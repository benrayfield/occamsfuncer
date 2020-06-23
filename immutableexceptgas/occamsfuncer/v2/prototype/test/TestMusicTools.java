/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.v2.prototype.test;

import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncer.v2.prototype.util.Boot;

public class TestMusicTools{
	
	//TODO use the doubleAssemblyVM thru Example.doubleAssemblyVM()
	
	/** an acyclicFlow of double[3] mapping to 3 more doubles,
	run in a loop, and 1 of them is dt. The other 2 are position and velocity
	which are eachothers plus/minus derives like sine and cosine.
	*/
	public static void testSpringVibrationWithoutOptimization(){
		lg("Starting testSpringVibration");
		throw new Error("TODO");
	}
	
	public static void main(String... args){
		testSpringVibrationWithoutOptimization();
		
		Boot.optimize(); //not called automatically so can test before optimizations and after such as in TestBasics
		
		//TODO implement the jsoundcard microphone volume norming by decaymax.
		
		//TODO port https://sourceforge.net/p/sparsedoppler/ to acyclicFlow
			
		//TODO port a certain audivolv sound effect to acyclicFlow
		
		
		/**TODO...
		
		Ocfn type of prim array, only allow 1d at contenttype level.
		Use (typelist "arrayOf" (typelist "application/x-ieee754-double")
				thebitstring), but I want the size 64 (which isn't always
						a powof2) to be specified somewhere cuz the outer
		array needs to know the block size. Or maybe it should be (typelist
				"application/x-ieee754-double[]" thebitstring)? No 
						contenttype rules say no [ ] chars. How about
						arrayOf-application/x-ieee754-double ? 
								application/x-ieee754-double-array1d ?
		...
		Create more ocfnplugs asap to make acyclicflow music work,
		compiled from s pairs and append at end to give back another
		arrayOf double.
		...
		For now do it with binheapindexing (Example.bhGet and Example.bhPut) 
		which means u have to know the height to know the array index but
		it's simple. Use emptybitstring as identityfunc. This is not getting 
		in comment branch and is optimized for cbt. Use double ops on cbt 
		instead of cbtbitstring which can build also for later. This way
		it will run fastest without acyclicflow optimization needed for 
		testing yet, bit for real-time sound will need that optimization.
		*/
		
	}

}
