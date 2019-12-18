/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.impl.util;
import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncer.fn;

/** Example: compile a certain fn that does ieee754 double multiply on
2 cbts of 64 bits each
(TODO bitstring cbt or without the trailing cbt1 and cbt0s?),
compile that to a BinaryOperator with cur=2
to use java strictfp double*double,
or a similar fn could do that in 1 cbt of 128 bits and 64 bits out.
*/
public class Compiled{
	
	public final int cur;
	
	/** If null then the constraint is Op.T which is always true so doesnt
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
		if(backup != null && cur != backup.cur) throw new Error("Diff cur in this="+this+" bk="+backup);
	}
	
	public void setOn(boolean on){
		if(!on && backup == null) throw new Error("Cant turn off the innermost Compiled");
	}

}