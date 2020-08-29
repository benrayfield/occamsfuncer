package occamsfuncer;
import java.util.List;

/** The valuable product this system produces is fprs, a cache of lambda called on lambda returns what lambda,
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
*/
public interface Bloom extends List<Bloom> /*, Comparable<Bloom>*/{
	
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
	*/
		
	public boolean isLeaf();
	
	/** madnode -> blockchainFork to prevent the existence of MAD */
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
	*/
	public boolean isZeroKelvin();
	
	public default int size(){ return 4; }
	
	/** FIXME need to prevent modification in Iterator.remove() and any other func of List that breaks immutable */
	public default Bloom set(int index, Bloom element){
		throw new UnsupportedOperationException("immutable");
	}
	
	/** child child child lazy(step). Id is derived only from first 3.
	get(3) is how you call the step function on this node and its first 3 childs recursively.
	The step function only uses the first 3 childs.
	*/
	public Bloom get(int index);
	
	/** returns a new bloom of {leaf this r lazy(step)}. This can be done with any 2 Blooms and it always results in a valid node. */
	public Bloom p(Bloom r);
	
	/** (varnode this)->val. See comment somewhere in this file. Must never have 2 values for the same var. That means you cant change a var's value.
	Sync in p2p network is instant if there are no var values and only the nodes derivable from stateless turingCompleteness.
	The existence of any var having a value echos a certain bit set to 1 in all ids derived from it recursively to warn about that.
	Madnode/blockchainblockwebetcFork occurs far more often the more var values exist, so they are best kept locally for temporary calculation
	of nondet ops wallet spend solve etc but could be ethereum-like in p2p network in a layer above and not affecting the pure stateless below.
	*/
	public Bloom write(Bloom val);
	
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

}