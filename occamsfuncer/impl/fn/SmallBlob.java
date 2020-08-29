package occamsfuncer.impl.fn;
import occamsfuncer.fn;
import occamsfuncer.fn.Compiled;

/** up to 64 bits (or include padding of 1L<<63 in abstract math but not stored?) */
public class SmallBlob implements fn{
	
	public final byte log2OfHeight;
	
	public final long data;
	
	/** log2OfHeight counts the height of T, F, and Pair, in complete binary tree of Pairs of Pairs... of Ts andOr Fs.
	FIXME might need a separate bit for is it (pair x) vs ((pair x) y)_aka_(pair x y).
	*/
	public SmallBlob(byte log2OfHeight, long data){
		this.log2OfHeight = log2OfHeight;
		this.data = data;
	}

	public fn apply(fn x){
		throw new Error("TODO");
	}

	public fn f(fn param){
		throw new Error("TODO");
	}

	public fn e(){
		throw new Error("TODO");
	}

	public fn func(){
		throw new Error("TODO");
	}

	public fn param(){
		throw new Error("TODO");
	}

	public fn stack(){
		throw new Error("TODO");
	}

	public fn cacheKey(){
		throw new Error("TODO");
	}

	public void setCompiled(Compiled c){
		throw new Error("TODO");
	}

	public Compiled getCompiled(){
		throw new Error("TODO");
	}

	public boolean isLeaf(){
		throw new Error("TODO");
	}

	public boolean isHaltedAbove(){
		throw new Error("TODO");
	}

	public boolean isDone(){
		throw new Error("TODO");
	}

	public boolean isParentsFunc(){
		throw new Error("TODO");
	}

	public boolean isParentsParam(){
		throw new Error("TODO");
	}

}
