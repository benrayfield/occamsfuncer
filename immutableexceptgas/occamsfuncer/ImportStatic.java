/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;

import immutableexceptgas.occamsfuncer.impl.fns.Call;
import immutableexceptgas.occamsfuncer.impl.fns.Leaf;

public class ImportStatic{
	private ImportStatic(){}
	
	public static final fn leaf = Leaf.instance;
	
	public static final fn cbt0 = Boot.op(Op.cbt0.ordinal());
	
	public static final fn cbt1 = Boot.op(Op.cbt1.ordinal());
	
	public static final fn L = Boot.op(Op.L.ordinal());
	
	public static final fn R = Boot.op(Op.R.ordinal());
	
	public static final fn T = Boot.op(Op.T.ordinal());
	
	public static final fn F = Boot.op(Op.F.ordinal());
	
	public static final fn I = Boot.op(Op.I.ordinal());
	
	public static final fn S = Boot.op(Op.S.ordinal());
	
	public static final fn isLeaf = Boot.op(Op.isLeaf.ordinal());
	
	public static final fn pair = Boot.op(Op.pair.ordinal());
	
	public static final fn bh = Boot.op(Op.bh.ordinal());
	
	public static final fn lazyEval = Boot.op(Op.lazyEval.ordinal());
	
	public static final fn curry = Boot.op(Op.curry.ordinal());
	
	public static final fn getParam = Boot.op(Op.getParam.ordinal());
	
	public static final fn nondetInfloopIf = Boot.op(Op.nondetInfloopIf.ordinal());
	
	public static final fn nondetGet = Boot.op(Op.nondetGet.ordinal());
	
	/** wrap. If its primitive array, loses the type and dim sizes but keeps the bits. */
	public static fn wr(Object ob){
		if(ob instanceof fn) return (fn)ob;
		throw new Error("TODO if prim array wrap in cbt");
	}
	
	public static fn f(Object... obs){
		if(obs.length == 1) return wr(obs[0]);
		fn x = wr(obs[0]).f(obs[1]);
		for(int i=2; i<obs.length; i++){
			x = x.f(wr(obs[i]));
		}
		return x;
	}
	
	/** 1 higher S-lambda-level than f(...). */
	public static fn S(Object... obs){
		throw new Error("TODO");
	}
	
	/** FIXME move this to mutable package */
	public static void lg(String line){
		System.out.println(line);
	}
	
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
	
	/** explained in comments in the switch statement for Op.getParam in Boot */
	public static fn getParam(int whichParam, fn thingNormallyMadeByCurry){
		if(whichParam == 0) return curry;
		return getNthCurry(whichParam,thingNormallyMadeByCurry).R();
	}
	
	/** getNthCurry(whichParam).R()==getParam(whichParam) except
	when whichParam==0 which is the curry op itself.
	You use this when you want to get multiple adjacent params efficiently.
	*/
	public static fn getNthCurry(int n, fn thingNormallyMadeByCurry){
		throw new Error("TODO");
	}
	
	public static fn cbtAsUnary(int nonnegInt){
		fn x = cbt1; //zero in unary
		while(nonnegInt-- > 0) x = x.f(x);
		return x;
	}
}
