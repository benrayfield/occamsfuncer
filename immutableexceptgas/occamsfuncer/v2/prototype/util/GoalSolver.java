package immutableexceptgas.occamsfuncer.v2.prototype.util;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncer.v2.spec.fn;

public class GoalSolver{
	
	public static fn solver(){
		return Example.earlyExperimentalGoalSolver();
	}
	
	/** Example: (nondet . "solve" ST(Example.bitToDouble() Example.equals().f(x)))
	returns x, for any x, or runs out of Gas for being too stupid,
	since x is the only fn that causes it to return (double)1
	and all other possible params return (double)0.
	<br><br>
	The implementation of this requires AI,
	and later I plan to make the solver itself be a fn
	so the system can improve its own way of solving goals.
	<br><br>
	This is called by
	(nondet "solve")#solveGoal and (solveGoal aGoal .) returns solution else runs out of Gas.
	<br><br>
	Returns a fn solution where goal.f(solution).d()>0
	BUT that only has to be true during solving since it may
	depend on nondet ops such as measuring how good a solution it is
	in part by how much compute power it uses
	and that varies by whats cached at the time and
	what optimizations are live in fn.setCompiled(Compiled).
	<br><br>
	If you want it to have to score at least .7 for example
	then you wrap the goal in another goal that calls the inner goal
	and returns .7 less or something like that.
	<br><br>
	I'm undecided if the doubles will be range -1 to 1 or plus/minus infinity.
	<br><br>
	Tries to use the available Gas.top to do this,
	trying more things if it has more Gas,
	or maybe trying bigger things that cost more computing each,
	so if you want a solution that uses at most some amount of Gas
	(which is only approx as Gas costs vary by cache etc)
	then include that as part of the goal.
	<br><br>
	TODO this should in some cases use Cache.java and maybe even
	a longterm caching system on harddrive,'
	expecting for goals to themself call solve
	which calls solve and so on. Cycles are prevented by Gas.
	<br><br>
	(nondet "findHighScoringParamOfFuncOfParamToDouble")#solveGoal
	and (solveGoal aGoal .) returns solution else runs out of Gas.
	It is very much like goalFuncNamespace except I've relaxed the
	consistency constraint to it only has to score higher than 0 once
	ever (when the answer is generated). 
	*/
	public static fn solve(fn goal /*, fn salt*/){
		return solver().f(goal);
	}
	
	/*public static fn solve(fn goal){
		return solve(goal,leaf);
	}*/
	
	/*FIXME maybe salt should be part of goal
	such as in the comment of the goal or
	in a wrapper of the goal?
	*/

}