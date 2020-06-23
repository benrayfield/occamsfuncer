package immutableexceptgas.occamsfuncer.v2.prototype.denseCbtMemMap;

import immutable.util.MathUtil;
import immutableexceptgas.occamsfuncer.v2.spec.fn;

/** see the vm_denseCbt* funcs in fn.java and comments about it in Cache.java.
At each nonnegative long binheapIndex of a bit
up to (maybe 2^61-1, see max Call.*last1* long)),
is the index of a bit.
<br><br>
3 ranges in that range
each contain ints (2^58 bits?),
floats (2^58 bits?), or doubles (2^59 bits?),
and any of those can be viewed as bits,
ieee754 normed if float or double.
<br><br>
TODO much later maybe...
also I might want a range for instances of Call.java
and 1 for the Leaf and a range of size 2^31 for unaryCbts.
I might want a range for various networking datastructs
as in the 2 main kinds of networking defined in Network.java
which are call triples and streams whose speed is 1 bit per
2^n nanoseconds for n is range 0 to 63.
*/
public final class Mem{
	private Mem(){}
	
	//TODO use binary searchable tree of sparse ranges filled in

	/** Get fn view of a n address even if that address has never
	been written directly but all its childs have been filled in.
	L.f(fnAtLong(x)).f(R.f(fnAtLong(x)))==fnAtLong(x) except
	where x is too big which is somewhere around size 2^58 bits,
	or except if its not in the denseCbt range (such as its a Call instance).
	*/
	public static fn fn(long addr){
		throw new Error("TODO");
	}
	
	public static long L(long addr){
		//FIXME what to do if its already size 1 bit?
		//Should it do the L of cbt0 or cbt1 and as it wraps around
		//at leaf cuz (L leaf) is I (identityFunc) and (R leaf) is leaf.
		return addr<<1;
	}
	
	public static long R(long addr){
		//FIXME what to do if its already size 1 bit. See similar comment in L(long).
		return (addr<<1)|1L;
	}
	
	public static long UP(long addr){
		//FIXME what to do if its too big
		return addr>>>1;
	}
	
	/** If Mem is ever expanded to hold the fileds of Call,
	outside the dense cbt range, then this would do a lambda call,
	maybe using the Cache hashtable,
	or maybe it would contain its own hashtable and related fields.
	Maybe this should use Time.timeAddr which is the number
	of nanoseconds since Y1970 or that plus a certain number
	if its called too soon after that, and the certain number
	would have to be big enough to fit everything that Call needs
	to possibly store ever including 36 (or 35?) byte id lazyEvaled.
	*/
	public static long call(long funcAddr, long paramAddr){
		throw new Error("TODO");
	}
	
	public static long wrap(int[] a){
		if(!MathUtil.isPowerOf2(a.length)) throw new Error("Not a powOf2 size");
		throw new Error("TODO");
	}
	
	public static long wrap(float[] a){
		if(!MathUtil.isPowerOf2(a.length)) throw new Error("Not a powOf2 size");
		throw new Error("TODO");
	}
	
	public static long wrap(double[] a){
		if(!MathUtil.isPowerOf2(a.length)) throw new Error("Not a powOf2 size");
		throw new Error("TODO");
	}
	
	/** deletes a cbt and all its childs recursively
	so that memory range can be used again.
	Does not delete other addrs which may have duplicate
	or partially duplicate content such as their left child
	is the same content as some other cbt.
	*/
	public static void free(long addr){
		throw new Error("TODO");
	}
	
	public static double doubleAt(long addr){
		throw new Error("TODO");
	}
	
	public static float floatAt(long addr){
		throw new Error("TODO");
	}
	
	public static long longAt(long addr){
		throw new Error("TODO");
	}
	
	public static int intAt(long addr){
		throw new Error("TODO");
	}
	
	public static short shortAt(long addr){
		throw new Error("TODO");
	}
	
	public static char charAt(long addr){
		throw new Error("TODO");
	}
	
	public static byte byteAt(long addr){
		throw new Error("TODO");
	}
	
	public static boolean bitAt(long addr){
		throw new Error("TODO");
	}
	
}
