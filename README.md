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



/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;
import static immutableexceptgas.occamsfuncer.Gas.*;
import java.util.List;
import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncer.impl.fns.Call;
import immutableexceptgas.occamsfuncer.impl.fns.Leaf;
import sun.jvm.hotspot.runtime.Bytes;

public class Boot{
	
	/** in order of height recursively (TODO verify) */
	public static List<fn> upToDepthN(int n){
		throw new Error("TODO return immutable");
	}
	
	private static fn[] ops;
	
	public static fn op(int i){
		if(ops == null){
			//must be 2^(2^nonnegInteger) such as 16 or 256 or 65536
			//so op number fits in complete binary tree of (.(..)) and ((..).).
			ops = new fn[16];
			Op[] e = Op.class.getEnumConstants();
			if(e.length != ops.length) throw new Error("Wrong number of ops: "+e.length);
			fn leaf = Leaf.instance;
			fn leafLeaf = cp(leaf,leaf);
			fn zero = cp(leaf,leafLeaf);
			fn one = cp(leafLeaf,leaf);
			for(int j=0; j<ops.length; j++){
				fn digitA = (j&8)==0 ? zero : one;
				fn digitB = (j&4)==0 ? zero : one;
				fn digitC = (j&2)==0 ? zero : one;
				fn digitD = (j&1)==0 ? zero : one;
				//These are arbitrarily chosen combos of the one leaf,
				//and they are given meaning by Boot and Leaf.L() and Leaf.R().
				ops[j] = cp(cp(digitA,digitB),cp(digitC,digitD));
			}
		}
		return ops[i];
	}
	
	/** Use Gas.infLoop() instead.
	will not actually infloop but this means avoid running out of
	compute resources by ending whatever you're doing, same as would
	happen if there were any actual infinite loop such as (s s s s)
	except this doesnt consume those resources.
	*
	private static void infLoop(){
		throw Gas.instance;
	}*/
	
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
		List<fn> fns = upToDepthN(4);
		BinaryOperator<fn> other = (fn l, fn r)->{
			throw new Error("TODO");
		};
		for(fn f : fns){
			if(!f.isLeaf()){
				f.setCompiled(other);
			}
		}
		fn T = op(Op.T.ordinal());
		fn F = op(Op.F.ordinal());
		fn pair = op(Op.pair.ordinal());
		for(Op op : Op.class.getEnumConstants()){
			fn f = op(op.ordinal()); //these are among the upToDepthN(4)
			int cur = -1;
			BinaryOperator<fn> constraintOrNull = null; //null means Op.T
			BinaryOperator<fn> funcBody = null;
			switch(op){
			case cbt0:
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					//TODO optimize for efficient bitstrings
					throw new Error("TODO");
				};
			break;
			case cbt1:
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					//TODO optimize for efficient bitstrings
					throw new Error("TODO");
				};
			break;
			case R:
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r.R();
				};
			break;
			case L:
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r.L();
				};
			break;
			case F:
				//(f x y) returns y
				cur = 2;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					throw new Error("TODO");
				};
			break;
			case T:
				//(t x y) returns x
				cur = 2;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					throw new Error("TODO");
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
					$();
					fn x = l.L().R();
					fn y = l.R();
					return x.f(r).f(y.f(r));
				};
			break;
			case isLeaf:
				cur = 1;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					return r.isLeaf() ? T : F;
				};
			break;
			case pair:
				//(pair x y r) returns (r x y)
				cur = 3;
				funcBody = (BinaryOperator<fn>)(fn l, fn r)->{
					$();
					fn x = l.L().R();
					fn y = l.R();
					return r.f(x).f(y);
				};
			break;
			case bh:
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
			case getParam:
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
			case nondetInfloopIf:
				cur = 1;
				funcBody = Nondet.nondetInfloopIf; //TODO or call that, in case add cbt first params it responds to at runtime?
				/*func = (BinaryOperator<fn>)(fn l, fn r)->{
					//TODO sub-op for Gas.infLoop() IF doesnt have enough Gas.top
					$();
					return Leaf.instance;
				};*/
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
				};*/
			break;
			}
			f.setCompiled(func);
		}
	}

}



Occamsfuncer booted.
Starting testSTLR
cur=2 this=(ST)
test pass: st.L()==S
test pass: st.R()==T
Starting testIdentityFuncs
cur=1 this=((ST)T)
test pass: leaf.L()==I
test pass: leaf.R()==leaf
cur=1 this=(TI)
test pass: stt.f(I)==I
cur=1 this=(TT)
test pass: stt.f(T)==T
cur=1 this=(TF)
test pass: stt.f(F)==F
test pass: I.f(stt)==stt
test pass: I.f(T)==T
Starting testSCurryList
cur=2 this=(PG)
cur=1 this=((PG)C)
cur=1 this=(TG)
test pass: pair.f(getp).f(curry).f(T)==getp
cur=1 this=(FG)
test pass: pair.f(getp).f(curry).f(F)==curry
test pass: t(getp)==T.f(getp)
test pass: T.f(getp).f(curry)==getp
cur=1 this=(T0)
cur=1 this=(T1)
cur=2 this=(S(T0))
cur=1 this=((S(T0))(T1))
S( [(T0), (T1)] ) returning ((S(T0))(T1))
cur=0 this=(01)
cbt01: (01)
cbt01__2: (01)
test pass
cur=1 this=(TP)
cur=1 this=(TC)
cur=2 this=(S(TP))
cur=1 this=((S(TP))(TG))
cur=2 this=(S((S(TP))(TG)))
cur=1 this=((S((S(TP))(TG)))(TC))
S( [(TP), (TG), (TC)] ) returning ((S((S(TP))(TG)))(TC))
SCurryA: ((S((S(TP))(TG)))(TC))
pair_getp_curry: ((PG)C)
test pass
cur=2 this=(S(TT))
cur=1 this=((S(TT))(TG))
cur=2 this=(S((S(TT))(TG)))
cur=1 this=((S((S(TT))(TG)))(TC))
S( [(TT), (TG), (TC)] ) returning ((S((S(TT))(TG)))(TC))
SCurryB: ((S((S(TT))(TG)))(TC))
test pass: f(S(t(T), t(getp), t(curry)),leaf)==getp
test pass: F.f(getp).f(curry)==getp
cur=2 this=(S(TF))
cur=1 this=((S(TF))(TG))
cur=2 this=(S((S(TF))(TG)))
cur=1 this=((S((S(TF))(TG)))(TC))
S( [(TF), (TG), (TC)] ) returning ((S((S(TF))(TG)))(TC))
test pass: f(S(t(F), t(getp), t(curry)),leaf)==curry
Starting testAnd
cur=0 this=(11)
cur=-1 this=((11)(11))
cur=-2 this=(((11)(11))((11)(11)))
cur=-3 this=((((11)(11))((11)(11)))(((11)(11))((11)(11))))
cur=-4 this=(((((11)(11))((11)(11)))(((11)(11))((11)(11))))((((11)(11))((11)(11)))(((11)(11))((11)(11)))))
cur=2 this=(ZC)
cur=1 this=((ZC)(((((11)(11))((11)(11)))(((11)(11))((11)(11))))((((11)(11))((11)(11)))(((11)(11))((11)(11))))))


---
newer run of TestBasics...

fn673: (..(..)(..(..))(..(..)(..)))
fn674: (..(..)(..(..))(..(..)(.(..))))
fn675: (..(..)(..(..))(..(..)(...)))
fn676: (..(..)(..(..))(..(..)(..(..))))
Occamsfuncer booted.
Starting testInfiniteLoopEndsCuzRunsOutOfGas
cur=2 this=(SI)
cur=1 this=(SII)
cur=2 this=(Z(SII))
cur=1 this=(Z(SII)(SII))
testInfiniteLoopEndsCuzRunsOutOfGas passed by ending early
Starting testSTLR
cur=2 this=(ST)
test pass: st.L()==S
test pass: st.R()==T
Starting testIdentityFuncs
cur=1 this=(STT)
test pass: leaf.L()==I
test pass: leaf.R()==leaf
cur=1 this=(TI)
test pass: stt.f(I)==I
cur=1 this=(TT)
test pass: stt.f(T)==T
cur=1 this=(TF)
test pass: stt.f(F)==F
test pass: I.f(stt)==stt
test pass: I.f(T)==T
Starting testSCurryList
cur=2 this=(PG)
cur=1 this=(PGC)
cur=1 this=(TG)
test pass: pair.f(getp).f(curry).f(T)==getp
cur=1 this=(FG)
test pass: pair.f(getp).f(curry).f(F)==curry
test pass: t(getp)==T.f(getp)
test pass: T.f(getp).f(curry)==getp
cur=1 this=(T0)
cur=1 this=(T1)
cur=2 this=(S(T0))
cur=1 this=(S(T0)(T1))
S( [(T0), (T1)] ) returning (S(T0)(T1))
cbtFuncBody of l=0 r=1
cur=1 this=(01)
cbt01: (01)
cbt01__2: (01)
test pass
cur=1 this=(TP)
cur=1 this=(TC)
cur=2 this=(S(TP))
cur=1 this=(S(TP)(TG))
cur=2 this=(S(S(TP)(TG)))
cur=1 this=(S(S(TP)(TG))(TC))
S( [(TP), (TG), (TC)] ) returning (S(S(TP)(TG))(TC))
SCurryA: (S(S(TP)(TG))(TC))
pair_getp_curry: (PGC)
test pass
cur=2 this=(S(TT))
cur=1 this=(S(TT)(TG))
cur=2 this=(S(S(TT)(TG)))
cur=1 this=(S(S(TT)(TG))(TC))
S( [(TT), (TG), (TC)] ) returning (S(S(TT)(TG))(TC))
SCurryB: (S(S(TT)(TG))(TC))
test pass: f(S(t(T), t(getp), t(curry)),leaf)==getp
test pass: F.f(getp).f(curry)==getp
cur=2 this=(S(TF))
cur=1 this=(S(TF)(TG))
cur=2 this=(S(S(TF)(TG)))
cur=1 this=(S(S(TF)(TG))(TC))
S( [(TF), (TG), (TC)] ) returning (S(S(TF)(TG))(TC))
test pass: f(S(t(F), t(getp), t(curry)),leaf)==curry
Starting testIsUnaryCbt
test pass: unary0
cbtFuncBody of l=1 r=1
cur=1 this=<unary1>
test pass: unary1
cbtFuncBody of l=<unary1> r=<unary1>
cur=1 this=<unary2>
test pass: unary2
cbtFuncBody of l=<unary2> r=<unary2>
cur=1 this=<unary3>
test pass: unary3
cbtFuncBody of l=<unary3> r=<unary3>
cur=1 this=<unary4>
test pass: unary4
cbtFuncBody of l=<unary4> r=<unary4>
cur=1 this=<unary5>
test pass: unary5
test pass
test pass
test pass
cbtFuncBody of l=1 r=0
cur=1 this=(10)
test pass
test pass
cbtFuncBody of l=1 r=<unary1>
cur=1 this=(1<unary1>)
test pass
test pass
test pass
Starting testGetp
cbtFuncBody of l=<unary5> r=<unary5>
cur=1 this=<unary6>
cur=5 this=(C<unary6>)
cur=4 this=(C<unary6>T)
cur=3 this=(C<unary6>TT)
x: (C<unary6>TT)
cur=2 this=(Z(C<unary6>TT))
cur=1 this=(Z(C<unary6>TT)0)
madeByCurryForConstraint: (Z(C<unary6>TT)0)
cur=2 this=(C<unary6>TT0)
y: (C<unary6>TT0)
cur=2 this=(Z(C<unary6>TT0))
cur=1 this=(Z(C<unary6>TT0)1)
madeByCurryForFuncBody: (Z(C<unary6>TT0)1)
test pass: constraintGetsSecondLastParam
test pass: funcBodyGetsLastParam
test pass: funcBodyGetsSecondLastParam
cur=2 this=(G.)
cur=1 this=(G.<unary4>)
test pass: constraint_getpunary4_is_cbt0
cur=1 this=(G.<unary5>)
test pass: constraint_getpunary5_is_leaf_cuzParamIndexDoesntExist
cur=1 this=(G.<unary6>)
test pass: constraint_getpunary6_is_leaf_cuzParamIndexDoesntExist
test pass: funcBody_getpunary4_is_cbt0
test pass: funcBody_getpunary5_is_cbt1
Starting testAnd
cur=4 this=(C<unary5>)
cur=3 this=(C<unary5>T)
cur=2 this=(S(G.<unary4>))
cur=1 this=(S(G.<unary4>)(G.<unary5>))
cur=2 this=(S(S(G.<unary4>)(G.<unary5>)))
cur=1 this=(S(S(G.<unary4>)(G.<unary5>))(TF))
S( [(G.<unary4>), (G.<unary5>), (TF)] ) returning (S(S(G.<unary4>)(G.<unary5>))(TF))
cur=2 this=(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))
and=(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))
cur=2 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))))
cur=1 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))F)
cur=1 this=(T(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))F))
cur=1 this=(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))F)
cur=2 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))F))
cur=1 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))F)F)
cur=1 this=(FF)
test pass: and_F_F
cur=1 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))F)T)
cur=1 this=(FT)
test pass: and_F_T
cur=1 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))T)
cur=1 this=(T(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF)))T))
cur=1 this=(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))T)
cur=2 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))T))
cur=1 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))T)F)
test pass: and_T_F
cur=1 this=(Z(C<unary5>T(S(S(G.<unary4>)(G.<unary5>))(TF))T)T)
test pass: and_T_T
Starting testString
s: abc
cbtFuncBody of l=(01) r=(10)
cur=1 this=(01(10))
cbtFuncBody of l=0 r=0
cur=1 this=(00)
cbtFuncBody of l=(00) r=(01)
cur=1 this=(00(01))
cbtFuncBody of l=(01(10)) r=(00(01))
cur=1 this=(01(10)(00(01)))
cbtFuncBody of l=(00) r=(10)
cur=1 this=(00(10))
cbtFuncBody of l=(01(10)) r=(00(10))
cur=1 this=(01(10)(00(10)))
cbtFuncBody of l=(01(10)(00(01))) r=(01(10)(00(10)))
cur=1 this=(01(10)(00(01))(01(10)(00(10))))
cbtFuncBody of l=(00) r=<unary1>
cur=1 this=(00<unary1>)
cbtFuncBody of l=(01(10)) r=(00<unary1>)
cur=1 this=(01(10)(00<unary1>))
cbtFuncBody of l=(10) r=(00)
cur=1 this=(10(00))
cbtFuncBody of l=(00) r=(00)
cur=1 this=(00(00))
cbtFuncBody of l=(10(00)) r=(00(00))
cur=1 this=(10(00)(00(00)))
cbtFuncBody of l=(01(10)(00<unary1>)) r=(10(00)(00(00)))
cur=1 this=(01(10)(00<unary1>)(10(00)(00(00))))
cbtFuncBody of l=(01(10)(00(01))(01(10)(00(10)))) r=(01(10)(00<unary1>)(10(00)(00(00))))
cur=1 this=(01(10)(00(01))(01(10)(00(10)))(01(10)(00<unary1>)(10(00)(00(00)))))
fnAbc: (01(10)(00(01))(01(10)(00(10)))(01(10)(00<unary1>)(10(00)(00(00)))))
s__2: abc
test pass
cbtFuncBody of l=(01(10)) r=<unary2>
cur=1 this=(01(10)<unary2>)
cbtFuncBody of l=(01(10)<unary2>) r=(01(10)(00<unary1>))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>)))
cbtFuncBody of l=(01(10)) r=(01(10))
cur=1 this=(01(10)(01(10)))
cbtFuncBody of l=<unary1> r=(10)
cur=1 this=(<unary1>(10))
cbtFuncBody of l=(01(10)) r=(<unary1>(10))
cur=1 this=(01(10)(<unary1>(10)))
cbtFuncBody of l=(01(10)(01(10))) r=(01(10)(<unary1>(10)))
cur=1 this=(01(10)(01(10))(01(10)(<unary1>(10))))
cbtFuncBody of l=(01(10)<unary2>(01(10)(00<unary1>))) r=(01(10)(01(10))(01(10)(<unary1>(10))))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10)))))
cbtFuncBody of l=(01) r=<unary1>
cur=1 this=(01<unary1>)
cbtFuncBody of l=(01<unary1>) r=(00(00))
cur=1 this=(01<unary1>(00(00)))
cbtFuncBody of l=<unary1> r=(00)
cur=1 this=(<unary1>(00))
cbtFuncBody of l=(01(10)) r=(<unary1>(00))
cur=1 this=(01(10)(<unary1>(00)))
cbtFuncBody of l=(01<unary1>(00(00))) r=(01(10)(<unary1>(00)))
cur=1 this=(01<unary1>(00(00))(01(10)(<unary1>(00))))
cbtFuncBody of l=(01) r=(01)
cur=1 this=(01(01))
cbtFuncBody of l=(01<unary1>) r=(01(01))
cur=1 this=(01<unary1>(01(01)))
cbtFuncBody of l=(01(10)) r=(01<unary1>)
cur=1 this=(01(10)(01<unary1>))
cbtFuncBody of l=(01<unary1>(01(01))) r=(01(10)(01<unary1>))
cur=1 this=(01<unary1>(01(01))(01(10)(01<unary1>)))
cbtFuncBody of l=(01<unary1>(00(00))(01(10)(<unary1>(00)))) r=(01<unary1>(01(01))(01(10)(01<unary1>)))
cur=1 this=(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))
cbtFuncBody of l=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))) r=(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>)))))
cbtFuncBody of l=(10) r=(10)
cur=1 this=(10(10))
cbtFuncBody of l=(00<unary1>) r=(10(10))
cur=1 this=(00<unary1>(10(10)))
cbtFuncBody of l=(10) r=(01)
cur=1 this=(10(01))
cbtFuncBody of l=(01(10)) r=(10(01))
cur=1 this=(01(10)(10(01)))
cbtFuncBody of l=(00<unary1>(10(10))) r=(01(10)(10(01)))
cur=1 this=(00<unary1>(10(10))(01(10)(10(01))))
cbtFuncBody of l=<unary1> r=(01)
cur=1 this=(<unary1>(01))
cbtFuncBody of l=(01(10)) r=(<unary1>(01))
cur=1 this=(01(10)(<unary1>(01)))
cbtFuncBody of l=(01(10)(<unary1>(01))) r=(01(10)(<unary1>(01)))
cur=1 this=(01(10)(<unary1>(01))(01(10)(<unary1>(01))))
cbtFuncBody of l=(00<unary1>(10(10))(01(10)(10(01)))) r=(01(10)(<unary1>(01))(01(10)(<unary1>(01))))
cur=1 this=(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01)))))
cbtFuncBody of l=(01) r=(00)
cur=1 this=(01(00))
cbtFuncBody of l=(01<unary1>) r=(01(00))
cur=1 this=(01<unary1>(01(00)))
cbtFuncBody of l=(01<unary1>(01(01))) r=(01<unary1>(01(00)))
cur=1 this=(01<unary1>(01(01))(01<unary1>(01(00))))
cbtFuncBody of l=(01<unary1>(01(01))(01<unary1>(01(00)))) r=(01(10)(00(01))(01(10)(00(10))))
cur=1 this=(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10)))))
cbtFuncBody of l=(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))) r=(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10)))))
cur=1 this=(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))
cbtFuncBody of l=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))) r=(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10)))))))
cbtFuncBody of l=(01(10)) r=(01(01))
cur=1 this=(01(10)(01(01)))
cbtFuncBody of l=(01(10)(<unary1>(00))) r=(01(10)(01(01)))
cur=1 this=(01(10)(<unary1>(00))(01(10)(01(01))))
cbtFuncBody of l=(01<unary1>) r=(10(00))
cur=1 this=(01<unary1>(10(00)))
cbtFuncBody of l=(01(10)(01(01))) r=(01<unary1>(10(00)))
cur=1 this=(01(10)(01(01))(01<unary1>(10(00))))
cbtFuncBody of l=(01(10)(<unary1>(00))(01(10)(01(01)))) r=(01(10)(01(01))(01<unary1>(10(00))))
cur=1 this=(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00)))))
cbtFuncBody of l=(01(10)(00<unary1>)) r=(01(10)(01(01)))
cur=1 this=(01(10)(00<unary1>)(01(10)(01(01))))
cbtFuncBody of l=(01<unary1>(00(00))) r=(01<unary1>(01(00)))
cur=1 this=(01<unary1>(00(00))(01<unary1>(01(00))))
cbtFuncBody of l=(01(10)(00<unary1>)(01(10)(01(01)))) r=(01<unary1>(00(00))(01<unary1>(01(00))))
cur=1 this=(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))
cbtFuncBody of l=(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))) r=(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))
cur=1 this=(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00))))))
cbtFuncBody of l=(01(10)(01<unary1>)) r=(01(10)(00(01)))
cur=1 this=(01(10)(01<unary1>)(01(10)(00(01))))
cbtFuncBody of l=(01<unary1>) r=(00<unary1>)
cur=1 this=(01<unary1>(00<unary1>))
cbtFuncBody of l=(00(10)) r=(<unary1>(10))
cur=1 this=(00(10)(<unary1>(10)))
cbtFuncBody of l=(01<unary1>(00<unary1>)) r=(00(10)(<unary1>(10)))
cur=1 this=(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))
cbtFuncBody of l=(01(10)(01<unary1>)(01(10)(00(01)))) r=(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))
cur=1 this=(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10)))))
cbtFuncBody of l=(01(10)(00<unary1>)) r=(01(10)(00(01)))
cur=1 this=(01(10)(00<unary1>)(01(10)(00(01))))
cbtFuncBody of l=(01(10)<unary2>(01(10)(00<unary1>))) r=(01(10)(00<unary1>)(01(10)(00(01))))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))
cbtFuncBody of l=(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))) r=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))
cur=1 this=(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01))))))
cbtFuncBody of l=(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))) r=(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01))))))
cur=1 this=(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))))
cbtFuncBody of l=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))) r=(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01))))))))
cbtFuncBody of l=(01(10)(<unary1>(01))) r=(01<unary1>(00<unary1>))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00<unary1>)))
cbtFuncBody of l=(01(10)(01(10))) r=(01<unary1>(01(01)))
cur=1 this=(01(10)(01(10))(01<unary1>(01(01))))
cbtFuncBody of l=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))) r=(01(10)(01(10))(01<unary1>(01(01))))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01)))))
cbtFuncBody of l=(01(10)(<unary1>(10))) r=(01(10)(00<unary1>))
cur=1 this=(01(10)(<unary1>(10))(01(10)(00<unary1>)))
cbtFuncBody of l=(01<unary1>) r=(00(10))
cur=1 this=(01<unary1>(00(10)))
cbtFuncBody of l=(01(10)(01(01))) r=(01<unary1>(00(10)))
cur=1 this=(01(10)(01(01))(01<unary1>(00(10))))
cbtFuncBody of l=(01(10)(<unary1>(10))(01(10)(00<unary1>))) r=(01(10)(01(01))(01<unary1>(00(10))))
cur=1 this=(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))
cbtFuncBody of l=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))) r=(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10))))))
cbtFuncBody of l=(01(00)) r=(01(01))
cur=1 this=(01(00)(01(01)))
cbtFuncBody of l=(00(10)(<unary1>(10))) r=(01(00)(01(01)))
cur=1 this=(00(10)(<unary1>(10))(01(00)(01(01))))
cbtFuncBody of l=(01<unary1>(10(00))) r=(01(10)(00(01)))
cur=1 this=(01<unary1>(10(00))(01(10)(00(01))))
cbtFuncBody of l=(00(10)(<unary1>(10))(01(00)(01(01)))) r=(01<unary1>(10(00))(01(10)(00(01))))
cur=1 this=(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01)))))
cbtFuncBody of l=(01(10)(<unary1>(01))) r=(01<unary1>(00(00)))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00(00))))
cbtFuncBody of l=(01(10)(<unary1>(01))(01<unary1>(00(00)))) r=(01(10)(<unary1>(00))(01(10)(01(01))))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01)))))
cbtFuncBody of l=(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))) r=(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01)))))
cur=1 this=(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))
cbtFuncBody of l=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))) r=(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01)))))))
cbtFuncBody of l=(00(10)(<unary1>(10))) r=(01(10)<unary2>)
cur=1 this=(00(10)(<unary1>(10))(01(10)<unary2>))
cbtFuncBody of l=(01(10)(00<unary1>)) r=(01(10)(01(10)))
cur=1 this=(01(10)(00<unary1>)(01(10)(01(10))))
cbtFuncBody of l=(00(10)(<unary1>(10))(01(10)<unary2>)) r=(01(10)(00<unary1>)(01(10)(01(10))))
cur=1 this=(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10)))))
cbtFuncBody of l=(01(10)(<unary1>(10))) r=(01<unary1>(00(00)))
cur=1 this=(01(10)(<unary1>(10))(01<unary1>(00(00))))
cbtFuncBody of l=(01(10)(<unary1>(00))) r=(01<unary1>(01(01)))
cur=1 this=(01(10)(<unary1>(00))(01<unary1>(01(01))))
cbtFuncBody of l=(01(10)(<unary1>(10))(01<unary1>(00(00)))) r=(01(10)(<unary1>(00))(01<unary1>(01(01))))
cur=1 this=(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))
cbtFuncBody of l=(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))) r=(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))
cur=1 this=(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01))))))
cbtFuncBody of l=(01(10)(01<unary1>)) r=(01(00)(01(01)))
cur=1 this=(01(10)(01<unary1>)(01(00)(01(01))))
cbtFuncBody of l=(01<unary1>) r=(00(01))
cur=1 this=(01<unary1>(00(01)))
cbtFuncBody of l=(01<unary1>(00(01))) r=(01<unary1>(00(01)))
cur=1 this=(01<unary1>(00(01))(01<unary1>(00(01))))
cbtFuncBody of l=(01(10)(01<unary1>)(01(00)(01(01)))) r=(01<unary1>(00(01))(01<unary1>(00(01))))
cur=1 this=(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01)))))
cbtFuncBody of l=(00(00)) r=(00(00))
cur=1 this=(00(00)(00(00)))
cbtFuncBody of l=(10(00)(00(00))) r=(00(00)(00(00)))
cur=1 this=(10(00)(00(00))(00(00)(00(00))))
cbtFuncBody of l=(00(00)(00(00))) r=(00(00)(00(00)))
cur=1 this=(00(00)(00(00))(00(00)(00(00))))
cbtFuncBody of l=(10(00)(00(00))(00(00)(00(00)))) r=(00(00)(00(00))(00(00)(00(00))))
cur=1 this=(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))
cbtFuncBody of l=(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))) r=(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))
cur=1 this=(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))
cbtFuncBody of l=(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))) r=(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))
cur=1 this=(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))))
cbtFuncBody of l=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))) r=(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))))
cur=1 this=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))))
cbtFuncBody of l=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))))) r=(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))))
cur=1 this=(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))))(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00)))))))))
cur=1 this=(Q(01(10)<unary2>(01(10)(00<unary1>))(01(10)(01(10))(01(10)(<unary1>(10))))(01<unary1>(00(00))(01(10)(<unary1>(00)))(01<unary1>(01(01))(01(10)(01<unary1>))))(00<unary1>(10(10))(01(10)(10(01)))(01(10)(<unary1>(01))(01(10)(<unary1>(01))))(01<unary1>(01(01))(01<unary1>(01(00)))(01(10)(00(01))(01(10)(00(10))))))(01(10)(<unary1>(00))(01(10)(01(01)))(01(10)(01(01))(01<unary1>(10(00))))(01(10)(00<unary1>)(01(10)(01(01)))(01<unary1>(00(00))(01<unary1>(01(00)))))(01(10)(01<unary1>)(01(10)(00(01)))(01<unary1>(00<unary1>)(00(10)(<unary1>(10))))(01(10)<unary2>(01(10)(00<unary1>))(01(10)(00<unary1>)(01(10)(00(01)))))))(01(10)(<unary1>(01))(01<unary1>(00<unary1>))(01(10)(01(10))(01<unary1>(01(01))))(01(10)(<unary1>(10))(01(10)(00<unary1>))(01(10)(01(01))(01<unary1>(00(10)))))(00(10)(<unary1>(10))(01(00)(01(01)))(01<unary1>(10(00))(01(10)(00(01))))(01(10)(<unary1>(01))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01(10)(01(01))))))(00(10)(<unary1>(10))(01(10)<unary2>)(01(10)(00<unary1>)(01(10)(01(10))))(01(10)(<unary1>(10))(01<unary1>(00(00)))(01(10)(<unary1>(00))(01<unary1>(01(01)))))(01(10)(01<unary1>)(01(00)(01(01)))(01<unary1>(00(01))(01<unary1>(00(01))))(10(00)(00(00))(00(00)(00(00)))(00(00)(00(00))(00(00)(00(00))))))))))
cur=1 this=(..)
Exception in thread "main" java.lang.Error: FIXME either the madeByCurry in Nondet.nondet(fn,fn) is broken or in ocfnplugEqq(fn) is broken.
	at immutableexceptgas.occamsfuncer.Nondet.nondet(Nondet.java:73)
	at immutableexceptgas.occamsfuncer.Boot.lambda$16(Boot.java:590)
	at immutableexceptgas.occamsfuncer.impl.fns.Call.f(Call.java:155)
	at immutableexceptgas.occamsfuncer.test.TestBasics.testOcfnplug(TestBasics.java:174)
	at immutableexceptgas.occamsfuncer.test.TestBasics.main(TestBasics.java:336)
	at start.Start.main(Start.java:10)
