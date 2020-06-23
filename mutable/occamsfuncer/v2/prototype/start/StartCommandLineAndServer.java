package mutable.occamsfuncer.v2.prototype.start;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncer.v2.prototype.fns.Leaf;
import immutableexceptgas.occamsfuncer.v2.prototype.test.TestBasics;
import immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic;
import immutableexceptgas.occamsfuncer.v2.spec.Gas;
import immutableexceptgas.occamsfuncer.v2.spec.Op;
import immutableexceptgas.occamsfuncer.v2.spec.fn;

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
