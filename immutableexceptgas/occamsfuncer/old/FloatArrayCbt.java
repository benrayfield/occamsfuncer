package immutableexceptgas.occamsfuncer.old;

/** is still the bits of cbt but is the NORMED (NOT RAW) float bits,
padded with 0s until the next powOf2 size.
32 0s is the float value positive 0 (TODO verify).
This is only an optimization such as to use with opencl
and gives the same ids, for all possible id functions,
as if it were stored in int[] or byte[] or long[] etc.
*/
public class FloatArrayCbt /*TODO implements fn*/{
	
	public final float[] data;
	
	public FloatArrayCbt(float... data){
		this.data = data;
	}

}
