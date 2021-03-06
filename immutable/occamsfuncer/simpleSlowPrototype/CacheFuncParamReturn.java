/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.simpleSlowPrototype;
import static immutable.occamsfuncer.simpleSlowPrototype.OcfnUtil.*;

import java.util.WeakHashMap;

import immutable.occamsfuncer.fn;

public class CacheFuncParamReturn{
	private CacheFuncParamReturn(){}
	
	/*CacheFuncParamReturn should be reduced to only doing dedup but not <isDeterministic,func,param,return> (fpr as callquad, see OcfnUtil.cacheVal(fn)),
	and the rest will be done by fn possibleCache param as in OcfnUtil.step(fn,fn)
	but redesigning past that see the meta ops fn OcfnUtil.lazyCall and fn OcfnUtil.step etc.
	*/
	
	/*TODO??? redesign CacheFuncParamReturn to use OcfnUtil.cacheVal(fn), to use fn as <func,param,return>,
	so caller of OcfnUtil.step(fn evalingState,fn possibleCache) would get possibleCache from here.
	The translation is, possibleCache==OcfnUtil.setCacheKey(map.get(cacheKey),cacheKey).
	
	Returns null if not cached.
	*/
	public static fn getCacheFn(fn cacheKey){
		return OcfnUtil.setCacheKey(map.get(cacheKey),cacheKey);
	}
	
	/*
	FIXME either do this (TODO below) asap or prove that if java garbcol is always continuous that it wont lose any cache items
	by them being a normed form (truncateToStackBottom etc, as used in step func) if the same cache item is needed multiple times
	in the same call such as in fibonacci implemented with either 0 or 2 recursive calls per call.
	//TODO cache <isDeterministic,func,param> -> <utcnanoTimeCacheLastUsed_or_counter,value> and garbcol the least recently used when need more memory.
	//isDeterministic is in NondetNode and is intentionally not knowable from fn cuz fn is deterministic so has the same id either way.
	//Use binheap datastruct for increasing utcnanoTimeCacheLastUsed_or_counter of cache nodes (affects up to log other cachenodes)?
	*/
	
	private static final WeakHashMap<fn,fn> map = new WeakHashMap();
	
	public static void put(fn call, fn ret){
		OcfnUtil.testForSimpleErrorsInCacheKeyInVM(call);
		
		
		/*FIXME throw if call (which may equal cacheKey or is supposed to always equal cacheKey? check ocfn2)
		is anything except {haltedX haltedY} or maybe also allow {haltedX haltedY c<{haltedX haltedY}>},
		where {...} means nonhalted, cuz its supposed to only be a way of
		storing the <isDeterministic,func,param> in <isDeterministic,func,param,return>.
		*/
		
		if(!ret.isDone()) throw new Error("return value !isDone: "+ret);
		//boolean allow = !call.isHalted && call.func.isHalted && call.param.isHalted && ret.isHalted
		//	&& !call.isParentsFunc && !call.isParentsParam()
		//	&& !ret.isParentsFunc && !ret.isParentsParam();
		//if(!allow) throw new Error("Not a normed <call,return>: call="+call+" ret="+ret);
		map.put(call, ret);
	}

	public static fn get(fn call){
		return map.get(call);
	}
	
	public static long howManyCached(){
		return map.size();
	}
	
	//WeakHashMap? slower but clears itself.
			
	//SoftReference? slower but java chooses when to garbcol each part of cache.

}
