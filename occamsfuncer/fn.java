/** Ben F Rayfield offers this software opensource MIT license */
package occamsfuncer;
import java.util.function.UnaryOperator;

/** This is the core object type in occamsfuncer. Using the lambda symbol (λ) cuz
its a universal lambda function and pattern calculus function. (renamed from fn.java)
Theres an immutable layer of all possible functions, with an optional mutable/NondetNode layer above them for efficiency.
Only the immutable functions are shared on internet cuz they never have errors nor state to sync.
This is a function or snapshot of stack state during eval. Stack state costs bigO(1) per step. Data is made of functions,
such as complete binary tree of pairs of T or F padded with T then 0 or more F up to next powOf2, is a bitstring.
T is the lambda Lx.Ly.x, and F is the lambda Lx.Ly.y.
All functions are made of combos of the universal function aka leaf, which has 15 params, described in occamsfuncerSpec.txt.
Can wrap arrays in a function, such as double[] int[] FloatBuffer for efficiency.
Wrapped objects must still have usable L(), R(), and lambda functions,
plus in some cases they can be used in combo with other optimizations directly as arrays.
Wrapped objects normally use lazy dedup, but if you get an id on them (from any idMaker func) everything dedups exactly,
such as happens when used as a map key.
*/
public interface fn extends UnaryOperator<fn>{
//public interface fn<FuncType extends fn<FuncType>> extends UnaryOperator<FuncType>{
	
	/*(func param stack cacheKey isHalted isParentsFunc isParentsParam isCacheKeyNull)
	see Node in spec comment about these 8 necessary childs for step func to be bigO(1).
	*/
	
	/** lazy lambda call */
	public fn f(fn param);
	
	/** nonlazy lambda call. WARNING: may never halt. Use wallet and spend ops to limit compute resources. */
	public default fn e(fn param){
		return f(param).e();
	}
	
	/** eval this, without modifying this. If this is already evaled, returns this. */
	public fn e();
	
	/** WARNING: may never halt. Use wallet and spend ops to limit compute resources. */
	public default fn apply(fn param){
		return e(param);
	}
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn func();
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn param();
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn stack();
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn cacheKey();
	
	public boolean isLeaf();
	
	/** is about to return from above (on stack) or is such a return value, ignoring what may be left to do lower on stack */
	public boolean isHaltedAbove();
	
	/** isHaltedAbove and nothing below in stack left to do */
	public boolean isDone();
	
	/** isParentsFunc. If true, stack().func()==this. If false, nothing about that is implied. */
	public boolean isParentsFunc();
	
	/** isParentsParam. If true, stack().param()==this. If false, nothing about that is implied. */
	public boolean isParentsParam();
	
	public void setCompiled(Compiled c);
	
	public Compiled getCompiled();
	
	public static interface Compiled{
		//TODO generalize this to Uedge as gameweb/gametree instead of just Uedge.eval.
		//use Biedge for that. Also see OcSync.
		
		/** param is normally not halted, and whats returned is always halted.
		This might wrap a UnaryOperator<fn> similar to how ocfn2's Compiled wrapped a BinaryOperator<fn>.
		*/
		public fn eval(fn lazy);
		
		public boolean setOn(boolean on);
		
		public boolean on();
		
		/** linkedlist of Compiled. Whichever first in that list is on() is used.
		By turning some off, you can test without those optimizations, such as to verify the compiled form has the exact same behaviors to bit precision.
		If prev is null, then on() is always true.
		*/
		public Compiled prevOrNull();
	}

}
