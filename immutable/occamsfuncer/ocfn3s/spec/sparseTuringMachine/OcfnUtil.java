/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine;
import static immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine.LogOptions.lgEval;
import static immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine.LogOptions.lgStep;
import static immutable.util.TestUtil.lg;

import java.util.HashMap;
import java.util.Map;

public class OcfnUtil{
	
	/*FIXME universalFunc always takes 10 params, instead of 9, cuz adding a cardinality param to,
	for example, create an object that evals to T or F depending if P equals NP or not,
	and evaling it costs infinity squared ops (may be able to optimize it to finite cost?).
	HaltingOracles are impossible, but cardinalityBasedHaltingDetectors (which cant emulate a haltingOracle)
	are consistent. Similar to truncateToDeterministic automatically getting called by (aDet aNnondet),
	truncateToCardinality will be automatically called whenever params cardinality is bigger than
	self's cardinality, and cardinalityBasedHaltingDetector will truncateToCardinality to 1 lower cardinality
	than self's cardinality (unless its already lower than that),
	And truncateToCardinality will never be called on the lowest/leaf cardinality,
	and cardinalityBasedHaltingDetector at cardinality leaf/lowest will always return T,
	and in all other cases it returns T or F depending if (itsParam leaf) halts or not,
	except that if (itsParam leaf) tries to call anything at higher cardinality
	(such as this cardinalityBasedHaltingDetector) it wont be able to cuz of truncateToCardinality.
	cardinalityBasedHaltingDetector is deterministic and is BigO(infinity^cardinality),
	and (nondet leaf leaf x) is (cardinalityBasedHaltingDetector x),
	therefore not every call of nondet is counted as nondeterministic
	(which automatically does truncateToDeterministic if determinstic calls nondeterministic).
	(nondet anyNonleaf b c) is nondeterministic.
	(nondet leaf anything anything) is deterministic,
	but it still makes sense to put the op there since it would normally be used with
	challenge/response across the network to converge a bunch of guesses and claims
	instead of computing it sequentially which may cost up to BigO(infinity^cardinality).
	This does not interfere with cardinality 0 step function always returning in constant time.
	..
	TODO create fn objects which if called on leaf (such as a lazig) return this...
	* T or F depending if P equals NP or not.
	* T or F depending if collatz is true or not.
	* T or F depending if haltingOracles are possible or not (of course it returns F, but it proves it).
	* the BigO of integer factoring.
	* the BigO of cracking ed25519.
	* the BigO of editDistance (of course this is squared times the BigO of integer plus, max, etc).
	* the BigO of matrix multiply, and of the specific algorithms that are used for it so far between about n^2.4 and n^3,
		though it might be slightly higher than that cuz they're not counting the cost of integer multiply and plus
		but thats probably just n^whatever * log(n) or something like that.
	I'm not saying I can get these answers, but I do plan to precisely ask the questions each as a fn object
	that if called on leaf evals to the answer, and such eval has at least infinity cost
	unless find a way to optimize it to finite cost.
	*/
	
	
	private static final Map<Node,Node> dedup = new HashMap();
	
	/** the universal function */
	public static final Node u = node(true,false,true,/*true,true,*/null,null,null,null/*,null*/);
	
	//FIXME? going wity ocfn3s so leaving the cardinality param as ignore, to be used in emulators?
	
	/** returns a deduped node */
	public static Node node(boolean isHalted, boolean isParentsFunc, boolean isDeterministic, /*boolean isFinite, boolean isUnary,*/
			Node func, Node param, Node stack, Node cacheKey/*, Node compareCardinality*/){
		int hash = hash(isHalted, isParentsFunc, isDeterministic, /*isFinite, isUnary,*/ stack, func, param, cacheKey/*, compareCardinality*/);
		return node(hash, isHalted, isParentsFunc, isDeterministic, /*isFinite, isUnary,*/ func, param, stack, cacheKey/*, compareCardinality*/);
	}
	
	/** returns a deduped node */
	protected static Node node(int hash, boolean isHalted, boolean isParentsFunc, boolean isDeterministic, /*boolean isFinite, boolean isUnary,*/
			Node func, Node param, Node stack, Node cacheKey/*, Node compareCardinality*/){
		return dedup(new Node(hash, isHalted, isParentsFunc, isDeterministic, /*isFinite, isUnary,*/ func, param, stack, cacheKey/*, compareCardinality*/));
	}
	
	protected static int hash(boolean isHalted, boolean isParentsFunc, boolean isDeterministic, /*boolean isFinite, boolean isUnary,*/
			Node func, Node param, Node stack, Node cacheKey/*, Node compareCardinality*/){
		//TODO spread the second params of identHashElse better.
		return identHashElse(stack,103)*1292567 + identHashElse(stack,103)*49999
			+ identHashElse(stack,5651) + identHashElse(cacheKey,619) /*+ identHashElse(compareCardinality,43)*/
			+ (isHalted?16:0) + (isParentsFunc?8:0) + (isDeterministic?4:0) /*+ (isFinite?2:0)+(isUnary?1:0)*/;
	}
	
	protected static int identHashElse(Node n, int elseThis){
		return n==null ? elseThis : System.identityHashCode(n);
	}
	
	/** with null cacheKey and stack */
	public static Node lazyCall(Node func, Node param){
		//FIXME is this the right place to call asStackTop?
		return lazyCall(func,param,null);
	}
	
	/** a lazy call pair at bottom of stack.
	WARNING: safe only if you first check canCall.
	<br><br>
	Node n is halted if func(n) is halted and param(n) are halted and the distance thru func(func(...func(n))) to leaf < 9
		cuz the universalFunc always takes 9 params.
		Aka if any of the first 8 are leaf, and func(n).isHalted and param(n).isHalted then n is halted, else n is not halted.
	*/
	public static Node lazyCall(Node func, Node param, Node cacheKey){
		//FIXME is this the right place to call asStackTop?
		if(!canCall(func,param)) throw new Error("Cant call ("+func+" "+param+")");
		Node stack = null;
		Node compareCardinality = null;
		//TODO call func(...) linear(constant) instead of squared(constant) times.
		//(u isDeterministic cardinality comment funcBodyElseU bitA bitB bitC paramD paramE paramF)
		Node l = L(func);
		Node ll = L(l);
		Node lll = L(ll);
		Node llll = L(lll);
		Node lllll = L(llll);
		Node llllll = L(lllll);
		Node lllllll = L(llllll);
		Node llllllll = L(lllllll);
		boolean isHalted = func.isHalted & param.isHalted & (
			func.isLeaf()
			| l.isLeaf()
			| ll.isLeaf()
			| lll.isLeaf()
			| llll.isLeaf()
			| lllll.isLeaf()
			| llllll.isLeaf()
			| lllllll.isLeaf()
			| llllllll.isLeaf()
		);
		boolean isParentsFunc = false; //cuz stack is null
		boolean isDeterministic = func.isDeterministic & param.isDeterministic; //FIXME also include cacheKey.isDeterministic?
		//boolean isFinite = func.isFinite & param.isFinite; //FIXME also include cacheKey.isFinite?
		//boolean isUnary = param.isUnary & func==T; //Example: (T (T (T .))) is unary3. Cardinality is a unary number.
		return node(isHalted, isParentsFunc,isDeterministic, /*isFinite, isUnary,*/ func, param, stack, cacheKey/*, compareCardinality*/);
	}
	
	/** a lazy call pair at bottom of stack.
	WARNING: safe only if you first check canCall on each pair.
	*/
	public static Node f(Node... curryList){
		//FIXME is this the right place to call asStackTop?
		if(curryList[0]==null) throw new NullPointerException();
		if(curryList.length == 0) return I;
		Node ret = curryList[0];
		for(int i=1; i<curryList.length; i++) ret = lazyCall(ret,curryList[i]); //FIXME cacheKey is null here. Is that right?
		return ret;
	}
	
	public static Node f(Object... curryList){
		return f(obsToNodes(curryList));
	}
	
	/** eval of (func param). WARNING: may never halt */
	public static Node e(Node func, Node param){
		return eval(lazyCall(func,param));
	}
	
	/** eval of calls. WARNING: may never halt */
	public static Node e(Node... curryList){
		return eval(f(curryList));
	}
	
	public static Node e(Object... curryList){
		return e(obsToNodes(curryList));
	}
	
	public static Node[] obsToNodes(Object... obs){
		Node[] ret = new Node[obs.length];
		for(int i=0; i<obs.length; i++){
			ret[i] = w(obs[i]);
		}
		return ret;
	}
		
	
	/** This is part of the VM and shouldnt be called by user level code. Its public so the VM can be tested.
	Same as f(Node...) except doesnt call anything and marks them all as halted at boot time */
	public static Node bootF(Node... curryList){
		if(curryList.length < 2) throw new Error("Must call at least 2 Nodes: "+curryList.length);
		if(curryList.length == 2){
			for(int i=0; i<2; i++){
				Node c = curryList[i];
				if(!c.isDeterministic) throw new Error("Boot func must be deterministic: "+c);
				//if(!c.isFinite) throw new Error("Boot func must be finite: "+c);
				if(c.stack != null | c.isParentsFunc) throw new Error("Boot func cant have stack (and therefore cant have isParentsFunc): "+c);
				if(c.cacheKey != null) throw new Error("Boot func cant have cacheKey: "+c);
			}
			//boolean isUnary = bootIsT(curryList[0]) & curryList[1].isUnary;
			return node(true, false, true, /*true, isUnary,*/ curryList[0], curryList[1], null, null/*, null*/);
		}else{
			Node ret = curryList[0];
			for(int i=1; i<curryList.length; i++) ret = bootF(ret,curryList[i]);
			return ret;
		}
	}
	
	/** Same as n==T except this works before T is defined.
	T is bootF(u,u,u,u,u,u,u,bootF(u,u),u).
	public static final Node opPrefix = bootF(u,u,u,u,u);
	public static final Node op1 = bootF(opPrefix,u,u,uu);
	public static final Node T = bootF(op1,u);
	*/
	public static boolean bootIsT(Node n){
		return bootIsBits(n,false,false,false,false,false,false,true,false);
		//return bootIsBits(n,false,false,false,false,false,false,false,true,false);
	}
	
	/** In the bits param, u is false, and uu is true, but uu is not bootF(u,u) cuz cant call bootF yet.
	This is not the normal T and F. This is bits as isLeaf vs !isLeaf used at a lower level.
	T is bootF(u,u,u,u,u,u,u,bootF(u,u),u) aka [Lx.Ly.x].
	public static final Node opPrefix = bootF(u,u,u,u,u);
	public static final Node op1 = bootF(opPrefix,u,u,uu);
	public static final Node T = bootF(op1,u);
	*/
	public static boolean bootIsBits(Node n, boolean... params){
		if(!n.isDone()) return false;
		if(params.length > 9) throw new Error("VM is broken or someone called bootF (a trusted dangerous function) deeper than 9 curries");
		int cur = curriesOfHalted(n);
		if(cur != params.length) return false;
		for(int paramIndex = params.length-1; paramIndex>=0; paramIndex--){
			if(params[paramIndex]){ //asking if param is (uu)
				if(!bootIsLeafLeaf(n.param)) return false;
			}else{ //asking if param is u
				if(n.param != u) return false;
			}
			n = n.func;
		}
		return true;
	}
	
	public static boolean bootIsLeafLeaf(Node n){
		if(!isDone(n)) return false;
		if(n == u) return false; //u.func==null & u.param==null, but every other func and param is nonnull
		if(n.func==u & n.param==u) return true;
		return false;
	}
	
	/** This is only for closing a recursive logic during boot. WARNING: If used for other things, might create errors. */
	protected static Node markHaltedRecursively(Node n){
		if(!isStackBottom(n)) throw new Error("Not stack bottom so cant be halted");
		if(n.isLeaf()){
			return u;
			//return node(true, true, false, false, null, null, null);
		}else{
			return node(true, false, n.isDeterministic, /*n.isFinite, n.isUnary,*/
				markHaltedRecursively(n.func), markHaltedRecursively(n.param), null, null/*, null*/);
			//return node(false, true, false, false, null, markHaltedRecursively(n.func), markHaltedRecursively(n.param));
		}
	}
	
	public static Node dedup(Node n){
		Node ret = dedup.get(n);
		if(ret == null) dedup.put(ret=n, n);
		return ret;
	}
	
	/** You can call (x y) when !isLocked(x)&&!isLocked(y). They dont have to be halted to call them, which creates a lazy call,
	but they do both have to be at the bottom of their stack. If they're in the middle of a calculation, you can ghostPop down the stack
	without changing stack contents until you're at the bottom of stack, then can call, then step and it will go back down the stack
	at most 1 stack depth per step.
	*/
	public static boolean isStackBottom(Node n){
		return n.stack==null;
		//OLD: could check n.stack==null but for better formal verification, branching should depend only on state in each node
		//and never touch a null pointer.
		//return !n.isParentsFunc() & !n.isParentsParam();
	}
	
	/** never null */
	public static Node L(Node n){
		//FIXME verify this doesnt get called before identityFunc is set.
		return n.isLeaf() ? I : n.func;
	}
	
	/** never null */
	public static Node R(Node n){
		return n.isLeaf() ? n : n.param;
	}
	
	/** measure by forest shape if its halted or not. The universalFunc always takes 9 params.
	Anything more than 9 and it cant be halted. But params not being halted can prevent self from being halted yet.
	*
	public static boolean isHalted(Node n){
		TODO define the logic. If there any way for it to cost more than constant number of cycles to measure isHalted, then need Node.isHalted cached.
		(... (leaf (leaf (leaf leaf))) isHalted but you have to look as deep as height to know it,
		therefore must have Node.isHalted cache.
	}*/
	
	//public static final boolean cacheFuncParamReturn = false; //FIXME should be true
	public static final boolean cacheFuncParamReturn = true;
	
	/** WARNING: may never halt */
	public static Node eval(Node n){
		Node start = n;
		if(lgEval) lg("start eval: "+n);
		while(!isDone(n)) n = step(n);
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
	public static Node eval(Node n, long maxSteps){
		while(maxSteps-- > 0 & !isDone(n)) n = step(n);
		return n;
	}
	
	public static Node evalOrThrow(Node n, long maxSteps){
		Node ret = eval(n,maxSteps);
		if(!isStackBottom(ret)) throw new RuntimeException("Needed more steps");
		return ret;
	}
	
	public static long test_countCallsOfStep = 0;
	
	/** returns 0 to 9. Throws if not halted */
	public static int curriesOfHalted(Node n){
		if(!n.isHalted) throw new Error("Not halted");
		for(int i=0; i<10; i++){
			if(n == u) return i;
			n = n.func;
		}
		throw new Error("Halted node has more than 9 params so VM is broken");
	}
	
	/** This is BigO(1). Get (. isDeterministic cardinality) such as (. . .) or such as (. (..) .) or (. (..) (T (T .))), when given
	a halted func of any number of curries between 0 and 9 (cuz universalFunc always curries 10 params).
	If it has less than 2 curries, adds . as those curries.
	<br><br>
	TODO this will be used with Node.isUnary and Node.countCardinality
	*/
	public static Node recur8(Node n){
		int curries = curriesOfHalted(n); //throws if not halted
		for(int i=curries-2; i>0; i--) n = n.func;
		return n;
	}
	
	public static boolean isDeterministic(Node n){
		return R(L(recur8(n))).isLeaf();
	}
	
	public static Node cardinality(Node n){
		return R(recur8(n));
	}
	
	
	/*The universalFunction u always curries 10 parameters, which are each made of combos of call pairs of u.
	U is a universalLambdaFunction and a patternCalculusFunction and can define transfinite constraints but will
	cost a transfinite amount of compute cycles and memory to solve the constraints unless each individual
	statement might be at runtime optimized to finite cost. At cardinality 0, each compute step halts in
	constant time and constant new objects in memory (allowing garbage collection), and its similar to a
	turing-machine except in a sparse forest topology, and every possible change is an immutable object.
	Eval is a loop of step.

	(u isDeterministic cardinality comment funcBodyElseU bitA bitB bitC paramD paramE paramF)
	
	truncateToDeterministic
	(aDeterministicLambda aDeterministicLambda) evals as normal.
	(aNondeterministicLambda aDeterministicLambda) evals as normal, however the local VM's nondeterminism says to.
	(aNondeterministicLambda anotherNondeterministicLambda) evals as normal, however the local VM's nondeterminism says to.
	(aDeterministicLambda anotherNondeterministicLambda) evals to (aDeterministicLambda (truncateToDeterministic anotherNondeterministicLambda))
	
	truncateToCardinality
	Happens for every param to at highest the same cardinality as this one, UNLESS its cardinality is leaf (the lowest)
	which is the baseCase. Params of (nondet leaf anything) have cardinality truncated to 1 lower than self's cardinality
	else self cardinality is leaf and (TODO choose 1, i think i did in godelituhedron*.txt but forgot what it was) its some
	constant (such as T or Leaf) or (s i i (s i i)). Think thru the design constraints and it will become clear
	which of those it needs to be, especially considering step func in cardinality 0 has to be Big(1).
	
	the 3 kinds of nondet (which is deterministicTransfinite if param 1/3 is leaf, else is nondeterministic):
	(nondet leaf leaf x) returns (after infinite time) T if (x leaf) halts else returns F. This is a deterministic transfinite call.
	(nondet leaf anyNonleaf x) is halted if (x leaf) would halt, else never halts. This is a deterministic transfinite call.
	(nondet anyNonleaf anything anything) is the normal 3 param nondet that you find in ocfn2
		such as for wallet, spend, ocfnplug, mutableWrapperLambda, and goalFuncNamespace calls.
	..
	These use truncateToCardinality to avoid being able to create halting-oracles and godel-like paradoxes.
	See godelituhedron*.txt for details.
	..
	deterministicTransfinite, at cardinality 2 (T (T leaf)), can directly define the question "does P equal NP or not"
	(todo put that fn doesPEqualNPGetAnswerWhenCallThisOnLeaf in Util with the other example functions, along with collatz etc),
	which in infinity squared time (exists possibleNPSolverInPTime where forAll subsetSumQuestion recogFuncOf_possibleSolver_with_question),
	which can be said in terms of halting vs nonhalting 2 transfinite haltingDetectors deep.
	Similarly it can represent the question is sqrt(2) irrational, and the question of the collatzConjecture, etc.
	It probably cant in finite time (unless a very good optimization is found that changes infinite to finite in some cases)
	find those answers but it can at least precisely ask the questions.
	..
	It doesnt have transfinite axioms, only transfinite sequence of things to do (each an infinity^n number of things to do in parallel)
	to bruteForce it... BUT since the system can emulate itself and variations of itself,
	it could redesign any of that in the emulator.
	<br><br>
	Disorganized text below[
		FIXME choose if Node needs an isDeterministic param vs if that can be derived from looking a constant depth.
			Consider that you cant tell if somethings deterministic vs needs truncateToDeterministic called on it,
			until it halts, but you can tell as soon as all 9 params (of universalFunc) halt if the leaf 9 down to the L
			is followed by leaf or not. It seems it can be derived. TODO verify after testcases are working.
		
		TODO if theres more than 9 params, recurse left,
			else if theres exactly 9 halted params, do the main logic,
			else if theres less than 9 halted params, its halted,
			elkse recurse if those params arent halted.
			
		TODO first of 9 params being leaf vs nonleaf chooses deterministic or nondeterministic, in the nondet op (which replaced lazyeval since can derive that).
			Nondet can call nondet or det as it is.
			Det can call det as it is.
			If det calls nondet (have to wait until a param halts to know of its det or nondet), truncateToDeterministic is automatically called on it
				which replaces first param with leaf if it has between 0 and 8 params (since 9 params would eval).
				The nondeterministic call therefore does everything the same except whenever (if ever) it calls op.nondet that evals to (S I I (S I I))
					which is an infloop, instead of potentially doing a nondeterministic thing.
		TODO does isHalted only refer to n.func and n.param or does it also include that it may have to return up the stack?
			It means only func and param but TODO rename it so its clear it means that, such as isHaltedExceptDownStack,
				but choose something shorter.
	]
	*/
	public static Node step(Node n){
		
		/*FIXME must do this before the core function is complete
		
		UPDATE: finishOcfnUniversalFuncByInfloopingIfParamIsHigherCardinalityThanMeOrIfIAmDeterministicAndParamIsNondeterministic_cuzTruncateFuncsAreTooComplexToBePartOfUniversalFunc
		This will be extremely simpler than including truncate funcs in the core definition of the universal func,
		and instead this infloops whenever it would have truncated,
		and if caller wants to do truncateToDeterministic or truncateToCardinality then caller can do that first
		so the infloop doesnt happen.
		will create truncateToDeterministic and truncateToCardinality funcs (or merged into 1 truncate func) as user level code, not part of VM.
		Step func will fast check Node.isDeterministic and Node.isFinite for func and param,
		and if both are true, nothing more to do about nondeterminism and cardinalities.
		If !isFinite, then the step func calls (infloopIfCardinalityBigger funcsCardinality paramsCardinality) and ignores its return value,
		and step func infloops if myIsDeterministic is true and paramsIsDeterministic is true,
		and if cardinality param is ever not like (T (T (T .))) then infloops,
		and there will be a bit in Node (so total 5 bits, 4 pointers, and in the case of java implementation an int hashCode)...
		a bit in Node for isUnary such as (T (T (T .))) is unary3 and . is unary0.
		Thats different than binary such as (T (F (T .))) which can have T and F.
		infloopIfCardinalityBigger is still needed AS LAZYEVAL cuz step must be BigO(1)
		but cardinality can be any unary number. Unsure if will need another bit in Node to say that
		its counting the cardinality so dont start another cardinality counting during
		it (similar to isTruncating bit which I got rid of).
		WAIT... where does the partial calculation go of calling infloopIfCardinalityBigger
		so that it can continue the rest of the step func?
			It appears to need a fifth pointer that does nothing except compare the sizes of 2 unary numbers (cardinalities),
			which would be either null or (pair funcsCardinalityCountingDown paramsCardinalityCountingDown),
			or could have 6 pointers and those 2 are funcsCardinalityCountingDown and paramsCardinalityCountingDown.
			Each step, if at least 1 of funcsCardinalityCountingDown vs paramsCardinalityCountingDown is . then
			the cardinality compare finished, and it either then does the normal step behaviors
			or returns lazy infloop aka lazy (S I I (S I I)). I choose 5 pointers.
			In some ways of optimizing it, will only need 2 pointers cuz using stack of external system,
			but as a sparseTuringMachine it needs 5, or would need only 4 if its always cardinality 0.
		...
		OLD:
		FIXME step must call truncateToCardinality if !Node.isFinite of this, this.func, and this param,
		and call truncateToDeterministic similarly if this.func isDeterministic and this.param !Node.isDeterministic,
		and maybe same for stack, and what about cacheKey?
		Only nondet has to be infinite cost at cardinality higher than 0.
		For example, at cardinality 3, the other 7 ops work as normal,
		so truncateToCardinality is testable.
		Do both kinds of truncate in same func. Have 4 funcs for all 4 combos of isDeterministic and isFinite cuz its more efficient.
		*/
		
		test_countCallsOfStep++;
		if(lgStep) lg("start step: "+n);
		
		//TODO optimize, avoid caching things that return themself due to having less than 10 params, like:
		//Write cache (mid), key=L
		//Write cache (mid), val=L
		//Probably did this by moving "n = setCacheKey(n, truncateToStackBottom(n));" into !isHalted. TODO verify.
		
		//TODO optimize: Can this.cacheKey==null&L(this).isHalted&R(this).isHalted
		//be used to mean cache key (not the field) is (this.func this.param)? 
		
		Node ret;
		Node l = L(n), r = R(n);
		
		//These next 2 IFs dont happen in most nodes, so its fast.
		if(l.isDeterministic & !r.isDeterministic){
			//Caller could have used truncateToDeterministic to avoid this.
			return lazyInfiniteLoop;
		}
		/*if(!r.isFinite){
			//Prepare to compareCardinality. If cardinality of func is less than cardinality of param, evals to lazyInfiniteLoop.
			//Caller could have used truncateToCardinality to avoid that.
			//Since step(Node) must be BigO(1), and cardinality is unlimited size unary number,
			//they are compared in Node.compareCardinality in multiple calls of step(Node),
			//unless cardinality 0 then takes no extra steps.
			//Node.compareCardinality is null or (pair funcsCardinalityCountingDown paramsCardinalityCountingDown)
			if(n.compareCardinality == null){
				if(lgStep) lg("cardinality start comparing. This system cannt possibly have a paradox.");
				return setCompareCardinality(n, bootF(P,cardinality(l),cardinality(r)));
			}else{
				Node aPair = n.compareCardinality;
				//faster way to do (car aPair) and (cdr aPair), in this case. Avoids adding to cache.
				Node funcsCardinalityCountingDown = R(L(aPair));
				Node paramsCardinalityCountingDown = R(aPair);
				if(paramsCardinalityCountingDown == u){ //cardinality(func) >= cardinality(param). Verified cardinality, so dont instantly infinite loop.
					if(lgStep) lg("cardinality continuing normally. This system cant possibly have a paradox.");
					n = setCompareCardinality(n, null);
					lg("Removed compareCardinality from Node (then continuing step func): "+n);
				}else if(funcsCardinalityCountingDown == u){ //cardinality(func) < cardinality(param). //Prevent this call by infinite looping.
					//For example, this is what happens if you try to call a halting oracle on an emulator of yourself to ask what yourself would do
					//then do the opposite, disproving the halting oracle. Halting oracles dont exist. The closest thing is
					//a function that, after infinity^cardinality cycles (see nondet op), answers T or F does (itsParam .) halt
					//BUT only if itsParam's cardinality is less than caller's cardinality,
					//and similarly everywhere else param can have less OR EQUAL cardinality as func.
					if(lgStep) lg("cardinality must infloop to avoid paradox. This system cannt possibly have a paradox.");
					return lazyInfiniteLoop;
				}else{ //still comparing cardinalities, havent reached the end of either unary number.
					//aUnaryNumber-1 = aUnaryNumber.param, if aUnaryNumber!=u.
					//Can bootF here cuz know P is halted with 2 params and only pair of unary numbers can be in Node.compareCardinality.
					if(lgStep) lg("cardinality counting down to check for paradox. This system cannt possibly have a paradox.");
					return setCompareCardinality(n, bootF(P,funcsCardinalityCountingDown.param,paramsCardinalityCountingDown.param));
				}
			}
		}*/
		
		//FIXME some of the isDeterministic and isFinite calculations will probably be buggy until
		//testcases are written for higher cardinalities and nondeterminism:
		//higher cardinalities (such as proving the existence of a pair
		//of integers x and x+1 where integer is a linkedlist of T and F, is cardinality 1,
		//which can only be tested by forkEditing an emulator of the system to have
		//math axioms which allow that otherwise BigO(infinity) cost calculation to
		//in some cases return in finite time, especially cases when that pattern is found)
		//and nondeterminism (such as wallet and spend calls).
		//The deterministic finite form is the first thing thats being tested and is the core logic of the system.
		//An emulator of the system (of the step func) cant be built (as user level code in the system)
		//until the core logic is well tested. Such emulator will be around 30 times slower
		//than the main system with only the optimization of caching <func,param,return>
		//but without the optimizations of GPU, hardware strictfp double arithmetic, etc,
		//but maybe optimizations can be done for emulators later too.
		
		//boolean writeCache = false;
		
		if(n.isHalted){
			//Usually a nonleaf, but if n isLeaf, it will be here, even though leaf.func is identityFunc and leaf.param is leaf.
			if(isStackBottom(n)){
				//FIXME write to cache here too?
				if(n.cacheKey != null){
					Node val = n;
					if(lgStep) lg("Write cache (end), key="+n.cacheKey);
					if(lgStep) lg("Write cache (end), val="+val);
					CacheFuncParamReturn.put(n.cacheKey, val);
				}
				ret = n;
			}else{ //return down the stack. This is either L/func or R/param child of its parent (1 lower on stack).
				if(n.cacheKey != null){
					Node val = truncateToStackBottom(n);
					if(lgStep) lg("Write cache (mid), key="+n.cacheKey);
					if(lgStep) lg("Write cache (mid), val="+val);
					CacheFuncParamReturn.put(n.cacheKey, val);
				}//else{
				//	//It is correct when it has less than 10 params. UniversalFunc always curries 10 params.
				//	throw new Error("FIXME Is it ever correct (other than inside an opencl optimized calculation etc) to return down the stack without writing cache?\r\nn="+n);
				//}
				if(n.isParentsFunc){
					boolean isHalted = false;
					boolean isParentsFunc = n.stack.isParentsFunc;
					//boolean isTruncating = TODO;
					Node func = truncateToStackBottom(n);
					Node param = n.stack.param;
					Node stack = n.stack.stack;
					Node cacheKey = n.stack.cacheKey;
					boolean isDeterministic = func.isDeterministic & param.isDeterministic;
					//boolean isFinite = func.isFinite & param.isFinite;
					ret = node(isHalted, isParentsFunc, isDeterministic, /*isFinite,*/ func, param, stack, cacheKey);
					//TODO return node(false, false, n.stack.isParentsFunc, n.stack.isParentsParam(), n.stack.stack, n, n.stack.param);
					//return node(false, false, n.stack.isParentsFunc, n.stack.isParentsParam(), n.stack.stack, n, n.stack.param);
				}else{ //n.isParentsParam
					boolean isHalted = false;
					boolean isParentsFunc = n.stack.isParentsFunc;
					//boolean isTruncating = TODO;
					Node func = n.stack.func;
					Node param = truncateToStackBottom(n);
					Node stack = n.stack.stack;
					Node cacheKey = n.stack.cacheKey;
					boolean isDeterministic = func.isDeterministic & param.isDeterministic;
					//boolean isFinite = func.isFinite & param.isFinite;
					ret = node(isHalted, isParentsFunc, isDeterministic, /*isFinite,*/ func, param, stack, cacheKey);
					//TODO return node(false, false, n.stack.isParentsFunc, n.stack.isParentsParam(), n.stack.stack, n.stack.func, n);
					//return node(false, false, n.stack.isParentsFunc, n.stack.isParentsParam(), n.stack.stack, n.stack.func, n);
				}
			}
		}else if(!l.isHalted){ //recurse into L(n)
			boolean isHalted = false;
			boolean isParentsFunc = true;
			//boolean isTruncating = TODO;
			Node func = l.func;
			Node param = l.param;
			Node stack = n;
			Node cacheKey = l.cacheKey; //FIXME should this be null?
			boolean isDeterministic = func.isDeterministic & param.isDeterministic;
			//boolean isFinite = func.isFinite & param.isFinite;
			ret = node(isHalted, isParentsFunc, isDeterministic, /*isFinite,*/ func, param, stack, cacheKey);
			//return node(l.isLeaf(), l.isHalted, true, false, n, l.func, l.param);
		}else if(!r.isHalted){ //recurse into R(n)
			boolean isHalted = false;
			boolean isParentsFunc = false;
			//boolean isTruncating = TODO;
			Node func = r.func;
			Node param = r.param;
			Node stack = n;
			Node cacheKey = r.cacheKey; //FIXME should this be null?
			boolean isDeterministic = func.isDeterministic & param.isDeterministic;
			//boolean isFinite = func.isFinite & param.isFinite;
			ret = node(isHalted, isParentsFunc, isDeterministic, /*isFinite,*/ func, param, stack, cacheKey);
			//return node(l.isLeaf(), l.isHalted, false, true, n, l.func, l.param);
		}else{ //do the main logic here instead of recursing into func, param, or going up stack
			
			if(n.cacheKey == null){
				//FIXME I dont know if this is the right cacheKey logic
				n = setCacheKey(n, truncateToStackBottom(n));
				if(lgStep) lg("After setCacheKey: "+n);
			}
			
			if(cacheFuncParamReturn){
				//About to eval (haltedX haltedY) which itself is not halted, but first check <func,param,return> cache
				//with the normed form as if its a stackBottom.
				Node truncateToStackBottom = truncateToStackBottom(n);
				Node cachedEval = CacheFuncParamReturn.get(truncateToStackBottom);
				if(cachedEval != null){
					if(lgStep) lg("Returning from cache. Before restack: "+cachedEval);
					ret = setStack(cachedEval, n.stack, n.isParentsFunc);
					if(lgStep) lg("Returning from cache: "+ret);
					return ret; //FIXME move the code below the IF into ELSE so ret isnt returned until end of func.
				}

				//FIXME must also put in CacheFuncParamReturn after it returns.
				//Thats just an optimization, but without it, it would take years to multiply 2 longs, something that normally takes 10 nanoseconds.
				//With that optimization, its BigO is the same as a RandomAccessMachine,
				//still a big constant cost, but with other optimizations I expect it to be competitive in the real world
				//as a number crunching software using GPU grids and just barely fast enough for CPU-like uses cuz of unusual caching needs.
				//throw new Error("FIXME must also put in CacheFuncParamReturn after it returns (use Node.cacheKey, so not every time something return, such as not in the ((xz)(yz)) steps (which can recurse endlessly) of (S x y z) but right after (whatXZReturns whatYZReturns) returns, map cacheKey to that, for example.");
			}
			
			Node list = n;
			Node z = R(list);
			list = L(list);
			Node y = R(list);
			list = L(list);
			Node x = R(list);
			list = L(list);
			boolean bitA = !R(list).isLeaf();
			list = L(list);
			boolean bitB = !R(list).isLeaf();
			list = L(list);
			boolean bitC = !R(list).isLeaf();
			list = L(list);
			Node bigCallFuncBody = R(list);
			boolean bitD = !bigCallFuncBody.isLeaf();
			list = L(list);
			Node comment = R(list); //comment is ignored by the main logic other than to get its childs
			list = L(list);
			//FIXME truncateToCardinality params recursively unless their cardinality is leaf.
			Node cardinality = R(list); //comment is ignored by the main logic other than to get its childs
			list = L(list);
			//FIXME truncateToDeterministic if this is deterministic and param is nondeterministic
			//(leaf leaf ...anything...) is pure deterministic. (leaf anyNonleaf ...anything...) allows nondeterminism.
			boolean isDeterministic = R(list).isLeaf();
			Node maybeLeaf = L(list);
			//If this is ready to eval, then maybeLeaf is now leaf. But TODO there may be other ways it could be leaf?
			//		I just want to check if there are exactly 8 params, also if there are more than 8 then eval
			//		the 8 first then the others are lazyEvaled lower in stack.
			if(!maybeLeaf.isLeaf()){
				//Example: (..)
				//Nothing to do except mark that theres nothing to do so caller knows to do the next thing.
				ret = setIsHalted(n, true);
			}else{
				//The main logic of the 10 param universalFunc
				
				int i = (bitD?8:0)|(bitC?4:0)|(bitB?2:0)|(bitA?1:0);
				switch(i){
				//FI T L R A P S N
				case 0: //False (Lignore.Ly.Lz.z) and IdentityFunc (Lignore.Lignore2.Lz.z) go together.
					ret = z;
				break; case 1: //True aka Lignore.Ly.Lz.y
					ret = y;
				break; case 2: //L of z returns z.func
					ret = L(z);
				break; case 3: //R of z returns z.param
					ret = R(z);
				break; case 4: //A/IsLeaf of z returns true or false depending on z.isLeaf
					ret = z.isLeaf()?T:F;
				break; case 5: //P/Pair aka Lx.Ly.Lz.zxy
					ret = f(z,x,y);
				break; case 6: //S aka Lx.Ly.Lz.xz(yz)
					ret = f(x,z,f(y,z));
				break; case 7: //N/Nondet, since this formalverify is pure deterministic, always evals to (S I I (S I I)) aka infloop.
					if(isDeterministic){
						//This part must always eval to (S I I (S I I)) in practical implementations, as it does here.
						ret = lazyInfiniteLoop;
					}else{
						
						//This part will be different in practical implementations.
						//
						//(leaf leaf ...anything...) is pure deterministic. (leaf anyNonleaf ...anything...) allows nondeterminism.
						//In the case of this formalverify, the nondeterminism happens to always eval to (S I I (S I I)),
						//but in practice it will offer functions that are hard to optimize deterministicly, such as wallet and spend,
						//and functions which depend on people obeying the rules of the network which cant always be instantly enforced,
						//such as mutableWrapperLambda requires that each privateKey only digitallySign at most 1 (key,value) per key
						//and if multiple are ever detected then every call of that publicKey, pretending to be a lambda taking key
						//as param and returning value, evals to (S I I (S I I)) forever after that,
						//since a private/public key pair can act as a lambda as long as its deterministic,
						//and it may deterministicly never give a value for a certain key or may take as long as it wants
						//while others wait on a call to return (which may end at a given limit by using spend call),
						//but its no longer deterministic if it gives a different value for the same key in 2 different calls
						//even if its on 2 different computers that later share things derived from it,
						//so to partially defend against that, all calls of that publicKey take infinite time if thats ever detected,
						//and any function may take infinite time as viewed as a very inefficient VM running a deterministic lambda,
						//but that wont fix the changes echoing outward deeply into the web of computers running occamsfuncer
						//that each believe (nondet "mutableWrapperLambda" aPublicKey someKey) returned 2 different things,
						//and they will either have to challenge/response eachother about many things until converging
						//or accept that its a nondet call and keep those parts more isolated, instead sharing only deterministic results,
						//including deterministic functions that can be interpreted as a request for an external system to do
						//a nondeterministic call, or a fn, as its a very general kind of information, can be interpreted to mean anything.
						//For example, Godel interpreted integers to mean certain proofs and equations, but that didnt change the integers themselves,
						//which is good since that interpretation led to contradiction true=false,
						//or certain combos of deterministic info could be interpreted as the bytes of a jpg file using "image/jpeg".
						ret = lazyInfiniteLoop;
						
						if(1<2) throw new Error("TODO compare cardinality here. Nondets third param (if nondets first param is u)"
							+" is limited to LESS CARDINALITY THAN func (nondet up to its first 2 params"
							+" compared to everywhere else its limited to LESS_OR_EQUAL.");
					}
				break; default:
					//(leaf leaf comment funcBody a b c d e f) returns (funcBody (P (leaf leaf comment funcBody a b c d e) f)) if !funcBody.isLeaf.
					//If funcBody.isLeaf then does 1 of 8 ops, which one depending on a.isLeaf, b.isLeaf, and c.isLeaf, each taking 3 params d e f.
					//Those ops are turingComplete by themself, but for functions up to 6 params (5 if you use F F F... T to mark number of params)
					//you use this. Those functions can be recursive. That makes it intuitive for Humans and more efficient.
					//The comment param just makes it intuitive for Humans, such as a comment containing icon pixels and text.
					//
					//TODO rewrite this text...
					//bigCallFuncBody on 6 params (receiving a halted op.lazyeval of itself as a param, before that thing to be lazyevaled halts,
					//which may seem like circular logic but thats how recursion is, and if it lacks a base case it will never halt,
					//except of course every step(Node) is guaranteed to halt in at most a small constant time and extra memory,
					//which is only subject to haltingProblem if run in a loop such as eval(Node) does.).
					//To make a func of 3 params you ignore the first 3,
					//maybe put F F T there and check for the first T and have vararg at most 5 params, or however you want to use it.
					ret = f(bigCallFuncBody,f(P,l,r));
				}
			}
			ret = setCacheKey(ret, truncateToStackBottom(ret));
			//FIXME also handle cacheKey here?
			if(n.stack != null){
				//lg("FIXME what to do here? n="+n+" ret="+ret);
				Node putBackIntoStack = node(ret.isHalted, n.isParentsFunc, ret.isDeterministic, /*ret.isFinite, ret.isUnary,*/
					ret.func, ret.param, n.stack, n.cacheKey/*, ret.compareCardinality*/); //FIXME 2020-6-28 added compareCardinality and isUnary. Are they correct here? 
				//lg("n="+n+" incompleteRet="+ret+" putBackIntoStack="+putBackIntoStack);
				ret = putBackIntoStack;
			}
		}
		if(lgStep) lg("step returning "+ret);
		return ret;
	}
	
	public static boolean isDone(Node n){
		return n.stack==null && n.isHalted;
	}
	
	/** For all x and y, canCall(downToStackBottom(x),downToStackBottom(y))==true. They dont have to be halted. */
	public static boolean canCall(Node x, Node y){
		return isStackBottom(x) && isStackBottom(y);
	}
	
	/** FIXME test this func.
	<br><br>
	For all x, eval(x)==eval(downToStackBottom(x))==downToStackBottom(eval(x)).
	For all x and y, canCall(downToStackBottom(x),downToStackBottom(y))==true. They dont have to be halted.
	<br><br>
	WARNING: BigO(stackHeight), instead of the usual BigO(1).
	<br><br>
	Go up stack (until canCall is true),
	maybe after slight adjustment of what its doing here,
	so can call anything on anything, such as step(f(step(someFunc),anotherFunc)).
	Thats BigO(stackHeight) instead of the usual BigO(1) which is why its not part of step func,
	so be careful how adjust the java funcs to do that. Its not part of the occamsfuncer spec
	but is something you can derive from that spec but not at user level code cuz
	it happens before isDone(), but it could of course be done in an emulator at user level code,
	but usually we wont be using emulators.
	*/
	public static Node downToStackBottom(Node n){
		while(!isStackBottom(n)) n = n.isParentsFunc ? setFunc(n.stack,truncateToStackBottom(n)) : setParam(n.stack,truncateToStackBottom(n));
		return n;
	}
	
	/** forkEdit: remove the stack below it, but keep everything else the same. */
	public static Node truncateToStackBottom(Node n){
		//if(n.compareCardinality != null) throw new Error("Cant finish truncateToStackBottom while comparing cardinality cuz if lower cardinality is called on higher cardinality it must eval to (S I I (S I I)), so setting Node.compareCardinality to null would bypass that infinite loop, allowing halting oracle (in nondet op) to be asked what a caller of itself would do then do the opposite, and therefore disproof-by-contradiction that the system itself is a consistent design. This is just a detail to adjust, in when truncateToStackBottom can and can not be called. Specificly, it can be called when Node.compareCardinality==null.");
		return node(n.isHalted, false, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, null, null/*, null*/);
	}
	
	public static final Node uu = bootF(u,u);
	
	public static final Node uuu = bootF(u,u,u);
	
	public static final Node uuuu = bootF(u,u,u,u);
	
	public static final Node opPrefix = bootF(u,u,u,u,u);
	//(u isDeterministic cardinality comment funcBodyElseU bitA bitB bitC paramD paramE paramF).
	//The 8 ops dont have paramD paramE paramF yet.
	public static final Node op0 = bootF(opPrefix,u,u,u);
	public static final Node op1 = bootF(opPrefix,u,u,uu);
	public static final Node op2 = bootF(opPrefix,u,uu,u);
	public static final Node op3 = bootF(opPrefix,u,uu,uu);
	public static final Node op4 = bootF(opPrefix,uu,u,u);
	public static final Node op5 = bootF(opPrefix,uu,u,uu);
	public static final Node op6 = bootF(opPrefix,uu,uu,u);
	public static final Node op7 = bootF(opPrefix,uu,uu,uu);
	
	
	
	
	
	
	
	//FIXME make some constants for op numbers or at least verify these match the switch cases.

	
	public static Node paramsCommentFuncbody(int params, String comment, Node funcBody){
		switch(params){
		case 1: return f(u,u,u,comment,funcBody,F,F,F,F,T);
		case 2: return f(u,u,u,comment,funcBody,F,F,F,T);
		case 3: return f(u,u,u,comment,funcBody,F,F,T);
		case 4: return f(u,u,u,comment,funcBody,F,T);
		case 5: return f(u,u,u,comment,funcBody,T);
		case 6: return f(u,u,u,comment,funcBody);
		default: throw new Error("params is "+params+" but must be 1 to 6");
		}
	}
	
	/** (Big funcBody a b c d e f), as long as funcBody is not leaf. If you want it to do that,
	wrap it in something with same behaviors other than its internal call forest (which other funcs may see that internal forest shape).
	(universalFunc comment bigCall bit bit bit param param param).
	*/
	public static final Node Big = uuuu;
	
	//FI T L R A P S N
	
	/** False aka Lx.Ly.y */
	public static final Node F = bootF(op0,u);
	
	/** IdentityFunc aka Lx.x */
	public static final Node I = bootF(F,u);
	
	/** True aka Lx.Ly.x aka the K lambda in SKI Calculus */
	public static final Node T = bootF(op1,u);
	
	/** Lx.(GetFunc x), where (GetFunc w (GetParam w)) equals w for all w other than stack states, and (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf. */
	public static final Node L = bootF(op2,u,u);
	
	/** Lx.(GetParam x), where (GetFunc w (GetParam w)) equals w for all w other than stack states, and (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf. */
	public static final Node R = bootF(op3,u,u);
	
	/** isLeaf */
	public static final Node A = bootF(op4,u,u);
	
	/** Pair aka Lx.Ly.Lz.zxy*/
	public static final Node P = op5;
	
	/** Lx.Ly.Lz.xz(yz) aka the S lambda in SKI calculus */
	public static final Node S = op6;
	
	/** nondet. If first param of universalFunc is leaf (is a pure deterministic call)
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
	public static final Node N = op7;
	
	public static final Node callParamOnItself = bootF(S,I,I);
	
	public static final Node lazyInfiniteLoop = bootF(callParamOnItself,callParamOnItself);
	
	public static final Node iota = e(P,S,T);
	
	/** forkEdits its param so that recursively every first param of universalFunc is leaf.
	This func must be a certain standard func (TODO) derived from the universalFunc and is also called by universalFunc,
	which markHaltedRecursively "closes the loop".
	<br><br>
	Nondet can call nondet or det as it is.
			Det can call det as it is.
			If det calls nondet (have to wait until a param halts to know of its det or nondet), truncateToDeterministic is automatically called on it
				which replaces first param with leaf if it has between 0 and 8 params (since 9 params would eval).
				The nondeterministic call therefore does everything the same except whenever (if ever) it calls op.nondet that evals to (S I I (S I I))
					which is an infloop, instead of potentially doing a nondeterministic thing.
	*
	public static final Node truncateToDeterministic = null; //FIXME
	
	public static final Node truncateToCardinality = null; //FIXME
	*/
	
	/** (getComment x) returns the second param of universalFunc cuz thats where comment goes, else returns leaf if it doesnt have a second param.
	The universalFunc always takes 9 params, so it can take 0 to 8 params and be halted as long as those params are halted. Second param is comment.
	This func must be derived from the universalFunc which ignores its second param other than to observe L and R childs.
	*
	public static final Node getComment = null; //FIXME
	
	/** (setComment x c) returns a forkEdited x with c as second param of universalFunc cuz thats where comment goes, leaving everything else the same.
	The universalFunc always takes 9 params, so it can take 0 to 8 params and be halted as long as those params are halted. Second param is comment.
	This func must be derived from the universalFunc which ignores its second param other than to observe L and R childs.
	*
	public static final Node setComment = null; //FIXME
	*/
	
	public static final Node cons = P;
	
	public static final Node car = e(S,I,t(T));
	
	public static final Node cdr = e(S,I,t(F));
	
	//public static final Node carByLR = e(ST(L,R));
	
	public static final Node nil = u;
	
	/** as in churchEncoding *
	public static final Node nil = e(P,T,T);
	*/
	
	/** the church encoding of isNil, instead of this software's recommended kind of isNil which is (equals nil).
	FIXME verify the church encoding of nil and chisnil works as in https://en.wikipedia.org/wiki/Church_encoding
	*
	public static final Node chisnil = car;
	*/
	public static final Node isNil = A;
	
	/** (T param) */
	public static final Node t(Node param){
		//FIXME is this the right place to call asStackTop?
		return f(T,param);
	}
	
	/** (T (T param)) */
	public static Node tt(Node param){
		return t(t(param));
	}
	
	/** (T (T (T param))) */
	public static Node ttt(Node param){
		return t(tt(param));
	}
	
	/** (T (T (T (T param)))) */
	public static Node tttt(Node param){
		return tt(tt(param));
	}
	
	public static Node S(Object... list){
		return S(obsToNodes(list));
	}
	
	/** returns an S-curry-list of those, like in ocfn2 */
	public static Node S(Node... list){
		//FIXME is this the right place to call asStackTop?
		if(list.length == 0) return I;
		Node x = list[0];
		for(int i=1; i<list.length; i++){
			x = f(S,x,list[i]);
		}
		return x;
	}
	
	/** ST(a b c d) equals S(t(a) b c d), for any size list */
	public static Node ST(Node... list){
		//FIXME is this the right place to call asStackTop?
		if(list.length == 0) return I;
		Node x = t(list[0]);
		for(int i=1; i<list.length; i++){
			x = f(S,x,list[i]);
		}
		return x;
	}
	
	public static Node ST(Object... list){
		return ST(obsToNodes(list));
	}
	
	/** copy common object types, such as String, float[], int[], double[], etc into Node, else throw */
	public static Node w(Object o){
		if(o instanceof Node) {
			return (Node)o;
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
	
	public static Node w(boolean z){
		return z ? T : F;
	}
	
	/*public static Node[] reverse(Node... list){
		Node[] ret = new Node[list.length];
		for(int i=0; i<list.length; i++) ret[i] = list[list.length-1-i];
		return ret;
	}*/
	
	/** progn(a b c) called on x returns (c (b (a x))) */
	public static Node progn(Node... list){
		Node ret = list[0];
		for(int i=1; i<list.length; i++){
			ret = f(S,t(list[i]),ret);
		}
		return ret;
	}
		
	
	/** get 10th param of bigCall which itself only has 6 params but including all 10 of universalFunc with first 9 and last 1 in a pair.
	Unlike the lower param indexs, this last one is the second param of a pair instead of in a currylist in the first param of pair.
	The others start with L R which gets the first param of pair. R gets the second param. Could also use car and cdr but those are slower
	and more general such as they could work on a function that takes T or F as its param thats acting similar to a pair but dynamicly.
	*/
	public static final Node p10 = R;
	
	/** get 9th param of bigCall which itself only has 6 params but including all 10 of universalFunc with first 9 and last 1 in a pair */
	public static final Node p9 = e(progn(L,R,R));
	
	/** get 8th param of bigCall which itself only has 6 params but including all 10 of universalFunc with first 9 and last 1 in a pair */
	public static final Node p8 = e(progn(L,R,L,R));
	
	public static final Node p7 = e(progn(L,R,L,L,R));
	
	public static final Node p6 = e(progn(L,R,L,L,L,R));
	
	public static final Node p5 = e(progn(L,R,L,L,L,L,R));
	
	public static final Node p4 = e(progn(L,R,L,L,L,L,L,R));
	
	public static final Node p3 = e(progn(L,R,L,L,L,L,L,L,R));
	
	public static final Node p2 = e(progn(L,R,L,L,L,L,L,L,L,R));
	
	public static final Node p1 = e(progn(L,R,L,L,L,L,L,L,L,L,R));
	
	/** universalFunc always curries 10 params, so param0 is leaf, and this func which gets p0 (from what bigCall creates) returns leaf when called on anything *
	public static final Node p0 = e(t(u));
	*/
	
	private static final Node[] p = {null, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
	
	/** 1 to 10 cuz universalFunc always curries 10 params. Index 0 is used for universalFunc itself. */
	public static Node p(int index){
		return p[index];
	}
	
	/*public static Node p(String comment, int index){
		return f(setComment,p[index],comment);
	}*/
	
	/** call bigCall of lambda of 6 params recursively. This is the simple kind of recursion that does NOT use F F F T etc
	as first 1-5 params to pad those first unused params so is vararg of 1-5 params. This is instead the 6 param simpler kind.
	*/
	public static final Node recur6 = e(progn(L,R,L,L,L,L,L));
	
	/** for bigCall (lambda of 6 params), recursive call with 5 param, so the first param is left as it is */
	public static final Node recur5 = e(progn(L,R,L,L,L,L));
			
	/** for bigCall (lambda of 6 params), recursive call with 4 param, so the first 2 params are left as they are */
	public static final Node recur4 = e(progn(L,R,L,L,L));; //FIXME
	
	/** for bigCall (lambda of 6 params), recursive call with 3 param, so the first 3 params are left as they are */
	public static final Node recur3 = e(progn(L,R,L,L));
	
	/** for bigCall (lambda of 6 params), recursive call with 2 param, so the first 4 params are left as they are */
	public static final Node recur2 = e(progn(L,R,L));
	
	/** for bigCall (lambda of 6 params), recursive call with 1 param, so the first 5 params are left as they are.
	This does the same thing as car if its param is a pair.
	*/
	public static final Node recur1 = e(progn(L,R));
	
	/** for what bigCall (lambda of 6 params) creates, call it now with those 6 params.
	You shouldnt do this from the funcBody inside a bigCall cuz it would infiniteLoop. Its here for completeness.
	*/
	public static final Node recur0 = S(recur1,p10);
	
	/** vararg 1-5 params recursive call. Takes param of what bigCall creates, which is (pair curryListOfFirst9Params lastParam),
	as a result of (curryListOfFirst9Params lastParam) being called.
	<br><br>
	(bigCall funcBody T) is a func of 5 params.
	(bigCall funcBody F T) is a func of 4 params.
	(bigCall funcBody F F T) is a func of 3 params.
	(bigCall funcBody F F F T) is a func of 2 params.
	(bigCall funcBody F F F F T) is a func of 1 param.
	<br><br>
	In funcBody, you can use recur, or recur1, recur2, recur3, recur4, or recur5,
	or if you arent using F F T etc to define number of params you can use recur6 for a 6 param lambda,
	and if you want more params you use bigCall to define a function that adds next param to a linkedlist until a counter reaches 0 then calls funcBody.
	For example, (bigCall fibonacciFuncBody F F F F T) where fibonacciFuncBody contains ST( plus S(recur ST(minusOne p10)) S(recur ST(plus t(-2) p10)) )
	and a baseCase for fibonacci of 0 is 0 and of 1 is 1, so (bigCall fibonacciFuncBody F F F F T 8) would return 21.
	Cuz of <func,param,return> caching, fibonacci has same BigO as doing it in an array,
	but a large constant times slower (in parts that are not GPU or javassist optimized etc).
	<br><br>
	This func will go into the first param of pair to get the currylist of the first 9 params (universalFunc always curries 10 params),
	then recurse to find the first param thats T, and return the currylist of that size, such as (bigCall fibonacciFuncBody F F F F T),
	so when the part of fibonacciFuncBody which contains S(recur something) is evaled, (recur whatBigcallCreates) evals to
	(bigCall fibonacciFuncBody F F F F T), and something evals to the first param to call on recursion of self,
	so (bigCall fibonacciFuncBody F F F F T 8) would call (bigCall fibonacciFuncBody F F F F T 7) and (bigCall fibonacciFuncBody F F F F T 6),
	and (bigCall fibonacciFuncBody F F F F T 7) would call (bigCall fibonacciFuncBody F F F F T 6) and (bigCall fibonacciFuncBody F F F F T 5),
	and the first call of (bigCall fibonacciFuncBody F F F F T 6) would be evaled and later calls of it (until at any time its removed from cache)
	would instantly return what the first call of it returned, even if its a nondeterministic node since first eval observes nondeterminism
	until cache is cleared cuz if that wasnt the design then randomNumberA-randomNumberA would not equal 0 so you couldnt
	proceed to do any deterministic calculations on nondeterministic results. Fibonacci should of course be defined deterministicly.
	<br><br>
	If it was a 3 param func (max 5 in vararg recur), then funcBody would contain S(recur a b c).
	If you want all 6 params, then funcBody would contain S(recur6 a b c d e f)
	<br><br>
	This is similar to the recur op in ocfn2 (1 of 16 of its ops) except ocfn2 had unlimited vararg,
	compared to this ocfn3 has max 6 params and has to derive any vararg bigger than that. Thats why lisp uses alot of linkedLists.
	A linkedList node is a pair which is Lx.Ly.Lz.zxy which is a 3 param lambda.
	*
	public static final Node recur = null; //FIXME
	*/
	
	/** (ifElse condition ifTrue ifFalse) evals to (ifTrue leaf) if condition==T and evals to (ifFalse leaf) if condition==F, for example.
	Normally used with lazig and S. See Example.equals() andOr ImportStatic.IF(fn,fn,fn) in ocfn2.
	*/
	public static final Node ifElse = e(
		
		//setComment,
		//e(
			Big,
			ST(
				P,
				p9,//TODO p("getIfTrue",9),
				p10,//TODO p("getIfFalse",10),
				p8,//TODO p("getCondition",8),
				t(u)
			),
			F, F, T //ignore first 3 of 6 params
		//)//,
		//"ifElse"
	);
	
	public static Node IF(Node condition, Node ifTrue, Node ifFalse){
		return ST(ifElse, condition, ifTrue, ifFalse);
	}
	
	/** https://en.wikipedia.org/wiki/Fixed-point_combinator#Fixed-point_combinators_in_lambda_calculus
	La.(Lb.a(bb))(Lb.a(bb))
	*
	public static final Node yCombinator = could use small forest of S to directly create the (Lb.a(bb)) lambdas then call (S I I) on it.
	e(Big,funcBody,F,F,F,T,a) no thats not the best way
	TODO use bigCall to make a 2 param func and refer to itself recursively.
	*/
	
	/** TODO getComment and setComment funcs, but until thats working, it will have to be more like assembly programming */
	public static final Node lazig = e(Big,S(p8,p9),F,F,T); //f( ccc(), S(p(4),p(5)) ).COMMENT("lazig"); //ignore p(6)
	
	public static Node then(Object... obs){
		return f(lazig,S(obs));
	}
	
	/** the ST form of then(...). ST just does t(...) to its first param
	and other than that is the same as S(...).
	*/
	public static Node thenT(Object... obs){
		return f(lazig,ST(obs));
	}
	
	public static Node thenConst(Node constant){
		//return tt(constant);
		//TODO tt(constant)?
		return f(lazig,t(constant)); //FIXME
	}
	
	/*public static Node and = e(
		//setComment,
		Big,
		S(
			p9,
			p10, //if p9 is T
			t(F) //if p9 is F
		),
		F, F, F, T //ignore first 4 of 6 params
		//"and"
	);*
	/** https://en.wikipedia.org/wiki/Church_encoding says and = Lp.Lq.pqp *
	public static Node and = S()
	//public static Node and = ST(P,I,t(F)); no...
	*/
	
	/** https://en.wikipedia.org/wiki/Church_encoding says and = Lp.Lq.pqp * */
	public static Node and = e(
		Big,
		S(p9,p10,p9),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	/** https://en.wikipedia.org/wiki/Church_encoding says and = Lp.Lq.ppq * */
	public static Node or = e(
		Big,
		S(p9,p9,p10),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	public static Node not = e(P,F,T);
	
	/** TODO there must be a more efficient form */
	public static Node xor = e(
		Big,
		ST(
			or,
			ST(and,p9,ST(not,p10)),
			ST(and,ST(not,p9),p10)
		),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	public static Node xor3 = e(
		Big,
		ST(
			xor,
			p8,
			ST(xor, p9, p10)
		),
		F, F, T //ignore first 3 of 6 params
	);
	
	public static Node xor4 = e(
		Big,
		ST(
			xor,
			ST(xor, p7, p8),
			ST(xor, p9, p10)
		),
		F, T //ignore first 2 of 6 params
	);
	
	/** TODO a more efficient form would look similar to and */
	public static Node nand = e(
		Big,
		ST(not,ST(and,p9,p10)),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	/** TODO a more efficient form would look similar to or */
	public static Node nor = e(
		Big,
		ST(not,ST(or,p9,p10)),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	/** a universal logic operator on 3 bits to 1 bit that returns T half the time. TODO there must be a more efficient form */
	public static Node minorityBit = e(
		Big,
		ST(
			xor4,
			t(T),
			ST(and,p8,p9),
			ST(and,p9,p10),
			ST(and,p10,p8)
		),
		F, F, T //ignore first 3 of 6 params
	);
	
	/** FIXME this was copied from ocfn2 which uses vararg. Will isntead use bigCall and recur2, and I didnt finish coding it here */
	public static Node equals = e(
		Big,
		IF(
			ST(A,p9), //if p9 is leaf
			thenT(A,p10), //then return: p10 is leaf?
			then(IF( //else if
				ST(A,p10), //if p10 is leaf?
				thenConst(F), //then return F
				thenT( //else return AND of recurse 2 times on the left of both params and right of both params
					and,
					S(recur2, ST(L,p9), ST(L,p10) ),
					S(recur2, ST(R,p9), ST(R,p10) )
				)
			))
		),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	//public static final Node GetComment = TODO derive from universalFunc;
	
	/** (SetComment (universalFunc comment bigCall bit bit bit param param) newComment)
	-> (universalFunc newComment bigCall bit bit bit param param).
	<br><br>
	(SetComment (universalFunc comment bigCall bit bit) newComment)
	-> (universalFunc newComment bigCall bit bit)
	<br><br>
	(SetComment leaf newComment)->(leaf newComment)
	*
	public static final Node SetComment = TODO derive from universalFunc;
	
	public static final Node equals = TODO derive from universalFunc, similar to how its derived in ocfn2;
	
	public static final Node cons = TODO derive from universalFunc;
	
	public static final Node car = TODO derive from universalFunc;
	
	public static final Node cdr = TODO derive from universalFunc;
	
	public static final Node nil = TODO derive from universalFunc;
	
	public static final Node cheapIsNil = TODO derive from universalFunc the churchEncoding way;
	
	public static final Node isNil = f(equals,nil);
	

	TODO simulate a vibrating sine wave by position += dt*velocity; velocity -= dt*position; And dont forget energy norming
	(in this case just hold constant approx radius cuz physics will be destroyed by roundoff in log number of cycles if not)
	Using linkedlist of T and F as numbers.
	Later will use completebinarytree T and F with Pair objects, as abstraction to wrap primitive arrays such as int[] and double[]
	and in each of those wrappers have an int start and int end that views a powOf2 size and can create views of subranges of same array,
	down to the bits in a single primitive, only if observed. But for now do it the slow way linkedlist of T and F.
	After that proofOfConcept, go farther by simulating spring physics between a small number of objects in a WorldOfGoo-like game,
	computed entirely by this universalFunc, other than to display colored rectangles or circles where the func says to display them
	by outputting linkedlists of T and F as numbers.
	*/
	
	
	/** linkedlist of T or F as integer, plus 1 *
	public static final Node plus1 = TODO;
	*/
	
	/** (chuasCircuit x y z dt)->(chuasCircuit x+dx y+dy z+dz) where those numbers are strictfp float64
	and it jumps linearly that distance by current derivative measured once.
	Implement it using a Big func of 4 params aka (. "chuasCircuit" funcBody F T x y z dt).
	The F T mean those params arent used, like if it was a 2 param func it would be F F F T.
	*
	public static final Node chuasCircuit = TODO;
	*/
	
	/** lin is listlike number such as (T (F (T (T nil)))) is (binary)1011 aka (baseTen)11. *
	public static final Node linPlusOne = could use small forest of S to directly create the (Lb.a(bb)) lambdas then call (S I I) on it.
	*/
	
	/** lln is linkedlist of T and F such as (pair T (pair F (pair T (pair T nil)))) is (binary)1101 aka (baseTen)13.
	The first T or F is the 1s digit.
	This is different than forExample cbt of 64 bits which hardware strictfp double multiply would be used on.
	*
	public static final Node llnPlusOne = TODO;
	If nil, then return (T nil).
	else{
		If first digit is F, forkEdit that for first digit to be T.
		Else forkEdit first digit to be F and forkEdit the remaining digits to be llnPlusOne of those.
	}
	TODO tests of this.
	*/
	
	/** lin aka linkedList number, is a simpler kind of linkedlist that doesnt use pair,
	like (T (T (F (T nilAkaLeaf)))) is the number 0x1011 aka 11, and nilAkaLeaf is 0.
	Remember, (F nilAkaLeaf) is I. Both are halted. They just have the same forest shape. So dont be confused by seeing I in the numbers.
	*/
	public static final Node linPlusOne = e(
		Big,
		IF(
			ST(A,p10),
			thenConst(f(T,nil)),
			then(IF(
				ST(L,p10), //get lowest digit as T or F.
				thenT( //Lowest digit is T. Replace it with F and replace rest (higher digits) with add 1 recursively
					F,
					S(recur1, ST(R,p10))
				),
				thenT( //lowest digit is F. Replace it with T.
					T,
					ST(R,p10) //leave rest of the linkedlist (higher digits) as it is
				)
			)
		)),
		F, F, F, F, T //ignore first 5 of 6 params
	);
	
	/*public static final Node linPlus = e(
		Big,
		S(linPlusWithCarry, t(F), p9, p10),
		F, F, F, T //ignore first 4 of 6 params
	);*/
	
	/** sums 1 or 0 (depending if p8 is T or F) and 2 lin numbers (p9 and p10)
	Cancel this func, wont work cuz of...
	
	111111
	111111
	
	    1
	111110
	111110
	
	
	   11
	111100
	111100
	*
	public static final Node linPlusWithCarry = e(
			FIXME Should this recurse into both numbers at once vs call linPlusOne for each T digit in the other number?
			
		Big,
		IF(
			ST(and, p8, ST(A,p9)),
			then(p10), //If p9 is 0 and theres no carry, return p1-
			then( //else recurse to sum each 1 digit of p9 into p10 starting at that digitOffset
				TODO
			)
		),
		F, F, F, T //ignore first 4 of 6 params
	);*/
					
	/** zero https://en.wikipedia.org/wiki/Church_encoding Lf.Lx.x */
	public static final Node chZero = F;
					
	/** plusOne/successor https://en.wikipedia.org/wiki/Church_encoding Ln.Lf.Lx.f(nfx) */
	public static final Node chSucc = e(
		Big,
		S(p9, S(p8, p9, p10)),
		F, F, T //ignore first 3 of 6 params
	);
		
	/** plus https://en.wikipedia.org/wiki/Church_encoding Lm.Ln.Lf.Lx.mf(nfx) */
	public static final Node chPlus = e(
		Big,
		S(p7,p9,S(p8,p9,p10)),
		F, T //ignore first 2 of 6 params
	);
	
	/** multiply https://en.wikipedia.org/wiki/Church_encoding Lm.Ln.Lf.Lx.m(nf)x */
	public static final Node chMult = e(
		Big,
		S(p7,S(p8,p9),p10),
		F, T //ignore first 2 of 6 params
	);
	
	/** exponent https://en.wikipedia.org/wiki/Church_encoding Lm.Ln.nm */
	public static final Node chExponent = e(
		Big,
		S(p10,p9),
		F, F, F, T //ignore first 4 of 6 params
	);
	
	/** exponent https://en.wikipedia.org/wiki/Church_encoding
	Ln.Lf.Lx.n(Lg.Lh.h(gf))(Lu.x)(Lv.v)
	TODO this will require more thinking than the other church funcs cuz it shares vars across lambdas,
	and ocfn is designed to have no vars, but I'm sure ocfn can do it,
	even in the worst case ocfn would just use lambdas to create entirely separate lambdas.
	*
	public static final Node chPred = e(
		Big,
		S(...)
		F, F, T //ignore first 3 of 6 params
	);*/
	
	/** Example: 0x1011 -> (T (T (F (T nilAkaLeaf)))) */
	public static Node lin(long number){
		if(number < 0) throw new Error("Lin only supports nonnegative integers");
		Node ret = nil;
		for(int digitIndex = 63-Long.numberOfLeadingZeros(number); digitIndex>=0; digitIndex--){
			Node digit = w((number&(1<<digitIndex))!=0);
			ret = digit.e(ret);
		}
		return ret;
	}
	
	/** (isItTrueThatForEveryPossibleXYZThatIfXEqualsYAndYEqualsZThenXEqualsZ .) returns T or F after infinity cycles */
	public static final Node isItTrueThatForEveryPossibleXYZThatIfXEqualsYAndYEqualsZThenXEqualsZ = null; //FIXME
	
	public static final Node emulatorOptimizedFor_isItTrueThatForEveryPossibleXYZThatIfXEqualsYAndYEqualsZThenXEqualsZ = null; //FIXME
	
	public static final Node emulatorOptimizedFor_areThereInfinityPrimes = null; //FIXME
	
	/** (areThereInfinityPrimes .) evals to T (else F) if there are infinity primes. Of course it will eval to T,
	but it would be cheating to set the value of this to (T T) where (T T .) evals to T. This will be a way to prove it.
	*/
	public static final Node areThereInfinityPrimes = null; //FIXME
	
	/** (isCollatzTrue .) returns T or F, after infinity cycles */
	public static final Node isCollatzTrue = null;
	
	public static final Node emulatorOptimizedFor_isCollatzTrue = null; //FIXME
	
	/** (isFermatsLastTheoremTrue .) evals to T if not exists integer exponent>2 where exists integers x y and z where x^exponent+y^exponent=z^exponent,
	else returns F. Costs some infinity number of calculations (higher cardinality) so can only finish the calculation in some emulator of this system
	which in some cases can optimize infinity calculations to a finite number of calculations.
	The question is extremely easier to define as a Node than the emulator which would answer it in finite time.
	*/
	public static final Node isFermatsLastTheoremTrue = null; //FIXME
	
	public static final Node emulatorOptimizedFor_isFermatsLastTheoremTrue = null; //FIXME
	
	/** (doesPEqualNP .) evals to T (else F) if there exists Node subsetSumSolverInPTime where,
	given a linkedlist of lin integers (such as (T (T (F (T .)))) is baseTen11), (subsetSumSolverInPTime thatLinkedList) evals to T or F
	depending if any subset of the integers in the (cdr thatLinkedList) sums to (car thatLinkedList),
	and subsetSumSolverInPTime costs at most maxCyclesAllowed=(plus constantA (exponent (numberOfNodesInForest (pair thatLinkedList subsetSumSolverInPTime)) constantB))
	number of calls of step(Node) for any constants constantA and constantB,
	and doesPEqualNP evals to T (else F) if:
	exists subsetSumSolverInPTime forAll thatLinkedList (lessThan (computeMaxCyclesAllowed ...) (unoptimizedEmulatorOfOccamsfuncerV3 subsetSumSolverInPTime thatLinkedList)).
	<br><br>
	I plan to create this Node but am very skeptical of ever evaling it,
	even though I am very confident that some possible emulator of occamsfuncerV3 would eval it in finite time,
	I just dont know which possible emulator would do that.
	*/
	public static final Node doesPEqualNP = null; //FIXME
	
	public static final Node emulatorOptimizedFor_doesPEqualNP = null; //FIXME
	
	//FIXME is there 8 params or 9 params in the universalFunc?
	//Depends how I'm designing the nondet, and if theres 4 vs 5 Node ptrs in Node.
	
	public static boolean forABreakpoint; //TODO remove this after get a certain testcase working
	
	public static Node setIsHalted(Node n, boolean newIsHalted){
		return node(newIsHalted, n.isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, n.stack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setIsParentsFunc(Node n, boolean newIsParentsFunc){
		return node(n.isHalted, newIsParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, n.stack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setIsDeterministic(Node n, boolean isDeterministic){
		return node(n.isHalted, n.isParentsFunc, isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, n.stack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	//public static Node setIsUnary(Node n, boolean newIsUnary){
	//	return node(n.isHalted, n.isParentsFunc, n.isDeterministic, n.isFinite, newIsUnary, n.func, n.param, n.stack, n.cacheKey/*, n.compareCardinality*/);
	//}
	
	//public static Node setIsFinite(Node n, boolean isFinite){
	//	return node(n.isHalted, n.isParentsFunc, n.isDeterministic, isFinite, n.isUnary, n.func, n.param, n.stack, n.cacheKey/*, n.compareCardinality*/);
	//}
	
	public static Node setFunc(Node n, Node newFunc){
		if(n.isLeaf()) throw new Error("Dont use this for leaf");
		return node(n.isHalted, n.isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ newFunc, n.param, n.stack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setParam(Node n, Node newParam){
		if(n.isLeaf()) throw new Error("Dont use this for leaf");
		return node(n.isHalted, n.isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, newParam, n.stack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setStack(Node n, Node newStack){
		return node(n.isHalted, n.isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, newStack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setStack(Node n, Node newStack, boolean isParentsFunc){
		return node(n.isHalted, isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, newStack, n.cacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setCacheKey(Node n, Node newCacheKey){
		return node(n.isHalted, n.isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, n.stack, newCacheKey/*, n.compareCardinality*/);
	}
	
	public static Node setCompareCardinality(Node n, Node newCompareCardinality){
		return node(n.isHalted, n.isParentsFunc, n.isDeterministic, /*n.isFinite, n.isUnary,*/ n.func, n.param, n.stack, n.cacheKey/*, newCompareCardinality*/);
	}

}
