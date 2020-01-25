/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncerV2Prototype.util;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2Prototype.fns.Leaf;
import immutableexceptgas.occamsfuncerV2Spec.fn;

/** used as a java.util.Map key for caching <func,param,return>.
does not trigger lazyHash cuz is by == and hashCode.
Is for fast dedup that works for forests of s and k lambdas etc
which would otherwise do an exponential number of calls.
*/
public class CallAsKey{
	
	/** in Cache, only frequently clear those which execute to do something,
	and keep those which still ahve curries remaining (retIsThisPair)
	until that pair is garbcoled.
	*/
	public final boolean retIsThisPair;
	
	/*Need an ok hash, such as long (or just int hashCode()),
	but not a secureHash.
	See how I did it in acyc32' mutable hashtable,
	or maybe it was a later fork of occamsfuncer,
	whichever one used that ImmutableLinkedListNode for hash bucket,
	but I could just use HashMap for now.
	Put mutable fn val ptr in CallAsKey?
	Id maybe want to use Call as that but I dont want
	any fn to exist which isnt returned yet, so I'll do it in CallAsKey.
	...
	What about leafs? How are they weakDeduped? By == normally,
	but I need it deduped by content if its an Op (like fn:plus)
	and maybe also if its so small it fits in an id (fn.maxIdSize).
	*/
	
	public final fn L, R, comment;
			
	/** null until (func param) returns *
	public fn val;
	*/
	
	/*FIXME "until that pair is garbcoled". Try to do that without Weakref
	cuz that would be extra slow.
	It wont need WeakReference cuz Cache.clear() happens
	normally once per video frame and will remove everything not reachable
	from 1 fn that is the root state, or something like that,
	though I would like flexibility to do it without requiring
	a rootState if I can efficiently but I would probably still
	want to use a rootState anyways. The difference is
	various java objects outside the system can hold pointers to fns
	if a rootState isnt required, but rootState is the main usecase.
	*/
	
	public CallAsKey(fn haltedLRComment){
		if(haltedLRComment == Leaf.instance) throw new Error("Cant cache leaf cuz thats where fractal wraps around aka leaf.L()==I and leaf.R()==leaf, and I is made of calling leaf on itself a certain combo at height 4.");
		this.retIsThisPair = true;
		this.L = haltedLRComment.L();
		this.R = haltedLRComment.R();
		this.comment = haltedLRComment.comment();
	}
	
	public CallAsKey(fn L, fn R, fn comment){
		this.retIsThisPair = false;
		this.L = L;
		this.R = R;
		this.comment = comment;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof CallAsKey)) return false;
		CallAsKey c = (CallAsKey)obj;
		return c.L==L && c.R==R && c.comment==comment;
	}
	
	public int hashCode(){
		//this would call id() since hashCode is derived from it:  return func.hashCode()+param.hashCode();
		return System.identityHashCode(L)+System.identityHashCode(R)+System.identityHashCode(comment);
		//throw new Error("TODO??? salt the hashes of the 2 childs, like probably did in other ocfn code in CacheFuncParamReturn class");
	}
	
	public String toString(){
		return comment==leaf ? "<"+L+","+R+">" : "<"+L+","+R+","+comment+">";
	}

}
