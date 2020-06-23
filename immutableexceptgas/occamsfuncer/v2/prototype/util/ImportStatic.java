/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.v2.prototype.util;

import java.util.Arrays;

import immutable.util.MathUtil;
import immutable.util.Text;
import immutableexceptgas.occamsfuncer.v2.prototype.fns.Call;
import immutableexceptgas.occamsfuncer.v2.prototype.fns.Leaf;
import immutableexceptgas.occamsfuncer.v2.spec.Gas;
import immutableexceptgas.occamsfuncer.v2.spec.Op;
import immutableexceptgas.occamsfuncer.v2.spec.fn;

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
	
	/*public static final fn ifElse = Boot.op(Op.ifElse.ordinal());
	//public static final fn bh = Boot.op(Op.bh.ordinal());
	
	//public static final fn lazyEval = Boot.op(Op.lazyEval.ordinal());
	public static final fn lazig = Boot.op(Op.lazig.ordinal());
	*/
	
	/** get comment */
	public static final fn comment = Boot.op(Op.comment.ordinal());
	
	/** forkSet comment */
	public static final fn COMMENT = Boot.op(Op.COMMENT.ordinal());
	
	/////
	
	public static final fn curry = Boot.op(Op.curry.ordinal());
	
	public static final fn getp = Boot.op(Op.getp.ordinal());
	
	public static final fn recur = Boot.op(Op.recur.ordinal());
	
	public static final fn nondet = Boot.op(Op.nondet.ordinal());
	
	/////
	
	
	
	/*
	public static fn randCbt128(){
		return nondet.f(nondet).f(nondet).f(unary(11));
	}*/
	
	/** curry.cur() is this aka 0 *
	public static final int CURRIES_VARARG = 0;
	
	public static final int CURRIES_BIGINT = Integer.MAX_VALUE-1;
	
	/** cbt0 and cbt1 and all fns at height1 to height3 take infinite curries. *
	public static final int CURRIES_INFINITE = Integer.MAX_VALUE;
	*/
	
	
	
	/** FIXME move this to mutable package */
	public static void lg(String line){
		System.out.println(line);
	}
	
	/** FIXME move this to mutable package */
	public static void lgErr(String line){
		System.err.println(line);
	}
	
	public static fn IF(fn condition, fn ifTrue, fn ifFalse){
		return ST(Example.ifElse(), condition, ifTrue, ifFalse);
	}
	
	/*public static fn dedup(fn f){
		return Cache.dedup(f);
	}
	
	public static fn dedup(fn itsL, fn itsR){
		return Cache.dedup(itsL, itsR);
	}*/
	
	public static fn cp(fn itsL, fn itsR){
		return cp(itsL, itsR, leaf);
	}
	
	/** WARNING: using this where itsL.f(itsR) would have done something other than
	create a call pair, breaks the system.
	<br><br>
	Wreate Call Pair without checking if it would execute, but do still dedup.
	*/
	public static fn cp(fn itsL, fn itsR, fn comment){
		fn f = Cache.getRetOfFuncParamCommentElseNull(itsL,itsR,comment);
		if(f == null) Cache.putLRParent(f = new Call(itsL, itsR, comment));
		return f;
	}
	
	/** a calltriple (callpair since its comment is leaf) without dedup */
	public static fn CP(fn itsL, fn itsR){
		return new Call(itsL, itsR, leaf);
	}
	
	/** a calltriple without dedup.
	similar to cp(fn,fn) except doesnt dedup. just returns new Call
	*/
	public static fn CP(fn itsL, fn itsR, fn comment){
		return new Call(itsL, itsR, comment);
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
	
	private static boolean trustedmode = false;
	public static boolean isTrustedMode() {
		return trustedmode;
	}
	
	/** for running unverified code strings such as openclNdrangeKernel code
	or the subset of java code that javassist compiles etc.
	This design requiring trust is temporary as code verifiers should be
	put into the occamsfuncer JIT compiler (Compiled.java) to
	run formalVerification on generated code so it doesnt
	need to be trusted, conditional on the systems it calls into
	work as their spec describes.
	*/
	public static void setTrustedMode(boolean trust){
		trustedmode = trust;
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
	
	/** Explained in comments in the switch statement for Op.getp in Boot.
	For efficiency does not add to Cache or call Op.getp.
	This is called in the implementation of Op.getp and Op.curry.
	Returns leaf if the requested param index is out of range, as in Op.getp spec.
	*/
	public static fn getp(int whichParam, fn thingNormallyMadeByCurry){
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
		//return getp.f(leaf).f(unary(paramIndex));
		return getp.f(unary(paramIndex));
	}
	
	/** a shortcut for Op.getp currying the first 2 params except
	the second param is a nonnegInt translated to cbt as unary.
	*/
	public static fn p(Object comment, int paramIndex){
		//return getp.f(comment).f(unary(paramIndex));
		return p(paramIndex).COMMENT(comment);
	}
	
	/** The first usecase of this is to wrap a String's utf8 bits
	in a cbtBitstring without Example.contentType(...) prefix,
	cuz Example.contentType() has to write the contentType in raw form
	to avoid infiniteLoop.
	*/
	public static fn utf8ToBitstring(String x){
		return w(Text.stringToBytes(x));
	}
	
	public static fn doubleToBitstring(double d){
		return longToBitstring(Double.doubleToLongBits(d)); //normed bits
	}
	
	/** rawcbt is cbt without padding,
	unlike bitstring pads with a cbt1 then cbt0s until next powOf2 size.
	*/
	public static fn doubleToRawcbt(double d){
		return longToRawcbt(Double.doubleToLongBits(d)); //normed bits
	}
	
	/** returns a bitstring size 32, which is a cbt size 64
	whose last half, most of which is not stored (TODO)
	is cbt1 then padded with cbt0s to the next powOf2 size
	as usual in cbtBitstring.
	*/
	public static fn intToBitstring(int i){
		//TODO optimize using SmallCbt
		return longToRawcbt((((long)i)<<32)|(1L<<31));
	}
	
	public static fn longToRawcbt(long j){
		//TODO optimize using SmallCbt.
		//Dont forget its (in abstract math but not storage) a cbt of size 128
		//padded with 1 then 63 0s meaning its a bitstring size 64.
		byte[] b = new byte[8];
		MathUtil.copyLongIntoByteArray(b, 0, j);
		return wrapPowOf2Size(b);
	}
	
	public static fn longToBitstring(long j){
		//TODO optimize using SmallCbt, will only store a long and a byte to say its bitstring vs rawcbt
		byte[] b = new byte[16];
		MathUtil.copyLongIntoByteArray(b, 0, j);
		b[8] = (byte)0x80;
		return wrapPowOf2Size(b);
	}
	
	/** wrap. If its primitive array, loses the type and dim sizes but keeps the bits. */
	public static fn w(Object ob){
		if(ob instanceof fn) return (fn)ob;
		if(ob instanceof String){
			return Example.stringPrefix().f(utf8ToBitstring((String)ob));
			//return w(Text.stringToBytes((String)ob)); //FIXME wrap in Example.stringPrefix()?
		}
		if(ob instanceof Number){
			if(ob instanceof Double){
				return Example.doublePrefix().f(doubleToBitstring((Double)ob));
			}
			if(ob instanceof Byte){
				byte b = (byte)ob;
				return byteToRawCbt((byte)ob); //FIXME use ImportStatic.doublePrefix() etc. contentType.
			}
			if(ob instanceof Short){
				short s = (short)ob;
				return w((byte)(s>>>8)).f((byte)s);  //FIXME use ImportStatic.doublePrefix() etc.  contentType.
			}
			if(ob instanceof Integer){
				int i = (int)ob;
				return w((short)(i>>>16)).f((short)i);  //FIXME use ImportStatic.doublePrefix() etc.  contentType.
			}
			throw new Error("TODO");
		}
		if(ob instanceof byte[]){
			//TODO optimize: use ArrayCbt or SmallCbt depending on its size,
			//but for now 2019-11 only Leaf and Call are working.
			byte[] a = (byte[])ob;
			a = pad(a);
			return wrapPowOf2SizeRange(pad(a), 0, a.length);
		}
		if(ob instanceof int[]){
			if(1<2) throw new Error("FIXME in commentPic this is meant not as a bitstring but as a cbt of powOf4 size.");
			//TODO optimize: use ArrayCbt or SmallCbt, similar to byte[]
			//but for now will copy to byte[] which gets copied to
			//interpreted complete binary tree with cbt0s and cbt1s
			//instead of wrapping the int[] as it will later.
			return w(MathUtil.intsToBytes((int[])ob));
		}
		throw new Error("TODO if prim array wrap in cbt. param="+ob);
	}
	
	public static fn wrapPowOf2Size(byte[] b){
		return wrapPowOf2SizeRange(b, 0, b.length);
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
	FIXME there are 3 kinds: with prefix such as Example.contentType("something"),
	vs cbt with padding (bitstring ends with 1 0 0 0...), vs cbt without padding.
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
		if(obs.length == 1) return w(obs[0]);
		fn x = w(obs[0]).f(obs[1]);
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
		fn x = w(obs[0]);
		if(obs.length == 1) return x; //f(S(x) p) returns (x p) so return x?
		for(int i=1; i<obs.length; i++){
			x = S.f(x).f(obs[i]);
		}
		lg("S( "+Arrays.asList(obs)+" ) returning "+x);
		return x;
	}
	
	/** same as S(t(firstParam), other params...) */
	public static fn ST(Object... obs){
		Object[] o = obs.clone();
		o[0] = t(w(o[0]));
		return S(o);
	}
	
	/** Same as f(lazig(), S(...)).
	Normally used as the ifTrue and ifFalse parts of Op.ifElse,
	but you can use anything as an ifTrue or ifFalse,
	anything designed to happen when it gets leaf as its param.
	*/
	public static fn then(Object... obs){
		return Example.lazig().f(S(obs));
	}
	
	/** the ST form of then(...). ST just does t(...) to its first param
	and other than that is the same as S(...).
	*/
	public static fn thenT(Object... obs){
		return Example.lazig().f(ST(obs));
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
	
	public static fn t(Object param){
		return T.f(param);
	}
	
	public static fn tt(fn param){
		return t(t(param));
	}
	
	public static fn ttt(fn param){
		return t(tt(param));
	}
	
	public static fn tttt(fn param){
		return tt(tt(param));
	}
	
	/** linkedlist by typeList */
	public static fn ll(Object... list){
		fn ret = Example.linkedList();
		for(Object o : list){
			ret = ret.f(o);
		}
		return ret;
	}
	
	/** S-currying that returns a [linkedlist by typeList] when given a param. */
	public static fn Sll(Object... list){
		Object[] newList = new Object[1+list.length];
		newList[0] = Example.linkedList();
		System.arraycopy(list, 0, newList, 1, list.length);
		return ST(newList);
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
	
	/** is this a complete binary tree of all cbt1s? *
	public static boolean isUnaryCbt(fn f){
		//FIXME call $()?
		//TODO optimize by caching this in Call instead of recursing.
		//Without that optimization, this is exponential cost. With it, constant cost.
		//unless f.isCbt() is false then its constant cost.
		return f.isCbt() && f.height()>=4 && (f==cbt1 || (isUnaryCbt(f.L()) && isUnaryCbt(f.R())));
		
	}*/
	
	public static byte[] bytes(fn f){
		$();
		if(!f.isBitstring()) throw new Error("Not a bitstring: "+f);
		int cbtSize = 1<<(f.height()-4);
		$(cbtSize);
		long bs = f.bitstringSize();
		if(bs > Integer.MAX_VALUE) throw new Error("TODO a few times bigger than that should work cuz its bit indexed not byte indexed, even though java arrays cant be bigger than int");
		int bitstringSize = (int)bs;
		if((bitstringSize&7)!=0) throw new Error("not a multiple of 8 bits");
		//FIXME also throw if not a multiple of 8 bits
		//FIXME throw Gas instead?
		byte[] b = new byte[bitstringSize>>3];
		for(int i=0; i<b.length; i++){
			b[i] = f.byteAt(i<<3);
		}
		return b;
	}
	
	/** doesnt check if it is a tinymap or not, but wont infloop */
	public static fn tinymapGetOrLeaf(fn tinymap, fn getKey){
		fn tm = Example.tinyMap();
		while(tm.height() < tinymap.height()){
			fn tinymapL = tinymap.L();
			fn key = tinymapL.R();
			if(getKey.equals(key)){
				return tinymap.R(); //val of that key
			}
			tinymap = tinymapL.L(); //without the last 2 params
		}
		return leaf;
	}
	
	/** My param is a fn.comment() datastruct,
	which is Example.tinylist() called on alternating key val key val...
	TODO emulate (and optimize with Compiled) this in Example.java,
	will be same speed but at least then user level occamsfuncer code can call it
	without going through op.nondet.
	*/
	public static fn commentTextOrLeaf(fn comment){
		return tinymapGetOrLeaf(comment, Example.commentKeyForText());
	}
	
	public static String commentText(fn comment){
		return strNoThrow(commentTextOrLeaf(comment));
	}
	
	
	/** My param is a fn.comment() datastruct,
	which is Example.tinylist() called on alternating key val key val...
	*/
	public static fn commentPicOrLeaf(fn comment){
		return tinymapGetOrLeaf(comment, Example.commentKeyForPic());
	}
	
	public static fn comment(String text, int[] pic){
		return f(Example.tinyMap(),
			Example.commentKeyForText(), text,
			Example.commentKeyForPic(), w(pic));
	}
	
	public static fn commentPixel(int pixelARGB){
		return f(Example.tinyMap(), Example.commentKeyForPic(), w(pixelARGB));
	}

	/** 011000010110001001100011 //string "abc"
	01100001011000100110001110000000 //padded
	(01(10)(00(01))(01(10)(00(10)))(01(10)(00<unary1>)(10(00)(00(00))))) //fn of padded
	*/
	public static String toRawString(fn x){
		$(); //TODO depend on string len
		if(!x.isBitstring()){
			throw new Error("Not a bitstring so cant be a utf8 string");
		}
		//FIXME throw Gas instead?
		//wrong direction: return Example.stringPrefix().f(x);
		return Text.bytesToString(bytes(x));
	}
	

	public static String str(fn x){
		$(); //TODO depend on string len
		if(x.L()==Example.stringPrefix()){
			x = x.R();
		}
		if(!x.isBitstring()){
			throw new Error("Not a bitstring so cant be a utf8 string");
		}
		//FIXME throw Gas instead?
		//wrong direction: return Example.stringPrefix().f(x);
		return Text.bytesToString(bytes(x));
	}
	
	/** returns "" if not a utf8 string */
	public static String strNoThrow(fn f){
		$(); //TODO depend on string len
		if(f.L()==Example.stringPrefix()){
			f = f.R();
		}
		if(!f.isBitstring() && (f.bitstringSize()&7)!=0) return "";
		try{
			//TODO optimize detect utf8 data format and return "" faster than throwing.
			return Text.bytesToString(bytes(f));
		}catch(Throwable t){
			return "";
		}
	}
	
	public static fn pair(fn myCar, fn myCdr){
		return pair.f(myCar).f(myCdr);
	}
	
	/** bitstring ends with cbt1 then padded with cbt0s until next powOf2 size */
	public static fn bitstringOfAll0sAndSize(long size){
		//FIXME check max bitstring size which Call.last1 can represent
		if(size < 0) throw new Error("neg size "+size);
		if(size == 0) return cbt1;
		if(size == 1) return cbt0.f(cbt1);
		//recurse todo 
		throw new Error("TODO build this of log number of nodes starting with cbt0");
	}
	
	/** Returns a call of Example.enforceType() which takes 1 more param,
	the value to pass through as is vs infloop if its not that type.
	For now make this a call of nondet, but todo implement it without nondet.
	arraySize is in units of primType, not bits as usual in cbtBitstring.
	*/
	public static fn enforceType(Class primType, int arraySize){
		if(primType == float.class){
			throw new Error("TODO");
		}
		throw new Error("TODO");
	}
	
	/** make sure not to create any func that starts with ocfnplug
	(and also must take exactly 1 param and it be type fn.class)
	unless you want user level code to be able to call it
	when its not in Gas.forceDeterminism mode.
	Being careful here in case somehow some later code
	converts other types of params into a fn param.
	Technically an ocfnplug can be used as varargs
	since it could count how many are in the madeByCurry fn
	that is its param and it could be used in different
	curry.f(unary(4)).f(constraint).f(nondet.f("ocfnplug").f(packageClassFunc)
	vs curry.f(unary(15))... etc, and you could use 2 different plugins
	one for the constraint and one for the funcBody.
	*/
	public static fn plug(String packageClassFunc, int params){
		return Example.c(params).f(nondet.f("ocfnplug").f(packageClassFunc));
	}
	
	public static final int curHeightOf_opCurry;
	
	static{
		Boot.boot();
		curHeightOf_opCurry = curry.curHeight();
		lg("Occamsfuncer booted.");
		//TODO Boot.optimize(), but calling that here would prevent TestBasics from testing it before optimizations
	}
	
	
}
