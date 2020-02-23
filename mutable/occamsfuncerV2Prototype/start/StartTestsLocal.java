package mutable.occamsfuncerV2Prototype.start;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2Prototype.fns.Leaf;
import immutableexceptgas.occamsfuncerV2Prototype.test.TestBasics;
import immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic;
import immutableexceptgas.occamsfuncerV2Spec.Gas;
import immutableexceptgas.occamsfuncerV2Spec.Op;
import immutableexceptgas.occamsfuncerV2Spec.fn;

/** TODO always run the fast tests (at least TestBasics.main)
then start either in commandline mode or open window on screen
*/
public class StartTestsLocal{
	
	public static void main(String[] args){
		//double can represent all integers between plus/minus this
		Gas.top = 1L<<53;
		//allow Op.nondet to do nondeterministic things instead
		//of always infiniteLooping (deterministic),
		//which is a certain few calls of universalLambdaFunction.
		//Its useful for limiting compute cycles and memory
		//and calling plugins, if any.
		Gas.forceDeterminism = false;
		TestBasics.main();
	}
}
