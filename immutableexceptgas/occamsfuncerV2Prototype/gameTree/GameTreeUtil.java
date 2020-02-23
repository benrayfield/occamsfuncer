package immutableexceptgas.occamsfuncerV2Prototype.gameTree;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import java.text.Normalizer.Form;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import immutableexceptgas.occamsfuncerV2Prototype.util.Example;
import immutableexceptgas.occamsfuncerV2Spec.fn;

public class GameTreeUtil{
	
	public static final List<fn> actions = Collections.unmodifiableList(Arrays.asList(
		Example.fnTapeLeft(),
		Example.fnTapeRight(),
		Example.fnTapeCopyRegisterToTapeCenter(),
		Example.fnTapeCopyTapeCenterToRegister(),
		Example.fnTapeReplaceRegisterWithCallRegisterOnTapeCenter(),
		Example.fnTapeReplaceRegisterWithCallLOnRegister(),
		Example.fnTapeReplaceRegisterWithCallROnRegister(),
		Example.fnTapeReplaceRegisterWithCallPairOnRegisterThenTapeCenter(),
		//Example.fnTapeHalt()
		//Example.fnTapeReplaceRegisterWithTypelist()
		//solveInFractionOfAvailableWallet.f(fraction).f(goal is register)
		Example.fnTapeReplaceRegisterWithSolveOfRegister() //solve calling solve
	));
	
	/*Define a goalFunc that tests if its param is an efficient goalFuncSolver
	in general (an AGI), then at least I'll know what I'm looking for
	so I can design such an AGI.
	OpenaiGym is an attempt at this but seems human centric in the
	kinds of tests it includes. I'm looking for something simpler
	thats still a test of general intelligence,
	which deriving mandelbrot would be an example test of but
	need tests that require selfReference such as solve calling solve deeply.
	
	AGI tests: predict if a certain call will halt or not,
	which of course we cant know in every case,
	but there are many cases when it can be easily proven,
	such as (S I I (S I I)) doesnt halt, and (T anything) halts.
	
	Imagine a neuralnet trained on (probably too much branching
	cuz of graph permutations of this)... trained on
	sets of triples of <func,param,return> as a cube with func being
	a position in any of its dimensions, so its a heightmap
	from each of func called on func (x and y) returns func (height).
	Or there are more compressed ways to represent that.
	...
	Can it be represented somehow statistically by
	predicting if things will halt or not, combos of such things?
	For example, a 2d grid of bits where func (x) called on func (y)
	halts or not (bit value there),
	and could try to do statistical inference from that to
	sparsely other 2d grids of other sets of partially overlapping funcs.
	...
	In general thats a directedGraph with binary edges,
	and could fit together many pieces of directedGraph to
	do statistical inference to generate new pieces of the directedGraph,
	such as to implement s and k funcs.
	TRY THAT WITH S AND K?
	Or how about the height3 variant of occamsfuncer with these ops:
	L R isLeaf pair S T?
	The directedGraph of all those possible funcs is well defined
	if you have an infinite amount of compute power to see if each
	halts or not. At least all possible halted states are countable.
	But we also want the nonhalted states.
	Each node would have 2 bits: isLeaf, and isHalted,
	so actually each node has 3 possible labels:
	isLeaf isHaltedCallPair isEvalingCallPair,
	and more generally, each node is a unique binary forest shape
	where all paths lead to the same leaf,
	but all we need to compute the next state is
	"isLeaf isHaltedCallPair isEvalingCallPair"
	of all those at some small constant depth from current node.
	...
	How can I call this universalLambda (L R isLeaf pair S T ops at height 3)...
	How can I call that universalLambda, using only directedGraphs of estimated
	doesItHalt (edge values) to create more such directedGraphs?
	...
	Since they are all subgraphs of the same infinite size directedGraph,
	simply wherever they align proves they fit together
	if each of them is known to be a subgraph,
	but how do you generate new parts of the graph that no observed
	subgraphs are displaying?
	All the logic is defined in the low few heights
	(maybe between plus/minus height 3).
	Also I might need to emulate the stack
	instead of like iotavm (see benrayfields github) it doing
	height number of ops and returning the bottom of the stack pointing
	recursively to wherever it was changed somewhere deep in the stack.
	...
	"L R isLeaf pair S T" are certainly the right ops if you
	dont need vararg but do need a func to not be rewritten during
	its curries (helps caching) and need the ability to detect
	the complete internal structure of any param without calling
	that param. It doesnt have Wallet and Spend calls but we would
	be doing that at the DirectedGraph level statistically,
	and technically it could emulate that too but having to implement
	treemap and secureHash ids is far too expensive.
	...
	Should the DirectedGraphs emulate stack steps in constant time and memory
	vs like iotavm in height time and memory vs like occamsfuncer
	in turingComplete time and memory?
	...
	Emulating the stack would prevent parallel optimizations
	since technically (but hard to practically) every S call
	can fork 2 parallel calculations, and most controlFlow is done
	by many many calls of S that call more S and so on,
	so the whole thing could in a global network easily
	simulate a trillion threads using GPUs and fit the DirectedGraphs
	together gradually as they explore various possible combos.
	...
	Each edge in directedGraph will be in the simplest case a bit
	but could also be a chance or conditionalProbability of
	multiple of them, but its probably better to represent
	conditionalProbability as many directedGraphs with some of
	their bits varying, like data points, to keep the datastructs simple.
	Or maybe there should be 2 bits per directedEdge,
	certainlyHalts and certainlyDoesNotHalt,
	so we can sparsely fit them together without having
	to make predictions about combos we dont care about.
	...
	Each dimension (dimension[] * dimension[] 2d DirectedGraph)
	is meant to refer to a specific unique binary forest shape,
	but we dont actually have to store anything about them
	except "certainlyHalts and certainlyDoesNotHalt" bits.
	That means dimensions lack any label except their relations to eachother.
	...
	Calculation using the "L R isLeaf pair S T" ops (at height 3)
	can be done locally without knowing them deeply, as long as
	we can mark dimensions as "isLeaf isHaltedCallPair isEvalingCallPair".
	Even if its an isEvalingCallPair, its still true or not whether
	it halts or not, but cuz of haltingProblem we often
	would not know, so its still valid to include isEvalingCallPair
	nodes in the DirectedGraphs. So the stack can exist in that form
	before returning.
	...
	Could train neuralnets to find permutations these DirectedGraphs
	fit together (related to subgraph isomorphism of NP math),
	allowing overlap where "certainlyHalts and certainlyDoesNotHalt"
	dont contradict eachother,
	and where "isLeaf isHaltedCallPair isEvalingCallPair" (per dim)
	exactly match eachother.
	...
	Also, each dim/node should tell which of the first n low nodes it is,
	among leaf, (leaf leaf), ..., L R isLeaf pair S T,
	and if its a S0, S1<x>, S2<x,y>, S3<x,y,z>, T0, T1<x>, T2<x,y>, etc.
	That will add just a few bits for nodeType and wont interfere
	with how they fit together since its important stuff I would use
	when programming such a system like I did in iotavm,
	even though its derivable info, it would still help.
	S3 and Pair3 and T2 and L1 and R1 and isLeaf1 are evaling types,
	and (unless I missed a few), all others are halted types.
	Maybe edges should also say those types since each edge
	refers to a dim/node that would be made by calling a dim on a dim.
	Dont forget the "certainlyHalts and certainlyDoesNotHalt"
	for the node types that havent halted (yet?).
	But the types dont tell us which dims are the left/right childs
	of which other dims. Only the statistics of
	"certainlyHalts and certainlyDoesNotHalt" in the graph would tell us that,
	so maybe should just use those 2 bits per directedEdge with
	no other data in the DirectedGraphs.
	...
	Using only "certainlyHalts and certainlyDoesNotHalt" bits in
	DirectedGraphs, how can I implement the basic logic of
	the universalLambda with "L R isLeaf pair S T" as its heigh3 ops?
	How can it identify statistically which dims are those ops?
	((L L)(R L)) evals to L.
	((L R)(R R)) evals to R.
	((L isLeaf)(R isLeaf)) evals to isLeaf.
	(L leaf) evals to (S T T)
	(R leaf) evals to leaf
	and so on. Theres an infinite number of such well defined relations.
	"certainlyHalts and certainlyDoesNotHalt" are known for many of those,
	so I know for sure that if we tend toward
	simpler models (occamsRazor/AIXI/etc)
	then this can represent the process,
	but it might cost exponential compute cycles to do simple things.
	Or maybe neuralnets and gametree search etc would overcome that
	and scale it to be faster and smarter than any existing system.
	Its experiments worth doing.
	...
	Could use RBM neuralnet since its specialized in bits and is very fast
	and should be able to learn many permutations if has lots of hidden nodes.
	...
	As input to neuralnet to infer missing parts, could fit any 2 or more
	DirectedGraphs together (subgraph isomorphism) then ask the neuralnet
	to fillin the missing parts, then graph any subset of those dims
	and generate a new DirectedGraph.
	...
	It would tend to lose precision over time if used too loosely
	but would also
	tend to increase precision by many partially overlapping views
	of this consistent logic, so overall it could work with
	approaching perfect precision without any data loss, in theory.
	...
	I could generate this graph directly using procedural
	universalLambda code similar to occamsfuncer, iotavm, unlambda, iota, etc,
	then train neuralnet on it, and generate the missing pieces,
	and somehow try to generate the forest form from the generated DirectedGraphs.
	...
	The op I need is, given a bunch of DirectedGraphs,
	and given 2 dims within them, generate a dim that is the calling of
	one of them on the other, in DirectedGraph form.
	If it could do that, then wouldnt need the forest,
	since its halting or not in various combos is all the identification
	needed to do general computing, such as a function that
	chooses to infinite loop or not depending if it equals the leaf.
	
	/occamsfuncer/src/immutable/util/CountBinForestShapesPerDepth.java
	Level0 has 1 binary forest shapes.
	Level1 has 2 binary forest shapes.
	Level2 has 5 binary forest shapes.
	Level3 has 26 binary forest shapes.
	Level4 has 677 binary forest shapes.
	Level5 has 458330 binary forest shapes.
	Each number so far is either 1 to start or 1+prev^2.
	
	Add some bits to each edge for:
	isCertainlyLOf
	isCertainlyNotLOf
	isCertainlyROf
	isCertainlyNotROf
	This way, the forest shape can be defined without jumping
	between edge and dim, and all data is still in the edges.
	
	We could add other bits to edges such as
	isCertainlyHigherThan (by height, or maybe by height
	then left recursively then right recursively?)
	
	What can it do? How efficiently could it compute mandelbrot
	if we manually programmed mandelbrot into it?
	Would it better use occamsfuncer's custom JIT compiler or
	something like that, somehow still with the DirectedGraphs?
	...
	Maybe could represent ideas in general,
	without having to do them up from simple lambda parts,
	by including an isCertainlyEqual and isCertainlyNotEqual bits per edge?
	...
	In general, these are 2d slices of the 3d tensor
	of <func,param,return> triples, other than the bit that says
	it certainly does not halt. Halting can always be proven
	in variable finite time, however long it takes to halt.
	Or more generally, if func 0 means anything that doesnt halt,
	then the 3d <func,param,return> tensor is perfectly filled in
	where every <func,param> evals to a return,
	where if it never halts then that means it returns func 0,
	and any call that includes
	func 0 (representing everything that doesnt halt)
	returns func 0.
	For example, the 2d slice of the L func so (L x) evals to y
	is a statement in the <x,y> plane at position L
	in the other of 3d tensor dims.
	I'm unsure if these planes are all parallel
	or if they all fit in this model such as
	the bit for do 2 things equal.
	
	Neuralnet trained on a 3d matrix of bits would
	likely predict correctly missing parts of the 3d matrix
	when parts of the 3d matrix fit together by subset isomorphism
	and the neuralnet is asked about the missing parts,
	representing <func,param,return> triples.
	But 2d is already slow, and 3d would be many times slower.
	Is there some way to represent it sparsely in the neuralnet?
	Like for example a 256*256*9 bit matrix where the 9 bits
	point at either 1 of the 256 funcs (int8) or an extra bit
	for it not pointing at any of those.
	128*128*8 bit matrix could fit in byte[128][128] aka 16kB,
	or maybe 128*128*16 bits where theres 2 bits for each bit in thue ptr
	for is it certainly a 0 or certainly a 1,
	so if its not any of them leave it uncertain?
	No, I like the extra bit for it being something outside those.
	*/
	
	
	
	
	public final FnGameTree empty =
		fnGameTreeStartingWithRegisterContent(leaf);
	
	/** for example, to help it figure out how to create a mandelbrot fn,
	you would give it double math ops such as plus and multiply etc,
	and and maybe give it the 16 opcodes
	that are derivable at height 4 and Example.equals() etc.
	*/
	public static FnGameTree fnGameTreeStartingWithRegisterContent(fn register){
		return new FnGameTree(
			Example.fnGameTreeStartingWithRegisterContent().f(register),
			actions
		);
	}
	
	/*TODO choose a list of fns that each view any fn as a double,
	and use those as neuralnet input to navigate gameTree.
	
	TODO use that to generate mandelbrot fn automatically,
	given a goalFunc that scores higher the more (y,x)->bit testcases
	it matches, and uses Wallet and Spend etc.
	
	TODO use zapeconacyc to choose which paths through gametree
	share how much of the cost for things they are preventing
	from being garbcoled by pointing at them.
	*/

}
