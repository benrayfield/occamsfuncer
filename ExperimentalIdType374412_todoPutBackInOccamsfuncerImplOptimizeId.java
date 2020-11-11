
import static immutable.occamsfuncer.impl.optimize.id.IdField.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** this experimental id type has a random name. Will choose a shorter name of whichever id type I end up using
after the system is working better.
<br><br>
448 bit id. Fits in long[7].
*/
public class ExperimentalIdType374412_todoPutBackInOccamsfuncerImplOptimizeId{
	private ExperimentalIdType374412_todoPutBackInOccamsfuncerImplOptimizeId(){}

	
	//public static final IdType idType = idTypeFromList(
	public static final List idType = Collections.unmodifiableList(Arrays.asList( //FIXME use idType instead
		
		//This first section should be 32 bits
		constant, 1, //first bit is always 1, so if its not then its some other datastruct, expected to try many of them for various optimizations in p2p network
		idOfIdDepth, 4,
		//If perfect dedup per callquad/callpair, thats 0 (dedupPerCallQuad).
		//If any zigzag node is reachable from here, its 1 (dedupPerCallquadOrPtrIntoBlobwithid).
		//2 (dedupPerCallquadOrPtrIntoBloblazy) and 3 (allowAnyDup)
		//are normally not used but are here just in case. See the 4 deduplevels in fn.DedupLevel.
		dedupLevel, 2,
		isBlobPadLong, 1, //This is how you store large arrays.
		//TODO isLiteralThatFitsInId isHashId, or can you derive those from log2OfLiteralCbtSizeButMaxMeansOther being the "other"?
		isMadeUpId, 1,
		curriesLeft, 4, //FIXME what if its evaling
		pairOfPairDepth, 6,
		log2OfLiteralCbtSizeButMaxMeansOther, 4,
		isZigzag, 1,
		
		
		
		
		isMetaCallPairVsQuad, 1,
		
		
		
		
		
		//If (UPDATE: just check isCallPair instead of)
		//!hasStackFunc && !hasStackParam && !hashCacheKey && !isBlob* and if its a hash id, then the hash is sha3_256 of
		//concat of func and param childs which fits in 1 sha3_256 cycle, else if its a callquad then that hash fits in 2 cycles.
		//If isBlob* then its the same hash which is from a hash tree of powOf2 size blob (caching the parts that are all 0s
		//we already know their hashes upward except where they meet the nonzeros).
		hasStackfunc, 1,
		hasStackparam, 1,
		hasCachekey, 1,
		isZeroKelvin, 1,
		isCbt, 1,
		isBitstring, 1,
		hasOpcode, 1,
		
		isHeightHasMoreDigits, 1,
		lowNBitsOfHeight, 31,

		//do this in Compiled.java
		//currysIsLeaf, 16,
		//currysIsLeafLeaf, 16,
		
		bizeHasMoreDigits, 1,
		lowDigitsOfBize, 63,
		
		zigzag, 64,
		
		constSizeHashOrLiteralOrMadeupid, 256
	));
	
	/*FIXME instead of isBlobPadLong
	want a way that can store any subrange, or maybe just powOf2 size subranges, of a blob, especially if its too big to fit in memory,
	and might want a way to have id[] instead of bit[] so can have a higher branching factor tree of blobs
	with zigzag referring to a few levels up. Of course callquad/callpair can store every internal node, and literal up to 256 bits,
	of a blob without storing any part of the blob larger than an id and its small constant number of childs (2-4 ptrs and a byte, basically).
	*/
	

}
