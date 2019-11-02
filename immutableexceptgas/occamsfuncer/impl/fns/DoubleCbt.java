package immutableexceptgas.occamsfuncer.impl.fns;

/** same as Bitstring64 (a 120 bit cbt) but optimized as double */
public class DoubleCbt implements fn{
	
	public final double bits;
	
	public DoubleCbt(double bits){
		this.bits = bits;
	}

}
