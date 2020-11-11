/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.simpleSlowPrototype;
import java.util.function.UnaryOperator;

import immutable.occamsfuncer.fn;

public class Nondet{
	
	/** starts as a trivial func that always returns leaf */
	private static UnaryOperator<fn> rootOfPlugins = (fn n)->Node.theUniversalFunction;
	
	public static fn call(fn n){ return rootOfPlugins.apply(n); }
	
	public static UnaryOperator<fn> getRootOfPlugins(){ return rootOfPlugins; }
	
	/** this is how to add plugins at runtime. TODO this should be a func that checks for the first param of bigCall containing the nondet call,
	and use that as name of plugin, then give controlflow to that plugin, instead of adding plugins directly here.
	*/
	public static void setRootOfPlugins(UnaryOperator<fn> rop){
		rootOfPlugins = rop;
	}

}
