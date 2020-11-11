/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.simpleSlowPrototype;
import static immutable.occamsfuncer.simpleSlowPrototype.OcfnUtil.u;

import java.util.Set;

import immutable.occamsfuncer.fn;

public final class Node implements fn{
	
	/*FIXME have these exact fields, counting isLeaf as measurable at lower level such as is its id a certain constant or ==leaf etc.
	(func param stack cacheKey isHaltedAbove isParentsFunc isParentsParam isCacheKeyNull) so its an 8WayForest, often storing just func and param and a byte, but sometimes storing 4 childs and a byte.
	If isLeaf then func is stored as null but is identityFunc, and param is stored as null but is leaf.
	If first param is leaf, then its the normal calloct (aka callquad) representing callpairs and stack states of them etc.
	If first param is T (then is true half of bloomfilter) and choose some constant (maybe leaf or (leaf leaf)) to REFLECT the callocts as func_param_callpairs, AND need some opcodes somewhere for doing every parts of step func including salt_func_param_return caching.
	WHAT IF DID THAT 8waytree AS BINARY TREE: (((leafbit leafbit)(leafbit leafbit))((func param)(stack cacheKey)))? Can optimize it similar to pairOfPairDepth in a way that actually hashes it the same way was going to, that puts 4 childs and a byte (or something like that) in a single sha3_256 cycle and can directly ask it for all those 8 childs.
	But it seems pointless since its not going to reflect those parts. Maybe best to keep it as octree: (func param stack cacheKey isHalted isParentsFunc isParentsParam isCacheKeyNull).
	*/
	
	/** reflect this node's (func param stack cacheKey isHaltedAbove isParentsFunc isParentsParam isCacheKeyNull)
	as (TODO choose a structure) something like...
	(((leafbit leafbit)(leafbit leafbit))((func param)(stack cacheKey))) as param after universalFunc's func param being (leaf leaf)
	which is a reflection area for callocts (aka callquad and some bits).
	*
	public Node reflect(){
		curry this sequence, but have to prove it to VM cant just call it the normal way[
			(leaf leaf).
			func, or [IdentityFunc or leaf, todo choose one] if func==null.
			param, or leaf if param==null.
			stack, or leaf if stack==null.
			cacheKey, or leaf if cacheKey==null.
			isHaltedAbove()?T:F.
			isCacheKeyNull()?T:F.
			isParentsFunc()?T:F.
			isParentsParam()?T:F.
		]
		FIXME, if isDone (stack==null && isHaltedAbove()) then use the first param being leaf which is where callpairs go?
		Or should they all be 8WayReflects?
	}*/
	
	//Choose, do I want λ to mean the interface or leaf?

	/** an optimization, not part of the spec */
	private final int hash;
	
	//this is only true for 1 node
	//public final boolean isLeaf;

	public final boolean isHalted;
	
	public final boolean isParentsFunc;
	
	//public final boolean isParentsParam;
	
	//public final boolean isCacheKeyNull;
	
	public final fn func;
	public fn func(){ return func; }
	
	public final fn param;
	public fn param(){ return param; }
	
	public final fn stack;
	public fn stack(){ return stack; }
	
	/** Is key in CacheFuncParamReturn and is original (func param) before forkEditing forExample (s x y z) becomes ((x z)(y z))
	so in that case cacheKey would be lazy (s x y z) whose 2 halted childs are (s x y) and z.
	Without CacheFuncParamReturn, this software would cost exponential time. With it, same BigO as RandomAccessMachine.
	In other implementations (than this sparseTuringMachine very basic one), CacheFuncParam will only be used on
	less than 1% of objects, expecially excluding the middle calculations of OpenCL/GPU and javassist optimizations.
	OLD: cacheKeyExists==(cacheKey!=null), which would normally be redundant, but this is a formalVerification of the system
	which must never read a null pointer (even to check if it is null).
	*/
	public final fn cacheKey;
	public fn cacheKey(){ return cacheKey; }
	
	
	
	
	/** null or (pair funcsCardinalityCountingDown paramsCardinalityCountingDown)
	TODO see comment in step func.
	*
	public final Node compareCardinality;
	*/
		
	public Node(int hash, boolean isHalted, boolean isParentsFunc, fn func, fn param, fn stack, fn cacheKey){
		this.hash = hash;
		this.isHalted = isHalted;
		this.isParentsFunc = isParentsFunc;
		this.func = func;
		this.param = param;
		this.stack = stack;
		this.cacheKey = cacheKey;
	}
	
	public fn u(){
		return OcfnUtil.u;
	}
	
	/** optimization of the default implementation which uses:
	u.e(u).e(u.e(u)).e(u).e(u).e(u.e(u)).e(u).e(u).e(u).e(u).e(u).e(u).e(u).e(u).e(u) as identityFunc
	which is cached in OcfnUtil.I, and fn u = u();
	This is part of fn interface cuz u().Func()==identityFunc(),
	and x.Func().e(x.Param()).equals(x) forall x, such as u is (identityFunc u) and identityFunc is (F u)
	and F is u.e(u).e(u.e(u)).e(u).e(u).e(u.e(u)).e(u).e(u).e(u).e(u).e(u).e(u).e(u).e(u).
	*/
	public fn identityFunc(){
		return OcfnUtil.I;
	}
	
	/** isLeaf */
	public boolean isLeaf(){ return func==null; }
	
	public boolean isHaltedAbove(){ return isHalted; }
	
	/** isParentsFunc implies stack!=null */
	public boolean isParentsFunc(){ return isParentsFunc; }
	
	/** isParentsParam */
	public boolean isParentsParam(){ return stack!=null & !isParentsFunc; }
	
	public boolean isCacheKeyNull(){ return cacheKey==null; }
	
	public int hashCode(){ return hash; }
	
	/* hash int32 must be derived from identityHashcode of all 3 Nodes and hashAndMask&mask. */
	public boolean equals(Object o){
		if(!(o instanceof Node)) return false;
		Node n = (Node)o;
		return hash==n.hash & isHalted==n.isHalted & isParentsFunc==n.isParentsFunc
			& func==n.func & param==n.param & stack==n.stack & cacheKey==n.cacheKey;
	}
	
	public String toString(){
		if(this==OcfnUtil.u) return ".";
		if(this==OcfnUtil.I) return "I"; //this line must happen before F cuz I==(F .)
		if(this==OcfnUtil.F) return "F";
		if(this==OcfnUtil.T) return "T";
		if(this==OcfnUtil.L) return "L";
		if(this==OcfnUtil.R) return "R";
		if(this==OcfnUtil.S) return "S";
		if(this==OcfnUtil.A) return "A";
		if(this==OcfnUtil.P) return "P";
		if(this==OcfnUtil.N) return "N";
		String push = isHalted ? "(" : "{";
		String pop = isHalted ? ")" : "}";
		String s = push;
		s += func+" "+param;
		if(cacheKey != null) s += " c<"+cacheKey+">";
		if(stack != null){
			if(isParentsFunc) s += " l<"+stack+">";
			else s += " r<"+stack+">";
		}
		s += pop;
		s = s.replace(") (",")(");
		s = s.replace("} {","}{");
		s = s.replace(". .","..");
		s = s.replace(") .",").");
		s = s.replace("} .","}.");
		s = s.replace("((((..).).).)", "opPrefix");
		s = s.replace("F .", "I"); //cuz (F .)==I, but if it has stack then this!=Util.I
		s = s.replace("null null", "."); //cuz every leaf has param==null and func==null. Theres multiple leafs cuz it can be in multiple possible stack states.
		s = s.replace("((opPrefix (..))(..))(..)", "N");
		return s;
	}
	
	public static final fn theUniversalFunction = OcfnUtil.u;
	
	/** lazyEval of (this param). Halts instantly if at cardinality 0, else has infinite cost cuz BigO is infinity^cardinality */
	public fn f(fn param){
		return OcfnUtil.f(this,param);
	}
	
	/** 1 compute step forward. Check isDone() to see if needs to step again else is the returned value. */
	public fn step(){
		return OcfnUtil.step(this);
	}
	
	public boolean isDone(){
		return stack==null && cacheKey==null && isHalted;
	}
	
	/** eval of (this param). WARNING: may never halt */
	public fn e(fn param){
		return OcfnUtil.e(this,param);
	}

	/** WARNING: may never halt */
	public fn apply(fn param){
		return e(param);
	}

	/** WARNING: may never halt */
	public fn e(){
		return OcfnUtil.eval(this);
	}

	public void setCompiled(Compiled c){
		throw new UnsupportedOperationException("Spec doesnt support optimizations other than whats needed for step func to be BigO(1).");
	}

	public Compiled getCompiled(){
		throw new UnsupportedOperationException("Spec doesnt support optimizations other than whats needed for step func to be BigO(1).");
	}

	/** null means dont know of any equal forest shapes as this node. If nonnull the set would have to include this Node */
	public Set<fn> twins(){
		return null;
	}

	/** dont use this optimization in this simpleSlowPrototype/spec implementation */
	public Object unwrap(){
		return null;
	}

	public long zigzag(){
		throw new Error("TODO return 1 if isCbt (ptr at root of this tree of bits), else return 0 (not a ptr into a blob). Ptr into a blob would be > 1, but dont do that optimization in this implementation.");
	}

	public DedupLevel dedupLevel(){
		return DedupLevel.dedupPerCallQuad;
	}

	public fn setDedupLevel(DedupLevel d){
		if(d == dedupLevel()) return this;
		throw new Error("TODO");
	}

	public boolean isMeta(){
		throw new Error("TODO for future metaOp expansion");
	}

	public boolean bitAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public byte byteAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public short shortAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public char charAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public int intAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public long longAt(long bitIndex){
		throw new Error("TODO cbt");
	}
	
	public float floatAt(long bitIndex){
		return Float.intBitsToFloat(intAt(bitIndex));
	}

	public double doubleAt(long bitIndex){
		return Double.longBitsToDouble(longAt(bitIndex));
	}
	
	public long bize(){
		throw new Error("TODO cbt");
	}

	public boolean isCbt() {
		throw new Error("TODO cbt");
	}

	public boolean isBitstring(){
		throw new Error("TODO cbt");
	}

	public fn w(Object wrapMe){
		throw new Error("TODO");
	}
	
	public long lid(){
		throw new RuntimeException("TODO");
	}

}
