package mutable.occamsfuncer.v2.spec;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import java.util.function.Function;

import immutableexceptgas.occamsfuncer.v2.spec.fn;
import mutable.util.Var;

/** a mutable object whose state, input, and output are each a fn.
Each call, updates its state.
Using the Var, you can (local to this JVM)
subscribe to changes of that state.
TODO should there also be subscribe for every call such as
a listener of (prevState param return nextState)
<br><br>
aState.f(param).f(T) is output.
aState.f(param).f(F) is nextState.
For example, return (pair output nextState).
(or is that backward?)
*/
public final class Mut implements Function<Object,fn>{
	
	public final Var<fn> state;
	
	public Mut(fn firstState){
		state = new Var(firstState);
	}
	
	public fn apply(Object in){
		fn aPair = state.get().f(in);
		fn out = aPair.f(T);
		fn nextState = aPair.f(F);
		state.set(nextState);
		return out;
	}

}
