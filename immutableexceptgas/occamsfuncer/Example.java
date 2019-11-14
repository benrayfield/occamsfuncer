package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;

import java.lang.reflect.InvocationTargetException;

/** This is NOT part of the occamsfuncer spec since all these
could be derived using the simpler ops (at most height4)
without writing any java code,
but the parts containing hardcoded BinaryOperator<fn>
as optimizations are plugins. Those could inTheory be
compiled automatically but that would need a smarter compiler.
<br><br>
Examples of things you could derive at user level
from the leaf aka the universal function,
without any java code, but since I'm still building the system
I'm going to call those combos using java.
*/
public class Example{
	private Example(){}
	
	/** TODO port the older version of https://github.com/benrayfield/smartblob
	to occamsfuncer, as a proof of concept of opencl and javassist optimization
	of that amount of complexity. It must be the triangle kind of smartblob
	instead of the circles kind, cuz circles are not a good proof of concept.
	*/
	private static fn bouncingSpringy2dPolygonsLikeInSmartblobGame;
	public static fn bouncingSpringy2dPolygonsLikeInSmartblobGame(){
		if(bouncingSpringy2dPolygonsLikeInSmartblobGame == null){
			throw new Error("TODO");
		}
		return bouncingSpringy2dPolygonsLikeInSmartblobGame;
	}
	
	
	
	/** TODO use "Op.nondetGet cbtAsStringPlug (ocfnplug)"
	by prefixing all of these with ocfn,
	like ocfnplugEquals, ocfnplugCdr, etc?
	Or I could use these funcs to create the fns
	then store the fns and not need these javafuncs again.
	Or I could make 1 func that uses java reflection to get these
	and it starts with ocfnplug,
	like ocfnplugReflectExample(String funcName)
	Example: ocfnplugReflectExample("cdr") returns Example.cdr().
	*/
	public static fn ocfnplugReflectExample(String funcName){
		$();
		try{
			return (fn) Example.class.getMethod(funcName).invoke(null);
		}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e){
			return infLoop();
		}
	}
	
	private static fn iota;
	/** This has the same param/return mapping as
	iota aka Lf.f(Lx.Ly.Lz.((xz)(yz)))(Lq.Li.q)
	and differs only in reflection ability as you can use
	Op.L and Op.R to look at the call pairs inside any halted state
	while still being a function within the system.
	*/
	public static fn iota(){
		if(iota == null){
			iota = pair.f(S).f(T);
		}
		return iota;
	}
	
	private static fn callParamOnItself;
	public static fn callParamOnItself(){
		if(callParamOnItself == null){
			callParamOnItself = S.f(I).f(I);
		}
		return callParamOnItself;
	}
	
	private static fn fnThatInfiniteLoopsForEveryPossibleParam;
	public static fn fnThatInfiniteLoopsForEveryPossibleParam(){
		if(fnThatInfiniteLoopsForEveryPossibleParam == null){
			fnThatInfiniteLoopsForEveryPossibleParam =
				lazyEval.f(callParamOnItself()).f(callParamOnItself());
		}
		return fnThatInfiniteLoopsForEveryPossibleParam;
	}
	
	//TODO put BinaryOperator<fn> in some of these.
	
	/*Use Op.pair instead
	private static fn cons;
	public static fn cons(){
		if(cons == null){
			return pair; //https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
		}
		return cons;
	}*/
	
	private static fn c;
	/** curry 2 without constraint. funcBody then its params are next. */
	public static fn c(){
		if(cc == null){
			c = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(5),
				T //no constraint
			);
		}
		return c;
	}
	
	private static fn cc;
	/** curry 2 without constraint. funcBody then its params are next. */
	public static fn cc(){
		if(cc == null){
			cc = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(5),
				T //no constraint
			);
		}
		return cc;
	}
	
	private static fn ccc;
	/** curry 3 without constraint. funcBody then its params are next. */
	public static fn ccc(){
		if(ccc == null){
			ccc = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(6),
				T //no constraint
			);
		}
		return cc;
	}
	
	private static fn and;
	/** AND of 2 params which are each T or F. Returns T or F.
	TODO check compatibility with https://en.wikipedia.org/wiki/Church_encoding
	*/
	public static fn and(){
		if(and == null){
			and = f(
				cc(),
				S(
					p(4),
					p(5), //if p4 is T
					t(F) //if p4 is F
				)
			);
		}
		return and;
	}
	
	private static fn or;
	/** OR of 2 params which are each T or F. Returns T or F. */
	public static fn or(){
		if(and == null){
		and = f(
				cc(),
				S(
					p(4),
					t(F), //if p4 is T
					p(5) //if p4 is F
				)
			);
		}
		return and;
	}
	
	/** FIXME cant do this easily without equals func to detect unary0 */
	private static fn unaryAdd;
	/** Example: unaryAdd().f(unary(3)).f(unary(4))==unary(7). */
	public static fn unaryAdd(){
		if(unaryAdd == null){
			//make sure to use curry and recur
			//like TestBasics.testUnaryAddWhichUsesCurryAndRecur says.
			/*unaryAdd =
				f(
					cc,
					TODO
				);
			*/
			throw new Error("TODO");
		}
		return unaryAdd;
	}
	
	private static fn equals;
	/** returns T or F depending if the 2 params equal by binForest shape.
	TODO optimize by Compiled that first checks their depth
	then compares them by whichever id type(s) is believed to be a secureHash,
	but want to avoid that if can trivially detect a difference
	such as isNil which is implemented using this is only looking
	for a specific thing.
	<br><br>
	The equals is a func that checks every path and uses Op.isLeaf
	so has exponential cost, but will be optimized to average constant time
	and that constant is at worst the time to compute an id
	(of which multiple id types are allowed simultaneously
	but 1 should be chosen to be trusted for determiniing equality
	at least in the early prototype).
	*/
	public static fn equals(){
		if(equals == null){
			/*TODO write the exponential cost implementation first,
			then write the Compiled optimization of it,
			keeping in mind that id funcs must themself be written as fn
			and normally would themselves be optimized by Compiled.
			Define it recursively. If both are isLeaf then it equals,
			else if 1 is isLeaf and the other not, then not equals,
			else the AND of equals of both lefts and both rights.
			Op.curry is designed to have a pointer to the func being called
			so it can be recursive.
			Do 3 if/elses (2 of which are used each time) and handle all 4 cases.
			*/
			
			//p4 is first param cuz p0..p3 are standard parts of curry.
			fn getP4 = p(4);
			fn getP5 = p(5);
			fn p5IsLeaf = S(t(isLeaf),getP5);
			/*equals =
				f(
					cc,
					S( //funcBody
						S(t(isLeaf),getP4), //returns T or F for first param
						p5IsLeaf, //optimization of the commentedout S(...) below
						//S(
						//	//FIXME verify if this is the right way to if/else inside if/else
						//	p5IsLeaf,
						//	t(T), //both leafs, equals return true
						//	t(F) //1 is leaf and the other not, equals return false
						//),
						S(
							p5IsLeaf,
							t(F), //1 is leaf and the other not, equals return false
							S(
								//Return AND of
								//(recurse into 2 lefts) (recurse into 2 rights)
								t(and()),
								S( recur, S(t(L),getP4), S(t(L),getP5) ),
								S( recur, S(t(R),getP4), S(t(R),getP5) )
							)
						)
					)
				);
			*/
			
			//implement equals using Op.ifElse
			//FIXME use Op.ifElse
			//.Example.How to split p5IsLeaf, related to S(...)?
			equals =
				f(
					cc,
					S( //funcBody
						t(ifElse),
						S(t(isLeaf),getP4), //returns T or F for first param
						
						//(S((T I)(T p5IsLeaf)) p) is (p5IsLeaf p)
						//but something to figure out...
						//does S((T I) p5IsLeaf) work? It doesnt lazyeval
						//but its just the condition so ok not to lazyeval that.
						t(I),
						//t(p5IsLeaf),
						p5IsLeaf,
						
						//p5IsLeaf.L(),
						//p5IsLeaf.R(),
						//S(
						//	//FIXME verify if this is the right way to if/else inside if/else
						//	p5IsLeaf,
						//	t(T), //both leafs, equals return true
						//	t(F) //1 is leaf and the other not, equals return false
						//),
						S(
							t(ifElse),
							p5IsLeaf,
							
							//See S((T I) p5IsLeaf) comment above
							t(I),
							t(F),
							//t(F).L(), //1 is leaf and the other not, equals return false
							//t(F).R(),
							
							/*FIXME use ifElse in here?
							but how? cuz there are 32 things: and, recur..., recur...
							Also ifElse of 5 params is making things bigger to write
							and is making me get L and R of things I want to use literally.
							Also the depth of multiple S(...) is confusing.
							I need to get this Example.equals() func working
							as proofOfConcept that the universal function (leaf)
							is flexible, practical, and turingComplete,
							though this isnt enough for proof of turingCompleteness
							I would soon after building this func build rule110, proving it,
							then proceed to other Example funcs implementing various games etc.
							...
							or if I cant get this to work intuitively and correct math
							then I'll have to use the lazy interface (which has lazyL lazyR and eval funcs
							and implements fn and runs (lazyL lazyR) to get the thing it actually wraps
							and remembers ptr to that fn it wraps
							before returning from any javafunc in fn such as fn.L() or fn.cur()
							but only for calls that do not instantly return (such as cur()>1).
							Op.ifElse appears to not align well with the following way
							Im trying to use S(... S(...) S(...) ...) to AND 2 RECURs.
							Does the t(S(...)) t(I) fix it? Probably. TODO verify.
							*/
							
							t(S(
								//Return AND of
								//(recurse into 2 lefts) (recurse into 2 rights)
								t(and()),
								S( recur, S(t(L),getP4), S(t(L),getP5) ),
								S( recur, S(t(R),getP4), S(t(R),getP5) )
							)),
							t(I)
						),
						t(I)
					)
				);
			
			//TODO optimize by equals.setCompiled(new Compiled(...)) 
		}
		return equals;
	}
	
	private static fn doubleMult;
	/** given 2 params that are cbtBitstring of 64 bits each, returns another of those
	thats the strictfp ieee754 multiply of those doubles
	such as what happens in java when you multiply 2 doubles in strictfp.
	*/
	public static fn doubleMult(){
		if(doubleMult == null){
			throw new Error("TODO");
		}
		return doubleMult;
	}
	
	/** curry 2 cbt bitstrings each of size 64, return 1 of those */
	private static fn doubleAdd;
	public static fn doubleAdd(){
		if(doubleAdd == null){
			throw new Error("TODO");
		}
		return doubleAdd;
	}
	
	/** curry 2 cbt bitstrings each of size 32, return 1 of those */
	private static fn floatAdd;
	public static fn floatAdd(){
		if(floatAdd == null){
			throw new Error("TODO");
		}
		return floatAdd;
	}
	
	private static fn mandelbrot;
	/** given some representation (TODO choose one) of x y coordinates in cbtBitstring,
	returns a cbtBitstring of the double representing the brightness/color
	as mandelbrot is normally displayed continuously
	even though technically mandelbrot returns a bit.
	*/
	public static fn mandelbrot(){
		if(mandelbrot == null){
			throw new Error("TODO");
		}
		return mandelbrot;
	}
	
	private static fn car;
	/** Lx.xF where F is La.Lb.b
	https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	*/
	public static fn car(){
		if(car == null){
			throw new Error("TODO");
		}
		return car;
	}
	
	private static fn cdr;
	/** Lx.xT where T is La.Lb.a
	https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	*/
	public static fn cdr(){
		if(cdr == null){
			throw new Error("TODO");
		}
		return cdr;
	}
	
	private static fn nil;
	/** https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	says this should be (pair T T), but I'm undecided about that.
	Am trying it.
	FIXME See how it works in TestBasics,
	and make sure to test strange combos of it.
	*/
	public static fn nil(){
		if(nil == null){
			nil = pair.f(T).f(T);
		}
		return nil;
	}
	
	private static fn isNil;
	/** TODO https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	says isNil should be FIRST aka CAR, but in this system
	there seems to be a better form of it which is
	(equals nil) so (equals nil x) would be T or F depending
	if the forest shape of nil and x are equal.
	*/
	public static fn isNil(){
		if(isNil == null){
			isNil = equals().f(nil());
		}
		return isNil;
	}
	
	
	
	
	
	
	
	
	/** more general than rule110 as it can do all 256 elementaryCellularAutomata
	Takes a size 8 cbt bitstring as param (or TODO should it be a cbt of 8 cbtLeafs?)
	*/
	private static fn elementaryCellularAutomataRecur;
	public static fn elementaryCellularAutomataRecur(){
		if(elementaryCellularAutomataRecur == null){
			throw new Error("TODO");
		}
		return elementaryCellularAutomataRecur;
	}
	
	/** recursive, not cbt optimized, except for the 2d indexs being cbt.
	Takes a func of 2 cbts for the baseCases,
	and is a func of 3 params that takes the basecase func and 2 cbts,
	or something like that (TODO choose an interface),
	and returns a bit (todo cbt or T/F?) for that 2d coordinate.
	*/
	private static fn rule110Recur;
	public static fn rule110Recur(){
		if(rule110Recur == null){
			throw new Error("TODO derive from elementaryCellularAutomataRecur");
		}
		return rule110Recur;
	}
	
	/** depending on param can generate any possible turingMachine and step through its states,
	representing it as Op.pair of the efficient-fork-append ends of 2 cbt bitstrings
	so can push/pop bits between them or even insert/delete to change the size
	of the turing tape.
	*/
	private static fn turingMachine;
	public static fn turingMachine(){
		if(turingMachine == null){
			throw new Error("TODO");
		}
		return turingMachine;
	}
	
	private static fn mapPut;
	public static fn mapPut(){
		if(mapPut == null){
			throw new Error("TODO");
		}
		return mapPut;
	}
	
	private static fn mapPair;
	public static fn mapPair(){
		if(mapPair == null){
			fn unary7 = unary(7);
			//func that infloops if parent's fields dont fit with both child's fields together
			fn mapPairConstraint = null;//FIXME TODO
			//func that does GET
			fn mapPairFuncBody = null;//FIXME todo
			//both of those use Op.getParam, where param0 is curry and param3 is mapPairFuncBody
			//and param4 is idFunc and param5 is number of key/val pairs in the map (cbtAsSize),
			//and so on until last param is getKey. Constraint cant see getKey (the key to get)
			//cuz constraint runs at cur()-1 so gets a different (lazyEval currysL currysR)
			//where currysR is maxChild instead of getKey.
			//So MapPair is just a name (that doesnt affect ids) of the earlier params
			//and MapPair is a specific call of Op.curry.
			//(MapPair idFunc cbtAsSize minKey maxKey minChild maxChild getKey)
			fn MapPair = f(curry,unary7,mapPairConstraint,mapPairFuncBody);
			//func that forkEdits a map (MapPair, MapSingle, or MapEmpty)
			//(mapPut map key val) returns forkEdited map
			throw new Error("TODO");
		}
		return mapPair;
	}
	
	/** see Opcode.acyclicFlow and .acyclicFlowN in other fork of occamsfuncer.
	This is where to hook in the int[] acyclicFlow music tool optimization.
	*/
	private static fn acyclicFlow;
	public static fn acyclicFlow(){
		if(acyclicFlow == null){
			throw new Error("TODO");
		}
		return acyclicFlow;
	}
	
	/** see Opcode.acyclicFlow and .acyclicFlowN in other fork of occamsfuncer.
	This is where to hook in the int[] acyclicFlow music tool optimization.
	*/
	private static fn acyclicFlowN;
	public static fn acyclicFlowN(){
		if(acyclicFlowN == null){
			throw new Error("TODO");
		}
		return acyclicFlowN;
	}
	
	/** a digsig (digital signature) algorithm for signing and verifying
	cbt bitstring, which has small signatures, publicKeys, privateKeys,
	and deterministicly generates key pairs without need for salt.
	*/
	private static fn ed25519sha512;
	public static fn ed25519sha512(){
		if(ed25519sha512 == null){
			throw new Error("TODO");
		}
		return ed25519sha512;
	}
	
	/** FIXME do this in Op.nondetGet instead.
	wraps mutable parts of the world in immutable lambda
	by having them digsign (digitally sign, such as by ed25519sha512)
	pairs of <param,return>, and param may include time andOr other ids,
	BUT this is technically not safe enough to be considered a lambda
	and must instead be part of Op.nondetGet
	cuz someone could sign multiple <param,return> for the same param
	and then that whole func (a mutableWrapperLambda) would be invalid
	unless it was defined as possibly nondeterministic from the start.
	*
	private static fn mutableWrapperLambda;
	public static fn ed25519sha512(){
		if(ed25519sha512 == null){
			TODO
		}
		return ed25519sha512;
	}*/
	
	/** Example uses: opencl optimized LSTM or RBM neuralnets, matrix multiply,
	hashing many things at once, many ed25519 digsigs at once, etc.
	<br><br>
	This is where ForestOp.java and OpenclUtil.java and Javassist hook in,
	though its not the only place Javassist could optimize things,
	it is probably the only place Opencl ndrange kernels need to hook in
	(opencl image/convolutional would hook in maybe somewhere else).
	This is not specific to opencl or javassist as it could be
	implemented efficiently by any parallel number crunching system.
	<br><br>
	Its a forest of ForestOp where each ForestOp has n ForestOp childs
	the lowest of which is a func to GET a literal array from param passed
	in at each of the top ForestOps (s and curry style).
	Each ForestOp returns 1 array thats an integer multiple size
	of number of opencl get_global_id(0)
	such as blocks of 5 float32s or blocks of 1 int32
	or blocks of 8 int32s representing a bigint each.
	It cant return multiple arrays from each ForestOp
	since you would use multiple ForestOp for that,
	which is a design sacrifice to keep it simple
	but technically could be implemented as those share some code
	within a single opencl kernel that returns multiple arrays.
	Occamsfuncer does not know the difference between primitive types
	at the cbt level but can know the difference at the function level
	which processes cbts as for example ieee754 strictfp float32 math
	or in Op.nondetGet you could use non-strictfp math or any
	nondeterministic op you want at your own risk of inconsistent behaviors
	but not at risk of anything escaping sandbox or infiniteLooping
	as its still protected by Gas.top etc (inTheory).
	This will do multiple forExample opencl kernels in a single call,
	which can be ordered async with dependnet (by multiple CLQueue) order.
	The recommended opencl implementation is LWJGL
	cuz of its low lag and compatibility with lots of desktop/laptop OSes,
	as will be used in the prototype, but thats NOT part of
	the occamsfuncer spec
	as the spec is ONLY the definition of the universal lambda function
	and everything other than that is just optimizations of it.
	Mobile phone implementations will probably implement this numCrunch fn
	using a different number crunching API specialized in their
	kind of hardware, similar to opencl.
	CUDA might be implemented in some systems
	as long as it follows the occamsfuncer spec
	and is therefore emulating occamsfuncer and just optimizing it
	and does not put anyone at the mercy and dependence on
	proprietary software since all its behaviors are known
	and formal-verifiable and challenge-response-able
	and replacable and redundantly implementable in
	multiple systems at once that can be hotSwapped
	andOr used together even as parts of the same function call
	across the internet at gaming-low-lag.
	Hadoop, number crunching clouds, quantum optimized clouds, etc,
	lots of possible ways to implement optimizations of this,
	though quantum optimizations might better have their own
	fn designed for their kind of statistics
	and maybe hook it in through op.nondetGet?
	*/
	private static fn numCrunch;
	public static fn numCrunch(){
		if(numCrunch == null){
			throw new Error("TODO");
		}
		return numCrunch;
	}
	
	/** the puzzle game where you slide pieces with powOf2 numbers on them */
	private static fn game2048;
	public static fn game2048(){
		if(game2048 == null){
			throw new Error("TODO");
		}
		return game2048;
	}
	
	private static fn gameRubiksCube3x3x3;
	public static fn gameRubiksCube3x3x3(){
		if(gameRubiksCube3x3x3 == null){
			throw new Error("TODO");
		}
		return gameRubiksCube3x3x3;
	}
	
	private static fn gameGoNxM;
	public static fn gameGoNxM(){
		if(gameGoNxM == null){
			throw new Error("TODO");
		}
		return gameGoNxM;
	}
	
	private static fn gameChessNxM;
	public static fn gameChessNxM(){
		if(gameRubiksCube3x3x3 == null){
			throw new Error("TODO");
		}
		return gameChessNxM;
	}
	
	private static fn gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM;
	public static fn gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM(){
		if(gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM == null){
			throw new Error("TODO");
		}
		return gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM;
	}
	
	/** https://sourceforge.net/projects/visualintfactor/
	with 2d digit carrying.
	*/
	private static fn visualIntFactorGamelikeBoard;
	public static fn visualIntFactorGamelikeBoard(){
		if(visualIntFactorGamelikeBoard == null){
			throw new Error("TODO");
		}
		return visualIntFactorGamelikeBoard;
	}
	
	/** Similar to visualIntFactorGamelikeBoard except with added constraints
	to lock parts so can swap to integers but not swap their individual bits
	while locked but can while summing to left andOr summing toward right.
	Each row (or is it col) except 2 on the sides is 1 of the integers
	to be summed, either toward the left or right.
	*/
	private static fn visualIntFactorGamelikeBoardWithSubsetSumConstraints;
	public static fn visualIntFactorGamelikeBoardWithSubsetSumConstraints(){
		if(visualIntFactorGamelikeBoardWithSubsetSumConstraints == null){
			throw new Error("TODO");
		}
		return visualIntFactorGamelikeBoardWithSubsetSumConstraints;
	}
	
	/** a simple game for testing reinforcementLearning AIs */
	private static fn gameBlocksWorld;
	public static fn gameBlocksWorld(){
		if(gameBlocksWorld == null){
			throw new Error("TODO");
		}
		return gameBlocksWorld;
	}
	
	private static fn gameSimilarToPacman;
	public static fn gameSimilarToPacman(){
		if(gameSimilarToPacman == null){
			throw new Error("TODO");
		}
		return gameSimilarToPacman;
	}
	
	private static fn gameSimilarToMarioRoyaleManyPlayers;
	public static fn gameSimilarToMarioRoyaleManyPlayers(){
		if(gameSimilarToMarioRoyaleManyPlayers == null){
			throw new Error("TODO");
		}
		return gameSimilarToMarioRoyaleManyPlayers;
	}
	
	/** like the iotavm/iotadesktop ui on github
	except a regular grid instead of (float,float) positions.
	*/
	private static fn uiForDragAndDropFuncOntoFuncToGetFunc;
	public static fn uiForDragAndDropFuncOntoFuncToGetFunc(){
		if(uiForDragAndDropFuncOntoFuncToGetFunc == null){
			throw new Error("TODO");
		}
		return uiForDragAndDropFuncOntoFuncToGetFunc;
	}
	
	/** see Vob.java (Visual OBject) in another fork of occamsfuncer */
	private static fn vobGraphicsExample1;
	public static fn vobGraphicsExample1(){
		if(vobGraphicsExample1 == null){
			throw new Error("TODO");
		}
		return vobGraphicsExample1;
	}
	
	/** see benrayfields smoothtapenet project on github */
	private static fn smoothTapeNet;
	public static fn smoothTapeNet(){
		if(smoothTapeNet == null){
			throw new Error("TODO");
		}
		return smoothTapeNet;
	}
	
	/** see benrayfields hyperCubeWave project on github */
	private static fn hyperCubeWave;
	public static fn hyperCubeWave(){
		if(hyperCubeWave == null){
			throw new Error("TODO");
		}
		return hyperCubeWave;
	}
	
	/** audivolv interactive musical instrument evolver, with hyperSphereNet option. */
	private static fn audivolv;
	public static fn audivolv(){
		if(audivolv == null){
			throw new Error("TODO");
		}
		return audivolv;
	}
	
	private static fn deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips;
	public static fn deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips(){
		if(deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips == null){
			throw new Error("TODO");
		}
		return deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips;
	}
	
	public static fn ocfnplugEqq(fn madeByCurry){
		if(1<2) throw new Error("FIXME either the madeByCurry in Nondet.nondet(fn,fn) is broken or in ocfnplugEqq(fn) is broken.");
		$();
		fn a = getParam(4,madeByCurry);
		fn b = getParam(5,madeByCurry);
		return a==b ? T : F;
	}
	
	/*TODO some of those fun experimental jar files in my q18 dir
	such as the "clouds that get brighter" graphics effect,
	or the earlier things that led to physicsmata, or physicsmata itself,
	smoothlife (not my project but could still implement variant of it),
	bayesiancortex experiment (didnt work out but still interesting),
	fluidGravity3Way, etc.
	
	TODO ops for the loop optimizations that avoid directly
	calculating maps but abstractly represent looping vars etc
	as puts of maps, and if/else that works with those,
	and progn-like ops (the p(...) syntax), etc.
	
	TODO, Example.java isnt the right place for ocfnplug,
	since Op.nondetGet is the right place,
	but I do want all static java funcs whose name (after package.a.b.classname)
	start with "ocfnplug" to be callable from Op.nondetGet cbtOfStringPlug,
	and be careful not to let any of those slip by Human attention
	as they must be trusted code trusted to not allow escape from sandbox,
	so dont want any to slip by in PULL REQUEST in opensource
	without much Human attention to them. Need an automatic generator
	of list of such funcs.
	*/

}





