package immutableexceptgas.occamsfuncer.impl.fns;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.*;

import java.lang.reflect.Array;
import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncer.Compiled;
import immutableexceptgas.occamsfuncer.fn;

/** optimization of completeBinaryTree of Op.cbt0 and Op.cbt1,
stored as any 1d primitive array,
but the choice of array is only an optimization
and has the same id (for all possible id funcs)
as if it was just the ieee754 normed bits of that
such as double[] float[] long[] int[] byte[] are all
representations of certain binForest shapes
that are a completeBinaryTree of bits.
<br><br>
FIXME this logic seems inconsistent: If the array size
is not a powOf2 then its viewed
as if the next bit is 1 and the rest are 0s.
<br><br>
FIXME there might be a problem with double[] and float[]
having a trailing 1 bit to end the bitstring
since that would be negativeZero which is not normed.
<br><br>
Its 1d array cuz thats all thats needed to optimize it
even though in some ways of using it, it might be interpreted
as having more dims of various sizes.
Occamsfuncer only has efficient bitstring ability
and only has strong typing in Op.curry's constraint/k param,
but the bitstring optimization,
which can inTheory forkAppend any large file
(petabit, googol bits, etc) in a p2p network,
are raw bits not any specific interpretation of them.
The bigger sizes would use Cbt chunks joined by
Call pairing them with eachother to make
bigger completeBinaryTrees of bits.
All completeBinaryTrees with cbt0 and cbt1 leafs are halted.
*/
public class ArrayCbt<T> implements fn{
	
	/** A small array can represent any larger powOf2 size
	defined by height, where height4 is cbt0 or cbt1,
	and height5 is 1 of: (cbt1 cbt1) (cbt1 cbt0) (cbt0 cbt1) (cbt0 cbt0)
	and so on.
	*/
	protected byte height;
	
	/** chooses a powOf2 size range in array or partially or completely
	outside the array as 1<<(height-4) (or is that offBy1 etc?)
	FIXME should binheapPtr be in units of bits or primitives?
	*
	protected int binheapPtr;
	*/
	
	protected int start, endExcl;
	
	//int indexOfLast1Bit
	
	//int indexOfLast0Bit or bitSize
	
	/*should start and size be merged into a single int
	thats a binheap index? Theres no substringing on
	non-powof2 boundaries so thats just as flexible,
	but its slower as it costs log2 number of cycles
	to get the size but is returned by Integer.highestOneBit(int).
	
	protected int start, size;
	*/
	
	/** Examples: double[] float[] long[] int[] byte[] */
	protected T bits;
	
	/** pads up to next powOf2 size (but doesnt store the padding) *
	public Cbt(T bits){
		this((byte)0, 0, null); //FIXME
	}*/
	
	/** pads up to given powOf2 size as defined by height (relative to leaf)
	and binheapPtr, (but doesnt store the padding).
	*
	public Cbt(byte height, int binheapPtr, T bits){
		this.height = height;
		this.binheapPtr = binheapPtr;
		this.bits = bits;
	}*
	public Cbt(T bits){
		this(TODO)
	}*/
	
	public ArrayCbt(byte height, int start, int endExcl, T bits){
		this.height = height;
		this.start = start;
		this.endExcl = endExcl;
		this.bits = bits;
	}
	
	/*public Cbt(T bits){
		this(bits, 0, Array.getLength(bits));
	}
	
	/** the ints are in units of primitives *
	public Cbt(T bits, int start, int size){
		this.bits = bits;
		this.start = start;
		this.size = size;
		//TODO verify its a 1d primitive array?
	}*/
	
	public void separate(){
		throw new Error("TODO use binheapPtr etc");
		/*if(start != 0 || size != Array.getLength(bits)){
			T newArray = (T) Array.newInstance(bits.getClass(), size);
			System.arraycopy(bits, start, newArray, 0, size);
			start = 0;
			bits = newArray;
			//FIXME $(... pay for new memory..., using Gas.ratio*)
		}*/
	}

	public fn f(fn param){
		throw new Error("TODO");
	}

	public boolean isLeaf(){
		return false;
	}

	/** doesnt dedup */
	public fn L(){
		//FIXME what if this is already 1 primitive or bit?
		//Then it would be cbt0 or cbt1 if bit and it already knows
		//its L and R as cbt0 and cbt1 are Call.
		
		return new ArrayCbt((byte)(height-1), start, (start+endExcl)/2, bits);
		/*return new Cbt(height-1, TODO binheapPtr /2+1 *2-1 or something like that, bits);
		throw new Error("TODO return view of half the powOf2 size array else a SmallCbt if its half of a primitive. Consider if its not a powOf2 size what bits it implies after that.");
		*/
		
	}

	/** doesnt dedup */
	public fn R(){
		//see FIXME in L()
		return new ArrayCbt((byte)(height-1), (start+endExcl)/2, endExcl, bits);
		//throw new Error("TODO return view of half the powOf2 size array else a SmallCbt if its half of a primitive. Consider if its not a powOf2 size what bits it implies after that.");
	}

	public int cur(){
		return 1;
	}

	public fn curBig(){
		throw new Error("TODO");
	}

	public fn bh(int path){
		throw new Error("TODO");
	}

	public fn bhBig(fn path){
		throw new Error("TODO");
	}

	public fn id(fn algorithm){
		throw new Error("TODO");
	}

	public Compiled compiled(){
		throw new Error("TODO");
	}

	public void setCompiled(Compiled c){
		throw new Error("TODO");
	}

	public boolean isCbt(){
		throw new Error("TODO");
	}

	public boolean isBitstring(){
		throw new Error("TODO");
	}

	public boolean isBigCbt(){
		throw new Error("TODO");
	}

	public long longAt(int cbtBitIndex){
		throw new Error("TODO");
	}

	public long longAtBig(fn cbtBitIndex){
		throw new Error("TODO");
	}

	public int height(){
		throw new Error("TODO");
	}

	public fn heightBig(){
		throw new Error("TODO");
	}

	public int bitstringSize(){
		throw new Error("TODO");
	}

	public fn bitstringSizeBig(){
		throw new Error("TODO");
	}

	public fn op(){
		throw new Error("TODO this would be the leftmost either cbt0 or cbt1, but thats not the most efficient way to use cbt so might need some redesign in Call.f(fn)");
	}

	public fn fIgnoreConstraint(fn param){
		return f(param);
	}
	
	
	/*FIXME there might be a problem with double[] and float[]
	having a trailing 1 bit to end the bitstring
	since that would be negativeZero which is not normed.
	Thats ok since it represents bits, not floats or doubles,
	but some fns may use it like floats or doubles.
	
	FIXME what about a float[3] thats meant to
	be viewed as 32*8=256 bits but 32*4 is the next powOf2?
			
	Usecase: store id in int[].
	*/
	
	/** INSTEAD of this field, if there is any padding, always pad
	with a cbt1 and the rest are cbt0s.
	if true, pad with cbt1 then cbt0s. if false, pad with just cbt0s. *
	protected boolean pad1;
	*/

}