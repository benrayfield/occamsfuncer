/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer;
import java.util.function.BinaryOperator;

/** Example: compile a certain fn that does iee754 double multiply on
2 cbts of 64 bits each, compile that to a BinaryOperator with cur=2
to use java strictfp double*double,
or a similar fn could do that in 1 cbt of 128 bits and 64 bits out.
*/
public class Compiled{
	
	public final int cur;
	
	/** If null then the constraint is Op.T which is always true so doesnt
	need to be calculated. A constraint is false when its param causes it to infloop.
	*/
	public final BinaryOperator<fn> constraintOrNull;
	
	public final BinaryOperator<fn> funcBody;
	
	public Compiled(int cur, BinaryOperator<fn> constraintOrNull, BinaryOperator<fn> funcBody){
		this.cur = cur;
		this.constraintOrNull = constraintOrNull;
		this.funcBody = funcBody;
	}

}