package occamsfuncer.impl.optimize.fpr;

import occamsfuncer.fn;

public class CacheFuncParamReturn{
	
	/*TODO continuously garbcol cache entries by long lastTimeUsed,
	or just use the long as a counter.
	<isZeroKelvin,func,param,return,longLastTimeUsed>
	*/
	
	/** null if result of that call is not cached */
	public static fn get(boolean isZeroKelvin, fn func, fn param){
		throw new Error("TODO copy the Map code from other CacheFuncParamReturn");
	}

	/** same as get(cacheKey.func(), cacheKey.param())
	but TODO verifies cacheKey has no stack and those 2 childs isHaltedAbove
	and self !isHaltedAbove cuz means to call one on the other
	*/
	public static fn get(boolean isZeroKelvin, fn cacheKey){
		throw new Error("TODO copy the Map code from other CacheFuncParamReturn");
	}
	
	/*&FIXME does isZeroKelvin go in fn cacheKey? For twoThingsIntoOne it probably does,
	but in the earlier design it only goes in FPR cache entry.
	The relation between those 2 designs is
	func=x.cacheKey.L
	param=x.cacheKey.R
	ret=(x.L x.R) //aka OcfnUtil.truncateToStackBottom(x)
	but only if x.stack==null and x.L.isHalted and x.R.isHalted and !x.isHalted
	//x.L means x.func, and x.R means x.param
	*/

}
