package mutable.occamsfuncer.v1.start;
import static immutableexceptgas.occamsfuncer.v1.impl.util.ImportStatic.*;

import immutableexceptgas.occamsfuncer.v1.fn;
import immutableexceptgas.occamsfuncer.v1.impl.fns.Leaf;
import immutableexceptgas.occamsfuncer.v1.impl.test.TestBasics;
import immutableexceptgas.occamsfuncer.v1.impl.util.Gas;
import immutableexceptgas.occamsfuncer.v1.impl.util.ImportStatic;
import immutableexceptgas.occamsfuncer.v1.impl.util.Op;

/** TODO always run the fast tests (at least TestBasics.main)
then start either in commandline mode or open window on screen
*/
public class StartCommandLineLocal{
	
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
