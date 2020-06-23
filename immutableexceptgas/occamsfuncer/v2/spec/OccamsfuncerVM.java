package immutableexceptgas.occamsfuncer.v2.spec;

public interface OccamsfuncerVM{
	
	/** Give a random example of what this VM can optimize,
	such as certain S-forests of opencl-like code
	may be optimizable by opencl in some VMs,
	andOr ieee754 float and double math and int long byte primitives etc
	if represented in rawcbt or cbtbitstring
	or the (((..)(..)) contentTypeCbtBitstring valueCbtBitstring),
	or acyclicFlow music tools optimizations,
	or various compressed datastructs,
	or there could be a variety of possible things can optimize.
	All OccamsfuncerVMs must do the exact same calculations
	which get the same results precise to the last bit
	EXCEPT where those calculations use op.nondet while !Gas.forceDeterminism
	but if Gas.forceDeterminism then all calls of op.nondet must
	eval to (S I I (S I I)) which infinite loops.
	<br><br>
	randomSeed can be any fn.
	*/
	public default fn exampleOfOptimized(fn randomSeed){
		fn leaf = leaf();
		fn leafLeaf = leaf.f(leaf);
		fn opBit1 = leafLeaf.f(leaf);
		fn opBits11 = opBit1.f(opBit1);
		fn nondet = opBits11.f(opBits11);
		return nondet.f("VM").f("exampleOfOptimizedByAnyFnAsRandSeed").f(randomSeed);
	}
	
	/** the universal lambda function,
	which all possible softwares can be built from.
	For efficiency, you might use int[] float[] double[] etc
	as params of fn.f(Object) instead of just fn.f(fn),
	which wraps them in fn.
	*/
	public fn leaf();
	
	/** same as func.f(param) */
	public default fn call(fn func, fn param){
		return func.f(param);
	}
	
	/** same as func.f(param) */
	public default fn call(fn func, Object param){
		return func.f(param);
	}
	
	/** such as ImportStatic.f(ob) */
	public default fn wrap(Object ob){
		////since ImportStatic isnt reachable from occamsfuncerV2Spec
		//but leaf is, use leaf then discard the leaf part.
		return leaf().f(ob).R();
	}
	
	/** Normall a "stateful fn" is a stateless fn used this way:
	aState.f(anything).f(T) is nextState.
	aState.f(anything).f(F) is returnValue.
	That can be accomplished by
	aState.f(anything) returning (pair nextState returnValue)
	(or did I get those T and F and the params of pair backward?
	I know of course T returns the first and F returns the second)
	<br><br>
	The other purpose of setState(fn) and getState() is
	it prevents garbcol (garbage collection) of anything reachable from state,
	such as (TODO) if its stored on harddrive andOr internet longterm.
	*/
	public void setState(fn state);
	
	public fn getState();
	
	
	/** fills to maximum gas (that double can represent integers densely in,
	which is 1L<<53) and other fields in Gas.java etc
	such as forceDeterminism. TODO make this unambiguous.
	Also does softReset().
	*/
	public void hardReset();
	
	/** This is meant for use about 50 times per second,
	between each 2 video frames. It clears parts of cache, etc.
	TODO how much Gas should be available here? Should each video frame
	take from the gas allocated in hardReset() but just allow more to
	be taken each time as it works recursively by Wallet and Spend nondet calls?
	*/
	public void softReset();

}
