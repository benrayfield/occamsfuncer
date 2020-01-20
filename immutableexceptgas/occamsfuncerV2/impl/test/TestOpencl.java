package immutableexceptgas.occamsfuncerV2.impl.test;
import static immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2.fn;
import immutableexceptgas.occamsfuncerV2.impl.util.Example;
//import mutable.compilers.opencl.OpenclUtil;

public class TestOpencl{
	
	/*
	public static void testMatmul(){
		lg("Starting testMatmul");
		fn cl = nondet.f("openclNdrangeKernel");
		String matmulCode1dAs2d =
			"(int const bSize, int const cSize, int const dSize, global const float* bc, global const float* cd, global float* bdOut){"+
			"	int bd = get_global_id(0);\n"+
			"		const int b = bd/dSize;\n"+ //TODO optimize allow get_global_id(more dims)?//
			"		const int d = bd%dSize;\n"+ //TODO optimize allow get_global_id(more dims)?
			"		float sum = 0;\n"+
			"		for(int c=0; c<cSize; c++){\n"+
			"			sum += bc[b*cSize+c]*cd[c*dSize+d];\n"+ //TODO optimize allow get_global_id(more dims)?
			"		}\n"+
			"		bdOut[bd] = sum;\n"+
			"}";
		int a = 100, b = 150, c = 170;
		float[] floatArrayAB = new float[a*b];
		float[] floatArrayBC = new float[b*c];
		for(int i=0; i<floatArrayAB.length; i++){
			floatArrayAB[i] = i;
		}
		for(int i=0; i<floatArrayBC.length; i++){
			floatArrayBC[i] = i;
		}
		//fn matAB = f(floatArrayAB); //TODO optimize these should wrap in ArrayCbt with lazy dedup
		//fn matBC = f(floatArrayBC);
		fn paramForForestOfOpenclCalls =
			Example.tinyMap().f("ab").f(floatArrayAB).f("bc").f(floatArrayBC);
		fn getAB = Example.tinyMapGet().f("ab");
		fn getBC = Example.tinyMapGet().f("bc");
		
		fn typeAB = TODO;
		
		//FIXME cccc()? ccc()? call opencl using cc() since it will take 2 params,
		//or maybe another param for making sure the cbtBitstring it returns
		//is the expected size.
		//How about wrapping it in Example.enforceType() and the type is
		//that its a certain size and if its float or double etc then
		//its the normed form of those bits, and that its a certain cbtBitstring size.
		typeAB typeBC typeAC
		
		//takes 1 more param, whatever opencl returns from a specific
		//kernel call of that type and size,
		//and returns that same float[] aka cbtBitstring of float bits
		//or infloops (caught at nearest nondet spend call)
		//if not that type (including that all floats are normed and is expected size).
		//This is a filter of cbtBitstring of such float[] bits.
		//A cbtBitstring is a cbt padded
		//sparselyStored with cbt1 then cbt0s until next powOf2 size.
		fn enforceTypeAB = enforceType(float.class, a*b);
		
		//fn enforceTypeAB = Example.enforceType().f(typeAB);
		//fn enforceTypeBC = Example.enforceType().f(typeBC);
		//fn enforceTypeAC = Example.enforceType().f(typeAC);
		
		//fn enforceFSize = Example.enforceIsCertainSizeOfFloatArray();
		//enforceFSize.f(bitstringOfAll0sAndSize(a*b*32)).f(TODO); use in S(...)
		//enforceFSize.f(bitstringOfAll0sAndSize(b*c*32)).f(TODO); use in S(...
		//enforceFSize.f(bitstringOfAll0sAndSize(a*c*32)).f(TODO); use in S(...
		//ST(
		//	Example.enforceType(),
		//	typeAB, //FIXME is this the right place to put AB? what about BC AD?
		//	cc().f(cl.f(matmulCode1dAs2d))
		//}
		
		//TODO forest of matmuls and matadds to make sure it can do what ForestOp was
		//designed to do: multiple opencl calls before returning to java/lwjgl,
		//and for that would use multiple S calls to flow the paramForForestOfOpenclCalls
		//down the forest of S calls, aka ImportStatic.S(...) is a convenient
		//way to write such S call forests.
		fn forestOfLazyevalOpenclCalls = ST(
			enforceTypeAB,
			ST(
				cl...,
				paramsOfThatOpenclNdrangeKernel
			)
		)
		
		
		TODO for multiple returned matrixs, us S(...) or ST(...) etc
		to create a tinymap of the returned values,
		which occamsfuncer's JIT compiler will be designed to
		look for that pattern on both sides of the opencl call forest
		and call, for example depending on implementation,
		LWJGL opencl (or compute it with sticks and stones in a cave
		whatever gets the correct result its still occamsfuncer logic)
		or javassist or wasm or whatever...
		
		FIXME this should return a tinymap with "ac" as one of its keys,
		instead of returning matAC directly.
		//compute whole forest of opencl calls at once before returning, for low lag.
		fn openclReturnedMatAC = forestOfLazyevalOpenclCalls.f(paramForForestOfOpenclCalls);
		
		TODO verify its the correct result as calculated by multiplying them strictfp in cpu,
		and verify opencl is run in strictfp float32 mode else do it as ints or longs in opencl however slow.
	}
	
	public static void main(String... args){
		//FIXME shouldnt need trusted mode
		boolean wasTrusted = isTrustedMode();
		try{
			setTrustedMode(true);
			testMatmul();
		}finally{
			setTrustedMode(wasTrusted);
		}
		
	}
	*/

}
