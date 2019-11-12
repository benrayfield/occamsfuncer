/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.test;
import static immutableexceptgas.occamsfuncer.Example.*;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;

import immutableexceptgas.occamsfuncer.Boot;
import immutableexceptgas.occamsfuncer.Example;
import immutableexceptgas.occamsfuncer.fn;
import immutableexceptgas.occamsfuncer.impl.fns.Call;

public class TestBasics{
	
	public static void test(boolean x){
		if(!x) throw new Error("Test failed");
		lg("test pass");;
	}
	
	public static void test(String name, boolean x){
		if(!x) throw new Error("Test failed: "+name);
		lg("test pass: "+name);;
	}
	
	public static void testEqq(String name, Object a, Object b){
		if(a != b) throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		lg("test pass: "+name);
	}
	
	public static void testSTLR(){
		lg("Starting testSTLR");
		fn st = S.f(T);
		test("st.L()==S", st.L()==S);
		test("st.R()==T", st.R()==T);
	}
	
	/** tests ImportStatic.S(...) which is s-lambda-level 1 (s is level 0) */
	public static void testSCurryList(){
		lg("Starting testSCurryList");
		test("pair.f(getp).f(curry).f(T)==getp", pair.f(getp).f(curry).f(T)==getp);
		test("pair.f(getp).f(curry).f(F)==curry", pair.f(getp).f(curry).f(F)==curry);
		test("t(getp)==T.f(getp)", t(getp)==T.f(getp));
		test("T.f(getp).f(curry)==getp", T.f(getp).f(curry)==getp);
		
		fn ll = leaf.f(leaf);
		fn llll = ll.f(ll);
		
		fn SCurry01 = S(t(cbt0), t(cbt1));
		fn cbt01 = cbt0.f(cbt1);
		fn cbt01__2 = SCurry01.f(llll);
		lg("cbt01: "+cbt01);
		lg("cbt01__2: "+cbt01__2);
		test(cbt01==cbt01__2);
		
		//cuz of the t(...) on each thing, it ignores param (leaf) and quotes all 3.
		fn SCurryA = S(t(pair), t(getp), t(curry));
		lg("SCurryA: "+SCurryA);
		fn pair_getp_curry = pair.f(getp).f(curry);
		lg("pair_getp_curry: "+pair_getp_curry);
		fn pair_getp_curry__2 = SCurryA.f(leaf);
		test(pair_getp_curry == pair_getp_curry__2);
		
		//cuz of the t(...) on each thing, it ignores param (leaf) and quotes all 3.
		fn SCurryB = S(t(T), t(getp), t(curry));
		lg("SCurryB: "+SCurryB);
		testEqq("f(S(t(T), t(getp), t(curry)),leaf)==getp", f(SCurryB,leaf), getp);
		
		
		test("F.f(getp).f(curry)==getp", F.f(getp).f(curry)==curry);
		
		//cuz of the t(...) on each thing, it ignores param (leaf) and quotes all 3.
		fn SCurryC = S(t(F), t(getp), t(curry));
		testEqq("f(S(t(F), t(getp), t(curry)),leaf)==curry", f(SCurryC,leaf), curry);
		
		//FIXME undecided what S(...1thing...)returns test("S(t(I), getp)==getp", S(t(I), getp)==getp);
	}
	
	public static void testIdentityFuncs(){
		lg("Starting testIdentityFuncs");
		fn stt = f(S,T,T);
		test("leaf.L()==I", leaf.L()==I);
		test("leaf.R()==leaf", leaf.R()==leaf);
		test("stt.f(I)==I", stt.f(I)==I);
		test("stt.f(T)==T", stt.f(T)==T);
		test("stt.f(F)==F", stt.f(F)==F);
		test("I.f(stt)==stt", I.f(stt)==stt);
		test("I.f(T)==T", I.f(T)==T);
	}
	
	public static void testAnd(){
		lg("Starting testAnd");
		test(and().f(F).f(F)==F);
		test(and().f(F).f(T)==F);
		test(and().f(T).f(F)==F);
		test(and().f(T).f(T)==T);
	}
	
	/** Test the fn returned by Example.equals()
	without the Compiled optimization that compares by height, ==, andOr id,
	and without Cache dedup of <func,param,return> on the 2 funcs to be
	compared for equality but with <func,param,return> caching in the
	equals func cuz otherwise it would have exponential cost,
	but maybe that would be ok for a very small pair of things
	to compare for equality.
	*/
	public static void testEqualsWithoutOptimizationsOrDedup(){
		lg("Starting testEqualsWithoutOptimizationsOrDedup");
		fn leafLeaf = new Call(leaf,leaf);
		fn zero = new Call(leaf,leafLeaf);
		//fn one = new Call(leafLeaf,leaf);
		fn zeroZero = new Call(zero,zero);
		fn copyOfFirstOp = new Call(zeroZero,zeroZero);
		fn firstOp = Boot.op(0);
		fn secondOp = Boot.op(1);
		fn equals = Example.equals();
		test("equalsA", equals.f(firstOp).f(copyOfFirstOp)==T);
		test("equalsB", equals.f(copyOfFirstOp).f(firstOp)==T);
		test("equalsC", equals.f(secondOp).f(copyOfFirstOp)==F);
		test("equalsD", equals.f(copyOfFirstOp).f(secondOp)==F);
	}
	
	/** tests ImportStatic.L(...) which is s-lambda-level 1 (s is level 0).
	f(L(a b c) p) returns same as l((a p)(b p)(c p)) aka linkedlist of
	what those 3 things eval to. Similar to testSCurryList but for making linkedlist.
	*/
	public static void testSLinkedList(){
		lg("Starting testSLinkedList");
		throw new Error("TODO");
	}
	
	/** get treemap working which is a function of these params
	(curry cbtAsSize constraint funcBody viewObjectAsNumberForSorting
	cbtAsSize minKey maxKey minChild maxChild getKey)
	that function returns the value at key getKey. Theres also MapSingle
	and MapEmpty funcs. They're all anonymous function calls of the curry op.
	<br><br>
	See comments about MapPair MapSingle and MapEmpty
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
	(MapPair viewObjectAsNumberForSorting cbtAsSize minKey maxKey minChild maxChild getKey)
	returns value at that key.
	(MapSingle key value getKey)
	returns value at that key.
	(MapEmpty getKey) returns leaf cuz it contains no key/value pairs,
	so MapEmpty maybe should be (T leaf).
	*
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
	}*/
	
	public static void main(String... args){
		testSTLR();
		testIdentityFuncs();
		testSCurryList();
		testAnd();
		testEqualsWithoutOptimizationsOrDedup();
		testSLinkedList();
		lg("All tests passed (TODO write harder tests)");
	}

}

