/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.v3.spec.sparseTuringMachine;

import java.util.function.UnaryOperator;

/** The simplest form that will work, with 3 pointers instead of 5 like in Node5. TODO copy some comments from there to here.
<br><br>
Of the 4 Node ptrs (staack func param cacheKey), you only need func and param if you use an external stack such as java stack,
but if you need step to return in constant time and memory then you need all 4.
<br><br>
As UnaryOperator, this is a lambda function, takes lambda parameter and returns lambda.
*/
public final class Node implements UnaryOperator<Node>{
	
	/*
	
	
	
	
	yes, 10 params, as in godelituhedron todo copy that text to its own file here while reorganizing it
	as it was quickly written and disorganized.
	
	TODO? Add a tenth param of the universalFunc thats cardinalityLevel[
	    If nondet's first param is leaf, then its a haltingDetector op,
	    and it (after infinity^cardinalityLevel cycles) returns 1 of 3 things
	    depending if it knows that it halts, does not halt, or cant answer cuz its asked about
	    something thats equal or higher cardinality.
	    I'm unsure if thats the right way to encode it since cardinalities might vary at runtime
	    and need another func like truncateToDeterministic but instead would truncate to a certain cardinalityLevel.
	    Or I might want it to be 2 funcs, one for does it certainly halt, and another for does it certainly not halt.
	    This part of nondet (where its first param is leaf) would be considered pure deterministic BUT
	    has BigO(exponent(infinity,cardinalityLevel)) so would only be useful as a form of communication
	    and maybe in some cases could be optimized by proofs.
	    Specificly, I want an ocfn3 object that certainly evals to true or false depending if P equals NP or not,
	    despite that it will likely cost infinity squared compute cycles to eval it,
	    but maybe I could find optimizations to prove P not equals NP in some finite time
	    maybe by using kolmogorovComplexity of the question itself (a specific ocfn3 object)
	    to limit the kolmogorovComplexity of its max possible compute cycles needed to answer it,
	    or something like that.
	    ..
	    (leaf isDeterministic cardinalityLevel comment funcbodyOrLeaf bit bit bit param param param),
	    ..
	    so universalFunc always takes 10 params. Or can I put that param inside nondets 3 params?
	    cardinalityLevel is leaf for 0, (T leaf) for 1, (T (T leaf)) for 2, and so on, or something like that.
	    (nondet leaf x y) returns 1 of 3 constants depending if (x y) halts, does not halt, or cant be known from here,
	    or it could be (nondet leaf leaf (lazig x y)) which depends on if (lazig x y leaf) halts.
	    ..
	    Maybe have haltingDetector return (pair doesItCertainlyHalt doesItCertainlyNotHalt).
	    ..
	    Start simpler by proving or disproving collatz, which should cost
	    only infinity cycles (instead of P vs NP costing infinity squared), possibly optimizable to finite cycles.
	    ...
	    Do I want an op that infloops unless (thatOp a b c) where (a b) evals to c,
	    as a way to represent <func,param,return> caching? (thatOp a b c) either is halted or infloops
	    depending if (a b) evals to c. That might create haltingOracle-like problems if used with
	    the otherwise consistent cardinalities of haltingDetector.
	    
	    ** (doesPEqualNP leaf) certainly returns T or F in at most infinity squared cycles, depending if P=NP or not,
	    and using proofs you might be able to optimize a fork of this occamsfuncerVM to prove that you can eval
	    it for finite cost, or even better for a certain finite cost, and better yet then do the eval
	   	and prove that P does not equal NP (cuz it near certainly does not equal, in my and most experts opinions,
	   	but we havent precisely proven it yet, we havent even precisely asked the question,
	   	and by precise I mean without using words such as in formal papers but instead using ONLY math symbols).
	    *
	    public static final Node doesPEqualNP = TODO;
	    test("prove P != NP",e(doesPEqualNP,leaf)==F);
	    It would be good if this could be done at user level
	    instead of having to write the optimizations and proofs into forks of the VM,
	    which I'm unsure if can be done or not, given how hard a time Godel had with a similar problem.
	    Every unique function behavior is identified by a binary forest shape of call pairs where all paths lead to leaf,
	    and already in ocfn2 there is an equals function, for example (equals equals equals)==T
	    and (equals equals anythingElse)==F, and equals func is guaranteed to always halt in
	    worst case of number of nodes in the 2 functions its comparing and practically (by secureHash)
	    in amortized constant time.
	    
	    
	                                                                    
		In what math syntax can you ask does P equal NP?
		For example, a lambda function could be created that returns true/Lx.Ly.x or false/Lx.Ly.y depending
		on 2 params: an emulator of a lambda, and a linkedlist of true/false as a number for max compute cycles
		. Has the emulator halted by then or not? Lambdas would work for finite questions, but P vs NP is an
				infinite question. It needs to ask about all possible functions and all possible NP questions
				(such as all possible sets of integers to do subset sum on, which can be translated for P
						cost to any other NP problem). For those, you dont need a haltingOracle but you need
				something similar. A kind of lambdas each with a nonnegative integer level, would have
		different behaviors depending on if they're called on a higher, equal, or lower level lambda. A haltingDetector
		at level n only answers correctly if its parameter is less than level n. For example, if a normal lambda at
		level 0 does the usual disproof of haltingOracles by calling haltingOracle on an emulator of itself, asking
		if it halts or not, then doing the opposite... If that happened with haltingDectector level 1, then it would
		know that its being asked about a level 1 lambda therefore should return some constant (such as identityFunc)
		instead of true or false. So the cardinalities of haltingDetectors are consistent, and no haltingOracles
		exist. Some variant of this might be able to ask the question does P equal NP. Is there a simpler way?
	]*/
		
	
	/** low few bits (selected by mask) are part of Node's data, and the rest are just for Object.hashCode()
	which must be derived from  
	*
	public final int hashAndMask;
	*/
	
	public final int hash;

	public final boolean isHalted;
	
	public final boolean isParentsFunc;
	
	public final boolean isDeterministic;
	
	public final boolean isFinite;
	
	/** True if VM forkEdited something to call truncateToDeterministic andOr truncateToCardinality,
	and this marks that fact so the VM doesnt call it again on the same thing before it returns.
	Nevermind, VM wouldnt do that cuz VM would wait until it returns anyways, so I'm removing this field.
	*
	public final boolean isTruncating;
	*/
	
	public final Node func;
	
	public final Node param;
	
	public final Node stack;
	
	/** Is key in CacheFuncParamReturn and is original (func param) before forkEditing forExample (s x y z) becomes ((x z)(y z))
	so in that case cacheKey would be lazy (s x y z) whose 2 halted childs are (s x y) and z.
	Without CacheFuncParamReturn, this software would cost exponential time. With it, same BigO as RandomAccessMachine.
	In other implementations (than this sparseTuringMachine very basic one), CacheFuncParam will only be used on
	less than 1% of objects, expecially excluding the middle calculations of OpenCL/GPU and javassist optimizations.
	OLD: cacheKeyExists==(cacheKey!=null), which would normally be redundant, but this is a formalVerification of the system
	which must never read a null pointer (even to check if it is null).
	*/
	public final Node cacheKey;
		
	public Node(int hash, boolean isHalted, boolean isParentsFunc, boolean isDeterministic, boolean isFinite,
			Node func, Node param, Node stack, Node cacheKey){
		this.hash = hash;
		this.isHalted = isHalted;
		this.isParentsFunc = isParentsFunc;
		this.isDeterministic = isDeterministic;
		this.isFinite = isFinite;
		this.func = func;
		this.param = param;
		this.stack = stack;
		this.cacheKey = cacheKey;
	}
	
	public boolean isLeaf(){ return func==null; }
	
	public boolean isHalted(){ return isHalted; }
	
	public boolean isParentsParam(){ return stack!=null & !isParentsFunc; }
	
	/** isParentsFunc implies stack!=null */
	public boolean isParentsFunc(){ return isParentsFunc; }
	
	public int hashCode(){ return hash; }
	
	/* hash int32 must be derived from identityHashcode of all 3 Nodes and hashAndMask&mask. */
	public boolean equals(Object o){
		if(!(o instanceof Node)) return false;
		Node n = (Node)o;
		return hash==n.hash & isHalted==n.isHalted & isParentsFunc==n.isParentsFunc
			& isDeterministic==n.isDeterministic & isFinite==n.isFinite
			& func==n.func & param==n.param & stack==n.stack & cacheKey==n.cacheKey;
		/*return hash==n.hash & isLeaf==n.isLeaf & isHalted==n.isHalted & isParentsFunc==n.isParentsFunc
			& isParentsParam==n.isParentsParam & cacheKeyExists==n.cacheKeyExists
			& func==n.func & param==n.param & stack==n.stack & cacheKey==n.cacheKey;// && afterEval==n.afterEval && nondetResponse==n.nondetResponse;
		*/
	}
	
	public String toString(){
		if(this==Util.u) return ".";
		if(this==Util.I) return "I"; //this line must happen before F cuz I==(F .)
		if(this==Util.F) return "F";
		if(this==Util.T) return "T";
		if(this==Util.L) return "L";
		if(this==Util.R) return "R";
		if(this==Util.S) return "S";
		if(this==Util.A) return "A";
		if(this==Util.P) return "P";
		if(this==Util.N) return "N";
		String push = isHalted ? "(" : "{";
		String pop = isHalted ? ")" : "}";
		String s = push;
		/*Node normed = Util.asStackBottom(this);
		if(this == normed){
			String possiblySimplerDisplay = normed.toString();
			if(possiblySimplerDisplay.length()==1){
				s += possiblySimplerDisplay;
			}else{
				s += func+" "+param;
			}
		}else{
			s += func+" "+param;
		}*/
		s += func+" "+param;
		if(cacheKey != null) s += ", cacheKey="+cacheKey;
		if(stack != null){
			if(isParentsFunc) s += ",  funcStack="+stack;
			else s += ", paramStack="+stack;
		}
		s += pop;
		s = s.replace(") (",")(");
		s = s.replace("} {","}{");
		s = s.replace(". .","..");
		s = s.replace(") .",").");
		s = s.replace("} .","}.");
		s = s.replace("((..).).).)", "opPrefix");
		s = s.replace("F .", "I"); //cuz (F .)==I, but if it has stack then this!=Util.I
		s = s.replace("null null", "."); //cuz every leaf has param==null and func==null. Theres multiple leafs cuz it can be in multiple possible stack states.
		return s;
	}
	
	public static Node theUniversalFunction = Util.u;
	
	/** lazyEval of (this param). Halts instantly if at cardinality 0, else has infinite cost cuz BigO is infinity^cardinality */
	public Node f(Node param){
		return Util.f(this,param);
	}
	
	/** 1 compute step forward. Check isDone() to see if needs to step again else is the returned value. */
	public Node step(){
		return Util.step(this);
	}
	
	public boolean isDone(){
		return Util.isDone(this);
	}
	
	/** eval of (this param). WARNING: may never halt */
	public Node e(Node param){
		return Util.e(this,param);
	}

	public Node apply(Node param){
		return e(param);
	}

}
