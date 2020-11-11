package immutable.occamsfuncer.impl.optimize.id;

import java.util.List;

/** tree or linkedlist of IdField each being a certain number of bits.
Its a tree if branching on all possible values of a certain IdField (such as the 8 possible values of 3 bits)
theres that many branches of what the rest of the bits in the id mean.
*/
public class IdType{
	
	/** cumulative bits so far from parent IdType to here.
	FIXME or is this the other direction the size of all paths in the tree thru childs from here? *
	public final short totalBits;
	
	/** totalBits is sum of localBits in any 1 path thru tree from root to a leaf (not the ocfn leaf, but the end of the id bit tree) *
	public final short localBits;
	
	/** what the localBits number of bits means *
	public final IdField field;
	
	/** Immutable List. childs.size() <= (1<<localBits). *
	public final List<IdType> childs;
	*/

}
