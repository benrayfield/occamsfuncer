/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;

public class IntRange{
	
	public final int start, endExclusive;
	
	public IntRange(int start, int endExclusive){
		this.start = start;
		this.endExclusive = endExclusive;
	}
	
	public String toString(){
		return "[IntRange "+start+" "+endExclusive+"]";
	}

}
