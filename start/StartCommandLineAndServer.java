package start;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.*;
import immutableexceptgas.occamsfuncer.fn;
import immutableexceptgas.occamsfuncer.impl.fns.Leaf;
import immutableexceptgas.occamsfuncer.impl.test.TestBasics;
import immutableexceptgas.occamsfuncer.impl.util.Gas;
import immutableexceptgas.occamsfuncer.impl.util.ImportStatic;
import immutableexceptgas.occamsfuncer.impl.util.Op;

/** TODO always run the fast tests (at least TestBasics.main)
then start either in commandline mode or open window on screen
*/
public class StartCommandLineAndServer{
	
	public static void main(String[] args){
		//double can represent all integers between plus/minus this
		Gas.top = 1L<<53;
		//allow Op.nondet to do nondeterministic things instead
		//of always infiniteLooping (deterministic),
		//which is a certain few calls of universalLambdaFunction.
		//Its useful for limiting compute cycles and memory
		//and calling plugins, if any.
		Gas.forceDeterminism = false;
		throw new Error("TODO");
	}
}
