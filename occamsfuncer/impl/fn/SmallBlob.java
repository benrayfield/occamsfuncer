package occamsfuncer.impl.fn;
import java.util.Set;
import occamsfuncer.*;

/** up to 64 bits (or include padding of 1L<<63 in abstract math but not stored?) */
public class SmallBlob implements fn{
	
	public final byte log2OfHeight;
	
	public final long data;
	
	/** log2OfHeight counts the height of T, F, and Pair, in complete binary tree of Pairs of Pairs... of Ts andOr Fs.
	FIXME might need a separate bit for is it (pair x) vs ((pair x) y)_aka_(pair x y).
	FIXME is this right? Use the high bits of the long? Or low bits? Going with low bits, at least for now.
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

	public DedupLevel dedupLevel(){
		throw new Error("TODO");
	}

	public fn setDedupLevel(DedupLevel d){
		throw new Error("TODO");
	}

	public Set<fn> twins(){
		throw new Error("TODO");
	}

	/** The wrapped data is 1<<log2OfHeight bits of long data. Since theres not a primitive value for all those powOf2 (2 or 4 bits),
	we cant always put it into a primitive.
	*/
	public Object unwrap(){
		//FIXME is this right? Use the high bits of the long? Or low bits? Going with low bits, at least for now.
		//FIXME might need a separate bit for is it (pair x) vs ((pair x) y)_aka_(pair x y).
		switch(log2OfHeight){
		case 6: return data;
		case 5: return (int)data;
		case 4: return (short)data;
		case 3: return (byte)data;
		case 1: return (data&1)==0 ? Boolean.TRUE : Boolean.FALSE;
		}
		return null;
	}

	/** 1 cuz is a cbt and not pointing anywhere except at itself */
	public long zigzag(){ return 1; }

	public boolean isMeta(){
		throw new Error("TODO");
	}

	public boolean bitAt(long bitIndex){
		throw new Error("TODO");
	}

	public byte byteAt(long bitIndex){
		throw new Error("TODO");
	}

	public short shortAt(long bitIndex){
		throw new Error("TODO");
	}

	public char charAt(long bitIndex){
		throw new Error("TODO");
	}

	public int intAt(long bitIndex){
		throw new Error("TODO");
	}

	public long longAt(long bitIndex){
		throw new Error("TODO");
	}

	public float floatAt(long bitIndex){
		throw new Error("TODO");
	}

	public double doubleAt(long bitIndex){
		throw new Error("TODO");
	}

	public long bize(){
		throw new Error("TODO");
	}

	public boolean isCbt(){
		throw new Error("TODO");
	}

	public boolean isBitstring(){
		throw new Error("TODO");
	}

}
