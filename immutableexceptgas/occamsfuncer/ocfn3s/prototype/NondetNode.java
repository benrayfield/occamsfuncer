/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.ocfn3s.prototype;

import immutable.occamsfuncer.ocfn3s.spec.fn;

/** fn is deterministic, including its stack. This is a layer above that which can forkEdit that stack depending if it
runs out of compute resources. Its not part of the ocfn spec but is needed for running the the wallet and spend calls at
practical speed, which technically you could very slowly do in the deterministic spec if you emulated the caching and garbcol
and counting of compute cost given various optimizations apply to different combos of objects at different costs,
This node remembers a gas limit, that however much gas you have must not fall below that limit in recursive calls else it takes
the alternate path. In ocfn2, the spend call takes 3 params: maxGasToSpend, doThisIfHaveEnoughHGas, elseDoThis
and returns either (doThisIfHaveEnoughHGas leaf) or (elseDoThis leaf).
I'm considering in this ocfn3 to remove the elseDoThis param and instead just return leaf in that case,
so you could choose a doThisIfHaveEnoughHGas that never returns leaf (such as returns (T (doThisIfHaveEnoughHGas leaf)))
which you would then check if its func is T and if so get the (doThisIfHaveEnoughHGas leaf) out of it,
or maybe it would return (T (doThisIfHaveEnoughHGas leaf)) or (F leaf).
The purpose of removing elseDoThis is it simplifies the controlflow so once controlflow comes down to a node
on the stack it doesnt go back up again on the alternate path, it returns either way.
<br><br>
There are potentially any number of nondeterministic ops that vary by occamsfuncerVM,
such as those which call java funcs whose name starts with ocfnplug,
mutableWrapperLambda, wallet, spend, etc. Try to keep most of the logic in the deterministic parts
and to only share deterministic parts across untrusted borders but within each computer
those deterministic parts can generate requests to do nondeterministic things
such as run some experimental downloaded untrusted code with at most a certain amount of gas risked on it
and of course its always sandboxed as long as the occamsfuncerVM's ocfnplug functions are correctly sandboxed
such as they might hook into an opencl optimized neuralnet system before the occamsfuncerVM
is upgraded to compile its deterministic parts to opencl.
Eventually I hope to do everything deterministicly except wallet, spend, and mutableWrapperLambda.
<br><br>
Text copied from GasNode before merged it into here:
Theres normally a linkedlist of NondetNodes as a stack, but only 1 GasNode pointing at top of that stack.
*/
public class NondetNode{
	
	/** This is ignored in all NondetNodes except stack top. When it pops back down, overwrites the gasTop in whatever it last was down there,
	which is an optimization to create less NondetNodes. The unoptimized form would be to keep them all 0 except stack top.
	node.gasLimit<=gasNow. Everything is prepay.
	*/
	public final long gasNow;
	
	/*FIXME should this go to 2 child fns or just 1?
	If 1, then spend call either evals to (someParam .) or .,
	but if 2 then it evals to (someParam .) or (elseParam .).
	*/
	
	/** FIXME should this be in a node above NondetNode so... GasNowNode->NondetNode->fn ? *
	public final long gasNow;
	*/
	
	/** (stack==null)||(stack.gasLimit<=gasLimit) */
	public final long gasLimit;
	
	/** down on the nondeterministic stack, similar to this.det.stack() except the nondeterministic stack can be shorter
	cuz not every det call is a wallet or spend etc call.
	*/
	public final NondetNode stack;
	
	/** deterministic stack state but its not always run by the spec if (leaf nonleaf...)
	but in (leaf leaf...) its always deterministic as that forces the nondet op to eval to (S I I (S I I)) aka infloop.
	*/
	public final fn det;
	
	public NondetNode(long gasNow, long gasLimit, NondetNode stack, fn det){
		this.gasNow = gasNow;
		this.gasLimit = gasLimit;
		this.stack = stack;
		this.det = det;
	}
	
	/** does as few of steps as it can without sacrificing optimizations,
	such as this might do a whole sequence of opencl ndrange kernel calls including matrix multiplies and backprops,
	which have to be done together to keep it at gaming-low-lag and efficient,
	or it might just do a single deterministic op such as a lazyEval step of the S lambda (of SKI Calculus).
	<br><br>
	This is nondeterministic as it depends on which things are cached and which optimizations are available.
	*
	public GasNode steps(){
		throw new Error("TODO");
	}*/

}
