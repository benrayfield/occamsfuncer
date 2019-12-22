/** Ben F Rayfield offers this software opensource MIT license */
package mutable.util;
import java.security.SecureRandom;
import java.util.Random;

public class Rand{
	private Rand(){}
	
	public static final Random weakRand;
	public static final SecureRandom strongRand;
	public static final long comCostPerRandBit;
	static{
		strongRand = new SecureRandom();
		//TODO set seed as bigger byte array, more hashcodes to fill it maybe
		strongRand.setSeed(3+System.nanoTime()*49999+System.currentTimeMillis()*new Object().hashCode());
		weakRand = new Random(strongRand.nextLong());
		comCostPerRandBit = 234; //FIXME how much?
	}
	
	/** Uses SecureRandom and only an average of 2 random bits from it */
	public static boolean weightedCoinFlip(double chance){
		return weightedCoinFlip(chance, Rand.strongRand);
	}
	
	/** Consumes an average of 2 random bits (so its practical to use SecureRandom which is slow)
	by consuming random bits until get the first 1 then going directly to that digit
	in the chance as a binary fraction and returning it as the weighted random bit observe.
	TODO I wrote that code somewhere, copy it here so its more practical more often to use SecureRandom.
	*/
	public static boolean weightedCoinFlip(double chance, Random rand){
		if(chance < 0 || 1 < chance) throw new ArithmeticException("chance="+chance);
		while(rand.nextBoolean()){
			if(.5 <= chance) chance -= .5;
			chance *= 2;
		}
		return .5 <= chance;
	}

}
