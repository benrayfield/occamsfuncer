/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.ocfn3s.prototype;
import immutable.occamsfuncer.ocfn3s.spec.Compiled;

public final class Node{ //TODO rename to Call
	
	/*Fit ALL 7 Ufun types into same 256 bit id.
	
	FIXME what should go in this 64 bit header? Look thru the list of planned optimizations.
	-- 48: low bits of bitstring size.
	-- 1: bit for is bitstring size bigger than fits in header (must then compute sizes as the universalFunc instead of using cache in header).
	-- 1: isHalted
	-- 1: isParentsFunc
	-- 1: isDeterministic
	-- 1: isUnary
	-- 4: cardinality if its 0 to 14, else 15 means is higher cardinality than that.
	-- 3: bits for the pair optimization, how deep in pair of pair... of pair.
	-- 3: depth of id of id of id... cuz 256 bit id can only hold up to 128 bits of literal data, or 256 bits of same bits minus 1 in this uint4.
	-- 1: bit is always 0, used in hashing algorithms that replace it with 1 to tell how many objects are being hashed?
	TODO might want to cache (isLeaf x) for x being this.func and this.func.func and this.func.func.func...
		as far as universalFunc always curries 10 params. Look in *sparseTuringMachine*OcfnUtil for exactly how deep would need that.
		But maybe dont need that cuz of Compiled.java. 
	TODO might want an int4 for curry depth, but only for halted nodes so its limited to 0-9. 
	TODO might want 9 or 10 of the 32 id bytes for header, leaving the rest for hash (likely not secure enough if smaller than 24 bytes),
		For extra security that hash is last 192 bits of sha256(input)+sha256(input+salt) where salt might for example be
		the first 512 binary digits of of 1/e. That way, to crack it you have to find 2 sha256 collisions at once.
	The bits other than header (totalling 256 bits) are 1 of:
		+++ up to 128 bits of literal data (cbt up to 128 or cbtBitstring up to 129)
		+++ secureHash of concat of id(Node) for the 5 pointers at other Nodes,
			but somehow I want to not include those that are null and instead just include a single bit for those.
	The compareCardinality could in nearly all cases be very compressed since its basically a pair of 2 nonnegative integers,
		BUT it has to support integers of unlimited size.
	/*
	public final long header;
	
	public final Node func, param;
	
	//public final Node func, param, stack, cacheKey, compareCardinality;
	
	private Compiled compiled;
	*/

}
