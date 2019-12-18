/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;
import java.util.function.BinaryOperator;

/** Example: compile a certain fn that does ieee754 double multiply on
2 cbts of 64 bits each
(TODO bitstring cbt or without the trailing cbt1 and cbt0s?),
compile that to a BinaryOperator with cur=2
to use java strictfp double*double,
or a similar fn could do that in 1 cbt of 128 bits and 64 bits out.
*/
public class Compiled{
	
	public final int cur;
	
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

}