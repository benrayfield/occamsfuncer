package immutable.occamsfuncer.impl.optimize.id;

/** This is an optional way to describe what various bit ranges in an id typpe mean.
Each id type will use some of these but not others.
An id type defines a trie of IdPart each being some number of bits. 
Occamsfuncer/ocfn can have an infinite number of kinds of ids that can be used simultaneously,
which are all deterministic based on forest shape. Every node has a small constant number of childs,
including: func, param, stack, cacheKey, isParentsFunc, isCallPair,
and maybe a few other is* bit childs (which are T or F but actually stored as bits).
Each is a fn called an idMaker. (anIdMaker x)->idOfX, for any x,
and idOfX is a cbtBitstring always of the same size, such as 256 bits or 416 bits or 512 bits.
If you want to use 3 idMakers together, you can concat all 3 ids or use any subset of them.
In general, think of the id of a fn as having an infinite number of bits that are each F/0, unknown, or T/1,
and each bit is every possible fn idBitMaker where (anIdBitMaker x)->y where y returns F (0), y returns T (1),
or y does not return F or T or doesnt not return at all (unknown).
An example of an idBitMaker is to get the 237th bit of some other idMaker that returns a bitstring,
so idBitMaker is mostly just a math abstraction and we normally use idMakers directly instead.
That math abstraction means you can use any bits from any part of any ids to combine into a new id type.
*/
public enum IdField{
	
	/** Example: First bit in an id is always 1 so if its not 0 then it means some other data structure,
	or you might allocate a multicodec/multihash (see the projects on github used in ipfs etc) prefix for a specific kind of id,
	or you might pad 0s to align to bytes or ints or longs so a 416 bit id could fit in an int[13],
	and you might have a few bits left over to fill one of those ints (especially the first int).
	*/
	constant,
	
	/** Theres 4 dedupLevels. The first 2 have ids shareable across untrusted borders (such as in p2p network or any website).
	The last 2 can only have an id if isMadeUpId and would normally use the first 2 levels for ids only.
	Still, you can store 2 bits of dedupLevel (4 possibilities) in an id, just in case you want to do the isMadeUpId for them.
	*/
	dedupLevel,
	
	/** Example: 256 bits thats either sha3_256 or 1 or 2 or 4 or 8 or 16 or 32 or 64 or 128 or 256 bits of literal cbt */
	constSizeHashOrLiteralOrMadeupid,
	
	isHashId,
	
	isLiteralThatFitsInId,
	
	/** If true, then constSizeHashOrLiteralOrMadeupid is interpreted as a made up id,
	such as a long used in databases to refer to this object without hashing it, or 192 bits of random number
	referring to yourself concat a long.
	*/
	isMadeUpId,
	
	/** Example: True if the universalFunc's first param is leaf or (leaf leaf) and it has at least 5 params
	and opcode size is 5 bits. False if its first param is something else, which is for possible future expansion.
	*/
	hasOpcode,
	
	/** Example: 5 bits of the first 5 params of universalFunc being leaf or nonleaf. */
	opcodeLeafVsNonleaf,
	
	/** Example: 16 bits for this (FIXME include this or not?), this.L, this.L.L, ... this.L.L.L.L.L.L.L.L.L.L.L.L.L.L.L==leaf.
	Efficient to bitShift this with each next curry.
	currysIsLeaf and currysIsLeafLeaf can be used together to check if first param of universalFunc is leaf, (leaf leaf), or other.
	*/
	currysIsLeaf,
	
	/** Same as currysIsLeaf except it checks if each of those is (leaf leaf). */
	currysIsLeafLeaf,
	
	/** like using currysIsLeaf and currysIsLeafleaf except comes in 2 bit blocks that are 10, 01, or 00, alternating the bits of those 2. */
	currysIsLeafVsLeafleafVsOther,
	
	/** Example: Uint2 Id of Id of id, so is Id of literal 256 bits of subtract 1 from that uint2. Normal IDs have 0 here. Id of id (aka Id of a cbt256) has 1 here. Id of id of id of id has 3 here. Id of id of id of id of id has 0 here and twice as much storage as 2 of literal 128 bits.
	Id is always halted, deterministic, cacheKeyIsNull, stackfuncisnonnull, and stackparamisnonnull,
		even when the thing it points at differs there. Id must still have those bits,
		since its the id of a cbt256 (which may be interpreted as an id or not),
		so always check this idOfIdOfId... bits before the other bits in the long header.
	*/
	idOfIdDepth,

	/** Example: uint4 curriesleft (and is halted) or nothalted. 0 means nothalted.
	Unless is idOfIdOfId... cuz then its always halted.
	*/
	curriesLeft,
	
	/** Example: Uint5 (pair (pair (pair x))) */
	pairOfPairDepth,

	/** Example: 3 bits for literalCbtSize, cbt1 to cbt128. */
	log2OfLiteralCbtSize,
	
	/** Example: 4 bits for literalCbtSize, cbt1 (2^0) to cbt16384 (2^0b1110). 0b1111 means its something else. */
	log2OfLiteralCbtSizeButMaxMeansOther,
	
	isHeightHasMoreDigits,
	
	/** leaf is height 0. (leaf leaf) is height 1. ((leaf leaf) leaf) and (leaf (leaf leaf)) and ((leaf leaf)(leaf leaf)) are height 2. and so on. */
	lowNBitsOfHeight,
	
	/** Its recommended to either not include height in id or use isHeightHasMoreDigits (1 bit) with lowNBitsOfHeight (such as 31 or 63 bits),
	instead of this allDigitsOfHeight, cuz limiting height complicates the universalFunc math.
	For example, if you include isHeightHasMoreDigits (1 bit) and lowNBitsOfHeight as 15 bits
	and height is bigger than that and some calculation asks what is height, that calculation has to compute it in interpreted mode
	where every param and return is a fn. If you limit height, you are using a different universalFunc math
	unless you define it as infinitelooping whenever try to create something higher than that, in which case
	it can be viewed as an infinitely inefficient implementation.
	*/
	allBitsOfHeight,
	
	hasStackfunc,
	
	hasStackparam,
	
	hasCachekey,
	
	/** related to isDeterministic and <func,param,return> caching or <isDeterminsitic,func,param,return> or salt or bloom.var or nondet op etc.
	A thing isZeroKelvin if it and everything needed to derive it contain no arbitrary data, instead are derived only from the small simple rules
	of the universalFunc. A thing is not zeroKelvin, for example, if you arbitrarily create <func,param,return> without deriving them,
	even if its done in a way that it will never contradict anything else, the existence of that cant be derived so adds info to the system
	so raises the number of possibilities therefore raises the entropy therefore raises the temperature.
	Entropy is log of number of possible states.
	In the p2p network, all data will be zeroKelvin so it syncs instantly since everything is only a cache derived deterministicly
	from the definition of the universalFunc itself, and if 2 computers on 2 opposite sides of Earth each create the same lambda function
	(including its internal forest shape in the definition of equality, not just param/return mapping)
	then its guaranteed those have the same id by every possible zeroKelvin idMaker function,
	so those computers, which have never communicated with eachother, generate the same id for the same lambda function,
	before light has time to travel between them, and when the info does reach eachother, usually in the form of
	lambdas being built as combos of many existing lambdas, its all instantly in sync,
	so whatever peers share with eachother fits together like clockwork instead of needing to blockchain-fork.
	A zeroKelvin blockchain NEVER forks and is always in 100% agreement faster than light,
	and its not actually a blockchain but technically is a merkle forest, which blockchains are a kind of,
	and is not a way to change things over time but is a cache of the facts of if you call lambda x on lambda y it returns lambda z,
	and if you want to change things over time you can choose a lambda at each time to represent the state you believe in at that time,
	and you can include that lambda, or various data structures about it, in a growing set of a publicKey
	such as by ed25519 or ed448 digitallySigning it.
	*/
	isZeroKelvin,
	
	/** This is normally not included in ids cuz leaf is represented as the only made up hash (such as all 0s) in constSizeHashOrLiteral */
	isLeaf,
	
	/** 1 of the childs, like func, param, stack, cacheKey, isParentsFunc.
	This is what allows callpairs to see and use every part of callquads (isMeta or !isMeta) for efficient selfEmulation
	and proving to the occamsfuncerVM that everything that emulator does obeys the universalFunc math.
	See the metaOps in OcfnUtil such as OcfnUtil.step, OcfnUtil.lazyCall, ocfnUtil.cacheKey,
	ocfnUtil.stack, OcfnUtil.asCallPair, OcfnUtil.asCallQuad, etc.
	*/
	isMeta,
	
	isCbt,

	/** true when isCbt and is not all F/0, cuz a bitstring is a cbt
	padded with T/1 then Fs/0s until the next powOf2 size (not stored that way, just in abstract math)
	*/
	isBitstring,
	
	/** If your model of lambdas has a max bitstring size (not recommended, cuz it complicates the math),
	you can use this instead of lowDigitsOfBize with bizeHasMoreDigits.
	*/
	allDigitsOfBize,
	
	/** see lowDigitsOfBize */ 
	bizeHasMoreDigits, //TODO rename all bit fields to is* 
	
	/** bitstring size or the low n digits of it. Example: sign bit is bizeHasMoreDigits and the 63 lowest digits of bize */
	lowDigitsOfBize,
	
	/** See fn.zigzag(). Ptr into a cbt, using binheap addressing, like 1 is theCbt, 2 is theCbt.L, 3 is theCbt.R, 4 is theCbt.L.L, and so on.
	This is normally lowDigitsOfBize+1 bits, such as storing bizeHasMoreDigits+lowDigitsOfBize in a long and zigzag in another long
	so it can represent bitstrings up to around a petabyte (2^60 bits) and refer to any powOf2 aligned subrange of it in a single id.
	The whole bitstring's id can be derived from any of its powOf2 aligned subrange's id cuz its zigzag is 1 and all other parts of the id are the same,
	will have to choose an order or priority between idOfIdDepth, pairOfPairDepth, and zigzag (TODO see comments in fn.zigzag() etc
	cuz I think I already decided that todo copy that here). 
	*/
	zigzag,
	
	/** see comment at top of MonkeyId256.java */
	zigzagWithBitIndexAsHeight,
	
	/** true if the zigzag bits > 1. This makes unnecessary to read zigzag (similar to isBitstring makes it unnecessary to read lowDigitsOfBize or bizeHasMoreDigits),
	so the first int or long in the id tells all the branching info.
	*/
	isZigzag,
	
	/** If true, bize number of bits come after the id, with no padding since its stored bit aligned. */
	isBlobNoPad,
	
	/** If true, bize number of bits come after the id, then pad it with 1 then 0s up to the next byte. */
	isBlobPadToByte,
	
	/** If true, bize number of bits come after the id, then pad it with 1 then 0s up to the next int. */
	isBlobPadInt,
	
	/** If true, bize number of bits come after the id, then pad it with 1 then 0s up to the next long. */
	isBlobPadLong,
	
	/** This has no effect on if stack and cacheKey are null, leaf, etc. This is how to interpret the childs, as in the metaOps in OcfnUtil. */
	isMetaCallPairVsQuad;

}