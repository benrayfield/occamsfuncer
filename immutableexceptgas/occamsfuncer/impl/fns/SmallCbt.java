package immutableexceptgas.occamsfuncer.impl.fns;

/** If height is 0, then data is either cbt0 or cbt1.
If height is 1, then its 2 bits. Height goes up to 6 for 64 bits.
cbtHeight is 4 more than fn height since cbt0 and cbt1 are
both at height 4.
*/
public class SmallCbt implements fn{
	
	public final byte height;
	
	public final long data;
	
	public SmallCbt(byte height, long data){
		this.height = height;
		this.data = data;
	}

}
