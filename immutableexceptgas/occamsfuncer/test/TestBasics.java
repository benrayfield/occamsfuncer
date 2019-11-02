/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.test;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;

import immutableexceptgas.occamsfuncer.fn;

public class TestBasics{
	
	public static void t(boolean x){
		if(!x) throw new Error("Test failed");
	}
	
	public static void testIdentityFuncs(){
		fn stt = f(S,T,T);
		t(stt.f(I)==I);
		t(stt.f(T)==T);
		t(stt.f(F)==F);
		t(I.f(stt)==stt);
		t(I.f(T)==T);
	}
	
	/** See comments about MapPair MapSingle and MapEmpty
	in the Op.curry and Op.getParam in switch in Boot.
	There will be Compiled (2 BinaryOperator<fn>) for MapPair etc
	but it can also work without that optimization
	and will generate exactly the same ids for every possible id function.
	TODO also test that it generates the same ids when those optimizations
	are removed.
	<br><br>
	TODO also test that MapPair infloops when called on its "fields"
	that dont obey constraints, and do that in a nondetGet Spend call
	and catch the infloop and return (the bits of) a string saying so.
	<br><br>
	Derive MapPair, MapSingle, and MapEmpty and their constraints using Op.curry.
	(MapPair idFunc cbtAsSize minKey maxKey minChild maxChild getKey)
	returns value at that key.
	(MapSingle key value getKey)
	returns value at that key.
	(MapEmpty getKey) returns leaf cuz it contains no key/value pairs,
	so MapEmpty maybe should be (T leaf).
	*/
	public static void testDeriveAndUseTreemapWithConstraints(){
		TODO use Example.mapPair()
		
		TODO create a new class and put MapPair() static func
		in it that creates and caches ptr to a MapPair fn,
		so it can be used from java code but is only
		created if its used the first time.
		Put similar funcs in there too like for float and double
		and int and long arithmetic, mapPut, rule110, etc.
		After enough basics are there, and making it clear
		that those are NOT part of the occamsfuncer spec
		as they can be derived without that java code,
		I'll start programming in a 2d grid of fns
		that is itself a quadtree implemented in Op.pair
		a ui similar to iotadesktop/iotavm my project on github.
		
		Example.mapPair()
		throw new Error("TODO");
	}
	
	public static void main(String... args){
		testIdentityFuncs();
		lg("All tests passed (TODO write harder tests)");
	}

}
