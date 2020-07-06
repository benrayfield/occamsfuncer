/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.ocfn3s.spec;

public interface Compiled{
	
	/** param is normally not halted, and whats returned is always halted.
	This might wrap a UnaryOperator<fn> similar to how ocfn2's Compiled wrapped a BinaryOperator<fn>.
	*/
	public fn eval(fn lazy);
	
	public boolean setOn(boolean on);
	
	public boolean on();
	
	/** linkedlist of Compiled. Whichever first in that list is on() is used.
	By turning some off, you can test without those optimizations, such as to verify the compiled form has the exact same behaviors to bit precision.
	If prev is null, then on() is always true.
	*/
	public Compiled prevOrNull();

}
