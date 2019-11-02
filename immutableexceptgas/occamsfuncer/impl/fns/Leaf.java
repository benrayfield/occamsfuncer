/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.impl.fns;
import java.util.function.BinaryOperator;
import immutableexceptgas.occamsfuncer.Boot;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;
import immutableexceptgas.occamsfuncer.Op;
import immutableexceptgas.occamsfuncer.fn;

public class Leaf implements fn{
	
	public static final fn instance = new Leaf();
	
	private Leaf(){}

	public fn f(fn param){
		return cp(this,param);
	}

	public boolean isLeaf(){
		return true;
	}

	/** returns identityFunc, cuz ((L x)(R x)).equals(x) for all x */
	public fn L(){
		return I;
	}

	/** returns this, cuz ((L x)(R x)).equals(x) for all x */
	public fn R(){
		return this;
	}

	public int cur(){
		return 1;
	}

	public fn curBig(){
		throw new Error("TODO");
	}

	public fn bh(int path){
		throw new Error("TODO the structure is known that L is identityFunc and R is this, so theres probably an optimized way to do that");
	}

	public fn bhBig(fn path){
		throw new Error("TODO");
	}

	public fn id(fn algorithm){
		throw new Error("TODO");
	}

	/** FIXME? does this being null contradict the design
	that everything from height0 to height4 is an op
	and must have a compiled? Could make that height1 to height4,
	but the behaviors are only nontrivial for 16 of those at heigh4.
	*/
	public BinaryOperator<fn> compiled(){
		return null;
	}

	public boolean isCbt(){
		return false;
	}

	public boolean isBigCbt(){
		return false;
	}

	public long longAt(int cbtBitIndex){
		return 0L;
	}

	public long longAtBig(fn cbtBitIndex){
		return 0L;
	}

	public int cbtSize(){
		return 0;
	}

	public fn cbtSizeBig(){
		throw new Error("TODO");
	}

	public boolean isBitstring(){
		return false;
	}

	public int bitstringSize(){
		return 0;
	}

	public fn bitstringSizeBig(){
		return cbt1; //FIXME? empty bitstring means integer 0?
	}

	public int height(){
		return 0;
	}

	public fn heightBig(){
		return null;
	}

	/** unlike nonleafs, leaf's op is its L and is identityFunc */
	public fn op(){
		return I;
	}

	public void setCompiled(BinaryOperator<fn> c){
		throw new UnsupportedOperationException("Leaf doesnt need a compiled form since its behaviors are very simple");
	}

}
