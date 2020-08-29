package occamsfuncer.impl.nondet;

public enum CostType{
	
	/** cost of starting to send any info to 1 more network address if it supports the occamsfuncer protocol and its robots.txt allows,
	to limit the number of peers each peer connects to, else they might flood the network.
	*/
	networkAddress,
	
	/** cost of sending or receiving 1 bit across network */
	networkBandwidth,
	
	/** cost of 1 unit of compute, maybe should be in units of time computing since gpu vs interpreted mode etc
	have very different efficiency.
	*/
	compute,
	
	/** cost of allocating 1 bit of memory. TODO what about freeing memory? Will have to experiment to figure that part out. */
	allocMem,
	
	/** recommended to use SSD drive cuz its many small parts, but any harddrive or memory stick will work */
	storeDrive,
	
	/** perComputerMoney for paying to increase recursiveExpireTime per node. Paid per time*nodeSizeInBits for the amount of time it increases.
	Cant increase expire time past child expire times, so must increase them first if you want to go past that,
	which the peer/server will offer a function to spend at most a chosen cost to increase all that for a chosen node else abort the operation,
	spending only the much smaller amount it took to look through those objects to find it could or couldnt be done,
	or maybe that it was partially done for some paths of childs but not reaching all the necessary childs. 
	*/
	storeRemote,
	
	/** pays for possibly limit amount of opencl functions or code size can compile, or maybe running in browser accessing gpu with GPU.js
	or maybe webasm will be upgraded to use GPU.
	*/
	gpuCompile,
	
	/** pays for possibly limited amount of cpu compiling such as javassist (works in any jdk or jre) or openjdk or oracle-proprietary-jdk
	or maybe its running in a browser so can compile to webasm (andOr maybe it will be upgraded to hook into GPU?).
	*/
	cpuCompile;

}
