package occamsfuncer.impl.fn;
import java.util.Set;
import occamsfuncer.fn;

/** A function or snapshot of stack state of evaling. A call quad [func, param, stack, cacheKey] with
various fields stored in a long including bitstringSize, isHalted, isParentsFunc, numCurries(0-15), etc.
*/
public class Call implements fn{
	
	protected Compiled compiled;

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

	public void setCompiled(Compiled c){ compiled = c; }

	public Compiled getCompiled(){ return compiled; }

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

	public Object unwrap(){ return null; }

	public long zigzag(){ return 0; }

	public boolean isMeta(){
		throw new Error("TODO for fure expansion of metaOps ");
	}

	public boolean bitAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public byte byteAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public short shortAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public char charAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public int intAt(long bitIndex){
		throw new Error("TODO cbt");
	}

	public long longAt(long bitIndex){
		throw new Error("TODO cbt");
	}
	
	public float floatAt(long bitIndex){
		return Float.intBitsToFloat(intAt(bitIndex));
	}

	public double doubleAt(long bitIndex){
		return Double.longBitsToDouble(longAt(bitIndex));
	}
	
	public long bize(){
		throw new Error("TODO cbt");
	}

	public boolean isCbt() {
		throw new Error("TODO cbt");
	}

	public boolean isBitstring(){
		throw new Error("TODO cbt");
	}

}