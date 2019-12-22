/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.S;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.f;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.p;

import java.util.function.BinaryOperator;

import mutable.util.Time;

/** Example: compile a certain fn that does ieee754 double multiply on
2 cbts of 64 bits each
(TODO bitstring cbt or without the trailing cbt1 and cbt0s?),
compile that to a BinaryOperator with cur=2
to use java strictfp double*double,
or a similar fn could do that in 1 cbt of 128 bits and 64 bits out.
*/
public class Compiled /*implements Comparable<Compiled>*/{
	
	/** what is this a compile of? This starts null cuz
	I'm only including it for finding bugs 2019-12. Might remove this.
	*/
	public fn func;
	
	public final int cur;
	
	/** Keep the Compiled with higher sort, usually cuz its faster.
	Renaming this from "sort" (as in comments below) to minCurHeight.
	<br><br>
	Compiled.backup should point at lower sort.
	The default Compileds at height0 to height1 all have sort 0.
	Example:
	curry.compiled().sort==0;
	Example.lazyEval() == f( ccc(), S(p(4),p(5),p(6)) );
	Example.lazyEval().compiled()==curry.compiled() at first
	but in Boot.optimize() is changed to another Compiled
	which has a higher sort.
	You could set the sort values to the param index,
	since for example curry.f(unary(3+params))
	could be optimized for that specific number of params,
	and then funcs that call curry and have that number of params
	would have their Compiled.backup point to that middle Compiled
	whose backup is curry.compiled()
	which is end of that linkedlist of Compileds.
	So maybe the standard should be fn.curHeight() of the min param
	it can be a Compiled at.
	f( ccc(), S(p(4),p(5),p(6)) ) aka f(curry,unary(6),T,S(p(4),p(5),p(6))),
	has curHeight of curry.curHeight()+3=7
	since there are 3 of the 6 params of that curry.
	There are 6 params of that curry cuz its first param is unary(6).
	curry.f(unary(6)).cur==5 cuz there are 5 more params of that curry.
	*
	public final int minCurHeight;
	//TODO enforce this in Boot.optimize where it tests Example.lazyEval,
	//and enforce this in setting Compiled.backup that the backup.minCurHeight<=this.minCurHeight.
	*/
	
	/** This is Time.timeId() when the Compiled was instantiated.
	A Compiled replaces another Compiled in the same sequence of params
	by always taking the highest (double)sort that can be seen below,
	but never replacing from higher param index to lower index.
	<br><br>
	timeIds are unique per computer, even across multiple JVM runs
	unless your clock changes backward farther than you wait to run the program again
	or if you run multiple JVMs at once (TODO check for that).
	But for Compiled we only need it to be unique within run of the JVM
	and to always increase so that the newest compatible Compiled is used
	in each sequence of params (if fn.updateCompiledCache() after such changes).
	<br><br>
	timeId might be used for other systems such as I've been thinking of
	making a database with only 1 table: <func,param,return,keepUntilAtLeast>
	where all 4 of those things are a timeId,
	and keepUntilAtLeast can be increased but not decreased
	and may have ordering constraints similar to if this represented
	a binary forest where func==L or func==R then keepUntilAtLeast
	would have to be at least as big as max of the childs keepUntilAtLeast,
	but that doesnt have to be true in <func,param,return> cuz
	there can be cycles such as ((S I I)(S I I)) evals to itself and never halts
	but you couldnt represent that as fn objects cuz they are ONLY halted states,
	but maybe the table should also have a bit for is it halted or not.
	and maybe also a second table <timeId,varSizeBinaryBlob>
	*/
	public final long timeId;
	
	/** A constraint is satisfied for a param if it halts (returns anything)
	when called on that param, and is called at fn.cur()-1
	compared to funcBody called at fn.cur(),
	so nothing that fails constraint is ever returned anywhere.
	It can only constrain the fn.cur()-1 size,
	where cur differs in different datastructs,
	but thats all you need for datastructs in general
	such as MapPair will be a derived datastruct
	whose constraint is a certain param (by getp)
	is the sum of the 2 childs' params of that same index
	which is the size,
	and that they ahve the same sortValueGenerator (instead of comparator,
	where sort values are compared by height then left then right),
	and it enforces key order in the treemap,
	and enforces that childs of mappair are either mappair or mapsingle.
	It doesnt need to know about mapempty but mapput and mapget etc do.96+
	Constraints dont cause map size to be in the mappair,
	but they motivate other code to do that else it wont return.
	<br>><br>
	If null then the constraint is Op.T which is always true so doesnt
	need to be calculated. A constraint is false when its param causes it to infloop.
	*/
	public final BinaryOperator<fn> constraintOrNull;
	
	public final BinaryOperator<fn> funcBody;
	
	/** gets the most optimized Compiled thats on, the one nearest in linkedlist.
	It might be off for testing.
	*/
	public Compiled get(){
		return on ? this : backup.get();
	}
	
	/** null if height <= 4.
	Use this.backup unless this.on,
	such as to test if a Compiled gets the same result
	(measured by fn.id(fn idFunc) for any idFunc)
	regardless of which combo of optimizations compute it. 
	<br><br>
	Thats a homomorphic property
	but is not homomorphic crypto cuz all idFuncs do
	is generate an id for a param binary forest shape
	and you would still know the binary forest shape.
	This is a general computer so could compute any
	possible kind of crypto but starts with only
	all possible binary forest shapes up to height 4 (leaf is 0)
	which are needed to define its turingComplete behaviors.
	<br><br>
	There is no backup for Compiled at heights 0..4
	since those are needed to define the turingCompleteness,
	but optimizations of optimizations... of optimizations,
	such as MapPair's Compiled will be derived in part
	from the Compileds of long or double math (havent decided yet)
	which are ops on cbts representing those longs or doubles
	which are Compileds derived from the Compileds at height 4
	which are the core ops, but not necessarily always
	automatically compiled as Humans can write trusted code
	into the VM (unlike the untrusted code at user level)
	to manually optimize certain binary forest shapes,
	which I plan to partially do for MapPair
	in combo with the automatic use of Compileds
	for longs or doubles to count the size.
	Before any fn can be compiled it must either be defined
	in terms of existing fns (formal verified)
	or be part of Op.nondet which in pure determinism mode
	always infloops to pretend its just very very slow
	so is still technically the same lambda behaviors
	but infinitely inefficient.
	The same lambda behaviors means that there is at most
	1 return value for each pair of func and param,
	so if it returns sometimes and infloops other times,
	it hasnt broken that rule.
	<br><br>
	This system guarantees that all calls either halt
	or end early by throwing Gas
	(caught at innermost Op.nondet Spend call),
	given the amount of compute resources
	allocated to that call, and guarantees that
	each next deeper call can further reduce the
	available compute resources between what it has
	and 0, and that even if that happens in EVERY CALL
	it does not significantly slow things down
	as it has a constant cost per resource limit.
	BUT this system makes no guarantees of if any particular
	calculation will halt within that resource limit
	even if it halted within that limit in an earlier call.
	This is cuz different optimizations may be found
	at runtime, in theory. 
	*/
	public final Compiled backup;
	
	protected boolean on = true;
	
	public Compiled(int cur, BinaryOperator<fn> constraintOrNull, BinaryOperator<fn> funcBody, Compiled backup){
		this.cur = cur;
		this.timeId = Time.timeId();
		this.constraintOrNull = constraintOrNull;
		this.funcBody = funcBody;
		this.backup = backup;
		if(backup != null && backup.cur != 0 && backup.cur != cur) {
			
			//If backup.cur==0 then its for Op.curry
			//Should still check the depth of L().L().L()... until Op.curry
			//but dont have access to the fn here,
			//so TODO check for that error later.
			//There will be no error if the Compiled is designed right.
			
			//since Op.curry has cur 0, An effect of that is fixable by makiung
			//the Compiled of calls of curry such as Example.lazyEval() curries 3
			//after funcBody (curry unary(6) T funcBody x y z) so
			//Boot.optimize() would setCompiled in
			//(curry unary(6) T funcBody) to a Compiled that has cur 3 instead of cur 0,
			//but how would it know to do that? The wrong way to pass tests
			//(TODO add tests that fail for that)
			//would be that Compiled of Example.lazyEval() has cur 0,
			//or maybe it wouldnt work since it wouldnt choose to run when it gets
			//3 more curries. The right way would be to check for cur==0
			//to handle the vararg case.
			
			
			
			throw new Error("Diff cur in this="+this+" ("+this.cur+") bk="+backup+" ("+backup.cur+")");
		}
	}
	
	public void setOn(boolean on){
		if(!on && backup == null) throw new Error("Cant turn off the innermost Compiled");
		this.on = on;
	}
	
	/** FIXME equals by == and compareTo by minCurHeight might be
	inconsistent with Comparable spec. If it is, dont use it.
	*
	public boolean equals(Object obj){
		return this == obj;
	}

	public int compareTo(Compiled c){
		return minCurHeight-c.minCurHeight;
	}*/

}