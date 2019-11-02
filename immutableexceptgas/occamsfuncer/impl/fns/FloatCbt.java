package immutableexceptgas.occamsfuncer.impl.fns;

/** similar to DoubleCbt but size 64 instead of 128 (half of that not stored) */
public class FloatCbt implements fn{
	
	public final float bits;
	
	public FloatCbt(float bits){
		this.bits = bits;
	}

}
