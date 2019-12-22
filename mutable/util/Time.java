/** Ben F Rayfield offers this software opensource MIT license */
package mutable.util;

import java.text.DecimalFormat;

public class Time{
	private Time(){}
	
	/*
	@Deprecated //TODO replace with nanoOffset
	public static final long startMillis;
	
	@Deprecated //TODO replace with nanoOffset
	public static final long startNano;
	*/
	
	public static final long nanoOffset;
	
	//public static final int secondsPerDay = 24*60*60;
	
	protected static final DecimalFormat secondsFormat  = new DecimalFormat("0000000000.0000000");
	
	static{
		long startMillis = System.currentTimeMillis();
		long startNano = System.nanoTime();
		//nanoOffset = startNanoxxxx
		/*nowSeconds = .001*startMillis + 1e-9*nanoDiff;
		nowNano = nowSeconds*1e9
		nowNano = (.001*startMillis + 1e-9*nanoDiff)*1e9
		nowNano = (.001*startMillis*1e9 + nanoDiff)
		nowNano = startMillis*1000000 + nanoDiff
		nanoDiff = System.nanoTime()-startNano
		nowNano = startMillis*1000000 + (System.nanoTime()-startNano);
		*/
		nanoOffset = startMillis*1000000 - startNano;
		//nowNano = nanoOffset+System.nanoTime(); (this code goes in nowNano())
	}
	
	/** Seconds since year 1970 UTC
	with relative nanosecond precision (System.nanoTime)
	and absolute few milliseconds precision (System.currentTimeMillis).
	<br><br>
	Practically, at least in normal computers in year 2011, this has about microsecond precision
	because you can only run it a few million times per second.
	TODO test it again on newer computers.
	*/
	public static double now(){
		return nowNano()*1e-9;
		/*
		//TODO optimize by caching the 2 start numbers into 1 double
		long nanoDiff = System.nanoTime()-startNano;
		return .001*startMillis + 1e-9*nanoDiff;
		*/ 
	}
	
	private static long lastTimeId = Long.MIN_VALUE;
	
	/** nowNano()/1e9 means the same time as (double)now(), except roundoff and lag */
	public static long nowNano(){
		return nanoOffset+System.nanoTime();
	}
	
	/** max of number of nanoseconds since year 1970 UTC vs the last value returned + 1.
	This can practically allocate a million ids per second
	and in theory a billion per second */
	public static synchronized long timeId(){
		//long utcNanoseconds = System.nanoTime()-startNano;
		return lastTimeId = Math.max(lastTimeId+1, nowNano());
	}
	
	/** returns the last in a block of timeIds.
	Example:
	long wId = timeId();
	long yId = blockOfTimeIds(2);
	long xId = yId-1;
	long zId = timeId();
	If param is big, you might have to wait 
	*/
	public static synchronized long timeIds(int blockSize){
		if(blockSize < 0) throw new Error("neg");
		lastTimeId += blockSize;
		return lastTimeId;
	}
	
	public static String nowStr(){
		return timeStr(now());
	}
	
	public static String timeStr(double time){
		return secondsFormat.format(time);
	}
	
	/** Uses Thread.sleep(milliseconds,nanoseconds) for extra accuracy,
	but don't count on Java running threads often enough to use the extra accuracy on all computers.
	*/
	public static void sleep(double seconds) throws InterruptedException{
		if(seconds <= 0) return;
		double millis = seconds*1e3;
		long millisL = (long)millis;
		millis -= millisL;
		double nanos = millis*1e6;
		int nanosI = (int)Math.round(nanos);
		Thread.sleep(millisL, nanosI);
	}
	
	public static void sleepNoThrow(double seconds){
		try{
			sleep(seconds);
		}catch(InterruptedException e){}
	}

}