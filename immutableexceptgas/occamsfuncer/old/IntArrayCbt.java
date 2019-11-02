package immutableexceptgas.occamsfuncer.old;

/** efficient bitstring as completeBinaryTree whose leafs
are Op.cbt0 andOr Op.cbt1, interpreted as suffixed by cbt1 which
marks the end of the bitstring and is not part of the bitstring,
or it may be an internal cbt node which doesnt have a cbt1.
Array size is always viewed as padded with 0s until the next powOf2.
This class cant represent a powOf2 less than 32 bits,
so for that use another class.  
*/
public class IntArrayCbt /*TODO implements fn*/{
	
	/** size in bits. Last int uses 1-31 of its bits. If empty bitstring, there are no ints? * 
	public final int bits;
	*/
	
	/** dont modify */
	public int[] data;
	
	public IntArrayCbt(int... data){
	//public Cbt(int bits, int... data){
		//this.bits = bits;
		this.data = data;
	}

}
