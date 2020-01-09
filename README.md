# occamsfuncer
an extremely optimizable and scalable universal lambda function meant for number crunching, AI research, and low lag massively multiplayer games that players can redesign into new game types in turingComplete ways by hotswap/forkEditing per bit, per function call pair, etc

mutable.occamsfuncerV2.Network.java is being designed. The world around us is stateless by mutableWrapperLambda and stream ranges, every <func,param> evals to the same return even if the system is used by time travellers creating grandfather paradoxes occamsfuncer is guaranteed consistent. There are 2 main kinds of networking, one where every recognizerFunction (such as a way of using an ed25519 publicKey for digitalSignatures, and proofOfWork gameTheory for faster updates between signatures) to stream many to many (such as subscribe to 5000 strems at once of 64 bytes per second each (such as mouse movements), and some few streams of 2^18 bytes per 1.07 second (such as video)... Each stream is 1 bit per powOf2 number of nanoseconds (thats why it aligns on about 1.07 at 2^30 nanoseconds). The other of 2 main kinds of networking is to call a function on a function to get a function, and that function is a call of op.nondet (nondeterminism as its not proven others will obey the network spec even though they are disconnecte if they dont the damage is already done, so op.nondet says that kind of thing might happen)... Similar to http except caching is always allowed infinitely long as the same param of the same url or publickey, and the same post data to it (or param in general) always gives the same response and anyone is allowed to cache that for anyone else forever or as short or long as they like or not at all. Basically, everything is a stateless/immutable function, and you can efficiently stream thousands of tiny streams of fewer big streams or objects, all derived from one universal lambda function represented as a trinary forest where all paths lead to that universal lambda function as the leaf, and the network is organized around that. (TODO).

Which namespaces for a universal lambda function to join with ids for every possible stateless function?
I dont know which namespaces are compatible. I'd like to hook into ipfs, multihash, urn: and I dont know what others. (and will also peer to peer directly later based on digsig (derived funcs) of a goal func of what each peer subscribes to, or something like that Where should a kind of turing-complete number go? As a kind of number, it cant be uniquely identified by any website name even if copies are cached there, and it cant act on a stateful world, only call a number on a number to get another number and you might have set up things to react to it but the number itself does not take any action (which is important since the space of all possible numbers contains every possible virus (id predefined for every possible function, and infinitely many id functions derivable) and one can not just say numbers do not exist because one prefers it. One does not add 2+3 if one does not want to see 5.

I'm soon going to have ids for every possible stateless function that exist in a global sandbox and are safe to send executables in email or post anywhere by their constant id. Any group of people or computers who have partial programs, even in mid execution per microsecond, can verify securely which point at which others (merkle forest). A program is a math statement, not a specific network. If a cloud goes down, use it at 5 others simultaneously, or write it with pen and paper and compute very very slowly the same function behaviors. You could literally snailmail a function in mid execution on a number crunching cloud and that function if typed in would be recognized, if found, as a secure part of that cloud process. If people exchange them on usb sticks without a network, its still the same function behaviors though slower. If there is a bug and it returns not what the spec says, anyone else who made the same function call or called functions on functions to measure something about them etc... could do the scientific method, that function calls are repeatable experiments that give the same id, for all possible id functions, and an id function can measure its own id. An equals function equals itself without using == or .equals in the prototype implementation, instead through lambda math to be optimized.

occamsfuncerV1 is a universal lambda function (not entirely bug free yet but hopefully will be able to formal verify itself). All possible stateless functions are either that or call pair of function and function which returns either itself halted or function (such as 0 and 1 and efficiently fork-appendable petabyte files would be functions). Every function is just an empty leaf or a call pair. Its similar to typed lambdas in that it has turing-complete constraints that never fail since they infinite loop so cant return a function that breaks constraints, which similar to ethereum gas (if not in strict/determinism mode) would locally give up early and catch at innermost spend call (not secure money, just a mutable variable that counts compute resources). If used as a pure lambda, attempts to call any of those things would infinite loop. There is a certain combo of calling it on itself that does any of those things.

---

Its very self referencing.
See the output at the end of README.md (and StartTestsLocal.main(String[])
where it proves that
the equals function equals the equals function by its binary forest of call pairs.
"test pass: equals(equals,equals)==T".
There are still optimizations to put in that will make it many times faster,
by using the Compiled objects to access OpenCL and Javassist
and int[] opcodes of acyclicFlow realtime music tools optimization,
and the equals function will continue to appear that way
to introspection but will be optimized by a Compiled
that uses a manually chosen secureHash id generator
(such as doubleSha256 with some pre and post processing
in a cbt bitstring so both the id generators and ids are functions,
and equals on cbts will be compared as small arrays such as
maybe 24 or 36 bytes I havent decided on the size
but it supports multiple id types at once
including every possible id func so your existing
ids in every system are already compatible
if you can write a function that statelessly
maps a binary forest to them or even an Op.nondet
can call a java func if you dont require strict determinism mode).

Its like an assembly language for pure functions (not procedural assembly)
but will be far more readable by Humans when you use
the comment section in Op.getp and #localNames.
Such comments affect equals/ids but #localNames do not.
You would #localName something either when it occurs multiple places
so you dont see its expanded form both places
andOr if you want to remember it for later.

TODO get the IF() working so dont have to directly use lazig.

equals = f(
	cc(),
	S(
		t(ifElse),
		S(t(isLeaf),getP4),
		f(lazig(), p5IsLeaf),
		f(
			lazig(),
			S(
				t(ifElse),
				p5IsLeaf,
				t(t(F)),
				f(
					lazig(),
					S(
						t(and()),
						S(recur, S(t(L),getP4), S(t(L),getP5) ),
						S(recur, S(t(R),getP4), S(t(R),getP5) )
					)
				)
			)
		)
	)
);

cc = f(
	curry,
	//cuz (curry cbtAsUnary constraint funcBody params...)
	unary(5),
	T //no constraint
);

and = f(
	cc(),
	S(
		p(4),
		p(5), //if p4 is T
		t(F) //if p4 is F
	)
);

lazig = f( ccc(), S(p(4),p(5)) );


/** Optimized forkAppend bitstring such as double*double op or opencl.
	All completeBinaryTrees (cbt) of calling these on eachother
	are halted states, but any non-complete-binary-tree infLoops
	as thats its constraint. The rest of this datastruct cant be
	represented efficiently as a constraint as it is to have at least 1 cbt1
	in outermost completeBinaryTree, and that cant be enforced
	cuz each L and R of cbt is also a cbt uless its cbt0 or cbt1.
	cbt1 means the empty bitstring.
	(cbt0 cbt1) means the bitstring "0".
	((cbt1 cbt0)(cbt1 cbt1)) means the bitstring "101".
	(((cbt1 cbt0)(cbt1 cbt1))((cbt1 cbt0)(cbt0 cbt0)))
	means the bitstring "1011" and will be efficiently represented in binary
	by objects in the VM that represent a completeBinaryTree of all 0s
	and by various datastructs representing small binForests
	with pointers and literals as leafs.
	*/
	cbt0(1,'0'),

	/** see cbt0 */
	cbt1(1,'1'),
	
	/** get right child, as in ((l x)(r x)).equals(x) for all x,
	and (l leaf) is i (identityFunc) and (r leaf) is leaf.
	*/
	R(1,'R'),
	
	/** get left child, as in ((l x)(r x)).equals(x) for all x,
	and (l leaf) is i (identityFunc) and (r leaf) is leaf.
	*/
	L(1,'L'),
	
	/** Lx.Ly.y aka getSecondOf2 aka (k i) */
	F(2,'F'),
	
	////////
	
	/** k aka t aka getFirstOf2. Lx.Ly.x */
	T(2,'T'),
	
	/** identityFunc aka same behaviors as (s k k) other than its forest shape.
	(L theLeaf) returns I.
	*/
	I(1,'I'),
	
	/** Lx.Ly.Lz.xz(yz). This is the simplest kind of controlflow
	and is used to define funcs by passing a param
	down to branches: x and y as (x z) and (y z).
	then calls what (x z) returns on what (y z) returns.
	Use identityFunc/I to get the z param,
	or use (T quoteMe) to quote something to get instead.
	*/
	S(3,'S'),
	
	////////
	
	/** returns T or F depending if param is ./theLeaf.
	From this, equals func can be derived,
	and so can comparator by forest shape by depth recursively
	or so can any other comparator.
	The equals func will be optimized by secureHash comparing.
	All optimizations go in BinaryOperator<fn> fn.compiled().
	*/
	isLeaf(1,'Y'),
	
	/** Lx.Ly.Lz.zxy.
	(pair x y F) returnx x.
	(pair x y T) returns y.
	(pair x y) is halted, of course.
	*/
	pair(3,'P'),
	
	/** This is being moved out of Op and will instead be derived
	and optimized by Compiled, cuz need the space for Op.ifElse
	which does similar thing as S with T or F but
	without evaling all branches, so dont need lazyeval.
	<br><br>
	FIXME choose which end of cbtBitstring, bigEndian or littleEndian,
	considering that one of the cbtBitstring ends is efficiently forkAppendable.
	Or should bh take an extra param thats T or F to choose which of those
	2 behaviors (that seems wasteful). Or should I derive a reverse cbtBitstring
	fn and somehow optimize combos of it and this op.bh (not sure if I
	can optimize it as well)?
	OLD...
	forkJump by binheap indexing, using cbt (complete binary tree) as bitstring
	suffixed by the last cbt1, and before that the cbt0 is L and cbt1 is R.
	This is an urbit-like op.
	*
	bh(2,'J'),
	*/
	
	/** (ifElse condition ifTrue ifFalse)
	returns (ifTrue leaf) or (ifFalse leaf) depending if condition is T or F,
	and if condition is neither of those then infloops.
	See Example.equals() for how to use this to conditionally recurse.
	<br><br>
	OLD: (ifElse condition funcIfTrue paramIfTrue funcIfFalse paramIfFalse)
	returns (funcIfTrue paramIfTrue) or (funcIfFalse paramIfFalse)
	depending on if condition is T or something other than T.
	See Example.equals() for how to use this with recur on a tree.
	<br><br>
	FIXME can ifElse be derived by a condition (which is T or F)
	being called on PAIR, and do that twice, once for funcIfTrue vs funcIfFalse
	and once for paramIfTrue vs paramIfFalse,
	and is that more intuitive than Op.ifElse?
	I could bring back Op.bh since Op.ifElse wouldnt be needed (or could be derived that way).
	But it seems nonintuitive to put half of the IFTRUE and half of the IFFALSE together twice.
	S( S(S(pair funcIfTrue funcIfFalse) condition) S(S(pair paramIfTrue paramIfFalse) condition) )
	or something like that.
	So I will keep the ifElse, since its intuitive.
	*/
	ifElse(3,'?'), 
	
	/** (lazyEval x y z) aka (((lazyEval x) y) z) returns (x y z) aka ((x y) z).
	(lazyeval x y) is halted.
	*/
	lazyEval(3,'Z'),
	
	////////
	
	/** (curry cbtAsUnary constraint/T funcBody ...params...)
	I chose that order of params so Call constructor
	will know its number of curries right away other than if its Op.curry
	whose number of curries is 0 (vararg).
	The BinaryOperator<fn> of Op.curry (in Boot) will check for
	BinaryOperator<fn> fn.compiled() in both constraint/k and funcBody params
	unless somehow I design that to happen when it calls them.
	<br><br>
	TODO create Compiled for each of
	(curry cbtAsUnary1 T) to (curry cbtAsUnary7 T)
	so theres no need to redesign as (curry T) having a Compiled.
	Most calls of curry have T as constraint. MapPair for example
	has a custom constraint. A constraint is a fn run at curry's fn.cur()-1,
	similar to funcBody is run at curry's fn.cur(),
	in both cases using a lazyEval to join currysL and currysR. 
	<br><br>
	OLD...
	<br><br>
	THIS IS INCOMPLETELY DEFINED cuz undecided on order of first few params.
	Wrote this during incomplete redesign of curry and getParam ops:
	<br><br>
	How many int cur is needed per fn [UPDATE: 1]? 2? If 2,
	then what should their values be
	in all possible binForest shapes?
	...
	Might need 2 cur()=like funcs: 1 for op.curry
	and 1 for my curries such as the 3 curries of s.
	...
	Can that be done in the same int cur? It appears YES.
	...
	For example, if its Op.s, it has 3 cur,
	but if its Op.curry then its variable number of curries
	depending on height of 1 of the earlier params (cbt of all 1s).
	Maybe should make that cbt the first param so curries are known
	as early as possible?
	Or should constraint/k be first param so can optimize
	for (curry k) as a Compiled that doesnt use constraint
	(since k is a constraint thats always true, and k is Op.t)
	...
	TODO choose order of params:
	(curry cbtAsUnary constraint/k funcBody ...params...)???
	(curry constraint/k cbtAsUnary funcBody ...params...)???
	(curry constraint/k) would have its own Compiled maybe,
	and would have cur=0,
	and (curry constraint/k cbtAsUnary) would have a different cur.
	...
	Technically I could leave int cur as 0 in curry and in (curry k)
	and (curry k cbtAsUnary) would have the number of curries
	defined by height of cbtAsUnary,
	BUT I want number of curries known as early as possible
	BUT I always want (curry k) to be a Compiled that skips the constraints
	(as an optimization cuz k/t is constraint thats always true,
	and remember any constraint thats false infLoops by design,
	which is caught by nearest (nondetGet ;spend) call).
	Must choose between those 2 designs.
	I could create A Compiled for each small number of curries
	and put cbtAsUnary first.
	Or I could just check every time if k/t is the first param
	and if so dont run the constraint, so its almost as fast.
	...
	Which is first, cbtAsUnary or constraint/k?
	...
	Maybe I'll choose:
	(curry constraint/k cbtAsUnary funcBody ...params...)
	TODO define int cur, and theres just 1 int cur per fn,
	in Call.java asap, but maybe I'll find its too inefficient
	to compute int cur that way and instead use the design
	(curry cbtAsUnary constraint/k funcBody ...params...)
	or maybe
	(curry constraint/k funcBody cbtAsUnary ...params...)
	//think a little more about it.
	...
	Should there be -2 cur for Op.curry,
	-1 cur for (Op.curry constraint/k),
	0 cur for (Op.curry constraint/k funcBody),
	and a specific cur for (Op.curry constraint/k funcBody cbtAsUnary)???
	...
	TODO write out these few possible designs,
	and think through how I would optimize each one,
	and choose the one thats most optimizable.
	----------------
	---------
	TODO choose order of params:
	(curry cbtAsUnary constraint/k funcBody ...params...)???
	OLD: (curry constraint/k funcBody cbtAsUnary ...params...),
	checks constraint (such as k is a constraint thats always satisfied)
	when add second last param, and runs funcBody when add last param.
	Each of those calls is constraint or funcBody called on
	(lazyEval (curry constraint/k funcBody cbtAsUnary ...paramsExceptLast...) lastParam),
	and constraint and funcBody can each call getParam.
	<br><br>
	curry and getParam use completeBinaryTree's height to count in unary, so cbt1
	is param0, and ((cbt1 cbt1)(cbt1 cbt1)) is param2. Efficiently shares branches.
	This fits well with bitstrings being suffixed by cbt1 so is a powOf2-1 len bitstring.
	*/
	curry(0,'C'),
	
	/** THIS IS INCOMPLETELY DEFINED cuz Op.curry is incompletely defined:
	(getParam comment cbtAsUnary structureMadeByCurryInFuncbodyOrConstraintCall).
	Suggested syntax for cbtAsUnary of 5
	and comment of (utf8 cbt bitstring)"varX" is 5varX.
	<br><br>
	curry and getParam use completeBinaryTree's height to count in unary, so cbt1
	is param0, and ((cbt1 cbt1)(cbt1 cbt1)) is param2. Efficiently shares branches.
	This fits well with bitstrings being suffixed by cbt1 so is a powOf2-1 len bitstring.
	<br><br>
	Returns leaf if the requested param index is out of range.
	*/
	getp(3,'G'),
	
	/** same logic as ImportStatic.recurse which uses .getNthCurry,
	TODO explain more directly.
	*/
	recur(1,'E'),
	
	/** First param is normally a cbt thats either an arbitrary
	bitstring or maybe a type:content bitstring or whatever you want it
	to be, and second param is the param of that func (nondet someCbt),
	so if you wanted to wrap the type:content kind of occamsfuncer
	in this kind, at some cost of extra memory maybe,
	you could wrap forExample (nondet "image/jpeg:bytesOfJpgFile")
	in an Op.curry for however many params it takes (if a jpg file would
	somehow act like a function, for example.
	Or that first param could be a list or other datastruct,
	which contains namespace subnamespace funcname,
	or however people like to organize Op.nondet,
	always with the option of pure determinism mode
	in which case Op.nondet always returns leaf or always infloops
	or things between that involving Spend and Wallet
	and infloopIfWalletLessThan etc.
	<br><br>
	This nondet op is a redesign merging
	the nondetGet and nondetInfloopIf ops.
	Its still considered deterministic when it returns leaf,
	as explained in the comments below of nondetInfloopIf,
	and considered nondeterministic when its nonhalting or if it
	returns anything other than leaf.
	The Spend and Wallet calls will be nondeterministic,
	and there will be another kind of call that returns leaf
	if a param meaning amount of Gas.top, is at most that amount
	meaning theres enough compute resources.
	Ocfnplug (static java funcs etc whose name starts with ocfnplug,
	excluding package.a.b.className) will be nondeterministic
	since their code can be changed without changing the func name.
	Even if they are nondeterministic, its important
	for them to still obey Gas.top and Gas.memToComRatio etc.
	<br><br>
	OLD...
	<br><br>
	Always returns the leaf unless error (in its param)
	in which case it infiniteLoops,
	and if you're in a nondet call that limits compute resources recursively
	that would jump to the outermost spend call,
	or if you're in pure determinism mode then would always return the leaf.
	There are only 2 ops related to nondeterminism, one ifFail and one always.
	This may be called in pureDeterminism mode cuz can be repeated
	from a previous state until it gives the deterministic result then continue,
	though its still theoretical andOr experimental how nondeterminism
	and determinism may interact and which possible states can be
	considered still deterministic if no nondeterministic thing
	has yet interfered with them, or possibly could interfere with them
	is another question, and if it possibly could interfere,
	can it still be recalculated from an earlier forkEdited state
	to continue it deterministicly.
	"occamsfuncerOpFailDependingOnNondetButDeterministicIfSucceed"
	this is deterministic unless it fails,
	such as ending a calculation if there is not at least someNumber
	of Wallet left, but without reading Wallet as that would be nondeterministic.
	This op may be repeated from a previous state
	until it gives the deterministic result then continue.
	*
	nondetInfloopIf('q'),
	...
	/** There are only 2 ops related to nondeterminism, one ifFail and one always.
	"occamsfuncerNdAntiop".
	If in pure deterministic mode, evals to (s s s s) [FIXME thats not actually an infinite loop] aka infinite loop
	which is deterministic, else counts as nondeterministic
	as soon as its used nomatter the result. Is used for things
	like Wallet op and Spend op, to measure and recursively
	limit compute resources, and could be used, in forks of occamsfuncer VM,
	for any other nondeterministic thing at your own risk since
	lambda functions tend to break when they're not repeatable.
	I'm not suggesting you use nondeterminism, except an outermost call
	limiting compute resources and maybe recursive limiting of them
	in each deeper call if you're very careful in defining
	which things are deterministic vs nondeterministic,
	if thats even possible once this is called,
	but if you must, this is where to put it, as how this reacts
	to different possible params.
	*
	nondetGet('Q');
	*/
	nondet(2,'Q');
	
	
	
	/** call this once when system starts to define the behaviors
	of a universal lambda function, other than what leaf returns
	which is hardcoded in Leaf.java.
	<br><br>
	This sets the Compiled object for all fns up to depth4
	despite that it changes their behaviors and compiling
	must not change behaviors EXCEPT during booting
	since those behaviors start empty.
	Those Compiled objects in the first depth0 to depth4
	also sets the behaviors of all infinity possible fns derived from them.
	<br><br>
	After this you start with an instance of that function as Leaf.instance
	and can create every possible function
	(except those that lack the ability to reflect using L and R)
	by calling it on itself in various combos,
	but practically you will also want to wrap large bitstrings in cbt
	which is a shortcut to some of those combos.
	*/
	public static void boot(){
		if(booted) throw new Error("Already booted");
		List<fn> fns = upToDepthN(4);
		Compiled other = new Compiled(
			1,
			null,
			(BinaryOperator<fn>)(fn l, fn r)->{
				//Return same as if had infinite curries, even though its just 1 curry.
				//FIXME that might be inconsistent logic
				//since ((..).) returning ((..).) is an infiniteLoop
				//unless its defined as a constraint and the actual number of
				//curries is always 1 more than where the constraint is checked
				//which would be 2 in this case, but need more than 2
				//cus these have to reach to height4.
				//These arent useful for anything except building the
				//16 ops at height4. I just want them to build up to that
				//and if anything else is called just be consistent logic.
				//It might be better if in all possible cases other
				//than building up to those ops they acted like identityFunc,
				//but that would complicate it.
				//Trying this simple thing first, just create the pair.			
				//Its maybe consistent to say its a halted state,
				//even if its not consistent by the strictest rules of lambda.
				//This can be adjusted later without affecting the ops.
				return cp(l,r);
			}
		);
		BinaryOperator<fn> cbtFuncBody = (fn l, fn r)->{
			lg("cbtFuncBody of l="+l+" r="+r);
			$();
			//TODO optimize for efficient bitstrings
			return cp(l,r);
		};
		for(fn f : fns){
			int i = bootOpIndexAtHeight4(f);
			if(i == -1 && !f.isLeaf()){ //skip leaf and the 16 Ops
				f.setCompiled(other);
			}
		}
		fn T = op(Op.T.ordinal());
		fn F = op(Op.F.ordinal());
		fn pair = op(Op.pair.ordinal());
		for(Op op : Op.class.getEnumConstants()){ //the 16 Ops
			fn f = op(op.ordinal()); //these are among the upToDepthN(4)
			int cur = -1;
			BinaryOperator<fn> constraintOrNull = null; //null means Op.T
			BinaryOperator<fn> funcBody = null;
			switch(op){
			case cbt0:
				cur = 1;
				funcBody = cbtFuncBody;
			break;
			case cbt1:
				cur = 1;
				funcBody = cbtFuncBody;
			break;
			case R:
				//(f x) returns x.R()
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r.R();
				};
			break;
			case L:
				//(f x) returns x.L() 
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r.L();
				};
			break;
			case F:
				//(f x r) returns r
				cur = 2;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r;
				};
			break;
			case T:
				//(t x y) returns x
				cur = 2;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return l.R();
				};
			break;
			case I:
				//(i x) returnx x
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r;
				};
			break;
			case S:
				//(s x y r) returns ((x r)(y r))
				cur = 3;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					
					//FIXME avoid stackoverflow in code like
					//Example.equals() by not recursing into
					//both branches when x is T or F
					//(TODO is that similar to how Lazyk does it?)
					//cuz the binary forest is infinitely deep
					//as leaf.L()==I and leaf.R()==leaf
					//so that code must be prevented from
					//recursing after leaf to compute
					//the first param of F or second param of T
					//since those are NONHALTING.
					//(T x anyNonhaltingCall) must return x.
					//(F anyNonhaltingCall x) must return x.
					//Since the anyNonhaltingCall is started here in Op.S,
					//it must be detected here.
					
					$();
					
					fn x = l.L().R();
					fn y = l.R();
					return x.f(r).f(y.f(r));
					
					/* This code breaks Example.equals()
					return x.f(r).f(y.f(r));
					*/
					
					/*if(x == T){
						//optimization of (T y r) returns y. Doesnt add to Cache
						return y;
					}else if(x == F){
						//optimization of (T y r) returns r. Doesnt add to Cache
						return r;
					}else{
						//FIXME check for S(...) of 3 things where first returns T or F
						//but for now just handle (s a b c) where (a c) is T
						//since that will intheory fix the Example.equals() problem
						//since Example.equals() uses recur only in the third param
						//instead of the second, so the base case is before that
						//so (T baseCase someCallOfRecur) wont do the someCallOfRecur,
						//but (F someCallOfRecur baseCase) would stackoverflow.
						//Not fixing that for F (yet?) cuz s only passes a param
						//down 2 branches, the param being the third param of s,
						//but 3 branches is S(a b c) aka (s (s a b) c).
						//Wait, maybe its F I need to call this way
						//and put the base case after the recur?
						fn xr = x.f(r);
						//if(xr == T){
						//	//dont eval y.f(r) cuz T would ignore it
						//	return xr.
						//}
						if(xr == F){
							return xr.
						}
						
						FIXME choose a design for not evaling
						the second param of T
						and not evaling the first param of F
						as combos of S calls them,
						and maybe also for not evaling some of the params
						inside curry but hopefully just thoe S T F things
						will be enough. Research how similar softwares
						handle recursion such as lazyk and urbit.
						
						https://tromp.github.io/cl/lazy-k.html says
						"if there is any order in which a Lazy K program can be evaluated to work properly, the Lazy K interpreter will find it."
						but I'm very skeptical the same thing will work in occamsfuncer
						cuz leaf.L()==I and leaf.R()==leaf so the binary forest
						of funcallPairs is infinitely deep cuz leaf wraps around,
						but I do expect to find some solution.
						
						I could fix it by creating a wrapper of a funcallPair
						that implements fn and only evals the call if ANY
						of the funcs in the java interface are called
						such as wrapper.L() must eval the call and return L()
						of whatever that returns,
						and as an optimization, dont create wrapper
						for something that would instantly halt as known by cur()>1
						or if its cur is 0 (cuz its Op.curry where 0 means varargs)
						or if its op is cbt0 or cbt1 (and their cur maybe should be
						cur 2 instead of cur 1 to simplify things but
						cbt0 and cbt1 and combos of just those normally only
						ever get 1 param and do something trivial (TODO what)
						if that is called on a second param.
						...
						Id like to avoid creating such a LazyFn
						(which is different than Op.lazyEval cuz you literally
						cant detect if it is a LazyFn vs the call it wraps,
						using only the deterministic ops at user level).
						Only S and Curry and maybe T and F would create LazyFn.
						LazyFn would not add to Cache <func,param,return> until
						its evaled.
						...
						fn.unstub() would get the evaled result if it exists
						so you dont have to keep using the LazyFn as the
						thing it returns after it returns,
						and that might need to happen recursively,
						1 step from each caller, similar to dedup by Cache,
						to avoid long chains containing LazyFn building up.
						...
						fn.unstub()
						fn.lazyLOrNull()
						fn.lazyROrNull()
						x.L() would return x.lazyLOrNull().f(x.lazyROrNull()).L()
						if lazyLOrNull()!=null, and after that, lazyLOrNull()
						and lazyROrNull() would return null since its evaled.
						...
						Is there another way?
						...
						Maybe if return Op.I when (x r) is Op.F,
						cuz F can be implemented as (T I),
						and maybe I should use (T I) and get rid of Op.F
						to make S not replace things unexpectedly,
						if I choose that design (TODO verify it).
						...
						Related videos, writings, etc...
						lazyk
						urbit maybe.
						haskell's compiled form
						scheme
						https://www.youtube.com/watch?v=eis11j_iGMs&t=1s
						...
						SOLUTION: Op.ifElse
						
					}*/
					
				};
			break;
			case isLeaf:
				//(isLeaf x) returns T if x is the leaf else returns F
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r.isLeaf() ? T : F;
				};
			break;
			case pair:
				//(pair x y r) returns (r x y)
				//(pair x y) is used as a cons pair
				//and (TODO) is optimized so car and cdr dont run this code
				//but get the value from inside it.
				cur = 3;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					fn x = l.L().R();
					fn y = l.R();
					return r.f(x).f(y);
				};
			break;
			/*case bh:
				//(bh cbtAsBitstring x) does x.L().R().L().L()...
				//for each bit in sequence in the cbtAsBitstring.
				//As bitstring, the last cbt1 and trailing cbt0s are ignored.
				//TODO optimize by in some future datastructs (which implement
				//the simpler spec as proven by same ids generated for all
				//possible id funcs), this op will skip over some branches
				//which avoids triggering lazyEval of id.
				//An example of this is cbt where you can get a bit or a subtree
				//without generating the cbts between,
				//as cbt is designed for efficient bitstrings,
				//especially forkAppending such as streaming a petabyte file
				//or the 32 or 64 bits of a float32 or int32 or double etc.
				cur = 2;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					throw new Error("TODO");
				};
			break;
			*/
			case ifElse:
				//(ifElse condition ifTrue ifFalse)
				//returns (ifTrue leaf) or (ifFalse leaf) depending on condition.
				//See Example.equals() for how to use this to conditionally recurse.
				cur = 3;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					lg("ifElse l="+l+" r="+r);
					fn condition = l.L().R();
					if(condition == T){
						return l.R().f(leaf);
					}else if(condition == F){
						return r.f(leaf);
					}else{
						return infLoop();
					}
				};
				
				/*
				//(ifElse condition funcIfTrue paramIfTrue funcIfFalse paramIfFalse)
				//returns (funcIfTrue paramIfTrue) if condition.equals(T)
				//else returns (funcIfFalse paramIfFalse) if condition.equals(F)
				//else infloop.
				cur = 5;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					lg("ifElse l="+l+" r="+r);
					fn condition = l.L().L().L().R();
					if(condition == T){
						fn funcIfTrue = l.L().L().R();
						fn paramIfTrue = l.L().R();
						return funcIfTrue.f(paramIfTrue);
					}else if(condition == F){
						fn funcIfFalse = l.R();
						fn paramIfFalse = r;
						return funcIfFalse.f(paramIfFalse);
					}else{
						return infLoop();
					}
				};
				*/
			break;
			case lazyEval:
				//(lazyEval x y r) returns (x y r)
				cur = 3;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					fn x = l.L().R();
					fn y = l.R();
					return x.f(y).f(r);
				};
			break;
			case curry:
				//(curry cbtAsUnary constraint/k funcBody ...params...)
				//This is the only func that has variable number of curries,
				//and by using it, can derive any func with variable curries,
				//and the whole such func is defined in params of this op.
				cur = 0; //0 curries means variable number of curries
				//but is checked for in Call constructor by L==curry
				constraintOrNull = (BinaryOperator<fn>)(fn l, fn r)->{
					//curry's constraint is to run the constraint in its params
					$();
					//TODO optimize. I was hoping there was a way to reuse
					//the (lazyEval currysL currysR) without getting it from Cache,
					//and this does find the same one in Cache,
					//but I also wanted to use getNthCurry
					//instead of 2 calls of getParam which is slower,
					//but it seems I cant since they run at different curry numbers.
					fn viewOfVarargCall = lazyEval.f(l).f(r);
					fn constraint = getParam(2,viewOfVarargCall);
					//infloop (catch at Spend) if constraint is not satisfied
					constraint.f(viewOfVarargCall);
					//output of curry's constraint is ignored.
					//only matters if it infloops or not.
					return leaf;
					
					
					/* if(constraint != T){
						//optimization: T is a constraint thats always true so dont call it
						//This optimization avoids caching (T viewOfVarargCall)
						//in Cache class as <func,param,return> by not doing the call.
						//
						//This infloops if constraint is false to prove
						//any calculation that continues obeys the constraint.
						//Infloop actually means throw and catch at nearest Spend call,
						//which also happens if theres an actual infinite loop etc
						//except then its not detected this early so spends up to a limit.
						//Everything in this system is prepaid and limited per call
						//separately from calls inside a call which can each reduce
						//the limit but cant raise it.
						//So constraints can be enforced using Op.spend
						//to jump to a (funcElse paramElse) if constraints are
						//not true in (spend funcIfOk paramIfOk funcElse paramElse),
						//but beware that Spend and Wallet are in Op.nondetGet,
						//compared to there is a weaker similar call in Op.nondetInfloopIf
						//which only infloops if the param amount of resources
						//asked about is more than wallet (Gas.top).
						constraint.f(viewOfVarargCall);
						
						FIXME constraint should only be checked at cur-1,
						but this is at cur.
						This is the only time anything runs at
						a number of curries other than cur().
						This is needed, for example, to prove that if a forest of MapPair
						exists then its keys are sorted by the given id function
						and it has the correct minKey and maxKey
						and its size is sum of 2 child sizes
						and similar for its interaction with MapSingle and MapEmpty.
						One more param is key and gets the value at that key
						or (TODO choose a design) leaf or infloop if none.
						(MapPair idFunc cbtAsSize minKey maxKey minChild maxChild key)
						returns value at that key.
						idFunc is any func that returns a cbt (such as 24 or 36 bytes)
						and does not have to be one of the id types
						used in fn.id(fn idFunc). Its trie-like of those bits.
						If there is an id collision for that idFunc,
						the MapPair may use any of those values
						and if sees a collision will take the one sorted lowest
						by recursive height of binForest shape (like in HumanAiNet acyc32)
						which is an unambiguous way of sorting all possible functions.
						(MapPair idFunc cbtAsSize minKey maxKey minChild)
						is halted.
						(MapPair idFunc cbtAsSize minKey maxKey minChild maxChild)
						runs the constraint before returning that Call,
						so if the Call exists then the constraint is true.
						MapPair will be derived from Op.curry, not built-in,
						except there will be BinaryOperator<fn> optimization for
						both its constraint (checks relation between its 2 childs
						and itself) and its funcBody (which does GET),
						and the optimization includes that no <func,param,return>
						are created (in Cache) for those up to log number of recursions.
						The depth of a MapPair is at most number of bits in an id
						and on average is log of its size as its a trie-like treemap.
						
					}
					*/
				};
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					fn viewOfVarargCall = lazyEval.f(l).f(r);
					//(curry cbtAsUnary constraint/k funcBody)
					//fn c3 = getNthCurry(3, viewOfVarargCall);
					//fn constraint = c3.L().R();
					//fn funcBody = c3.R();
					fn itsFuncBody = getParam(3,viewOfVarargCall);
					
					//itsFuncBody and constraint normally use Op.getParam.
					//FIXME I'm still undecided how to interpret cbt
					//as integer since I'm only decided how to interpret
					//it as bitstring and how to interpret it as unary by height,
					//so these integer params must still be encoded as cbt.
					//getParam(0) is curry.
					//getParam(1) is cbtAsUnary, tells how many to curry.
					//getParam(2) is constraint, run at cur()-1 which is already DONE cuz it
					//	returned the Call that passed the constraint (like a datastruct)
					//	and is waiting for 1 more (call the verified datastruct on something).
					//getParam(3) is funcBody, run at cur() which is NOW.
					//getParam(4+n) is nth param of func, starting at 0.
					//getParam(index of last param) is myR of (lazyEval myL myR),
					//and the other params are in myL.
					//
					//constraint and funcBody use the same getParam numbers
					//so can share branches and cached <func,param,return> of them.
					return itsFuncBody.f(viewOfVarargCall);
				};
			break;
			case getp:
				//(getParam comment cbtAsUnaryHeight thingNormallyMadeByCurry)
				//thingNormallyMadeByCurry is (lazyEval currysL currysR)
				//currysR is the last param.
				//currysL is var size currylist and its leftmost is curry.
				//curry is at height 4.
				//works in either constraint or funcBody generated by Curry
				//and cbtAsUnaryHeight counts ascending despite the
				//datastruct being ordered descending.
				cur = 3;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					//first is 0 (cbt1).
					//second param is 1 (cbt1 cbt1).
					//third pram is 2 ((cbt1 cbt1)(cbt1 cbt1)), and so on.
					fn cbtAsUnaryHeight = l.R();
					int whichParam = cbtAsUnaryHeight.height()-4;
					//r is thingNormallyMadeByCurry
					return getParam(whichParam, r);
					
					//FIXME this doesnt account for if params make it higher,
					//so want only 
					//int lHeight = l.height(); //(l r) is 1 higher
					
				};
			break;
			case recur:
				//given what Op.curry generates (to be param of constraint or funcBody),
				//returns L().L().L()... until R() is funcBody then returns
				//(curry cbtAsUnary constraint funcBody)
				//which already existed in the param and this just finds it.
				//See Example.equals() for how to use this since its a recursive func,
				//and its also (TODO) optimized by BinaryOperator<fn> that uses id
				//so when that BinaryOperator<fn> is there it bypasses Op.recurse.
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					//r is what curry generates
					return getNthCurry(3,r);
				};
			break;
			case nondet:
				cur = 2;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					//TODO sub-op for Gas.infLoop() IF doesnt have enough Gas.top
					//See comments in Op.nondet for what these 2 params are for
					//and how to wrap the older type:content kind of occamsfuncer in
					//this by the type:content being the cbt bitstring of firstParam,
					//or it can be anything you want to hook in nondeterministicly here.
					//$();
					//fn firstParam = l.R();
					//fn secondParam = r;
					//return Leaf.instance;
					
					//does $(...), but FIXME??? is there a danger of infloop just by calling l.R() before nondet? Probably not.
					return Nondet.nondet(l.R(), r);
					//return Nondet.nondet(l.L().R(), l.R(), r);
				};
			break;
			/*case nondetInfloopIf:
				cur = 1;
				funcBody = Nondet.nondetInfloopIf; //TODO or call that, in case add cbt first params it responds to at runtime?
				/*func = (BinaryOperator<fn>)(fn l, fn r)->{
					//TODO sub-op for Gas.infLoop() IF doesnt have enough Gas.top
					$();
					return Leaf.instance;
				};*
			break;
			case nondetGet:
				//TODO sub-ops for Spend and Wallet,
				//where (nondetGet ;wallet x) returns Gas.top for any x.
				//and (nondetGet ;spend funcIfWorks paramIfWorks funcElse paramElse).
				cur = 1;
				funcBody = Nondet.nondetGet; //TODO or call that, in case add cbt first params it responds to at runtime?
				/*func = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return infLoop();
				};*
			break;
			*/
			}
			f.setCompiled(new Compiled(cur, constraintOrNull, funcBody));
		}
		for(int i=0; i<fns.size(); i++){
			fn f = fns.get(i);
			lg("fn"+i+": "+f);
		}
		booted = true;
	}
	
	
	
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
...
bootOpChildIndexAtHeight3 of (..(..)(..(..))) is -1
bootOpIndexAtHeight4 of (..(..)(..(..))(..(..)(..(..)))) is -1
...
fn0: .
fn1: (..)
fn2: (.(..))
fn3: (...)
fn4: (..(..))
fn5: (.(.(..)))
...
fn669: (..(..)(..(..))(...(.(..))))
fn670: (..(..)(..(..))(...(...)))
fn671: (..(..)(..(..))(...(..(..))))
fn672: (..(..)(..(..))(..(..).))
fn673: (..(..)(..(..))(..(..)(..)))
fn674: (..(..)(..(..))(..(..)(.(..))))
fn675: (..(..)(..(..))(..(..)(...)))
fn676: (..(..)(..(..))(..(..)(..(..))))
Occamsfuncer booted.
Starting testInfiniteLoopEndsCuzRunsOutOfGas
testInfiniteLoopEndsCuzRunsOutOfGas passed by ending early
Starting testSTLR
test pass: st.L()==S
test pass: st.R()==T
Starting testIdentityFuncs
test pass: leaf.L()==I
test pass: leaf.R()==leaf
test pass: stt.f(I)==I
test pass: stt.f(T)==T
test pass: stt.f(F)==F
test pass: I.f(stt)==stt
test pass: I.f(T)==T
Starting testSCurryList
test pass: pair.f(getp).f(curry).f(T)==getp
test pass: pair.f(getp).f(curry).f(F)==curry
test pass: t(getp)==T.f(getp)
test pass: T.f(getp).f(curry)==getp
S( [(T0), (T1)] ) returning (S(T0)(T1))
cbtFuncBody of l=0 r=1
cbt01: (01)
cbt01__2: (01)
test pass
S( [(TP), (TG), (TC)] ) returning (S(S(TP)(TG))(TC))
SCurryA: (S(S(TP)(TG))(TC))
pair_getp_curry: (PGC)
test pass
S( [(TT), (TG), (TC)] ) returning (S(S(TT)(TG))(TC))
SCurryB: (S(S(TT)(TG))(TC))
test pass: f(S(t(T), t(getp), t(curry)),leaf)==getp
test pass: F.f(getp).f(curry)==getp
S( [(TF), (TG), (TC)] ) returning (S(S(TF)(TG))(TC))
test pass: f(S(t(F), t(getp), t(curry)),leaf)==curry
Starting testIsUnaryCbt
test pass: unary0
cbtFuncBody of l=1 r=1
test pass: unary1
cbtFuncBody of l=<unary1> r=<unary1>
test pass: unary2
cbtFuncBody of l=<unary2> r=<unary2>
test pass: unary3
cbtFuncBody of l=<unary3> r=<unary3>
test pass: unary4
cbtFuncBody of l=<unary4> r=<unary4>
test pass: unary5
test pass
test pass
test pass
cbtFuncBody of l=1 r=0
test pass
test pass
cbtFuncBody of l=1 r=<unary1>
test pass
test pass
test pass
Starting testGetp
cbtFuncBody of l=<unary5> r=<unary5>
x: (C<unary6>TT)
madeByCurryForConstraint: (Z(C<unary6>TT)0)
y: (C<unary6>TT0)
madeByCurryForFuncBody: (Z(C<unary6>TT0)1)
test pass: constraintGetsSecondLastParam
test pass: funcBodyGetsLastParam
test pass: funcBodyGetsSecondLastParam
test pass: constraint_getpunary4_is_cbt0
test pass: constraint_getpunary5_is_leaf_cuzParamIndexDoesntExist
test pass: constraint_getpunary6_is_leaf_cuzParamIndexDoesntExist
test pass: funcBody_getpunary4_is_cbt0
test pass: funcBody_getpunary5_is_cbt1
Starting testAnd
S( [(G.<unary4>), (G.<unary5>), (TF)] ) returning (S(S(G.<unary4>)(G.<unary5>))(TF))
and=(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))
test pass: and_F_F
test pass: and_F_T
test pass: and_T_F
test pass: and_T_T
Starting testString
s: abc
cbtFuncBody of l=(01) r=<mayBeStr:>
cbtFuncBody of l=0 r=0
cbtFuncBody of l=(00) r=(01)
cbtFuncBody of l=(01<mayBeStr:>) r=(00(01))
cbtFuncBody of l=(00) r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>) r=(00<mayBeStr:>)
cbtFuncBody of l=(01<mayBeStr:>(00(01))) r=(01<mayBeStr:>(00<mayBeStr:>))
cbtFuncBody of l=(00) r=<unary1>
cbtFuncBody of l=(01<mayBeStr:>) r=(00<unary1>)
cbtFuncBody of l=<mayBeStr:> r=(00)
cbtFuncBody of l=(00) r=(00)
cbtFuncBody of l=<mayBeStr:> r=(00(00))
cbtFuncBody of l=(01<mayBeStr:>(00<unary1>)) r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>))) r=<mayBeStr:c>
fnAbc: <mayBeStr:abc>
s__2: abc
test pass
cbtFuncBody of l=(01<mayBeStr:>) r=<unary2>
cbtFuncBody of l=(01<mayBeStr:><unary2>) r=(01<mayBeStr:>(00<unary1>))
cbtFuncBody of l=(01<mayBeStr:>) r=(01<mayBeStr:>)
cbtFuncBody of l=<unary1> r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>) r=(<unary1><mayBeStr:>)
cbtFuncBody of l=(01<mayBeStr:>(01<mayBeStr:>)) r=(01<mayBeStr:>(<unary1><mayBeStr:>))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))) r=(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))
cbtFuncBody of l=(01) r=<unary1>
cbtFuncBody of l=(01<unary1>) r=(00(00))
cbtFuncBody of l=<unary1> r=(00)
cbtFuncBody of l=(01<mayBeStr:>) r=(<unary1>(00))
cbtFuncBody of l=(01<unary1>(00(00))) r=(01<mayBeStr:>(<unary1>(00)))
cbtFuncBody of l=(01) r=(01)
cbtFuncBody of l=(01<unary1>) r=(01(01))
cbtFuncBody of l=(01<mayBeStr:>) r=(01<unary1>)
cbtFuncBody of l=(01<unary1>(01(01))) r=(01<mayBeStr:>(01<unary1>))
cbtFuncBody of l=(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))) r=(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>)))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))) r=(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>))))
cbtFuncBody of l=<mayBeStr:> r=<mayBeStr:>
cbtFuncBody of l=(00<unary1>) r=(<mayBeStr:><mayBeStr:>)
cbtFuncBody of l=<mayBeStr:> r=(01)
cbtFuncBody of l=(01<mayBeStr:>) r=(<mayBeStr:>(01))
cbtFuncBody of l=(00<unary1>(<mayBeStr:><mayBeStr:>)) r=(01<mayBeStr:>(<mayBeStr:>(01)))
cbtFuncBody of l=<unary1> r=(01)
cbtFuncBody of l=(01<mayBeStr:>) r=(<unary1>(01))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))) r=(01<mayBeStr:>(<unary1>(01)))
cbtFuncBody of l=(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))) r=(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))
cbtFuncBody of l=(01) r=(00)
cbtFuncBody of l=(01<unary1>) r=(01(00))
cbtFuncBody of l=(01<unary1>(01(01))) r=(01<unary1>(01(00)))
cbtFuncBody of l=(01<unary1>(01(01))(01<unary1>(01(00)))) r=(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>)))
cbtFuncBody of l=(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))) r=(01<unary1>(01(01))(01<unary1>(01(00)))(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>))))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>))))) r=(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>)))))
cbtFuncBody of l=(01<mayBeStr:>) r=(01(01))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))) r=(01<mayBeStr:>(01(01)))
cbtFuncBody of l=(01<unary1>) r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>(01(01))) r=(01<unary1><mayBeStr:>)
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))) r=(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))
cbtFuncBody of l=(01<mayBeStr:>(00<unary1>)) r=(01<mayBeStr:>(01(01)))
cbtFuncBody of l=(01<unary1>(00(00))) r=(01<unary1>(01(00)))
cbtFuncBody of l=(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))) r=(01<unary1>(00(00))(01<unary1>(01(00))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))) r=(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))
cbtFuncBody of l=(01<mayBeStr:>(01<unary1>)) r=(01<mayBeStr:>(00(01)))
cbtFuncBody of l=(01<unary1>) r=(00<unary1>)
cbtFuncBody of l=(00<mayBeStr:>) r=(<unary1><mayBeStr:>)
cbtFuncBody of l=(01<unary1>(00<unary1>)) r=(00<mayBeStr:>(<unary1><mayBeStr:>))
cbtFuncBody of l=(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))) r=(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))
cbtFuncBody of l=(01<mayBeStr:>(00<unary1>)) r=(01<mayBeStr:>(00(01)))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))) r=(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01))))
cbtFuncBody of l=(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))) r=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01)))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))) r=(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01))))))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>))))(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>)))))) r=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01)))))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))) r=(01<unary1>(00<unary1>))
cbtFuncBody of l=(01<mayBeStr:>(01<mayBeStr:>)) r=(01<unary1>(01(01)))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))) r=(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1><mayBeStr:>)) r=(01<mayBeStr:>(00<unary1>))
cbtFuncBody of l=(01<unary1>) r=(00<mayBeStr:>)
cbtFuncBody of l=(01<mayBeStr:>(01(01))) r=(01<unary1>(00<mayBeStr:>))
cbtFuncBody of l=(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))) r=(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>)))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))) r=(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>))))
cbtFuncBody of l=(00<mayBeStr:>(<unary1><mayBeStr:>)) r=(01<mayBeStr:>(<mayBeStr:>(01)))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))) r=(01<unary1>(00(00)))
cbtFuncBody of l=(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))) r=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))) r=(00<mayBeStr:>(<unary1><mayBeStr:>))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))) r=(01<unary1>(01(01))(01<unary1>(01(00))))
cbtFuncBody of l=(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))) r=(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))(01<unary1>(01(01))(01<unary1>(01(00)))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>))))) r=(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))(01<unary1>(01(01))(01<unary1>(01(00))))))
cbtFuncBody of l=(01<mayBeStr:>(<mayBeStr:>(01))) r=(01<mayBeStr:>(<unary1>(00)))
cbtFuncBody of l=(01(00)) r=(01(01))
cbtFuncBody of l=(00<mayBeStr:>(<unary1><mayBeStr:>)) r=(01(00)(01(01)))
cbtFuncBody of l=(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))) r=(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))
cbtFuncBody of l=(01<unary1><mayBeStr:>) r=(01<mayBeStr:>(00(01)))
cbtFuncBody of l=(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))) r=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))
cbtFuncBody of l=(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))) r=(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00)))))
cbtFuncBody of l=(00<mayBeStr:>(<unary1><mayBeStr:>)) r=(01<mayBeStr:><unary2>)
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))) r=(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))
cbtFuncBody of l=(01<mayBeStr:>(00<unary1>)) r=(01<mayBeStr:>(01<mayBeStr:>))
cbtFuncBody of l=(01<mayBeStr:>(<unary1><mayBeStr:>)) r=(01<unary1>(00(00)))
cbtFuncBody of l=(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))) r=(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))) r=(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00)))))
cbtFuncBody of l=(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00)))))) r=(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00))))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>))))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))(01<unary1>(01(01))(01<unary1>(01(00))))))) r=(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00)))))))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>))))(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01)))))))) r=(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>))))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))(01<unary1>(01(01))(01<unary1>(01(00))))))(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00))))))))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))) r=(01<unary1>(01(01)))
cbtFuncBody of l=(01<mayBeStr:>(01<unary1>)) r=(01(00)(01(01)))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<unary1>(01(01)))) r=(01<mayBeStr:>(01<unary1>)(01(00)(01(01))))
cbtFuncBody of l=(01<unary1>) r=(00(01))
cbtFuncBody of l=(01<unary1>(00(01))) r=(01<unary1>(00(01)))
cbtFuncBody of l=(01(00)) r=<unary2>
cbtFuncBody of l=(01(00)<unary2>) r=(01<mayBeStr:>(01<mayBeStr:>))
cbtFuncBody of l=(01<unary1>(00(01))(01<unary1>(00(01)))) r=(01(00)<unary2>(01<mayBeStr:>(01<mayBeStr:>)))
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<unary1>(01(01)))(01<mayBeStr:>(01<unary1>)(01(00)(01(01))))) r=(01<unary1>(00(01))(01<unary1>(00(01)))(01(00)<unary2>(01<mayBeStr:>(01<mayBeStr:>))))
cbtFuncBody of l=(01(01)) r=(00(00))
cbtFuncBody of l=(01(01)(00(00))) r=(01<mayBeStr:>(00(01)))
cbtFuncBody of l=(01<mayBeStr:>(<mayBeStr:>(01))) r=(01<unary1>(00<mayBeStr:>))
cbtFuncBody of l=(01(01)(00(00))(01<mayBeStr:>(00(01)))) r=(01<mayBeStr:>(<mayBeStr:>(01))(01<unary1>(00<mayBeStr:>)))
cbtFuncBody of l=(00(00)) r=(00(00))
cbtFuncBody of l=<mayBeStr:> r=(00(00)(00(00)))
cbtFuncBody of l=(00(00)(00(00))) r=(00(00)(00(00)))
cbtFuncBody of l=<mayBeStr:> r=(00(00)(00(00))(00(00)(00(00))))
cbtFuncBody of l=(01(01)(00(00))(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<mayBeStr:>(01))(01<unary1>(00<mayBeStr:>)))) r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<unary1>(01(01)))(01<mayBeStr:>(01<unary1>)(01(00)(01(01))))(01<unary1>(00(01))(01<unary1>(00(01)))(01(00)<unary2>(01<mayBeStr:>(01<mayBeStr:>))))) r=<mayBeStr:Pair>
cbtFuncBody of l=(00(00)(00(00))(00(00)(00(00)))) r=(00(00)(00(00))(00(00)(00(00))))
cbtFuncBody of l=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))) r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))
cbtFuncBody of l=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))) r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))
cbtFuncBody of l=<mayBeStr:lugEqqOfPair> r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))))
cbtFuncBody of l=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))) r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))))
cbtFuncBody of l=<mayBeStr:lugEqqOfPair> r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>))))(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01)))))))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>))))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))(01<unary1>(01(01))(01<unary1>(01(00))))))(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00))))))))) r=<mayBeStr:lugEqqOfPair>
test pass: plugEqqAPair
test pass: plugEqqBPair
cbtFuncBody of l=(01<unary1>(00(01))(01<unary1>(00(01)))) r=<mayBeStr:>
cbtFuncBody of l=(01<mayBeStr:>(<unary1>(00))(01<unary1>(01(01)))(01<mayBeStr:>(01<unary1>)(01(00)(01(01))))) r=<mayBeStr:qq>
cbtFuncBody of l=<mayBeStr:lugEqq> r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))
cbtFuncBody of l=<mayBeStr:lugEqq> r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))))
cbtFuncBody of l=<mayBeStr:lugEqq> r=(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))(00(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))))
cbtFuncBody of l=(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<mayBeStr:>(<unary1><mayBeStr:>)))(01<unary1>(00(00))(01<mayBeStr:>(<unary1>(00)))(01<unary1>(01(01))(01<mayBeStr:>(01<unary1>))))(00<unary1>(<mayBeStr:><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<mayBeStr:>(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01<mayBeStr:>(00(01))(01<mayBeStr:>(00<mayBeStr:>)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(01<mayBeStr:>(01(01))(01<unary1><mayBeStr:>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01<mayBeStr:>(01<unary1>)(01<mayBeStr:>(00(01)))(01<unary1>(00<unary1>)(00<mayBeStr:>(<unary1><mayBeStr:>)))(01<mayBeStr:><unary2>(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(00(01)))))))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00<unary1>))(01<mayBeStr:>(01<mayBeStr:>)(01<unary1>(01(01))))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(00<unary1>))(01<mayBeStr:>(01(01))(01<unary1>(00<mayBeStr:>))))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:>(<mayBeStr:>(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00))))(01<mayBeStr:>(<unary1>(00))(00<mayBeStr:>(<unary1><mayBeStr:>))(01<unary1>(01(01))(01<unary1>(01(00))))))(01<mayBeStr:>(<mayBeStr:>(01))(01<mayBeStr:>(<unary1>(00)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01(00)(01(01))))(01<unary1><mayBeStr:>(01<mayBeStr:>(00(01)))(01<mayBeStr:>(<unary1>(01))(01<unary1>(00(00)))))(01<mayBeStr:>(<unary1>(00))(01<mayBeStr:>(01(01)))(00<mayBeStr:>(<unary1><mayBeStr:>)(01<mayBeStr:><unary2>))(01<mayBeStr:>(00<unary1>)(01<mayBeStr:>(01<mayBeStr:>))(01<mayBeStr:>(<unary1><mayBeStr:>)(01<unary1>(00(00))))))))) r=<mayBeStr:lugEqq>
test pass: plugEqqACurry
test pass: plugEqqBCurry
Starting testUnaryAddWhichUsesCurryAndRecur
test pass: unaryInc_u3
S( [(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1)), (G.<unary5>)] ) returning (S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>))
S( [(G.<unary4>), (G.<unary5>)] ) returning (S(G.<unary4>)(G.<unary5>))
S( [(T(SII)), (G.<unary4>)] ) returning (S(T(SII))(G.<unary4>))
S( [(TL), (G.<unary5>)] ) returning (S(TL)(G.<unary5>))
S( [E, (S(T(SII))(G.<unary4>)), (S(TL)(G.<unary5>))] ) returning (S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))
S( [(T?), (S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)), (C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)), (C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>))))] ) returning (S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))1)1))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))1)1))
test pass: unaryAddUsingNondetEqq_u0_u0
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary1>)<unary1>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary1>)<unary1>))
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary2>)1))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary2>)1))
test pass: unaryAddUsingNondetEqq_u1_u1
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary2>)<unary1>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary2>)<unary1>))
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary3>)1))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary3>)1))
test pass: unaryAddUsingNondetEqq_u2_u1
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary2>)<unary3>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary2>)<unary3>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary3>)<unary2>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary3>)<unary2>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary4>)<unary1>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary4>)<unary1>))
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary5>)1))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))(Z(C<unary5>T(S(S(S(T?)(S(T(C<unary5>T(Q<mayBeStr:ocfnplug:immutableexceptgas.occamsfuncer.impl.util.Example.ocfnplugEqq>)1))(G.<unary5>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(SE(S(T(SII))(G.<unary4>)))(S(TL)(G.<unary5>)))))<unary5>)1))
test pass: unaryAddUsingNondetEqq_u2_u3
Starting testLazys
cbtFuncBody of l=<unary6> r=<unary6>
S( [(G.<unary4>), (G.<unary7>)] ) returning (S(G.<unary4>)(G.<unary7>))
S( [(G.<unary5>), (G.<unary7>)] ) returning (S(G.<unary5>)(G.<unary7>))
S( [(S(G.<unary4>)(G.<unary7>)), (S(G.<unary5>)(G.<unary7>))] ) returning (S(S(G.<unary4>)(G.<unary7>))(S(G.<unary5>)(G.<unary7>)))
test pass: lazys_reverses_10_to_01
Starting testLazig
test pass: lazigA
Starting testEqualsWithoutOptimizationsOrDedup
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight3 of (.(..)(.(..))) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight3 of (.(..)(.(..))) is 0
bootOpIndexAtHeight4 of (.(..)(.(..))(.(..)(.(..)))) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight3 of (.(..)(.(..))) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight2 of (.(..)) is 0
bootOpChildIndexAtHeight3 of (.(..)(.(..))) is 0
bootOpIndexAtHeight4 of (.(..)(.(..))(.(..)(.(..)))) is 0
S( [(TY), (G.<unary5>)] ) returning (S(TY)(G.<unary5>))
S( [(TY), (G.<unary4>)] ) returning (S(TY)(G.<unary4>))
S( [(TL), (G.<unary4>)] ) returning (S(TL)(G.<unary4>))
S( [(TL), (G.<unary5>)] ) returning (S(TL)(G.<unary5>))
S( [E, (S(TL)(G.<unary4>)), (S(TL)(G.<unary5>))] ) returning (S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))
S( [(TR), (G.<unary4>)] ) returning (S(TR)(G.<unary4>))
S( [(TR), (G.<unary5>)] ) returning (S(TR)(G.<unary5>))
S( [E, (S(TR)(G.<unary4>)), (S(TR)(G.<unary5>))] ) returning (S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))
S( [(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))), (S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))), (S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))] ) returning (S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))
S( [(T?), (S(TY)(G.<unary5>)), (T(TF)), (C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))] ) returning (S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))
S( [(T?), (S(TY)(G.<unary4>)), (C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))), (C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))] ) returning (S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))
equals=(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))
equalsLeaf=(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).)
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).).))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).).))
test pass: equals_leaf_leaf
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
test pass: equals_leafLeaf_leafLeaf
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
test pass: equals_leafLeaf_copyOfLeafLeaf
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).)(..)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).)(..)))
test pass: equals_leaf_leafLeaf
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))0)(.(..)(.(..))(.(..)(.(..))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))0)(.(..)(.(..))(.(..)(.(..))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))0)(.(..)(.(..))(.(..)(.(..))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
test pass: equalsA
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))(.(..)(.(..)))))0))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))(.(..)(.(..)))))0))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))(.(..)(.(..)))))0))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))
test pass: equalsB
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))1)(.(..)(.(..))(.(..)(.(..))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))1)(.(..)(.(..))(.(..)(.(..))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))1)(.(..)(.(..))(.(..)(.(..))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(...)))(.(..)(.(..)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(...)))(.(..)(.(..)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(...)))(.(..)(.(..)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...))(.(..))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...))(.(..))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...))(.(..))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..)).))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..)).))
ifElse l=(?T(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..)).))
test pass: equalsC
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))(.(..)(.(..)))))1))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))(.(..)(.(..)))))1))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))(.(..)(.(..)))))1))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(...))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(...))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(...))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(...)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(...)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(...)))
ifElse l=(?T(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).)(..)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))).)(..)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..)).))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..)).))
ifElse l=(?T(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..)).))
test pass: equalsD
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(Z(SII)(SII)))(Z(SII)(SII))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(Z(SII)(SII)))(Z(SII)(SII))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(Z(SII)(SII)))(Z(SII)(SII))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(Z(SII)))(Z(SII))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(Z(SII)))(Z(SII))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(Z(SII)))(Z(SII))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))Z)Z))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))Z)Z))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))Z)Z))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...(.(..))))(...(.(..)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...(.(..))))(...(.(..)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...(.(..))))(...(.(..)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...))(...)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...))(...)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...))(...)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(..))(..)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)))(.(..))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...(...)))(...(...))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...(...)))(...(...))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(...(...)))(...(...))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SII))(SII)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SII))(SII)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SII))(SII)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SI))(SI)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SI))(SI)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SI))(SI)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))S)S))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))S)S))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))S)S))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(...)))(.(..)(...))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(...)))(.(..)(...))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(...)))(.(..)(...))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))I)I))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))I)I))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))I)I))
test pass: somethingLambdaFuncsCantDoCuzItWouldInfiniteLoop
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))))(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))))(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))))(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T))(C<unary5>T)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T))(C<unary5>T)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T))(C<unary5>T)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>))(C<unary5>)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>))(C<unary5>)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>))(C<unary5>)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))C)C))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))C)C))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))C)C))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(.(..)(.(..))))(.(..)(.(..)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary5>)<unary5>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary5>)<unary5>))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary5>)<unary5>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary4>)<unary4>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary4>)<unary4>))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary4>)<unary4>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary3>)<unary3>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary3>)<unary3>))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary3>)<unary3>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary2>)<unary2>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary2>)<unary2>))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary2>)<unary2>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary1>)<unary1>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary1>)<unary1>))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary1>)<unary1>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))1)1))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))1)1))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))1)1))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))T)T))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))T)T))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))T)T))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))))(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary4>)))))(S(S(T?)(S(TY)(G.<unary4>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary4>)))))(S(S(T?)(S(TY)(G.<unary4>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary4>)))))(S(S(T?)(S(TY)(G.<unary4>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)(S(TY)(G.<unary4>))))(S(T?)(S(TY)(G.<unary4>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)(S(TY)(G.<unary4>))))(S(T?)(S(TY)(G.<unary4>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)(S(TY)(G.<unary4>))))(S(T?)(S(TY)(G.<unary4>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)))(S(T?))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)))(S(T?))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)))(S(T?))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T?))(T?)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T?))(T?)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T?))(T?)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))?)?))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))?)?))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))?)?))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)(G.<unary4>)))(S(TY)(G.<unary4>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)(G.<unary4>)))(S(TY)(G.<unary4>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)(G.<unary4>)))(S(TY)(G.<unary4>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)))(S(TY))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)))(S(TY))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)))(S(TY))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TY))(TY)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TY))(TY)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TY))(TY)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))Y)Y))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))Y)Y))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))Y)Y))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.<unary4>))(G.<unary4>)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.<unary4>))(G.<unary4>)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.<unary4>))(G.<unary4>)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.))(G.)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.))(G.)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.))(G.)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))G)G))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))G)G))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))G)G))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T))(C<unary6>T)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T))(C<unary6>T)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T))(C<unary6>T)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>))(C<unary6>)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>))(C<unary6>)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>))(C<unary6>)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary6>)<unary6>))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary6>)<unary6>))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))<unary6>)<unary6>))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(G.<unary4>)(G.<unary5>)))(S(G.<unary4>)(G.<unary5>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(G.<unary4>)(G.<unary5>)))(S(G.<unary4>)(G.<unary5>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(G.<unary4>)(G.<unary5>)))(S(G.<unary4>)(G.<unary5>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(G.<unary4>)))(S(G.<unary4>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(G.<unary4>)))(S(G.<unary4>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(G.<unary4>)))(S(G.<unary4>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.<unary5>))(G.<unary5>)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.<unary5>))(G.<unary5>)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(G.<unary5>))(G.<unary5>)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)(G.<unary5>)))(S(TY)(G.<unary5>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)(G.<unary5>)))(S(TY)(G.<unary5>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TY)(G.<unary5>)))(S(TY)(G.<unary5>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary5>)))(T(TF))))(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary5>)))(T(TF))))(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary5>)))(T(TF))))(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary5>)))))(S(S(T?)(S(TY)(G.<unary5>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary5>)))))(S(S(T?)(S(TY)(G.<unary5>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T?)(S(TY)(G.<unary5>)))))(S(S(T?)(S(TY)(G.<unary5>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)(S(TY)(G.<unary5>))))(S(T?)(S(TY)(G.<unary5>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)(S(TY)(G.<unary5>))))(S(T?)(S(TY)(G.<unary5>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T?)(S(TY)(G.<unary5>))))(S(T?)(S(TY)(G.<unary5>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T(TF)))(T(TF))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T(TF)))(T(TF))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T(TF)))(T(TF))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TF))(TF)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TF))(TF)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TF))(TF)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))F)F))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))F)F))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))F)F))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))))(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(G.<unary4>)(G.<unary5>))(TF)))(S(S(G.<unary4>)(G.<unary5>))(TF))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(G.<unary4>)(G.<unary5>))(TF)))(S(S(G.<unary4>)(G.<unary5>))(TF))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(G.<unary4>)(G.<unary5>))(TF)))(S(S(G.<unary4>)(G.<unary5>))(TF))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(G.<unary4>)(G.<unary5>))))(S(S(G.<unary4>)(G.<unary5>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(G.<unary4>)(G.<unary5>))))(S(S(G.<unary4>)(G.<unary5>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(S(G.<unary4>)(G.<unary5>))))(S(S(G.<unary4>)(G.<unary5>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TL)(G.<unary4>)))))(S(SE(S(TL)(G.<unary4>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TL)(G.<unary4>)))))(S(SE(S(TL)(G.<unary4>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TL)(G.<unary4>)))))(S(SE(S(TL)(G.<unary4>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE(S(TL)(G.<unary4>))))(SE(S(TL)(G.<unary4>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE(S(TL)(G.<unary4>))))(SE(S(TL)(G.<unary4>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE(S(TL)(G.<unary4>))))(SE(S(TL)(G.<unary4>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE))(SE)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE))(SE)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE))(SE)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))E)E))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))E)E))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))E)E))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)(G.<unary4>)))(S(TL)(G.<unary4>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)(G.<unary4>)))(S(TL)(G.<unary4>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)(G.<unary4>)))(S(TL)(G.<unary4>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)))(S(TL))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)))(S(TL))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)))(S(TL))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TL))(TL)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TL))(TL)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TL))(TL)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))L)L))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))L)L))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))L)L))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)(G.<unary5>)))(S(TL)(G.<unary5>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)(G.<unary5>)))(S(TL)(G.<unary5>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TL)(G.<unary5>)))(S(TL)(G.<unary5>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TR)(G.<unary4>)))))(S(SE(S(TR)(G.<unary4>))))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TR)(G.<unary4>)))))(S(SE(S(TR)(G.<unary4>))))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(SE(S(TR)(G.<unary4>)))))(S(SE(S(TR)(G.<unary4>))))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE(S(TR)(G.<unary4>))))(SE(S(TR)(G.<unary4>)))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE(S(TR)(G.<unary4>))))(SE(S(TR)(G.<unary4>)))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(SE(S(TR)(G.<unary4>))))(SE(S(TR)(G.<unary4>)))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)(G.<unary4>)))(S(TR)(G.<unary4>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)(G.<unary4>)))(S(TR)(G.<unary4>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)(G.<unary4>)))(S(TR)(G.<unary4>))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)))(S(TR))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)))(S(TR))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)))(S(TR))))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TR))(TR)))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TR))(TR)))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(TR))(TR)))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))R)R))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))R)R))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))R)R))
ifElse l=(?F(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)(G.<unary5>)))(S(TR)(G.<unary5>))))) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)(G.<unary5>)))(S(TR)(G.<unary5>))))
ifElse l=(?F(TF)) r=(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))(Z(C<unary5>T(S(S(S(T?)(S(TY)(G.<unary4>)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(TY)(G.<unary5>))))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(S(T?)(S(TY)(G.<unary5>)))(T(TF)))(C<unary6>T(S(G.<unary4>)(G.<unary5>))(S(S(T(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))(S(SE(S(TL)(G.<unary4>)))(S(TL)(G.<unary5>))))(S(SE(S(TR)(G.<unary4>)))(S(TR)(G.<unary5>))))))))(S(TR)(G.<unary5>)))(S(TR)(G.<unary5>))))
test pass: equals(equals,equals)==T
Exception in thread "main" java.lang.Error: TODO test Example.doubleAdd()
	at immutableexceptgas.occamsfuncer.impl.test.TestBasics.testDoubleAddUnoptimized(TestBasics.java:279)
	at immutableexceptgas.occamsfuncer.impl.test.TestBasics.main(TestBasics.java:369)
	at start.StartTestsLocal.main(StartTestsLocal.java:24)
	
