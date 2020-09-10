/** Ben F Rayfield offers this software opensource MIT license */
package occamsfuncer.impl.fn;
import java.util.Set;
import occamsfuncer.*;

public class NondetNode implements fn{
	
	/** lower on stack starts as nondeterministic. At some point it may choose to become deterministic,
	then eveything above that on the stack is forced to be deterministic until it returns back
	to that same point where it became deterministic, and this may repeat many times on the same stack.
	*/
	public final boolean isDeterministic;
	
	/** When pop, sum 2 of these into 1. When push, remove some of this (in a new node) and the new node has the part removed,
	minus a small amount to pay for the new object.
	NondetUtil.cost(CostType) says QUOTE current amount of NondetNode.addToGas it costs for 1 unit of CostType.
	This allows a single currency (which only works on this local computer, not a cryptocurrency, but maybe use Raiden network etc later)
	to be used for allocating multiple kinds of computer-related resources such as compute cycles, memory, and network bandwidth. UNQUOTE.
	*/
	public final long addToGas;
	
	/** null if this is top */
	public final NondetNode nondetStack;
	
	/** deterministic stack or return value from it, which may be used in a modified way by nondeterministic NondetNode
	or used deterministicly as the spec says to, such as backing out of it if it uses more compute resources
	than spend/wallet call allows. Its always true that only the op.nondet is modified bny NondetNode.
	op.nondet infloops (evals to (s i i (s i i))) in deterministic mode but may do anything in nondeterministic modde.
	*/
	public final fn detStack;
	
	public NondetNode(boolean isDeterministic, long addToGas, NondetNode nondetStack, fn detStack){
		this.isDeterministic = isDeterministic;
		this.addToGas = addToGas;
		this.nondetStack = nondetStack;
		this.detStack = detStack;
	}

	public fn f(fn param){
		throw new Error("TODO");
	}

	public fn e(){
		throw new Error("TODO");
	}

	public fn func(){
		throw new Error("TODO");
	}

	public fn param(){
		throw new Error("TODO");
	}

	public fn stack(){
		throw new Error("TODO");
	}

	public fn cacheKey(){
		throw new Error("TODO");
	}

	public boolean isLeaf(){
		throw new Error("TODO");
	}

	public boolean isHaltedAbove(){
		throw new Error("TODO");
	}

	public boolean isDone(){
		throw new Error("TODO");
	}

	public boolean isParentsFunc(){
		throw new Error("TODO");
	}

	public boolean isParentsParam(){
		throw new Error("TODO");
	}

	public void setCompiled(Compiled c){
		throw new UnsupportedOperationException("NondetNode probably shouldnt have Compiled??? Only Call etc should.");
	}

	public Compiled getCompiled() {
		throw new UnsupportedOperationException("NondetNode probably shouldnt have Compiled??? Only Call etc should.");
	}

	public DedupLevel dedupLevel(){
		return DedupLevel.allowAnyDup;
	}

	public fn setDedupLevel(DedupLevel d){
		throw new Error("TODO");
	}

	public Set<fn> twins(){
		throw new Error("TODO");
	}

	public Object unwrap(){
		throw new Error("TODO");
	}

	public long zigzag(){
		throw new Error("TODO");
	}

	public boolean isMeta(){
		throw new Error("TODO");
	}

	public boolean bitAt(long bitIndex){
		throw new Error("TODO");
	}

	public byte byteAt(long bitIndex){
		throw new Error("TODO");
	}

	public short shortAt(long bitIndex){
		throw new Error("TODO");
	}

	public char charAt(long bitIndex){
		throw new Error("TODO");
	}

	public int intAt(long bitIndex){
		throw new Error("TODO");
	}

	public long longAt(long bitIndex){
		throw new Error("TODO");
	}

	public float floatAt(long bitIndex){
		throw new Error("TODO");
	}

	public double doubleAt(long bitIndex){
		throw new Error("TODO");
	}

	public long bize(){
		throw new Error("TODO");
	}

	public boolean isCbt(){
		throw new Error("TODO");
	}

	public boolean isBitstring(){
		throw new Error("TODO");
	}

}