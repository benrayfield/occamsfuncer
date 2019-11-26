/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.impl.util;
import static immutableexceptgas.occamsfuncer.impl.util.Gas.*;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncer.fn;
import immutableexceptgas.occamsfuncer.impl.fns.Call;
import immutableexceptgas.occamsfuncer.impl.fns.Leaf;

public class Boot{
	
	/** in order of height recursively (TODO verify) */
	public static List<fn> upToDepthN(int n){
		fn leaf = Leaf.instance;
		Set<fn> nodesSet = Collections.newSetFromMap(new IdentityHashMap()); 
		List<fn> nodesList = new ArrayList();
		//Map<String,String> display = new HashMap();
		Map<fn,Integer> height = new IdentityHashMap();
		for(int i=0; i<=n; i++){
			if(i==0){ 
				nodesSet.add(leaf);
				nodesList.add(leaf);
				//display.put(leaf, "0");
				//display.put(leaf, "0.");
				height.put(leaf,0);
				//lg(display.get(leaf)+" <0>");
			}else{
				int j=0;
				fn[] nodesArray = nodesList.toArray(new fn[0]);
				for(fn nodeX : nodesArray){
					for(fn nodeY : nodesArray){
						//String newPair = pair(nodeX,nodeY);
						fn newPair = cp(nodeX,nodeY);
						int h = Math.max(height.get(nodeX),height.get(nodeY))+1;
						//String disp = h+"`"+display.get(nodeX)+display.get(nodeY);
						//String disp = h+display.get(nodeX)+display.get(nodeY);
						//String disp = h+"("+display.get(nodeX)+","+display.get(nodeY)+")";
						if(!nodesSet.contains(newPair)){
							nodesSet.add(newPair);
							nodesList.add(newPair);
							height.put(newPair, h);
							//display.put(newPair, disp);
							//lg(disp+" <"+(j++)+">");
						}else{
							//lg(disp+" <dup>");
						}
					}
				}
			}
			lg("Level"+i+" has "+nodesList.size()+" binary forest shapes.");
		}
		return Collections.unmodifiableList(nodesList);
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
				tempNames.put(ops[j], ""+e[j].abbrev);
			}
		}
		return ops[i];
	}
	
	/** Use Gas.infLoop() instead.
	will not actually infloop but this means avoid running out of
	compute resources by ending whatever you're doing, same as would
	happen if there were any actual infinite loop such as (s s s s) [FIXME thats not actually an infinite loop]
	except this doesnt consume those resources.
	*
	private static void infLoop(){
		throw Gas.instance;
	}*/
	
	private static boolean booted;
	
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
	
	/** Slow. Returns 0 if (.(..)) or 1 if ((..).), else -1 if its not part of an Op */
	public static int bootOpChildIndexAtHeight2(fn f){
		//Theres 1 fn at height0 and 1 fn at height1 and 3 fn at height2
		int ret;
		if(f.height() != 2){
			return -1;
		}else if(f.L().height()==0){
			ret = 0; //f is (.(..))
		}else{ //f.L().height()==1
			if(f.R().height()==0) ret = 1; //f is ((..).)
			else ret = -1; //f is ((..)(..))
		}
		lg("bootOpChildIndexAtHeight2 of "+f+" is "+ret);
		return ret;
	}
	
	/** Slow. Returns 0..3, else -1 if its not part of an Op */
	public static int bootOpChildIndexAtHeight3(fn f){
		int ret;
		if(f.height() != 3){
			return -1;
		}
		int l = bootOpChildIndexAtHeight2(f.L());
		int r = bootOpChildIndexAtHeight2(f.R());
		ret = l == -1 || r == -1 ? -1 : l*2+r;
		lg("bootOpChildIndexAtHeight3 of "+f+" is "+ret);
		return ret;
	}
	
	/** Slow. Returns 0..15, else -1 if its not part of an Op */
	public static int bootOpIndexAtHeight4(fn f){
		int ret;
		if(f.height() != 4){
			return -1;
		}
		int l = bootOpChildIndexAtHeight3(f.L());
		int r = bootOpChildIndexAtHeight3(f.R());
		ret = l == -1 || r == -1 ? -1 : l*4+r;
		lg("bootOpIndexAtHeight4 of "+f+" is "+ret);
		return ret;
	}
	
	/** Slow. Returns what Call.cur (number of remaining curries)
	should be during Call constructor for any fn of height()<5. This only
	happens once per each of those 677 funcs cuz after that they are reused.
	*/
	public static int bootCur(fn f){
		//FIXME if f is a cbt (but maybe cant use fn.isCbt() cuz this is before
		//Call constructor finishes.
		int o = bootOpIndexAtHeight4(f);
		if(o == -1) return 1;
		return Op.atIndex(o).cur;
		/*
		if(f.height()>4) throw new Error("This is only for booting height0..4");
		if(f.height()!=4) return 1;
		return bootIsHeight3ChildOfOp(f.L());
		TODO
		*/
	}
	
	public static boolean bootIsCbt(fn f){
		int height = f.height();
		if(height < 4) return false;
		if(height != 4) throw new Error("height is too big to be part of boot: "+height);
		int o = bootOpIndexAtHeight4(f);
		return o == Op.cbt0.ordinal() || o == Op.cbt1.ordinal();
	}
	
	/** these names dont affect id, for any possible id generator */
	public static Map<fn,String> tempNames = new HashMap();

}
