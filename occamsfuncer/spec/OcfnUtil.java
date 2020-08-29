/** Ben F Rayfield offers this software opensource MIT license */
package occamsfuncer.spec;
import occamsfuncer.fn;
import static occamsfuncer.spec.Log.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OcfnUtil{
	
	//FIXME some of this code was copied from ocfn3r or ocfn3s etc. Modify it for ocfn3v.
	
	private static final Map<fn,fn> dedup = new HashMap();
	
	public static fn dedup(fn n){
		fn ret = dedup.get(n);
		if(ret == null) dedup.put(ret=n, n);
		return ret;
	}
	
	/** the universal function aka leaf. All possible functions can be built by calling this on itself in various combos,
	but you probably want to also wrap arrays such as double[] int[] FloatBuffer for efficiency,
	which mean a complete binary tree of pairs of T and F padded with T and 0 or more Fs until the next powOf2 number of bits,
	as a way to represent a bitstring. Wrapped objects must still have usable L(), R(), and lambda functions,
	plus in some cases they can be used in combo with other optimizations directly as arrays.
	Wrapped objects normally use lazy dedup, but if you get an id on them (from any idMaker func) everything dedups exactly,
	such as happens when used as a map key.
	*/
	public static final fn u = node(true, false, null, null, null, null);
	
	/** never null */
	public static fn L(fn n){
		//FIXME verify this doesnt get called before identityFunc is set.
		return n.isLeaf() ? I : n.func();
	}
	
	/** never null */
	public static fn R(fn n){
		return n.isLeaf() ? n : n.param();
	}
	
	/** returns a deduped node */
	public static fn node(boolean isHalted, boolean isParentsFunc, fn func, fn param, fn stack, fn cacheKey){
		int hash = hash(isHalted, isParentsFunc, stack, func, param, cacheKey);
		fn ret = node(hash, isHalted, isParentsFunc, func, param, stack, cacheKey);
		return ret;
	}
	
	/** returns a deduped node */
	protected static fn node(int hash, boolean isHalted, boolean isParentsFunc, fn func, fn param, fn stack, fn cacheKey){
		return dedup(new Node(hash, isHalted, isParentsFunc, func, param, stack, cacheKey));
	}
	
	protected static int hash(boolean isHalted, boolean isParentsFunc, fn func, fn param, fn stack, fn cacheKey){
		//TODO spread the second params of identHashElse better.
		return identHashElse(func,103)*1292567 + identHashElse(param,103)*49999
			+ identHashElse(stack,5651) + identHashElse(cacheKey,619)
			+ (isHalted?2:0) + (isParentsFunc?1:0);
	}
	
	protected static int identHashElse(fn n, int elseThis){
		return n==null ? elseThis : System.identityHashCode(n);
	}
	
	public static fn lazyCall(fn func, fn param){
		return lazyCall(func, param, null);
	}
	
	public static fn lazyCall(fn func, fn param, fn cacheKey){
		if(!canCall(func,param)) throw new Error("Cant call ("+func+" "+param+")");
		fn stack = null;
		fn l = L(func);
		fn ll = L(l);
		fn lll = L(ll);
		fn llll = L(lll);
		fn lllll = L(llll);
		fn llllll = L(lllll);
		fn lllllll = L(llllll);
		fn llllllll = L(lllllll);
		fn lllllllll = L(llllllll);
		fn llllllllll = L(lllllllll);
		fn lllllllllll = L(llllllllll);
		fn llllllllllll = L(lllllllllll);
		fn lllllllllllll = L(llllllllllll);
		boolean isHalted = func.isHaltedAbove() & param.isHaltedAbove() & (
			func.isLeaf()
			| l.isLeaf()
			| ll.isLeaf()
			| lll.isLeaf()
			| llll.isLeaf()
			| lllll.isLeaf()
			| llllll.isLeaf()
			| lllllll.isLeaf()
			| llllllll.isLeaf()
			| lllllllll.isLeaf()
			| llllllllll.isLeaf()
			| lllllllllll.isLeaf()
			| llllllllllll.isLeaf()
			| lllllllllllll.isLeaf()
		);
		boolean isParentsFunc = false; //cuz stack is null
		return node(isHalted, isParentsFunc, func, param, stack, cacheKey);
	}
	
	/** in the (pair allCurriesExceptLast lastParam) that bigCall creates and calls funcBody on,
	that funcBody can call whats returned by this to get a param. Params range 1 to 15. Param 0 is the universalFunc/leaf.
	funcBody is itself a param, since you get all 15 params of the universalFunc,
	but which param it is, or if it contains a funcBody vs use directly,
	depends on which of the 16 opcodes chosen by the first 4 params.
	*/
	public static fn p(int paramIndex){ return p[paramIndex]; }
	
	/** halted callPair without evaling or lazyEvaling, like in ocfn2's cp func */
	protected static fn cp(fn func, fn param){
		return node(true, false, func, param, null, null);
	}
	
	public static final boolean cacheFuncParamReturn = true;
	
	/** lazy call *
	public static Node f(Node func, Node param){
		return lazyCall(func, param, null);
	}
	
	/** call and eval *
	public static Node e(Node func, Node param){
		return e(f(func,param));
	}*/

	/** WARNING: may never halt. isDeterministic. */
	public static fn eval(fn n){
		return eval(n,true);
	}
	
	/** WARNING: may never halt */
	public static fn eval(fn n, boolean isDeterministic){
		fn start = n;
		if(lgEval) lg("start eval: "+n);
		while(!n.isDone()){
			n = step(n);
		}
		//FIXME should isDone include cacheKey==null? Or should cacheKey only be removed here?
		//Should null cacheKey mean cacheKey is self's func param
		n = setCacheKey(n, null);
		if(lgEval) lg("end eval: "+n+" --- is eval of: "+start);
		return n;
	}
	
	/** Always halts (but in practice may run out of memory, TODO have memory and compute limits separately?
	In the prototype (other than formalverify) they will be merged). Whats returned may be stackBottom or not,
	depending if it needed more than the steps allowed.
	*/
	public static fn eval(fn n, boolean isDeterministic, long maxSteps){
		while(maxSteps-- > 0 & !n.isDone()) n = step(n, isDeterministic);
		return n;
	}
	
	public static fn evalOrThrow(fn n, boolean isDeterministic, long maxSteps){
		fn ret = eval(n, isDeterministic, maxSteps);
		if(!isStackBottom(ret)) throw new RuntimeException("Needed more steps");
		return ret;
	}
	
	/** a lazy call pair at bottom of stack.
	WARNING: safe only if you first check canCall on each pair.
	*/
	public static fn f(fn... curryList){
		//FIXME is this the right place to call asStackTop?
		if(curryList[0]==null) throw new NullPointerException();
		if(curryList.length == 0) return I;
		fn ret = curryList[0];
		for(int i=1; i<curryList.length; i++) ret = lazyCall(ret,curryList[i]); //FIXME cacheKey is null here. Is that right?
		return ret;
	}
	
	public static fn f(Object... curryList){
		return f(obsToNodes(curryList));
	}
	
	/** eval of (func param). WARNING: may never halt */
	public static fn e(fn func, fn param){
		return eval(lazyCall(func,param));
	}
	
	/** eval of calls. WARNING: may never halt */
	public static fn e(fn... curryList){
		return eval(f(curryList));
	}
	
	public static fn e(Object... curryList){
		return e(obsToNodes(curryList));
	}
	
	public static fn[] obsToNodes(Object... obs){
		fn[] ret = new fn[obs.length];
		for(int i=0; i<obs.length; i++){
			ret[i] = w(obs[i]);
		}
		return ret;
	}
	
	/** isDeterministic */
	public static fn step(fn evalingState){
		return step(evalingState,true);
	}
	
	public static long countSteps_todoRemoveThisVar;
	
	/** See occamsfuncerSpec.txt for the 16 opcodes. As of 2020-8-17 I'm still making small adjustments to them but will finalize the spec soon.
	*/
	public static fn step(fn evalingState, boolean isDeterministic){
		countSteps_todoRemoveThisVar++;
		if(lgStep) lg("start step: "+evalingState);
		fn ret = null;
		fn allCurriesExceptLast = L(evalingState), lastParam = R(evalingState);
		if(evalingState.isHaltedAbove()){
			//Usually a nonleaf, but if n isLeaf, it will be here, even though leaf.func is identityFunc and leaf.param is leaf.
			if(isStackBottom(evalingState)){
				
				
				
				
				
				
				if(evalingState.cacheKey() != null){
					fn val = evalingState;
					//fn val = truncateToStackBottom(evalingState);
					if(lgStep) lg("Write cache (end), key="+evalingState.cacheKey());
					if(lgStep) lg("Write cache (end), val="+val);
					CacheFuncParamReturn.put(evalingState.cacheKey(), val);
					//ret = val;
				}//else{
				//	ret = evalingState;
				//}
				ret = evalingState;
				
				
				//FIXME
				
			}else{ //return down the stack. This is either L/func or R/param child of its parent (1 lower on stack).
				if(evalingState.cacheKey() != null){
					fn val = truncateToStackBottom(evalingState);
					if(lgStep) lg("Write cache (mid), key="+evalingState.cacheKey());
					if(lgStep) lg("Write cache (mid), val="+val);
					CacheFuncParamReturn.put(evalingState.cacheKey(), val);
				}
				if(evalingState.isParentsFunc()){
					boolean isHalted = false;
					boolean isParentsFunc = evalingState.stack().isParentsFunc();
					//boolean isTruncating = TODO;
					fn func = truncateToStackBottom(evalingState);
					fn param = evalingState.stack().param();
					fn stack = evalingState.stack().stack();
					fn cacheKey = evalingState.stack().cacheKey();
					ret = node(isHalted, isParentsFunc, func, param, stack, cacheKey);
				}else{ //n.isParentsParam
					boolean isHalted = false;
					boolean isParentsFunc = evalingState.stack().isParentsFunc();
					//boolean isTruncating = TODO;
					fn func = evalingState.stack().func();
					fn param = truncateToStackBottom(evalingState);
					fn stack = evalingState.stack().stack();
					fn cacheKey = evalingState.stack().cacheKey();
					ret = node(isHalted, isParentsFunc, func, param, stack, cacheKey);
				}
			}
		}else if(!allCurriesExceptLast.isHaltedAbove()){ //recurse into L(n)
			boolean isHalted = false;
			boolean isParentsFunc = true;
			fn func = allCurriesExceptLast.func();
			fn param = allCurriesExceptLast.param();
			fn stack = evalingState;
			fn cacheKey = allCurriesExceptLast.cacheKey(); //FIXME should this be null?
			ret = node(isHalted, isParentsFunc, func, param, stack, cacheKey);
		}else if(!lastParam.isHaltedAbove()){ //recurse into R(n)
			boolean isHalted = false;
			boolean isParentsFunc = false;
			fn func = lastParam.func();
			fn param = lastParam.param();
			fn stack = evalingState;
			fn cacheKey = lastParam.cacheKey(); //FIXME should this be null?
			ret = node(isHalted, isParentsFunc, func, param, stack, cacheKey);
		}else{ //do the main logic here instead of recursing into func, param, or going up stack
			
			if(cacheFuncParamReturn){
				//About to eval (haltedX haltedY) which itself is not halted, but first check <func,param,return> cache
				//with the normed form as if its a stackBottom.
				fn truncateToStackBottom = truncateToStackBottom(evalingState);
				fn cachedEval = CacheFuncParamReturn.get(truncateToStackBottom);
				if(cachedEval != null){
					if(lgStep) lg("Returning from cache. Before restack: "+cachedEval);
					//error: ret = setStack(cachedEval, evalingState.cacheKey(), evalingState.isParentsFunc());
					error: ret = setStack(cachedEval, evalingState.stack(), evalingState.isParentsFunc());
					if(lgStep) lg("Returning from cache: "+ret);
					return ret; //FIXME move the code below the IF into ELSE so ret isnt returned until end of func.
				}

				//TODO update this comment, was written for a different universalFunc:
				//Must also put in CacheFuncParamReturn after it returns.
				//Thats just an optimization, but without it, it would take years to multiply 2 longs, something that normally takes 10 nanoseconds.
				//With that optimization, its BigO is the same as a RandomAccessMachine,
				//still a big constant cost, but with other optimizations I expect it to be competitive in the real world
				//as a number crunching software using GPU grids and just barely fast enough for CPU-like uses cuz of unusual caching needs.
				//throw new Error("FIXME must also put in CacheFuncParamReturn after it returns (use Node.cacheKey, so not every time something return, such as not in the ((xz)(yz)) steps (which can recurse endlessly) of (S x y z) but right after (whatXZReturns whatYZReturns) returns, map cacheKey to that, for example.");
			}
			
			//In practical implementations, a node will know most of this stuff cached recursively from its L,
			//such as which of 16 ops it is, number of curries left before eval, and a pointer to its funcBody if its a bigCall,
			//so it wont have to read all 15 params here.
			fn list = evalingState;
			fn p = R(list);
			list = L(list);
			fn o = R(list);
			list = L(list);
			fn n = R(list);
			list = L(list);
			fn m = R(list);
			list = L(list);
			fn l = R(list);
			list = L(list);
			fn k = R(list);
			list = L(list);
			fn j = R(list);
			list = L(list);
			fn i = R(list);
			list = L(list);
			fn h = R(list);
			list = L(list);
			fn g = R(list);
			list = L(list);
			fn f = R(list);
			list = L(list);
			fn e = R(list);
			list = L(list);
			fn d = R(list);
			list = L(list);
			fn c = R(list);
			list = L(list);
			fn b = R(list);
			fn maybeLeaf = L(list);
			if(!maybeLeaf.isLeaf()){
				//Example: (..)
				//Nothing to do except mark that theres nothing to do so caller knows to do the next thing.
				ret = setIsHalted(evalingState, true);
			}else{
				
				if(evalingState.cacheKey() == null){
					//FIXME I dont know if this is the right cacheKey logic
					evalingState = setCacheKey(evalingState, truncateToStackBottom(evalingState));
					if(lgStep) lg("After setCacheKey: "+evalingState);
				}

				
				//The main logic of the 15 param universalFunc
				
				int fourBitOpcode = ((c==u)?0:8)|((d==u)?0:4)|((e==u)?0:2)|((f==u)?0:1);
				fourBitOpcode &= 0xf; //has no effect on logic but might help JVM optimize the switch
				switch(fourBitOpcode){
				case 0: //op0 (u u u u u f g h i j k l m n o p) -> infiniteLoop (such as (S I I (S I I)) in strictMode, else (VM_nondet (pair (u u u u u f g h i j k l m n o) p)) as a way to request things from the occamsfuncer VM. //nondet
					if(isDeterministic){
						ret = lazyInfiniteLoop;
					}else{
						//ret = Nondet.call(lastParam); //ignore all params except last
						ret = Nondet.call(P.f(allCurriesExceptLast).f(lastParam)); //can do it either way with this, can still get lastParam out of it.
					}
				case 1: //op1  (u u u u u ^ g h i j k l m n o p) -> (n (pair (u u u u u ^ g h i j k l m n o) p)) //bigCall1, (p)<br>
					//In practical implementations, will create the pair call already halted since we know it halts, using cp func like in ocfn2.
					ret = n.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 2: //op2  (u u u u ^ u g h i j k l m n o p) -> (m (pair (u u u u ^ u g h i j k l m n o) p)) //bigCall2, (o p)<br>
					ret = m.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 3: //op3  (u u u u ^ ^ g h i j k l m n o p) -> (l (pair (u u u u ^ ^ g h i j k l m n o) p)) //bigCall3, (n o p), aka (... k/comment l/funcBody m/context n o p)<br>
					ret = l.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 4: //op4  (u u u ^ u u g h i j k l m n o p) -> (k (pair (u u u ^ u u g h i j k l m n o) p)) //bigCall4, a lambda of 4 params (m n o p) where the k/funcBody param can get those params<br>
					ret = k.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 5: //op5  (u u u ^ u ^ g h i j k l m n o p) -> (j (pair (u u u ^ u ^ g h i j k l m n o) p)) //bigCall5, a lambda of 5 params (l m n o p) where the j/funcBody param can get those params<br>
					ret = j.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 6: //op6  (u u u ^ ^ u g h i j k l m n o p) -> (i (pair (u u u ^ ^ u g h i j k l m n o) p)) //bigCall6, (k l m n o p), aka (... h/comment i/funcBody j/context k l m n o p)<br>
					ret = i.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 7: //op7  (u u u ^ ^ ^ g h i j k l m n o p) -> (h (pair (u u u ^ ^ ^ g h i j k l m n o) p)) //bigCall7, (j k l m n o p)<br>
					ret = h.f(P.f(allCurriesExceptLast).f(lastParam));
				break; case 8: //op8  (u u ^ u u u g h i j k l m n o p) -> o //T, the K in SKI Lambda Calculus
					ret = o;
				break; case 9: //op9  (u u ^ u u ^ g h i j k l m n o p) -> p //FI, does False and IdentityFunc depending on number of curries
					ret = p;
				break; case 10: //op10 (u u ^ u ^ u g h i j k l m n o p) -> (VM_L p) //L, get left child, its func, where (L x (R x)) equals x for all possible x
					ret = L(p);
				break; case 11: //op11 (u u ^ u ^ ^ g h i j k l m n o p) -> (VM_R p) //R, get right child, its param, where (L x (R x)) equals x for all possible x
					ret = R(p);
				break; case 12: //op12 (u u ^ ^ u u g h i j k l m n o p) -> (VM_IsLeaf p) aka [T if p is u, else F] //IsLeaf
					ret = (p==u)?T:F;
				break; case 13: //op13 (u u ^ ^ u ^ g h i j k l m n o p) -> (n p (o p)) //S, as in SKI Lambda Calculus
					ret = n.f(p).f(o.f(p));
				break; case 14: //op14 (u u ^ ^ ^ u g h i j k l m n o p) -> (p n o) //Pair, such as (Pair n o) is halted and (Pair n o T)->n and (Pair n o F)->o
					ret = p.f(n).f(o);
				break; case 15: //op15 (u u ^ ^ ^ ^ g h i j k l m n o p) -> infiniteLoop (such as (S I I (S I I)) //Typeval, a semantic such as for type/n is "image/jpeg" and val/o is bitstring of that image, ignoring p. Any objects, not just strings and bitstrings.
					ret = lazyInfiniteLoop;
				}
			}
			if(!ret.isHaltedAbove() && L(ret).isHaltedAbove() && R(ret).isHaltedAbove()){
				ret = setCacheKey(ret, truncateToStackBottom(ret));
			}
			if(evalingState.stack() != null){
				ret = node(ret.isHaltedAbove(), evalingState.isParentsFunc(),
					ret.func(), ret.param(), evalingState.stack(), evalingState.cacheKey()); //put back into stack 
			}
		}
		if(lgStep) lg("step returning "+ret);
		testForSimpleErrorsInAnyNodeInVM(ret);
		return ret;
	}
	
	/** throws if find simple errors in not doing what the math of the universal func says.
	This is only used for finding bugs in the occamsfuncer VM.
	*/
	public static void testForSimpleErrorsInAnyNodeInVM(fn n){
		if((n.func()==null) != (n.param()==null)) throw new Error(
			"func and param must both be null (replace them in L(Node) and R(Node)) or both nonnull. "+n);
		if(n.cacheKey() != null) testForSimpleErrorsInCacheKeyInVM(n.cacheKey());
	}
	
	/** throws if find simple errors in not doing what the math of the universal func says.
	This is only used for finding bugs in the occamsfuncer VM.
	*/
	public static void testForSimpleErrorsInCacheKeyInVM(fn cacheKey){
		if(cacheKey.isHaltedAbove()) throw new Error("isHaltedAbove "+cacheKey);
		if(!cacheKey.func().isHaltedAbove()) throw new Error("!cacheKey.func().isHaltedAbove() "+cacheKey);
		if(!cacheKey.param().isHaltedAbove()) throw new Error("!cacheKey.param().isHaltedAbove() "+cacheKey);
		if(cacheKey.stack() != null) throw new Error("cacheKey.stack() != null, "+cacheKey);
		//FIXME check cacheKey.cacheKey or not? Is that allowed to be nonnull here? If so, it would have to at least be just the func and param
		if(cacheKey.cacheKey() != null) throw new Error("cacheKey.cacheKey() != null, "+cacheKey);
	}
	
	
	/*FIXME ocfn3vReservesFirstParamForAnyKindsOfStatelessNamespace_leafIsTheUniversalFunc_TAndFAndLeafleafAreReservedForGamewebBloomFilter_theRestCan
	This is a generalization of ocfn3vReservesFirstParamForFutureExpansionOfBloomFilterSoBigcallHas1-7NormalParams.
	(. . <params>) is universalFunc.
	(. T <params>) is statements claimed to be true, so in bloomFilter if claimed to be true and false, thats MADNODE.
	(. F <params>) is statements claimed to be false, so in bloomFilter if claimed to be true and false, thats MADNODE.
		Maybe ids will just differ by 1 or 2 bits somehow for things inside T or F, or maybe thats not the best place to put a bloomfilter.
	(. (..) <params>) general bloomfilter if I dont want to start it with T or F.
	(. "yourpublickey or website or name of your algorithm etc" <params>) anything else, as long as its stateless.
		Stateless means that the same (func param) call either gives the same return value every time or does not return (yet?).
	...
	FIXME ocfn3vReservesFirstParamForFutureExpansionOfBloomFilterSoBigcallHas1-7NormalParams
	If this node is leaf and param is nonleaf (or just (..)) then return lazyInfiniteLoop,
	so in this implementation (the spec), the bloom filter area is closed and reserved for future expansion.
	*/
	
	//TODO optimize, avoid caching things that return themself due to having less than 10 (update: 15) params, like:
	//Write cache (mid), key=L
	//Write cache (mid), val=L
	//Probably did this by moving "n = setCacheKey(n, truncateToStackBottom(n));" into !isHalted. TODO verify.
	
	//TODO optimize: Can this.cacheKey==null&L(this).isHalted&R(this).isHalted
	//be used to mean cache key (not the field) is (this.func this.param)? 
	
	
	
	/** This is part of the VM and shouldnt be called by user level code. Its public so the VM can be tested.
	Same as f(Node...) except doesnt call anything and marks them all as halted at boot time */
	public static fn bootF(fn... curryList){
		if(curryList.length < 2) throw new Error("Must call at least 2 fns: "+curryList.length);
		if(curryList.length == 2){
			for(int i=0; i<2; i++){
				fn c = curryList[i];
				//moved to NondetNode if(!c.isDeterministic) throw new Error("Boot func must be deterministic: "+c);
				//if(!c.isFinite) throw new Error("Boot func must be finite: "+c);
				if(c.stack() != null | c.isParentsFunc()) throw new Error("Boot func cant have stack (and therefore cant have isParentsFunc): "+c);
				if(c.cacheKey() != null) throw new Error("Boot func cant have cacheKey: "+c);
			}
			//boolean isUnary = bootIsT(curryList[0]) & curryList[1].isUnary;
			return node(true, false, curryList[0], curryList[1], null, null);
		}else{
			fn ret = curryList[0];
			for(int i=1; i<curryList.length; i++) ret = bootF(ret,curryList[i]);
			return ret;
		}
	}
	
	/** Same as n==T except this works before T is defined.
	T is bootF(u,u,bootF(u,u),u,u,u, u,u,u,u,u,u,u,u) aka op(8) then 8 u's, so 2 params until eval.
	FIXME include param 0 which is always u?
	*/
	public static boolean bootIsT(fn n){
		return bootIsBits(n,false,true,false,false,false, false,false,false,false,false,false,false,false);
	}
	
	/** In the bits param, u is false, and uu is true, but uu is not bootF(u,u) cuz cant call bootF yet.
	This is not the normal T and F. This is bits as isLeaf vs !isLeaf used at a lower level.
	T is bootF(u,u,bootF(u,u),u,u,u, u,u,u,u,u,u,u,u) aka op(8) then 8 u's, so 2 params until eval.
	*/
	public static boolean bootIsBits(fn n, boolean... params){
		if(!n.isDone()) return false;
		int maxParamsAllowed = 14;
		if(params.length > maxParamsAllowed) throw new Error("VM is broken or someone called bootF (a trusted dangerous function) deeper than "+maxParamsAllowed+" curries");
		int cur = curriesOfHalted(n);
		if(cur != params.length) return false;
		for(int paramIndex = params.length-1; paramIndex>=0; paramIndex--){
			if(params[paramIndex]){ //asking if param is (uu)
				if(!bootIsLeafLeaf(n.param())) return false;
			}else{ //asking if param is u
				if(n.param() != u) return false;
			}
			n = n.func();
		}
		return true;
	}
	
	/** returns 0 to 14. Throws if not halted */
	public static int curriesOfHalted(fn n){
		if(!n.isHaltedAbove()) throw new Error("Not halted");
		for(int i=0; i<15; i++){ //FIXME should this be <14?
			if(n == u) return i;
			n = n.func();
		}
		throw new Error("Halted node has more than 14 params so VM is broken");
	}
	
	public static boolean bootIsLeafLeaf(fn n){
		if(!n.isDone()) return false;
		if(n == u) return false; //u.func==null & u.param==null, but every other func and param is nonnull
		if(n.func()==u & n.param()==u) return true;
		return false;
	}
	
	public static boolean isStackBottom(fn n){
		return n.stack()==null;
	}
	
	public static fn truncateToStackBottom(fn n){
		return node(n.isHaltedAbove(), false, n.func(), n.param(), null, null);
	}
	
	/** For all x and y, canCall(downToStackBottom(x),downToStackBottom(y))==true. They dont have to be halted. */
	public static boolean canCall(fn x, fn y){
		return isStackBottom(x) && isStackBottom(y);
	}
	
	public static fn op(int fourBitOpcode){
		return bootF(u, u, ((fourBitOpcode&8)==0)?u:uu, ((fourBitOpcode&4)==0)?u:uu, ((fourBitOpcode&2)==0)?u:uu, ((fourBitOpcode&1)==0)?u:uu);
	}
	
	/** 1-7 params, not including comment and context */
	public static fn lambda(int numParams, fn funcBody){
		return lambda(numParams, defaultComment, funcBody, defaultContext);
	}
	
	/** 1-7 params, not including comment and context */
	public static fn lambda(int numParams, fn comment, fn funcBody){
		return lambda(numParams, comment, funcBody, defaultContext);
	}
	
	/** 1-7 params, not including comment and context */
	public static fn lambda(int numParams, fn comment, fn funcBody, fn context){
		if(numParams < 1 || numParams > 7) throw new Error(
			"The universalFunc has 16 opcodes. 7 of those are a lambda call with 1-7 params (not counting comment and context)."
			+" If you want more, use that to create a func that adds to a linkedlist in a recursive call of itself else evals"
			+" depending if the linkedlist is big enough. numParams="+numParams);
		fn ret = op(numParams); //5 params. first is ignored for future expansion. next 4 are leafbits (leaf vs nonleaf) to choose 1 of 16 opcodes.
		int pad = 7-numParams; //Fill in leaf/u's until... comment funcBody context <...params...> but return it before those 1-7 params.
		for(int i=0; i<pad; i++) ret = ret.e(u);
		return ret.e(defaultComment).e(funcBody).e(defaultContext);
	}
	
	/** (T param) */
	public static final fn t(fn param){
		//FIXME is this the right place to call asStackTop?
		return f(T,param);
	}
	
	/** (T (T param)) */
	public static fn tt(fn param){
		return t(t(param));
	}
	
	/** (T (T (T param))) */
	public static fn ttt(fn param){
		return t(tt(param));
	}
	
	/** (T (T (T (T param)))) */
	public static fn tttt(fn param){
		return tt(tt(param));
	}
	
	public static fn S(Object... list){
		return S(obsToNodes(list));
	}
	
	/** returns an S-curry-list of those, like in ocfn2 */
	public static fn S(fn... list){
		//FIXME is this the right place to call asStackTop?
		if(list.length == 0) return I;
		fn x = list[0];
		for(int i=1; i<list.length; i++){
			x = f(S,x,list[i]);
		}
		return x;
	}
	
	/** ST(a b c d) equals S(t(a) b c d), for any size list */
	public static fn ST(fn... list){
		//FIXME is this the right place to call asStackTop?
		if(list.length == 0) return I;
		fn x = t(list[0]);
		for(int i=1; i<list.length; i++){
			x = f(S,x,list[i]);
		}
		return x;
	}
	
	public static fn ST(Object... list){
		return ST(obsToNodes(list));
	}
	
	/** copy common object types, such as String, float[], int[], double[], etc into Node, else throw */
	public static fn w(Object o){
		if(o instanceof fn) {
			return (fn)o;
		}else if(o instanceof String){
			throw new Error("TODO");
		}else if(o instanceof int[]){
			throw new Error("TODO");
		}else if(o instanceof long[]){
			throw new Error("TODO");
		}else if(o instanceof float[]){
			throw new Error("TODO");
		}else if(o instanceof double[]){
			throw new Error("TODO");
		}else if(o instanceof short[]){
			throw new Error("TODO");
		}else if(o instanceof char[]){
			throw new Error("TODO");
		}else if(o instanceof byte[]){
			throw new Error("TODO");
		}else if(o instanceof boolean[]){
			throw new Error("TODO");
		}else{
			throw new Error("Unknown type: "+o.getClass().getName());
		}
	}
	
	public static fn w(boolean z){
		return z ? T : F;
	}
	
	/** progn(a b c) called on x returns (c (b (a x))) */
	public static fn progn(fn... list){
		fn ret = list[0];
		for(int i=1; i<list.length; i++){
			ret = f(S,t(list[i]),ret);
		}
		return ret;
	}
	
	public static fn setIsHalted(fn n, boolean newIsHalted){
		return node(newIsHalted, n.isParentsFunc(), n.func(), n.param(), n.stack(), n.cacheKey());
	}
	
	public static fn setIsParentsFunc(fn n, boolean newIsParentsFunc){
		return node(n.isHaltedAbove(), newIsParentsFunc, n.func(), n.param(), n.stack(), n.cacheKey());
	}
	
	public static fn setFunc(fn n, fn newFunc){
		if(n.isLeaf()) throw new Error("Dont use this for leaf");
		return node(n.isHaltedAbove(), n.isParentsFunc(), newFunc, n.param(), n.stack(), n.cacheKey());
	}
	
	public static fn setParam(fn n, fn newParam){
		if(n.isLeaf()) throw new Error("Dont use this for leaf");
		return node(n.isHaltedAbove(), n.isParentsFunc(), n.func(), newParam, n.stack(), n.cacheKey());
	}
	
	public static fn setStack(fn n, fn newStack){
		return node(n.isHaltedAbove(), n.isParentsFunc(), n.func(), n.param(), newStack, n.cacheKey());
	}
	
	public static fn setStack(fn n, fn newStack, boolean isParentsFunc){
		return node(n.isHaltedAbove(), isParentsFunc, n.func(), n.param(), newStack, n.cacheKey());
	}
	
	public static fn setCacheKey(fn n, fn newCacheKey){
		return node(n.isHaltedAbove(), n.isParentsFunc(), n.func(), n.param(), n.stack(), newCacheKey);
	}
	
	public static fn setCompareCardinality(fn n, Node newCompareCardinality){
		return node(n.isHaltedAbove(), n.isParentsFunc(), n.func(), n.param(), n.stack(), n.cacheKey());
	}
	
	/** TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.
	(Big funcBody a b c d e f), as long as funcBody is not leaf. If you want it to do that,
	wrap it in something with same behaviors other than its internal call forest (which other funcs may see that internal forest shape).
	(universalFunc comment bigCall bit bit bit param param param).
	*
	public static final Node Big = uuu;
	*/
	
	public static final fn uu = bootF(u,u);
	
	/** TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R. NONDET WAS MOVED TO OP1OF16
	nondet. If first param of universalFunc is leaf (is a pure deterministic call)
	then (nondet a b c) for any a b c evals to (S I I (S I I)) aka infloop
	else its allowed to do nondeterministic things that cant possibly affect a pure deterministic call.
	Nondeterministic can call nondeterministic or deterministic as it is,
	except that it can cancel the deterministic execution part way through,
	but if deterministic inside nondeterministic returns then it has to be the deterministic result.
	Deterministic can call deterministic as is.
	If deterministic calls nondeterministic then nondeterministic param is forkEdited recursively
	for every first param of universalFunc then it gets that param,
	and that will be done by a certain (TODO choose one) func that can be lazyEvaled (like everything else)
	which recursively goes into a func and changes that, so (aDeterministicFunc aNondeterministicFunc)
	will instantly step to (aDeterministicFunc (truncateToDeterministic aNondeterministicFunc)).
	*/
	public static final fn N = op(0);
	
	/** True aka Lx.Ly.x aka the K lambda in SKI Calculus. TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R. */
	public static final fn T = bootF(op(8),u,u,u,u,u,u,u,u);
	
	/** False aka Lx.Ly.y. TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R. */
	public static final fn F = bootF(op(9),u,u,u,u,u,u,u,u);
	
	/** IdentityFunc aka Lx.x. TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R. */
	public static final fn I = bootF(F,u);
	
	/** Lx.(GetFunc x), where (GetFunc w (GetParam w)) equals w for all w other than stack states, and (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf.
	TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.
	*/
	public static final fn L = bootF(op(10),u,u,u,u,u,u,u,u,u);
	
	/** Lx.(GetParam x), where (GetFunc w (GetParam w)) equals w for all w other than stack states, and (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf.
	TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.
	*/
	public static final fn R = bootF(op(11),u,u,u,u,u,u,u,u,u);
	
	/** A/isLeaf. TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R. */
	public static final fn A = bootF(op(12),u,u,u,u,u,u,u,u,u);
	
	/** Lx.Ly.Lz.xz(yz) aka the S lambda in SKI calculus. TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.*/
	public static final fn S = bootF(op(13),u,u,u,u,u,u,u);
	
	/** P/Pair aka Lx.Ly.Lz.zxy. TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.*/
	public static final fn P = bootF(op(14),u,u,u,u,u,u,u);
	
	/** a semantic used for things like (typeval "image/jpeg" <bitstringOfJpgContent>), and more generally type and value can be any object.
	Theres no enforcement of types except how user level code chooses to measure and share them, or not share those which dont obey user generated specs.
	If type is a bitstring, the semantic is its a utf8 string of a contentType/mediaType like "image/jpeg".
	If type is not a bitstring, it might be a treemap or a recogFunc of objects, which if (aRecogFunc x)->T then x is type aRecogFunc,
	or it might be a treemap containing such recogFuncs, or it is whatever model of types user level code finds useful.
	*/
	public static final fn typeval = bootF(op(15),u,u,u,u,u,u,u,u);
	
	public static final fn callParamOnItself = bootF(S,I,I);
	
	/** Lx.Ly.Lz.xy, lazyAtUserLevelInsteadOfVMLevel (x y) ignoring z.
	TODO add comment. TODO create setComment func. Its one of the 15 params but different param index depending on which of 16 opcodes.
	*/
	private static fn lazig;
	public static fn lazig(){
		if(lazig == null) lazig = lambda(3,S(p(13),p(14)));
		return lazig;
	}
	
	private static fn funcThatInfloopsForEveryPossibleParam;
	public static fn funcThatInfloopsForEveryPossibleParam(){
		if(funcThatInfloopsForEveryPossibleParam == null) {
			funcThatInfloopsForEveryPossibleParam = e(lazig(),callParamOnItself,callParamOnItself);
		}
		return funcThatInfloopsForEveryPossibleParam;
	}
	
	public static final fn lazyInfiniteLoop = f(callParamOnItself,callParamOnItself);
	
	public static final fn iota = e(P,S,T);
	
	/** TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.
	(getComment x) returns the second param of universalFunc cuz thats where comment goes, else returns leaf if it doesnt have a second param.
	The universalFunc always takes 9 params, so it can take 0 to 8 params and be halted as long as those params are halted. Second param is comment.
	This func must be derived from the universalFunc which ignores its second param other than to observe L and R childs.
	*
	public static final Node getComment = null; //FIXME
	
	/** TODO REWRITE COMMENTS AND FIX THIS CODE, IT WAS COPIED FROM OCFN3R.
	(setComment x c) returns a forkEdited x with c as second param of universalFunc cuz thats where comment goes, leaving everything else the same.
	The universalFunc always takes 9 params, so it can take 0 to 8 params and be halted as long as those params are halted. Second param is comment.
	This func must be derived from the universalFunc which ignores its second param other than to observe L and R childs.
	*
	public static final Node setComment = null; //FIXME
	*/
	
	public static final fn cons = P;
	
	public static final fn car = e(S,I,t(T));
	
	public static final fn cdr = e(S,I,t(F));
	
	//public static final Node carByLR = e(ST(L,R));
	
	public static final fn nil = u;
	
	public static final fn isNil = A;
	
	/** FIXME undecided. new: infloop if key not found, so have to use containsKey. OLD: (aMap key) -> val or u if doesnt contain key. *
	public static final fn mapOfOneThing = TODO call equals func on the key and param and return val if equals else return leaf,
		and if this
	*/
	
	/** FIXME undecided. new: infloop if key not found, so have to use containsKey. OLD: (aMap key) -> val or u if doesnt contain key. This func returns u for everything. */
	public static final fn emptyMap = t(u);
	
	public static final fn defaultComment = u;
	
	/** context can be anything since the universalFunc logic sees it the same as comment (exists but only in that L and R can see it.
	Its recommended to use (pair salt map) where salt is forkEdited by some secureHash to be a different salt, deterministicly,
	each time you call a nondet op that needs salt such as wallet or spend or solve,
	so you can call it again and not have the cache from the previous call (which has a different salt) returned instead of trying again.
	FIXME CacheFuncParamReturn needs to be modified to be a map of <isDeterministic_aka_NOTIsZeroKelvinInBloomClass,func,param> -> return,
	and only share those where !isDeterministic_aka_NOTIsZeroKelvinInBloomClass in p2p network cuz only those guarantee sync statelessly.
	Everything else is recommended to use the defaultContext constant.
	*/
	public static final fn defaultContext = P.e(u).e(emptyMap);
	
	private static fn ifElse;
	/** (ifElse condition ifTrue ifFalse) evals to (ifTrue leaf) if condition==T and evals to (ifFalse leaf) if condition==F, for example.
	Normally used with lazig and S. See Example.equals() andOr ImportStatic.IF(fn,fn,fn) in ocfn2.
	TODO setComment to "ifElse" after create setComment func and use typeval for it being a string or a certain key "//" in comment being a map.
	*/
	public static fn ifElse(){
		if(ifElse == null) ifElse = lambda(3,
			ST(
				P,
				p(14),//TODO p("getIfTrue",14),
				p(15),//TODO p("getIfFalse",15),
				p(13),//TODO p("getCondition",13),
				t(u)
			)
		);
		return ifElse;
	}
		
	/*
		//setComment,
		//e(
			Big,
			ST(
				P,
				p8,//TODO p("getIfTrue",8),
				p9,//TODO p("getIfFalse",9),
				p7,//TODO p("getCondition",7),
				t(u)
			),
			F, F, T //ignore first 3 of 6 params
		//)//,
		//"ifElse"
	);*/
	
	public static fn IF(fn condition, fn ifTrue, fn ifFalse){
		return ST(ifElse(), condition, ifTrue, ifFalse);
	}
	
	public static fn thenConst(fn constant){
		return f(lazig(),t(constant));
	}
	
	/** the ST form of then(...). ST just does t(...) to its first param
	and other than that is the same as S(...).
	*/
	public static fn thenT(Object... obs){
		return f(lazig(),ST(obs));
	}
	
	public static fn then(Object... obs){
		return f(lazig(),S(obs));
	}
	
	private static fn and;
	/** https://en.wikipedia.org/wiki/Church_encoding says and = Lp.Lq.pqp * */
	public static fn and(){
		if(and == null) and = lambda(2,S(p(14),p(15),p(14)));
		return and;
	}
	
	private static fn or;
	/** https://en.wikipedia.org/wiki/Church_encoding says and = Lp.Lq.ppq */
	public static fn or(){
		if(or == null) or = lambda(2,S(p(14),p(14),p(15)));
		return or;
	}
	
	private static fn not;
	public static fn not(){
		if(not == null) not = P.e(F).e(T);
		return not;
	}
	
	private static fn xor;
	/** TODO there must be a more efficient form */
	public static fn xor(){
		if(xor == null) xor = lambda(2,ST(
			or(),
			ST(and(),p(14),ST(not(),p(15))),
			ST(and(),ST(not(),p(14)),p(15))
		));
		return xor;
	}
	
	private static fn xor3;
	public static fn xor3(){
		if(xor3 == null) xor3 = lambda(3,ST(
			xor(),
			p(13),
			ST(xor, p(14), p(15))
		));
		return xor3;
	}
	
	private static fn xor4;
	public static fn xor4(){
		if(xor4 == null) xor4 = lambda(4,ST(
			xor(),
			ST(xor(), p(12), p(13)),
			ST(xor(), p(14), p(15))
		));
		return xor4;
	}
	
	private static fn nand;
	public static fn nand(){
		if(nand == null) nand = lambda(2,ST(not(),ST(and(),p(14),p(15))));
		return nand;
	}
	
	private static fn nor;
	public static fn nor(){
		if(nor == null) nor = lambda(2,ST(not(),ST(or(),p(14),p(15))));
		return nor;
	}
	
	private static fn minorityBit;
	/** a universal logic operator on 3 bits to 1 bit that returns T half the time. TODO there must be a more efficient form */
	public static fn minorityBit(){
		if(minorityBit == null) minorityBit = lambda(3,ST(
			xor4(),
			t(T),
			ST(and(),p(13),p(14)),
			ST(and(),p(14),p(15)),
			ST(and(),p(15),p(13))
		));
		return minorityBit;
	}
	
	/** TODO create a recur (no number) that checks which of op1 to op7 it is which is the number of params it takes */
	private static fn recur2;
	public static fn recur2(){
		if(recur2 == null) recur2 = progn(L,R,L); //in (pair allCurriesExceptLast lastParam) get (L allCurriesExceptLast)
		return recur2;
	}
	
	private static fn Equals;
	public static fn Equals(){
		if(Equals == null) Equals = lambda(2,IF(
			ST(A,p(14)), //if p9 is leaf
			thenT(A,p(15)), //then return: p10 is leaf?
			then(IF( //else if
				ST(A,p(15)), //if p10 is leaf?
				thenConst(F), //then return F
				thenT( //else return AND of recurse 2 times on the left of both params and right of both params
					and,
					S(recur2(), ST(L,p(14)), ST(L,p(15)) ),
					S(recur2(), ST(R,p(14)), ST(R,p(15)) )
				)
			))
		));
		return Equals;
	}
	
	/** getParamInBigCall. Does not get the right param if called on something other than the (pair allCurriesExceptLast lastParam) bigCall makes. */
	private static final fn p[];
	static{
		p = new fn[16];
		p[0] = t(u); //every call starts with the universalFunc/u, then 15 params if first param is leaf. If first param is not leaf, thats for future expansion.
		//R is faster form of cdr when we know its called on a pair.
		for(int i=1; i<15; i++){
			int numLs = 14-i; 
			fn[] list = new fn[2+numLs+1];
			Arrays.fill(list, L);
			list[0] = L; //get (pair allCurriesExceptLast)
			list[1] = R; //get allCurriesExceptLast
			list[list.length-1] = R; //get param from call pair
			p[i] = progn(list);
		}
		p[15] = R; //get lastParam from (pair allCurriesExceptLast lastParam)
	}

}
