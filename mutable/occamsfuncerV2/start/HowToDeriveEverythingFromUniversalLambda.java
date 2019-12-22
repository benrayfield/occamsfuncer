package mutable.occamsfuncerV2.start;
import static immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2.fn;
import immutableexceptgas.occamsfuncerV2.impl.fns.Leaf;
import immutableexceptgas.occamsfuncerV2.impl.test.TestBasics;
import immutableexceptgas.occamsfuncerV2.impl.util.Gas;
import immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic;
import immutableexceptgas.occamsfuncerV2.impl.util.Op;

public class HowToDeriveEverythingFromUniversalLambda{
	
	public static void main(String[] args){
		//double can represent all integers between plus/minus this
		Gas.top = 1L<<53;
		//allow Op.nondet to do nondeterministic things instead
		//of always infiniteLooping (deterministic),
		//which is a certain few calls of universalLambdaFunction.
		//Its useful for limiting compute cycles and memory
		//and calling plugins, if any.
		Gas.forceDeterminism = false;
		fn u = fn.universalLambdaFunction;
		lg("universalLambdaFunction: "+u);
		fn uu = u.f(u);
		fn bit0 = u.f(uu);
		fn bit1 = uu.f(u);
		fn op0 = bit0.f(bit0).f(bit0.f(bit0));
		fn op1 = bit0.f(bit0).f(bit0.f(bit1));
		fn op2 = bit0.f(bit0).f(bit1.f(bit0));
		fn op3 = bit0.f(bit0).f(bit1.f(bit1));
		fn op4 = bit0.f(bit1).f(bit0.f(bit0));
		fn op5 = bit0.f(bit1).f(bit0.f(bit1));
		fn op6 = bit0.f(bit1).f(bit1.f(bit0));
		fn op7 = bit0.f(bit1).f(bit1.f(bit1));
		fn op8 = bit1.f(bit0).f(bit0.f(bit0));
		fn op9 = bit1.f(bit0).f(bit0.f(bit1));
		fn op10 = bit1.f(bit0).f(bit1.f(bit0));
		fn op11 = bit1.f(bit0).f(bit1.f(bit1));
		fn op12 = bit1.f(bit1).f(bit0.f(bit0));
		fn op13 = bit1.f(bit1).f(bit0.f(bit1));
		fn op14 = bit1.f(bit1).f(bit1.f(bit0));
		fn op15 = bit1.f(bit1).f(bit1.f(bit1));
		//These are the named ops in Op enum
		//such as ImportStatic.isLeaf is the fn for Op.isLeaf.
		if(op8 != isLeaf) throw new Error("op8["+op8+"] != isLeaf["+isLeaf+"]");
		lg("\r\n\r\n\r\n\r\nThe 16 ops derived from fn.universalLambdaFunction: "+op0+" "+op1+" "+op2+" "+op3+" "+op4+" "+op5+" "+op6+" "+op7+" "+op8+" "+op9+" "+op10+" "+op11+" "+op12+" "+op13+" "+op14+" "+op15+"\r\nsuch as (L L) is "+L.f(L)+" and (R L) is "+R.f(L)+" and ((L L)(R L)) is "+L.f(L).f(R.f(L))+"\r\n\r\n\r\n");
		lg("Go research and create and play in the space of all possibilities.");		
		
		TestBasics.main();
	}
}
