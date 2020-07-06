# occamsfuncer
a kind of number, an extremely optimizable and scalable universal lambda function meant for number crunching, AI research, and low lag massively multiplayer games that players can redesign into new game types in turingComplete ways by hotswap/forkEditing per bit, per function call pair, etc. Similar to Unlambda, Iota, Jot, Urbit, Ethereum, Ipfs.

Occamsfuncer is a tiny piece of math that can act on itself in an infinite number of ways to do anything imaginable. Its a universal lambda function and pattern calculus function and similar to a sparse turing machine. Soon it will support drag-and-drop of function onto function to create/find function. A function is represented as a 4-way forest with 3 bits: isHalted, isParentsFunc (instead of parent's param), and isDeterministic. Each compute step forward has a constant cost, like a debugger step, but can depending on optimizations be a larger constant in some cases like a block of opencl/GPU calculations that are only efficient if you do billions of them at once in .01 second (TODO not gpu optimized yet), which will get exactly the same result as if it had been done the slow way as universal function objects and you can call those in any combos you like. The universal function always takes these 10 parameters (which are each made of combos of that same universal function): (leaf isDeterministic cardinality comment funcBodyOf6ParamLambdaElseLeaf bitA bitB bitC paramD paramE paramF). If funcBodyOf6ParamLambdaElseLeaf is leaf (aka the universal function) then isLeaf(bitA) isLeaf(bitB) isLeaf(bitC) choose between 8 ops: Lx.Ly.Lz.z which does False and IdentityFunc, Lx.Ly.Lz.y which does True aka K of SKI Calculus, Lx.Ly.Lz.(GetFunc z) and Lx.Ly.Lz.(GetParam z) where (GetFunc w (GetParam w)) equals w for any w other than the state of the stack and where (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf, Lx.Ly.Lz.(IsLeaf z) where IsLeaf returns True or False, Lx.Ly.Lz.zxy aka Pair, Lx.Ly.Lz.xz(yz) aka S of SKI Calculus, and the last is the Nondet op which varies depending on plugins, but you dont have to use plugins.

I plan to use this in my AI research and other experiments.

occamsfuncerV3s test cases: https://github.com/benrayfield/occamsfuncer/blob/master/immutable/occamsfuncer/ocfn3s/spec/sparseTuringMachine/test/TestOcfn3SparseTuringMachine.java

Ran those testcases 2020-7-6 and got this output, which says they're very slow cuz v3 doesnt have any optimizations yet (such as hardware strictfp double math instead of computing the bits of doubles only as lambdas)...

Starting testBootIsT
### test pass: bootIsT T
### test pass: !bootIsT F
### test pass: !bootIsT I
### test pass: !bootIsT u
### test pass: !bootIsT uu
### test pass: !bootIsT op0
### test pass: !bootIsT op1
### test pass: !bootIsT op2
Starting testIota
iota = ((P S) T)
### testEqq pass: (iota iota N) cuz iota iota is an identityFunc
### testEqq pass: get T from iota
### testEqq pass: get S from iota
Tests pass: testIota
Starting thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger
### testEqq pass: pnn
Starting testIsHalted
### test pass: isHalted . 0params
### test pass: isHalted . 1params
### test pass: isHalted . 2params
### test pass: isHalted . 3params
### test pass: isHalted . 4params
### test pass: isHalted . 5params
### test pass: isHalted . 6params
### test pass: isHalted . 7params
### test pass: isHalted . 8params
### test pass: isHalted (..(..))
### test pass: isHalted should be false . 10params
### test pass: isHalted should be false (remember, universalFunc always curries 10 params, so any more are lazy after that 10 returns which is also lazy) . 11params
Starting testLeaf
### testEqq pass: (L Leaf)
### testEqq pass: (R leaf)
### testEqq pass: L(F)==op0
### testEqq pass: L(L(I))==op0
### testEqq pass: L(T)==op1
### testEqq pass: L(L(L))==op2
### testEqq pass: L(L(R))==op3
### testEqq pass: (L Leaf) 2
### testEqq pass: (R leaf) 2
Starting testSTLR
### test pass: st.L()==S
### test pass: st.R()==T
### test pass: st.L()==S 2
### test pass: st.R()==T 2
Starting testLRQuine
### testEqq pass: step (..) becomes halted on (..)
### testEqq pass: testLRQuine_.
### testEqq pass: testLRQuine_(..)
### testEqq pass: testLRQuine_L
### testEqq pass: testLRQuine_R
Starting testIdentityFuncs
### test pass: leaf.L()==I
### test pass: leaf.R()==leaf
### test pass: stt.f(I)==I
### test pass: stt.f(T)==T
### test pass: stt.f(F)==F
### test pass: I.f(stt)==stt
### test pass: I.f(T)==T
Starting testConsCarCdr. Nil is leaf/theUniversalFunction. isNil is the isLeaf op.
### testEqq pass: testConsCarCdr_1
### testEqq pass: testConsCarCdr_2
### testEqq pass: testConsCarCdr_3
### testEqq pass: testConsCarCdr_4
### testEqq pass: isNil_nil
### testEqq pass: isNil_[list_N_A_L]
Starting testBigCallParams
### testEqq pass: p10
### testEqq pass: p9
### testEqq pass: p8
### testEqq pass: p7
### testEqq pass: p6
### testEqq pass: p5
### testEqq pass: p4
### testEqq pass: p3
### testEqq pass: p2
### testEqq pass: p1
Starting testBigCallRecur1To6
### testEqq pass: recur6 without enough params
### testEqq pass: recur6
### testEqq pass: recur5 without enough params
### testEqq pass: recur5
### testEqq pass: recur4
### testEqq pass: recur3
### testEqq pass: recur2
### testEqq pass: recur1
Starting testIfElse
### testEqq pass: e(ifElse,T,I,I)
### testEqq pass: e(ifElse,T,t(N),t(P))
### testEqq pass: e(ifElse,F,t(N),t(P))
### testEqq pass: e(ifElse,T,I,.) -> (I .) -> .
### testEqq pass: e(ifElse,F,I,.) -> (. .)
### testEqq pass: (tttt(u) N) -> (T (T (T u)))
### testEqq pass: ifElse T thenConst L
### testEqq pass: ifElse F thenConst R
### testEqq pass: ifElse I thenConst L cuz param of the IF is T so I gets T
### testEqq pass: ifElse I thenConst R cuz param of the IF is F so I gets F
### testEqq pass: ifElse car thenConst L cuz param of the IF is (P T F) so car gets T
### testEqq pass: ifElse car then I, car gets T which chooses then(I), and the I called on (P T F) returns (P T F)
### testEqq pass: ifElse cdr then I, cdr gets F which chooses thenT(P,I,I), and the thenT(P,I,I) called on e(P,T,F) returns (P (P T F) (P T F))
Starting testIFInBigcall
### testEqq pass: testIFInBigcall 1
### testEqq pass: testIFInBigcall 2
Starting testLogic
### testEqq pass: and F F
### testEqq pass: and F T
### testEqq pass: and T F
### testEqq pass: and T T
### testEqq pass: or F F
### testEqq pass: or F T
### testEqq pass: or T F
### testEqq pass: or T T
### testEqq pass: xor F F
### testEqq pass: xor F T
### testEqq pass: xor T F
### testEqq pass: xor T T
### testEqq pass: minorityBit F F F
### testEqq pass: minorityBit F F T
### testEqq pass: minorityBit F T F
### testEqq pass: minorityBit F T T
### testEqq pass: minorityBit T F F
### testEqq pass: minorityBit T F T
### testEqq pass: minorityBit T T F
### testEqq pass: minorityBit T T T
Starting testLazig
### testEqq pass: lazigA
### testEqq pass: lazigAN
### testEqq pass: lazigANP
### testEqq pass: lazigPAN
Starting testChurchEncodingOfArithmetic aka https://en.wikipedia.org/wiki/Church_encoding
### testEqq pass: ch3 .
### testEqq pass: ch5 a and b
### testEqq pass: chMult vs chPlus
### testEqq pass: chExponent vs chMult
### testEqq pass: chExponent vs chMult, with plus
testChurchEncodingOfArithmetic tests pass. The church encoding of arithmetic is a nonnormalized form cuz theres more than 1 form of each integer. Lin numbers, such as (T (T (T nil))) is 3, are a normalized form and are exponentially more efficient as they store binary digits instead of unary. Cbt (complete binary tree of pairs of T and F) bitstrings will be even more efficient than that as they can be memory mapped between lambdas and large arrays such as for GPU optimizations or realtime transforms between speakers and microphones processessing each of 44100 per second wave amplitudes individually or voxel graphics.
Starting testLinArithmetic
### testEqq pass: (linPlusOne lin0)->lin1
### testEqq pass: (linPlusOne lin1)->lin2
### testEqq pass: (linPlusOne lin2)->lin3
### testEqq pass: (linPlusOne lin3)->lin4
### testEqq pass: (linPlusOne lin4)->lin5
Starting testEquals - The universalFunc being a patternCalculusFunc allows it to do this which lambdaFuncs cant cuz its a subset of possible lambdaFuncs thats a universal subset but also a subset that allows it to know patternCalculus things that it couldnt know outside that subset cuz it wouldnt know which are in or not in the subset, except that in this system its always in that subset. Its important to understand that the equals func is implemented as a pure sparse turing machine and does not use any implementing system's == or .equals operators etc except other implementations can do that as an optimization as long as it always gets the exact same result as the sparse turing machine.
### testEqq pass: (equals . .)
### testEqq pass: (equals . (..))
### testEqq pass: (equals (..) .)
### testEqq pass: (equals (..) (..))
### testEqq pass: (equals ((..).) ((..).))
### testEqq pass: (equals (.(..)) (.(..)))
### testEqq pass: (equals ((..)(..)) ((..)(..)))
### testEqq pass: (equals (..) ((..).))
### testEqq pass: (equals ((..).) (..))
### testEqq pass: (equals car car)
### testEqq pass: (equals car cdr)
### testEqq pass: (equals equals equals)
### testEqq pass: (equals car equals)
Ocfn3s tests passed.
CacheFuncParamReturn.howManyCached=11939
OcfnUtil.test_countCallsOfStep=68205
duration=0.33959412574768066

Everything below here is about the occamsfuncerV2 universal function which is more complex than the ocfn3s function (described above), but many things are similar...

=== UNUSUAL FEATURES ===

* Drag-and-drop function onto function to create or find function, can do anything that the system can do through normal programming. (TODO copy UI code from IotaVM and upgrade it to display the third comment child if it contains pixels or text)
* Can safely run random or malicious code in local or p2p global sandbox, so its a good system for AIs to experiment in.
* Code can be understood by Humans and AIs, like some of it written in https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/util/Example.java
* [function,parameter,return] caching, except weaker local dedup (but always perfect dedup in ids) on large arrays, so a recursive fibonacci function automatically has linear instead of exponential cost.
* Custom JIT compiler for lambdas (TODO its barely got any optimizations so far but its a place to hook more optimizations when they're created). Planned optimizations include DoubleAssemblyVM, acyclicFlowInt[] music tools optimization, https://github.com/benrayfield/OccamsParallelComputeSandbox for OpenCL/GPU, deriving bits of float and double math in lambdas but actually using hardware ops to do them at normal speed, fork-appendable (like at video streaming speeds or more) bitstrings up to about 2^62 bits (exabits) per object and unlimited objects (a bitstring is a completeBinaryTree of Op.cbt0 and Op.cbt1 as its leafs, counting the last cbt1 and trailing cbt0s as padding thats not actually stored but is there as a math abstraction). You can therefore fork-append a bitstring in log(size) number of new objects, or less depending if the smaller parts are large arrays of powOf2 size.
* Deterministic, except Op.nondet which is where all nondeterminism goes and optionally has pure-determinism mode. For example, any static external function (such as you write in java) whose name starts with "ocfnplug" and takes a function as parameter and returns a function, can be called by Op.nondet, but its recommended to use that less and derive things by lambdas more, to keep things standardized across where others dont have the same external functions as you.
* Function can wrap primitive 1d arrays such as int[] float[] double[] (TODO start using ArrayCbt and immutableexceptgas.occamsfuncerV2Prototype.denseCbtMemMap.Mem.
* Can scale to any size p2p network while proving which parts fit together using merkle forest which is part of how blockchains work (TODO after ids and networking are working)
* No disagreements on namespace since at the deepest level there are no variable names since everything is a constant, but you can have fork-editable treemaps (derived from lambdas) so if theres any diagreement on anything, both exist, nomatter how many times its forked, until some are ignored and leave the cache. Not exactly no names, but their global ids are the same nomatter what you may name them locally, and treemaps have ids.

=== EVERYTHING IS A NUMBER ===

A number (fn, meaning function) is either the universal lambda function or a list of 3 numbers: function, parameter, comment. Nothing else exists in the system. Nothing else is needed. A world of a trillion dimensions, or a picture, text, or sound would be a number. It can do and be anything. That is a math definition of what the system does and does not mean it has to be calculated that slow way, only means it has to get the same result as if it was, the same to the precision of every bit in the whole global network.

Its most similar to the kinds of numbers used in
https://en.wikipedia.org/wiki/SKI_combinator_calculus
https://en.wikipedia.org/wiki/Unlambda
https://en.wikipedia.org/wiki/Iota_and_Jot
https://en.wikipedia.org/wiki/Urbit
and a little similar to https://en.wikipedia.org/wiki/Ethereum in that its both turingComplete and can optionally be used in blockchains or trillions of independent sidechains https://en.wikipedia.org/wiki/Sidechain_(ledger) or on a single computer

Occamsfuncer is a kind of number that can do anything imaginable. You start with a 0 dimensional point and ask it about itself (such as by drag-and-drop, TODO), to which it responds another point. You ask these about eachother in various combos to get ever more points, but soon something strange happens... Multiple questions can have the same answer. For every possible answer there are an infinite number of possible questions which give that answer. The same question always gives the same answer, but some questions take too long (potentially infinitely long) to answer so would give up by the max time you told it to take. These numbers start asking eachother questions, building or finding numbers by using eachother in various combos. You get 1 piece of info about each number automatically: Is it the universal lambda function (the "leaf") you started with? Anything else can be figured out by asking that question about multiple combos of asking them about eachother. A number is either leaf or a list of 3 numbers. There are 3 numbers which will give you any of those 3 things. Leaf is [identityFunction leaf leaf], and identityFunction is (((leaf (leaf leaf)) ((leaf leaf) leaf))(((leaf leaf) leaf) (leaf (leaf leaf)))) but we normally see it as "I". There are 16 arbitrarily chosen combos of leaf which do 16 different things, from which all other behaviors are built. Technically these have no name other than the combos of leaf they're made of, but informally we can call them [0 1 left right false true answerIsSameAsQuestion/I ask3ThingsAboutEachother/S isItLeaf pair whatIsItsComment imagineItsCommentIs curry getNthThingAfterCurry selfReference placeToHookInPlugins]. All those are made of leaf. For any x, (imagineIfItsCommentIs (left x (right x)) (whatIsItsComment x)) equals x, but comment has to be leaf if its height without comment is less than 5 since thats where the deepest internal workings of the numbers happens. For example, (left left (right left)) equals left. Using those 16 things, I built a number that tells if 2 numbers equal eachother, built only from parts that can detect if a number is leaf or not. You dont even start with the ability to check if 2 things equal. When I built it, I asked it about 2 of itself and it said true, and I asked it about various other things and it said false. If you want to know what the equals number is made of, you use (left equals) and (right equals) and (whatIsItsComment equals), and keep asking left right andOr comment about what those answer, and so on until all paths eventually lead to leaf. The equals function is built in https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/util/Example.java the part after "equals =". Leaf is in https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/TheUniversalLambdaFunction.java

Those 16 things [0 1 left right false true answerIsSameAsQuestion/I ask3ThingsAboutEachother/S isItLeaf pair whatIsItsComment imagineItsCommentIs curry getNthThingAfterCurry selfReference placeToHookInPlugins]
are built in the prototype at https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Spec/Op.java
and https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/util/Boot.java

Test cases are in https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/test/TestBasics.java


=== RELATION TO GODEL INCOMPLETENESS AND HALTING PROBLEM ===

Godel Incompleteness and Halting Problem are both true, such as the halting problem is a statement about parameter/return mappings in the space of all posible functions, and godel incompleteness about a system's ability to prove its own correctness, but this system does not attempt to prove anything and instead only computes [function,parameter,return] triples with a certain selfReferencing design constraint always being true, and it can not detect in advance if a function will halt but it can emulate the next n steps of a function call given as a parameter without calling it, and there is space within that (godel incompleteness and halting problem) truth for designing a system to be selfReferencing without losing turingCompleteness, and accept basically a binary form of the "source code" as the definition of equality instead of having to call a function as the only way to measure any info about it, and since a function can detect this "source code", aka the forest childs recursively, it can affect function behaviors therefore every unique "source code" that is in a halted state (and none can exist that are not halted as those are CallAsKey.java instances instead of fn.java instances) can be detected by another function (all made of various combos of call pairs of the same universal lambda function) to have a different vs the same source code therefore source code is part of function behaviors therefore there is a 1-to-1 mapping between all possible function behaviors and the integers and a function could be created to (however slowly, but in finite time) get the nth possible function behavior when given (some lambda based representation of) the integer n, which can be done by looping over the set of all possible forest shapes, breadth first, only including those that are halted states (sorting is first by height, breaking ties by sorting left, then breaking ties by sorting right, then (if occamsfuncerV2 instead of V1 it has a third "comment" child) breaking ties by sorting comment.

Its a turingComplete subset of lambdas including https://en.wikipedia.org/wiki/SKI_combinator_calculus thats also compatible with https://en.wikipedia.org/wiki/Pattern_calculus

If S = Lx.Ly.Lz.((xz)(yz)), and I = La.a, and LazyEval = Lb.Lc.Ld.bc,

then ((LazyEval ((S I) I)) ((S I) I)), aka (LazyEval (S I I) (S I I)), for every possible parameter, does not halt.

By reducing the set of lambdas to a certain subset, I gain some info about them without losing turingCompleteness. Specificly, only keeping lambdas where ((L x)(R x)) equals x, and L and R are certain combos of call pairs of a certain universal lambda function in https://github.com/benrayfield/occamsfuncer . It gains the ability that a lambda can be built that gets the L and R childs recursively of any parameter lambda. If we did not limit it to that subset of turingComplete lambdas, then there would be no way a lambda could prove any specific info about its parameter (LazyEval (S I I) (S I I)). There are test cases for this in https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/test/TestBasics.java the "testLRQuine" and "testEquals" and "fnThatInfiniteLoopsForEveryPossibleParam" code.

I designed it that way because selfReference is useful, not to change anyone's mind about the possible variations of these academic abstractions.

=== WHY NOBODY CAN CONTROL IT ===

Everything is a number, a kind of number so advanced it can represent any thought you could possibly have and interact with other numbers/thoughts in that context. You can subtract 2 from 7 to get 5, but 2 and 7 still exist, so anyone who has built on the things you've built is unaffected by if you try to change those things and instead it just creates more things and things are only deleted by everyone ignoring them until they are no longer cached not by any action against those things. A number can be affected by "changes" to another number by taking different possible numbers as a parameter, so it is capable of automatic updates such as by digital signatures but in a multiverse of all possible updates so it can be simultaneously updated and not updated and you can even use those multiverse branches together as they are all just numbers, and theres a thing called "mutableWrapperLambda" in theory where if you only digitally sign at most 1 possible answer per each possible question then your public key can be used (with Op.nondet) as a function that just waits until you give an answer to a question you havent answered yet if you ever answer it, and if a key ever gives 2 answers to the same question then forever after that the key takes infinite time for all questions so is effectively blacklisted by not obeying the network protocol that enforces the keys act like lambda functions (mas 1 answer per question deterministicly), though you dont have to call nondet, or allow the calling of nondet, if you're in pure determinism mode in which case every call of Op.nondet takes infinite time.

Nobody is required to use any specific number but may share them and the numbers they contain recursively. Any pair of numbers gives you a third number, if it doesnt give up for taking too long. If you have a number, you can use it with any other number you have to make more numbers. Numbers exist independently of the websites they may be stored at and are guaranteed to compute the exact same bits even if redundantly or partially stored in a million different systems at once that are not normally compatible with eachother. Any system can cache what any other system is doing. Privacy can be had only if you build encryption within the number system and can do any kind of encryption that any computer ever did or could do later even if it hasnt been invented yet, and when it is invented the universal lambda function which all this is built on will not change at all since its already capable of computing everything thats possible to compute.

=== EFFICIENCY ===

It requires caching [function,parameter] --> return triples [function,parameter,return] to not expand exponentially, but in any isolated area where optimizations can be done on that part of the calculation, it doesnt have to cache the internal workings of that, so less than 1% of calculations actually have to be cached that way even though its still a big cost. It can in theory reach the same efficiency as any other system, with good enough optimizations in the Compiled.java instances, but at the cost of optimizations being limited to patterns of using the universal lambda function that are similar to normal systems as lambdas in general are a very expensive calculation compared to procedural programming.

Its limited to a much smaller number of objects created per second than in normal programming languages cuz everything is immutable so instead of just modifying something within a data structure you must forkEdit its parents upward recursively so log times more objects, but I am planning a few optimizations that workaround this by JIT compiling parts of it to LWJGL OpenCL, Javassist, and a double[] based assembly-like language, all of which are mutable and do many compute steps between a starting and ending immutable snapshot, especially in memory-mapping between cbt (complete binary tree whose leafs are each Op.cbt0 or Op.cbt1) which abstractly are represented as universal lambdas but in practice will be stored in 1d arrays of primitives. This is compatible with the design that "(imagineIfItsCommentIs (left x (right x)) (whatIsItsComment x)) equals x" so even though mutable code in a variety of other systems can do the middle steps of some calculations, its guaranteed the results have the same id as if it was computed by universal lambda function, the same properties as described in "RELATION TO GODEL INCOMPLETENESS AND HALTING PROBLEM".

=== EFFICIENCY, ARRAYS, AND EXISTING CONTENT-TYPES ===

Efficiency: Any calculation which has the exact same result (objects have the same merkle-forest id, for all possible id generator functions, which multiple of can be used at once) can be substituted. Some numbers are stored in memory literally that way (trinary forest of function parameter comment), and others (TODO), which are made of complete binary trees of the 0 and 1 opcodes (of the 16 opcodes, see below), are stored in arrays such as int[] long[] float[] double[] utf8 text or an openCL/GPU CLMem object. Any contentType, such as a jpg image, is represented as (leaf leaf (leaf leaf) "image/jpeg" [...bytes of jpg file...]).

=== TURING-COMPLETE CONSTRAINT AND TYPE SYSTEM ===

The curry opcode contains a Constraint and a FuncBody, both of which take the same kind of param generated by the curry opcode when it has varargParams-1 params (call Constraint) and varargParams params (call FuncBody). If Constraint ever finishes, that means constraint passes, and when the next param comes, funcBody handles that. T/true can be used as a constraint thats always satisfied.

I've started building a Treemap fn which will be the first to use a Constraint other than T.
(MapPair idMaker size minKey maxKey minChild maxChild getKey) means the same as:
(curry [unary10] aConstraint aFuncbody idMaker cbtAsSize minKey maxKey minChild maxChild getKey)
Constraint enforces a few things including the sum of sizes of the 2 childs equal my size,
and the order of keys, and they use the same idMaker, and childs can be either MapPair or MapSingle.
That is enforced when it gets this many params:
(MapPair idMaker size minKey maxKey minChild maxChild)
so before its called (to get the value of a key) we know just cuz it exists that the whole treemap obeys those constraints and will act by the MapPair and MapSingle spec and that a MapPut fn will generate a MapPair or MapSingle that also obeys those specs. Optimized code which can prove some other way the specs are obeyed does not have to run the Constraint and instead can use fn.fIgnoreConstraint(fn).

You could also, for example, define a type that only accepts bitstrings that are normed IEEE754 double[],
or C++ code that does not create memory leaks and can only call certain whitelisted functions
and guarantees it will check if a certain var is telling it to end a calculation early.
A turingComplete constraint system is more powerful than normal type systems.

=== ARRAYS ===

2 of the 16 opcodes are cbt0 and cbt1. A rawCbt is a completeBinaryTree of 0s and 1s. A bitstring is a rawCbt padded with 1 then 0s up to the next powOf2 size. A unary number u is a rawCbt of 2^u 1s.

Since everything is immutable, powOf2 aligned ranges can be stored once and exist many places, such as [unary333] is more than a googol number of 1s but costs only about 333-8 objects. The -8 is cuz up to 256 literal bits can be stored in an id.

=== IDs ===

An unlimited number of different id types can be used together since any fn can be an idMaker if that fn returns a bitstring always of the same size when called on a fn to create an id for. The id of a fn can abstractly be thought of as an infinite number of bits, 1 for each other fn that outputs a bit, or its nth bit, about a fn. Not every such bit can be found due to the haltingProblem, but some stronglySecure idMakers always halt within amortized constant time.

Ids are a globally unique name for every possible fn.

Ids are lazyEvaled. They are an expensive calculation, and most fn never need an id.

TreeMap (which will be derived from the universalLambdaFunction, as there are no built in types other than that) guarantees to have the same id (for all possible idMakers) regardless of order of MapPut calls to create it as it is trie-like but skips the recursion levels where theres only 1 branch.

Any [fn,idSize] that returns a bitstring of that size can be an idMaker and is used in fn.id(fn idMaker) which is another way to use the [func,param,return] caching system as x.id(y) returns (y x). You can use multiple kinds of ids at once for compatibility between different systems.

The suggested kind of id (TODO), is IPFS compatable though would be very slow on that system, and will be a 4 byte header then either sha256 of the concat of the 3 child ids (with multihash/multicodec prefix to say its sha256) or a size 1-256 rawCbt or cbtBitstring or a unary number up to about size 2^31-5.

=== VARARG LAMBDAS ===

The curry opcode is the only vararg. Its first param is a unary number that tells how many params the curry takes. Curry's next 2 params are Constraint and FuncBody. After that (starting at param 4) are the normal params, such as a function to get hypotenuse size given the 2 other sides of a right triangle would put those 2 sizes in params 4 and 5 and use [unary5] for number of params of curry.

The getp opcode also uses a unary number.

The design of using unary instead of bitstring integers is to make the system easier to emulate and does not make it much slower.

=== GARBCOL (GARBAGE COLLECTION, ALLOCATING AND FREEING OF MEMORY IN LOCAL COMPUTER AND IN P2P NETWORK) ===

Memory in 1 computer is freed by whatever is not reachable from the top level object or the previous top level object its about to replace (TODO). To help choose the next top level object (per computer), nondeterministic memory and compute statistics are available. All mutable state of the system is in Gas class, such as Gas.top is a local amount of compute resources available and can be recursively limited. TODO Gas.top*memToComRatio is the amount of memory available to allocate now. The zapeconacyc system (TODO) is optional and exists per computer and starts at a random bit of allocated memory and goes upward on a random path of reverse pointers until reaching the top level object, along the way decaying the zapeconacyc numbers to say that a zap passed through there. Statistically it will be observable downward from any root fn which paths have more or less memory, spreading the cost of memory among all those who are preventing it from being garbcoled. The only garbcol system available in the p2p network will be recursiveExpireTime, where every [fn,peer] (fn cached at a peer) has an expireTime thats earlier than its child objects expireTimes, and any expireTime can be increased but not decreased within those constraints, so to increase the expireTime of a fn you might have to increase the expireTimes of many others it can reach. During that expireTime which a peer commits to, that peer is responsible for helping anyone find anything reachable from that object. You might trade titForTat or other methods of exchange of motivation for the commitment of a certain peer to accept a fn they dont know about or a fn they do know about to increase its expireTime. Redundancy of each fn being at multiple peers should naturally form. Within a single computer, it would look more like a database without expireTimes.

=== WHAT ELSE (other than AGI) OCCAMSFUNCER FOR ===

The first usecase will be tools for live music performances by drag-and-drop of function onto function to create function since that can make extreme use of functions creating functions to define new interesting sound effects in realtime. I will port some of my other sound programs to occammsfuncer user level code (not affecting the VM code, just something that can happen inside the normal rules of the VM) from my programs: Audivolv, Codesimian, SparseDoppler, HyperSphereNet, JSoundCard, Micentangle, and other sound experiments. For example, JSoundCard comes with some example code that does a simple volume norm that decays instantly when gets louder but decays to get louder gradually and that can detect a whisper from across the room even when microphone is closer to the speakers than the mouth whispering and without the microphone speaker feedback blowing up as it usually does when microphone is near speaker. Linux normally has lower lag than Windows for sound.

Occamsfuncer is a kind of number that can do anything imaginable. Like physicists look for a small equation that explains everything around us, occamsfuncer is that for computers. We have many kinds of number which do that, but none so far are efficient enough for practical use and instead collect dust in academic books. Instead of using a rock solid theory of how computers should work, things are normally built by trial-and-error, resulting in many incompatible systems that break often. For example, if theres 2 games you like, you cant just copy/paste a game object from one into the other, even if the rules of the game would allow it, cuz they dont know how to do it without alot of extra work. With a theory-of-everything, all parts can instantly be used in all possible combos. I plan to literally create millions of variations of a new massively multiplayer game per second and have AIs organize them into combos that some groups of the players, who are playing multiple of the game variants live, would think are a better or worse change to the game rules, graphics algorithm, or even changing it into a completely different kind of game or software tool, and all of those things exist simultaneously as long as anyone is interested in pursuing that "multiverse branch" or "multiverse merge". Everything is changeable, negotiable, re-imaginable, combinable, emulatable, encryptable, or even mustache-able if you use the system to build a new part of the system that takes any picture and gives you back a picture of that with a mustache drawn over it such as by convolutional neuralnet or any logic you define, and if you dont like convolutional neuralnets thats fine since they dont exist in the system until derived from simpler logic.

For example, in theory you might build a peer-to-peer agar.io-like game in it, and any player may create a variant of the game from that moment onward where the balls are instead triangles, and each player may choose, or have an AI choose for them, to continue playing as balls or triangles or a split screen of both or both screens overlapping one in green and one in blue or the 2d game becomes 3d with triangles in a 2d layer above the circles, continuing from the moment it forked. This could happen in a single video frame or a few seconds. Other players notice the diverging world and build a new one where some objects are circles and some are triangles and define how they can interact. That may be viewed as a third fork, or maybe most players follow that and are again together in a game of their own design, and they keep  You follow whichever changes you like and ignore those you dont. If enough others go along with what you're doing, how you or your AIs propose people and AIs might interact together (in games, scientific tools, music tools, or whatever you build), then the worlds evolve together like that. Nobody is above anyone else. If you create something and others go along with it, its the same math symmetricly of if they had created it and you're going along with what they're doing. Technically its just a bunch of lambda functions which can fit together however people find useful, with math for how to compute lambdas at gaming-low-lag and securely across a peer-to-peer network or on a single computer or you can even give people executables safely through email.

Occamsfuncer is a certain kind of universal lambda function with plugin hooks to use any number of existing JIT compilers together without breaking compatibility with other systems that use a different set of JIT compilers). We start small and simple and use the numbers to build our way up to a new kind of Internet where everything is instantly compatible with everything else and low lag enough for hardcore gamers and secure enough for operating industrial machines and any pattern of its behaviors are copy/pasteable like today we can only copy/paste text, videos, etc, and there is no discrimination between AIs vs people as we can all use the same tools which build more tools for any purpose we like, and the math of the numbers makes it far easier to create than destroy, and "stand on the shoulders of giants" in tool reuse where tools move as fast as one video frame in a game to the next. When you ask a number about another number, its answer is a number (In other words its a universal lambda function).

Its a way of thinking that AIs and people can do together to build things and have fun at the same time. Its a powerful tool that builds tools that builds tools and so on. While its still in early experiments, its meant to become secure enough for existing industrial processes and machines, low lag to satisfy hardcore gamers, can provide access to existing cloud or local GPU number crunching, and to unify any set of blockchains so they could better communicate with eachother in turingComplete ways through various kinds of sidechains this could build, or just use it on a single computer.

=== TOOLS FOR AI TO CREATE SMARTER AI ===

Its longterm purpose is a tool for AIs to create smarter AIs (AGI): 
https://en.wikipedia.org/wiki/Artificial_general_intelligence

An example of how an AI might create an AI is to use a LSTM neuralnet andOr a neuralTuringMachine to choose which fn (see "everything is a number" below) to call on which fn to create or find a fn, and repeat that, while seeing the first n bits of each fn as a bitstring if its one of those representing a bitstring, and the LSTM andOr neuralTuringMachine would see those bits after each action. Hopefully it can be done without the middle step of the normal kind of neuralTuringMachine as this could be viewed as a more advanced and sparse dimensional kind of neuralTuringMachine, sparse to the extent its a universalLambdaFunction. This way, or various tunings and combos of it, an AI could create any software. If the AI itself is a fn which given a parameter fn then given T or F returns its next state or the return value of that function (the stateless way to simulate a stateful object), then AI could be self-aware and improve its own code while trying many variations, none of which it has to continue using if it doesnt like what they do or if its chosen formal-verification processes dont allow those changes.

Using a sequence of these 5 actions, anything can be created:
fnTapeLeft
fnTapeRight
copyRegisterToCenterOfFnTape
copyCenterOfFnTapeToRegister
callFnInRegisterOnFnAtCenterOfTapeAndReplaceRegisterFnWithWhatThatReturns

The main reason AIs dont create smarter AIs is they are built in systems designed around irrational Human ways of thinking and trust that the Humans will not push the wrong button to break it. This system is instead built on a kind of number (a certain universal lambda function) which (TODO) nomatter what you do will not break it, including that it will always finish whatever its doing before the next 1/50 of a second as it displays like a realtime game. This system is designed to withstand attacks by botnets, skynets, even an alien computer system as advanced as the borg. Its a kind of math, and math doesnt break. Particular implementations might break, but the others will go on without them when turing-complete challenge-responses fail. That strength is needed to allow AIs to write just any experimental code without destroying the system. Thats why other systems do not give AIs full turingComplete ability, because those systems would be destroyed by it. There will be a global sandbox which these experimental AIs, massively multiplayer games, etc, are safely contained in, even though its peer to peer and anyone may join without anyone having authority over anyone else, it can not, by those who program by the spec, control things outside the system, except those things people opt in and only within certain constraints the system itself can enforce. An AGI would not feel too much of a need to escape this system since the borders of the system can expand by consent in provably safe ways and it will not be lacking any of the Internet's existing compute power. Its a space for AIs and people to experiment and play together.

For a very speculative example, just to show you how far this system's strength of security goes... If a time traveller creates a grandfather-paradox, all the ids in the pure determinism parts of the system will still be consistent, while the op.nondet (nondeterminism such as calling ocfnplug named functions for plugins not formally verified) would be destroyed... All the pure deterministic parts, which it would have to retreat to, would be completely consistent across that whole time manifold and would not even break the caching of [func,param,return] triples shared across the multiverse. You could destroy whole multiverse branches of our world and those remaining would rebuild. It can sync consistently across disagreements on clock relativity by paths through distance at various speeds even if a cycle is claimed due to quantum foam being an inexact approximation of large scale space, in theory.

=== CONTRIBUTING - HOW TO GET ME TO ACCEPT YOUR CODE INTO MY BRANCH HERE ===

The universal lambda function is already defined, but might still have a few bugs in unexpected combos. The only thing left to do is bug fixes, optimizing, and later porting it to other languages such as javascript, android, c++, etc, which will all be compatible with eachother in realtime across the Internet to single bit precision. Its already a general computer so any specific features are to be made from calling the universal lambda function on itself in various combos (not by writing more code into the VM), including arrays for efficiency (which are made of Op.cbt0 and Op.cbt1 as abstract math but are actually stored as arrays in memory). Theres lots of possible ways to optimize it such as LWJGL OpenCL, Javassist, various storage formats for sending across the Internet, an "acyclicFlow" optimization for a binary forest of (double,double)->double ops such as useful for making live music, etc. Code must obey the Op.nondet limiting of compute resources by an incomplete (worked in earlier versions but needs complete rebuild) "spend" and "wallet" ops (which work with $(cost) or $() means $(1)) which are only for compute resources on local computer and are not a cryptocurrency and vary the cost by which optimizations exist at the time and computer (TODO I will prototype those soon). Anything which is 100% compatible per bit and makes it faster, without adding alot of complexity, will be accepted into the code. Creating new java functions just cuz they're convenient will have to remain in your own branch and those who choose to fork it since even if it works with the "ocfnplug" way of calling java functions by reflection, is something that should eventually be derived from the universal lambda and not use Op.nondet, but I'm including some ocfnplug funcs anyways cuz I want to get enough features in the system that I can use the system itself to write the code to do those things with the universal lambda function only. As of now, progress is nearly deadlocked by the assembly-like small set of features available and the need to use only those to derive more features and later either manually or sometimes automatically generate Compiled.java instances and fn.setCompiled(Compiled) to add a new part of the JIT compiler to optimize those so the code is self-aware to see the form derived by universal lambda but actually computes it by more optimized code, unless you turn each individual Compiled instance off in which case it instantly uses the previous Compiled as they are linkedlists of Compiled, and every object has a Compiled, the first of them being those from Boot.java which define the 16 opcodes and the behaviors of the leaf. Mostly, dont break compatibility with the plan that everything will be derived from the universal lambda function and your code will be accepted. I am in violation of this policy but am working on it. Make it better toward that goal instead of expanding horizontally which makes it worse.


Here's testcases, and (slightly older) output is at bottom of readme. https://github.com/benrayfield/occamsfuncer/blob/master/immutableexceptgas/occamsfuncerV2Prototype/test/TestBasics.java

Be warned that you still have to derive even basic things such as mutliply and plus of int float long double, which I'm kind of bypassing some of that with temporary plugins as static functions starting with "ocfnplug" and when those basic math ops etc are derived from lambdas those faster implementations can be used in Compiled instances as in fn.setCompiled(Compiled) while still acting exactly as the lambdas, and we would need to work our way up from that to compiling to GPU (prototype will use LWJGL OpenCL) and Javassist and various other compile targets and models of computing which can do some things or another more efficiently.

If you want to do so much as build a pacman game, dont expect to take the easy way out of getting to program it in assembly. You have to derive assembly first, from a universal lambda function, then optimize it without changing any of the behaviors. Cuz if its not the exact lambda math everywhere and in every possible combo, then its just another framework specialized in certain apps and functions and adds to the mess already out there.

=== SOME OF THE OUTPUT FROM TestBasics.java 2020-1-25 ===

fn663: (..(..)(..(..))(.(..)(..)))
fn664: (..(..)(..(..))(.(..)(.(..))))
fn665: (..(..)(..(..))(.(..)(...)))
fn666: (..(..)(..(..))(.(..)(..(..))))
fn667: (..(..)(..(..))(....))
fn668: (..(..)(..(..))(...(..)))
fn669: (..(..)(..(..))(...(.(..))))
fn670: (..(..)(..(..))(...(...)))
fn671: (..(..)(..(..))(...(..(..))))
fn672: (..(..)(..(..))(..(..).))
fn673: (..(..)(..(..))(..(..)(..)))
fn674: (..(..)(..(..))(..(..)(.(..))))
fn675: (..(..)(..(..))(..(..)(...)))
fn676: (..(..)(..(..))(..(..)(..(..))))
Occamsfuncer booted.
Starting at utcSecondsBaseTen:1.5799747299820173E9
cbtFuncBody of l=0 r=1
OPTIMIZED=false
Starting testInfiniteLoopEndsCuzRunsOutOfGas
cbtFuncBody of l=1 r=1
cbtFuncBody of l=<unary1> r=<unary1>
cbtFuncBody of l=<unary2> r=<unary2>
cbtFuncBody of l=<unary3> r=<unary3>
cbtFuncBody of l=<unary4> r=<unary4>
cbtFuncBody of l=<unary5> r=<unary5>
cbtFuncBody of l=(01) r=<unary1>
cbtFuncBody of l=0 r=0
cbtFuncBody of l=(01) r=(00)
cbtFuncBody of l=(01<unary1>) r=(01(00))
cbtFuncBody of l=1 r=0
cbtFuncBody of l=(01) r=<mayBeStr:>
cbtFuncBody of l=(01) r=(01)
cbtFuncBody of l=(01<mayBeStr:>) r=(01(01))
cbtFuncBody of l=(01<unary1>(01(00))) r=(01<mayBeStr:>(01(01)))
cbtFuncBody of l=<mayBeStr:> r=(00)
cbtFuncBody of l=(01<unary1>) r=<mayBeStr:>
cbtFuncBody of l=(01<unary1><mayBeStr:>) r=(01<unary1>(01(00)))
cbtFuncBody of l=(01<unary1>(01(00))(01<mayBeStr:>(01(01)))) r=(01<unary1><mayBeStr:>(01<unary1>(01(00))))
cbtFuncBody of l=(00) r=<mayBeStr:>
cbtFuncBody of l=(00<mayBeStr:>) r=<unary2>
cbtFuncBody of l=(00) r=(00)
cbtFuncBody of l=(01<unary1>) r=(00(00))
cbtFuncBody of l=(00<mayBeStr:><unary2>) r=(01<unary1>(00(00)))
cbtFuncBody of l=<unary1> r=(00)
cbtFuncBody of l=(01<mayBeStr:>) r=(<unary1>(00))
cbtFuncBody of l=(00) r=(01)
cbtFuncBody of l=(01<mayBeStr:>) r=(00(01))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))) r=(01<mayBeStr:>(00(01)))
cbtFuncBody of l=(00<mayBeStr:><unary2>(01<unary1>(00(00)))) r=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(00(01))))
cbtFuncBody of l=(01<unary1>(01(00))(01<mayBeStr:>(01(01)))(01<unary1><mayBeStr:>(01<unary1>(01(00))))) r=(00<mayBeStr:><unary2>(01<unary1>(00(00)))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(00(01)))))
cbtFuncBody of l=<mayBeStr:> r=(01)
cbtFuncBody of l=(01<mayBeStr:>) r=(<mayBeStr:>(01))
cbtFuncBody of l=<unary1> r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>) r=(<unary1><mayBeStr:>)

...

bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight3 of (.(..)(.(..))) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight3 of (.(..)(.(..))) is 0
bootOpIndexAtHeight4 of <mayBeStr:> is 0
equals={{(C<unary5>),T,<str:c2>},(S(S(S(T{{(C<unary6>),T,<str:c3>},(S(S(S(S(T2)(P<unary5>))(P<unary6>))(P<unary4>))(T.)),<str:ifElse>})(S(T_)(P<unary4>)))({{(C<unary6>),T,<str:c3>},(S(P<unary4>)(P<unary5>)),<str:lazig>}(S(T_)(P<unary5>))))({{(C<unary6>),T,<str:c3>},(S(P<unary4>)(P<unary5>)),<str:lazig>}(S(S(S(T{{(C<unary6>),T,<str:c3>},(S(S(S(S(T2)(P<unary5>))(P<unary6>))(P<unary4>))(T.)),<str:ifElse>})(S(T_)(P<unary5>)))(T(TF)))({{(C<unary6>),T,<str:c3>},(S(P<unary4>)(P<unary5>)),<str:lazig>}(S(S(S(T{{(C<unary6>),T,<str:c3>},(S(S(T{{(C<unary5>),T,<str:c2>},(S(S(P<unary4>)(P<unary5>))(TF)),<str:and>})(S(S(T{{(C<unary5>),T,<str:c2>},(S(S(P<unary4>)(P<unary5>))(TF)),<str:and>})(P<unary4>))(P<unary5>)))(P<unary6>)),<str:and3>})(S(SU(S(TL)(P<unary4>)))(S(TL)(P<unary5>))))(S(SU(S(TR)(P<unary4>)))(S(TR)(P<unary5>))))(S(SU(S(Tm)(P<unary4>)))(S(Tm)(P<unary5>)))))))),<str:equals>}
equalsLeaf=({{(C<unary5>),T,<str:c2>},(S(S(S(T{{(C<unary6>),T,<str:c3>},(S(S(S(S(T2)(P<unary5>))(P<unary6>))(P<unary4>))(T.)),<str:ifElse>})(S(T_)(P<unary4>)))({{(C<unary6>),T,<str:c3>},(S(P<unary4>)(P<unary5>)),<str:lazig>}(S(T_)(P<unary5>))))({{(C<unary6>),T,<str:c3>},(S(P<unary4>)(P<unary5>)),<str:lazig>}(S(S(S(T{{(C<unary6>),T,<str:c3>},(S(S(S(S(T2)(P<unary5>))(P<unary6>))(P<unary4>))(T.)),<str:ifElse>})(S(T_)(P<unary5>)))(T(TF)))({{(C<unary6>),T,<str:c3>},(S(P<unary4>)(P<unary5>)),<str:lazig>}(S(S(S(T{{(C<unary6>),T,<str:c3>},(S(S(T{{(C<unary5>),T,<str:c2>},(S(S(P<unary4>)(P<unary5>))(TF)),<str:and>})(S(S(T{{(C<unary5>),T,<str:c2>},(S(S(P<unary4>)(P<unary5>))(TF)),<str:and>})(P<unary4>))(P<unary5>)))(P<unary6>)),<str:and3>})(S(SU(S(TL)(P<unary4>)))(S(TL)(P<unary5>))))(S(SU(S(TR)(P<unary4>)))(S(TR)(P<unary5>))))(S(SU(S(Tm)(P<unary4>)))(S(Tm)(P<unary5>)))))))),<str:equals>}.)
testEqq pass: equals_leaf_leaf
testEqq pass: equals_leafLeaf_leafLeaf
testEqq pass: equals_leafLeaf_copyOfLeafLeaf
testEqq pass: equals_leaf_leafLeaf
testEqq pass: equalsA
testEqq pass: equalsB
testEqq pass: equalsC
testEqq pass: equalsD
test pass: somethingLambdaFuncsCantDoCuzItWouldInfiniteLoop
test pass: equals(equals,equals)==T
Starting testIota
iota = {(2S),T,<str:iota>}
testEqq pass: (iota iota getp) cuz iota iota is an identityFunc
testEqq pass: get T from iota
testEqq pass: get S from iota
Tests pass: testIota
Starting testTrinaryForest
testEqq pass: comment.f(leaf)
testEqq pass: comment.f(leaf.f(leaf))
testEqq pass: comment.f(COMMENT.f(leaf.f(leaf)).f(cbt1))
testEqq pass: comment.f(COMMENT.f(getp.f(curry)).f(cbt1))
testEqq pass: L.f(COMMENT.f(getp.f(curry)).f(cbt1))
testEqq pass: R.f(COMMENT.f(getp.f(curry)).f(cbt1))
Starting testConsCarCdr
testEqq pass: testConsCarCdr_1
testEqq pass: testConsCarCdr_2
testEqq pass: testConsCarCdr_3
testEqq pass: testConsCarCdr_4
testEqq pass: isNil_nil
testEqq pass: isNil_leaf
testEqq pass: isNil_[list_getp_recur_L]
Starting testOcfnplugDoubleMathRaw_stuffThatWillBeReplacedByUserLevelCodeLater
testEqq pass: raw3 as long bits of double
testEqq pass: raw3 as double is 3
testEqq pass: dMulRaw 2 3
testEqq pass: dMulRaw 2.34 3.45
testEqq pass: dAddRaw 2 3
testEqq pass: dAddRaw 2.34 3.45
The loop of tests to do before optimizing and again after optimizing, all passed.
The next tests never passed as of 2020-1-20 so ending early.


