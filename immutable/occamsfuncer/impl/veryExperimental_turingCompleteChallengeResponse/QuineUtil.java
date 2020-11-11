/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.impl.veryExperimental_turingCompleteChallengeResponse;
import immutable.occamsfuncer.fn;

public class QuineUtil{
	
	/*FIXME might need tailRecursion to make the callquads actually loop back to themself?
	Try it the simple way first. Tailrecursion would be a simple change of the step func
	to pop if the next lower thing on stack is just going to return whatever this returns in some very simple and direct way.
	Or it might be so small a stack that it doesnt even recurse like that,
	as its just calling (func param)->r and checking if (equals r correctReturn)
	then if they do returning the original quine (which bigCall ops during evaling already has pointer to itself by design).
	*
	
	public static fn simpleQuine = S.e(I).e(I).f(S.e(I).e(I));
	
	/** WARNING: may never halt, but only if (func param) doesnt halt. *
	public static fn quine(fn func, fn param){
		return quine(func, param, func.e(param));
	}
	
	/** This always halts, and the return value is a quine thats an infiniteLoop that you can step thru.
	Returns an evaling fn that if you step->step->...step, eventually comes back to itself, and during that
	proves (func param)->ret IF thats true. See comments in QuineEdge for details on turingCompleteChallengeResponse using that.
	*
	public static fn quine(fn func, fn param, fn ret){
		return lazyQuine(func,param,ret).f(u);
	}
	
	public static fn lazyQuine(fn func, fn param, fn ret){
		fn funcBody = TODO see comment in QuineEdge for what calculation the bigcall does;
		return e(bigCall4,funcBody,func,param,ret);
	}*/

}
