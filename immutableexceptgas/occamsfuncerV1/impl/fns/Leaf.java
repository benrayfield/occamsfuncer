/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncerV1.impl.fns;
import static immutableexceptgas.occamsfuncerV1.impl.util.ImportStatic.*;

import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncerV1.Compiled;
import immutableexceptgas.occamsfuncerV1.fn;
import immutableexceptgas.occamsfuncerV1.impl.util.Boot;
import immutableexceptgas.occamsfuncerV1.impl.util.Op;

/** leaf.f(anything) is the halted state (leaf anything).
x.L().f(x.R()).equals(x) for all x.
leaf.L() is I (aka identityFunc). leaf.R()==leaf. I.f(leaf)==leaf.
Therefore the L and R paths are infinitely deep and consistent.
L and R of anything else is simply its left and right childs.
All L and R paths eventually lead to leaf, such as I is
a certain binary forest shape (see Boot class) made of
calling leaf on itself in various combos.
*/
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
	
	/** TODO optimize this by not calling Leaf.instance and copying that code here.
	This is actually a little slower than Leaf directly,
	but every x.compiled()!=null for every fn x,
	cuz they copy ptr to Compiled in each next param.
	*/
	public static final Compiled compiledOfLeaf = new Compiled(
		Leaf.instance.cur(),
		null,
		((fn l,fn r)->Leaf.instance.f(r)),
		null
	);
	
	public Compiled compiled(){
		return compiledOfLeaf;
	}

	/** FIXME? does this being null contradict the design
	that everything from height0 to height4 is an op
	and must have a compiled? Could make that height1 to height4,
	but the behaviors are only nontrivial for 16 of those at heigh4.
	*
	public Compiled compiled(){
		return null;
	}*/
	
	public void setCompiled(Compiled c){
		throw new UnsupportedOperationException("Leaf doesnt need a compiled form since its behaviors are very simple");
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

	public fn fIgnoreConstraint(fn param){
		return f(param);
	}
	
	public String toString(){
		return ".";
	}

}
