/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.impl.fns;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;
import java.util.function.BinaryOperator;
import immutableexceptgas.occamsfuncer.Boot;
import immutableexceptgas.occamsfuncer.Cache;
import immutableexceptgas.occamsfuncer.Compiled;
import immutableexceptgas.occamsfuncer.Op;
import immutableexceptgas.occamsfuncer.fn;

public class Call implements fn{
	
	public final fn L, R;
	
	/** There are only 16 nontrivial ops,
	but everything up to depth4 is considered an op.
	The first op thats found from this.L().L().L()... is cached here.
	Example ops: s, t, f, cbt0, cbt1, curry, leaf, (leaf leaf).
	All of those have a Compiled, and thats what f(fn) uses.
	(curry k) may also have a Compiled even though curry has a Compiled.
	*/
	public final fn op;
	
	/** number of curries remaining until would do something nontrivial,
	or 0 if varargs and havent found the cbt to use as unary number for how many curries.
	*/
	public final int cur;
	
	public final int height;
	
	/** except if done by Boot, the Compiled must generate the same
	fns as if was called in interpreted mode, same id would be generated
	(if trigger lazyEval of id) for all possible id funcs
	since an id func describes a binary forest shape.
	Its allowed to differ when set by Boot cuz before that
	the behaviors arent the universal function and are empty
	waiting for up to depth4's behaviors to be defined
	which indirectly define the behaviors of all infinity possible
	fns that are combos of calling them on eachother.
	That same flexibility of Compiled is how things are optimized,
	such as MapPair will be optimized to use java stack
	instead of caching <func,param,return> in every treemap recursion,
	and after ieee754 float32 ops are defined, some combos of them
	will be optimized using lwjgl opencl through ForestOp.java
	The specific optimizations are not part of the occamsfuncer spec
	since they have no effect on ids.
	*/
	protected Compiled compiledOrNull;
	
	public Call(fn L, fn R){
		this.L = L;
		this.R = R;
		int h = Math.max(L.height(),R.height());
		//height()==Integer.MAX_VALUE means doesnt fit in int and use heightBig() instead.
		height = h==Integer.MAX_VALUE ? Integer.MAX_VALUE : h+1;
		op = height<5 ? this : L.op();
		//If L is Op.curry then next param is cbtAsUnary (or might redesign it as later param?)
		//The -4 is cuz Op.cbt1 is at height 4, and cbtAsUnary is exponential number of cbt1s.
		//That exponential number of them is at worst linear cost cuz of sharing branches,
		//and for small sizes that fit in a primitive is constant cost.
		//FIXME might be offBy1 etc in R.height()-...
		cur = L==curry ? R.height()-4 : L.cur()-1;
	}
	
	public fn f(fn param){
		fn ret = Cache.getRetOfFuncParamElseNull(this,param);
		if(ret != null) return ret;
		if(1 < cur){
			if(cur == 2){
				BinaryOperator<fn> constraint = op.compiled().constraintOrNull;
				if(constraint != null){ //null means Op.T which matches everything
					//Most calls dont have a constraint, but for example derived MapPair does.
					//Constraint never runs with less than 2 curries
					//and is always on the call up to the second last param,
					//and last param is unconstrained except by funcBody
					//which may be designed to infloop in some cases
					//which is the same as a constraint.
					//(this,param) is (this.L(),this.R()) when cur==1, in comment below.
					//Infloop if constraint fails, so Call that fails constraint never exists.
					//unless trusted code does cp(fn,fn) or Call constructor,
					//to create Call without checking if thats a valid thing to do,
					//which is why user level code cant do that,
					//and VM (TODO verify) should be designed not to.
					//FIXME If you get calls from an untrusted source,
					//make sure to run their constraint after running childs constraints
					//and so on recursively wherever it hasnt been verified.
					
					constraint.apply(this,param);
				}
			}
			ret = new Call(this,param);
			Cache.putLRParent(ret);
			return ret;
		}
		//If nonnnull (cuz null means constraint is Op.T which matches everything),
		//op.compiled().constraintOrNull.apply(this.L(),this.R()) was already run
		//and this Call only exists cuz it didnt infloop therefore constraint is true.
		//or FIXME I might have misaligned that as Op.curry uses lazyEval in constraints
		//but theres constraint inside that constraint as Op.curry's params
		//contain a fn to use as a constraint and a fn to use as a funcBody,
		//and this is a similar pattern but should not need the lazyEval.
		//FIXME verify all that fits together, else it will be detected in TestBasics.
		ret = op.compiled().funcBody.apply(this,param);
		//FIXME should this happen in op.compiled().apply instead?
		Cache.putFuncParamReturn(this, param, ret);
		return ret;
	}

	public boolean isLeaf(){
		return false;
	}

	public fn L(){
		return L;
	}

	public fn R(){
		return R;
	}

	public int cur(){
		throw new Error("TODO");
	}

	public fn curBig(){
		throw new Error("TODO");
	}

	public fn bh(int path){
		throw new Error("TODO");
	}

	public fn bhBig(fn path){
		throw new Error("TODO");
	}

	public fn id(fn algorithm){
		throw new Error("TODO");
	}

	public Compiled compiled(){
		return compiledOrNull;
	}
	
	public void setCompiled(BinaryOperator<fn> c){
		compiledOrNull = c;
	}

	public boolean isCbt(){
		throw new Error("TODO");
	}

	public boolean isBigCbt(){
		throw new Error("TODO");
	}

	public long longAt(int cbtBitIndex){
		throw new Error("TODO");
	}

	public long longAtBig(fn cbtBitIndex){
		throw new Error("TODO");
	}

	public int cbtSize(){
		throw new Error("TODO");
	}

	public fn cbtSizeBig(){
		throw new Error("TODO");
	}

	public boolean isBitstring(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}

	public int bitstringSize(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}

	public fn bitstringSizeBig(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}

	public int height(){
		return height;
	}

	public fn heightBig(){
		throw new Error("TODO");
	}
	
	public fn op(){
		return op;
	}

}
