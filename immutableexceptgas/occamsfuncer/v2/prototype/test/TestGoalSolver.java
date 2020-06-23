package immutableexceptgas.occamsfuncer.v2.prototype.test;
import static immutableexceptgas.occamsfuncer.v2.prototype.test.TestBasics.*;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncer.v2.prototype.util.Example;
import immutableexceptgas.occamsfuncer.v2.prototype.util.GoalSolver;
import immutableexceptgas.occamsfuncer.v2.spec.fn;

public class TestGoalSolver{
	
	public static void testFindWhatEquals(fn equalsThis){
		fn solver = GoalSolver.solver();
		fn goal = ST(Example.bitToDouble(),Example.equals().f(equalsThis));
		fn solution = solver.f(goal);
		testEqq("testFindWhatEquals_1", equalsThis, solution);
	}
	
	public static void main(String[] args){
		testFindWhatEquals(leaf.f(leaf));
		testFindWhatEquals(w("hello"));
		
		/*thinkOfAnAmazingTestcaseForOcfnGoalSolveToWorkTowardLongterm QUOTE[
			TODO write testcases for this, something more interesting
			than finding something than the equals example,
			something that shows what AI is really about
			as it would use solutions to things to find solutions
			to harder things.
			How about defining matrix multiply in test cases
			and finding a general matrix multiply algorithm?
			Good start, but since Humans already have well optimized
			matmul, I want something more interesting.
			How about a function of (y,x) to brightness
			that has certain brightnesses at certain (y,x)
			so the task would be to find an image which,
			without adding much unnecessary complexity,
			has those pixels, so like AIXI it would (if implemented smartly)
			predict simpler patterns exponentially more often
			than complex patterns,
			but only those that predict the things tested for,
			and the interesting part is what else they predict
			for things not included in the tests.
			
			Also when testing its ability to find a matrix multiplier function,
			integrate with OccamsParallelComputeSandbox
			so it can safely generate opencl code
			while still being in sandbox and obeying Gas limits etc.
			
			But first, think of a testcase that if solved would
			demo what AI is really about, something that goes beyond
			what a Human could figure out but Human will still understand
			the solution to and find it fun or useful for something.
			Dont have to solve it yet, just a far future testcase
			to work toward, that if its solved, occamsfuncer will be known
			to be a killerapp as it can solve that and a variety of
			equally difficult goal funcs.
			Make sure its something where the solution has to call solve
			on subtasks and measuring and evolving code in turingComplete combos
			cuz its so selfReferencing a problem.
		]*/
		
	}

}
