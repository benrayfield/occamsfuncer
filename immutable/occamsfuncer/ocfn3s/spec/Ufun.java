/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.ocfn3s.spec;

import static immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine.OcfnUtil.S;
import static immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine.OcfnUtil.T;
import static immutable.util.TestUtil.testEqq;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** which universal function.
In occamsfuncerV3 there are 3 universalFuncs, which arent used together
except that ocfn3c and ocfn3s can be very near exactly copied to eachother at cardinality 0,
and I plan to port audivolv to ocfn3c and ocfn3s in a way that uses the exact same 4-way-forest
where in ocfn3c its actually a 5-way-forest but the fifth child (compareCardinality) is null
when cardinality is 0, same shape for both of them since audivolv doesnt need cardinality,
and I plan to port audivolv to ocfn3n which will be a very different 4-way-forest.
<br><br>
The standard representation for bitstring is a complete binary tree of T and F (or 1 and 0)
where the last 1 is not part of the bitstring and is padded with 0s until the next power of 2 size.
The padding is normally not stored but is a math abstraction.
*/
public enum Ufun{
	
	/** TODO occamsfuncerV1 *
	ocfn1(...TODO..., func, param),
	
	/** TODO occamsfuncerV2 *
	ocfn2(...TODO..., func, param, comment),
	*/
	
	/*
	FIXME organize this better. have multiple letter suffixs for the various things, including maybe...
	* 3: uses determinism param, has determinism param but ignores it for compatibility, no determinism param.
	* 3: has bigCall thats works whenever funcBody is not leaf, has bigCall that works whenever funcBody and its first 2 params are not leaf, doesnt have bigCall.
	FIXME: the determinism and "bigCall that works whenever funcBody and its first 2 params are not leaf" are connected since that replaces the nondet call.
	* 3: uses cardinality param, has cardinality param but ignores it for compatibility, no cardinality param.
	* 2: has comment param.
	* 2: isIotaBased, else expands those parts and others into more ops.
	* 2: is just binary forest data, else is turingComplete. This probably doesnt need to branch with all the others since theres only 1 kind of it.
	//* ?: number of curries.
	//* 2: is very optimizable
	//number of childs: 2, 4, or 5.
	*/
	
	/** occamsfuncer version 3 data (has nothing to do with 3 dimensions),
	is not a universal function but is a data layer which one could be built on.
	It can store binary data efficiently so would make a good general blockchain, file format, computing system, etc.
	Every possible call pair is halted. Therefore it doesnt need stack, cacheKey, or compareCardinality.
	For example, you might use...
	. is leaf.
	(.(..)) is 0.
	((..).) aka (...) is 1.
	Any combo of 0 and 1 is halted, such as (((1 0)(1 1))((0 0)(0 1))).
	((..)(..)) aka (..(..)) is where you put a universalFunc or similar things.
	Or you might instead use these 4 as something.
	(...)
	(.(..).)
	(..(..))
	(.(..)(..))
	<br><br>
	As usual, you can use any id algorithm you like, but unlike the other kinds of "universalFunc",
	this one is not turingComplete so cant do that without an external system to interpret it,
	so I will probably need to create a default id type,
	such as having up to 128 bits of literal data per 256 bit id,
	and of course you can send bigger blobs of data to be hashed in a tree shape upward to get a single 256 bit id for that large blob.
	Its suggested to use the usual 
	*/
	ocfn3d(true, null, false, false, false, false, true, Uchild.func, Uchild.param),
	
	/** occamsfuncer version 3 iota, the universal lambda function La.a(Lb.Lc.Ld.bd(cd))(Le.Lf.e) aka Lf.fST aka (Pair S T).
	This is the simplest universal lambda BUT it has a big problem in not being able to define an equals function.
	For example, ((La.Lb.Lc.ab)(S I I)(S I I)) does not halt for any param. ocfn3n, ocfn3s, and ocfn3c can all create a func
	that returns T or F depending on if the param is that cuz they can see internal forest of call pairs.
	Iota and most other universal funcs cant. The difference is being both a universal lambda func and a pattern calculus func.
	*/
	ocfn3i(true, 1, true, false, false, false, false, Uchild.func, Uchild.param, Uchild.stack, Uchild.cacheKey),
	
	/** occamsfuncer version 3 iotaPatternCalculus, but with 2 extra params to choose from 4 ops: GetFunc/L GetParam/R IsLeaf/A Iota.
	Unlike ocfn3i, and like ocfn3n, ocfn3r, ocfn3s, and ocfn3c, this ocfn3j can measure equality by forest shape of call pairs.
	Which of 4 ops depends on (IsLeaf firstOf3Params) and (IsLeaf secondOf3Params).
	-- . is that universalFunc and is defined as halted.
	-- I is (..) aka IdentityFunc and is defined as halted.
	-- (L .) is I and is defined as halted.
	-- (R .) is . and is defined as halted.
	-- T is (.(.I)) and is defined as halted. (.I) is defined as halted, so this can work.
	-- S is (.T) and is defined as halted.
	-- F is (TI) and is defined as halted.
	Some of those might be halted naturally, but these slight adjustments to the normal iota func are needed to
	have a simple representation of its middle computing steps between call and return.
	*/
	ocfn3j(true, 1, true, true, false, false, false, Uchild.func, Uchild.param, Uchild.stack, Uchild.cacheKey),
	
	/** occamsfuncer version 3 nano, a universal function that always curries 6 params,
	and it has the same first 7 ops as ocfn3s and ocfn3c but the 8th op is lambda of 5 params (instead of nondet)
	and the first 2 of those params cant be leaf (and last 3 params can be anything)
	cuz if either or both of the first 2 params are leaf then its 3 of the other 7 ops
	cuz (isLeaf firstParamOf6) and (isLeaf secondParamOf6) and (isLeaf thirdParamOf6) chooses which of 8 ops.
	Its 4 way forest (func, param, stack, cacheKey) with bits: isHalted, isParentsFunc.
	<br><br>
	As of 2020-6-29 this has not been coded,
	but the 7 ops have been coded for 10 params so will be easy to port them to 6 params,
	and the last op will be ported from the Big code which is fourth param of 10
	and simply returns e(P,l,r) where l is the first 5 curries and r is the param its called on.
	*/
	ocfn3n(true, 6, true, true, false, false, true, Uchild.func, Uchild.param, Uchild.stack, Uchild.cacheKey),
	
	/** same as ocfn3s except its 9 params instead of 10, excluding ocfn3c's cardinality param */
	ocfn3r(true, 9, true, true, true, true, true, Uchild.func, Uchild.param, Uchild.stack, Uchild.cacheKey),
	
	/** occamsfuncer version 3 simple, a universal function that always curries 10 params,
	and its the same as ocfn3c except it ignores the second of 10 params,
	which is like a second comment param instead of in ocfn3c its cardinality.
	I chose to ignore that param, instead of shrinking to 9 params, so ocfn3s and ocfn3c nodes can be
	copied to eachother at cardinality 0 and have the exact same behaviors except how they interact with cardinality.
	<br><br>
	This is in progress of being implemented in immutable.occamsfuncer.v3c.spec.sparseTuringMachine,
	as of 2020-6-29 the cardinality parts havent been created yet,
	but I plan to code cardinality so TODO try to remember to put a boolean there for is it
	implementing ocfn3s (simple ignores cardinality) vs ocfn3c (cardinality).
	*/
	ocfn3s(true, 10, true, true, true, true, true, Uchild.func, Uchild.param, Uchild.stack, Uchild.cacheKey),
	
	/** occamsfuncer version 3 cardinality, a universal function that always curries 10 params.
	<br><br>
	This is in progress of being implemented in immutable.occamsfuncer.v3c.spec.sparseTuringMachine
	but as of 2020-6-29 the cardinality parts havent been created yet.
	<br><br>
	<br><br>
	OLD WRITING ABOUT IT...
	<br><br>
	UPDATE in progress (TODO rewrite this disorganized big paragraph): I do not believe in haltingOracles but this is more of a  place to optionally expand a constraint system to create combos of general math axioms, when not computing directly forward using the 8 main ops. OccamsfuncerV3 (current code is V2) will be a universal lambda function and pattern calculus function and transfinite function (all at once), which always curries 10 parameters (leaf isDeterministic cardinality comment funcBodyOf6ParamLambdaElseLeaf bitA bitB bitC paramD paramE paramF) where leaf is cardinality 0 and forExample (T (T (T leaf))) is cardinality 3 which allows up to 3 Exists and ForAll within eachother based on doesItHalt_limitedBy_truncateCardinality_to_avoidParadoxes (actually infinity squared number of Exists or ForAll at cardinality 2 which each allow up to infinity Exists or ForAll at cardinality 1 which each allow 0 of them at cardinality 0, as you can have any turing-complete acyclic combo of Exists and ForAll, and have Exists and Forall about such turing-completeness if you jump up 1 more cardinality, and cardinality level goes up to every finite integer such as infinity^200) in the nondet op and isDeterministic is for plugin hooks but its best to do everything deterministicly if you can, a transfinite sparse automata with same BigO as a RandomAccessMachine for eval, BigO of 1 per step (eval is a loop of step), BigO of constant^emulationLevel per step for emulating an emulator... of itself, can directly represent transfinite questions such as "does P equal NP?", questions about the zeros of the zeta function, are there an infinite number of primes, collatz conjecture, BigO of cracking ed25519 or various other algorithms, and can represent axioms needed to in some cases optimize an infinity^2 cost calculation (such as does P equal NP, which has an Exists and ForAll which are 1 then 2 cardinalities deep as a double-loop of doesItHalt_limitedBy_truncateCardinality_to_avoidParadoxes)... can represent a huge variety of possible axioms (unsure how complete in the space of axioms) by fork-editing an emulator of itself to have chosen optimizations which in some cases optimize an infinite cost calculation to a finite cost calculation such as optimizing a function that searches all possible functions for if the are a pair of integer x and integer x+1, which should be very easy to optimize if you know thats the pattern you're looking for, but otherwise at cardinality 1 and higher all calculations must infinite loop cuz they do the most general solution of checking every possibility and by default are optimized to instead directly return (s i i (s i i)) which is an infinite loop, but emulators of the system can do something different than (s i i (s i i)) for cases when there is a faster way to sove a transfinite problem, probably not all possible cases, and I dont know how to prove that a certain function is or is not an emulator of the system, except that statistically computers can challenge-response eachother in turing-complete ways about any possible calculation, using the <func,param,return> caches and other combos of funcs that havent been called yet. Transfinite calculations are considered deterministic even though they (in the default VM, but not necessarily in emulators derived inside the default VM) have infinite cost, since there can be no disagreement among mathematicians of what the result must be if they all had all the relevant info (which may be an infinite amount of info). The system will also be useful for normal programming of GPUs, music tools, 2d 4096x2048 9-bit-color gaming-low-lag graphics, etc. (leaf isDeterministic cardinality comment funcBodyOf6ParamLambdaElseLeaf bitA bitB bitC paramD paramE paramF). If funcBodyOf6ParamLambdaElseLeaf is leaf (aka the universal function) then isLeaf(bitA) isLeaf(bitB) isLeaf(bitC) choose between 8 ops: Lx.Ly.Lz.z which does False and IdentityFunc, Lx.Ly.Lz.y which does True aka K of SKI Calculus, Lx.Ly.Lz.(GetFunc z) and Lx.Ly.Lz.(GetParam z) where (GetFunc w (GetParam w)) equals w for any w other than the state of the stack and where (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf, Lx.Ly.Lz.(IsLeaf z) where IsLeaf returns True or False, Lx.Ly.Lz.zxy aka Pair, Lx.Ly.Lz.xz(yz) aka S of SKI Calculus, and the last is the Nondet op which varies depending on cardinality and at cardinality 0 is Lx.Ly.Lz.(S I I (S I I)) aka infiniteLoop and at higher cardinalities: (nondet leaf leaf x) returns (after infinite time) T if (x leaf) halts else returns F. This is a deterministic transfinite call.
	(nondet leaf anyNonleaf x) is halted if (x leaf) would halt, else never halts, and thats how you make claims about math such as (pseudocode, there is a technical form...) exists possibleNpSolverInPTime forAll possibleSetOfIntegersToSubsetSum funcToCheckIfItSolvesItWithinGivenNumberOfEmulatedCycles, or you could also claim the NOT of that to say P does not equal NP, and these kind of questions would possibly be answerable depending on what axioms are tried in forkEdits of emulators of this system which implement the nondet op at higher cardinalities in some cases in finite time and in most cases still costing infinite time, but if its a question its best to use (nondet leaf leaf x) to ask the question of does it halt instead of to claim a <func,param,return>. This is a deterministic transfinite call.
	(nondet anyNonleaf anything anything) is the normal 3 param nondet that you find in ocfn2
		such as for wallet, spend, ocfnplug, mutableWrapperLambda, and goalFuncNamespace calls. truncateToCardinality
	Happens for every param to at highest the same cardinality as this one, UNLESS its cardinality is leaf (the lowest)
	which is the baseCase. Params of (nondet leaf anything) have cardinality truncated to 1 lower than self's cardinality
	else self cardinality is leaf and (TODO choose 1, i think i did in godelituhedron*.txt but forgot what it was) its some
	constant (such as T or Leaf) or (s i i (s i i)). Think thru the design constraints and it will become clear
	which of those it needs to be, especially considering step func in cardinality 0 has to be Big(1). truncateToDeterministic
	(aDeterministicLambda aDeterministicLambda) evals as normal.
	(aNondeterministicLambda aDeterministicLambda) evals as normal, however the local VM's nondeterminism says to.
	(aNondeterministicLambda anotherNondeterministicLambda) evals as normal, however the local VM's nondeterminism says to.
	(aDeterministicLambda anotherNondeterministicLambda) evals to (aDeterministicLambda (truncateToDeterministic anotherNondeterministicLambda)). Bitstrings, which will be efficiently forkAppendable and possibly faster than Bittorrent and Ipfs, will be made of pairs of True and False like (pair (pair (pair T T) (pair F T)...) and will usually be actually stored in int[] or float[] or double[] or FloatBuffer or CLMem etc. Treemaps will be similar to in ocfn2 (which I didnt finish those in).
	*/
	ocfn3c(true, 10, true, true, true, true, true, Uchild.func, Uchild.param, Uchild.stack, Uchild.cacheKey, Uchild.compareCardinality);
	
	/** You should only use those which are consistent. If its not certainly consistent,
	that means its a theoretical model of computing to be explored and hasnt been verified (yet?) to be consistent
	with godel incompleteness, the impossibility of halting oracles, etc.
	That consistency extends only to correctly designed plugins, if plugins are used.
	*/
	public final boolean isCertainlyConsistent;
	
	public final int curries;
	
	public final boolean isTuringComplete;
	
	/** For example, ((La.Lb.Lc.ab)(S I I)(S I I)) does not halt for any param. ocfn3n, ocfn3s, and ocfn3c can all create a func
	that returns T or F depending on if the param is that cuz they can see internal forest of call pairs,
	cuz they are both universal lambda funcs and pattern calculus funcs.
	*/
	public final boolean patternCalculus;
	
	/** All the universalFuncs in ocfn3 have a pure deterministic subset of funcs that cant call plugins,
	which is the highest security level and guarantees convergence toward perfect Internet sync in space of turing completeness.
	Some kinds of universal func have a layer above that which can also call plugins,
	such as wallet, spend, mutableWrapperLambda, goalFuncNamespace, ocfnplug, or whatever set of plugins
	the specific occamsfuncer VM has.
	The pure deterministic funcs can still be called by plugins, and they can return deterministic immutable data
	that a caller may interpret as a request to a plugin, but why the universalFunc is called and how
	callers interpret its factual math data is outside the scope of the universalFunc.
	A plugin hook is where the universalFunc directly calls the plugin during its stack being nonempty.
	<br><br>
	The plugin hooks all go in the nondet op. Questions or statements about lower cardinalities halting
	are considered transfinite/cardinality deterministic and are not plugins cuz no 2 mathematicians
	which have all the relevant info (which may be an infinite amount of info) can disagree about it.
	(nondet leaf anyNonleaf x) is halted if (x leaf) would halt, else never halts, and thats how you make claims about math
	such as (pseudocode, there is a technical form...)
	exists possibleNpSolverInPTime forAll possibleSetOfIntegersToSubsetSum funcToCheckIfItSolvesItWithinGivenNumberOfEmulatedCycles,
	or you could also claim the NOT of that to say P does not equal NP, and these kind of questions would possibly be answerable
	depending on what axioms are tried in forkEdits of emulators of this system which implement the nondet op at higher cardinalities
	in some cases in finite time and in most cases still costing infinite time, but if its a question its best to use (nondet leaf leaf x)
	to ask the question of does it halt instead of to claim a <func,param,return>. This is a deterministic transfinite call.
	(nondet anyNonleaf anything anything) is where plugins go, such as normal 3 param nondet that you find in ocfn2
		including (incomplete code for some of these) wallet, spend, ocfnplug, mutableWrapperLambda, and goalFuncNamespace calls.
	*/
	public final boolean pluginHook;
	
	/** true if the universalFunc type has a comment param. ocfn2 put that as 1 of the child pointers,
	but ocfn3 always has it as 1 of the curried params of universalFunc. Having a comment param means that param
	is ignored by everything except GetFunc/L and GetParam/R and IsLeaf/A.
	Also, even if a universalFunc doesnt have a comment param, you might still interpret some other part of it
	as a comment, such as in ocfn3n, the "lambda of 5 params (instead of nondet)" op
	could be interpreted as its first param is always comment (else (..) to mean no comment, cuz . isnt allowed there)
	and it has 4 params, or you could make a lambda of Lcomment.Lf.Lp.fp so it ignores the comment param,
	but that would get confusing if that same lambda occurred for some other reason as its a simple combo of calls to do that.
	For that reason, some universalFuncs are designed with 1 of their curried params to mean comment.
	Comment can be any func but is normally a map or some kind of linkedlist of key/value/key/value,
	where keys contain "txt" or "icon" to optionally have the pixels of an icon with some utf8 text,
	or whatever you want to put in there.
	*/
	public final boolean comment;
	
	/** true if the universalFunc was designed for use with compilers,
	such as efficient storage and calculation (such as OpenCL/GPU optimized) of treemaps and bitstrings
	such as 3 bits or up to 2^47-1 bits, or something like that, where bitstring is
	a complete binary tree (cbt) of pairs of T and F, normally stored in 1 or more int[] float[] double[] FloatBuffer, CLMem, etc,
	and abstractly represented as combos of a universalFunc and always actually usable as combos of universalFunc
	which are lazy created as needed.
	This will use the Compiled.java class.
	*/
	public final boolean veryOptimizable;
	
	public final List<Uchild> childs;
	
	private Ufun(boolean isCertainlyConsistent, Integer curries, boolean isTuringComplete, boolean patternCalculus, boolean pluginHook, boolean comment, boolean veryOptimizable, Uchild... childs){
		this.isCertainlyConsistent = isCertainlyConsistent;
		this.curries = curries;
		this.isTuringComplete = isTuringComplete;
		this.patternCalculus = patternCalculus;
		this.pluginHook = pluginHook;
		this.comment = comment;
		this.veryOptimizable = veryOptimizable;
		this.childs = Collections.unmodifiableList(Arrays.asList(childs.clone()));
	}

}
