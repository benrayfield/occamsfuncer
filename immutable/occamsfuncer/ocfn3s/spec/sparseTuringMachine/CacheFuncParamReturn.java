package immutable.occamsfuncer.ocfn3s.spec.sparseTuringMachine;

import java.util.WeakHashMap;

/** Copied this comment from Node.stack's comment[
While this logic alone is turingComplete, it would take an exponential number of compute cycles to do
a linear amount of work without the following optimization (which gives it the same Big-O as a random access machine)...
OPTIMIZATION: Map of Node x to Node y where
!x.isHalted&&x.func.isHalted&&x.param.isHalted&&y.isHalted&&x.stack==null&&y.stack==null&&x.eval().equals(y);
Once per step, avoid duplicating a call by checking if that call is in the Map and returning the value it maps to if so,
else push the lazy (!isHalted) call onto stack as usual. A variant of this is working in occamsfuncerV1 and occamsfuncerV2.	
]
*/
public class CacheFuncParamReturn{
	private CacheFuncParamReturn(){}
	
	private static final WeakHashMap<Node,Node> map = new WeakHashMap();
	
	public static void put(Node call, Node ret){
		//boolean allow = !call.isHalted && call.func.isHalted && call.param.isHalted && ret.isHalted
		//	&& !call.isParentsFunc && !call.isParentsParam()
		//	&& !ret.isParentsFunc && !ret.isParentsParam();
		//if(!allow) throw new Error("Not a normed <call,return>: call="+call+" ret="+ret);
		map.put(call, ret);
	}

	public static Node get(Node call){
		return map.get(call);
	}
	
	public static long howManyCached(){
		return map.size();
	}
	
	//WeakHashMap? slower but clears itself.
			
	//SoftReference? slower but java chooses when to garbcol each part of cache.

}
