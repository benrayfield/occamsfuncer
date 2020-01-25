package mutable.occamsfuncerV2.start;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2Prototype.TheUniversalLambdaFunction;
import immutableexceptgas.occamsfuncerV2Prototype.fns.Leaf;
import immutableexceptgas.occamsfuncerV2Prototype.test.TestBasics;
import immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic;
import immutableexceptgas.occamsfuncerV2Spec.Gas;
import immutableexceptgas.occamsfuncerV2Spec.Op;
import immutableexceptgas.occamsfuncerV2Spec.fn;

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
		fn u = TheUniversalLambdaFunction.instance;
		lg("universalLambdaFunction: "+u);
		fn uu = u.f(u);
		fn opBit0 = u.f(uu);
		fn opBit1 = uu.f(u);
		fn op0 =  opBit0.f(opBit0).f(opBit0.f(opBit0));
		fn op1 =  opBit0.f(opBit0).f(opBit0.f(opBit1));
		fn op2 =  opBit0.f(opBit0).f(opBit1.f(opBit0));
		fn op3 =  opBit0.f(opBit0).f(opBit1.f(opBit1));
		fn op4 =  opBit0.f(opBit1).f(opBit0.f(opBit0));
		fn op5 =  opBit0.f(opBit1).f(opBit0.f(opBit1));
		fn op6 =  opBit0.f(opBit1).f(opBit1.f(opBit0));
		fn op7 =  opBit0.f(opBit1).f(opBit1.f(opBit1));
		fn op8 =  opBit1.f(opBit0).f(opBit0.f(opBit0));
		fn op9 =  opBit1.f(opBit0).f(opBit0.f(opBit1));
		fn op10 = opBit1.f(opBit0).f(opBit1.f(opBit0));
		fn op11 = opBit1.f(opBit0).f(opBit1.f(opBit1));
		fn op12 = opBit1.f(opBit1).f(opBit0.f(opBit0));
		fn op13 = opBit1.f(opBit1).f(opBit0.f(opBit1));
		fn op14 = opBit1.f(opBit1).f(opBit1.f(opBit0));
		fn op15 = opBit1.f(opBit1).f(opBit1.f(opBit1));
		//These are the named ops in Op enum
		//such as ImportStatic.isLeaf is the fn for Op.isLeaf.
		if(op8 != isLeaf) throw new Error("op8["+op8+"] != isLeaf["+isLeaf+"]");
		if(L.f(L).f(R.f(L)) != L) throw new Error("((L L)(R L)) != L");
		lg("\r\n\r\n\r\n\r\nThe 16 ops derived from fn.universalLambdaFunction: "+op0+" "+op1+" "+op2+" "+op3+" "+op4+" "+op5+" "+op6+" "+op7+" "+op8+" "+op9+" "+op10+" "+op11+" "+op12+" "+op13+" "+op14+" "+op15+"\r\nsuch as (L L) is "+L.f(L)+" and (R L) is "+R.f(L)+" and ((L L)(R L)) is "+L.f(L).f(R.f(L))+"\r\n\r\n\r\n");
		lg("Go research and create and play in the space of all possibilities.");		
		
		//TestBasics.main();
	}
}
