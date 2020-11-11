package immutable.occamsfuncer.impl.nondet;

public class NondetUtil{
	
	/** current amount of NondetNode.addToGas it costs for 1 unit of CostType.
	This allows a single currency (which only works on this local computer, not a cryptocurrency, but maybe use Raiden network etc later)
	to be used for allocating multiple kinds of computer-related resources such as compute cycles, memory, and network bandwidth.
	*/
	public static float cost(CostType t) {
		throw new Error("TODO");
	}
	
	/** cost (in units of NondetNode.addToGas) of allocating 1 more bit of memory.
	The cost of compute cycles may be the backing for gas so 1 gas is 1 unit of compute,
	which maybe should be measured in units of time since different optimizations
	used together have very different efficiency, like GPU number crunching might be
	a million times faster than occamsfuncer interpreted mode due to cache misses of memory jumping.
	TODO optimize, should this be an int in units of 1/64k of a compute unit, for faster multiply?
	*
	public static final float memCost;
	
	public static final long cost(long compute, long mem){
		return compute+(long)(memCost*mem);
	}
	
	public static final long memCost(long mem){
		return (long)(memCost*mem);
	}
	
	public static final long cost(long compute, long mem){
		return compute+memCost(mem);
	}
	
	//TODO also cost for other things, including:
	//* possibly limited number of compiles in opencl and javassist
	//* various kinds of storage, reading and writing (only cache, since everythings a constant)
	//* use of speakers and microphones
	*/

}
