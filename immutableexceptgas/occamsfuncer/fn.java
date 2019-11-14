/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;
import java.util.function.BinaryOperator;

/** The purpose of this software is large scale realtime collaboration
at low lag, of millions of people programming andOr researching andOr
gaming together. Its not the most efficient but it can do that inTheory.
This is a universal-lambda-function as a (TODO)
secure (by deriving and optimizing digital signature
algorithms and security processes within the system)
turing-complete AI-research number-crunching
and massively-multiplayer-gaming low-lag tiny-data or big-data
compute cloud that doesnt depend on any specific
network protocol or system or if its centralized vs decentralized.
Its designed to make it efficient and intuitive for any number
of people to build things together in realtime and securely
as every object is a constant including forkEdits of any size.
<br><br>
x.L().f(x.R()).equals(x) for all x.
id is globally unique for every secureHash id func
(allowing any number of ids funcs in parallel,
and TODO design MapPair takes param of id func andOr comparator),
and using identityHashCode and == by <func,param> in this case aka <itsL,itsR>
can do that without slowly computing id except for large cbts
since they are created without all their childs being created first.
<br><br>
Pure-function. If called on a function, returns a function,
with optimizations to make it a practical global system.
Lazy-merkle-hashable as ids, and can use any function as an id generator
for multiple compatible ids at once.
Can in theory represent small data
such as bits, doubles, float arrays, up to googol size forkAppending blockchains,
or nonblockchain but still (lazy)merkle-forest datastruct,
or forkAppending streaming sound video or games etc,
with optimization hooks you might implement VMs using opencl, javassist, etc,
but the spec is just the math of what the VM should do, not how to implement it
or what networks it might go through, and even if it goes through
multiple networks that are normally incompatible, it can make any set of systems
in the world compatible in realtime if they all implement this spec
and are capable of realtime computing and streaming,
even if those systems do not know eachother are both implementing this
but just happen to find funcallPair merkle data (each very small pieces)
and put the puzzle together into an executing decentralized computer
and emit such pieces for others to find and verify
as a secure realtime computer.
A big challenge in optimizing this spec is the need to
cache <func,param,return> triples, which will get cache cleared multiple times
per second for those that are not <myLeft,myRight,parent> of pairs actually in memory,
but the s and other controlflow ops tend to exponentially expand without those triples.
Fortunately you dont need a secureHash id to exactly deduplicate <func,param>
to match it to <func,param,return> as if you have deduped all childs then
all you need to do is hashtable <func,param> and check funcA==funcB
and paramA==paramB of those which hash to the same hashBucket,
which is made harder by lazyEvaling L and R the opposite direction as usual
in bitstrings stored in raw binary and looking for their cbt childs
which are half as big a bitstring but always within the cbt0 and cbt1 combos.
Any secureHash id always perfect dedups, or multiple id funcs
that arent expected to all have a collision on the same object
(which would technically make the powerset of id functions contain id functions).
Nomatter which id function your system already uses,
if its deterministic of the content its an id for,
its already an id function in this system as it can be derived
therefore a hash function can hash itself though there are
multiple possible functions which have the same behaviors other than
if another function gets them as param can tell the difference
by looking into them with L, R, andOr bh,
so the truly normed form of a hash function, you might define,
is the smallest sorted (by depth recursively) function which computes it
ignoring L and R differences of internal forest shape.
All possible functions, being the same as all possible binary forest shapes,
can be binary searched and prevFunc and nextFunc
by sorting by depth recursively
(first depth here, then recurse left, then recurse right),
but that would be a derived op compiled into BinaryOperator<fn>.
Any function can be compiled to BinaryOperator<fn> which hopefully later
will happen automatically such as by opencl, javassist, or whatever compilers
are available locally, but for now I'm planning to just hardcode
some optimizations for common funcs I derive such as MapPair MapSingle MapEmpty
and AVL treelist datastructs and LSTM and RBM neuralnets and acyclicFlow
music tools optimizations. None of that is part of the spec
but is something derivable using the spec and will hopefully be
part of prototype soon.
<br><br>
Bitstring optimization in ids:
Ids of smaller parts of CBTs, such as CBTs up to 255 or 254 bits
for example, could be optimized by choice of id funcs that
include literal data if the first or last bit of the id is a certain value,
and you can get an extra bit by hashing concat(idA,idB,salt)
until that hash ends with a 0 bit, looping from salt=0 salt++
until that happens, or as many 0 bits as you want
(similar to is done in ip6 it appears) but you only need do
this average of 1 extra hash if all you need is
1 extra bit (so 255, not 254). Remember cbt normally ends
with cbt1 padded by cbt0s until the next powOf2 size.
<br><br>
While Double.longBitsToDouble etc are slow,
many calculations can in theory be done between a previous and next state
as fn objects (especially cbt patterns of them),
such as compiling to opencl, javassist, or int[] ayclicFlow music tools
optimization, or whichever optimizations the VM can derive and optimize
or already contains manual optimizations for specific fns.
<br><br>
Be careful of if its the first or last bit cuz want
the secureHash ids to be separated in MapPair/MapSingle/EmptyMap
by the first branch of the map so that literal ids in the map
can only DoSAttack the map within the literal section
as its a trie-like treemap, even though you can derive
a variety of other kinds of map datastructs with constraints,
that is one I think will be very useful,
something like (TODO verify)
(MapPair size minKey maxKey minChild maxChild) (use curry constraint system to
cause infLoop if relation between it and childs is wrong)
or maybe (MapPair minChild maxChild) and let size minKey and maxKey
be stored in <func,param,return>.
(MapSingle key val)
EmptyMap
*/
public strictfp interface fn{
	
	
	/** lambda call. Rememeber, if this is in a nondet(erministic)
	(Spend maxSpend funcIfWorks paramIfWorks funcElse paramElse) call,
	where Wallet and Spend etc ops are something Nondet op returns (TODO which params?),
	and exceeds compute resources (using Gas.ratio* the ratio between
	compute cycles and memory adjusting similar to a free market (TODO),
	then will throw Gas and be caught at nearest Spend call
	which will return (funcElse paramElse) outside that Spend call,
	as in (Op.nondetGet cbtNameOfSpendCall funcIfOk paramIfOk funcElse paramElse),
	VS if this is in pure determinism mode then could actually infiniteLoop.
	Op.nondetInfloopIf will have something similar to Spend except
	it only throws Gas (by infloop) if the param is a number thats
	more than Gas.top (the amount of compute resources available)
	and if it doesnt throw then its considered still deterministic
	since you could run it from an earlier state/callPair multiple times
	until it doesnt halt (maybe with more compute resources available later)
	and get the deterministic result eventually that everyone would agree on.
	*/
	public fn f(fn param);
	
	/** User level code must use fn.f(fn) instead.
	Same as f(fn) if doesnt violate the constraint in the leftmost Op.curry.
	This is only to be called by trusted code that guarantees it obeys
	constraints even though they will not be proven automatically,
	(but in a p2p network they could still challenge-response you
	to find you have not obeyed constraints),
	for efficiency. A usecase of this is if an optimized MapForkPut func
	as BinaryOperator<fn> knows its creating a MapPair correctly
	then it doesnt need to run the constraint part of MapPair, so its faster.
	*/
	public fn fIgnoreConstraint(fn param);
	
	/** Convenience function to wrap param's bits
	(but not its number of array dimensions or their sizes etc)
	using ImportStatic.wr first
	*/
	public default fn f(Object param){
		return f(ImportStatic.f(param));
	}
	
	public default boolean isLeaf(){
		return height()==0;
	}
	
	public fn L();
	
	public fn R();
	
	/** Height while only considering left branches.
	This is normally used as cache of how far L().L().L()... is Op.curry.
	This is designed to be more general cuz its simpler not to check for Op.curry
	and instead to use 0 if leaf else L().height()+1.
	Default implementation is slow and should be overridden.
	Example: curHeight(leaf)==0
	Example: curHeight(leaf.f(leaf))==1
	Example: curHeight(leaf.f(leaf.f(leaf)))==1, despite its height is 2.
	Example: curHeight(leaf.f(leaf).f(leaf))==2, same as its height.
	*/
	public default int curHeight(){
		return isLeaf() ? 0 : L().curHeight()+1;
	}
	
	/** number of curries since nearest Op.curry.
	Technically this could be an unlimited size integer in a cbt,
	but practically it will rarely if ever exceed byte range so int is probably ok.
	WARNIGN: possible security hole if this range is exceeded,
	so do check for it, and its an error to either curry or not curry
	when this range is exceeded since the spec says to curry for any depth
	so to do anything other than say compute resources are exceeded would
	be against the spec so maybe if exceeding should return (s s s s) [FIXME thats not actually an infinite loop] aka infLoop?
	*/
	public int cur();
	
	/** same as cur() but, as in the spec, curries up to unlimited size.
	cbt as unary number. FIXME havent decided on
	howWillCbtBeViewedAsUnaryNumberSuchAsForNumberOfCurriesAndGetparam
	or similarly how cbt will be interpreted as binary number.
	Cbt is well-defined as a bitstring with a cbt1 appended not included in that bitstring.
	*/
	public fn curBig();
	
	/* since currying doubles the depth of cbt (of all cbt1),
	bitstring size is exponential of curry depth,
	so am I ok with that relation between curBig and bitstringSizeBig?
	I chose cbt depth (of all cbt1) as the unary view of cbt for Op.curry
	and Op.getParam cuz its the simplest to emulate.
	Or is there a superexponential andOr log2 in there somewhere?
	Also you wouldnt normally call both of those if you knew its
	for Op.curry andOr Op.getParam but it must work just in case its called.
	...
	If curry depth is 1000, how many bits are in bitstringSizeBig?
	curBig is 2^1000 bits (all cbt1), or maybe half or double of that.
	bitstringSizeBig would then be about 1000 bits.
	Thats ok, since most curries will be less than 8 params, not 1000,
	and it scales to any size for linear cost per 1 more param curried.
	*/
	
	
	/*FIXME the ints in bh vs bhBig, and intAt vs intAtBig,
	must represent a cbt with those ints
	or if they dont then there must be an extra func for
	just a plain int param instead of an int representing a cbt bitstring.
	A cbt bitstring ignores its last 1 bit as its not part of the bitstring.
	I must choose bigEndian vs littleEndian.
	*/
	
	/** L andOr R up to 31 times, same as bh(fn) is for variable size. urbitLike op. */
	public fn bh(int path);
	
	/** L andOr R up to cbt size (excluding last 1) times. urbitLike op. */ 
	public fn bhBig(fn path);
	
	/** returns algorithm.f(this) and caches it if its one of the id types
	currently supported by this VM.
	*/
	public fn id(fn algorithm);
	
	//public BinaryOperator<fn> compiled();
	public Compiled compiled(); //cuz has 2 BinaryOperator<fn>: constraint and funcBody.
	
	/** This is only to be called by trusted code. */
	public void setCompiled(Compiled c);
	
	/** efficient bitstrings. If isCbt but not isBitstring then is all cbt0. */
	public boolean isCbt();
	
	/** efficient bitstrings. cbt with a last cbt1 (not part of bitstring)
	and the rest are cbt0s padding until the next higher powOf2.
	If isCbt but not isBitstring then is all cbt0.
	This default implementation is very slow. Implementing classes should optimize.
	*/
	public default boolean isBitstring(){
		return isCbt() && (this==cbt1 || L().isBitstring() || R().isBitstring());
	}
	
	/** If true, you must use *Big bit indexs for cbt funcs instead of int indexs */
	public boolean isBigCbt();
	
	public default boolean bitAt(int cbtBitIndex){
		if(!isCbt()) return false;
		int cbtHeight = height()-4;
		int cbtSize = 1<<cbtHeight;
		if(cbtBitIndex < 0 || cbtBitIndex >= cbtSize) return false;
		if(cbtSize == 1) return this==cbt1;
		if(cbtBitIndex < (cbtSize>>1)) return L().bitAt(cbtBitIndex);
		return R().bitAt(cbtBitIndex-(cbtSize>>1));
	}
	
	public default byte byteAt(int cbtBitIndex){
		int ret = 0;
		for(int i=0; i<8; i++){
			ret <<= 1;
			if(bitAt(cbtBitIndex+i)) ret |= 1;
		}
		return (byte)ret;
	}
	
	//TODO byteAtBig
	
	/** efficient bitstrings (if isCbt).
	Example: Double.longBitsToDouble(((long)intAt(0))<<32)|(intAt(32)&0xffffffffL))
	which is not very efficient cuz of longBitsToDouble but
	at least the bits themselves are efficient and can make
	things like calling into opencl efficient for functional programming.
	Maybe there should also be a longAt func.
	*/
	public default int intAt(int cbtBitIndex){
		return (int)(longAt(cbtBitIndex)>>>32);
	}
	
	/** Example: Double.longBitsToDouble(longAt(0)) */
	public long longAt(int cbtBitIndex);
	
	/** efficient bitstrings (if isCbt) */
	public default int intAtBig(fn cbtBitIndex){
		return (int)(longAtBig(cbtBitIndex)>>>32);
	}
	
	/** efficient bitstrings (if isCbt) */
	public long longAtBig(fn cbtBitIndex);
	
	/** height0 to height4 are ops.
	Only leaf and 16 of those at height4 have nontrivial behaviors.
	Height can technically be unlimited, so use heightBig() if doesnt fit in int
	which would be marked by height()==Integer.MAX_VALUE.
	*/
	public int height();
	
	/** cbt interpreted as a binary number (TODO which kind of binary number?) */
	public fn heightBig();
	
	/** efficient bitstrings (if isCbt). This tells where the last cbt1 is,
	or TODO return what if its a cbt with all 0s or if its not a cbt?
	Cbt represents bitstring and I'm undecided how to view that as
	signed integer as there are multiple ways it could be done.
	This default implementation is very slow and should be optimized in
	subclasses ArrayCbt and SmallCbt.
	*/
	public default int bitstringSize(){
		if(!isCbt()) throw new Error("Not a cbt");
		int cbtSize = 1<<(height()-4);
		for(int i=cbtSize-1; i>=0; i--){
			if(bitAt(i)) return i; //dont include last cbt1 in bitstring
		}
		throw new Error("No cbt1 found so is not a bitstring");
	}
	
	/** efficient bitstrings (if isCbt) */
	public fn bitstringSizeBig();
	
	/** cache of this.L().L().L()... (could be this) until find
	the first whose height()<5 since all ops are height0 to height4.
	Even if its a compiled custom func thats deeper, its normally in an Op.curry.
	<br><br>
	If Op.curry then it looks for Compiled/BinaryOperator<fn>
	in its constraint/k param and its funcBody param.
	*/
	public fn op();
	
	/** If this is a cbt that points into a range of an array possibly
	shared with other cbts, copies the relevant range
	into a new array, allowing the bigger array to be garbcoled
	if no others are using it.
	java.lang.String was redesigned similarly since they had
	a problem with large char[] not being garbcoled cuz
	substring views of it existed.
	*/
	public default void separate(){}
	
	/** Use ImportStatic.wr(Object) instead.
	wrap an object's bits (such as Double or float[3][44][90000] or byte[]),
	but not necessarily its type, in a fn,
	especially in the cbt parts which are optimized for bitstring efficiency.
	Its type can be represented in funcs that use such bits as the relevant type.
	This is very experimental.
	*
	public static fn wr(Object o){
		throw new Error("TODO");
	}*/

}
