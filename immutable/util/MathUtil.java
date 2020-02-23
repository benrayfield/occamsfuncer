/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleUnaryOperator;

public class MathUtil{
	
	//TODO merge multiple MathUtil classes
	
	public static double sigmoid(double x){
		return 1/(1+Math.exp(-x));
	}
	
	/*public static double bisigmoid(double x){
		//reutrn sigmoid(x)
		tanh
	}*/
	
	/** bellcurve height scaled so max is 1 */
	public static double zbell(double stdDev){
		return Math.exp(-stdDev*stdDev/2);
	}
	
	public static int indexOfMax(double[] d){
		int m=0;
		for(int i=1; i<d.length; i++){
			if(d[m] < d[i]) m = i;
		}
		return m;
	}
	
	//public static final double veryPositive = Double.MAX_VALUE/0x1000000;
	
	//public static final double veryNegative = -veryPositive;
	
	/** If fraction is 0, returns -Infinity. If 1, returns Infinity.
	Derivation:
	s = 1/(1+e^-x).
	s*(1+e^-x) = 1.
	1+e^-x = 1/s.
	e^-x = 1/s - 1.
	-x = logBaseE(1/s - 1).
	x = -logBaseE(1/s - 1).
	//
	x = -logBaseE(1/s - 1).
	x = -logBaseE(1/s - s/s).
	x = -logBaseE((1-s)/s).
	x = logBaseE(s/(1-s)).
	//
	aka x = Math.log(s/(1-s)) which "A Practical Guide to Training Restricted Boltzmann Machines" recommends for bias.
	*/
	public static double inverseSigmoid(double fraction){
		//x = -logBaseE(1/s - 1)
		//if(s == 0) return .5; //TODO verify this is on the curve
		//if(fraction == 0) return veryNegative; //TODO verify this is on the curve
		return -Math.log(1/fraction - 1);
	}
	
	public static double derivativeOfSigmoid(double x){
		double s = sigmoid(x);
		return s*(1-s);
	}
	
	public static void main(String args[]){
		//testPermutate();
		testSigmoidAndItsInverse();
		//testWeightedCoinFlip();
	}
	
	/** no Rand allowed in immutable package
	public static void testWeightedCoinFlip(){
		System.out.print("Testing weightRandomBit...");
		for(double targetChance=0; targetChance<1; targetChance+=.03){
			int countZeros = 0, countOnes = 0;
			for(int i=0; i<100000; i++){
				if(weightedCoinFlip(targetChance,Rand.strongRand)) countOnes++;
				else countZeros++;
			}
			double observedChance = (double)countOnes/(countZeros+countOnes);
			System.out.println("targetChance="+targetChance+" observedChance="+observedChance);
			if(Math.abs(targetChance-observedChance) > .01) throw new RuntimeException("targetChance too far from observedChance");
		}
	}*/
		
	public static void testSigmoidAndItsInverse(){
		System.out.println("Testing sigmoid and inverseSigmoid");
		double epsilon = 1e-12;
		for(double s=0; s<=1; s+=1./64){
			double x = inverseSigmoid(s);
			double ss = sigmoid(x);
			System.out.println("s="+s+" x="+x+" ss="+ss);
			if(Math.abs(s-ss) > epsilon) throw new RuntimeException("s != ss and is not close");
		}	
	}
	
	/** no Rand allowed in immutable package
	/** Uses SecureRandom and only an average of 2 random bits from it *
	public static boolean weightedCoinFlip(double chance){
		return weightedCoinFlip(chance, Rand.strongRand);
	}*/
	
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
	
	public static boolean isPowerOf2(long i){
		return i>0 && (i&(i-1)) == 0;
	}
	
	public static double[] cat(double[]... arrays){
		int lenSum = 0;
		for(double[] array : arrays) lenSum += array.length;
		double[] ret = new double[lenSum];
		int filled = 0;
		for(double[] array : arrays){
			System.arraycopy(array, 0, ret, filled, array.length);
			filled += array.length;
		}
		return ret;
	}
	
	public static void normBySortedPointers(double min, double max, double[] d){
		normBySortedPointers(min, max, d, sortedPointersInto(d));
	}
	
	/** If you already have sortedPointers(d) */
	public static void normBySortedPointers(double min, double max, double[] d, int[] pointers){
		int siz = d.length;
		double range = max-min;
		for(int i=0; i<siz; i++){
			double fraction = (double)i/(siz-1);
			d[pointers[i]] = min+fraction*range;
		}
	}
	
	/** Example: normBySortedPointers data in arbitrary range, run neuralnet on it,
	then normBySortedPointersInverse to put neuralnet's output back into that same spread of data
	but a different permutation of it.
	*/
	public static void normBySortedPointersInverse(double[] d, int[] pointers){
		double[] inverse = new double[d.length];
		for(int i=0; i<d.length; i++){
			inverse[i] = d[pointers[i]];
		}
		System.arraycopy(inverse, 0, d, 0, d.length);
	}
	
	public static void normBySortedPointers(DoubleUnaryOperator curve, float[] d){
		int siz = d.length;
		int pointers[] = sortedPointersInto(d);
		for(int i=0; i<siz; i++){
			double fraction = (double)i/(siz-1);
			d[pointers[i]] = (float)curve.applyAsDouble(fraction);
		}
	}
	
	
	/** curve receives a fraction and returns the new double */
	public static void normBySortedPointers(DoubleUnaryOperator curve, double d[]){
		int siz = d.length;
		int pointers[] = sortedPointersInto(d);
		for(int i=0; i<siz; i++){
			double fraction = (double)i/(siz-1);
			d[pointers[i]] = curve.applyAsDouble(fraction);
		}
	}
	
	public static int[] sortedPointersInto(float d[]){
		return sortedPointersInto_tryingToImproveSpeed(d);
	}
	
	public static int[] sortedPointersInto(double d[]){
		return sortedPointersInto_tryingToImproveSpeed(d);
	}
	
	public static strictfp int[] sortedPointersInto(final long d[]){
		Integer Ints[] = new Integer[d.length];
		for(int i=0; i<d.length; i++) Ints[i] = i;
		Comparator<Integer> compare = new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				long xd = d[x], yd = d[y];
				if(xd < yd) return -1;
				if(xd > yd) return 1;
				return 0;
			}
		};
		Arrays.sort(Ints, compare);
		int ints[] = new int[d.length];
		for(int i=0; i<d.length; i++) ints[i] = Ints[i];
		return ints;
	}
	
	public static int[] sortedPointersInto_tryingToImproveSpeed(final double d[]){
		/*int pointers[] = new int[d.length];
		for(int i=0; i<d.length; i++) pointers[i] = i;
		//TODO? Arrays.parallelSort(arg0);
		*/
		
		/*for(int i=0; i<d.length; i++){
			double x = d[i];
			if(x != x){ //NaN, because it may be causing sorting inconsistency
				d[i] = Double.MAX_VALUE;
			}
		}*/
		
		Integer Ints[] = new Integer[d.length];
		for(int i=0; i<d.length; i++) Ints[i] = d.length-1-i;
		Comparator<Integer> compare = new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				double xd = d[x], yd = d[y];
				if(xd < yd) return -1;
				if(xd > yd) return 1;
				return 0;
			}
		};
		/*while(true){
			try{
				Arrays.sort(Ints, compare);
				break;
			}catch(Exception e){
				System.out.println("This is probably 'Comparison method violates its general contract' which strictfp avoids always singlethreaded but it appears some thread is using it, but which one could it be since its a local var? For now, since it happens only 1 20000 times its faster to just catch this and do it again those times. TODO find that thread and synchronize here and there! "+e.getMessage());
				e.printStackTrace(System.out);
			}
		}*/
		Arrays.sort(Ints, compare);
		int ints[] = new int[d.length];
		for(int i=0; i<d.length; i++) ints[i] = Ints[i];
		return ints;
	}
	
	public static int[] sortedPointersInto_tryingToImproveSpeed(final float d[]){
		/*int pointers[] = new int[d.length];
		for(int i=0; i<d.length; i++) pointers[i] = i;
		//TODO? Arrays.parallelSort(arg0);
		*/
		
		/*for(int i=0; i<d.length; i++){
			double x = d[i];
			if(x != x){ //NaN, because it may be causing sorting inconsistency
				d[i] = Double.MAX_VALUE;
			}
		}*/
		
		Integer Ints[] = new Integer[d.length];
		for(int i=0; i<d.length; i++) Ints[i] = d.length-1-i;
		Comparator<Integer> compare = new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				double xd = d[x], yd = d[y];
				if(xd < yd) return -1;
				if(xd > yd) return 1;
				return 0;
			}
		};
		/*while(true){
			try{
				Arrays.sort(Ints, compare);
				break;
			}catch(Exception e){
				System.out.println("This is probably 'Comparison method violates its general contract' which strictfp avoids always singlethreaded but it appears some thread is using it, but which one could it be since its a local var? For now, since it happens only 1 20000 times its faster to just catch this and do it again those times. TODO find that thread and synchronize here and there! "+e.getMessage());
				e.printStackTrace(System.out);
			}
		}*/
		Arrays.sort(Ints, compare);
		int ints[] = new int[d.length];
		for(int i=0; i<d.length; i++) ints[i] = Ints[i];
		return ints;
	}
	
	/** Fast because it leaves it the complexity of NaN and positive/negative zero.
	TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM?
	*/
	public static double max(double x, double y){
		return x>y ? x : y;
	}
	
	public static float max(float... a){
		if(a.length == 0) throw new Error("empty array");
		float max = -Float.MAX_VALUE;
		for(float f : a) max = Math.max(f, max);
		return max;
	}
	
	public static float min(float... a){
		if(a.length == 0) throw new Error("empty array");
		float min = Float.MAX_VALUE;
		for(float f : a) min = Math.min(f, min);
		return min;
	}
	
	/** TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM? */
	public static float max(float x, float y){
		return x>y ? x : y;
	}
	
	/** Fast because it leaves it the complexity of NaN and positive/negative zero.
	TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM?
	*/
	public static double min(double x, double y){
		return x<y ? x : y;
	}
	
	/** TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM? */
	public static float min(float x, float y){
		return x<y ? x : y;
	}
	
	/** Same as max(minValue, min(value, maxValue))
	TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM?
	*/
	public static double holdInRange(double min, double value, double max){
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	/** TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM? */
	public static float holdInRange(float min, float value, float max){
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	/** TODO consider using java.lang.Math funcs instead of this in case its native optimized internal to JVM? */
	public static int holdInRange(int min, int value, int max){
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}

	public static int firstPowerOf2AtLeast(int i){
		//TODO this can be done in log steps. YES, wheres that code? Somewhere in the xorlisp experimental code.
		//Also related is Long.highestOneBit and Long.lowestOneBit.
		//This can be done with log number of if statements and bit shifts by half as many bits each time.
		int j = 1;
		int powerOf2 = 0;
		while(j < i){
			powerOf2++;
			j <<= 1;
		}
		return powerOf2;
	}

	public static int lastPowerOf2NotExceeding(int i){
		//TODO this can be done in log steps. YES, wheres that code? Somewhere in the xorlisp experimental code.
		//Also related is Long.highestOneBit and Long.lowestOneBit.
		//This can be done with log number of if statements and bit shifts by half as many bits each time.
		int j = 1;
		int powerOf2 = 0;
		while(j <= i){
			powerOf2++;
			j <<= 1;
		}
		return powerOf2-1;
	}
	
	public static double vectorLengthDyDx(double dy, double dx){
		return Math.sqrt(dy*dy + dx*dx);
	}
	
	public static double dotProd(double x[], double y[]){
		if(x.length != y.length) throw new RuntimeException("Arrays must be same size");
		double sum = 0;
		for(int i=0; i<x.length; i++) sum += x[i]*y[i];
		return sum;
	}
	
	/** useful in contrastiveDivergence and backprop */
	public static void addMultOfSameSize1dArraysIntoSquareArray(double x[], double y[], double square[][]){
		final int siz = x.length;
		if(siz!=y.length || siz!=square.length || siz!=square[0].length)
			throw new RuntimeException("Arrays must be same size");
		for(int i=0; i<siz; i++){
			final double mult = x[i];
			for(int j=0; j<siz; j++){
				square[i][j] += mult*y[j];
			}
		}
	}
	
	public static double len(double vec[]){
		double sumOfSquares = 0;
		for(double d : vec) sumOfSquares += d*d;
		return Math.sqrt(sumOfSquares);
	}
	
	/** sum of absvals */
	public static double lenManhattan(double vec[]){
		double sum = 0;
		for(double d : vec) sum += Math.abs(d);
		return sum;
	}
	
	/*public static double[] eachFourHexDigitsToScalar(String hex){
		double d[] = new double[hex.length()/4];
		for(int i=0; i<d.length; i++){
			int uint16 = Integer.parseInt(hex.substring(i*4,(i+1)*4), 16);
			d[i] = ((double)uint16-(1<<15))/(1<<15);
		}
		return d;
	}*/
	
	public static boolean readBit(byte b[], int index){
		return (b[index>>3] & (128>>(index&7))) != 0;
	}
	
	public static void writeBit(byte b[], int index, boolean value){
		if(value) b[index>>3] |= (128>>(index&7));
		else b[index>>3] &= ~(128>>(index&7));
	}
	
	public static double ave(double d[]){
		return sum(d)/d.length;
	}
	
	public static float ave(float d[]){
		return sum(d)/d.length;
	}
	
	public static double sum(double d[]){
		double sum = 0;
		for(double dd : d) sum += dd;
		return sum;
	}
	
	public static float sum(float d[]){
		float sum = 0;
		for(float dd : d) sum += dd;
		return sum;
	}
	
	/** standard deviation */
	public static double dev(double d[]){
		return devGivenAve(ave(d), d);
	}
	
	/** standard deviation, after you've already computed average */
	public static double devGivenAve(double ave, double d[]){
		double sumOfSquares = 0;
		for(double dd : d){
			double diff = dd-ave;
			sumOfSquares += diff*diff;
		}
		double aveSquare = sumOfSquares/d.length;
		return Math.sqrt(aveSquare);
	}
	
	/** standard deviation, after you've already computed average */
	public static float devGivenAve(float ave, float d[]){
		float sumOfSquares = 0;
		for(float dd : d){
			float diff = dd-ave;
			sumOfSquares += diff*diff;
		}
		float aveSquare = sumOfSquares/d.length;
		return (float)Math.sqrt(aveSquare);
	}
	
	public static float[] toFloats(double[] d){
		float[] f = new float[d.length];
		for(int i=0; i<f.length; i++) f[i] = (float)d[i];
		return f;
	}
	
	public static float[] toFloats(boolean[] b){
		float[] f = new float[b.length];
		for(int i=0; i<f.length; i++) f[i] = b[i]?1:0;
		return f;
	}
	
	public static double[] toDoubles(float[] f){
		double[] d = new double[f.length];
		for(int i=0; i<d.length; i++) d[i] = f[i];
		return d;
	}
	
	/** only the values at odd indexs */
	public static double[] odds(double[] d){
		double[] odds = new double[d.length/2];
		for(int i=0; i<odds.length; i++){
			odds[i] = d[i+i+1];
		}
		return odds;
	}
	
	/** only the values at even indexs */
	public static double[] evens(double[] d){
		double[] evens = new double[(d.length+1)/2];
		for(int i=0; i<evens.length; i++){
			evens[i] = d[i+i];
		}
		return evens;
	}
	
	public static double[] joinEvensOdds(double[] evens, double[] odds){
		if(evens.length != odds.length) throw new Error("Diff sizes");
		double[] d = new double[evens.length+odds.length];
		for(int i=0; i<evens.length; i++){
			d[i<<1] = evens[i];
			d[(i<<1)+1] = odds[i];
		}
		return d;
	}
	
	/** ints 0..(size-1) shuffled. Uses size-1 swaps in triangle array for correct shuffle, unlike a square loop. */
	public static int[] randPermutation(int size, Random rand){
		int[] p = new int[size];
		for(int i=0; i<size; i++) p[i] = i;
		for(int i=1; i<size; i++){
			//Range 0..(i-1) is random.
			int j = rand.nextInt(i+1); //j <= i
			int temp = p[i];
			p[i] = p[j];
			p[j] = temp;
		}
		return p;
	}
	
	/**A random permutation on half the nodes and the others map to themself. Which half is whatever matches the mask (1<<bitIndex). */
	public static int[] randPermutationForHalfOfNodesByBitIndex(int bitIndex, int size, Random rand){
		if((size&(size-1))!=0) throw new Error("Must be power of 2: "+size);
		//TODO verify bitIndex is in range and has exactly 1 bit1.
		int[] halfSizePermutation = randPermutation(size/2, rand);
		int[] ret = new int[size];
		int mask = 1<<bitIndex;
		for(int i=0; i<size; i++){
			if((i&mask)==0){
				ret[i] = i;
			}else{ //Insert mask bit and slide some bits up
				int lowMask = mask-1; //all 1s below mask bit
				int highMask = ~((1<<(bitIndex+1))-1); //all 1s above mask bit
				int p = halfSizePermutation[((i&highMask)>>1)|(i&lowMask)];
				ret[i] = ((p<<1)&highMask) | mask | (p&lowMask);
			}
		}
		return ret;
	}
	
	public static int[] inversePermutation(int[] permutation){
		int[] inverse = new int[permutation.length];
		for(int i=0; i<permutation.length; i++){
			inverse[permutation[i]] = i;
		}
		return inverse;
	}
	
	/** To reverse the permutation, use permutate(float[],inversePermutation(permutation)) */
	public static float[] permutate(float[] in, int[] permutation){
		if(in.length != permutation.length) throw new Error("Diff sizes");
		float[] out = new float[in.length];
		for(int i=0; i<in.length; i++){
			out[permutation[i]] = in[i];
		}
		return out;
	}
	
	/*no Rand allowed in immutable package
	static void testPermutate(){
		float[] f = new float[100];
		for(int i=0; i<f.length; i++) f[i] = i+200;
		int[] p = randPermutation(f.length, Rand.strongRand);
		int[] pInverse = inversePermutation(p);
		float[] f2 = permutate(f,p);
		float[] f3 = permutate(f2,pInverse);
		int countSameWhereMostShouldntBe = 0;
		for(int i=0; i<f.length; i++){
			if(f[i] == f2[i]) countSameWhereMostShouldntBe++;
			if(f[i] != f3[i]) throw new Error("Didnt inverse permutation back to original");
		}
		if(countSameWhereMostShouldntBe > 8) throw new Error("Too many "+countSameWhereMostShouldntBe+" are same, almost certainly didnt permutate randomly.");
		//lg("Permutation tests pass");
	}*/
	
	public static float[] reverse(float[] a){
		float[] newA = new float[a.length];
		for(int i=0; i<a.length; i++){
			newA[i] = a[a.length-1-i];
		}
		return newA;
	}
	
	public static boolean[] xChooseYArray(int x, int y, Random rand){
		if(y < 0 || y > x) throw new Error("x="+x+" choose y="+y);
		boolean[] ret = new  boolean[x];
		if(y < x/2){
			int ones = 0;
			while(ones < y){
				int i = rand.nextInt(x);
				if(!ret[i]){
					ret[i] = true;
					ones++;
				}
			}
		}else{
			Arrays.fill(ret, true);
			int ones = x;
			while(ones > y){
				int i = rand.nextInt(x);
				if(ret[i]){
					ret[i] = false;
					ones--;
				}
			}
		}
		return ret;
	}
	
	public static float[] bitsToFloats(boolean[] b){
		float[] f = new float[b.length];
		for(int i=0; i<b.length; i++){
			f[i] = b[i]?1:0;
		}
		return f;
	}
	
	/** 1d arrays can be different sizes within same parent array, but x and y must be same sizes in all ways. */
	public static float[][] multiplyScalars(float[][] x, float[][] y){
		if(x.length != y.length) throw new Error("diff sizes");
		float[][] ret = new float[x.length][];
		for(int i=0; i<x.length; i++){
			int innerSize = x[i].length;
			ret[i] = new float[innerSize];
			if(innerSize != y[i].length) throw new Error("diff sizes");
			for(int j=0; j<innerSize; j++){
				ret[i][j] = x[i][j]*y[i][j];
			}
		}
		return ret;
	}
	
	/** Not matrixMultiply. BigO of squared. Returns a 2d array where each index is the multiply of an index from each param array.
	They must both be rectangle arrays the same sizes. The optimization allows java to allocate the 2d array as 1 block of memory,
	and to branch in code less.
	*/
	public static float[][] multiplyScalars_optimizedByKnowingBothAreRectangle(float[][] x, float[][] y){
		int b = x.length;
		int c = x[0].length;
		if(y.length != b || y[0].length != c) throw new Error("Diff sizes");
		float[][] ret = new float[b][c];
		for(int j=0; j<b; j++){
			for(int k=0; k<c; k++){
				ret[j][k] = x[j][k]*y[j][k];
			}
		}
		return ret;
	}
	
	public static void copyLongIntoByteArray(byte[] b, int byteIndex, long j){
		for(int i=7; i>=0; i--){
			b[byteIndex+i] = (byte)j;
			j>>=8;
		}
	}
	
	public static long readLongFromByteArray(byte[] b, int byteIndex){
		long j = 0;
		for(int i=0; i<8; i++){
			j = (j<<8)|(b[byteIndex+i]&0xff);
		}
		return  j;
	}
	
	public static int readInt(byte[] b, int offset){
		int ret = 0;
		for(int i=0; i<4; i++){
			ret = (ret<<8)|(b[i]&0xff);
		}
		return  ret;
	}
	
	public static byte[] doublesToBytes(double[] d){
		byte[] b = new byte[d.length<<3];
		for(int i=0; i<d.length; i++){
			copyLongIntoByteArray(b, i<<3, Double.doubleToRawLongBits(d[i]));
		}
		return b;
	}
	
	public static double[] bytesToDoubles(byte[] b){
		double[] d = new double[b.length>>3];
		for(int i=0; i<d.length; i++){
			d[i] = Double.longBitsToDouble(readLongFromByteArray(b,i<<3));
		}
		return d;
	}
	
	public static float[][] nPointersTo(int n, float[] a){
		float[][] ret = new float[n][];
		Arrays.fill(ret, a);
		return ret;
	}
	
	public static float[][] nPointersToThenSwapDims(int n, float[] a){
		float[][] ret = new float[a.length][n];
		for(int i=0; i<a.length; i++){
			//TODO optimize use Arrays.fill instead of inner loop cuz its arrays each with only 1 unique float
			for(int j=0; j<n; j++){
				ret[i][j] = a[i];
			}
		}
		return ret;
	}
	
	public static void writeLong(long g, OutputStream out, boolean littleEndianByteOrder) throws IOException{
		if(littleEndianByteOrder){
			for(int i=0; i<8; i++){
				out.write((byte)g);
				g >>>= 8;
			}
		}else{
			for(int i=56; i>=0; i-=8){
				out.write((byte)(g>>>i));
			}
		}
	}
	
	public static void writeInt(int g, OutputStream out, boolean littleEndianByteOrder) throws IOException{
		if(littleEndianByteOrder){
			for(int i=0; i<4; i++){
				out.write((byte)g);
				g >>>= 8;
			}
		}else{
			for(int i=24; i>=0; i-=8){
				out.write((byte)(g>>>i));
			}
		}
	}
	
	public static float[][] newArraySameSizeAs(float[][] a, float fill){
		float[][] ret = new float[a.length][];
		for(int i=0; i<a.length; i++){
			ret[i] = new float[a[i].length];
			if(fill != 0) Arrays.fill(ret[i], fill);
		}
		return ret;
	}
	
	public static float[][][] newArraySameSizeAs(float[][][] a, float fill){
		float[][][] ret = new float[a.length][][];
		for(int i=0; i<a.length; i++){
			ret[i] = newArraySameSizeAs(a[i], fill);
		}
		return ret;
	}
	
	/** each internal array can be different size */
	public static boolean arraysAreSameSize(float[][] a, float[][] b){
		if(a.length != b.length) return false;
		for(int i=0; i<a.length; i++){
			if(a[i].length != b[i].length) return false;
		}
		return true;
	}
	
	/** each internal array can be different size */
	public static boolean arraysAreSameSize(float[][][] a, float[][][] b){
		if(a.length != b.length) return false;
		for(int i=0; i<a.length; i++){
			if(!arraysAreSameSize(a[i],b[i])) return false;
		}
		return true;
	}
	
	public static byte[] intsToBytes(int[] ints){
		byte[] b = new byte[ints.length*4];
		for(int i=0; i<ints.length; i++){
			int j = ints[i];
			b[i<<2] = (byte)(j>>>24);
			b[i<<2+1] = (byte)(j>>>16);
			b[i<<2+2] = (byte)(j>>>8);
			b[i<<2+3] = (byte)j;
		}
		return b;
	}
	
}

