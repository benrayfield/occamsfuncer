/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.ImportStatic.S;
import static immutableexceptgas.occamsfuncer.ImportStatic.T;
import static immutableexceptgas.occamsfuncer.ImportStatic.curry;
import static immutableexceptgas.occamsfuncer.ImportStatic.getp;
import static immutableexceptgas.occamsfuncer.ImportStatic.t;

import java.util.Arrays;

import immutableexceptgas.occamsfuncer.impl.fns.Call;
import immutableexceptgas.occamsfuncer.impl.fns.Leaf;

public class ImportStatic{
	private ImportStatic(){}
	
	public static final fn leaf = Leaf.instance;
	
	
	/////
	
	public static final fn cbt0 = Boot.op(Op.cbt0.ordinal());
	
	public static final fn cbt1 = Boot.op(Op.cbt1.ordinal());
	
	public static final fn R = Boot.op(Op.R.ordinal());
	
	public static final fn L = Boot.op(Op.L.ordinal());
	
	/////
	
	public static final fn F = Boot.op(Op.F.ordinal());
	
	public static final fn T = Boot.op(Op.T.ordinal());
	
	public static final fn I = Boot.op(Op.I.ordinal());
	
	public static final fn S = Boot.op(Op.S.ordinal());
	
	/////
	
	public static final fn isLeaf = Boot.op(Op.isLeaf.ordinal());
	
	public static final fn pair = Boot.op(Op.pair.ordinal());
	
	public static final fn bh = Boot.op(Op.bh.ordinal());
	
	public static final fn lazyEval = Boot.op(Op.lazyEval.ordinal());
	
	/////
	
	public static final fn curry = Boot.op(Op.curry.ordinal());
	
	public static final fn getp = Boot.op(Op.getp.ordinal());
	
	public static final fn recur = Boot.op(Op.recur.ordinal());
	
	public static final fn nondet = Boot.op(Op.nondet.ordinal());
	
	
	
	/** FIXME move this to mutable package */
	public static void lg(String line){
		System.out.println(line);
	}
	
	/** FIXME move this to mutable package */
	public static void lgErr(String line){
		System.err.println(line);
	}
	
	/*public static fn dedup(fn f){
		return Cache.dedup(f);
	}
	
	public static fn dedup(fn itsL, fn itsR){
		return Cache.dedup(itsL, itsR);
	}*/
	
	/** WARNING: using this where itsL.f(itsR) would have done something other than
	create a call pair, breaks the system.
	<br><br>
	Wreate Call Pair without checking if it would execute, but do still dedup.
	*/
	public static fn cp(fn itsL, fn itsR){
		fn f = Cache.getRetOfFuncParamElseNull(itsL,itsR);
		if(f == null) Cache.putLRParent(f = new Call(itsL, itsR));
		return f;
	}
	
	/** optimization of $(1) */
	public static void $() throws Gas{
		double newTopGas = Gas.top-1;
		if(newTopGas < 0) throw Gas.instance();
		Gas.top = newTopGas;
	}
	
	public static void $(double spend) throws Gas{
		double newTopGas = Gas.top-spend;
		if(newTopGas < 0) throw Gas.instance();
		Gas.top = newTopGas;
	}
	
	public static fn infLoop() throws Gas{
		throw Gas.instance();
	}
	
	/** Explained in comments in the switch statement for Op.getParam in Boot.
	For efficiency does not add to Cache or call Op.getp.
	This is called in the implementation of Op.getp and Op.curry.
	*/
	public static fn getParam(int whichParam, fn thingNormallyMadeByCurry){
		if(whichParam == 0) return curry;
		return getNthCurry(whichParam,thingNormallyMadeByCurry).R();
	}
	
	/** getNthCurry(whichParam).R()==getParam(whichParam) except
	when whichParam==0 which is the curry op itself.
	You use this when you want to get multiple adjacent params efficiently.
	Cant use this to get the last param cuz fn.cur() cant be 0
	cuz every fn is a halted state, and thats why lazyEval is used,
	but if its a lazyEval its not exactly a curry as it was originally done
	cuz (this) getNthCurry is only used on curries of Op.curry.
	*/
	public static fn getNthCurry(int n, fn thingNormallyMadeByCurry){
		//TODO? optimize by Call.java caching depth since leftmost curry,
		//which is a separate int than Call.cur.
		if(n == 3){
			//this is the only case I'm using so far:
			//(curry cbtAsUnary constraint funcBody)
			
			//Get itsL in thingNormallyMadeByCurry=(lazyEval itsL itsR).
			fn x = thingNormallyMadeByCurry.L().R();
			while(x.L().L().L() != curry){ //TODO optimize by using fn.bh(int)
				x = x.L();
			}
			return x;
		}
		throw new Error("TODO");
	}
	
	public static fn nonnegIntToUnaryCbt(int nonnegInt){
		if(nonnegInt < 0) throw new Error("is neg: "+nonnegInt);
		//TODO optimize cuz cbt is wrapper of bitstring and
		//for example 1..64 cbt1s fits in a primitive like SmallCbt.java
		//and thats unary 0 to unary 6, and there are also bigger cbts,
		//so dont have to create the pairs this way...
		//(will be same id either way, for all possible id funcs).
		fn x = cbt1;
		while(nonnegInt-- > 0) x = x.f(x);
		return x;
	}
	
	/** cbt1 gives 0. (cbt1 cbt1) gives 1. ((cbt1 cbt1)(cbt1 cbt1)) gives 2. And so on. */
	public static int cbtToNonnegInt(fn cbt){
		if(cbt.isBigCbt()) throw new Error("TODO");
		return cbt.height()-4;
	}
	
	public static final int standardParamsOfCurry = 3;
	
	public static fn paramIndex(int nonnegInt){
		return nonnegIntToUnaryCbt(standardParamsOfCurry+nonnegInt);
	}
	
	/** a shortcut for Op.getp currying the first 2 params except
	the second param is a nonnegInt translated to cbt as unary.
	*/
	public static fn getpCommentNonnegint(Object comment, int paramIndex){
		return getp.f(comment).f(nonnegIntToUnaryCbt(paramIndex));
	}
	
	/** wrap. If its primitive array, loses the type and dim sizes but keeps the bits. */
	public static fn f(Object ob){
		if(ob instanceof fn) return (fn)ob;
		throw new Error("TODO if prim array wrap in cbt");
	}
	
	public static fn f(Object... obs){
		if(obs.length == 1) return f(obs[0]);
		fn x = f(obs[0]).f(obs[1]);
		for(int i=2; i<obs.length; i++){
			x = x.f(obs[i]);
		}
		return x;
	}
	
	/** This is 1 s-lambda-level above f(...).
	f(S(a b c) p) returns ((a p)(b p)(c p)).
	Example: f(S(t(T), t(getp), t(curry)) anything)==getp
	Example: f(S(t(F), t(getp), t(curry)) anything)==curry
	//TODO rename to s(...)
	(lowercase s, and maybe also do that for Op.S becomes Op.s etc).
	*/
	public static fn S(Object... obs){
		if(obs.length == 0) throw new Error(
			"TODO what should this return if obs.length is 0 or should that be allowed at all?");
		fn x = f(obs[0]);
		if(obs.length == 1) return x; //f(S(x) p) returns (x p) so return x?
		for(int i=1; i<obs.length; i++){
			x = S.f(x).f(obs[i]);
		}
		lg("S( "+Arrays.asList(obs)+" ) returning "+x);
		return x;
	}
	
	/* l(...) is a literal linkedlist. L(...) is 1 s-lambda-level higher
	as f(L(a b c) p) returns l((a p)(b p)(c p)).
	TODO? might want to rename that since Op.L means leftChild, not linkedList.
	*/
	public static fn L(Object... obs){
		throw new Error("TODO");
	}
	
	/** see comment in L(...) */
	public static fn l(Object... obs){
		throw new Error("TODO");
		/*TODO loop in reverse.
		TODO use Example.cons and Example.nil or use Op.pair and Op.T and Op.F?
		Example.cons will likely be a func that calls Op.pair
		but reorders params first.
		*/
	}
	
	/** convenience func for T.f(param) */
	public static fn t(fn param){
		return T.f(param);
	}
	
	private static fn recurse;
	/** given a thingNormallyMadeByCurry as its only param (get it by Op.I),
	returns Op.curry with its first few params up to a funcBody
	but without any params after funcBody.
	*/
	public static fn recurse(){
		if(recurse == null){
			recurse = null; //FIXME
			//recurse = getNthCurry(standardParamsOfCurry, thingNormallyMadeByCurry);
			//FIXME i want that call except with Op.I getting the thingNormallyMadeByCurry
		}
		return recurse;
	}
	
	static{
		Boot.boot();
		lg("Occamsfuncer booted.");
	}
}
