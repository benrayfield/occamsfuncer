# occamsfuncer
an extremely optimizable and scalable universal lambda function meant for number crunching, AI research, and low lag massively multiplayer games that players can redesign into new game types in turingComplete ways by hotswap/forkEditing per bit, per function call pair, etc

This is a redesign of https://github.com/benrayfield/occamsfuncer_typecontent
so theres only 1 leaf and bitstrings are represented a more efficient way for forkAppending.

package immutableexceptgas.occamsfuncer;

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
	cbt0('0'),

	/** see cbt0 */
	cbt1('1'),
	
	/** get right child, as in ((l x)(r x)).equals(x) for all x,
	and (l leaf) is i (identityFunc) and (r leaf) is leaf.
	*/
	R('R'),
	
	/** get left child, as in ((l x)(r x)).equals(x) for all x,
	and (l leaf) is i (identityFunc) and (r leaf) is leaf.
	*/
	L('L'),
	
	/** Lx.Ly.y aka getSecondOf2 aka (k i) */
	F('F'),
	
	////////
	
	/** k aka t aka getFirstOf2. Lx.Ly.x */
	T('T'),
	
	/** identityFunc aka same behaviors as (s k k) other than its forest shape.
	(L theLeaf) returns I.
	*/
	I('I'),
	
	/** Lx.Ly.Lz.xz(yz) */
	S('S'),
	
	////////
	
	/** returns T or F depending if param is ./theLeaf.
	From this, equals func can be derived,
	and so can comparator by forest shape by depth recursively
	or so can any other comparator.
	The equals func will be optimized by secureHash comparing.
	All optimizations go in BinaryOperator<fn> fn.compiled().
	*/
	isLeaf('Y'),
	
	/** Lx.Ly.Lz.zxy.
	(pair x y F) returnx x.
	(pair x y T) returns y.
	(pair x y) is halted, of course.
	*/
	pair('P'),
	
	/** forkJump by binheap indexing, using cbt (complete binary tree) as bitstring
	suffixed by the last cbt1, and before that the cbt0 is L and cbt1 is R.
	This is an urbit-like op.
	*/
	bh('J'),
	
	/** (lazyEval x y z) aka (((lazyEval x) y) z) returns (x y z) aka ((x y) z).
	(lazyeval x y) is halted.
	*/
	lazyEval('Z'),
	
	////////
	
	/** (curry cbtAsUnary constraint/k funcBody ...params...)
	I chose that order of params so Call constructor
	will know its number of curries right away other than if its Op.curry
	whose number of curries is 0 (vararg).
	The BinaryOperator<fn> of Op.curry (in Boot) will check for
	BinaryOperator<fn> fn.compiled() in both constraint/k and funcBody params
	unless somehow I design that to happen when it calls them.
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
	curry('C'),
	
	/** THIS IS INCOMPLETELY DEFINED cuz Op.curry is incompletely defined:
	(getParam comment cbtAsUnary structureMadeByCurryInFuncbodyOrConstraintCall).
	Suggested syntax for cbtAsUnary of 5
	and comment of (utf8 cbt bitstring)"varX" is 5varX.
	<br><br>
	curry and getParam use completeBinaryTree's height to count in unary, so cbt1
	is param0, and ((cbt1 cbt1)(cbt1 cbt1)) is param2. Efficiently shares branches.
	This fits well with bitstrings being suffixed by cbt1 so is a powOf2-1 len bitstring.
	*/
	getParam('G'),
	
	/** Always returns the leaf unless error (in its param)
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
	*/
	nondetInfloopIf('q'),
	
	/** There are only 2 ops related to nondeterminism, one ifFail and one always.
	"occamsfuncerNdAntiop".
	If in pure deterministic mode, evals to (s s s s) aka infinite loop
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
	*/
	nondetGet('Q');
	
	/** the abbrev of leaf is '.' but its not one of the 16 ops
	since those are all at depth4.
	*/
	public final char abbrev;
	
	private Op(char abbrev){
		this.abbrev = abbrev;
	}

}
