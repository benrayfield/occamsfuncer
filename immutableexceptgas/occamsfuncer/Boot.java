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
