package immutableexceptgas.occamsfuncerV2Prototype.fns;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2Prototype.util.Example;
import immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic;
import immutableexceptgas.occamsfuncerV2Spec.fn;

public abstract class AbstractFn implements fn{
	
	public int compareTo(fn o){
		return Example.comparator().f(this).f(o).intAt(0);
		/*fn c = Example.compare().f(this).f(o);
		if(c == T) return 1;
		if(c == F) return -1;
		return 0;
		*/
	}
	
	public boolean equals(Object o){
		if(!(o instanceof fn)) return false;
		return Example.equals().f(this).z();
	}
	
	public fn f(Object param){
		return f(ImportStatic.w(param));
	}
	
	/** OLD, cuz moved this func body to AbstractFn...
	This is very inefficient unless overridden in subclasses.
	<br><br>
	Returns last1_notCbtBitstring=-1 if is not a cbtBitstring,
	or returns last1_bigCbtBitstring=-2
	if is a cbtBitstring but its bigger than its last bit index
	would fit in long.
	<br><br>
	TODO: Efficient bitstrings (if isCbt). This tells where the last cbt1 is,
	or TODO return what if its a cbt with all 0s or if its not a cbt?
	Cbt represents bitstring and I'm undecided how to view that as
	signed integer as there are multiple ways it could be done.
	This default implementation is very slow and should be optimized in
	subclasses ArrayCbt and SmallCbt.
	*/
	public long bitstringSize(){
		if(!isCbt()) return last1_notCbtBitstring; //throw new Error("Not a cbt");
		//int cbtHeight = height()-4; //cbtSize = 2 exponent cbtHeight.
		int h = height();
		if(h > Call.maxHeightToUse_last1) return last1_bigCbtBitstring;
		long cbtSize = 1L<<(h-4);
		for(long i=cbtSize-1; i>=0; i--){
			if(bitAt(i)) return i; //dont include last cbt1 in bitstring
		}
		return last1_notCbtBitstring;
		//throw new Error("No cbt1 found so is not a bitstring");
	}
	
	/** very inefficient if not overridden to use long Call.last1 forExample */
	public boolean isBitstring(){
		return isCbt() && (this==cbt1 || L().isBitstring() || R().isBitstring());
	}
	
	/** very inefficient if not overridden to use ArrayCbt etc,
	and you would not normally get just 1 bit at a time
	but might use longAt(long) or floatAt(long)
	or TODO funcs to get a range into byte[] or int[] or float[] etc.
	*/
	public boolean bitAt(long cbtBitIndex){
		if(!isCbt()) return false;
		int cbtHeight = height()-4;
		int cbtSize = 1<<cbtHeight;
		if(cbtBitIndex < 0 || cbtBitIndex >= cbtSize) return false;
		if(cbtSize == 1) return this==cbt1;
		if(cbtBitIndex < (cbtSize>>1)) return L().bitAt(cbtBitIndex);
		return R().bitAt(cbtBitIndex-(cbtSize>>1));
	}
	
	public boolean z(){
		return this == T;
	}
	
	public fn comment(){ return leaf; }

}
