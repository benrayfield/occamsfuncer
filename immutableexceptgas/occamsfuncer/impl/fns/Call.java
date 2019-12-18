/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.impl.fns;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.*;

import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncer.fn;
import immutableexceptgas.occamsfuncer.impl.util.Boot;
import immutableexceptgas.occamsfuncer.impl.util.Cache;
import immutableexceptgas.occamsfuncer.impl.util.Compiled;
import immutableexceptgas.occamsfuncer.impl.util.Op;
import immutableexceptgas.occamsfuncer.impl.util.TinyMap;

public class Call implements fn{
	
	public final fn myL, myR;
	
	/** There are only 16 nontrivial ops,
	but everything up to depth4 is considered an op.
	The first op thats found from this.L().L().L()... is cached here.
	Example ops: s, t, f, cbt0, cbt1, curry, leaf, (leaf leaf).
	All of those have a Compiled, and thats what f(fn) uses.
	(curry k) may also have a Compiled even though curry has a Compiled.
	*
	public final fn op;
	*/
	
	/** number of curries remaining until would do something nontrivial,
	or 0 if varargs and havent found the cbt to use as unary number for how many curries.
	*/
	public final int cur;
	
	public final int curHeight;
	
	public final int height;
	
	/** regardless of which javaclass represents it,
	a binary forest of calls is a cbt if it is cbt0 or cbt1
	or [if L() is a cbt and R() is a cbt].
	*/
	public final boolean isCbt;
	
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
	protected Compiled compiled;
	
	/** most fns never have an id as its lazyEval, but even if they
	are created later there is still instant global sync cuz derived from content.
	<br><br>
	TODO should this just use the Cache class? Would have to prevent
	garbcol of ids until the things they are ids of are gone, and what
	if theres a cycle such as cbt0.f(cbt1) is likely somewhere in its
	own id in many possible idFuncs generating it.
	*/
	protected TinyMap ids;
	
	//protected boolean fChecksConstraint;
	
	public Call(fn myL, fn myR){
		this.myL = myL;
		this.myR = myR;
		curHeight = myL.curHeight()+1;
		//int h = Math.max(myL.height(),myR.height());
		//height()==Integer.MAX_VALUE means doesnt fit in int and use heightBig() instead.
		//TODO optimize. use long for height? Or limit height?
		//height = h==Integer.MAX_VALUE ? Integer.MAX_VALUE : h+1;
		//boolean isBig = h==Integer.MAX_VALUE;
		height = Math.max(myL.height(),myR.height())+1;
		//if(height > MAX_HEIGHT) infLoop();
		if(height<0){
			//FIXME should isBig heights be allowed?
			infLoop(); //doesnt fit in int.
		}
		
		
		//TODO optimize by calculating cur a simpler way
		//by representing cur some way more similar to curHeight
		//and calculating the same result in cur() but int cur is the optimized way,
		//and name it something other than int cur if cur() doesnt return it directly.
		
		
		
		if(myL == curry){ //then height must be at least 5 cuz Op.curry height is 4
			//op = curry;
			compiled = curry.compiled();
			cur = cbtToNonnegInt(myR)-1; //subtract (TODO how much) cuz already (curry cbtAsUnary)
			isCbt = myL.isCbt() && myR.isCbt();
		}else if(height > 4){ //this happens most often
			//op = myL.op();
			compiled = myL.compiled();
			//cur = (op==cbt0 || op==cbt1) ? 1 : myL.cur()-1;
			cur = Math.max(myL.cur()-1, 1); //if (op==cbt0 || op==cbt1) cur is 1
			isCbt = myL.isCbt() && myR.isCbt() & myL.height()==myR.height();
			//FIXME should isBig heights be allowed? If so,
			//must check height as fn/bigint instead of just height() here.
			//if(isBig) throw new Error("TODO its expensive to cache isCbt when isBig aka height is Integer.MAX_VALUE. Maybe just shouldnt allow height bigger than that.");
		}else{ //height <= 4. Part of boot process.
			//If its 1 of the 16 in Op enum, get cur from there. Else cur is 1.
			//op = this;

			//compiledOrNull will be set in Boot but is null for now.
			//Its never ok to call a fn whose compiledOrNull is null.
			
			cur = Boot.bootCur(this);
			isCbt = Boot.bootIsCbt(this);
		}
		//lg("cur="+cur+" this="+this);
	}
	
	public fn f(fn param){
		$();
		if(cur == 0){
			return cp(this,param); //this is Op.curry. param is normally a cbtAsUnary
		}
		fn ret = Cache.getRetOfFuncParamElseNull(this,param);
		if(ret != null) return ret;
		if(1 < cur){
			if(cur == 2){
			//TODO may be optimizable with fChecksConstraint but only if done in op.compiled() instead of this.compiled()
			//if(fChecksConstraint){
				//BinaryOperator<fn> constraint = op.compiled().constraintOrNull;
				BinaryOperator<fn> constraint = compiled.get().constraintOrNull;
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
		ret = compiled.get().funcBody.apply(this,param);
		//FIXME should this happen in op.compiled().apply instead?
		Cache.putFuncParamReturn(this, param, ret);
		return ret;
	}
	
	public fn fIgnoreConstraint(fn param){
		throw new Error("TODO copy most of the code from f(fn) except the part that does constraint");
	}

	public boolean isLeaf(){
		return false;
	}

	public fn L(){
		return myL;
	}

	public fn R(){
		return myR;
	}
	
	public int curHeight(){
		return curHeight;
	}

	public int cur(){
		return cur;
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
		//TODO optimize? could make ids be an Object thats either the id
		//by a default id algorithm or a TinyMap if multiple.
		fn id;
		if(ids == null){
			ids = new TinyMap(algorithm, id = algorithm.f(this));
		}else{
			id = ids.get(algorithm);
			if(id == null) ids = ids.put(algorithm, id = algorithm.f(this));
		}
		return id;
	}

	public Compiled compiled(){
		return compiled;
	}
	
	public void setCompiled(Compiled c){
		if(cur != c.cur) throw new Error("cur differs. Its set in Op enum for 16 of the fns at height 4, and for all those at most height 4. this="+this+" Compiled="+c+" this.cur="+this.cur+" Compiled.cur="+c.cur);
		compiled = c;
		//FIXME this would only work if it happened here instead of in op.compiled()
		//fChecksConstraint = cur == 2 && c != null && c.constraintOrNull != null;
	}

	public boolean isCbt(){
		return isCbt;
	}

	public boolean isBigCbt(){
		return isCbt() && height()==Integer.MAX_VALUE;
	}

	/** You should probably use ArrayCbt and SmallCbt for efficient bitstrings,
	but as of 2019-11 those arent working.
	*/
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

	/*TODO implement optimization here and faster optimization in ArrayCbt and SmallCbt
	public boolean isBitstring(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}*/

	/** todo optimize
	public int bitstringSize(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}*/

	public fn bitstringSizeBig(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}

	public int height(){
		return height;
	}

	public fn heightBig(){
		throw new Error("TODO");
	}
	
	/*public fn op(){
		return op;
	}*/
	
	public String toString(){
		//if(L()==T) return "\\"+R(); //cuz of how common it is to prefix with T in S(...)
		String n = Boot.tempNames.get(this);
		if(n != null) return n;
		if(isCbt()){
			if(isUnaryCbt(this)){
				return "<unary"+(height-4)+">";
			}else if(isBitstring() && (bitstringSize()&7)==0){
				return "<mayBeStr:"+str(this)+">";
			}
		}
		//display as currylist such as (((a b)c)d) displays as (a b c d).
		String l = L().toString();
		if(l.startsWith("(") && l.endsWith(")")) l = l.substring(1,l.length()-1);
		return "("+l+R()+")";
	}

}
