package occamsfuncer.impl.fn;

import occamsfuncer.fn;

/** A function or snapshot of stack state of evaling. A call quad [func, param, stack, cacheKey] with
various fields stored in a long including bitstringSize, isHalted, isParentsFunc, numCurries(0-15), etc.
*/
public class Call implements fn{

	public fn apply(fn x){
		throw new Error("TODO");
	}

	public fn f(fn param){
		throw new Error("TODO");
	}

	public fn e(){
		throw new Error("TODO");
	}

	public fn func(){
		throw new Error("TODO");
	}

	public fn param(){
		throw new Error("TODO");
	}

	public fn stack(){
		throw new Error("TODO");
	}

	public fn cacheKey(){
		throw new Error("TODO");
	}

	public void setCompiled(Compiled c){
		throw new Error("TODO");
	}

	public Compiled getCompiled(){
		throw new Error("TODO");
	}

	public boolean isLeaf(){
		throw new Error("TODO");
	}

	public boolean isHaltedAbove(){
		throw new Error("TODO");
	}

	public boolean isDone(){
		throw new Error("TODO");
	}

	public boolean isParentsFunc(){
		throw new Error("TODO");
	}

	public boolean isParentsParam(){
		throw new Error("TODO");
	}

}