/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncerV2.impl.util;

/** For efficiency of a universal lambda function,
there should be a powOf2 number of opcodes.
Constraints infiniteLoop when not satisfied,
which fits into the model of the Wallet and Spend etc ops
which are nondeterministic, or so me nondetIf (only
nondeterministic if that amount of computing wasnt allocated)
and would jump back to the innermost spend's else call,
as (spend maxSpend funcIfWorks paramIfWorks funcElse paramElse)
though nondet and nondetIf are highly experimental
compared to the other lambda parts
and you might do better to turn on
complete determinism mode in which nondet always infLoops
and nondetIf always returns theLeaf.
nondet and nondetIf can also be hooks into other systems,
but its best if thats done in the other 14 pure deterministic ops.
<br><br>
. is a the universal lambda and is halted.
(..) is calling it on itself and is halted.
(.(..)) is called bit0, and is not the same as the cbt bits.
((..).) is called bit1, and is not the same as the cbt bits.
There are 16 combos of bit0 and bit1
which mean these 16 ops.
If . is depth 0, then all 16 ops are at depth 4.
<br><br>
((bit0 bit0)(bit0 bit0))
((bit0 bit0)(bit0 bit1))
((bit0 bit0)(bit1 bit0))
((bit0 bit0)(bit1 bit1))
<br><br>
((bit0 bit1)(bit0 bit0))
((bit0 bit1)(bit0 bit1))
((bit0 bit1)(bit1 bit0))
((bit0 bit1)(bit1 bit1))
<br><br>
((bit1 bit0)(bit0 bit0))
((bit1 bit0)(bit0 bit1))
((bit1 bit0)(bit1 bit0))
((bit1 bit0)(bit1 bit1))
<br><br>
((bit1 bit1)(bit0 bit0))
((bit1 bit1)(bit0 bit1))
((bit1 bit1)(bit1 bit0))
((bit1 bit1)(bit1 bit1))
<br><br>
Any of those 16 things called on any of eachother are as the opcodes
say to do and represent incomplete curries
the same as any other funcall pair up from ./leaf .
<br><br>
Any funcallPair of those lower thats not defined in that
is defined as a halted state,
such as ((..)((..)(..))) evals to itself.
<br><br>
TODO copy comments from my mindmap in these names:
choosingListOfOccamsfuncerOpsFromWhichMapPairConsCarCdrEtcWillBeDerived2019-10-23+
occamsfuncer
*/
public enum Op{
	
	
	
	
	
	
	
	
	/*TODO copy the rest of the comments from
	choosingListOfOccamsfuncerOpsFromWhichMapPairConsCarCdrEtcWillBeDerived2019-10-23+
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*FIXME rename this to a subtype of occamsfuncer?
	like i did for the others
	occamsfuncer_typecontent and occamsfuncerbycoretype etc,
	Maybe something like occamsfuncer_01rlftis (not describing all 16 ops)
	...
	Maybe I need to play with this most direct form of occamsfuncer
	before I'm able to redesign its datastructs to have
	less callpairs and moreimportantly to not have to
	<func,param,return> cache as many things.
	*/
	
	/*TODO define the first depth n of binForest shapes
	mapping to/from integer, at least up to depth 4 (where leaf is depth 0),
	and define it for some of the shallower cbts.
	...
	Each next depth, it uses 2 numbers. Theres a total so far
	and a group after that. The total so far already includes
	all pairs within itself, or something like that. I'm not explaining this well.
	TODO count it out and verify I've aligned it right in the first few,
	then automate it.
	The next depth is to compute all pairs of whats already there
	MINUS whats already there.
	...
	depth0 1 leaf, 1 total
	depth1 1 more, 2 total
	depth2 3 more, 5 total
	depth3 
	depth4
	
	FIXME choose which go together? cbt0 T L, cbt1 F R. T goes with 0? Align better.
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* FIXME, choose a design...
	Allow cbt0 and cbt1 to form things that arent completeBinaryTrees
	like (0(11))? Would make it more efficient since wouldnt have to
	use pair on that.
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	isLeaf(1,'_'),
	
	/** Lx.Ly.Lz.zxy.
	(pair x y F) returnx x.
	(pair x y T) returns y.
	(pair x y) is halted, of course.
	*/
	pair(3,'2'),
	
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
	*
	ifElse(3,'?'),
	*/
	
	/** This will be derived instead of being an op, to make room for lazig.
	(lazyEval x y z) aka (((lazyEval x) y) z) returns (x y z) aka ((x y) z).
	(lazyeval x y) is halted.
	*
	lazyEval(3,'Z'),
	*/
	
	
	/** (lazig x y z) returns (x y). Used in ifElse and curry and getp and recur.
	In an earlier design lazyEval was used for that.
	*
	lazig(3, 'Z'),
	*/
	
	/*FIXME need G and setG ops, so make 2 of these not be ops and instead
	derive them in Example class, and get the Compiled optimizations working
	asap so that wont affect efficiency much. It cant be any 2 ops that
	are needed in curry. Curry doesnt use ifElse or lazig, so it could be those.
	Or it could be getp and recur since those could be derived by s and k,
	but its easier to derive ifElse and lazig than to rederive getp and recur.
	*/
	
	/** get comment, the third trinary branch like L and R */
	comment(1,'m'),
	
	/** set comment, the third trinary branch like L and R */
	COMMENT(2,'M'),
	
	
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
	getp(3,'P'),
	
	/** same logic as ImportStatic.recurse which uses .getNthCurry,
	TODO explain more directly.
	*/
	recur(1,'U'),
	
	/** UPDATE: (nondet type instance param), has 3 params instead of
	the 2 params occamsfuncerV1 had. This change is to make it
	more optimizable by Compiled.java which will normally go in
	(nondet someType).
	<br><br>
	OLD...
	<br><br>
	First param is normally a cbt thats either an arbitrary
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
	nondet(3,'Q');
	/*TODO update comments. like explained in Nondet.java,
	the first param of nondet is always a type:content
	such as "image/jpeg:...bytesOfJpgFile..."
	and such as "ocfnplug:package.a.b.name.func"
	and including types for few wallet related ops (Wallet Spend InfloopIf).
	but must still use op.curry if want it to have more than 1 param (after the type:content fijrst param)
	*/
	
	private static final Op[] vals = Op.values();
	
	public static Op atIndex(int i){
		return vals[i];
	}
			
	public final int cur;
	
	/** the abbrev of leaf is '.' but its not one of the 16 ops
	since those are all at depth4.
	*/
	public final char abbrev;
	
	private Op(int cur, char abbrev){
		this.cur = cur;
		this.abbrev = abbrev;
	}

}
