# occamsfuncer
a kind of lazyEvaled shareable 512 bit number, an extremely optimizable and scalable universal lambda function for number crunching, AI research, low lag massively multiplayer games players redesign into new game types in turingComplete ways by hotswap/forkEdit per bit, per function call pair, etc. Similar to Unlambda Iota Jot Urbit Ethereum Ipfs 

The whole system is entirely stateless. There are 2^(1+512*3) possible statements, that x called on y returns z, or does not return z. Anything may be called on anything, instantly resulting in a lazy object that you may continue in small pieces of computing (debugStepInto or debugStepOver_with_cacheKey) to see if it returns eventually, while doing the same thing with many other function calls in a trillion different threads andOr computers (such as a GPU having 3072 cores and a million computers sharing a live calculation across a shared sandbox). The system state is just a set of facts about math that can be cached or uncached that these 512 bits called on those 512 bits result in another specific 512 bits, is that true or false, and unlike blockchains this is a web where many paths lead to the same 512 bits, like (+ 5 10)->15 and (+ 7 8)->15 both lead to 15 (a specific 512 bits nomatter how small or big the data, and in practice will be optimized for bitstrings up to about 2^63-1 bits (1 exabyte, and up to about 2^100 objects which each may be up to an exabyte or lightweight forkEdits of eachother for just a few bits each) which may be just lazy possibilities or specific data in specific gpu, cpu, harddrive etc memory across multiple redundantly stored computers in realtime, such as blitting between user-approved parts of 2 screens across the internet, which are both inside sandbox, and your computers other files etc are outside the sandbox, and since it is stateless, you may to infinite depth UNDO any action such as on your screen pixels BUT only if you still have all the relevant data, or any smaller set of data which it can be derived from, which may have been uncached if you chose not to keep it in lists maps etc which are for their own reasons not yet garbage collectable (garbcol). You know how in an emulator of an old game system you can quicksave and quickload the whole game at any moment... Imagine that but for the whole Internet or big parts of it. In theory, it could loadBalance far better than any existing system, without you even knowing its load balancing (specificly, that if even a single bit is out of place in the whole network, all sets of statements which together can derive a contradiction are themself a contradiction, and its automatic blockchain-like fork (except its a web with many paths between all possible states and eachother, statelessly and timelessly) if anywhere in the network there are more than 0 errors, of course counting human preference of "i thought it was a feature last week but now i think its a bug" has nothing to do with mathematical truth about lambdas though can be modelled by them. Something is a bug only if it does not with infinite precision reproduce the behaviors of every possible bug or bug-free code. If it does what the universal lambda says to, your opinion on its preferred behaviors may vary, but it is perfect and bug free, so dont ask it to calculate the possible behaviors of a virus unless you are interested in that subject and know not to copy from inside the sandbox, where a simulated virus or AI skynet etc may exist, to outside the sandbox into your computer which you may do by opensource at your own risk, but even if you do, that would not allow it into other computers which the sandbox intersects unless they too do the same thing or run a compatible fork of the opensource code as you which may be modified to not protect the sandbox border. The plan is for many compatible opensource forks to implement evolving network and data protocols, themselves safely sandboxed considering permutations of gametheory etc representable in functions themselves, such as an inability to disobey robots.txt or DoS or http POST but can HTTP get within statistical limits and set of consenting addresses, and that such bunch of computers providing general computing and sync service among eachother and people using browsers etc... would together work out the details of an OPEN SPEC of how to compute lambdas together efficiently and at low lag, and most importantly, to reduce code deployment time from "an annoying process" to the time of less than 1 video frame of a game as every possible software, every possible experience, is approximated somewhere in the space of all lambdas, and things might work better if our shared experiences across the internet worked more like math than politics. Like a magnetic bottle may hold antimatter if very careful, the normal web may hold pieces of the deep web in a very flexibly reshapable turing complete sandbox that spans 1 or millions of computers similar to how javascript intersects a website and your browser but cant escape to your private files), like the whole internet was one continuous chip with various bottlenecks). Its like a blockchain that forks and merges equally often, and it doesnt change over time, nor is it a chain. Its a web with many paths from everywhere to everywhere. For example, theres a path from pacman to chess to go back to pacman, and that path is in what functions you might call on functions to build one using the parts of the other. Every function is a unique 512 bit number, or at least in practice nobody will be able to find 2 functions of the same number or 2 numbers for the same function, and in the abstract math it really is an infinite space but in practice the whole internet could fit in that or at least large parts of it be reachable and viewable as these kinds of numbers. And if some flaw is found in the 512 bit kind of number, it can self modify to be any other kind of number that may have better security and efficiency properties as it is the space of all possible functions. A number which outputs such 512 bit numbers is itself a 512 bit number that it will output when called on itself even if it is a lazyEval of that number and that specific number has never been observed, calling the lazy on itself will derive the number so we know it is not just copying the input number since it doesnt exist yet, so you could easily just call another number on things to get different bits or use multiple "id types" at once. There are 32 opcodes chosen in the first 5 of 15 params of the universalFunc each being universalFunc or (universalFunc universalFunc). The first 16 opcodes (where first param is universalFunc) are turingComplete by themself. The other 16 opcodes (where first param is (universalFunc universalFunc)), I'm leaving for future expansion of reflection ops such as debugStepInto and debugStepOver_with_cacheKey and getCacheKey and getStack and pushEmulator and popEmulator etc so you might be a trillion emulators deep inside emulation of emulation of emulation of emulation... in some small part of a software and be able to compute the next step in constant time and find your way back, as an extreme example, cuz emulation would be sparse and similar to a stack instead of a whole program simulating a whole program. In practice, ids will be int64 and local to a computer and only when shared or used as map keys or in some ways of checking for equality are normed to 512 bits. Where first param is not universalFunc or (universalFunc universalFunc), thats a space for possible future expansion that other systems may be mounted into aka viewed through.

EDIT: testcases at https://github.com/benrayfield/occamsfuncer/blob/master/immutable/occamsfuncer/simpleSlowPrototype/TestSpec.java TODO fix broken links below and rewrite this disorganized text.

<img src=https://raw.githubusercontent.com/benrayfield/occamsfuncer/master/data/occamsfuncer/pics/DragTree%202020-11-11.png>
This pic is meant to resize its parts so it looks like indented code with multiple things per line, and the pairs in linkedlists will be displayed as 0 size, and SCurryLists {x y} being (S x y) and {x y z} being ((S ((S x) y)) z) will just display the x y z and those S as 0 size and will display the type of syntax [ { ( IF thenT thenConst pixels sound etc at the top left corner of each rectangle. For now it looks like an assembly language for pure functional programming (see "the 16 ops" below), but its going to be very intuitive by grabbing things and putting them on other things to create or find more things. The pic displays OcfnUtil.P.e(OcfnUtil.Equals()).e(OcfnUtil.op(12)) and can display any fn. Every fn is immutable and made of 2 immutable fns. The universal function is displayed as ".", and its 2 childs are identityFunc/I and itself. Left click to display childs (2 rectangles inside a rectangle). Right click to stop displaying those childs. It goes infinitely deep cuz its a pattern calculus function. Its also a universal lambda function that always curries 15 params. Mouse wheel on parents border resizes the 2 childs but doesnt resize parent. Middle click to switch between above/below and left/right display of childs in a certain rectangle. The left or above rectangle is fn.func()/L and the right or below rectangle is fn.param()/R. For any fn x, (L x (R x)) aka ((L x)(R x)) equals x. For example, you see the equals function in there, and (equals equals equals)->T aka true, and (equals car cdr)->F aka false. The next step in creating this UI is to drag a fn (a rectangle) onto a fn to call it. Every fn displayed is the call of its 2 childs which returns that parent, else it would be displayed as whatever it returns, if it ever returns. If it does not return in some chosen time limit, like max 1 second, or .02 seconds during a game, then it will give up (TODO wallet and spend ops from other forks of occamsfuncer, port that to here. used with op.nondet). Imagine multiple of these outermost rectangles moving around in open space, and when you touch 2 of them together one gets called on the other (left called on right, or top called on bottom), whatever 2d area they both occupy, and they would have to be the same height or width (but not both) to touch eachother that way, then that combined rectangle is either halted (returns itself) or is replaced by whatever it does return. For example, you drag (+ 2) to the left of 5, aka (+ 2 5) aka ((+ 2) 5) and its replaced by 7, but if you drag + and 2 together it just stays as (+ 2). If you have 3 rects of #equals and drag 2 equals together you get (equals equals) as its waiting for another param. If you then drag equals to the left of that you get (equals (equals equals)) which is waiting for another param. If you then drag (equals equals) to the right of that, (equals (equals equals) (equals equals))->T so is replaced by T. Or they might roll up into balls or icons and move around, and some of them will generate int colorARGB pixels (see lazycl LazyBlob, which will be used to optimize occamsfuncer by JIT compiling it to lwjgl opencl for gpu and javassist for cpu, TODO) so some of these rectangles will be pictures, videos, recorded sounds, interactive sound effects practically usable in live music performances, games, pieces of the internet, AI experiments, and whatever else a bunch of people want to build and play with together in the turing complete space of all possibilities.


=== UNUSUAL FEATURES ===

* Drag-and-drop function onto function to create or find function, can do anything that the system can do through normal programming. (TODO copy UI code from IotaVM and upgrade it to display the third comment child if it contains pixels or text)
* Can safely run random or malicious code in local or p2p global sandbox, so its a good system for AIs to experiment in.
* Code can be understood by Humans and AIs, like some of it written in https://github.com/benrayfield/occamsfuncer/blob/master/immutable/occamsfuncer/simpleSlowPrototype/TestSpec.java
* [function,parameter,return] caching, except weaker local dedup (but always perfect dedup in ids) on large arrays, so a recursive fibonacci function automatically has linear instead of exponential cost.
* Custom JIT compiler for lambdas (TODO its barely got any optimizations so far but its a place to hook more optimizations when they're created). Planned optimizations include DoubleAssemblyVM, acyclicFlowInt[] music tools optimization, https://github.com/benrayfield/OccamsParallelComputeSandbox (UPDATE: lazycl instead of that, or maybe merge those 2) for OpenCL/GPU, deriving bits of float and double math in lambdas but actually using hardware ops to do them at normal speed, fork-appendable (like at video streaming speeds or more) bitstrings up to about 2^62 bits (exabits) per object and unlimited objects (a bitstring is a completeBinaryTree of Op.cbt0 and Op.cbt1 as its leafs, counting the last cbt1 and trailing cbt0s as padding thats not actually stored but is there as a math abstraction). You can therefore fork-append a bitstring in log(size) number of new objects, or less depending if the smaller parts are large arrays of powOf2 size.
* Deterministic, except Op.nondet which is where all nondeterminism goes and optionally has pure-determinism mode. For example, any static external function (such as you write in java) whose name starts with "ocfnplug" and takes a function as parameter and returns a function, can be called by Op.nondet, but its recommended to use that less and derive things by lambdas more, to keep things standardized across where others dont have the same external functions as you.
* Function can wrap primitive 1d arrays such as int[] float[] double[] (TODO start using ArrayCbt and immutableexceptgas.occamsfuncerV2Prototype.denseCbtMemMap.Mem.
* Can scale to any size p2p network while proving which parts fit together using merkle forest which is part of how blockchains work (TODO after ids and networking are working)
* No disagreements on namespace since at the deepest level there are no variable names since everything is a constant, but you can have fork-editable treemaps (derived from lambdas) so if theres any diagreement on anything, both exist, nomatter how many times its forked, until some are ignored and leave the cache. Not exactly no names, but their global ids are the same nomatter what you may name them locally, and treemaps have ids.

=== EVERYTHING IS A NUMBER ===

A number (fn, meaning function) is either the universal lambda function or a list of 3 numbers: function, parameter, comment (UPDATE: just function and parameter, cuz comment moved to 1 of the 15 curried params of the universal function, a different param index depending which of the 16 opcodes which are in the first 5 params, and the first param is either the universal function as normal or is anything else to mount other systems like you might mount something at (universalFunc "myThingXYZ") so (universalFunc "myThingXYZ" ...params...) does stuff, but some in strict/deterministic mode it infinite loops for anything except those 16 ops). Nothing else exists in the system. Nothing else is needed. A world of a trillion dimensions, or a picture, text, or sound would be a number. It can do and be anything. That is a math definition of what the system does and does not mean it has to be calculated that slow way, only means it has to get the same result as if it was, the same to the precision of every bit in the whole global network.

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

UPDATE: TODO: there is no need at this low of a level to blacklist any public keys due to breaking the rules of how to act like a lambda function, since that part will be to sign bitstrings, without enforcing how those bitstrings signed are to be interpreted, so it is impossible for a public key to break the rules since there are no rules since any possible input output pair of the public key can be included, but only as the output, sig, and verifier. (ed25519 password message)->(pubKey sig message) where (pubKey sig message leaf)->leaf if its verified else infiniteLoops.
OLD...
Everything is a number, a kind of number so advanced it can represent any thought you could possibly have and interact with other numbers/thoughts in that context. You can subtract 2 from 7 to get 5, but 2 and 7 still exist, so anyone who has built on the things you've built is unaffected by if you try to change those things and instead it just creates more things and things are only deleted by everyone ignoring them until they are no longer cached not by any action against those things. A number can be affected by "changes" to another number by taking different possible numbers as a parameter, so it is capable of automatic updates such as by digital signatures but in a multiverse of all possible updates so it can be simultaneously updated and not updated and you can even use those multiverse branches together as they are all just numbers, and theres a thing called "mutableWrapperLambda" in theory where if you only digitally sign at most 1 possible answer per each possible question then your public key can be used (with Op.nondet) as a function that just waits until you give an answer to a question you havent answered yet if you ever answer it, and if a key ever gives 2 answers to the same question then forever after that the key takes infinite time for all questions so is effectively blacklisted by not obeying the network protocol that enforces the keys act like lambda functions (mas 1 answer per question deterministicly), though you dont have to call nondet, or allow the calling of nondet, if you're in pure determinism mode in which case every call of Op.nondet takes infinite time.

Nobody is required to use any specific number but may share them and the numbers they contain recursively. Any pair of numbers gives you a third number, if it doesnt give up for taking too long. If you have a number, you can use it with any other number you have to make more numbers. Numbers exist independently of the websites they may be stored at and are guaranteed to compute the exact same bits even if redundantly or partially stored in a million different systems at once that are not normally compatible with eachother. Any system can cache what any other system is doing. Privacy can be had only if you build encryption within the number system and can do any kind of encryption that any computer ever did or could do later even if it hasnt been invented yet, and when it is invented the universal lambda function which all this is built on will not change at all since its already capable of computing everything thats possible to compute.

=== EFFICIENCY ===

It requires caching [function,parameter] --> return triples [function,parameter,return] to not expand exponentially, but in any isolated area where optimizations can be done on that part of the calculation, it doesnt have to cache the internal workings of that, so less than 1% of calculations actually have to be cached that way even though its still a big cost. It can in theory reach the same efficiency as any other system, with good enough optimizations in the Compiled.java instances, but at the cost of optimizations being limited to patterns of using the universal lambda function that are similar to normal systems as lambdas in general are a very expensive calculation compared to procedural programming.

Its limited to a much smaller number of objects created per second than in normal programming languages cuz everything is immutable so instead of just modifying something within a data structure you must forkEdit its parents upward recursively so log times more objects, but I am planning a few optimizations that workaround this by JIT compiling parts of it to LWJGL OpenCL, Javassist, and a double[] based assembly-like language, all of which are mutable and do many compute steps between a starting and ending immutable snapshot, especially in memory-mapping between cbt (complete binary tree whose leafs are each Op.cbt0 or Op.cbt1) which abstractly are represented as universal lambdas but in practice will be stored in 1d arrays of primitives. This is compatible with the design that "(imagineIfItsCommentIs (left x (right x)) (whatIsItsComment x)) equals x" so even though mutable code in a variety of other systems can do the middle steps of some calculations, its guaranteed the results have the same id as if it was computed by universal lambda function, the same properties as described in "RELATION TO GODEL INCOMPLETENESS AND HALTING PROBLEM".

=== EFFICIENCY, ARRAYS, AND EXISTING CONTENT-TYPES ===

Efficiency: Any calculation which has the exact same result (objects have the same merkle-forest id, for all possible id generator functions, which multiple of can be used at once) can be substituted. Some numbers are stored in memory literally that way (trinary forest of function parameter comment), and others (TODO), which are made of complete binary trees of the 0 and 1 opcodes (of the 16 opcodes, see below), are stored in arrays such as int[] long[] float[] double[] utf8 text or an openCL/GPU CLMem object. Any contentType, such as a jpg image, is represented as (leaf leaf (leaf leaf) "image/jpeg" [...bytes of jpg file...]).

=== TURING-COMPLETE CONSTRAINT AND TYPE SYSTEM ===

UPDATE: theres no vararg and no curry opcode anymore. If you want type checking you call a function on it at runtime to check if its the type of thing that function returns (anything) for, and if it doesnt return then its not that type, and by automatic [func param return] caching, that call to check its type will only happen once until uncached.

OLD... The curry opcode contains a Constraint and a FuncBody, both of which take the same kind of param generated by the curry opcode when it has varargParams-1 params (call Constraint) and varargParams params (call FuncBody). If Constraint ever finishes, that means constraint passes, and when the next param comes, funcBody handles that. T/true can be used as a constraint thats always satisfied.

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

uses pair (P) function to form complete binary trees (cbt) of T and F.

OLD...
2 of the 16 opcodes are cbt0 and cbt1. A rawCbt is a completeBinaryTree of 0s and 1s. A bitstring is a rawCbt padded with 1 then 0s up to the next powOf2 size. A unary number u is a rawCbt of 2^u 1s.

Since everything is immutable, powOf2 aligned ranges can be stored once and exist many places, such as [unary333] is more than a googol number of 1s but costs only about 333-8 objects. The -8 is cuz up to 256 literal bits can be stored in an id.

=== IDs ===

IDs are lazyEvaled since most objects never need one. IDs will be 512 bits, including up to 256 literal bits or a sha3-256 hash of its childs, and including int64 bitstring length, and including int64 pointer into bitstring or its internal nodes (binheap indexing similar to urbit), and including a few bit masks and small numbers for a simple kind of compression such as only storing x and y if its actually ((pair x) y) aka (pair x y) but in a way that (L (pair x y))->(pair x) even though (pair x) isnt normally stored, but (idMaker (L (pair x y))) gives the same 512 bits as if it were stored. Similarly, the id of an id usually fits in 512 bits by just adding 1 in some small number in the header, and only if that number is about to overflow would you need a pair of literal 256 bits (each 512 bits) to store the 512 bit id. Given a set of id[3] (func param return), such as [L, (pair x y), (pair x)] which are each 512*3 bits (or the first 2 are in fn.cacheKey.L and fn.cacheKey.R and the return is fn.L and fn.R, if its 1 step before returning)... given such a set of id[3] or set of callquads/fnWithCacheKey, the whole system state and cache can be computed in a decentralized way, except that someone could still make up 512 bits thats not a function at all and when computer asks them for its childs they dont respond or it could be a call that takes a trillion years to finish and they claim it returns some thing or another and who can disprove it, so I'm hesitant to recommend sharing the [func,param,return] caches across untrusted borders, but sharing halted functions [x.L, x.R, x] (cuz (L x (R x))->x for all x) is easier to sparsely verify in a p2p net in theory.

OLD...
An unlimited number of different id types can be used together since any fn can be an idMaker if that fn returns a bitstring always of the same size when called on a fn to create an id for. The id of a fn can abstractly be thought of as an infinite number of bits, 1 for each other fn that outputs a bit, or its nth bit, about a fn. Not every such bit can be found due to the haltingProblem, but some stronglySecure idMakers always halt within amortized constant time.

Ids are a globally unique name for every possible fn.

Ids are lazyEvaled. They are an expensive calculation, and most fn never need an id.

TreeMap (which will be derived from the universalLambdaFunction, as there are no built in types other than that) guarantees to have the same id (for all possible idMakers) regardless of order of MapPut calls to create it as it is trie-like but skips the recursion levels where theres only 1 branch.

Any [fn,idSize] that returns a bitstring of that size can be an idMaker and is used in fn.id(fn idMaker) which is another way to use the [func,param,return] caching system as x.id(y) returns (y x). You can use multiple kinds of ids at once for compatibility between different systems.

The suggested kind of id (TODO), is IPFS compatable though would be very slow on that system, and will be a 4 byte header then either sha256 of the concat of the 3 child ids (with multihash/multicodec prefix to say its sha256) or a size 1-256 rawCbt or cbtBitstring or a unary number up to about size 2^31-5.

=== VARARG LAMBDAS ===

UPDATE: always 15 params. 7 of the 16 opcodes are any lambda of 1-7 params, and if you want more params you derive a function that adds them to a linkedlist and when the linkedlist gets big enough uses it, or just use a linkedlist directly.

OLD...

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


EDIT: testcases at https://github.com/benrayfield/occamsfuncer/blob/master/immutable/occamsfuncer/simpleSlowPrototype/TestSpec.java
TODO fix broken links below and rewrite this disorganized text.

EDIT: This paragraph is old but similar to the new one (SPEC paragraph after it), mostly in that the universal function always takes 15 parameters, has 16 opcodes, and 7 of those opcodes are any lambda of 1-7 params. (((((Occamsfuncer is a tiny piece of math that can act on itself in an infinite number of ways to do anything imaginable. Its a universal lambda function and pattern calculus function and similar to a sparse turing machine. Soon it will support drag-and-drop of function onto function to create/find function. A function is represented as a 4-way forest with 3 bits: isHalted, isParentsFunc (instead of parent's param), and isDeterministic. Each compute step forward has a constant cost, like a debugger step, but can depending on optimizations be a larger constant in some cases like a block of opencl/GPU calculations that are only efficient if you do billions of them at once in .01 second (TODO not gpu optimized yet), which will get exactly the same result as if it had been done the slow way as universal function objects and you can call those in any combos you like. The universal function always takes these 10 parameters (which are each made of combos of that same universal function): (leaf isDeterministic cardinality comment funcBodyOf6ParamLambdaElseLeaf bitA bitB bitC paramD paramE paramF). If funcBodyOf6ParamLambdaElseLeaf is leaf (aka the universal function) then isLeaf(bitA) isLeaf(bitB) isLeaf(bitC) choose between 8 ops: Lx.Ly.Lz.z which does False and IdentityFunc, Lx.Ly.Lz.y which does True aka K of SKI Calculus, Lx.Ly.Lz.(GetFunc z) and Lx.Ly.Lz.(GetParam z) where (GetFunc w (GetParam w)) equals w for any w other than the state of the stack and where (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf, Lx.Ly.Lz.(IsLeaf z) where IsLeaf returns True or False, Lx.Ly.Lz.zxy aka Pair, Lx.Ly.Lz.xz(yz) aka S of SKI Calculus, and the last is the Nondet op which varies depending on plugins, but you dont have to use plugins.)))))

I plan to use this in my AI research and other experiments.

THE SPEC (IMPLEMENTED IN https://github.com/benrayfield/occamsfuncer/blob/master/immutable/occamsfuncer/simpleSlowPrototype/OcfnUtil.java OcfnUtil.step, which I interpret as a complete enough spec now that it has proven that (equals equals equals)->T and has the basics of lisp such as cons car cdr isNil)[
This completely defines the occamsfuncer universal function of 15 params (including an infinite area, 1-15 params,
reserved for future expansion such as VM internals or forks of occamsfuncer, branching on the first param),
which is a universal lambda function (combinator) and a pattern calculus function,
from which all possible functions can be created and potentially any system mounted.
The system is represented (as abstract math, but may be implemented more efficient ways)
as an immutable binary forest, where all paths lead to the same leaf/u.
That leaf is the universal function, so lets call it u. Everything in the system is made of combos of u.
Binary forest nodes can be found/added by choosing any 2 nodes (which may be the same node) as its 2 childs,
which calls one on the other and returns itself if it doesnt have enough params to eval yet or
returns something else or never returns,
or in a constraint area (first param is (u u) for VM internals) only returns itself if the constraint is proven.
Those childs are called its Func/L and its Param/R, as its a binary forest of call pairs.
A specific binary forest node, based only on the forest shape reachable from it,
is either halted or (a snapshot of) evaling,
and to represent evaling states you need 4 childs [func param stack cacheKey] and 2 bits [isHalted, isParentsFunc],
where isHalted is a cache of all its childs recursively also being halted, and isParentsFunc
defines if self is parentNode.func or [parentNode.param or has no stack] (since its possible for those to equal),
which are called callQuads (instead of callPairs) which always step (like in a debugger) to next callQuad in bigO(1),
which will be demoed in the java code of this spec but are outside the scope of the universal function itself.
It takes 1-15 curried params, which are all made of combos of u.

The first param is protocol.
If the first param is u, it takes exactly 15 params and is the main turingComplete logic.
If the first param is not u (^), by default it infinite loops before returning from the first curry,
and could be upgraded to be an infinite space of a variety of other systems for possible future expansion... (continued farther below).

If the first param is u, the next 4 params choose 1 of 16 opcodes,
as each of those params is [leaf (u) or anything except leaf (^)] (a leafbit).

The 0th param is always u. Lets call it and the 15 params: u b c d e f g h i j k l m n o p.
Dont confuse those with F/False and I/IdentityFunc.

Lets call "anything except u" "^".
Lets call "anything" "*".  

(u ^) -> infiniteLoop, except when used for VM internals andOr forks of occamsfuncer. For future expansion.

The 16 ops:

op0 (u u u u u f g h i j k l m n o p) -> infiniteLoop (such as (S I I (S I I)) in strictMode, else (VM_nondet (pair (u u u u u f g h i j k l m n o) p)) as a way to request things from the occamsfuncer VM. //nondet

op1  (u u u u u ^ g h i j k l m n o p) -> (n (pair (u u u u u ^ g h i j k l m n o) p)) //bigCall1, (p)

op2  (u u u u ^ u g h i j k l m n o p) -> (m (pair (u u u u ^ u g h i j k l m n o) p)) //bigCall2, (o p)

op3  (u u u u ^ ^ g h i j k l m n o p) -> (l (pair (u u u u ^ ^ g h i j k l m n o) p)) //bigCall3, (n o p), aka (... k/comment l/funcBody m/context n o p)

op4  (u u u ^ u u g h i j k l m n o p) -> (k (pair (u u u ^ u u g h i j k l m n o) p)) //bigCall4, a lambda of 4 params (m n o p) where the k/funcBody param can get those params

op5  (u u u ^ u ^ g h i j k l m n o p) -> (j (pair (u u u ^ u ^ g h i j k l m n o) p)) //bigCall5, a lambda of 5 params (l m n o p) where the j/funcBody param can get those params

op6  (u u u ^ ^ u g h i j k l m n o p) -> (i (pair (u u u ^ ^ u g h i j k l m n o) p)) //bigCall6, (k l m n o p), aka (... h/comment i/funcBody j/context k l m n o p)

op7  (u u u ^ ^ ^ g h i j k l m n o p) -> (h (pair (u u u ^ ^ ^ g h i j k l m n o) p)) //bigCall7, (j k l m n o p)

op8  (u u ^ u u u g h i j k l m n o p) -> o //T, the K in SKI Lambda Calculus

op9  (u u ^ u u ^ g h i j k l m n o p) -> p //FI, does False and IdentityFunc depending on number of curries

op10 (u u ^ u ^ u g h i j k l m n o p) -> (VM_L p) //L, get left child, its func, where (L x (R x)) equals x for all possible x

op11 (u u ^ u ^ ^ g h i j k l m n o p) -> (VM_R p) //R, get right child, its param, where (L x (R x)) equals x for all possible x

op12 (u u ^ ^ u u g h i j k l m n o p) -> (VM_IsLeaf p) aka [T if p is u, else F] //IsLeaf

op13 (u u ^ ^ u ^ g h i j k l m n o p) -> (n p (o p)) //S, as in SKI Lambda Calculus

op14 (u u ^ ^ ^ u g h i j k l m n o p) -> (p n o) //Pair, such as (Pair n o) is halted and (Pair n o T)->n and (Pair n o F)->o

op15 (u u ^ ^ ^ ^ g h i j k l m n o p) -> infiniteLoop (such as (S I I (S I I)) //Typeval, a semantic such as for type/n is "image/jpeg" and val/o is bitstring of that image, ignoring p. Any objects, not just strings and bitstrings.

(VM_L x) -> left/func child of x in binary forest if x is not u, else I/IdentityFunc.
(VM_R x) -> right/param child of x in binary forest if x is not u, else u.
(VM_IsLeaf x) -> T if x is u, else F.
Optional: VM_isStrict -> T or F depending if running in strictMode/isDeterministic. Non-strict-mode can choose to become strictMode at a point in stack which is
	enforced everywhere higher in stack until returning to same place in stack, but strictMode cant choose to become non-strict-mode. 
Optional: (VM_nondet x) -> This is where plugins and memory and compute statistics are hooked in, such as the spend op limits how much memory
	and compute cycles a call higher on stack can use and it may further limit it to calls it makes, or the solve call where (solve x)
	returns any y where (x y)->u else never halts and (solve x) is used for computers in peer to peer network to query eachother for simple
	patterns such as a digitalSignature of a certain publicKey which signed (pair y z) and its solving for that publicKey and y.

(IsLeaf u) -> T

(IsLeaf ^) -> F

(L u) -> I

(R u) -> u

FIXME some of these are wrong. I reordered the opcodes after writing this, but dont plan to reorder them again[
(u u (u u) u u u u u u u u u u u) is T.

(u u (u u) u u (u u) u u u u u u u u) is F.

(u u (u u) u u (u u) u u u u u u u u u) is I.

(u u (u u) u (u u) u u u u u u u u) is S.

(u u (u u) (u u) (u u) u u u u u u u u) is Pair.

(u u (u u) (u u) (u u) u u u u u u u u n o) is Pair of n and o.

(u u (u u) (u u) (u u) u u u u u u u u (u u (u u) u (u u) u u u u u u u u) (u u (u u) u u u u u u u u u u u)) is (Pair S T) aka iota.
]

(Pair S T) is the iota lambda aka Lf.f(Lx.Ly.Lz.xz(yz))(Lq.Li.q).

(iota (iota (iota iota))) -> T.

(iota (iota (iota (iota iota)))) -> S.

(iota iota "image/jpeg") -> "image/jpeg".

(L iota) -> (Pair S).

(R iota) -> T.

(L iota (R iota)) -> iota. 

(L x (R x)) -> x, for any x. For example, (L L (R L)) -> L, and (L u (R u)) -> u, and (L "image/jpeg" (R "image/jpeg")) -> "image/jpeg".

(L "image/jpeg") -> a complete binary tree of pairs of pairs... of T and F of the bits of utf8 of "image/jp" as its powOf2 aligned.
Bitstrings are padded with T then 0 or more of F until the next powOf2 number of bits but in practice will be stored in concat of 1 or more arrays.
If you want things displayed as string vs raw bits, or as double vs 64 raw bits, etc, then use typeval which is for such semantics.

(Typeval "image/jpeg" {bytesOfJpg}).

(L (Typeval "image/jpeg" {bytesOfJpg})) -> (Typeval "image/jpeg").

(L (Typeval "image/jpeg")) -> Typeval.

(R (Typeval "image/jpeg")) -> "image/jpeg".

(R (Typeval "image/jpeg" {bytesOfJpg})) -> {bytesOfJpg}.

(Typeval "double[]" {bitstringOfDoubleArray}).
	

Optional: The semantic is, if the first param of Typeval is a bitstring (complete binary tree of pairs of T and F,
with at least 1 T where padding starts) and is also valid UTF8, then its displayed as a string.
Other things would need to be in a typeval if you want to say they are a string or image/jpeg or or any existing contentType/mediaType.
This is optional cuz technically the universal function doesnt know about any of this but user level code can
choose to look at it, using L and R (and derived equals function etc) recursively, and react based on what it sees any chosen way,
so you might have multiple interpretations of what is and isnt a valid jpg file or if the spec for jpg is ambiguous
about the low bits of precision of pixel color or lossy wave compression etc, then each of those possibilities
can be a separate unambiguous function which, given any function, returns a function (if it ever halts),
some of those functions being bitstrings such as of an int[1024][1024] block of pixels or an int being a voxel or whatever.

Optional: There is a suggested place for a comment param (can be anything) and a context/cx param (pair salt treemap),
but those are outside the scope of this spec and can be implemented as combos of u if you like,
but they are described here cuz the spec was designed to make it easy to use the system various ways similar to that
and exactly which of those possible ways is left to user level code (what functions are built from combos of u),
which would be implemented by deriving (from combos of u) 2 functions: (setComment x newComment) and (getComment x),
keeping in mind that everything is immutable so you can only forkEdit things without modifying the things themselves.
That suggested place for comment is just before the last param used on the right side of ->
such as the the T func takes 2 params so T-with-comment takes 3 params, comment going just before those 2,
and comment is ignored, or the S func takes 3 params so S-with-comment takes 4 params and ignores comment,
and in bigCall1 to bigCall7 comment goes just before funcBody (before: n m l k j i or h).
The context/cx param only exists in bigCall1 to bigCall7, is the first param of their 2-8 params
and would normally be automatically handled for forking the salt param in (pair salt treemap)
for use with the nondet op such as wallet and spend calls to recursively allocate compute resources,
request solutions to turing-complete queries across the network to peers, etc,
in the simplest case an ed25519 digital signature on a 256 bit id of (pair "whats 2+2?" "4")
would mean that publicKey answered "4" to the question of "whats 2+2?",
but in practice there will be more info in the things signed such as utcnano time, ids of other peers, whole functions, etc.

Optional: If the first param is not u, by default it infinite loops before returning from the first curry,
and could be upgraded to be an infinite space for possible future expansion,
with first param being namespace/protocol/modelOfComputing/etc,
such as a sparse bloomFilter accumulating/caching true statements about the possible forests of data structures
implementing the stack and debugger steps etc [func, param, stack, cacheKey, isHalted, isParentsFunc, etc],
or such as various turingComplete models of computing being interchangible with eachother.
The only rule for mounting things into the protocol param is they must be stateless,
so if you want to mount a mutable system you have to statelessly refer to var values each at a time,
such as (I call it utcnano) int64 number of nanoseconds since year 1970 UTC,
or accumulate true statements about digitalSignatures each signing an ever expanding set of nodes in the system.


------------------------------
The following is old and has some params in the wrong place,
but need it to explain the comment and context/cx which are SUGGESTED ways to use the universalFunc/u.
U's behaviors are not modified by this. This is something you can do with combos of u.

FIXME MOVE THEM ALL OVER 1 PARAM, AS FIRST PARAM IS NAMESPACE/BLOOMFILTER/ETC. FIRST PARAM IS LEAF/. FOR THESE 16 OPS BELOW,
	EXCEPT IT GETS 1 LESS PARAM AT THE END, SO BIGCALL/FUNCBODY GETS cx THEN 1-7 PARAMS (INSTEAD OF 1-8).
	THAT LEAVES AN OPCODE FOR TYPEVAL.
	(nond .       .        .  . . . . . . /       p) //external pluginRoot (in Nondet.java) gets the p param ONLY. Put this in bigCall.
	(s    .       .        .  . . . . / x y       z)
	(pair .       .        .  . . . . / x y       z)
	//(pair .       .        .  . . ..(..)type val ignore) //OLD: typeval, when comment of pair is (..). Still does same thing as pair (but is not optimizable by pairOfPairDepth), but its a semantic meaning to look for things like "image/jpeg" as type and bytes of jpg in val or other combos which dont all have to be bitstrings.
	(t    .       .        .  . . . . . / y       z)
	(typv .       .        .  . . . . / ty val ignore) //example: ty is "image/jpeg" and val is cbtBitstring of that jpg content
	(op8  comment funcThatInfloopsForEveryPossibleParam_with_comment_OfLeafOfLeaf cx p p p p p p p ignore) //general datastruct
	(op8  comment funcbody cx p p p p p p p       p)
	(op9  . comment funcbody cx p p p p p p       p)
	(op10 . . comment funcbody cx p p p p p       p)
	(op11 . . . comment funcbody cx p p p p       p)
	(op12 . . . . comment funcbody cx p p p       p)
	(op13 . . . . . comment funcbody cx p p       p)
	(op14 . . . . . . comment funcbody cx p       p)
	(op15 . . . . . . . comment funcbody cx       p)
		actually op9..op15, cuz typeval, and theres only 1-7 normal params of bigcall cuz first param is namespace/bloomfilter/etc.
]

TEST CASES https://github.com/benrayfield/occamsfuncer/blob/master/occamsfuncer/spec/TestSpec.java RUN 2020-8-29[
Starting testBootIsT
### test pass: bootIsT T
### test pass: !bootIsT F
### test pass: !bootIsT I
### test pass: !bootIsT u
### test pass: !bootIsT uu
### test pass: !bootIsT op0
### test pass: !bootIsT op1
### test pass: !bootIsT op2
Starting testTF
### testEqq pass: (T N).func()->T
### testEqq pass: (T N).param()->N
### testEqq pass: (T N u)->N
### testEqq pass: (T N P)->N
### testEqq pass: (F N).func()->F
### testEqq pass: (F N).param()->N
### testEqq pass: (F N u)->u
### testEqq pass: (F N P)->P
Starting testPair
### testEqq pass: (pair N) is halted
### testEqq pass: (pair N u) is halted
### testEqq pass: (pair N u T)->N
### testEqq pass: (pair N u F)->u
Starting testIota
iota = ((P S) T)
(iota iota) -> ((S T)(T T))
### testEqq pass: (iota iota)->(S T (T T))
### testEqq pass: (iota iota N) cuz iota iota is an identityFunc
### testEqq pass: get T from iota
### testEqq pass: get S from iota
Tests pass: testIota
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
### test pass: isHalted . 9params
### test pass: isHalted . 10params
### test pass: isHalted . 11params
### test pass: isHalted . 12params
### test pass: isHalted . 13params
### test pass: isHalted . 14params
### test pass: isHalted (..(..))
### test pass: isHalted should be false . 15params
### test pass: isHalted should be false (remember, universalFunc always curries 15 params, so any more are lazy after that 15 returns which is also lazy) . 11params
Starting testLeaf
### testEqq pass: (L Leaf)
### testEqq pass: (R leaf)
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
### testEqq pass: lambda7.p15
### testEqq pass: lambda7.p14
### testEqq pass: lambda7.p13
### testEqq pass: lambda7.p12
### testEqq pass: lambda7.p11
### testEqq pass: lambda7.p10
### testEqq pass: lambda7.p9
### testEqq pass: lambda7.p8
### testEqq pass: lambda7.p7
### testEqq pass: lambda7.p6
### testEqq pass: lambda7.p5
### testEqq pass: lambda7.p4
### testEqq pass: lambda7.p3
### testEqq pass: lambda7.p2
### testEqq pass: lambda7.p1
### testEqq pass: lambda5.p9
### testEqq pass: lambda6.p8
### testEqq pass: lambda7 create pair from 2 params
Starting testLazig
### testEqq pass: lazigA
### testEqq pass: lazigAN
### testEqq pass: lazigANP
### testEqq pass: lazigPAN
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
steps=89789
seconds=0.061151800000000006
stepsPerSec=1468296.9266644644
objectsInCachePerSec=255658.86858604322
In other implementations (not this spec), this will be optimized to make full use of GPU but CPU will often be many times slower than other programs that use CPU cuz of unusual cache needs.
]



OLD: test cases: https://github.com/benrayfield/occamsfuncer/blob/master/immutable/occamsfuncer/ocfn3s/spec/sparseTuringMachine/test/TestOcfn3SparseTuringMachine.java

UPDATE 2020-8-3, code not here yet but working on[
Ids are lazy-evaled. Most objects use a faster kind of hash-consing that uses == and a hashtable, until id is needed if ever, especially that opencl/GPU matrix ops will just wrap those binary blobs until their parts are observed in more detail if ever. The default id type is 248 bits, supports unlimited size bitstrings (such as a googol bits) but only efficiently supports bitstrings up to 2^43-1 bits (terabyte) and unlimited objects in the peer to peer network since it has 92 bits of security against finding any collision (uses 23 bytes of sha3_256 of its 2-4 child ids: func, param, optional:stack, optional:cacheKey). Expandable at runtime to multiple id types tuned for different purposes used simultaneously, and every id maker function can create id of itself and all other id maker functions and all of eachothers parts which will form a formal-verification system to verify and strengthen its own security and tune between security, low-lag, scalability, and other properties of computing.

	public static Id id(Id func, Id param, boolean isParentsFunc, Id stack, Id cacheKey){
		boolean isCallPair = stack == null && cacheKey == null; //if true, 1 sha3-256 cycle instead of 2
		if(stack == null) stack = nullId;
		if(cacheKey == null) cacheKey = nullId;
		boolean isCbt256 = log2OfLiteralCbtSizeElse15(func.a)==7 && log2OfLiteralCbtSizeElse15(param.a)==7;
		if(isCbt256 && idOfIdDepth(func.b)!=maxIdOfIdDepth){
			//id is a cbt256, and is id of a cbt256 with all the same bits except idOfId+1
			return id( func.b+(1L<<shiftIdOfId), func.c, param.b, param.c );
		}
		
		byte[] hashMe = new byte[1+31*(isCallPair?2:4)];
		hashMe[0] = isCallPair ? callPairHeader : callQuadHeader;
		copyFirst31BytesOfIdIntoByteArray(func, hashMe, 1);
		copyFirst31BytesOfIdIntoByteArray(param, hashMe, 1+31);
		if(!isCallPair){
			copyFirst31BytesOfIdIntoByteArray(stack, hashMe, 1+31*2);
			copyFirst31BytesOfIdIntoByteArray(cacheKey, hashMe, 1+31*3);
		}
		byte[] hash = sha3_256(hashMe); //ignore the first 8 and last 1 bytes
		return id(
			firstLong(func, param, isParentsFunc, stack, cacheKey),
			MathUtil.readLongFromByteArray(hash, 8),
			MathUtil.readLongFromByteArray(hash, 16),
			(MathUtil.readLongFromByteArray(hash, 24)&0xffffffffffffff00L)|(padLastByte&0xff)
		);		
	}
	
	/**
	Uint2 Id of Id of id, so is Id of literal 256 bits of subtract 1 from that uint2. Normal IDs have 0 here. Id of id (aka Id of a cbt256) has 1 here. Id of id of id of id has 3 here. Id of id of id of id of id has 0 here and twice as much storage as 2 of literal 128 bits.
		Id is always halted, deterministic, cacheKeyIsNull, stackfuncisnonnull, and stackparamisnonnull,
			even when the thing it points at differs there. Id must still have those bits,
			since its the id of a cbt256 (which may be interpreted as an id or not),
			so always check this idOfIdOfId... bits before the other bits in the long header.
	uint4 curriesleft (and is halted) or nothalted. 0 means nothalted.
		Unless is idOfIdOfId... cuz then its always halted.
	Uint5 (pair (pair (pair x))).
	4 bits for literalCbtSize, cbt1 to cbt128. 1111 means its something else.
	2 bits stackfuncisnonnull stackparamisnonnull.
	1 bit cachekeyisnonnull.
	1 bit isdeterministic.
	1 bit for iscbt.
	1 bit does bize have more digits.
	43 up to 1 terabyte bize (bitstring size lowest digits).
	*/
	public static long firstLong(Id func, Id param, boolean isParentsFunc, Id stack, Id cacheKey){
		long ret = 0;
		boolean isCallPair = stack == null && cacheKey == null;
		//can be cbt256 as 2 cbt128 (first and last 128 bits), or if idOfId>0 (then its same 256 bits except idOfId is 1 less)
		boolean isCbt256 = log2OfLiteralCbtSizeElse15(func.a)==7 && log2OfLiteralCbtSizeElse15(param.a)==7;
		if(isCbt256 && idOfIdDepth(func.b)!=maxIdOfIdDepth) {
			return func.b+(1L<<shiftIdOfId); //id is a cbt256, and is id of a cbt256 with all the same bits except idOfId+1
		}
		//nothing to change in long ret: int idOfCbt256ThatFitsInId_depth = 0;
		//Universal func always takes 9 params.
		int curriesLeftF = curriesLeft(func.a);
		int curriesLeftP = curriesLeft(param.a);
		int curriesLeft = curriesLeftF-1;
		if(curriesLeftF == 0 || curriesLeftP == 0){
			//If either child is evaling, then parent is evaling
			curriesLeft = 0;
			//FIXME how does curriesLeft get set to the higher number? Maybe need more bits in id for that?
		}
		ret |= (((long)curriesLeft)<<shiftCurriesLeft);
		//FIXME infloop between Pair creating id, but id func checking if a child is pair for this optimization.
		int pairOfPairDepth = TODO;
		if(pairId.equals(func)){
			TODO pairOfPair+1 unless its already as deep as it gets.
		}
		ret |= (((long)pairOfPairDepth)<<shiftPairOfPair);
		
		TODO implement whats in comment of this func.
		return ret;
	}
]

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


