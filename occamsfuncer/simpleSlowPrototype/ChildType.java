package occamsfuncer.simpleSlowPrototype;

/** At most 4 of the pointer childs (func, param, stack, cacheKey, blob) have to be stored at once,
and those which arent stored are a compression of those childs being leaf.
Theres a few bit childs (including isZeroKelvin, isCallPair, isHaltedAbove, isParentsFunc)
which are always stored. The zigzag might be stored as an int64 (TODO choose design).
The goal is that the hashing of ids will fit in 1 sha3_256 cycle (max 135 bytes) for callpairs
and max 2 sha3_256 cycles (max 271 bytes) for callquads.
OLD...
These are the childs of an 8-way-forest(all paths lead to the same leaf) node that affect its id,
if you include nodes during evaling, but if you only include isDone nodes then all you need is func and param childs.
This doesnt include isLeaf cuz thats 1 specific node, has a constant id for any idMaker.
Normally whats shared across untrusted borders (such as on p2p network)
is only the func and param binary forest of call pairs, leaving the other childs for evaling locally
and whats created by that evaling can be shared as its stack and cacheKey are null.
*/
public enum ChildType{
	
	/* UPDATE: will use bin.java for this later, and for now maybe the fn will take a concat of 4 params and a cbt4 or something like that,
	so even though fn cant see all the child fns, it can see their ids.
	<br><br>
	FIXME for ocfn to be able to create ids of callquads/callocts, using any custom id func,
	it must be only a binary forest, so use first param being (leaf leaf) to reflect callquads/callocts,
	and have those 1+8 curries include other callocts etc, and maybe use first param as leaf
	in cases when stack and cacheKey are null. Its more reflective that way.
	Without this, new idMakers can only create ids for halted funcs instead of callocts too,
	and you need callocts for eval.
	*/
	
	/** never null. If isLeaf(this) then this.func is IdentityFunc and this.param is this. */
	func,
	
	/** never null. If isLeaf(this) then this.func is IdentityFunc and this.param is this. */
	param,
	
	/** leaf if null. Nonnull if isParentsFunc|isParentsParam. */
	stack,
	
	/** leaf if null. Null only if isCacheKeyNull. */
	cacheKey,
	
	/** I named this isZeroKelvin cuz temperature is strongly related to entropy,
	and entropy is log of number of possible states.
	True if this could be derived from things that have only 1 possible state (even if it was derived from
	nondet call AND derived from pure deterministic calls both of which led here, it only needs at least 1),
	therefore can sync faster than light since everyone who derives the same objects would derive the same ids for them
	before communicating with eachother, which instantly syncs when that info does reach eachother,
	syncs with everything thats also isZeroKelvin thats derived from it.
	False if this is part of an evaling state of nondet or <!isZeroKelvin,func,param,return>s derived from it.
	*/
	isZeroKelvin,
	
	isHaltedAbove,
	
	isParentsFunc,
	
	//isParentsParam,
	
	//isCacheKeyNull,
	
	/** used with zigzag. If this is not leaf, then the id of a pointer into the blob
	is the blob's id forkEdited to have the pointer's zigzag bits,
	and the blob's id can be derived from that since its zigzag is always 1.
	*/
	blob,
	
	/** FIXME is this var size cbt (inefficient even if optimized to primitive cuz must store ptr in some cases)
	or is this a constant size such as 64 bits? And what if its stored in less bits than that in some id types
	so they must store the rest of the bits in their content to be hashed if its exceeded?
	Maybe I should just go with 64 bits (up to 63 hops) and use 56 byte ids instead of 48?
	*/
	zigzag,
	
	//"FIXME emuOfEmuDepth or something like that. maybe just an extra pairlike datastruct in some places instead? todo copy my writing about those possible designs (ocfnreflect mindmap) here after choose a design."
	
	/** true if have proven, and choose to use (instead of cacheMiss metaop
	forkEditing this to false, or not cacheHit metaOp forkEditing this to true else some
	constant whose isUseCacheHit is false):
	[possibleCache.cacheKey.L.equals(evalingState.L) && possibleCache.cacheKey.R.equals(evalingState.R)]
	in the node ((checkingEqualityBeforeStep evalingState) possibleCache)
	 */
	isUseCacheHit,
	
	/** see OcfnUtil.asCallPair vs OcfnUtil.asCallQuad and emuOfEmuDepth */
	isCallPair;
	
	/*TODO make sure this is compatible with fprQuines doing tailRecursion which may be needed to close the quine.
	It probably is already and that would just be a small adjustment (if its not already compatible) in step func.
	*/

}
