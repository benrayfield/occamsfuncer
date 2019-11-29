/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.impl.util;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.S;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.T;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.curry;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.getp;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.t;

import java.util.Arrays;

import immutable.util.Text;
import immutableexceptgas.occamsfuncer.fn;
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
	
	public static final fn ifElse = Boot.op(Op.ifElse.ordinal());
	//public static final fn bh = Boot.op(Op.bh.ordinal());
	
	public static final fn lazyEval = Boot.op(Op.lazyEval.ordinal());
	
	/////
	
	public static final fn curry = Boot.op(Op.curry.ordinal());
	
	public static final fn getp = Boot.op(Op.getp.ordinal());
	
	public static final fn recur = Boot.op(Op.recur.ordinal());
	
	public static final fn nondet = Boot.op(Op.nondet.ordinal());
	
	/////
	
	
	
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
	
	/** similar to cp(fn,fn) except doesnt dedup. just returns new Call */
	public static fn CP(fn itsL, fn itsR){
		return new Call(itsL, itsR);
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
	
	/** TODO optimize by caching int in Call, like explained in getParam(int,fn).
	A madebycurry is (lazyEval (curry ... paramN) param<n+1>)
	where n is either the number of params of curry (for funcBody)
	or 1 less than that (for constraint).
	This func will be unnecessary once that optimization exists
	and the optimized code can be moved into getParam(int,fn) instead.
	(which can be further optimized by Compiled not even calling these funcs every time).
	*
	public static int numParamsInMadebycurry(fn thingNormallyMadeByCurry){
		fn x = thingNormallyMadeByCurry.L().R(); //starts as curryL
		int params = 1; //counting curryR
		while(x.height() > 4){ //until x is curry or detect error as the leftmost op is not curry
			x = x.L();
			params++;
		}
		return params;
	}*/
	
	/** Explained in comments in the switch statement for Op.getParam in Boot.
	For efficiency does not add to Cache or call Op.getp.
	This is called in the implementation of Op.getp and Op.curry.
	Returns leaf if the requested param index is out of range, as in Op.getp spec.
	*/
	public static fn getParam(int whichParam, fn thingNormallyMadeByCurry){
		//TODO merge duplicate code between getParam(int,fn) and getNthCurry(int,fn)
		
		if(whichParam < 0){
			if(whichParam != 0) return leaf;
			//left end of currylist doesnt have nil like right end of linkedlist
			return curry;
		}
		fn x = thingNormallyMadeByCurry.L().R(); //curryL in (lazyEval curryL curryR)
		int p = x.curHeight()-curHeightOf_opCurry;
		if(p < whichParam){
			if(p+1 == whichParam){ //FIXME off by 1? Should it be p==whichParam?
				//lastParam in (lazyEval (curry ... secondLastParam) lastParam),
				//or thirdLastParam and secondLastParam if this is
				//called by constraint instead of by funcBody
				//since constraint is evaled at cur()-1 cuz its a constraint
				//on a datastruct (such as Example.mapPair()), and funcBody
				//is what happens when that datastruct is called on something.
				return thingNormallyMadeByCurry.R();
			}else{ //whichParam is bigger than last param
				return leaf;
			}
		}
		while(p != whichParam){
			x = x.L(); //Example: x=(curry unary constraint) becomes x=(curry unary).
			p--;
		}
		return x.R(); //if whichParam==0 then would return x here, but did that earlier
		
		
		
		/*if(whichParam == 0) return curry;
		fn curryL = thingNormallyMadeByCurry.L().R();
		boolean isLastParam = curryL.cur()==1;
		*/
		
		/*
		//curry is getParam 0 so dont subtract 1 here
		boolean isLastParam = numParamsInMadebycurry(thingNormallyMadeByCurry) == whichParam;
		if(isLastParam){
			//lastParam in (lazyEval (curry ... secondLastParam) lastParam)
			return thingNormallyMadeByCurry.R();
		}
		FIXME should this -1 be here?
		return getNthCurry(whichParam-1,thingNormallyMadeByCurry).R();
		*/
	}
	
	/** getNthCurry(whichParam).R()==getParam(whichParam) except
	when whichParam==0 which is the curry op itself.
	You use this when you want to get multiple adjacent params efficiently.
	Cant use this to get the last param cuz fn.cur() cant be 0
	cuz every fn is a halted state, and thats why lazyEval is used,
	but if its a lazyEval its not exactly a curry as it was originally done
	cuz (this) getNthCurry is only used on curries of Op.curry.
	<br><br>
	WARNING: may go into undetectable infinite loop if thingNormallyMadeByCurry
	is not the right datastruct, so this must only be called by trusted code.
	All possible nonhalting programs buildable at user level obey Gas (always halt),
	if the VM correctly implements the occamsfuncer spec (TODO verify the spec). 
	*/
	public static fn getNthCurry(int n, fn thingNormallyMadeByCurry){
		//TODO merge duplicate code between getParam(int,fn) and getNthCurry(int,fn)
		
		//thingNormallyMadeByCurry=(lazyEval (curry ... y) z)
		//where z is either the second last param (if this is called by constraint)
		//or z is the last param (if this is called by funcBody),
		//and either way y is the param just before z (or is funcBody if only 1 param).
		fn x = thingNormallyMadeByCurry.L().R();
		int xIsNth = x.curHeight()-curHeightOf_opCurry;
		if(xIsNth+1==n) return thingNormallyMadeByCurry.R(); //FIXME off by 1?
		while(xIsNth != n){ //crashes if 
			x = x.L();
			xIsNth--;
		}
		return x;
		/*
		//TODO optimize by Call.java caching depth since leftmost curry,
		//which is a separate int than Call.cur.
		//Get itsL in thingNormallyMadeByCurry=(lazyEval itsL itsR).
		fn x = thingNormallyMadeByCurry.L().R();
		while(x.L().L().L() != curry){ //TODO optimize by using fn.bh(int)
			x = x.L();
		}
		return x;
		*/
	}
	
	/** returns cbt of 2 exponent nonnegInt cbt1s, representing a unary number.
	cbt1 is unary 0. (cbt1 cbt1) is unary 1. ((cbt1 cbt1)(cbt1 cbt1)) is unary 2,
	and so on. TODO These are optimized to share branches,
	and to only store it in a wrapper of a primitive if up to 64 bits so unary 6,
	and maybe up to 256 bits depending on implementation of the VM,
	and above than that it uses funcallPairs (Call). It has linear cost per height.
	TODO optimize? maybe create a new javaclass that implements fn,
	that wraps an int and represents unary up to 2^31-1 height
	and its L() and R() are another of itself with 1 less height
	or such a wrapper of a long if small enough,
	BUT that might interfere with dedup optimizations, but large bitstrings
	often interfere with dedup optimizations
	but every fn guarantees collision-free dedup when using
	any secureHash idFunc (such as doubleSha256 with some pre and post processing)
	EXCEPT for the possibility that its not actually a secureHash
	as a collision may be found eventually and for defense against that
	you can use multiple idFuncs at once
	as in abstract math an id is represented as a vector whose dims (dimensions)
	are every possible fn and whose value at that dim are the fn returned
	when call (anIdFunc anyFunc) which returns anId,
	especially where anId is always a cbtBitstring,
	so technically every possible content-addressable id generator function
	is already part of the system and integrates seamlessly
	so the ids of this system (though not any particular subset of them)
	are perfectly unhackable in the abstract math
	but may be hackable in the choice of a specific idFunc
	but thats why you get to use multiple idFuncs at once
	(except in sorting MapPair etc, but you could define an idFunc
	as concat of what other idFuncs return so could do it in MapPair,
	or you could derive a variant of MapPair that does it a different way) 
	and why fn.id(fn idFunc) has a fn param instead of being fn.id(),
	though in some VMs it might only be able to cache 1 idFunc at a time,
	but if you want to cache multiple idFuncs at once
	you could use an immutable linkedlist of key/value pairs.
	<br><br>
	TODO move the part of the comment above about idFuncs
	to a more general place such as into the comments of fn.id(fn).
	*/
	public static fn unary(int nonnegInt){
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
	
	//public static final int standardParamsOfCurry = 3;
	
	/*confusing cuz of the standardParamsOfCurry
	public static fn paramIndex(int nonnegInt){
		return nonnegIntToUnaryCbt(standardParamsOfCurry+nonnegInt);
	}*/
	
	/** p4 is first param, and p5 is second param, and so on.
	p0 gets Op.curry. p1 gets cbtAsUnary. p2 gets constraint. p3 gets funcBody.
	returns a func that
	[gets param at nonnegative integer when given the structure Op.curry creates]
	There are 3 standard params of curry:
	(curry cbtAsUnary constraint funcBody),
	so p(0).f(structure curry creates)==curry,
	and is curry and p(4).f(structure curry creates) returns first param,
	and Op.recur calls (unless Compiled) getNthCurry.
	*/
	public static fn p(int paramIndex){
		//TODO optimize by remembering (getp leaf) in Example.java
		return getp.f(leaf).f(unary(paramIndex));
	}
	
	/** a shortcut for Op.getp currying the first 2 params except
	the second param is a nonnegInt translated to cbt as unary.
	*/
	public static fn p(Object comment, int paramIndex){
		return getp.f(comment).f(unary(paramIndex));
	}
	
	/** wrap. If its primitive array, loses the type and dim sizes but keeps the bits. */
	public static fn f(Object ob){
		if(ob instanceof fn) return (fn)ob;
		if(ob instanceof String){
			return f(Text.stringToBytes((String)ob));
		}
		if(ob instanceof byte[]){
			//TODO optimize: use ArrayCbt or SmallCbt depending on its size,
			//but for now 2019-11 only Leaf and Call are working.
			byte[] a = (byte[])ob;
			a = pad(a);
			return wrapPowOf2SizeRange(pad(a), 0, a.length);
		}
		throw new Error("TODO if prim array wrap in cbt. param="+ob);
	}
	
	public static fn wrapPowOf2SizeRange(byte[] b, int start, int endExcl){
		if(!isPowOf2(endExcl-start)) throw new Error(
			"not powOf2 start="+start+" endExcl="+endExcl);
		if(start+1==endExcl) return byteToRawCbt(b[start]);
		fn itsL = wrapPowOf2SizeRange(b,start,(start+endExcl)/2);
		fn itsR = wrapPowOf2SizeRange(b,(start+endExcl)/2,endExcl);
		return itsL.f(itsR);
	}
	
	public static boolean isPowOf2(int i){
		return 0<i && (i&(i-1))==0; //TODO optimize: does this need 0<i?
	}
	
	/** append cbt1 cbt0 cbt0... until the next higher powOf2 num of bits.
	If array is already a powOf2 size, will double its size cuz must have that last cbt1
	thats not part of the bitstring.
	TODO optimize this using ArrayCbt which doesnt store this padding.
	*/
	public static byte[] pad(byte[] b){
		int minBytes = b.length+1;
		int newSize = Integer.highestOneBit(minBytes);
		if(!isPowOf2(minBytes)) newSize *= 2;
		byte[] c = new byte[newSize];
		System.arraycopy(b, 0, c, 0, b.length);
		c[b.length] = (byte)0b10000000;
		return c;
	}
	
	/** raw means without the
	trailing cbt1 cbt0 cbt0... that normally represent bitstring before the last cbt1.
	*/
	public static fn byteToRawCbt(byte B){
		int i = B;
		fn a = (i&128)==0 ? cbt0 : cbt1;
		fn b = (i&64)==0 ? cbt0 : cbt1;
		fn c = (i&32)==0 ? cbt0 : cbt1;
		fn d = (i&16)==0 ? cbt0 : cbt1;
		fn e = (i&8)==0 ? cbt0 : cbt1;
		fn f = (i&4)==0 ? cbt0 : cbt1;
		fn g = (i&2)==0 ? cbt0 : cbt1;
		fn h = (i&1)==0 ? cbt0 : cbt1;
		return a.f(b).f(c.f(d)).f( e.f(f).f(g.f(h)) ); //(((ab)(cd))((ef)(gh)))
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
	
	/*
	private static fn recurse;
	/** given a thingNormallyMadeByCurry as its only param (get it by Op.I),
	returns Op.curry with its first few params up to a funcBody
	but without any params after funcBody.
	*
	public static fn recurse(){
		if(recurse == null){
			recurse = null; //FIXME
			//recurse = getNthCurry(standardParamsOfCurry, thingNormallyMadeByCurry);
			//FIXME i want that call except with Op.I getting the thingNormallyMadeByCurry
		}
		return recurse;
	}*/
	
	/** is this a complete binary tree of all cbt1s? */
	public static boolean isUnaryCbt(fn f){
		//FIXME call $()?
		//TODO optimize by caching this in Call instead of recursing.
		//Without that optimization, this is exponential cost. With it, constant cost.
		//unless f.isCbt() is false then its constant cost.
		return f.isCbt() && f.height()>=4 && (f==cbt1 || (isUnaryCbt(f.L()) && isUnaryCbt(f.R())));
		
	}
	
	public static byte[] bytes(fn f){
		$();
		if(!f.isBitstring()) throw new Error("Not a bitstring: "+f);
		int cbtSize = 1<<(f.height()-4);
		$(cbtSize);
		int bitstringSize = f.bitstringSize();
		if((bitstringSize&7)!=0) throw new Error("not a multiple of 8 bits");
		//FIXME also throw if not a multiple of 8 bits
		//FIXME throw Gas instead?
		byte[] b = new byte[bitstringSize>>3];
		for(int i=0; i<b.length; i++){
			b[i] = f.byteAt(i<<3);
		}
		return b;
	}
	
	/**
	011000010110001001100011 //string "abc"
	01100001011000100110001110000000 //padded
	(01(10)(00(01))(01(10)(00(10)))(01(10)(00<unary1>)(10(00)(00(00))))) //fn of padded
	*/
	public static String str(fn f){
		$();
		if(!f.isBitstring()) {
			throw new Error("Not a bitstring so cant be a utf8 string");
		}
		//FIXME throw Gas instead?
		return Text.bytesToString(bytes(f));
	}
	
	public static final int curHeightOf_opCurry;
	
	static{
		Boot.boot();
		curHeightOf_opCurry = curry.curHeight();
		lg("Occamsfuncer booted.");
	}
}
