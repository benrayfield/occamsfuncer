/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.v3.spec;

/** immutable and deterministic. Everything is calls of a certain universal function
(which is similar to a universal lambda function and is a kind of pattern calculus):
(universalFunc deterministic? comment funcIfBigElseLeaf bit bit bit param param param).
This can in theory be GPU optimized as well as any other system for gridlike calculations
but cant perform nearly as well on CPU as other systems cuz it has unusual caching needs when jumping in memory.
*/
public interface fn{
	
	//Do I want to only include param() and func() in hash when stack is null? Might also include afterEval() in hash if its nonnull?
	
	
	/** 1 of 4 required pointers in the core datastruct */
	public fn func();
	
	/** 1 of 4 required pointers in the core datastruct */
	public fn param();
	
	/** 1 of 4 required pointers in the core datastruct */
	public fn stack();
	
	/** 1 of 4 required pointers in the core datastruct */
	public fn cacheKey();
	
	/** optional pointer (beyond "1 of 3 required pointers in the core datastruct"), a scheduled thing to do after eval finishes, so can call an stack on a stack to get a stack as in lambda funcs *
	public fn after();
	
	/** optional pointer (beyond "1 of 3 required pointers in the core datastruct"), nondetResponse *
	public fn in();
	*/
	
	/** lazy call func on func to get func, like in lambdaCalculus or patternCalculus. If this is view at bottom of stack, this is bigO(1),
	or if using optional param after() then its always bigO(1),
	else loops to get a view at bottom of stack while leaving everything above as lazys then adds this call as new stack bottom. */
	public default fn f(fn param){
		throw new Error("TODO something like return cp(null,stackBottom(),param);"); 
	}
	
	/** Call func on func to get func, like in lambdaCalculus or patternCalculus. Same as f(fn) but not lazyEval. WARNING: may never halt. */
	public default fn F(fn param){
		return f(param).eval();
	}
	
	public fn step();
	
	/** must check isHalted after this returns, in case it needed more steps */
	public default fn step(long maxSteps){
		fn x = this;
		while(--maxSteps > 0 && !x.isHalted() /*&& !Thread.interrupted()*/) x = x.step();
		return x;
	}
	
	/*FIXME counting steps seems pointless when there will be Compiled optimizations,
	but still need at least an APPROXIMATE counting of optimized cost and a GUARANTEE of that maximum number of unoptimized steps.
	
	Maybe need a nondeterministicNumberOfSteps(double approxCostLimit) func, more like whats in ocfn2,
	and where Compiled exist, it has a number of steps it costs to check the dynamic cost,
	which it charges right away, then it charges the dynamic cost if theres enough?
	*/
	
	public default fn eval(){
		fn x = this;
		while(!x.isHalted() /*&& !Thread.interrupted()*/) x = x.step();
		return x;
	}
	
	/** throw unless isHalted. Example: x.f(y).step(50000).h().f(z) never calls it on z if x.f(y) took more than 50000 steps to halt. *
	public default fn h(){}*/
	
	public default fn stackBottom(){
		fn s = this;
		while(s.stack() != null) s = s.stack();
		return s;
	}
	
	/** used in an optimization that doesnt store (pair funcsParam) in ((pair funcsParam) param) but does store funcsParam and param,
	which allows a completeBinaryTree (such as of bits in a bitstring or any objects) to be stored in an array without the pairs until observe them.
	*/
	public default fn funcsParam(){ return func().param(); }
	
	public Compiled compiled();
	
	public void setCompiled(Compiled c);
	
	public boolean isLeaf();
	
	public boolean isHalted();
	
	public boolean isCbt();
	
	/** If isParentsParam then stack().func().equals(this) regardless of if stack().param().equals(this) */
	public boolean isParentsFunc();
	
	/** If isParentsParam then stack().param().equals(this) regardless of if stack().func().equals(this) */
	public boolean isParentsParam();
	
	/** long starting at bit index, if this is a cbt. */ 
	public long j(long bitIndex);
	
	public default int i(long bitIndex){
		return (int)(j(bitIndex)>>>32);
	}
	
	public default short s(long bitIndex){
		return (short)(j(bitIndex)>>>48);
	}
	
	public default char c(long bitIndex){
		return (char)(j(bitIndex)>>>48);
	}
	
	public default double d(long bitIndex){
		return Double.longBitsToDouble(j(bitIndex));
	}
	
	public default float f(long bitIndex){
		return Float.intBitsToFloat(i(bitIndex));
	}
	
	/** bitstring size else negative (TODO which codes, such as size doesnt fit in long, only storing lowest 48 bits bitstring size, etc).
	FIXME what should this return if bitstring size (in bits) doesnt fit in long, or if only up to uint48 size is cached?
	*/ 
	public long bize();
	
	/*TODO optimization where if pair is my left/func (or up to depth 15 of that, using 4 bits in id),
	then id is same other than those 4 bits,
	But how does that work with having stack ptr too?
	*/

}
