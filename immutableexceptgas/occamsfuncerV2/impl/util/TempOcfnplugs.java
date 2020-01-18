package immutableexceptgas.occamsfuncerV2.impl.util;
import static immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic.*;
import immutableexceptgas.occamsfuncerV2.fn;

/** these are temporary cuz hopefully will eventually
make occamsfuncer advanced enough to port these to user level code,
which may be automatically optimized or manually optimized in
occamsfuncerVM code. Its ok to fork an occamsfuncerVM to
put in optimizations cuz it doesnt change its behaviors, only speed,
so its still compatible. It breaks compatibility for different
occamsfuncerVMs to have different funcs that start with ocfnplug*,
and the way systems go that complexity usually grows out of control
and things dont get standardized precisely.
It breaks into more and more different kinds of programs,
instead of being unified by a single programming language
they're all user level code of.
<br><br>
I'm putting a few things I need here while building occamsfuncerVM.
*/
public class TempOcfnplugs{
	
	public static fn ocfnplugDoubleMultiplyRaw(fn madeByCurry){
		fn x = getParam(4,madeByCurry);
		fn y = getParam(5,madeByCurry);
		return doubleToBitstring(x.doubleAt(0)*y.doubleAt(0));
	}
	
	public static fn ocfnplugDoubleAddRaw(fn madeByCurry){
		fn x = getParam(4,madeByCurry);
		fn y = getParam(5,madeByCurry);
		return doubleToBitstring(x.doubleAt(0)+y.doubleAt(0));
	}
	
	/** doubles are prefixed by a contentType */
	public static fn ocfnplugDoubleMultiply(fn madeByCurry){
		fn x = getParam(4,madeByCurry);
		fn y = getParam(5,madeByCurry);
		return f(x.R().doubleAt(0)*y.R().doubleAt(0));
	}
	
	
	/** TODO move most of this huge comment to Todo.java
	<br><br>
	hash by doubleSha256 (multihash type-andmaybelen-prefixed)
	EXCEPT that certain constants are needed.
	This will be 36 bytes and be returned in a wrapper of int[9]
	which will make it efficient for use in trie-like treemap
	which is sorted first by height then by left recursively
	then by right recursively (as in acyc32)
	so bitstrings of same len always sort by bigEndian bits.
	<br><br>
	There will be a header before the multihash-type-andMaybeSize.
	Values of that header choose between:
	-- prefix then hash(concat(L().id(...),R.id(...),comment(...).id(...)), excluding the cbt1 padded at end of each bitstring.
	-- cbtRaw<of size 2^0 to 2^8> bits, and a bit to say if a 1 is appended (cbtBitstring)
	//-- cbtBitstring<of size 0 to 256 bits (not storing the last cbt1).
	-- cbtUnary of of height 0 to 2^31-1.
	//NO... just leaf -- maybe the first 677 <heightThenRecurseLeftThenRecurseRightSort> which
		are height0 to height4 (not including height of comment),
		which all have leaf as their comment/third child,
		so after that it must be counted as trinary instead of binary.
		and height5 and above is where comment is allowed to not be leaf.
		The first of those 677 (index 0) is leaf.
		All 16 opcodes and the commonly used ((..)(..)) are included.
	<br><br>
	Do I want this to be variable size (could just pad 0s to 36 bytes).
	Do I want these to fit in 256 bits?
	<br><br>
	Could simplify it by its either of these things:
	-- prefix then hash(concat(L().id(...),R.id(...),comment(...).id(...)), excluding the cbt1 padded at end of each bitstring.
	-- cbt of these specific 2^0 to 2^8 bits, concat this varint number of 1s, concat this varint number of 0s.
	<br><br>
	Or...
	-- prefix then hash(concat(L().id(...),R.id(...),comment(...).id(...)), excluding the cbt1 padded at end of each bitstring.
	-- cbt of 2^0 bits (no comment allowed in this form of storing it)
	...
	-- cbt of 2^8 bits (no comment allowed in this form of storing it)
	-- cbt of 2^9 bits but second half is a 1 followed by 255 0s (no comment allowed in this form of storing it)
	-- cbtUnary followed by an int32 of height (no comment allowed in this form of storing it).
	Do I want int32 height as part of the id? Would make it 40 bytes instead of 36.
	If prefix the whole thing with a multiformats-varint of number of bytes,
	then wouldnt need to store the hash size.
	<br><br>
	bitIsHash
	bitIsCbtUnary
	bitIsCbtBitstring
	bitIsCbtNormal
	<br><br>
	Do I want this to be compatible with the streamAppendable compression format
	I was considering where Call triples are appended and pointers can be relative
	to current stream size and a pointer can just refer to something earlier in stream
	to give it a nearer place to point at with smaller number
	and can append a cbtRaw by 0 10 110 1110 then powOf2 as many bits as len of that header?
	Do I want a place to put hashes even though they're locally named?
	Do I want a bit to say its the deduped form so any 2 objectAtStreamPosition
	that have the dedup bit are either at the same stream position
	or are different forest shapes or are a single pointer to give it a nearer place?
	Would need to have most of the same fields as in Call.java available
	such as each would be assigned a byte value as part of its header?
	Actually we dont need trinary calls for compression datastruct
	cuz can build trinary calls from binary calls.
	All thats really needed is leaf, pointerToOneToGetItNearer, binary call, cbtRaw,
	and maybe also shortcuts to certain common forest shapes such as the 16 opcodes
	but those can be derived like...
	(..)#leafLeaf
	(. leafLeaf)#opBit0
	(leafLeaf .)#opBit1  
	(opBit0 opBit0)#opBits00
	(opBit0 opBit1)#opBits01
	(opBit1 opBit0)#opBits10
	(opBit1 opBit1)#opBits11
	Each of the 16 opcodes is a pair of 2 of those last 4 things,
	so its not alot of extra stuff.
	...
	First 2 bits choose leaf, pointerToOneToGetItNearer, binaryCall, cbtRaw.
	leaf ends at those 2 bits.
	pointerToOneToGetItNearer is followed by a ptr.
	binaryCall is followed by 2 ptrs.
	cbtRaw is followed by 111..10 then 2 exponent that many bits (number of bits in 1...0).
	What is ptr datastruct? Must be varsize. It could be a cbtRaw uint,
	but that seems wasteful since it has to be a powOf2 size.
	A trinary number would be best, but that doesnt fit well in a binary stream.
	Could use a base3 uint of digits 00 01 10 and 11 ends it,
	and it always points backward in the stream.
	Dont actually need a representation of leaf since the start of stream
	could always be leaf.
	Instead of leaf being 1 of the 4 types,
	generalize that to choose forest shape by their well-defined mapping
	between nonneginteger and forest (where its binary forest up to height 4,
	only counting the L and R branches,	and trinary forest above that),
	and the number format will be the base3 used in ptrs,
	and maybe abstractly we could represent that as prefix of stream
	is all infinity of those possible nodes 1 bit each?
	...
	00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	01 callPair ptr ptr <each ptr: digits 00 01 10, end 11>
	10 pointerToOneToGetItNearer
	11 cbtRaw <111...10 then 2 exponent that many bits number of more bgits>
	...
	00 chooseFromSortedForestShapes
	01 callTriplePair ptr ptr ptr //leaf is 0011 aka the smallest
	10 pointerToOneToGetItNearer
	11 cbtRaw
	...
	00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	010 callPair ptr ptr leaf <each ptr: digits 00 01 10, end 11>
	011 callTriple ptr ptr ptr <each ptr: digits 00 01 10, end 11>
	10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	11 cbtRaw <111...10 then 2 exponent that many bits number of more bgits>
	...
	Add a bit to all of those for is it deduped?
	How does that work with pointerToOneToGetItNearer?
	If a chain of pointerToOneToGetItNearers leads to a deduped,
	should the deduped bit on them mean leads to deduped?
	Should a chain of pointerToOneToGetItNearers be considered
	a single pointer? Should trees of pointerToOneToGetItNearers be banned
	but chains of them be allowed?
	NO, dedup bit interferes too much with pointerToOneToGetItNearers.
	...
	How about a bit for is it halted or not? Would only need that
	for callPair. callTriple is always halted.
	Technically you can detect if a certain call is already halted or not
	cuz the number of curries are well defined.
	...
	00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	010 callPair ptr ptr leaf <each ptr: digits 00 01 10, end 11>
	??? callPairEvaling ptr ptr <each ptr: digits 00 01 10, end 11>
	011 callTriple ptr ptr ptr <each ptr: digits 00 01 10, end 11>
	10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	11 cbtRaw <111...10 then 2 exponent that many bits number of more bgits>
	...
	Technically you can detect if a certain call is already halted or not
	cuz the number of curries are well defined.
	...
	00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	01 callPair ptr ptr <each ptr: digits 00 01 10, end 11>
	10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	11 cbtRaw <111...10 then 2 exponent that many bits number of more bgits>
	...
	Could have a nondet param be able to lookup an object by idType and id,
	and (nondet ;lookupByIdType idType) would be a single node #nameXYZ
	so you could get a node by id using (nameXYZ cbtRawOfItsId),
	except thats inefficient if the id is forexample 36 bytes not a powof2
	so maybe I want cbtRaw and cbtBitstring?
	On the other hand it only takes log number of callPairs extra per id,
	and call pairs are very small in this data format.
	...
	(Example.funcParamReturn() func param return) could be used to
	claim various fields about objects, such as int32 Call.java height
	or long of bitstring size if fits in bitstring,
	but would have to derive or lookup by nondet funcParamReturn
	to use it in a sparse collection of these compressed form of funcs,
	and the funcParamReturn would only be valid if it halts
	and until then its a claim that lazyEvalA called on lazyEvalB
	returns lazyEvalC, the claim itself being lazyEvaled and if it
	returns anything at all then it returns a
	(Example.funcParamReturn() func param return) and is a valid proof.
	...
	Maybe there should be an isHalted bit AND a bit for willCertainlyHalt
	and a bit for willCertainlyNotHalt (and may be uncertain of both)?
	IF isHaltedBit, then need to support callTriple.
	Dont need willCertainlyNotHalt bit.
	willCertainlyHalt bit would be enough, if it were trusted in each specific case,
	for a claim of lazyEvalA called on lazyEvalB returns lazyEvalC
	to be interpreted as a proof that is true before knowing what the lazyEvals
	return, and that way we can claim (or prove?) the id@idType of a certain
	node is a certain cbt.
	...
	Yes, I want a willCertainlyHalt bit.
	...
	hH00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	hH01 callPair ptr ptr <each ptr: digits 00 01 10, end 11>
	hH10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	hH11 cbtRaw <111...10 then 2 exponent that many bits number of more bgits>
	where h is willCertainlyHalt and H is willCertainlyNotHalt,
	cuz I dont want the lack of willCertainlyHalt to be interpreted ever
	as that its more likely it wont halt.
	...
	hH00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	hH010 callPair ptr ptr leaf <each ptr: digits 00 01 10, end 11>
	hH011 callTriple ptr ptr ptr <each ptr: digits 00 01 10, end 11>
	hH10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	hH11 cbtRaw <111...10 then 2 exponent that many bits number of more bgits>
	...
	How about instead of cbtRaw, ONLY allow cbtBitstring,
	and if you want a cbtRaw you store a cbtBitstring and call L on it?
	Yes, do that.
	And for the size prefix, use <digits 00 01 10, end 11>.
	...
	hH00 chooseFromSortedForestShapes <whichForestInt: digits 00 01 10, end 11>
	hH010 callPair ptr ptr leaf <each ptr: digits 00 01 10, end 11>
	hH011 callTriple ptr ptr ptr <each ptr: digits 00 01 10, end 11>
	hH10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	hH11 cbtBitstring <digits 00 01 10, end 11> size then that many bits.
	...
	hH00 is leaf
	hH01 callPair ptr ptr <each ptr: digits 00 01 10, end 11>
	hH10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	hH11 cbtBitstring <digits 00 01 10, end 11> size then that many bits.
	...
	Do I want one of those to be funcParamReturn ptr ptr ptr
	which may (depending how people and computers interpret it
	as this is a way to evolve merkle computing systems
	not a specific universal lambda...)...
	its node would be a (Example.funcParamReturn() func param return)
	so L of L of L of it would be Example.funcParamReturn()?
	If that halts (as claimed by hH) then its claimed that
	func called on param returns that "return",
	even if some of all of those parts are lazyEvaled.
	I could get rid of leaf and put funcParamReturn in and still
	have just 4 top level things. But I do want a leaf.
	So I guess I need 5 things at the top.
	Maybe put callPair and funcParamReturn together...
	...
	hH00 is leaf
	hH010 callPair ptr ptr <each ptr: digits 00 01 10, end 11>
	hH011 funcParamReturn ptr ptr ptr <each ptr: digits 00 01 10, end 11>
	hH10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	hH11 cbtBitstring <digits 00 01 10, end 11> size then that many bits.
	...
	Maybe allow cbtBitstring and cbtRaw...
	...
	hH00 is leaf
	hH010 callPair ptr ptr <each ptr: digits 00 01 10, end 11>
	hH011 funcParamReturn ptr ptr ptr <each ptr: digits 00 01 10, end 11>
	hH10 pointerToOneToGetItNearer <each ptr: digits 00 01 10, end 11>
	hH110 cbtRaw 111...10 then 2 exponent that many bits.
	hH111 cbtBitstring <digits 00 01 10, end 11> size then that many bits.
	...
	...
	TODO use this to compress an example of that sound which sounds like its
	changing frequency (cuz of fading in gradually changing frequency
	then fading out per note and many notes at once)
	but actually is same average frequency at each moment.
	...
	...
	How about at depth3 theres 6 ops:
	Pair
	S
	TAkaK
	L
	R
	isLeaf
	FIXME still need typeList cuz theres no curry, getp, or recur ops.
	...
	How about these 6 (at height 3)...
	..
	Pair
	Iota //represented in memory/internet/storage as (Pair S K) but abstract math is like iotavm/iotadesktop
	L
	R
	isLeaf returns K (aka true/first) or (K I) (aka false/second) both derived from Iota.
	typeList
	..
	Do I need both pair AND typeList?
	...
	How about these 6 ops (at height 3):
	..
	S
	K
	L
	R
	isLeaf
	typeList
	..
	height 3... "Level3 has 26 binary forest shapes."
		.
		(..)
		(.(..))
		((..).)
		((..)(..))
	But only 9 of those can consistently refer to those below,
	those 9 being all ordered pairs of (.(..)) and ((..).) and ((..)(..)).
	..
	I wish I could squeeze it into 3: (.(..)) and ((..).) and ((..)(..)) directly.
	..
	Maybe I should use Pair instead of typeList, since Pair can be used to
	derive Curry Getp and Recur ops or more efficient variants of them.
	..
	Pair //curried iota cant be derived efficiently without this
	Iota
	L
	R
	isLeaf //returns K (aka true/first) or (K I) (aka false/second) both derived from Iota.
	..
	Any 5 ops could consistently map tofrom:
	((.(..))(.(..))) //00 at height 3
	((.(..))((..).)) //01 at height 3
	(((..).)(.(..))) //10 at height 3
	(((..).)((..).)) //11 at height 3
	((..)(..)) //whats normally typeList in occamsfuncerV2 at height 2
	...
	typeList/unlimitedsizelist
	Iota
	L
	R
	isLeaf //returns K (aka true/first) or (K I) (aka false/second) both derived from Iota.
	???
	...
	If we have unlimitedSizeList then could use that with L and R
	to get whatever ops out of it
	if define 1 of the 3 things at height 2 as a constant
	certain unlimitedSizeList with params.
	...
	...
	(that has nothing to do with idMaker_doubleSha256_orCbtOrBitstringOrUnary
	so TODO move those comments about the compression datastruct somewhere else).
	*/
	public static fn ocfnplug_idMaker_doubleSha256_orCbtOrBitstringOrUnary(fn madeByCurry){
		$(1000); //TODO more precise estimation of cost
		fn getMyId = getParam(4,madeByCurry);
		if(getMyId == leaf){ //hash part is all 0s
			throw new Error("TODO");
		}else if(getMyId.isCbt()){
			if(getMyId.isUnaryCbt()){
				int h = getMyId.height();
				throw new Error("TODO");
			}else if(getMyId.isBitstring()){
				/*FIXME, a cbtbitstring is a cbtRaw but we just dont store the 0s at end
				Theres only 1 case when we need to store it differently than cbtRaw,
				and thats when its a cbtBitstring of size 256 
				cuz that takes 257 bits to store the last 1,
				so in header byte just have a bit for is a 1 appended or not.
				*/
				throw new Error("TODO");
			}else{
				throw new Error("TODO");
			}
		}else{ //doubleSha256 of ids of 3 childs
			throw new Error("TODO");
		}
	}

}
