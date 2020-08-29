package occamsfuncer.spec;

/** these are the childs of an 8-way-forest(all paths lead to the same leaf) node that affect its id,
if you include nodes during evaling, but if you only include isDone nodes then all you need is func and param childs.
This doesnt include isLeaf cuz thats 1 specific node, has a constant id for any idMaker.
Normally whats shared across untrusted borders (such as on p2p network)
is only the func and param binary forest of call pairs, leaving the other childs for evaling locally
and whats created by that evaling can be shared as its stack and cacheKey are null.
*/
public enum ChildType{
	
	/* UPDATE: will use bin.java for this later, and for now maybe the fn will take a concat of 4 params and a cbt4 or something like that,
	so even though fn cant see all the child fns, it can see their ids.
	<br><br>
	FIXME for ocfn to be able to create ids of callquads/callocts, using any custom id func,
	it must be only a binary forest, so use first param being (leaf leaf) to reflect callquads/callocts,
	and have those 1+8 curries include other callocts etc, and maybe use first param as leaf
	in cases when stack and cacheKey are null. Its more reflective that way.
	Without this, new idMakers can only create ids for halted funcs instead of callocts too,
	and you need callocts for eval.
	*/
	
	/** never null. If isLeaf(this) then this.func is IdentityFunc and this.param is this. */
	func,
	
	/** never null. If isLeaf(this) then this.func is IdentityFunc and this.param is this. */
	param,
	
	/** leaf if null. Nonnull if isParentsFunc|isParentsParam. */
	stack,
	
	/** leaf if null. Null only if isCacheKeyNull. */
	cacheKey,
	
	isHaltedAbove,
	
	isParentsFunc,
	
	isParentsParam,
	
	isCacheKeyNull;
	
	/*TODO make sure this is compatible with fprQuines doing tailRecursion which may be needed to close the quine.
	It probably is already and that would just be a small adjustment (if its not already compatible) in step func.
	*/

}
