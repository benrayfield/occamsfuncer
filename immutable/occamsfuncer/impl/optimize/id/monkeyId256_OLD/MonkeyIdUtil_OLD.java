/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.impl.optimize.id.monkeyId256_OLD;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** FIXME this code and comments were copied from a different fork of occamsfuncer with a different universalFunc
<br><br>
This is for the default kind of id, which hasnt been fully defined or tested as of 2020-8-1,
which is for either ocfn3r or some variant of it.
The id is 248 bits, normally stored in 256 bits, which leaves room for a byte of header
when hashing 2 ids in 1 sha3-256 cycle for efficiency.
That header byte chooses between callPair (func param), callQuad (func param stack cacheKey), blob, etc,
and that byte is not part of id. Id has a 0x80 byte at end as padding to the end of 256 bits,
so its normal a cbtBitstring of size 248 bits.
The first 64 bits have all the branching-related stuff, and that long is most of whats processed here.
This kind of id can be created by just a
<br><br>
FIXME this is just a first draft[
Ocfn
Id248 (pad 8 0s at end, or maybe 10000000)...
..
43 up to 1 terabyte bize (bitstring size lowest digits).
1 bit does bize have more digits.
1 bit isdeterministic.
//1 bit isparentsfunc.
//merge with curriesleft
1 bit ishalted.
2 bits stackfuncisnonnull stackparamisnonnull.
1 bit cachekeyisnonnull.
Uint5 (pair (pair (pair x))).
Uint2 Id of Id of id, so is Id of literal 256 bits of subtract 1 from that uint2. Normal IDs have 0 here. Id of id (aka Id of a cbt256) has 1 here. Id of id of id of id has 3 here. Id of id of id of id of id has 0 here and twice as much storage as 2 of literal 128 bits.
1 bit for iscbt.
//Use the 56 extra bits in 23 byte hash or 16 byte literal, to store this part?
3 bits for isliteralcbt, cbt1 to cbt128, (FIXME thats 8 things) is 7 things, else 8th means it's something else. Idofidofid is a something else.
uint4 curriesleft or nothalted.
184 bits of hash or up to 128 (rest is 0s) of literaldata etc.
8 0s of padding so id size is 256 bits.
...
Will adjust the sizes a little but that's mostly what I want in ocfn id248
]
..
Do I want cbtOfObjects at this level? Would have to be some way to mark is it a wrapper of leaf or not,
since a pair could be the object or that could be another internal pair.
Or I could just use a few extra object per node like in treemap, without complicating the ids.
Could use (T x) as marking the leaf, such as (pair (T T) (T F)) is the cbt2 of 10,
and (pair (T someObject) (T F)) is the cbtOfObjects of [someObject F]...
No, I dont want that complexity. Cbt is just for bits.
*/
public class MonkeyIdUtil_OLD{
	
	/*

	
	//"FIXME this code and comments were copied from a different fork of occamsfuncer with a different universalFunc"
	
	public static final byte callPairHeader = 2;
	public static final byte callQuadHeader = 4;
	
	/** concat(248BitsOfId,this) is a cbtBitstring size 248 by the standard padding *
	public static final byte padLastByte = (byte)0x80;
	
	/** FIXME be compatible with firstLong and padLastByte *
	public static final Id nullId = id(0,0,0,0);

	/** FIXME find the actual id of the pair func, which is 1 of the 8 small ops, the lambda Lx.Ly.Lz.zxy *
	public static final Id pairId = id(1,2,3,4);
	
	//TODO id of literal bitstring from 1 to 128 bits, a powOf2 size.
	
	/** TODO also do a block of these in opencl *
	public static Id id(Id func, Id param){
		return id(func,param,null,null);
	}
	
	/** TODO also do a block of these in opencl.
	TODO dedup Id.
	*
	public static Id id(Id func, Id param, boolean isParentsFunc, Id stack, Id cacheKey){
		boolean isCallPair = stack == null && cacheKey == null; //if true, 1 sha3-256 cycle instead of 2
		if(stack == null) stack = nullId;
		if(cacheKey == null) cacheKey = nullId;
		boolean isCbt256 = log2OfLiteralCbtSizeElse15(func.a)==7 && log2OfLiteralCbtSizeElse15(param.a)==7;
		if(isCbt256 && idOfIdDepth(func.b)!=maxIdOfIdDepth){
			//id is a cbt256, and is id of a cbt256 with all the same bits except idOfId+1
			return id( func.b+(1L<<shiftIdOfId), func.c, param.b, param.c );
		}
		
		byte[] hashMe = new byte[1+31*(isCallPair?2:4)];
		hashMe[0] = isCallPair ? callPairHeader : callQuadHeader;
		copyFirst31BytesOfIdIntoByteArray(func, hashMe, 1);
		copyFirst31BytesOfIdIntoByteArray(param, hashMe, 1+31);
		if(!isCallPair){
			copyFirst31BytesOfIdIntoByteArray(stack, hashMe, 1+31*2);
			copyFirst31BytesOfIdIntoByteArray(cacheKey, hashMe, 1+31*3);
		}
		byte[] hash = sha3_256(hashMe); //ignore the first 8 and last 1 bytes
		return id(
			firstLong(func, param, isParentsFunc, stack, cacheKey),
			MathUtil.readLongFromByteArray(hash, 8),
			MathUtil.readLongFromByteArray(hash, 16),
			(MathUtil.readLongFromByteArray(hash, 24)&0xffffffffffffff00L)|(padLastByte&0xff)
		);
	}
	
	//TODO rewrite all comments and var names, from idOfId to idOfCbt256ThatFitsInId or something like that.
	
	
	/*FIXME need isBitstring bit OR to put that in one of the existing uints such as in literalCbtSize or bize,
	or take 1 of the uint5 pairOfPair bits down to uint4.
	Also, if its a bigger cbt than needed to fit the bitstring, its not a bitstring.
	
	/**
	Uint2 Id of Id of id, so is Id of literal 256 bits of subtract 1 from that uint2. Normal IDs have 0 here. Id of id (aka Id of a cbt256) has 1 here. Id of id of id of id has 3 here. Id of id of id of id of id has 0 here and twice as much storage as 2 of literal 128 bits.
		Id is always halted, deterministic, cacheKeyIsNull, stackfuncisnonnull, and stackparamisnonnull,
			even when the thing it points at differs there. Id must still have those bits,
			since its the id of a cbt256 (which may be interpreted as an id or not),
			so always check this idOfIdOfId... bits before the other bits in the long header.
	uint4 curriesleft (and is halted) or nothalted. 0 means nothalted.
		Unless is idOfIdOfId... cuz then its always halted.
	Uint5 (pair (pair (pair x))).
	4 bits for literalCbtSize, cbt1 to cbt128. 1111 means its something else.
	2 bits stackfuncisnonnull stackparamisnonnull.
	1 bit cachekeyisnonnull.
	1 bit isdeterministic.
	1 bit for iscbt.
	1 bit does bize have more digits.
	43 up to 1 terabyte bize (bitstring size lowest digits).
	*
	public static long firstLong(Id func, Id param, boolean isParentsFunc, Id stack, Id cacheKey){
		long ret = 0;
		boolean isCallPair = stack == null && cacheKey == null;
		//can be cbt256 as 2 cbt128 (first and last 128 bits), or if idOfId>0 (then its same 256 bits except idOfId is 1 less)
		boolean isCbt256 = log2OfLiteralCbtSizeElse15(func.a)==7 && log2OfLiteralCbtSizeElse15(param.a)==7;
		if(isCbt256 && idOfIdDepth(func.b)!=maxIdOfIdDepth) {
			return func.b+(1L<<shiftIdOfId); //id is a cbt256, and is id of a cbt256 with all the same bits except idOfId+1
		}
		//nothing to change in long ret: int idOfCbt256ThatFitsInId_depth = 0;
		//Universal func always takes 9 params.
		int curriesLeftF = curriesLeft(func.a);
		int curriesLeftP = curriesLeft(param.a);
		int curriesLeft = curriesLeftF-1;
		if(curriesLeftF == 0 || curriesLeftP == 0){
			//If either child is evaling, then parent is evaling
			curriesLeft = 0;
			//FIXME how does curriesLeft get set to the higher number? Maybe need more bits in id for that?
		}
		ret |= (((long)curriesLeft)<<shiftCurriesLeft);
		//FIXME infloop between Pair creating id, but id func checking if a child is pair for this optimization.
		int pairOfPairDepth = TODO;
		if(pairId.equals(func)){
			TODO pairOfPair+1 unless its already as deep as it gets.
		}
		ret |= (((long)pairOfPairDepth)<<shiftPairOfPair);
		
		
		
		
		
		TODO implement whats in comment of this func.
		return ret;
	}
	
	public static boolean isIdOfCbt256(Id func, Id param, boolean isParentsFunc, Id stack, Id cacheKey){
	
	public static final int shiftIdOfId = 62;
	
	public static final int maxIdOfIdDepth = 0b11;
	
	public static final long maskIdOfId = ((long)maxIdOfIdDepth)<<shiftIdOfId;
	
	public static int idOfIdDepth(long firstLong){
		return (int)((firstLong&maskIdOfId)>>>shiftIdOfId);
	}
	
	public static final int shiftCurriesLeft = 58;
	
	public static final long maskCurriesLeft = 0b1111L<<shiftCurriesLeft;
	
	public static int curriesLeft(long firstLong){
		return (int)((firstLong&maskCurriesLeft)>>>shiftCurriesLeft);
	}
	
	public static final int shiftPairOfPair = 53;
	
	public static final long maskPairOfPair = 0b11111L<<shiftPairOfPair;
	
	public static int pairOfPairDepth(long firstLong){
		return (int)((firstLong&maskPairOfPair)>>>shiftPairOfPair);
	}
	
	public static final int shiftLiteralCbtSize = 49;
	
	public static final long maskLiteralCbtSize = 0b1111L<<shiftLiteralCbtSize;
	
	public static int log(long firstLong){
		return (int)((firstLong&maskLiteralCbtSize)>>>shiftLiteralCbtSize);
	}
	
	public static boolean isLiteralCbt(long firstLong){
		 return (firstLong&maskLiteralCbtSize)!=maskLiteralCbtSize;
	}

	/** only if isLiteralCbt(firstLong) *
	public static int literalCbtSize(long firstLong){
		 return 1<<log2OfLiteralCbtSizeElse15(firstLong);
	}
	
	public static int log2OfLiteralCbtSizeElse15(long firstLong){
		 return (int)((firstLong&maskLiteralCbtSize)>>>shiftLiteralCbtSize);
	}
	
	public static final long maskStackFuncIsNonNull = 48;
	
	public static final long maskStackParamIsNonNull = 47;
	
	public static final long maskStackIsNonNull = (maskStackFuncIsNonNull|maskStackParamIsNonNull);
	
	public static boolean hasStack(long firstLong){
		 return (firstLong&maskStackIsNonNull)!=0;
	}
	
	public static boolean hasStackFunc(long firstLong){
		 return (firstLong&maskStackFuncIsNonNull)!=0;
	}
	
	public static boolean hasStackParam(long firstLong){
		 return (firstLong&maskStackParamIsNonNull)!=0;
	}
	
	public static final long maskCacheKeyIsNonNull = 46;
	
	public static boolean hasCacheKey(long firstLong){
		 return (firstLong&maskCacheKeyIsNonNull)!=0;
	}
	
	public static final long maskIsDeterministic = 45;
	
	public static boolean isDeterministic(long firstLong){
		 return (firstLong&maskIsDeterministic)!=0;
	}

	public static final long maskIsCbt = 44;
	
	public static boolean isCbt(long firstLong){
		 return (firstLong&maskIsCbt)!=0;
	}
	
	/** is it a bitstring whose size exceeds maxBize *
	public static final long maskBizeHasMoreDigits = 43;
	
	public static final long maskBize = (1L<<maskBizeHasMoreDigits)-1;
	
	/** max bitstring size in bits. Bits are T or F, in a complete binary tree (cbt) made of pairs.
	Bitstring is any cbt which contains T (1). The bitstring is the bits before the last 1.
	Every bitstring isCbt.
	*
	public static final long maxBize = maskBize;
	
	
	
	/** TODO dedup Id, but for now just a new one *
	static Id id(long a, long b, long c, long d){
		return new Id(a,b,c,d);
	}
	
	public static void copyFirst31BytesOfIdIntoByteArray(Id i, byte[] b, int offset){
		MathUtil.copyLongIntoByteArray(b, offset, i.a);
		MathUtil.copyLongIntoByteArray(b, offset+8, i.b);
		MathUtil.copyLongIntoByteArray(b, offset+16, i.c);
		MathUtil.copyHigh7BytesOfLongIntoByteArray(b, offset+24, i.d);
	}
	
	/** TODO also do a block of these in opencl *
	public static byte[] sha3_256(byte[] in){
		//TODO ThreadLocal or new MessageDigest each time faster? not for single threaded.
		//TODO have 2 implementations of every hash and digsig algorithm and test them at runtime in production
		//by every 10000 or so calls, use both at once and verify they give the same output.
		synchronized(mdSha3_256){
			mdSha3_256.reset();
			return mdSha3_256.digest(in);
		}
	}
	
	static final MessageDigest mdSha3_256;
	static{
		try{
			mdSha3_256 = MessageDigest.getInstance("SHA3-256");
		}catch (NoSuchAlgorithmException e){ throw new Error(e); }
	}*/

}
