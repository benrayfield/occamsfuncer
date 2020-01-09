package mutable.occamsfuncerV2;
import static immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic.*;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import immutableexceptgas.occamsfuncerV2.fn;
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
