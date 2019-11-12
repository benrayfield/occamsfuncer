package immutableexceptgas.occamsfuncer.impl.fns;

import immutableexceptgas.occamsfuncer.fn;

/** a cbt of 128 bits where 64 of them are given
and the other 64 are a 1 then 63 0s.
*/
public class Bitstring64 /*TODO implements fn*/{
	
	public final long bits;
	
	public Bitstring64(long bits){
		this.bits = bits;
	}

}
