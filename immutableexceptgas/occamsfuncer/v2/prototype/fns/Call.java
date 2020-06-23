/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.v2.prototype.fns;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;

import immutableexceptgas.occamsfuncer.v2.prototype.util.Boot;
import immutableexceptgas.occamsfuncer.v2.prototype.util.Cache;
import immutableexceptgas.occamsfuncer.v2.prototype.util.Example;
import immutableexceptgas.occamsfuncer.v2.prototype.util.TinyMap;
import immutableexceptgas.occamsfuncer.v2.spec.Compiled;
import immutableexceptgas.occamsfuncer.v2.spec.Op;
import immutableexceptgas.occamsfuncer.v2.spec.fn;

public class Call extends AbstractFn{
			
			
			
	//TODO long keepUntilAtLeast (utc nanoseconds as in Time.nowNano())
	//as way to organize garbcol in large p2p net in realtime,
	//but for now make it do interesting things on 1 computer.
	//Same use of long as in Compiled.timeId.
	
	/** myComment doesnt need to be stored in datastructs except a single bit if its leaf.
	myCommentElseLeaf is leaf when height()<5 so it doesnt interfere with ops.
	*/
	public final fn myL, myR, myCommentElseLeaf;
	
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
	
	/** If isCbt and height()<=maxHeightToUse_last1 (66)
	then this is index of the last cbt1.
	If height is 4 and isCbt then this is cbt0 or cbt1 (cbt size 1).
	If height is 67 then cbt size is 2^63,
	and if the last bit is 1 then last1 = 2^63-1.
	A cbt is not required to have any 1, but if it does
	then it can be interpreted as a cbtBitstring which is all the bits
	until that last 1.
	<br><br>
	If !isCbt or there is no 1, then this is -1.
	if isCbt but height is bigger than that, then last1 = -2;
	*/
	public final long last1;
	
	/** regardless of which javaclass represents it,
	a binary forest of calls is a cbt if it is cbt0 or cbt1
	or [if L() is a cbt and R() is a cbt].
	*/
	public final boolean isCbt;
	
	/** true if isCbt and contains a cbt1, even if !bitstringSizeFitsInLong() */
	public final boolean isBitstring;
	
	public final boolean isUnaryCbt;
	
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
		this(myL, myR, leaf);
	}
	
	public Call(fn myL, fn myR, fn myCommentElseLeaf){
		this.myL = myL;
		this.myR = myR;
		this.myCommentElseLeaf = myCommentElseLeaf;
		curHeight = myL.curHeight()+1;
		//int h = Math.max(myL.height(),myR.height());
		//height()==Integer.MAX_VALUE means doesnt fit in int and use heightBig() instead.
		//TODO optimize. use long for height? Or limit height?
		//height = h==Integer.MAX_VALUE ? Integer.MAX_VALUE : h+1;
		//boolean isBig = h==Integer.MAX_VALUE;
		height = Math.max(Math.max(myL.height(),myR.height()),myCommentElseLeaf.height())+1;
		//if(height > MAX_HEIGHT) infLoop();
		if(height<0){
			//FIXME should isBig heights be allowed?
			infLoop(); //doesnt fit in int.
		}
		
		
		//TODO optimize by calculating cur a simpler way
		//by representing cur some way more similar to curHeight
		//and calculating the same result in cur() but int cur is the optimized way,
		//and name it something other than int cur if cur() doesnt return it directly.
		
		
		//FIXME these comments need updating cuz they are from V1
		if(myL == curry){ //then height must be at least 5 cuz Op.curry height is 4
			//op = curry;
			compiled = curry.compiled();
			cur = cbtToNonnegInt(myR)-1; //subtract (TODO how much) cuz already (curry cbtAsUnary)
			isCbt = myL.isCbt() && myR.isCbt();
			isUnaryCbt = false;
			last1 = last1_notCbtBitstring; //cuz !isCbt
			isBitstring = false;
		}else if(height > 4){ //this happens most often
			//op = myL.op();
			compiled = myL.compiled();
			//cur = (op==cbt0 || op==cbt1) ? 1 : myL.cur()-1;
			cur = Math.max(myL.cur()-1, 1); //if (op==cbt0 || op==cbt1) cur is 1
			isCbt = myL.isCbt() && myR.isCbt() & myL.height()==myR.height();
			//FIXME should isBig heights be allowed? If so,
			//must check height as fn/bigint instead of just height() here.
			//if(isBig) throw new Error("TODO its expensive to cache isCbt when isBig aka height is Integer.MAX_VALUE. Maybe just shouldnt allow height bigger than that.");
			isUnaryCbt = myL.isUnaryCbt() & myR.isUnaryCbt() && myL.height()==myR.height();
			if(isCbt){
				if(height <= maxHeightToUse_last1){
					long rs = myR.bitstringSize();
					if(rs >= 0){ //not last1_notCbtBitstring or last1_bigCbtBitstring
						//long cbtSize = 1L<<(height-4);
						long leftCbtSize = 1L<<(height-5);
						last1 = leftCbtSize+rs;
					}else{
						last1 = myL.bitstringSize();
					}
				}else{
					last1 = last1_notCbtBitstring;
				}
			}else{
				last1 = last1_notCbtBitstring;
			}
			isBitstring = last1 != last1_notCbtBitstring;
		}else{ //height <= 4. Part of boot process.
			//If its 1 of the 16 in Op enum, get cur from there. Else cur is 1.
			//op = this;

			//compiledOrNull will be set in Boot but is null for now.
			//Its never ok to call a fn whose compiledOrNull is null.
			
			cur = Boot.bootCur(this);
			isCbt = Boot.bootIsCbt(this);
			isUnaryCbt = Boot.bootIsOp(this, Op.cbt1);
			last1 = isCbt ? (isUnaryCbt?0:last1_notCbtBitstring) : last1_notCbtBitstring;
			isBitstring = last1==0;
		}
		if(cur == -1){
			throw new Error("cur");
		}
		//lg("cur="+cur+" this="+this);
	}
	
	public fn f(fn param){
		$();
		if(cur == 0){
			return cp(this,param); //this is Op.curry. param is normally a cbtAsUnary
		}
		fn ret = Cache.getRetOfFuncParamCommentElseNull(this,param,leaf);
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
		Cache.putFuncParamCommentReturn(this, param, leaf, ret);
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
	
	public fn comment(){
		return myCommentElseLeaf;
	}
	
	public fn COMMENT(fn newComment){
		//cant have comment below height 5 cuz interferes with ops.
		if(myCommentElseLeaf == newComment || height() < 5) return this;
		return cp(myL, myR, newComment);
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
		if(height() <= 4){
			if(cur != c.cur){
				throw new Error("In op or below. cur differs. Its set in Op enum for 16 of the fns at height 4, and for all those at most height 4. this="+this+" Compiled="+c+" this.cur="+this.cur+" Compiled.cur="+c.cur);
			}
		}else{
			fn op = this;
			while(op.height() != 4) op = op.L();
			if(op == curry){
				lg("FIXME throw if cur not match");
			}else{
				if(op.cur() != c.cur){
					throw new Error("In params of op other than curry. cur differs. Its set in Op enum for 16 of the fns at height 4, and for all those at most height 4. this="+this+" Compiled="+c+" this.cur="+this.cur+" Compiled.cur="+c.cur);
				}
			}
		}
		compiled = c;
		
		//OLD?...
		//FIXME this would only work if it happened here instead of in op.compiled()
		//fChecksConstraint = cur == 2 && c != null && c.constraintOrNull != null;
	}

	public boolean isCbt(){
		return isCbt;
	}

	public boolean isBigCbt(){
		return isCbt() && height()==Integer.MAX_VALUE;
	}
	
	public boolean isUnaryCbt(){
		return isUnaryCbt;
	}

	public long longAtBig(fn cbtBitIndex){
		throw new Error("TODO");
	}

	public long cbtSize(){
		if(!isCbt()) return 0;
		return 1<<(height()-4);
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
	
	public long bitstringSize(){
		return last1;
	}

	public fn bitstringSizeBig(){
		throw new Error("TODO should probably have separate class for cbt and not allow Call to be a small cbt but can be any cbt that has small cbts as childs");
	}
	
	public boolean isBitstring(){
		if(bitstringSizeFitsInLong()){ //fast
			return last1 >= 0;
		}else{ //slow
			return super.isBitstring();
		}
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
		//check Example.stringPrefixHasBeenCalled() to avoid infloop
		//FIXME why would that infloop?
		if(Example.stringPrefixHasBeenCalled() && L()==Example.stringPrefix()){
			//TODO display in quotes with string escapes
			if(R().isBitstring() && (R().bitstringSize()&7)==0){
				return "<str:"+toRawString(R())+">";
			}
		}
		if(isCbt()){
			if(isUnaryCbt()){
				return "<unary"+(height-4)+">";
			}else if(isBitstring() && (bitstringSize()&7)==0){
				return "<mayBeStr:"+toRawString(this)+">";
			}
		}
		if(myCommentElseLeaf == leaf){
			//display as currylist such as (((a b)c)d) displays as (a b c d).
			String l = L().toString();
			if(l.startsWith("(") && l.endsWith(")")) l = l.substring(1,l.length()-1);
			String ret = "("+l+R()+")";
			/*if(!ret.contains("\t")){
				ret = indentPseudocode(ret);
			}*/
			return ret;
		}else{
			return "{"+L()+","+R()+","+comment()+"}";
		}
	}
	
	/*public static String toString(fn x, int tabLevel){
		//if(L()==T) return "\\"+R(); //cuz of how common it is to prefix with T in S(...)
		String n = Boot.tempNames.get(x);
		if(n != null) return n;
		if(x.isCbt()){
			if(isUnaryCbt(x)){
				return "<unary"+(x.height()-4)+">";
			}else if(x.isBitstring() && (x.bitstringSize()&7)==0){
				return "<mayBeStr:"+str(x)+">";
			}
		}
		//display as currylist such as (((a b)c)d) displays as (a b c d).
		//String l = x.L().toString();
		String l = toString(x.L(), tabLevel+1);
		if(l.startsWith("(") && l.endsWith(")")) l = l.substring(1,l.length()-1);
		return "("+l+x.R()+")";
	}*/
	
	/** as of 2020-1-15 this doesnt indent correctly, didnt finish this code. */
	public static String indentPseudocode(String s){
		StringBuilder sb = new StringBuilder();
		int tabLevel = 0;
		boolean inAngleBrackets = false;
		IntConsumer indentLine = (int tabs)->{
			sb.append("\n");
			for(int i=0; i<tabs; i++) sb.append('\t');
		};
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(!inAngleBrackets && c == '('){
				indentLine.accept(tabLevel++);
				sb.append(c);
			}else if(!inAngleBrackets && c == ')'){
				indentLine.accept(--tabLevel);
				sb.append(c);
				//indentLine.accept(--tabLevel);
			}else if(c == '<'){
				if(inAngleBrackets) throw new Error("TODO < ... < ... > ... > s="+s);
				//FIXME this might not handle string literal syntax
				inAngleBrackets = true;
				indentLine.accept(tabLevel);
				sb.append(c);
			}else if(c == '>'){
				if(!inAngleBrackets) throw new Error("> while not in <...>. s="+s);
				inAngleBrackets = false;
				indentLine.accept(tabLevel);
				sb.append(c);
			}else{
				indentLine.accept(tabLevel);
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public boolean equals(Object o){
		if(!(o instanceof fn)) return false;
		fn O = (fn)o;
		//TODO optimize this in Example.equals().compiled() instead of here
		if(this == o) return true;
		if(height() != O.height()) return false;
		return Example.equals().f(this).f(o)==T;
	}
	
	public int intAt(int cbtBitIndex){
		int ret = 0;
		for(int i=0; i<32; i++){
			if(bitAt(cbtBitIndex+i)) ret |= (1<<(31-i));
		}
		return ret;
	}
	
	public boolean bitAt(int cbtBitIndex){
		if(!isCbt()) return false;
		long cbtSize = cbtSize();
		if(cbtBitIndex < 0 || cbtSize <= cbtBitIndex) return false;
		if(cbtSize == 1) return this==cbt1;
		if(cbtBitIndex < (cbtSize>>1)) return L().bitAt(cbtBitIndex);
		return R().bitAt(cbtBitIndex-(cbtSize>>1));
	}

}
