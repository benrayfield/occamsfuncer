package immutable.occamsfuncer.simpleSlowPrototype.lang;

import java.util.List;
import java.util.Stack;
import java.util.function.Function;

import immutable.occamsfuncer.fn;

/** parser and tostringer of a suggested language for fns (occamsfuncer objects),
which uses ( ) as CurryList, { } as SCurryList, and [ ] as linkedlist,
which are all made of combos of calls of the universal func (u) on itself.
It uses ```x to mean (T (T (T x))), often used as {`x y z}.
<br><br>
TODO implement this as fns itself, but it would be useful to have a working syntax at runtime
before writing the parser and tostringer for it in it,
keeping in mind that for a fn to be a map key it needs to be hashed which is slow,
but there are some optimizations planned to avoid hashing the middle steps.
*/
public class Lang{
	private Lang(){}
	
	/*TODO create the language only using (((...)((...)...))#name . (... name ````name . `(..) name) name ``name . (..)) etc
	(except dont even need ` at that level), and all ( ) calls are of 2 things, or even simpler use unlambda` currying syntax with # at that level.
	then define transforms of it (done abstractly, not actually creating this longer string form) to also have [] and {}.
	In that way, can store it in a file of 64 bit nodes, where each node is 2 int32 pointers (always pointing lower than itself) into long[].
	Or use 64 bit ids and store: [hashBucket id leftChildId rightChildId].
	*/
	
	//public 
	
	/** Code is something like this string (todo still experimenting with possible syntaxs):
		(lambda2 (IF
			{`A p14} //if p9 is leaf
			(thenT A p15) //then return: p10 is leaf?
			(then (IF //else if
				{`A p15} //if p10 is leaf?
				(thenConst F) //then return F
				(thenT //else return AND of recurse 2 times on the left of both params and right of both params
					?and
					{recur2 {`L p14} {`L p15}}
					{recur2 {`R p14} {`R p15}}
				)
			))
		))
		
		[a b [x y z]#rr c rr rr] is an example of a fn being multiple places aka shared forest branch, a shared pointer or (until dedup) duplicate.
		Its [a b [x y z] c [x y z] [x y z]] and the #rr has no effect on id or equals.
		
		(a b c) equals ((a b) c)
		{x y z} equals {{x y} z} equals (S (S x y) z)
		[a b c] equals (pair a [b c])
		
		Every object is a constant. There are no variables, but you can forkEdit treemaps like namespace if you call get,
		and the treemap and get funcs etc are all derived from combos of universal func called on itself.
		
		There should be no builtin func names like lambda2, thenT, thenConst, recur2, etc.
		All of those should be derived from universalFunc and #localNamed.
		
		So can start with only the universal func and the ( ) { } [ ] ` syntax, and build anything.
		
		Maybe should represent this as a certain byte as the kind of display of each fn (which has 2 childs, excluding simulating the stack),
		like is it still a linkedlist [ ] or is it still a SCurryList { } such as does it have S and leaf/nil in all the right places.
		
		Every (...) or {...} or [...] is a function and can put any of them in eachother as varargs in all possible combos
		which each refer to a specific forest of call pairs all leading to the same leaf.
		
		I want a UI where any of those can be opened or closed like a JTree but having multiple branches on one line where it fits.

	*/
	public static fn parse(String code, Function<String,fn> namespace){
		List<String> tokens = tokenize(code);
		Stack<String> stack = new Stack(); //contains any of: ( ) { } [ ], and maybe (todo?) every other token
		int tLevel = 0; //last n chars were ` like ``x means (T (T x))
		/*for(String token : tokens){
			
		}
		/*TODO put comments like "then return: p10 is leaf?" in the comment param of nearly every func.
		Only very short funcs dont have a comment param, considering the universal func always takes 15 params
		and the param index of the comment varies based on the first 5 params each being leaf vs nonleaf.
		
		TODO*/
		throw new RuntimeException("TODO");
	}
	
	/** todo kinds of sparsity display. FIXME at shared branches might need to create names for them so can refer to that name
	instead of displaying them more than once which could result in exponential size code.
	 */
	public static String toString(fn x, Function<fn,String> namespace){
		throw new RuntimeException("TODO");
	}

	/** examples of tokens: ( ) { } [ ] ` A thenConst abc xyz ?and */
	public static List<String> tokenize(String code){
		throw new RuntimeException("TODO");
	}

}
