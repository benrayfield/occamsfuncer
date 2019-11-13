/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.test;
import static immutableexceptgas.occamsfuncer.Example.*;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;

import immutableexceptgas.occamsfuncer.Boot;
import immutableexceptgas.occamsfuncer.Example;
import immutableexceptgas.occamsfuncer.Gas;
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
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("test pass: "+name);
	}
	
	/** WARNING: modifies Gas.top without conserving Gas */
	public static void testInfiniteLoopEndsCuzRunsOutOfGas(){
		lg("Starting testInfiniteLoopEndsCuzRunsOutOfGas");
		Gas.top = 1000;
		try{
			fn returned = fnThatInfiniteLoopsForEveryPossibleParam().f(leaf);
			throw new Error("testInfiniteLoopEndsCuzRunsOutOfGas failed. What should have infinite looped (until reach its resource limit) returned "+returned);
		}catch(Gas g){
			lg("testInfiniteLoopEndsCuzRunsOutOfGas passed by ending early"); 
		}
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
	
	public static void testIsUnaryCbt(){
		lg("Starting testIsUnaryCbt");
		for(int i=0; i<6; i++){
			test("unary"+i, isUnaryCbt(unary(i)));
		}
		test(!isUnaryCbt(leaf));
		test(!isUnaryCbt(leaf.f(leaf)));
		test(!isUnaryCbt(cbt0));
		test(!isUnaryCbt(cbt1.f(cbt0)));
		test(!isUnaryCbt(cbt0.f(cbt1)));
		test(!isUnaryCbt(cbt1.f(cbt1.f(cbt1))));
		test(!isUnaryCbt(S));
		test(!isUnaryCbt(T));
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
	
	public static void testGetp(){
		lg("Starting testGetp");
		fn funcBody = T; //return madeByCurry
		//cbt0 and cbt1 are the params of funcBody.
		//curry is still waiting since we lazyEvaled here
		//instead of letting curry create the lazyEval.
		fn x = f(curry,unary(6),T,funcBody);
		lg("x: "+x);
		fn madeByCurryForConstraint = f(lazyEval,x,cbt0);
		lg("madeByCurryForConstraint: "+madeByCurryForConstraint);;
		fn y = f(curry,unary(6),T,funcBody,cbt0);
		lg("y: "+y);
		fn madeByCurryForFuncBody = f(lazyEval,y,cbt1);
		lg("madeByCurryForFuncBody: "+madeByCurryForFuncBody);;
		
		testEqq("constraintGetsSecondLastParam", getParam(4,madeByCurryForConstraint), cbt0);
		testEqq("funcBodyGetsLastParam", getParam(5,madeByCurryForFuncBody), cbt1);
		testEqq("funcBodyGetsSecondLastParam", getParam(4,madeByCurryForFuncBody), cbt0);
		
		fn getpLeaf = getp.f(leaf); //first param is comment. leaf means no comment.
		testEqq("constraint_getpunary4_is_cbt0", getpLeaf.f(unary(4)).f(madeByCurryForConstraint), cbt0);
		testEqq("constraint_getpunary5_is_leaf_cuzParamIndexDoesntExist", getpLeaf.f(unary(5)).f(madeByCurryForConstraint), leaf);
		testEqq("constraint_getpunary6_is_leaf_cuzParamIndexDoesntExist", getpLeaf.f(unary(6)).f(madeByCurryForConstraint), leaf);
		testEqq("funcBody_getpunary4_is_cbt0", getpLeaf.f(unary(4)).f(madeByCurryForFuncBody), cbt0);
		testEqq("funcBody_getpunary5_is_cbt1", getpLeaf.f(unary(5)).f(madeByCurryForFuncBody), cbt1);
	}
	
	public static void testAnd(){
		lg("Starting testAnd");
		lg("and="+and());
		testEqq("and_F_F", and().f(F).f(F), F);
		testEqq("and_F_T", and().f(F).f(T), F);
		testEqq("and_T_F", and().f(T).f(F), F);
		testEqq("and_T_T", and().f(T).f(T), T);
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
		lg("equals="+equals);
		fn equalsLeaf = equals.f(leaf);
		lg("equalsLeaf="+equalsLeaf);
		testEqq("equals_leaf_leaf", equalsLeaf.f(leaf), T);
		testEqq("equals_leafLeaf_leafLeaf", equals.f(leafLeaf).f(leafLeaf), T);
		testEqq("equals_leafLeaf_copyOfLeafLeaf", equals.f(leafLeaf).f(leaf.f(leaf)), T);
		testEqq("equals_leaf_leafLeaf", equals.f(leaf).f(leafLeaf), F);
		testEqq("equalsA", equals.f(firstOp).f(copyOfFirstOp), T);
		testEqq("equalsB", equals.f(copyOfFirstOp).f(firstOp), T);
		testEqq("equalsC", equals.f(secondOp).f(copyOfFirstOp), F);
		testEqq("equalsD", equals.f(copyOfFirstOp).f(secondOp), F);
		fn sii = CP(CP(S,I),I);
		fn copyOf_lazyEval_sii_sii = CP(CP(lazyEval,sii),sii);
		test(
			"somethingLambdaFuncsCantDoCuzItWouldInfiniteLoop",
			T == equals
				.f(fnThatInfiniteLoopsForEveryPossibleParam())
				.f(copyOf_lazyEval_sii_sii)
		);
		test("equals(equals,equals)==T", equals.f(equals).f(equals)==T);
		//Unless optimizations have been turned on (shouldnt be yet, TODO verify),
		//none of these fns use java == or .equals and are running
		//only as combos of a universal lambda func,
		//which can still detect equality between a lambda and itself
		//even if the lambda its asked about infinite loops for every
		//possible param. It can detect this cuz of the
		//ability to see left and right childs
		//where (equals ((L x)(R x))) is T for every x,
		//and at the java level so is x.L().f(x.R()).equals(x) for every x,
		//and if you're deduping using a hashtable
		//(which is normally disabled for cbt bitstring optimizations)
		//then also x.L().f(x.R())==x for every x.
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
		testInfiniteLoopEndsCuzRunsOutOfGas();
		Gas.top = 1e6;
		testSTLR();
		testIdentityFuncs();
		testSCurryList();
		testIsUnaryCbt();
		testGetp();
		testAnd();
		//TODO test (curry cbtAsUnary5 T).setCompiled(...) for
		//1-7 params after the standard curry params
		testEqualsWithoutOptimizationsOrDedup();
		testSLinkedList();
		lg("All tests passed (TODO write harder tests)");
	}

}

