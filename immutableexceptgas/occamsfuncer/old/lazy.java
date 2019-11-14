package immutableexceptgas.occamsfuncer.old;

import immutableexceptgas.occamsfuncer.fn;

/** A lazyfn represents whatever fn lazyL().f(lazyR()) would return,
but in some cases (see comments in Boot about stackoverflow caused
by Example.equals() not doing lazyeval
as in computing the second param of T
or computing the first param of F when those are nonhalting.
<br><br>
There will still be a merkleForest form of lazyfn,
basically represented as each funcallPair has a bit
thats 0 if its halted and 1 if its not halted (is lazy).
*/
public interface lazy extends fn{
	
	/** often different than L(). See comment of this interface. */
	public fn lazyL();
	
	/** often different than L(). See comment of this interface. */
	public fn lazyR();
	
	public fn eval();

}
