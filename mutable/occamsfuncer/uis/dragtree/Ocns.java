package mutable.occamsfuncer.uis.dragtree;
import immutable.occamsfuncer.fn;

/** occamsfuncer namespace */
public interface Ocns{
	
	/** local name, doesnt affect global id */
	public String name(fn x);
	
	public fn fn(String name);
	
	//TODO move (long)fn.lid() here?

}