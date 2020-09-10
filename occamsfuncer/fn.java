/** Ben F Rayfield offers this software opensource MIT license */
package occamsfuncer;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;

import occamsfuncer.simpleSlowPrototype.OcfnUtil;

/** fn and Bloom are 2 ways of using the same thing. As of 2020-8-31 Bloom is very experimental and incomplete.
This is the core object type in occamsfuncer. Using the lambda symbol (λ) cuz
its a universal lambda function and pattern calculus function. (renamed from fn.java)
Theres an immutable layer of all possible functions, with an optional mutable/NondetNode layer above them for efficiency.
Only the immutable functions are shared on internet cuz they never have errors nor state to sync.
This is a function or snapshot of stack state during eval. Stack state costs bigO(1) per step. Data is made of functions,
such as complete binary tree of pairs of T or F padded with T then 0 or more F up to next powOf2, is a bitstring.
T is the lambda Lx.Ly.x, and F is the lambda Lx.Ly.y.
All functions are made of combos of the universal function aka leaf, which has 15 params, described in occamsfuncerSpec.txt.
Can wrap arrays in a function, such as double[] int[] FloatBuffer for efficiency.
Wrapped objects must still have usable L(), R(), and lambda functions,
plus in some cases they can be used in combo with other optimizations directly as arrays.
Wrapped objects normally use lazy dedup, but if you get an id on them (from any idMaker func) everything dedups exactly,
such as happens when used as a map key.
*/
public interface fn extends UnaryOperator<fn>{
//public interface fn<FuncType extends fn<FuncType>> extends UnaryOperator<FuncType>{
	
	/** This funcjump/j aka step with metaOps, and isLeaf, are the only functions you need for turingCompleteness.
	Its named j cuz its called so often.
	It always halts for constant cost IN UNITS OF calls of equals,
	which has average constant cost but worst case of number of objects reachable
	if it triggers lazyEval of creating ids for all those objects.
	The only time it needs to check equality is ((step evalingState) possibleCache) where it checks if
	evalingState.isHaltedAbove && possibleCache.cacheKey equals (evalingState.L evalingState.R),
	aka possibleCache.cacheKey.L.equals(evalingState.L) && possibleCache.cacheKey.R.equals(evalingState.R).
	Since in memory it normally runs at DedupLevel.dedupPerCallquadOrPtrIntoBloblazy,
	but equality must be compared by DedupLevel.dedupPerCallquadOrPtrIntoBlobwithid
	(which DedupLevel.dedupPerCallquad is a statement about dedupPerCallquadOrPtrIntoBlobwithid
	that no zigzag>1 are reachable, but metaOps could still create them), and it runs
	at that looser DedupLevel for efficiency of wrapping arrays without hashing them yet if ever...
	Since it normally runs at a looser DedupLevel than equality must be compared at,
	theres a risk of triggering lazyEval of dedup to the stronger level,
	whenever you call this func (depending if its a step.j(y).j(z)
	and it cant be trivially determined that they're equal or not equal in Compiled.java.
	<br><br>
	Alternatively, you can actually run at DedupLevel.dedupPerCallquadOrPtrIntoBloblazy in memory
	if you hash all array contents right away, which makes the system much slower for CPU calculations
	but nearly the same speed for GPU calculation since ids can inTheory be computed in GPU
	at a speed that would let you tree-hash a 10 megabyte array in .01 second,
	or however fast you could call sha3_256 in log2 number of sequential steps to tree-hash that.
	The problem is GPU can only be called a few hundred times per second on large chunks of work.
	<br><br>
	You could implement dedup slightly lazy with a very short delay by
	every .01 second you take whatever fns dont have ids but their childs do,
	and create an array of blocks of [func param stack cacheKey and few other small things]
	and send that array into GPU which after .01 second gives you the id of those,
	so you could dedup things as fast as GPU as long as it only grows upward much slower,
	and when you find 2 fns have the same id, you use whichever was created first as the normed form
	and put a pointer to it in the other, and often replace fns with their normed form if they have it.
	<br><br>
	Its far more efficient to check for equality using ==, and if they equal that way,
	it proves they certainly equal at all DedupLevels,
	else its unknown so dont use that cache and instead debugStepInto and check cache there.
	Duplicates mostly happen when the same array is created by an optimized process,
	such as matrix multiply in GPU, without hashing it, or when an object comes in from Internet
	which has an id but comparing it against objects id hasnt been computed for yet
	(ids are always perfect dedup even if computed on different computers).
	If wrapped arrays always came with id instantly,
	and only accepted fn from internet after matching its childs to any fns that may exist here,
	then all dedup would be perfect. But it would probably be too slow.
	<br><br>
	The logic of callPairs doesnt need equality checking and only compares if something is a leaf or nonleaf,
	but can be very much optimized by partial or perfect equality checking. 
	*/
	public default fn j(fn param){
		throw new Error("TODO for future expansion where first of 15 params is (leaf leaf), for the metaOps such as asCallPair, asCallFunc, step, lazyEval, cacheKey, stack, stackDown, isUseCacheKey, etc.");
	}
	/*Maybe I should add another forest child thats a bit that can only be set to true
	by proving [possibleCache.cacheKey.L.equals(evalingState.L) && possibleCache.cacheKey.R.equals(evalingState.R)]
	in the node ((checkingEqualityBeforeStep evalingState) possibleCache)
	then (step ((checkingEqualityBeforeStep evalingState) possibleCache))->whatStepNormallyReturns
	else some constant if equality wasnt proven.
	Or maybe a small amount of binheapIndexing for proving equality of things,
	like a node that knows this.L.L.R==this.R and knows this.L.R.L.L.R==this.R.R.L
	so that can be translated during other constant cost transitions which move it around
	but remember where some of the equalities are,
	and somehow, in abstract math at least, create those upward from any 2 things that need to be compared,
	from their parts upward. Sounds expensive, but it could be optimized away in many cases
	when equality can be proven by a Compiled.java, which brings back the need to use nondet
	which I'm trying to avoid. But maybe theres a way to do it deterministicly.
	Imagine that every node x has byte[16] where pairs of bytes tell 2 things that are known to equal
	as binheap/zigzag address from x, so it could refer to anything 0-7 levels down,
	and refer to 8 such pairs.
	or hopefully could be done with far fewer bits. Only need to do that for 1 specific case:
	[possibleCache.cacheKey.L.equals(evalingState.L) && possibleCache.cacheKey.R.equals(evalingState.R)]
	in the node ((checkingEqualityBeforeStep evalingState) possibleCache).
	In the bigO, a question is often far cheaper to ask than to answer,
	such as NPHard math or what does a function call return, so there is still benefit in the bigO
	of comparing equality by all parts recursively to compare a cacheKey,
	BUT it would be many times slower, and I want a more direct solution.
	I could, at least in abstract math, cause the 2 things that need to be compared for equality
	to both be childs of the same node, and to metaop from there after an equality bit is set,
	but how to prove the bit should be set, efficiently, is the problem...
	In general, we might have 2 bits for certainlyEquals and certainlyNotEquals between every
	pair of childs in a node, and you only cause whichever of them to be set that you want
	to pay to calculate (by combos of other metaOps).
	
	Its a bloomFilter. It doesnt matter as much if its nondeterministic, compared to mutable systems,
	cuz it can still only create the same set of fns in the bloomFilter, just might create them
	from different combos, like every path thru debugStepOver vs debugStepInto
	leads to the same return if it ever returns.
			
	What if every (fn,fn)->fn has worstCase constant cost EXCEPT one that,
	for example, forkEdits a bit in x that means x.L.equals(x.cacheKey),
	and such ops would exist for every possible pair of childs
	(a small constant number of pairs since theres a small constant number of childs per fn),
	and that op is deterministic in what it returns but may
	trigger lazyEval of ids recursively (instead of step triggering that).
	
	SOLUTION:
	There will be these 2 metaOps, one of which must check forest shape equality
	and is constant cost if everything is instant hashed but in practice
	there will be lazy dedup so some parts will trigger lazyEval of dedup,
	but nondeterministic code can ask if they're known to be equal vs unknown if equal vs nonequal.
	The important part is that every (fn,fn)->fn halts in average constant time.
	The 2 new metaOps are...
	cacheHit //step would do debugStepOver
	cacheMiss //step would do debugStepInto
	I'm undecided which of these should be merged: [cacheHit cacheMiss step stepIn stepOver].
	This design requires another bit (isUseCacheHit) child of all forest nodes, thats 1 only if its proven they are a cacheHit.
	A cacheHit is a certain (TODO choose a datastruct) combo of evalingState and possibleCache.
	cacheMiss forkEdits that datastruct's isUseCacheHit to false.
	cacheHit forkEdits that datastruct's isUseCacheHit to true IF that .equals
		ELSE returns some constant whose isUseCacheHit is false.
		WARNING: the cacheHit metaOp has average constant cost but
			worst case of triggering lazy dedup of reachable objects recursively, just once, which they remember.
	*/
	
	
	
	public default fn apply(fn param){
		return e(param);
	}	
	
	
	/** always halts in constant time. similar to debugStepOver or debugStepInto etc,
	depending on small depth into childs.
	*
	public default fn apply(fn param){
		return step(param);
	}*/
	
	/*FIXME merge this, maybe just in OcfnUtil.step (a new step func that only takes 1 fn param but does what the (untested 2020-9-3) step(fn,fn) does)
	so the metaOps work as fns that always (callquad,callquad)->callquad in bigO(1) except for the need to call equals func
	which when optimized with == and whats being checked actually does equal and its the same one at dedupPerCallquadOrPtrIntoBloblazy level
	(which is not the only way it can equal but will work over 99.99% of the time on average, as an optimization to run on local computer
	but when crossing untrusted borders we use stricter deduplevel of either
	dedupPerCallquadOrPtrIntoBlobwithid(perfect except lazy deduped blobs have perfect ids) or dedupPerCallQuad(perfect)).
	*/
	
	/*(func param stack cacheKey isHalted isParentsFunc isParentsParam isCacheKeyNull)
	see Node in spec comment about these 8 necessary childs for step func to be bigO(1).
	*/
	
	/** a.ff(b,c,d,e) is (a b c d e) aka ((((a b) c) d) e).
	This allows optimizations such as ((lazyCall x) y) to go directly to halted (x y) without creating (lazyCall x),
	and probably some temp objects to skip creating while using a fn c as cache <c.cacheKey.L,c.cacheKey.R,(c.L c.R)>.
	*
	public fn f(fn... sequence);
	
	/** Same as ((lazyCall this) param). lazy lambda call (dont eval yet. call e() to eval). */
	public fn f(fn param);
	
	/** same as x=((lazyCall this) param) then x=(step x) until (isDone x), using cache nondeterministicly
	as optimization (whichever <func,param,return> may be cached (as callquads, see OcfnUtil.cacheVal(fn))
	to compute a deterministic result, the same calculation and caching you could do deterministicly
	if you had pointers to the fns that are the cache (which are a inefficient to use as map keys cuz triggers hash id).
	WARNING: may never halt. nonlazy/eval lambda call. Use wallet and spend ops to limit compute resources.
	*/
	public default fn e(fn param){
		return f(param).e();
	}
	
	/** eval this. WARNING: may never halt. Eval this, without modifying this. If this is already evaled, returns this. */
	public fn e(); /*{
		fn evalingState = this;
		while(!evalingState.isDone()) evalingState = step(evalingState);
		return evalingState;
	}*/
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn func();
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn param();
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits */
	public fn stack();
	
	/** the 4 childs are func, param, stack, and cacheKey, and a few bits.
	<isZeroKelvin,func,param,return> caching: <?todoChooseADesign?,c.cacheKey.L,c.cacheKey.R,(c.L c.R)>
	*/
	public fn cacheKey();
	
	/** renamed !isCallPair to isMeta, meaning interpreted as a metaOp of all callquad fields, vs calling it evals (in steps) as a callPair.
	See OcfnUtil metaOps such as asCallPair asCallQuad cacheKey stack stackDown lazyCall step, etc.
	<br><br>
	OLD:
	This is a child, same as func, param, stack, cacheKey, and isParentsFunc.
	isHaltedAbove is a cache that may also be a required child in some kinds of ids.
	see OcfnUtil.asCallPair and .asCallQuad and .isCallPair and .metaNil.
	*/
	public boolean isMeta();
	
	public boolean isLeaf();
	
	/** is about to return from above (on stack) or is such a return value, ignoring what may be left to do lower on stack */
	public boolean isHaltedAbove();
	
	/** isHaltedAbove and nothing below in stack left to do */
	public boolean isDone();
	
	/** isParentsFunc. If true, stack().func()==this. If false, nothing about that is implied. */
	public boolean isParentsFunc();
	
	/** isParentsParam. If true, stack().param()==this. If false, nothing about that is implied. */
	public boolean isParentsParam();
	
	public default boolean hasCacheKey(){
		throw new Error("TODO should cacheKey() and stack() be leaf/u instead of null? Verify theres no valid way for them to be leaf so can use it as a null constant in those 2 cases, which probably is true.");
		//return !cacheKey().isLeaf()
		//return cacheKey() != null
	}
	
	public void setCompiled(Compiled c);
	
	public Compiled getCompiled();
	
	/** true if this is the normed form of the forest shape this object represents.
	False if this includes any PtrIntoBlob (TODO what to name it?) which is a wrapper of an array or File etc and
	an int64 binheap pointer into it that says which powOf2 aligned part of it.
	<br><br>
	Use this with Set<fn> twins(), norm(), unwrap(), and zigzag().
	*
	public boolean isNorm();
	*/
	
	public DedupLevel dedupLevel();
	
	/** this may be very expensive but its average cost is constant, and its a large constant.
	forkEdits this fn, deterministicly if going to stricter DedupLevel (lower DedupLevel_as_enum.ordinal()),
	possibly nondeterministicly if going to looser DedupLevel,
	since forExample if a DedupLevel.dedupPerCallQuad is viewed as dedupPerCallquadOrPtrIntoBlob
	then theres many possible blobs which contain the same subsetOfBlob and could be ptr into any of those.
	*/
	public fn setDedupLevel(DedupLevel d);
	
	/** UPDATE: isNorm() and norm() are being replaced by dedupLevel() and setDedupLevel(DedupLevel).
	see isNorm(). If nonnull, this is a mutable set of this fn and other fns which this fn is the normed form of.
	These all have different ids, but all have the same id of norm().
	FIXME make sure this doesnt prevent garbcol. Use Set<WeakReference<fn>> or WeakHashMap<fn,Boolean> mapping them all to true as a set?
		Beware that WeakHashMap may be much slower than HashMap or HashSet.
	*/
	public Set<fn> twins();
	
	/** UPDATE: isNorm() and norm() are being replaced by dedupLevel() and setDedupLevel(DedupLevel).
	float[], long[], FloatBuffer, String, File, CLMem, ipfs id, magnet url, etc, which zigzag() points into, else null
	*/
	public Object unwrap();
	
	/** UPDATE: isNorm() and norm() are being replaced by dedupLevel() and setDedupLevel(DedupLevel).
	Path of L().L().R().L().R() (as deep as number of binary digits before the highest 1 bit, todo choose bigendian or littleendian of bits)
	etc into a large (caller's responsibility locally but provable in p2p network by merkle forest id, to use as) immutable
	bitstring such as long[] or FloatBuffer or CLMem or File. Similar to tree addressing op in Urbit except limit 63 hops,
	and if you need more you do create a fn.
	(renamed binheapIndex to zigzag()) see isNorm() and twins(). This is a binheap index into a blob,
	normally stored as a primitive array and 2 int indexs fromInclusive and toExclusive which are powOf2 aligned,
	but may be big enough to need the long index as it could be a file or network storage etc.
	<br><br>
	<br><br>
	<br><br>
	FIXME this is only true if the blob (such as float[]) thats wrapped has an id (even if its a nonnormed ptr at blob id)
	instead of being deduped only by Map and ==, so we need a local id of those blobs in memory that have never been hashed
	and to make sure those arent shared across untrusted borders until hashing/id them if ever cuz making up local ids wont sync in p2p.
	If this is 0, then !isCbt() and isNormed(). If this is 1, then isCbt() and isNormed().
	If this > 1 then isCbt() and !isNormed().
	<br><br>
	<br><br>
	<br><br>
	Binheap index 1 is the normed form of any cbt. 2 is its L(). 3 is its R(). 4 is its L().L(), 5 L().R() and so on.
	This allows large arrays to be reused while having pointers into many parts of them,
	instead of less efficiently storing everything inside an id which can hold up to 256 bits of literal data
	but you need more ids for the internal nodes of binary forest and it would be inefficient to
	have to lookup each part of it with a separate id if you have more data than fits in memory.
	*/
	public long zigzag();
	
	
	/** returns false if this is not a representation of bits (cbt) */
	public boolean bitAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public byte byteAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public short shortAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public char charAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public int intAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public long longAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public float floatAt(long bitIndex);
	
	/** returns 0 if this is not a representation of bits (cbt) */
	public double doubleAt(long bitIndex);
	
	/** bitstring size. cbt is padded with T then F's until next powOf2 size. Can wrap primitive 1d arrays, FloatBuffer, CLMem, etc.
	returns 0 if this is not a representation of bits (cbt) or if there is no T/1 in it to start the padding.
	FIXME todo use negative long values to mean size doesnt fit in long but give the low 62 or 63 bits of that size.
	FIXME should 0 mean is not a cbt, and bize is always 1 higher aka includes the 1 of padding?
	*/
	public long bize();
	
	public boolean isCbt();
	
	/** isCbt and contains a T/1 which is the first bit of paddding up to next powOf2 (which is not actually stored
	but is there in abstract math as a representation of unlimited size bitstrings.
	*/
	public boolean isBitstring();
	
	public static interface Compiled{
		
		/** param is normally not halted, and whats returned is always halted.
		This might wrap a UnaryOperator<fn> similar to how ocfn2's Compiled wrapped a BinaryOperator<fn>.
		*/
		public fn eval(fn lazy);
		
		//public Bloom eval(Bloom lazy);
		
		public boolean setOn(boolean on);
		
		public boolean on();
		
		/** linkedlist of Compiled. Whichever first in that list is on() is used.
		By turning some off, you can test without those optimizations, such as to verify the compiled form has the exact same behaviors to bit precision.
		If prev is null, then on() is always true.
		*/
		public Compiled prevOrNull();
	}
	
	/** increasing DedupLevel.ordinal() (java Enum ordinal, the order of these enums)
	is decreasing level of dedup. Ordinal 0 (dedupPerCallQuad) is perfect dedup by forest level.
	Each level can be normed to any lower level, which merges potentially multiple objects of them into 1,
	which are nonequal at the higher ordinal but equal at the next lower ordinal.
	<br><br>
	TODO maybe merge some of the OcSync in comments end of this fn.java file into this enum.
	*/
	public static enum DedupLevel{
		
		/*TODO dedupPerCallQuad and dedupPerCallquadOrPtrIntoBlobwithid are partially merging,
		but will still probably keep them both here to say if any of the dedupPerCallquadOrPtrIntoBlobwithid are reachable,
		even though dedupPerCallQuad will be able to generate dedupPerCallquadOrPtrIntoBlobwithid.
		Callquad is getting 2 new childs: cbt64_zigzag and blobPtr.
		Every object thats not a zigzag ptr has cbt64_zigzag equal to 0 or 1.
		Its 0 if !isCbt. Its 1 if isCbt and is ptr at itself (aka not a ptr into another cbt).
		If cbt64_zigzag > 1 then blobPtr is used instead of the other childs [func param stack cacheKey]
		and its halted. cbt64_zigzag can refer to depths past the bits in the cbt
		by the rule that cbt64_zigzag is used as a bitstring (when nonzero), padded with 1 (todo choose endian) then 0s,
		and the sequence of bits in that mean (blobPtr T T F T F... whatever the bits are).
		Since blobPtr is proven to be a cbt, which is a completeBinaryTree made of pairs of pairs... of T andOr F,
		calling any internal node in it on T or F always halts,
		and if it goes past the T or F at the cbtLeafs (which are each T or F)
		then the result is always T, F, (T T), (T F), (F T), or (F F), so it doesnt expand complexity beyond that,
		and which of those it is can be derived from cbt64_zigzag and whichever cbtLeaf bit (T or F) it went past.
		...
		callquad childs (TODO update OcChilds.java enum?):
		* func
		* param
		* stack
		* cacheKey
		* blob //leaf if [zigzag64 != 0 && zigzag64 != 1]
		* zigzag64 //a cbt64, that when > 1 means that id of self equals id of self.blob (which has zigzag64==1) forkEdited to be self.zigzag64 
		* isLeaf ?
		* isMeta (2 forms of each callquad for reflection. See OcfnUtil metaOps such as step, lazyCall, as*, stackDown, etc)
		//* isCallPair (2 forms of each callquad/callpair for reflection)
		//	FIXME I've written wrong things other places about isCallPair. It can still have stack and cacheKey but computes the normal vs meta ops.
		///	Therefore rename isCallPair to isMeta.
		* isParentsFunc
		* cache_isZeroKelvin //see IdField.isZeroKelvin
		* cache_isHalted
		* cache_isCbt
		* //cache_isBitstring
		* //(TODO some of the other bits in /OccamsfuncerY2020M9/src/occamsfuncer/impl/optimize/id/ExperimentalIdType374412.java ?)
		...
		TODO add a few more meta ops for the zigzag64 and blob child.
		...
		I intentionally designed callquad.blob child to not know if its being used as a blob or not
		so user level code cant force it to be computed as a certain blob size or specific-powOf2-branching-factor of tree of blobs.
		The main benefit of the blob and zigzag64 childs being visible to equals func
		is that the system can contain bigdata without having to searchIndex each individual part of the huge blobs.
		...
		The OcfnUtil.step func will act SIMULTANEOUSLY at the first 2 deduplevels (without and with zigzag)
		and at worst will trigger lazy hashing down to the deduplevel with zigzag (ptrs into blobs)
		when ((step evalingState) possibleCache) checks if possibleCache.cacheKey is what evalingState needs.
		It can use == in Compiled.java optimization when their forest shapes do equal,
		but it cant use == when their forest shapes dont equal,
		so "trigger lazy hashing down to the deduplevel with zigzag" would happen if forest shapes differ.
		*/
		
		
		/** This is required for practical optimization of equals function such as for map keys, else computing equals as a
		sparse turing machine (pure interpreted mode) would have exponential cost. The universe would heat-death first,
		but the math has been tested on smaller calculations and it works.
		Perfect dedup of forest shape, the strongest level.
		<br><br>
		Ptrs into blobs arent allowed to affect ids, since blobs must be represented as binary forest of callquads,
		but you can still have blobs stored in arrays as long as you also store the internal binary tree nodes as callquads up to
		the root of that blob whose callquad is its dedupPerCallQuad level id.
		In practice, you might store this as a 4-way 8-way or 16-way tree for more storage efficiency,
		skipping a few levels of the tree but calculating the same ids at those more sparse heights.
		dedupPerCallquadOrPtrIntoBlobwithid is like that except only stores the top callquad's id and the whole blob content,
		so if you're only pointing at the top node of a blob which is deduped by id, it counts as dedupPerCallQuad.
		*/
		dedupPerCallQuad,
		
		/*FIXME merge dedupPerCallQuad with dedupPerCallquadOrPtrIntoBlobwithid and
		add a bit somewhere that tells if any zigzag>1 is reachable.
		*/
		
		
		/** This is the normal DedupLevel to use when saving on harddrive or in p2p network.
		Ptrs into blobs are allowed and that affect ids.
		*/
		dedupPerCallquadOrPtrIntoBlobwithid,
		
		/** This is the normal DedupLevel to use while computing in memory.
		Same as dedupPerCallquadOrPtrIntoBlobwithid except weaker dedup cuz the blobs arent scanned for content to dedup them
		so 2 blobs of the same size could have the same content. The callquads are perfect deduped, among those at same DedupLevel,
		if you consider a non-deduped blob that we dont even know the contents of (wrapper of float[] for example, that we havent hashed)
		to be an ok leaf within this otherwise perfect-deduped forest shape. Its also not deduped against stronger DedupLevels
		such as if a dedupPerCallquadOrPtrIntoBlobwithid level object comes in, we might have a copy of it or not and not know it.
		*/
		dedupPerCallquadOrPtrIntoBloblazy,
		
		/** Its recommended to never use this except in NondetNode which is just a stack.
		or to describe a part of the system if it has an error (in an optimization, not the universalFunction itself which has no errors)
		where duplicates happen where they shouldnt.
		The weakest dedupLevel. It doesnt even dedup the contents of blobs, so anything built on them is also not deduped.
		Most large blobs start this way and upgrade to dedupPerCallquadOrPtrIntoBlob before saving to harddrive or sending across p2p network.
		The math of the system will still work without any dedup, cuz its a sparse turingMachine, but it will be exponentially slower.
		*/
		allowAnyDup;

	}
	
	/** garbage collection (garbcol) types.
	Any of these may be influenced by nondet ops such as wallet, spend, zapEconAcyc, and fullEconAcyc,
	which may give info or direct controlflow to return a different thing as the next state to
	replace earlier states which get garbcoled if garbcolUnreachableFromSet.
	*/
	public static enum OcGarbcol{
		
		garbcolUnreachableFromSet,
		
		garbcolRecursiveExpireTime;

	}


}
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////
////////////end fn, start comments...




















/** TODO organize these comments


** A gameweb (like chess gametree web of possible states and edges to next possible states) representation
of the space of all possible functions and stack states during computing them.
Compare this to Triedge which does <func,param,return> caching and only Uedge.eval.
A little of this should be used many places between triedges as turingCompleteChallengeResponse
way of holding p2p network to correct math and in sync.
Its much harder to do that with triedge alone cuz between lazyCalling <func,param>
and getting its return (if it ever returns) there can be huge amount of calculations
that can be represented by Biedge, some of which can be represented by triedge
as calls make more calls higher in stack, and to find those other calls you can use biedge
or there are stateful ways to do it like ocfn2's prototype used java stack.
Ocfn3 doesnt need java stack and instead defines BigO(1) step func (used by Uedge.step)
to repeat until returns, each step being an immutable snapshot including the stack
which costs at most BigO(1) more memory and compute cycles, allowing garbcol between those. 
*
public interface Biedge{
	
	public OcEdge type();
	
	public GameState from();
	
	public GameState to();

}


/** fn and Bloom are 2 ways of using the same thing. As of 2020-8-31 Bloom is very experimental and incomplete.
This is a way of computing the same universal function as in fn.java,
with more self-reference of the VM internals.
Basically need to implement callquad and <isDeterministic=true,func,param,return> caching
and the step func, all in a Bloom step func, which you call on 2 Blooms by
create/find a Bloom whose childs are (leaf,x,y,lazy(step(parent))) then fill in the step(parent).
<br><br>
The valuable product this system produces is fprs, a cache of lambda called on lambda returns what lambda,
aka <func,param,return>, and evidence shareable across p2p network that those statements are true,
which in theory could allow allocation of huge computing resources for a tiny fraction of a second
only when you need it such as allocating half the GPU power of the planet to anyone anywhere instantly
if it could be agreed thru some other system that those who have the compute power want to use it
for that at what times. This system is only for the transfer of computing power and sharing
of lambda functions from and to anywhere at gamingLowLag, and is not for deciding where or what to use it for,
but as its turingComplete such a system to help people and computers decide could be built inside it
and many competing systems could simultaneously exist inside it since the bloomFilter
contains all possible lambda functions already.
<br><br>
An immutable merkleForest bloomFilter data structure of the space of all turingCompleteness is in here.
Every possible node in the bloomFilter is already known cuz its exactly what can be derived from leaf and step.
The system is entirely stateless. Everything in the system is cache. Therefore, it syncs faster than light
across p2p cuz theres nothing to sync, only cache to share, and to statistically verify by other things
believed to be in the cache/bloomFilter by turingCompleteChallengeResponse.
It will contain digitalSignatures (ed25519 by default and ed448 for higher security, and can derive
every possible digital signature algorithm cuz its a turingComplete space, but will optimize for those
in early versions before the compiler is smart enough to optimize more general turingCompleteness).
All communication will be by signing lambda functions,
such as a file is a lambda function made of Lx.Ly.Lz.zxy as the pair function and Lx.Ly.x as true
and Lx.Ly.y as false so you can create completeBinaryTree of bits (as true and false),
and store it as wrapping arrays but in abstract math its those lambdas and bloomFilter nodes,
and some of the bloomFilter nodes and lambdas will literally exist in computer memory
and merkle forest in p2p network. Most will be lazyEvaled thats never triggered.
<br><br>
This will be a 3-way binary forest where all paths lead to leaf,
representing sparse bloomFilter nodes. That bit is 1 in the bloomFilter if that node exists.
The bloomFilter is completely stateless. The set of possible nodes that can be added is defined by
the step function which implements turingCompletness. The bloomFilter represents statements
about callquads <func,param,stack,cacheKey,isHalted,isParentsParam> and fprs <func,param,return>
and other VM internals needed to process them, like a datastruct containing a callquad and a fpr
where that callquad's next step reads cache to jump ahead in the calculation
and the cache entry it needs is checked against that fpr and if that fpr
has the <func,param> the callquad is looking for then the callquad uses its return and the
callquad's existing stack (which are all statelss parts of bloomFilter) in what step returns.
Step returns another node/Bloom to add to the bloomFilter.
<br><br>
Step func (this.get(3)) is bigO(1). Create {leaf,x,y,lazy(step(this))} is bigO(1).
You can stepInto or stepOver like in debuggers, depending if you have fpr of the calculation
to stepOver, so step can get from a node to a node thats very very far away
in just a few steps, and explore that path as a tree, and that path may be an infiniteLoop.
<br><br>
f x and y are in bloomFilter then you can add {leaf,x,y,lazy(step(this))},
and step func is deterministic and from every node goes to next node.
Repeated step can have cycle where infinite loop or next is self to mean halted,
else keeps expanding without ever returning to any node its been before
else eventually reaches an infinite loop.
Step from 2 different nodes can have the same next node.
TODO Step is designed to use the first child as opcodes and evalling state
in a provable way since user (if obeying the rules in the opensource p2p network,
which will be verified statistically but thats a research path)
cant create node that has anything other than leaf as first child
except by creating {leaf,anything1,anything2} and calling step on it n times
and any combo of those.
<br><br>
Its best to keep all nodes reachable thru the first 3 of 4 childs recursively,
from every node in the bloomFilter, and remove/uncache nodes from earlier steps after
they create a fpr which is the most useful product of this system.
You may remove any set of nodes from the bloomFilter which means to clear those from cache,
but others in the p2p network may still have them and act like they're still in bloomFilter.
The normal behavior of a bloomFilter is you can add but never remove.
You can remove/uncache from this bloomFilter cuz every bit in the bloomFilter can be derived
from leaf and step. Therefore the komogorovComplexity of the bloomFilter, nomatter how
big it gets (like the size of ipfs and bittorrent), is just a few kilobytes to define
the step func, but if it contains digitalSignatures then some things are exponentially
harder to find/derive than others. It might be proven that a certain thing has been signed
by a certain publickey even though the privatekey never signed it simply cuz of the fact
that it could be signed, that among all possible bitstrings at least 1 of them is such a signature,
then it could be that the signature was uncached,
so whatever was derived from the fact that a certain publickey could have signed something,
therefore has signed every possible thing, might remain in the bloomFilter,
therefore we should use (publickey sig message leaf)->leaf as verifier
and (aDigitalSignatureAlgorithm password message)->(publickey sig message) as way to sign,
which are all part of bloomFilter, and be very careful, in opensource forks of this code,
which all use the same merkle forest data format so are compatible at runtime...
very careful what kinds of evidence and statistics are used to verify that what
nodes in the p2p network are claimed (to be part of bloomFilter) were actually derived from leaf and step
instead of just made up as any trinary forest or ids are random numbers instead of hashes/literals
of correct data format. Multiple idMakers can be used together but those would be parallel forests
of the same shape. Its true in math that every possible sig exists in the bloomFilter already,
but in practice its the paths between nodes, thru their 4 childs each,
where theres an infinite number of paths between each 2 nodes in the bloomFilter,
that will be used as evidence that something is in the bloomFilter,
and if you
<br><br>
As list, size is always 4. The first 3 are direct childs. The last is what step returns
and is lazyEvaled cuz it can have cycles and doesnt affect id
but may sent thru network as part of turingCompleteChallengeResponse.
<br><br>
<br><br>
=====OLD FROM WHEN THIS WAS A BINARY FOREST INSTEAD OF 3/4 WAY======:
<br><br>
binary forest node aka 2 branches downward from each, where all paths lead to the same leaf,
and the 2 childs of leaf are whatever in fn.java represents IdentityFunc (is my left) and myself (is my right),
as that is mounted at the first param being leaf.
<br><br>
This is a way to represent what fn does but as a bloomFilter where each bit to be included or unknownIfItsIncluded
is a binary forest node. Some nodes represent quadtrees, some represent <salt,func,param,return> cache,
and one represests a step func, etc.
<br><br>
For any 2 bins x and y(included in the bloomFilter), you can add another 2 bins to the bloomFilter
as (pair x) and ((pair x) y) aka (pair x y).
For any bin x in the bloomFilter, for every gamewebEdgeType g, and (g x)->z, you can add z to the bloomFilter.
Any fn, if trusted to only create true statements (such as (leaf T x) might mean (x leaf) halts,
and (leaf F x) might mean (x leaf) does not halt), so you cant have both of those for any x...
if that fn is trusted to not create contradictions, then you can use it to add new things to the bloomFilter.
<br><br>
TODO get fn.java working first (for the 15 param universalFunc), then explore various ways of
representing it and the internal workings of the VM (such as callquads and <salt,func,param,return> cache entries, etc,
and maybe other ways to prove things as multiple gamewebEdgeType fns are found that can trust.
<br><br>
Also keep in mind that <salt,func,param,return> will in practice have a utcnano time last used
so remove cache entries used least recently when need the memory for new ones.
<br><br>
fn.func() and fn.param() are bin.L() and bin.R(),
but bin doesnt have stack() and cacheKey() and isHalted() etc cuz its always halted
<br><br>
TODO optimizations similar to fn for wrapping float[] long[] FloatBuffer CLMem etc.
<br><br>
CANCEL, CUZ DONT WANT TO STORE HEIGHT:
as Comparable<Bloom>, its first by height then by child 0 recursively, then by child 1, then child 2,
ignoring child 3 which is lazy(step(this)). Skip equal childs.
*
public interface Bloom extends List<Bloom> *, Comparable<Bloom>*{
	
	/*FIXME need some way of labeling nodes as having a certain step func,
	since will want to try some variations of this having different ways of proving madnode when the rules arent followed.
	Maybe a cbt of fn.java forest of a func that takes a 3-way-tree and returns a 3-way-tree,
	store its id as cbt or better, store its binary forest (get(1) and get(2)) somewhere in get(0) inside an op.
	Maybe that should be a fourth direct child, the definition of the step func,
	and combining any nodes that have a different step func than eachother,
	other than if those nodes represent ocfn3v binary callpair forest of halted lambdas (which step func can be made of),
	instantly results in madnode so no such nodes exist in the bloomfilter
	but all possible bloomfilters with all possible step funcs exist in the same bloomfilter but those sections dont interact with eachother.
	The fourth param will be included in hashing to get ids (which may also contain literals up to 256 bits as they are 44 byte ids),
	and to keep it within 1 sha3_256 cycle, xor the stepfunc id into every third byte of the concat of the other 3, but across the network
	send self and all 5 childs self=(child child child stepFunc returnOfStepFuncCalledOnParent).
	The sending of self's id with the things that generate that id is a way of verifying peers are using the same hash function.
	...
	NO, put the stepFunc (as forest, not its id) somewhere in get(0), such as get(0).get(1),
	except ocfn3v funcs, which step funcs can be made of, have some constant in their get(0) so theres no circular logic.
	This way, theres only 3 direct childs and dont have to weaken security by xoring an id into every third byte etc
	which would weaken it cuz up to 256 bits (any powOf2 up to that) can be any chosen bits of literal cbt.
	Put Compiled.java instances (BloomCompiled.java? Compiled.java is for fn.java) on the few <op,stepFunc>
	since stepFunc will be the same within each section of the bloomFilter, a section being defined by what stepFunc it uses.
	
	FIXME, I might want to allow multiple funcs to look at any set of nodes and answer madnode vs ok,
	such as looking at 2 fpr, or such as looking at 1 node (and its contents recursively)
	and seeing that it couldnt possibly have been created by the rules of the system.
	This way, we dont have to change the step func and can instead share different ways (each a fn)
	of proving that the rules werent followed,
	so the system would be far more likely to contain only true statements.
	Every fn will be represented as Bloom/node.
	
	FIXME, mostly for local use with nondet.spend and nondet.wallet and nondet.solve etc,
	but possibly for state in some parts of p2p network as layer above and not affecting the stateless parts...
	There will be a few opcodes (made of bloom nodes, not a new datastruct), including:
	* allowAny2NodesAsChilds1And2IfThisIsChild0 (what I originally said was leaf but will need more opcodes than that so its not leaf)
	* madnode aka mutually assured destruction of blockchain-like merkle forest (actually a web, far more decentralized) forking cuz
		disproofByContradiction if madnode is ever proven to be part of bloomFilter which can only happen if some node is claimed to
		be in the bloomFilter thats not correctly derived.
		Occurs only when 2 fpr of the same <func,param> have different return such as <b,c,d> and <b,c,e>,
		which can be redundantly checked by the debuggerStepInto (callquad without fpr, more steps)
		vs debuggerStepOver (with fpr as cache in callquadWithFpr) which must lead to the same fpr (in cacheKey lower on stack),
		therefore every possible claim that a certain <func,param> halts on a certain return
		can be proven or disproven (may take huge number of steps) BUT if it actually never halts
		then a claim that it halts on a certain return cant be disproven even though its false,
		so it might be best to only share halted lambdas instead of fprs across the p2p network or only include fprs that
		can be verified in a small number of steps (including stepOver with fprs recursively).
		Godel incompletness and halting problem explain some relevant issues, to be explored as research path.
		If peers share many paths, each a single step, that can go either direction per
		edge (each node can go down to 4 childs, the last being step), whose 2 ends are relevant nodes,
		then like surfaceTension of a fluid, the system will be dense enough that statistically almost always
		it will contain only true statements cuz statements that are too sparsely separated by too few paths
		from the high dimensional blob of turingCompletness (statements believed, derived from leaf and step)
		will be left as unknown.
	* twoFprs - allows 2 fprs to be checked for having the same <func,param> and different return, and if so, steps to madnode, else is halted.
	* varnode - the lambda (varnode key)->val is stored in fprs, except user can create those fpr directly without
		deriving them from step and leaf, which means user arbitrarily defines that forExample (varnode "hello") returns "world",
		but if simultaneously the bloomFilter contains (varnode "hello")->42 then madnode cuz a var can have only 1 value.
		A var's value can never change, cuz the system is stateless. As long as every var only ever has at most 1 value,
		the lambda math is consistent, cuz varnode is defined as the lambda that when given the param "hello" always returns "world"
		even before someone claimed it returns "world" it was already that lambda but we just didnt know exactly which lambda it is,
		and as long as no 2 users ever create 2+ values for the same var (even to change its value over time) it will work,
		and madnode will blockchain-fork (actually trillions of mostly independent sidechains with recursive sidechains, a forest not a chain)
		many times per second to keep that consistent. But mostly, varnode is for
		locally implementing the nondet lambda for wallet spend and solve etc.
		VERY IMPORTANT: anything that can reach or was derived from a varnode fpr,
			must have a certain bit as 1 in its id, so p2p sync is instant for those. 
	* callquadWithFpr - Any callquad can be combined with any fpr, but if its not the fpr of the cache entry the callquad wants to read
		then it will debuggerStepInto (slower) instead of debuggerStepOver.
	

		Nodes (Bloom) must do .equals(Bloom) in bigO(1) for step func to be bigO(1)
		cuz callquad needs to check if a certain fpr is the one its trying to read as cache.
		BUT... TODO... dont do that as .equals, do it as a func that can prove they equal but if it doesnt prove they're equal
		then thats ok too cuz it can stepInto instead of stepOver.
		Therefore there must be 2 paths (bloomFilter allows many paths already, still deterministic),...
		WAIT NO...
		just leave that step/get(3) as lazy and dont proceed into it if cant efficiently prove that equality,
		cuz wrappers of primitive arrays are lazy deduped and things derived from them are partial deduped by hashconsing
		where the partial part is that certain nodes below (wrapped arrays) might not be deduped but above them
		theres perfect dedup other than that part so there can be at most 2^numberOfWrappedArrays duplicates of each node in the bloomFilter
		and in practice it will only be about 1% more nodes on average.
	*
		
	public boolean isLeaf();
	
	/** madnode -> blockchainFork to prevent the existence of MAD *
	public boolean isMAD();
				
	/** true if this node is in the 0 entropy (only 1 possible state derived from leaf and the step function which contains
	all of turingCompletness) infinite size space, meaning it was not derived from any var values (fpr of (varnode x)->y).
	<br><br>
	Sync is instant in p2p network, faster than light, cuz the whole system is cache and derivable from leaf and step statelessly,
	UNLESS at least 1 var value (this.write(value)->nodeRepresentingThatFpr or madnode if this is not a halted lambda)
	exists which is state. Sync is faster than light in the way that
	if 2 computers on opposite sides of earth create the same node at the same time,
	they will both create the same id for that node and be agreed on that id before light has time to
	travel between those 2 computers, and the same recursively for anything built on it,
	similar to how in ethereum the same node called on the same transaction costs a deterministic amount of gas
	but ethereum is stateful in that which transaction goes to which node is not deterministic cuz they could come
	in different orders depending on the network and amounts of gas elsewhere to do that vs abort transactions that dont have enough gas
	as in the TransactionState objects in ethereum. Unlike ethereum, this system is turingcomplete and absolutely stateless and timeless,
	and we call that zeroKelvin cuz it has 0 entropy aka only 1 possible state and that is the space of all turingCompleteness.
	Layered above that, and not affecting that zeroKelvin system below it, is a variable system where
	each variable can have at most 1 value that never changes, so it can be written at most once,
	and if you want its value to change you instead include a time (utcnano in int64 for example) in the var name
	as a var name and var value can be any lambda functions.
	*
	public boolean isZeroKelvin();
	
	public default int size(){ return 4; }
	
	/** FIXME need to prevent modification in Iterator.remove() and any other func of List that breaks immutable *
	public default Bloom set(int index, Bloom element){
		throw new UnsupportedOperationException("immutable");
	}
	
	/** child child child lazy(step). Id is derived only from first 3.
	get(3) is how you call the step function on this node and its first 3 childs recursively.
	The step function only uses the first 3 childs.
	*
	public Bloom get(int index);
	
	/** returns a new bloom of {leaf this r lazy(step)}. This can be done with any 2 Blooms and it always results in a valid node. *
	public Bloom p(Bloom r);
	
	/** (varnode this)->val. See comment somewhere in this file. Must never have 2 values for the same var. That means you cant change a var's value.
	Sync in p2p network is instant if there are no var values and only the nodes derivable from stateless turingCompleteness.
	The existence of any var having a value echos a certain bit set to 1 in all ids derived from it recursively to warn about that.
	Madnode/blockchainblockwebetcFork occurs far more often the more var values exist, so they are best kept locally for temporary calculation
	of nondet ops wallet spend solve etc but could be ethereum-like in p2p network in a layer above and not affecting the pure stateless below.
	*
	public Bloom write(Bloom val);
	
	
	
	
	
	
	
	
	
	/** things a system can do multiple of (but maybe not every possible combo works?) to sync computing across untrusted borders,
and some of these things are for use within trusted borders. Trusted borders are normally just the local computer,
which you might not even trust that and want to verify every node such as if you think your computer might have been hacked
by some other program, or you might define a trusted area as a specific few computers which https between eachother.
Occamsfuncer is designed mostly to deal with computing across untrusted borders
and to make huge networks of that appear to work as 1 big computer that many people can use together
without being able to damage what eachother build but can still expand on it as every tiny change is a fork.
<br><br>
All of these can be used with most or all the optimizations, especially opencl/gpu optimizations of matrix math
and acyclicFlow calculation of binary forest of float or double such as for musical instruments.
<br><br>
FIXME this should maybe be split into multiple enums?
*
public enum OcSync{
	
	//FIXME should Nondet or Bloom.Var (which are similar but not exactly) be described in OcSync?
	//Normally you would only try to sync those within 1 computer (not crossing untrusted borders).
	
	/*FIXME remove or change andOr add, some of these cuz this was copied from another fork of occamsfuncer
	before had decided on which universalFunc (ocfn3v).
	It may be missing some of the veryExperimental research paths planned for Bloom.
	*
	
	
	
	/** the worst kind of sync. Most software outside this system is this way. Things change over time
	instead of being based on a stateless immutable universal function.
	For example, x++ changes the value of x instead of forkEditing something like a Continuation
	so you can have 2 objects representing before and after the "change",
	and it doesnt actually change since you can reuse a continuation as many times as you want
	without changing it. Occamsfuncer uses lambdas instead of continuations,
	but if you use a treemap (made of lambdas) as a namespace then things can be used similar to continuations.
	Ids referring to these are usually not compatible with occamsfuncer so it mostly refers to things that happen outside occamsfuncer.
	*
	syncMutable,
	
	/** counterpart of syncAlwaysId. This can be used, even across untrusted borders, if you have strong syncForestAndUntrustedTriedgeAndBiedge,
	or in some cases syncForestAndUntrustedTriedge might be strong enough, but you cant reliably use it across untrusted borders with syncForestOnly.
	*
	syncLazyId,
	
	/** every sync uses an id (which there can be an infinite number of kinds of as any func that returns a cbt can be an idMaker),
	instead of allowing lazyEval of ids. For example, across a p2p network, if you dont want to deal with the gametheory of
	making up random or allocated ids and computers disagreeing on what are the childs (mostly func and param, but may include other Uedges),
	then you can choose to only accept nodes by their id (which is normally 256 bits).
	*
	syncAlwaysId,
	
	/** If you want to avoid the gametheory of peers giving you wrong <func,param,return> caches, you can choose to only accept the forest edges
	(the kinds of Uedge where Uedge.isChild is true) but none of the cache (Uedge.isChild is false).
	*
	syncForestOnly,
	
	/** syncForestOnly with using some of untrusted triedges which are <func,param,return> caching.
	Triedges can do some turingCompleteChallengeResponse to hold the network to correct math but needs alot more intelligence in designing
	the sync algorithms than syncForestAndUntrustedTriedgeAndBiedge.
	*
	syncForestAndUntrustedTriedge,
	
	/** This is recommended above syncForestAndUntrustedTriedge and syncForestOnly,
	but only use a little of it to turingCompleteChallengeResponse hold together the triedges by unexpected combos where multiple lead to the same node. 
	syncForestOnly with using some of untrusted triedges which are <func,param,return> caching AND some untrusted Biedges
	which are the most detailed way to navigate the space of all possible functions so can most reliably
	turingCompleteChallengeResponse between untrusted biedges and forest nodes.
	Forest nodes are untrusted only when they lack ids. When they have ids, that proves how they fit into the forest,
	of course depending on how hard it is to crack the secureHash used in that kind of id and thats why any fn that returns cbt
	can instantly be used as an idMaker including using multiple id types at once or concatting or xoring multiple of them into a single id type.
	*
	syncForestAndUntrustedTriedgeAndBiedge,
	
	/** Sync can be done by pattern matching of pure topology using biedge, without needing to id anything
	(or could use it in combo with id some things and topology other parts, for redundant safety), instead filling in
	sparse parts of the constant infinite size unweighted directedGraph (with some subset of Uedge edge types),
	things like using Uedge.eval to say that the eval of 1 node is another node, and Uedge.func and Uedge.param
	and Uedge.stack and Uedge.cacheKey etc to represent the pointers that the step func needs, and Uedge.step refers to what
	the step func would return, and Uedge.eval refers to (if its ever found) what looping step would end at.
	You dont need ids if you represent everything as such a 2d array of Uedge constant number of
	dimensions of vector (so 3d but only 2 are var size) at each sparse 2d cell or 1d array of Uedge number of pointers each.
	This is likely very inefficient in CPUs and just barely efficient enough in GPUs and may be by far faster than quantum computers
	in a new kind of black-hole-like quantum-like fluid-like computer that might tune the shape
	of the "superfluid vacuum" (which is everywhere and in all things) to implement this by some kind of smooth graph-coloring
	to pattern match and converge toward that undirectedGraph. This thing is so simple you might even run it near the planck level,
	by using the fractal property of fluids for smaller things to control gradually smaller things than themself,
	as a pure fluid based algorithm. But thats all very speculative, and we need a basic simulation of syncByTopology first,
	and before that we need syncForestAndUntrustedTriedgeAndBiedge, and before that need syncForestAndUntrustedTriedge,
	and already (as of 2020-7-22) have syncForestOnly.
	*
	syncByTopology,
	
	syncByBloom;

}

	
	
	/** biedge types, such as child pointer type used in various kinds of Ufun, and dynamic edge types computed after the childs are known which can have cycles.
Different kinds of universal function will use different set of these.
Some of these are not meant to be part of id as they are derived after its created, such as step and eval.
*
public enum OcEdge{
	
	/** reflection of boolean fn.leaf(), always returns T or F. *
	bitLeaf(true, true, false),
	
	/** reflection of boolean fn.cog(), always returns T or F. *
	bitCog(true, true, false),
	
	/** reflection of isHalted bit, always returns T or F. This differs from bitEnd/end() cuz there can still be things lower on stack *
	bitHalt(true, true, false),
	
	/** reflection of isParentsFunc bit, always returns T or F *
	bitIsParentsFunc(true, true, false),
	
	/** reflection of boolean fn.end(), always returns T or F. *
	bitEnd(true, true, false),
	
	/** boolean isDeterministic *
	bitDet(true, true, false),
	
	/** For every x, (func x (param x)) equals x. (func leaf) equals IdentityFunc. (param leaf) equals leaf. *
	func(true, false, false),
	
	/** For every x, (func x (param x)) equals x. (func leaf) equals IdentityFunc. (param leaf) equals leaf. *
	param(true, false, false),
	
	/** first (func param) this part of stack called, before it was replaced by what those returned in the middle of calculations,
	such as (S x y z) becomes ((x z)(y z)) aka (x z (y z)) but its cacheKey is still lazy (S x y) called on z aka (S x y z) with isHalted==false.
	cacheKey holds a normed form that doesnt have any cacheKey of its own and doesnt have stack and doesnt have compareCardinality etc,
	as if it was a call at the bottom of a stack, so if that call happens again (even if inside a stack, it asks about the normed form),
	return from cache instead of doing an exponential number of calculations.
	When it returns, add to cache the mapping: norm(cacheKey) -> return. Return values are already normed
	(FIXME verify, it might be leaving stack on those and its just not breaking anything cuz its not checking their stack)
	cuz for something to return means it doesnt have anything lower on stack to do,
	except if its returning to something in the stack. Thats why I wrote that FIXME to check if its doing that.
	*
	cacheKey(true, false, false),
	
	/** 1 lower in stack, state of the stack, efficiently forkEditable for BigO(1) per step *
	stack(true, false, false),
	
	/** The use of both stackFunc and stackParam together, with at most 1 existing at a time, is an alternative to stack with boolean isParentsFunc. *
	stackFunc(true, false, false),
	
	/** The use of both stackFunc and stackParam together, with at most 1 existing at a time, is an alternative to stack with boolean isParentsFunc. *
	stackParam(true, false, false),
	
	/** Cardinality is a unary number in some kinds of universalFunc. If cardinality(func) < cardinality(param)
	then eval to (S I I (S I I)) aka infloop. If cardinality(func) <= cardinality(param) at the last param of a (nondet leaf anything),
	which is either a question or statement about its last param (called on leaf) halting or not,
	THEN eval to (S I I (S I I)) aka infloop cuz questions or statements about halting must be about a lower cardinality than self.
	Everything else allows equal-or-lower cardinality than self.
	leaf aka . is unary number 0. (T anyUnaryNumber) is 1 higher, such as (T (T (T .))) is unary 3.
	<br><br>
	Cardinality is left out of some kinds of universalFunc cuz comparing 2 unary numbers adds complexity
	that cant be done in a single call of step so counts down a pair of unary numbers in this compareCardinality child.
	<br><br>
	compareCardinality is either null or (Pair unaryNumberA unaryNumberB) and is always halted.
	*
	compareCardinality(true, false, false),
	
	/** after returns at bottom of stack (normally this would be stack==null & isHalted, but if also has an afterEval child, its not halted yet),
	next step is (afterEval thisWithNullAfterEval).
	This can be used to call an in progress stack state on another in progress stack state,
	to allow anything to be called on anything and give the same answer as if you had gone upward on both stacks and called them there,
	and step is still BigO(1).
	Most kinds of universal function wont use this cuz its wasteful compared to doing the variable number of alternate steps to view
	the top of each stack then lazyCall them on eachother, but its here for completeness.
	*
	afterEval(true, false, false),
	
	/** as of 2020-7 the only universalFunc ever described in this software which uses this child is ocfn2,
	where every lambda call had 3 things instead of 2, 1 of those being comment.
	In other universal functions, comment was only 1 of the params and all calls have 2 things (func, param).
	*
	comment(true, false, false),
	
	/** a bit, would reflect as T vs F *
	isParentsFunc(null, true, false),
	
	isDeterministic(null, true, false),
	
	/** a bit, would reflect as T vs F *
	isHalted(false, true, false),
	
	/** optimization of func then param. Often avoids the need to store (Pair x) when getting x from ((Pair x) y) aka (Pair x y),
	aka an immutable lispConsNode.
	*
	getFuncGetParam(false, false, false),
	
	step(false, false, false),
	
	eval(false, false, false),
	
	stackDown(false, false, false),
	
	stackBottom(false, false, false);
	
	/** The below text is just me thinking about it and I'm unsure what to do, if anything, with this edge type...
	<br><br>
	PLAN, quote from below: "Ok, lets do that: <func,param,return,nonce256> so its 128 bytes, and of course there could be more compressed forms for some patterns of computing, but thats general enough to handle everything.". func is either an OcEdge (quoting up to 23 bytes of utf8 of its OcEdge name) in which case its a biedge, else is a triedge. nonce256 may be interpreted as some of those bits refer to time. nonce256 must be less than the sha3-256 of hashing those 128 bytes (or maybe should be 127 bytes so its just 2 sha3-256 cycles including ending 2 bits of padding).
	..
	BUT STILL THERES PROBLEM OF HOW TO INCLUDE MUTABLEWRAPPERLAMBDA OR OTHER WAY FOR PEOPLE TO INTERACT WITH EACHOTHER IN A STATEFUL WORLD SINCE THAT ONLY HANDLES THE STATELESS PART.
	
	a merging if triedge with biedge. A certain bit index in every id tells if its an OcEdge or not. (L x (R x))==x for every x is only true if none of the relevant things are biedges. Its only if they are nodes/fns. OcEdge (biedge type) is, for example, func, param, stack, cacheKey, step, eval, stackDown, stackBottom, bitEnd, bitDet, etc. If the func in <func,param,return> is an OcEdge then param and return are NOT OcEdges, and the id of an OcEdge is a constant that contains its enum name (so keep them small, at most 23 bytes maybe). If func is not an OcEdge, then its a normal <func,param> evals to return. So everything can be represented as tribedges. Imagine a database table with 4 columns: isBiedge, func, param, return, but can be stored other places as isBiedge is a certain bit in the 256 bits of func. Also, might want a long lastUsed field so can remove last recently used <func,param,return> from cache, but never remove forest childs.
	
	This is a variant of storing the forest childs (func, param, stack, cacheKey) that also does <func,param,return> caching.
	
	Every <func,param,return> is either true or not. There can be no contradictions derived by those who verify things before deriving more things from them.
	
	This doesnt necessarily need to store the int256 ids of everything as long as it can use long timeIds and dedups everything, but to get started, maybe its best to only longterm store triples of int256 ids.
	
	These are therefore 96 byte self contained objects that can be shared across internet and verify eachother as parts of gameweb/gametree of space of all possible functions.
	
	Also, there should be a 256 bit constant that means WANT_TO_KNOW, such as <L,someObject,WANT_TO_KNOW> is the question "what does <L,someObject> return?". So <L,someObject,WANT_TO_KNOW> is a valid tribedge.
	
	Many computers could send a bunch of these 96 byte tribedges to eachother.
	
	We could include proofOfWork in it in various ways, such as <<func,param,return>,<timeAve,timeDev,nonce>> where <timeAve,timeDev,nonce> tells people how strongly someone, and others who copy that to further others, believe thats true, and if it turns out to be false then it counts against those who shared it, but if it turns out to be true, it helps them, in titForTat. This would be an interesting experiment, in the form of ocfn3r that can have up to 128 bits of literal data or 192 bits of secureHash per 256 bit id. Use punishTheNonpunishers gametheory.
	
	We could simplify it to <func,param,return,nonce> but having a bellcurve of time allows forgetting of intentionally error data.
	
	Maybe should be <<func,param,return>,int128timeAndLowBitsAreNonce>
	
	Or maybe should just do <<func,param,return>,int256Nonce> and let people andOr their computers choose how to interpret those 256 bits of extra data. Could define it as invalid if either (1) <func,param,return> is false, or (2) int256Nonce >= proofOfWork(<<func,param,return>,int256Nonce>), so you have to choose a target proofOfWork and keep hashing until you get something thats at least that, so int256Nonce would count as the proofOfWork if its valid.
	
	Ok, lets do that: <func,param,return,nonce256> so its 128 bytes, and of course there could be more compressed forms for some patterns of computing, but thats general enough to handle everything.
	
	BUT STILL THERES PROBLEM OF HOW TO INCLUDE MUTABLEWRAPPERLAMBDA OR OTHER WAY FOR PEOPLE TO INTERACT WITH EACHOTHER IN A STATEFUL WORLD SINCE THAT ONLY HANDLES THE STATELESS PART.
	
	mutableWrapperLambda would be similar to ipns. Its basically supposed to be <publicKey,param,return> where return never changes for same <publicKey,param>, but theres no way to prevent publicKey from signing multiple things. So could define it as always taking the smallest ptr256 return, but that seems like it might need <mutableWrapperLambda,publicKey,param,return,int256Nonce> and digsig in there somewhere, but maybe "public static fn mostEfficientSoFarThatHalts(fn goal)" is a way to partially solve that, the problem being "most efficient" isnt well defined in such a sparse network. "most efficient" could be defined if sacrifice extreme amount of efficiency but then theres not much point in it.
	
	Might be better to have a turingComplete search for things that each publicKey has signed, which is either a fact or unknownSoFar. At least that syncs well.
	
	<existsElseInfloop,x> would eval to leaf else eval to lazy (S I I (S I I)) depending if any y is observed where (x y) halts.
	So <existsElseInfloop,x,leaf,int256Nonce> fits into the tribedge paradigm.
	
	But its damn inefficient to only get 1 bit at a time.
	
	Could this be optimized to look for the thing signed by x (which is a publickey as recogfunc of digsigs) thats of minimum int256 value thats at least a given value?
	That could be an optimization of looking for 512 bits which are each a bloomFilter of is each of 256 bits certainly 1 or is it certainly 0, which it could sign that its both, but that would still be a consistent statement signed even if its not a meaningful bloomFilter statement. I like this. Look more into it.
	
	I therefore want a existsElseInfloop OcEdge type, or something like that, where <existsElseInfloop,x> returns leaf if any <x,y,z> is observed where <x,y> returns z and all are halted funcs (not (s i i (s i i)) or OcEdges etc). In other words, <existsElseInfloop,x> returns leaf if theres any known param of x which halts when x is called on it.
	
	I can at least for now imagine no possible math system which would sync better (lower lag or higher scale) than this, if optimized with such 512 bits to basically query <x_as_mutableWrapperLambda,param> and get the current lowest sorted value that returns, and it can never break the consistency of the lambda math, BUT you cant call it as lambdas, can only call it to get an int256 or individual bit.
	
	Similarly, it could be used more like mypeerstreamapi, instead of those 512 bits of 256 bit bloomFilter, instead as a big bloomFilter aligned to utc time on powOf2s (such as every 16 seconds, every 2^-5 seconds, every 2^-11 seconds, etc, any bit rate), to get the bits (which either are observed or not), and each such bit would be a specific call of <existsElseInfloop,funcThatHaltsIfGivenADigsigProvingThatBitWasSigned>, so basically the bit stream of each pubkey would be a sparse bloomFilter.
	
	More generally, imagine mmgMouseai as a sparse bloomFilter in some huge space of bits, which each are certainly1 or unknownIf0Or1. Some proofs could cover a block of bits such as 32 or 512 bits, but could still be individually referred to. But I do like the publickey model.
	
	Basically, however its interpreted, I want to have a sparse space of short bitstrings (such as at most 1024 bits each, or whatever limit), inside the namespace of each publickey (of any kind of publickey definable by universalFunc, not hardcoding them such as by name "ed25519", instead defining them by the behaviors of those digsig and verifier funcs etc)... It would be a growing set of such bitstrings, and you could query it by prefix strings, and those bitstrings (or combos of them) could be interpreted various ways.
	
	This is getting way too abstract to be efficient. Maybe should try a simpler prototype with hardcoded ed25519 signing 256 bits each, referring to an id256, and figure it out from there. Do a search for <ed25519PubKey,thingSigned> as a recogfunc of thingSigned. Or a datastruct something like <ed25519PubKey,thingSigned,digsig>
	
	existsElseInfloop is basically a turingComplete query that may or may not find the answer, but if it does find the answer (and fits with the rest of the network) then its certainly correct. So existsElseInfloop is a good edge type
	*
	existsElseInfloop(false, false, true),
	*
	//unsure if this can be disproved in <tOrF,func,param,return> disproofByContradiction bloomFilter. 
	
	/** <returnsTElseInfloop,x,leaf> if <x,leaf,T>, else <returnsTElseInfloop,x,lazyInfloop>.
	used for bloomfilter (returnsTElseInfloop and returnsFElseInfloop together) which can, in theory, represent the space of all possible funcs
	as a sparse 2d matrix where every cell has 2 bits, 00 to mean unknown, 10 or 01 are ok, 11 is error.
	Such as is the 237th bit in a certain id type (x.func) of a certain param (x.param) T or F.
	*
	returnsTElseInfloop(false, false, true),
	
	/** <returnsFElseInfloop,x,leaf> if <x,leaf,F>, else <returnsFElseInfloop,x,lazyInfloop>.
	used for bloomfilter (returnsTElseInfloop and returnsFElseInfloop together) which can, in theory, represent the space of all possible funcs
	as a sparse 2d matrix where every cell has 2 bits, 00 to mean unknown, 10 or 01 are ok, 11 is error.
	Such as is the 237th bit in a certain id type (x.func) of a certain param (x.param) T or F.
	*
	returnsFElseInfloop(false, false, true);
	*
	
	/*TODO create NOT edges for most of the edge types, such as if <func,x,y> then <NOT_func,x,z> where y!=z,
	or in other words I want 2 bits for each <func,param,return> tribedge, 1 for certainly false and 1 for certainly true,
	as a bloomfilter. You can therefore disrpove the AND of someone's claim of a certain edge type being true (and your claim that its false)
	by contradicting it. The system therefore can work by Random search through the space of all possible funcs
	and is capable of proofByContradiction.
	So instead of tribedge, its quadedge: <tOrF,func,param,return>,
	and every possible <tOrF,func,param,return> is derivable from combos of <tOrF,func,param,return>s
	other than those which claim it returns (s i i (s i i)) aka that it never halts (which you could never prove anyways in ocfn3r).
	..
	YES, DO <tOrF,func,param,return>.
	This will be a very interesting p2p experiment.
	Only consistent set of <tOrF,func,param,return> can avoid disproofByContradiction simply by randomSearch or strategic varieties of search
	thru the space of possibilities.
	So try it, maybe without things that dont return in bigo1 (so excluding stackBottom, eval, etc).
	The false form of <T,func,param,return> statements doesnt need to be created but CAN be created if desired,
	as part of the gameweb of all possible funcs (and stack states of them),
	similar to how any 2 nodes which are cog (can og) can be lazyCalled together (as both are at bottom of stack even if lazyevaled).
	...
	I'm still concerned that some statements likely exist which cant be disprovenByContradiction
	since they might be so sparsely distant from the main blob of statements other peers are interested in
	that a path to the relevant things are never found.
	*
	
	/** If isChild, then if it has that kind of edge, it must be included in id. Else its lazyEvaled and can have cycles.
	null if depends on which universalFunc.
	*
	public final Boolean isChild;
	
	/** always returns T or F (which means it always returns, which makes it different than isAlwaysLeafElseInfloop). *
	public final boolean isAlwaysBit;
	
	/** similar to isAlwaysBit except instead of T or F, this is either leaf or subject to the haltingProblem so is a sparse bloomFilter
	where the FROM node (this) is the dimension/key in bloomFilter and if it returns anything (returns leaf) then its a member of the one global
	bloomFilter set, else its unknown if its a member of the set or not. The first usecase of this is existsElseInfloop,
	and maybe will be the only edge type like that as its so general. Basically, if this node, for any possible param, halts,
	then this returns leaf, else its unknown whats after this (which would actually be (S I I (S I I)) or whatever the eval edge type leads to
	when something never halts, as abstract math, but since we can never know that (without halting-related constraints in
	some other kind of universalFunc), what this edge leads to in that case would just never be filled in or
	if its claimed then it wouldnt be verified across the network.
	<br><br>
	The existsElseInfloop bloomFilter could therefore be represented simpler than <func,param,return,optionalNonce256>.
	It could be represented as just a set of func, each representing <existsElseInfloop,thatFunc,leaf,someNonce256>.
	*
	public final boolean isAlwaysLeafElseInfloop;
	
	//How about an edge type specialized in isAlwaysLeafElseInfloop of binarySearch of a range of possible things a pubkey could have signed.
	//Normal isAlwaysLeafElseInfloop can do that, so no new edge types needed.
	//For example, outside this system, it could be claimed that somePubKey signed x, so you could check
	//isAlwaysLeafElseInfloop for the min and max id of x's id or could binarysearch for ranges converging on x in log number of queries.
	//Its consistent either way.
	//
	//There should maybe be a way to suggest that others query for a certain edge type,
	//instead of just WANT_TO_KNOW, there might be a I_SUGGEST_YOU_SHOULD_WANT_TO_KNOW.
	//Or more generally some informal system of communication between publickeys, maybe similar to sexps (lisp sExpressions),
	//so publickeys could basically have a conversation as a mix of natural-language and hard logic.
	//But theres no concept of publickeys in this system other than what can be derived from existsElseInfloop.
	//
	//Do I want something more like each peer publishes a goalfunc and other peers try to help them find solutions to it,
	//a goalfunc that can change from moment to moment? Thats probably very inefficient for anything but very very simple patterns.
	
	private OcEdge(Boolean isChild, boolean isAlwaysBit, boolean isAlwaysLeafElseInfloop){
		this.isChild = isChild;
		this.isAlwaysBit = isAlwaysBit;
		this.isAlwaysLeafElseInfloop = isAlwaysLeafElseInfloop;
	}

}


/** I imagine the space of all possible functions and stack states of computing them,
as a gametree, actually a web with cycles so a gameweb. This is an attempt to create a practical
peer to peer compute cloud for massively multiplayer games and AI research at gaming-low-lag
that holds itself consistent by turing-complete-challenge-response as there are many paths from
and to everywhere in this pure topology based model of computing.
<br><br>
This is designed for many possible universal funcs (such as ocfn3s). Use java generics in superinterface
(such as an interface designed specificlly for ocfn3s can still return that interface type from these funcs).
<br><br>
TODO likely still need some funcs about paying for vs giving up on the cost of finding the fn across a certain edge type,
like you can try to go(Uedge.eval) from a certain fn to get the fn it evals to,
but you'd need a haltingOracle (which are impossible) to reliably cross that edge from a randomly selected fn,
so there needs to be titForTat push and pull of forces of fitting together these pieces of the sparse gameweb/gametree
of the space of all possible functions and stack states during computing them.
That is this space, but navigating it in BigO(1) tiny pieces of work is tricky.
Of course you can use go(Uedge.step) to guarantee BigO(1) but for efficiency we need to cache
<func,param,return> triples in the form of lazyEval between 2 things then between that and the return value
is another 2-way edge, so all edges have only 2 pointers and a Uedge as its type.
A Uedge is a small constant number of possible edges, a subset of which are supported by a kind of universal func
such as ocfn3s supports Uedge.func Uedge.param Uedge.stack Uedge.cacheKey but not Uedge.countCardinality,
and among the dynamics it of course supports Uedge.step Uedge.eval and Uedge.stackDown.
<br><br>
Designed for representing the space of all possible functions as a sparse piece of infinite size
directedGraph with small constant number of edge types, such as func, param, stack, cacheKey, step, eval, stackDown, etc,
and since theres many possible paths to every node, its turing-complete-challenge-response-able.
This is not always a function but is a state in a gametree (similar to a chess game tree), actually a gameweb,
in the space of all possible functions and calculations about them.
There is 1 bit in each node that tells canCall, and the gameweb has an infinite number of possible reverse actions
(paths backward along func and param edges) by calling any 2 of these on eachother,
which is not an exception to the gameweb having a small constant finite number of branches outward from each node
since there can be an infinite number of incoming edges but always at most that small constant number of outgoing edges.
<br><br>
This will be compatible with all optimizations, such as opencl/gpu optimized matrix math
that doesnt create the fn objects for the middle steps but still generates the same secureHash based id
as if it had been done the slow way.
<br><br>
Unlike ocfn1 and ocfn2, this does not require hashing to prove sync in p2p network
since its entirely defined as directedGraph topology and can be patternmatched in parallel
or by the usual caching way with lazyEval ids. Thats where possible new kind of quantum-like-black-hole-like-fluid-like computers
could be designed, to push and pull forces to fit together the gameweb from a partial pattern
with titForTat exchange of those forces so as much as a computer helps other computers prove the graph topology
(representing <func,param,return> and partial computing states of it), it can ask others about <func,param>
and they will find the return for it, or partial states possibly toward that.
So basically this model of computing allows many computers to work together to
share cache of <func,param,return> and whichever of them have hardware optimized for certain calculations
can do those calculations in exchange for other calculations or caching done for them by others,
all at gaming-low-lag.
<br><br>
This is more general than ocfn3s but that is the first spec I'm planning to implement.
Other universal lambda funcs which are also pattern calculus funcs, can also be researched in parallel,
since they each are easier to optimize for some things than others or some are simpler.
<br><br>
How to call 2 lambdas (x and y) on eachother and eval to get the returned lambda:
fn x = ..., y = ...;
while(!x.cog()) x = x.go(Uedge.stackDown);
while(!y.cog()) y = y.go(Uedge.stackDown);
fn lazyXY = x.og(y);
while(!lazyXY.end()) lazyXY = lazyXY.go(Uedge.step);
fn theReturn = lazyXY;
//There will be far more optimized ways in some cases, but thats the math spec for WHAT it should do, not HOW to do it.
<br><br>
Or as UnaryOperator its a lambda function, starting from a universal function and from that building all possible functions.
*
public interface GameState<FuncType extends GameState<FuncType>> extends UnaryOperator<FuncType>{
	
	//FIXME verify go(...) and og(...) are consistent with new ocfn design.
	
	/** lazy lambda call (this param), after nonlazy going to stackBottom of each which has BigO(stackHeight)
	but amortized to BigO(1) if doing this to many things and to the results of lazy calling them on eachother.
	*
	public default FuncType f(FuncType param){
		return go(stackBottom).og(param.go(stackBottom));
	}
	
	/** lambda call (this param). WARNING: may never halt. *
	public default FuncType e(FuncType param){
		return f(param).go(eval);
	}
	
	/** returns true or false depending if go(edgeType) is T (Lx.Ly.x) vs F (Lx.Ly.y) which are a forest whose shape depends on which UFun.
	This is for returning things like isDeterministic, isParentsFunc, boolean end(), boolean cog(), etc.
	Only call this where OcEdge.isAlwaysBit==true.
	*
	public boolean bit(OcEdge edgeType);
	
	/** UnaryOperator as lambda call. WARNING: may never halt. *
	public default FuncType apply(FuncType param){
		return e(param);
	}
	
	/** true if this is the universal function *
	public boolean leaf();
	
	/** canCall. True if CAN OG, meaning this is a view from bottom of stack even if its lazyEval,
	so you can create/find a stack bottom from 2 of those which is lazyEval of calling one on the other.
	If you keep travelling along go(Uedge.stackDown) you will eventually get to a cog()==true.
	haAny 2 fn which are both canCall, can be lazyCalled on eachother, where 1 is func, 1 is param, and stack and cacheKey are null,
	and there may be other Uchilds but those 4 are the minimum you need (such as for ocfn3s),
	and any lazy Uedges (such as step, eval, stackDown) are not necessarily filled in yet
	but they already lazily refer to a specific gameweb topology, a constant directedGraph topology of infinite size
	which contains all possible functions and stack states during computing them.
	*
	public boolean cog();
	
	/** true if there is no Uedge.stack (or Uedge.stackFunc and Uedge.stackParam) and isHalted, meaning this is a return value at bottom of halted stack *
	public boolean end();
	*/
	
	/** GO, opposite of OG. Go forward along an edge, of a certain edge type, to an adjacent game state,
	if that game state is known.
	<br><br>
	For a Ufun (which universal func), it uses a certain set of Uedge (edge types).
	Every edge certainly exists since the topology cant have dead-ends,
	even if it has potentially infinite cost to prove it for certain,
	such as (TODO prove consistency of this since thats not halted)
	Uedge.eval might point at lazyEval of (S I I (S I I)) aka the simplest infinite loop
	as the return value of any calculation that never halts, or it could just never figure out what game state is there,
	but for math consistency, the infinite gameweb must from every game state along every supported edge type have a next game state.
	Similar constants will need to be filled in where nulls would normally go such as if it doesnt have a stack, stackFunc, stackParam,
	or cacheKey etc, or maybe we only need 1 such constant which acts most similar to  (S I I (S I I)) but is not exactly (S I I (S I I))
	and is instead something designed specificly to mean nothing is there. Thats a hard puzzle but I'm confident some
	consistent solution can be found.
	<br><br>
	Any boolean funcs in a game state should have a Uedge which goes to either T or F (such as ocfn3s spec sparseTuringMachine T and F).
	*
	public FuncType go(OcEdge edgeType);
	
	
	/** Use OcEdge.funcParam instead.
	
	This is used in the optimization that stores PairNode<x,y> which represents (Pair x y) aka ((Pair x) y)
	so you can goo(OcEdge.func,OcEdge.param) to get x without creating (Pair x). Thats only created if observed.
	*
	public default GameState goo(OcEdge edgeTypeFirst, OcEdge ocEdgeTypeSecond){
		return go(edgeTypeFirst).go(ocEdgeTypeSecond);
	}
	
	public default GameState gos(OcEdge... edgeTypeSequence){
		GameState ret = this;
		for(OcEdge e : edgeTypeSequence) ret = ret.go(e);
		return ret;
	}*
	
	/*Soon after writing this paragraph, I created Biedge and Triedge interfaces, which will do this.
	
	Maybe go(Uedge) should come with a double to add to energyFunc that means how much energy of the whole system is higher
	if this is not known, and come with a double of average time and double of time stdDev (or some kind of decay)
	for how much its relevant then to weight the energy func over time for what it should prioritize.
	But it would still need way to represent uncertainty of many possible things it could be.
	How you put it in a fn object, instead of a set of directedGraphsWithFewEdgeTypes, I'm unsure of.
	I need to organize these possible design tradeoffs and find a way to fit multiple variants of them together
	in the p2p network. In the ocfn2 with nondet, eval is limited by wallet and spend calls.
	I do need the topology based form of it to balance the gametheory in the p2p network of ocfn
	so computers can verify the correctness of eachothers calculations,
	but I also need that to sync with the procedural calculation of it including gpu calculations.
	...
	So theres 2 main models of computing I need to join:
		procedural ocfn (like ocfn2 and ocfn3s) which is kind of timeless but still computed in some kind of sequence, and
		timeless pure-topology-based ocfn (with titForTat exchange of helping eachother find parts of the gameweb).
	*
		
		
	/** Call. OG, the opposite of GO.
	Returns the game state which is backward along a FUNC edge from this and backward along a PARAM edge from p.
	Throws if !canCall()|!param.canCall(), else returns such a lazy call.
	x.call(y).get(Uedge.func).equals(x) and often == x depending if using perfect dedup mode which is expensive.
	x.call(y).get(Uedge.param).equals(y) and often == y depending if using perfect dedup mode which is expensive.
	*
	public FuncType og(FuncType p);

}

	
	
	/** This is an optimization of multiple Biedges, a sparse piece of that bigger (both infinite size)
undirectedGraph (with Uedge edge types between each FROM node and TO node).
This is a Uedge.eval between a call pair (between 2 fn which are both fn.cog() aka can og)
which are Uedge.func and Uedge.param, between that and what it returns (if it ever returns). 
This is a <func,param,return> cache entry, but it might also be stored as Biedge,
or in a Map<fn,fn> of just the eval edges (such as is done in ocfn3s spec sparseTuringMachine).
For every x, (GetFunc/L x (GetParam/R x)) equals x, such as (L leaf) is identityFunc and (R leaf) is leaf,
and L and R of every halted thing other than leaf is its literal forest shape (its func and param Uedges).
*
public interface Triedge{
	
	public fn func();
	
	public fn param();
	
	/** TODO Use some constant, such as lazy (S I I (S I I)) to represent "never halts" if that is somehow known or neuralnet wants to guess that,
	but fn/Node might need an extra bit to say to interpret it as if it is halted even though its (S I I (S I I)) which is the simplest infloop.
	*
	public fn ret();

}



*/