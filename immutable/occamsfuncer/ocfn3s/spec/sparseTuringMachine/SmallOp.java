package immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine;

public enum SmallOp{
	
	/** Lx.Ly.Lz.z which does False and IdentityFunc. False is (opFI leaf). IdentityFunc is (False leaf). */
	opFI,
	
	/** Lx.Ly.Lz.y which does True aka K of SKI Calculus. True is (opT leaf). */
	opT,
	
	/** GetFunc/R of: Lx.Ly.Lz.(GetFunc z) and Lx.Ly.Lz.(GetParam z) where (GetFunc w (GetParam w)) equals w for any w other than the state of the stack
	and where (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf.
	*/
	opGetFunc,
	
	/** GetParam/R of: Lx.Ly.Lz.(GetFunc z) and Lx.Ly.Lz.(GetParam z) where (GetFunc w (GetParam w)) equals w for any w other than the state of the stack
	and where (GetFunc leaf) equals IdentityFunc and (GetParam leaf) equals leaf.
	*/
	opGetParam,
	
	/** Lx.Ly.Lz.(IsLeaf z) where IsLeaf returns True or False */
	opIsLeaf,
	
	/** Lx.Ly.Lz.zxy aka Pair */
	opPair,
	
	/** Lx.Ly.Lz.xz(yz) aka S of SKI Calculus */
	opS,
	
	/** Cardinality is second of 10 params of universalFunc. Cardinality 0 is leaf. Cardinality 3 is (T (T (T leaf))), for example.
	Nondet op which varies depending on cardinality and at cardinality 0 is Lx.Ly.Lz.(S I I (S I I))
	aka infiniteLoop and at higher cardinalities: (nondet leaf leaf x) returns (after infinite time) T if (x leaf) halts else
	returns F. This is a deterministic transfinite call. (nondet leaf anyNonleaf x) is halted if (x leaf) would halt,
	else never halts, and thats how you make claims about math such as (pseudocode, there is a technical form...)
	exists possibleNpSolverInPTime forAll possibleSetOfIntegersToSubsetSum funcToCheckIfItSolvesItWithinGivenNumberOfEmulatedCycles,
	or you could also claim the NOT of that to say P does not equal NP, and these kind of questions would possibly be
	answerable depending on what axioms are tried in forkEdits of emulators of this system which implement the nondet
	op at higher cardinalities in some cases in finite time and in most cases still costing infinite time, but if its
	a question its best to use (nondet leaf leaf x) to ask the question of does it halt instead of to claim a <func,param,return>.
	This is a deterministic transfinite call. (nondet anyNonleaf anything anything) is the normal 3 param nondet that you find
	in ocfn2 such as for wallet, spend, ocfnplug, mutableWrapperLambda, and goalFuncNamespace calls. truncateToCardinality
	Happens for every param to at highest the same cardinality as this one, UNLESS its cardinality is leaf (the lowest) which
	is the baseCase. Params of (nondet leaf anything) have cardinality truncated to 1 lower than self's cardinality else self
	cardinality is leaf and (TODO choose 1, i think i did in godelituhedron*.txt but forgot what it was) its some constant
	(such as T or Leaf) or (s i i (s i i)). Think thru the design constraints and it will become clear which of those it needs
	to be, especially considering step func in cardinality 0 has to be Big(1).
	truncateToDeterministic (aDeterministicLambda aDeterministicLambda) evals as normal.
	*/
	opNondet;

}