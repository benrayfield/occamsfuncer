/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.simpleSlowPrototype;
import static immutable.occamsfuncer.simpleSlowPrototype.Log.*;
import static immutable.occamsfuncer.simpleSlowPrototype.OcfnUtil.*;

//import static immutable.util.TestUtil.*;
import java.util.Arrays;

import immutable.occamsfuncer.fn;

/** FIXME make the tests independent of implementation, other than you cant call java from js,
but I do have a simpleSlowPrototype dir and an impl dir that will be 2 implementations of fn.java,
and I want to share tests between them, other than the problem of simpleSlowPrototype
lacks Compiled.java optimizations so will be impractically slow for most things.
It will still be fast enough for the basics of math etc, so share those tests.
*/
public class TestSpec{
	
	//TODO simplify this test code, something similar to JUnit,
	//but since its to be available at runtime and I dont want this simple spec to depend on extra libraries,
	//these few funcs might be the simplest way.
	//Unlike most programs, occamsfuncer is stateless except for a few memory and compute statistics etc,
	//so theres no setup and teardown like junit helps with.
	
	public static void test(boolean x){
		if(!x) throw new Error("Test failed");
		lg("### test pass");;
	}
	
	public static void test(String name, boolean x){
		if(!x) throw new Error("Test failed: "+name);
		lg("### test pass: "+name);;
	}
	
	public static void testEqq(String name, Object a, Object b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testEqq pass: "+name);
	}
	
	public static void testNotEqq(String name, Object a, Object b){
		if(a == b){
			throw new Error("Test failed (cuz they equal but shouldnt): "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testNotEqq pass: "+name);
	}
	
	public static void testEqq(String name, long a, long b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testEqq pass: "+name);
	}
	
	public static void testEqq(String name, double a, double b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testEqq pass: "+name);
	}
	
	public static void testDotEq(String name, Object a, Object b){
		if(!a.equals(b)){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testDotEq pass: "+name);
	}

	
	//FIXME this was copied from ocfn3r, need to modify all code and comments to have 9 params of universalFunc instead of 10
	
	
	public static void testBootIsT(){
	//public static void testBootIsTAndIsUnaryBit(){
		lg("Starting testBootIsT");
		test("bootIsT T", bootIsT(T));
		test("!bootIsT F", !bootIsT(F));
		test("!bootIsT I", !bootIsT(I));
		test("!bootIsT u", !bootIsT(u));
		test("!bootIsT uu", !bootIsT(uu));
		test("!bootIsT op0", !bootIsT(op(0)));
		test("!bootIsT op1", !bootIsT(op(1)));
		test("!bootIsT op2", !bootIsT(op(2)));
	}
	
	public static void testFnDotIdentityfunc(){
		lg("Starting testFnDotIdentityfunc");
		testEqq("I==u.identityFunc()", I, u.identityFunc());
		testEqq("I==T.identityFunc()", I, T.identityFunc());
		testEqq("derive I/IdentityFunc", u.e(u).e(u.e(u)).e(u).e(u).e(u.e(u)).e(u).e(u).e(u).e(u).e(u).e(u).e(u).e(u).e(u), I);
		testEqq("(I P)==P", I.e(P), P);
	}
	
	public static void testTF(){
		lg("Starting testTF");
		fn t_n = T.e(N);
		testEqq("(T N).func()->T", t_n.func(), T);
		testEqq("(T N).param()->N", t_n.param(), N);
		testEqq("(T N u)->N", t_n.e(u), N);
		testEqq("(T N P)->N", t_n.e(P), N);
		fn f_n = F.e(N);
		testEqq("(F N).func()->F", f_n.func(), F);
		testEqq("(F N).param()->N", f_n.param(), N);
		testEqq("(F N u)->u", f_n.e(u), u);
		testEqq("(F N P)->P", f_n.e(P), P);
	}
	
	public static void testPair(){
		lg("Starting testPair");
		testEqq("(pair N) is halted", P.e(N), P.e(N));
		testEqq("(pair N u) is halted", P.e(N).e(u), P.e(N).e(u));
		fn pair_N = P.e(N);
		fn lazy_pair_N_u = pair_N.f(u);
		fn pair_N_u = lazy_pair_N_u.e();
		testEqq("(pair N u T)->N", pair_N_u.e(T), N);
		testEqq("(pair N u F)->u", pair_N_u.e(F), u);
	}
	
	public static void testIota(){
		lg("Starting testIota");
		fn x = iota;
		lg("iota = "+x);
		
		/* From ocfn3r:
		Starting testIota
		iota = ((P S) T)
		start eval: {((P S) T)((P S) T)}
		start step: {((P S) T)((P S) T)}
		After setCacheKey: {((P S) T)((P S) T) c<{((P S) T)((P S) T)}>}
		step returning {{((P S) T) S} T c<{{((P S) T) S} T}>}
		start step: {{((P S) T) S} T c<{{((P S) T) S} T}>}
		step returning {((P S) T) S l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		start step: {((P S) T) S l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		After setCacheKey: {((P S) T) S c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		
		step returning ((S S) T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		start step: ((S S) T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		Write cache (mid), key={((P S) T) S}
		Write cache (mid), val=((S S) T)
		step returning {((S S) T) T c<{{((P S) T) S} T}>}
		start step: {((S S) T) T c<{{((P S) T) S} T}>}
		step returning ((S T)(T T) c<((S T)(T T))>)
		end eval: ((S T)(T T)) --- is eval of: {((P S) T)((P S) T)}
		iotaIota = ((S T)(T T))
		*/
		
		/*
		After setCacheKey: {((P S) T) S c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		{
			((P S) T)
			S
			c<{((P S) T) S}>
			l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>
		}
		
		CORRECT:
		step returning ((S S) T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		(
			(S S)
			T
			c<{((P S) T) S}>
			l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>
		)
		
		OBSERVED 2020-8-27-915a after changed var "n" to "evalingState" cuz there were multiple n vars:
		step returning {{S S} T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		{
			{S S}
			T
			c<{((P S) T) S}>
			l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>
		}
		It differs only by {S S} meaning !isHaltedAbove vs (S S) meaning isHaltedAbove
		
		OBSERVED 2020-8-23-10a:
		step returning {{S S} T c<{{S S} T}>}
		{
			{S S}
			T
			c<{{S S} T}>
		}
		*/
		fn iotaIota = x.e(x);
		lg("(iota iota) -> "+iotaIota);
		
		
		/** ocfn3r:
		Starting testIota
		iota = ((P S) T)
		start eval: {((P S) T)((P S) T)}
		start step: {((P S) T)((P S) T)}
		After setCacheKey: {((P S) T)((P S) T) c<{((P S) T)((P S) T)}>}
		step returning {{((P S) T) S} T c<{{((P S) T) S} T}>}
		start step: {{((P S) T) S} T c<{{((P S) T) S} T}>}
		step returning {((P S) T) S l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		start step: {((P S) T) S l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		After setCacheKey: {((P S) T) S c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		
		step returning ((S S) T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		start step: ((S S) T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		Write cache (mid), key={((P S) T) S}
		Write cache (mid), val=((S S) T)
		step returning {((S S) T) T c<{{((P S) T) S} T}>}
		start step: {((S S) T) T c<{{((P S) T) S} T}>}
		step returning ((S T)(T T) c<((S T)(T T))>)
		end eval: ((S T)(T T)) --- is eval of: {((P S) T)((P S) T)}
		iotaIota = ((S T)(T T))
		
		After setCacheKey: {((P S) T) S c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		
		CORRECT:
		step returning ((S S) T c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		
		OBSERVED:
		step returning {{S S} T c<{{S S} T}>}
		
		----
		After those changes, the problem is seen in...
		
		start step: {(S T) {T T} c<{{S T}{T T}}>}
		step returning {T T r<{(S T) {T T} c<{{S T}{T T}}>}>}
		start step: {T T r<{(S T) {T T} c<{{S T}{T T}}>}>}
		After setCacheKey: {T T c<{T T}> r<{(S T) {T T} c<{{S T}{T T}}>}>}
		Returning from cache. Before restack: (T T)
		Returning from cache: (T T r<{T T}>) //this line is wrong cuz the r stack was bigger, and maybe it shouldnt have an r stack at all... code appears to call truncateToStackBottom which shouldnt have cacheKey or stack
		start step: (T T r<{T T}>)
		step returning {T (T T)}
		start step: {T (T T)}
		After setCacheKey: {T (T T) c<{T (T T)}>}
		step returning (T (T T) c<(T (T T))>)
		end eval: (T (T T)) --- is eval of: {((P S) T)((P S) T)}
		
		T
		*/
		testEqq("(iota iota)->(S T (T T))", iotaIota, bootF(S,T,bootF(T,T)));
		
		testEqq("(iota iota N) cuz iota iota is an identityFunc", iotaIota.e(N), N);
		
		/** from ocfn3r (works) 2020-8-29-1220p:
		end eval: N --- is eval of: {((S T)(T T)) N}
		### testEqq pass: (iota iota N) cuz iota iota is an identityFunc
		start eval: {((P S) T)((P S) T)}
		start step: {((P S) T)((P S) T)}
		After setCacheKey: {((P S) T)((P S) T) c<{((P S) T)((P S) T)}>}
		step returning {{((P S) T) S} T c<{{((P S) T) S} T}>}
		start step: {{((P S) T) S} T c<{{((P S) T) S} T}>}
		step returning {((P S) T) S l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		start step: {((P S) T) S l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		After setCacheKey: {((P S) T) S c<{((P S) T) S}> l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>}
		Returning from cache. Before restack: ((S S) T)
		Returning from cache: ((S S) T l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		start step: ((S S) T l<{{((P S) T) S} T c<{{((P S) T) S} T}>}>)
		step returning {((S S) T) T c<{{((P S) T) S} T}>}
		start step: {((S S) T) T c<{{((P S) T) S} T}>}
		step returning ((S T)(T T) c<((S T)(T T))>)
		end eval: ((S T)(T T)) --- is eval of: {((P S) T)((P S) T)}
		start eval: {((P S) T)((S T)(T T))}
		start step: {((P S) T)((S T)(T T))}
		After setCacheKey: {((P S) T)((S T)(T T)) c<{((P S) T)((S T)(T T))}>}
		step returning {{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}
		start step: {{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}
		step returning {((S T)(T T)) S l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		start step: {((S T)(T T)) S l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		After setCacheKey: {((S T)(T T)) S c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		step returning {(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		start step: {(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		step returning {(T T) S r<{(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}>}
		start step: {(T T) S r<{(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}>}
		After setCacheKey: {(T T) S c<{(T T) S}> r<{(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}>}
		step returning (((opPrefix .)(..)). c<{(T T) S}> r<{(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}>)
		start step: (((opPrefix .)(..)). c<{(T T) S}> r<{(T S) {(T T) S} c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}>)
		Write cache (mid), key={(T T) S}
		Write cache (mid), val=T
		step returning {(T S) T c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		start step: {(T S) T c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>}
		step returning ((((((..).).)(..))(..)). c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>)
		start step: ((((((..).).)(..))(..)). c<{((S T)(T T)) S}> l<{{((S T)(T T)) S} T c<{{((S T)(T T)) S} T}>}>)
		Write cache (mid), key={((S T)(T T)) S}
		Write cache (mid), val=S
		step returning {S T c<{{((S T)(T T)) S} T}>}
		start step: {S T c<{{((S T)(T T)) S} T}>}
		step returning (S T c<(S T)>)
		end eval: (S T) --- is eval of: {((P S) T)((S T)(T T))}
		start eval: {((P S) T)(S T)}
		start step: {((P S) T)(S T)}
		After setCacheKey: {((P S) T)(S T) c<{((P S) T)(S T)}>}
		step returning {((S T) S) T c<{((S T) S) T}>}
		start step: {((S T) S) T c<{((S T) S) T}>}
		step returning {(T T)(S T) c<{(T T)(S T)}>}
		start step: {(T T)(S T) c<{(T T)(S T)}>}
		step returning (((opPrefix .)(..)). c<T>)
		end eval: T --- is eval of: {((P S) T)(S T)}
		### testEqq pass: get T from iota
		
		
		from this occamsfuncer (broken) 2020-8-29-1220p:
		end eval: N --- is eval of: {((S T)(T T)) N}
		### testEqq pass: (iota iota N) cuz iota iota is an identityFunc
		start eval: {((P S) T)((P S) T)}
		start step: {((P S) T)((P S) T)}
		After setCacheKey: {((P S) T)((P S) T) c<{((P S) T)((P S) T)}>}
		step returning {{((P S) T) S} T}
		start step: {{((P S) T) S} T}
		step returning {((P S) T) S l<{{((P S) T) S} T}>}
		start step: {((P S) T) S l<{{((P S) T) S} T}>}
		Returning from cache. Before restack: ((S S) T)
		Returning from cache: ((S S) T)
		end eval: ((S S) T) --- is eval of: {((P S) T)((P S) T)}
		start eval: {((P S) T)((S S) T)}
		start step: {((P S) T)((S S) T)}
		After setCacheKey: {((P S) T)((S S) T) c<{((P S) T)((S S) T)}>}
		step returning {{((S S) T) S} T}
		start step: {{((S S) T) S} T}
		step returning {((S S) T) S l<{{((S S) T) S} T}>}
		start step: {((S S) T) S l<{{((S S) T) S} T}>}
		After setCacheKey: {((S S) T) S c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		step returning {{S S}{T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		start step: {{S S}{T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		step returning {S S l<{{S S}{T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>}
		start step: {S S l<{{S S}{T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>}
		step returning (S S l<{{S S}{T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>)
		start step: (S S l<{{S S}{T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>)
		step returning {(S S) {T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		start step: {(S S) {T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		step returning {T S r<{(S S) {T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>}
		start step: {T S r<{(S S) {T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>}
		step returning (T S r<{(S S) {T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>)
		start step: (T S r<{(S S) {T S} c<{((S S) T) S}> l<{{((S S) T) S} T}>}>)
		step returning {(S S)(T S) c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		start step: {(S S)(T S) c<{((S S) T) S}> l<{{((S S) T) S} T}>}
		step returning ((S S)(T S) c<{((S S) T) S}> l<{{((S S) T) S} T}>)
		start step: ((S S)(T S) c<{((S S) T) S}> l<{{((S S) T) S} T}>)
		Write cache (mid), key={((S S) T) S}
		Write cache (mid), val=((S S)(T S))
		step returning {((S S)(T S)) T}
		start step: {((S S)(T S)) T}
		After setCacheKey: {((S S)(T S)) T c<{((S S)(T S)) T}>}
		step returning {{S T}{(T S) T}}
		start step: {{S T}{(T S) T}}
		step returning {S T l<{{S T}{(T S) T}}>}
		start step: {S T l<{{S T}{(T S) T}}>}
		step returning (S T l<{{S T}{(T S) T}}>)
		start step: (S T l<{{S T}{(T S) T}}>)
		step returning {(S T) {(T S) T}}
		start step: {(S T) {(T S) T}}
		step returning {(T S) T r<{(S T) {(T S) T}}>}
		start step: {(T S) T r<{(S T) {(T S) T}}>}
		After setCacheKey: {(T S) T c<{(T S) T}> r<{(S T) {(T S) T}}>}
		step returning ((((((((((((..)(..))(..)).)(..)).).).).).).). c<{(T S) T}> r<{(S T) {(T S) T}}>)
		start step: ((((((((((((..)(..))(..)).)(..)).).).).).).). c<{(T S) T}> r<{(S T) {(T S) T}}>)
		Write cache (mid), key={(T S) T}
		Write cache (mid), val=S
		step returning {(S T) S}
		start step: {(S T) S}
		step returning ((S T) S)
		end eval: ((S T) S) --- is eval of: {((P S) T)((S S) T)}
		start eval: {((P S) T)((S T) S)}
		start step: {((P S) T)((S T) S)}
		After setCacheKey: {((P S) T)((S T) S) c<{((P S) T)((S T) S)}>}
		step returning {{((S T) S) S} T}
		start step: {{((S T) S) S} T}
		step returning {((S T) S) S l<{{((S T) S) S} T}>}
		start step: {((S T) S) S l<{{((S T) S) S} T}>}
		After setCacheKey: {((S T) S) S c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		step returning {{T S}{S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		start step: {{T S}{S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		step returning {T S l<{{T S}{S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>}
		start step: {T S l<{{T S}{S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>}
		step returning (T S l<{{T S}{S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>)
		start step: (T S l<{{T S}{S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>)
		step returning {(T S) {S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		start step: {(T S) {S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		step returning {S S r<{(T S) {S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>}
		start step: {S S r<{(T S) {S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>}
		step returning (S S r<{(T S) {S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>)
		start step: (S S r<{(T S) {S S} c<{((S T) S) S}> l<{{((S T) S) S} T}>}>)
		step returning {(T S)(S S) c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		start step: {(T S)(S S) c<{((S T) S) S}> l<{{((S T) S) S} T}>}
		step returning ((((((((((((..)(..))(..)).)(..)).).).).).).). c<{((S T) S) S}> l<{{((S T) S) S} T}>)
		start step: ((((((((((((..)(..))(..)).)(..)).).).).).).). c<{((S T) S) S}> l<{{((S T) S) S} T}>)
		Write cache (mid), key={((S T) S) S}
		Write cache (mid), val=S
		step returning {S T}
		start step: {S T}
		step returning (S T)
		end eval: (S T) --- is eval of: {((P S) T)((S T) S)}
		Exception in thread "main" java.lang.Error: Test failed: get T from iota a[(S T)] b[T]
			at occamsfuncer.spec.TestSpec.testEqq(TestSpec.java:31)
			at occamsfuncer.spec.TestSpec.testIota(TestSpec.java:282)
			at occamsfuncer.spec.TestSpec.main(TestSpec.java:566)
		*/
		
		testEqq("get T from iota", x.e(x.e(x.e(x))), T);
		testEqq("get S from iota", x.e(x.e(x.e(x.e(x)))), S);
		lg("Tests pass: testIota");
	}
	
	/*public static void thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger(){
		lg("Starting thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger");
		Node x = f(P,f(I,N),f(I,N));
		OcfnUtil.forABreakpoint = true;
		Node pnn = eval(x); //returns (P N N)
		OcfnUtil.forABreakpoint = false;
		testEqq("pnn", pnn, bootF(P,N,N));
	}*/
	
	public static void testIsHalted(){
		lg("Starting testIsHalted");
		for(int params=0; params<15; params++){
			Node[] p = new Node[params+1];
			Arrays.fill(p, u);
			test("isHalted . "+params+"params", f(p).isHaltedAbove());
		}
		test("isHalted (..(..))", f(u,u,f(u,u)).isHaltedAbove());
		test("isHalted should be false . 15params", !f(u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u).isHaltedAbove());
		test("isHalted should be false (remember, universalFunc always curries 15 params, so any more are lazy after that 15 returns which is also lazy) . 11params", !f(u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u,u).isHaltedAbove());
	}
	
	
	public static void testLeafAndFewOpsInternalStructures_withFewThingsCommentedOutCuzCodeWasFromDiffUniversalFunc_todoAddSimilarTests(){
		lg("Starting testLeaf");
		testEqq("(L Leaf)", L(u), I);
		testEqq("(R leaf)", R(u), u);
		//testEqq("L(F)==op0", L(F), op0);
		//testEqq("L(L(I))==op0", L(L(I)), op0);
		//testEqq("L(T)==op1", L(T), op1);
		//testEqq("L(L(L))==op2", L(L(L)), op2);
		//testEqq("L(L(R))==op3", L(L(R)), op3);
		testEqq("(L Leaf) 2", e(L,u), I);
		testEqq("(R leaf) 2", e(R,u), u);
	}
	
	public static void testSTLR(){
		lg("Starting testSTLR");
		fn st = f(S,T);
		test("st.L()==S", L(st)==S);
		test("st.R()==T", R(st)==T);
		test("st.L()==S 2", e(L,st)==S);
		test("st.R()==T 2", e(R,st)==T);
	}
	
	public static void testLRQuine(fn x){
		testEqq("testLRQuine_"+x, e(L,x,f(R,x)), x);
	}
	
	public static void testLRQuine(){
		lg("Starting testLRQuine");
		fn uuNonhalted = f(u,u);
		testEqq("step (..) becomes halted on (..)", setCacheKey(step(uuNonhalted),null), bootF(u,u));
		testLRQuine(u);
		testLRQuine(e(u,u));
		testLRQuine(L);
		testLRQuine(R);
		//TODO more calls of testLRQuine
	}
	
	public static void testIdentityFuncs(){
		lg("Starting testIdentityFuncs");
		fn stt = e(S,T,T);
		test("leaf.L()==I", e(L,u)==I);
		test("leaf.R()==leaf", e(R,u)==u);
		test("stt.f(I)==I", e(stt,I)==I);
		test("stt.f(T)==T", e(stt,T)==T);
		test("stt.f(F)==F", e(stt,F)==F);
		test("I.f(stt)==stt", e(I,stt)==stt);
		test("I.f(T)==T", e(I,T)==T);
	}
	
	public static void testConsCarCdr(){
		lg("Starting testConsCarCdr. Nil is leaf/theUniversalFunction. isNil is the isLeaf op.");
		fn list_N_A_L = cons.e(N).e(cons.e(A).e(cons.e(L).e(nil)));
		testEqq("testConsCarCdr_1", car.e(list_N_A_L), N);
		testEqq("testConsCarCdr_2", car.e(cdr.e(list_N_A_L)), A);
		testEqq("testConsCarCdr_3", car.e(cdr.e(cdr.e(list_N_A_L))), L);
		testEqq("testConsCarCdr_4", cdr.e(cdr.e(cdr.e(list_N_A_L))), nil);
		testEqq("isNil_nil", isNil.e(nil), T);
		testEqq("isNil_[list_N_A_L]", isNil.e(list_N_A_L), F);
	}
	
	public static void testBigCallParams(){
		lg("Starting testBigCallParams");
		//The universalFunc always curries 15 params (more if lazy, but uses 15 at a time recursively).
		//7 of its 16 opcodes are a lambda call on 1-7 params. The last 1-7 of those (p(9) to p(15)) are those params.
		//Just before those are: comment funcBody context <...the 1-7 params...>.
		testEqq("lambda7.p15", e(lambda(7,p(15)),L,R,P,A,N,T,S), S);
		testEqq("lambda7.p14", e(lambda(7,p(14)),L,R,P,A,N,T,S), T);
		testEqq("lambda7.p13", e(lambda(7,p(13)),L,R,P,A,N,T,S), N);
		testEqq("lambda7.p12", e(lambda(7,p(12)),L,R,P,A,N,T,S), A);
		testEqq("lambda7.p11", e(lambda(7,p(11)),L,R,P,A,N,T,S), P);
		testEqq("lambda7.p10", e(lambda(7,p(10)),L,R,P,A,N,T,S), R);
		testEqq("lambda7.p9",  e(lambda(7, p(9)),L,R,P,A,N,T,S), L);
		testEqq("lambda7.p8",  e(lambda(7, p(8)),L,R,P,A,N,T,S), defaultContext);
		testEqq("lambda7.p7",  e(lambda(7, p(7)),L,R,P,A,N,T,S), p(7)); //p(7) is funcBody in this call
		testEqq("lambda7.p6",  e(lambda(7, p(6)),L,R,P,A,N,T,S), defaultComment);
		testEqq("lambda7.p5",  e(lambda(7, p(5)),L,R,P,A,N,T,S), R(op(7)));
		testEqq("lambda7.p4",  e(lambda(7, p(4)),L,R,P,A,N,T,S), R(L(op(7))));
		testEqq("lambda7.p3",  e(lambda(7, p(3)),L,R,P,A,N,T,S), R(L(L(op(7)))));
		testEqq("lambda7.p2",  e(lambda(7, p(2)),L,R,P,A,N,T,S), R(L(L(L(op(7))))));
		testEqq("lambda7.p1",  e(lambda(7, p(1)),L,R,P,A,N,T,S), u); //cuz first of 15 params is leaf for the universalFunc and nonleaf for future expansion
		
		//see OcfnUtil.equals for an example of tree recursion using this way of getting its own funcBody etc.
		testEqq("lambda5.p9",  e(lambda(5,p(9)),     P,A,N,T,S), p(9)); //p(9) is funcBody in this call
		testEqq("lambda6.p8",  e(lambda(6,p(8)),   R,P,A,N,T,S), p(8)); //p(8) is funcBody in this call
		
		//testEqq("lambda7.p12", e(lambda(7,p(12)),L,R,P,A,N,T,S), A);
		//testEqq("lambda7.p14", e(lambda(7,p(14)),L,R,P,A,N,T,S), T);
		testEqq("lambda7 create pair from 2 params",   e(lambda(7,ST(P,p(12),p(14))),L,R,P,A,N,T,S), P.e(A).e(T));

	}
	
	/*public static void testBigCallRecur1To6(){
		lg("Starting testBigCallRecur1To6");
		testEqq("recur6 without enough params", e(Big,recur6,L,R,P,A,N), e(Big,recur6,L,R,P,A,N));
		testEqq("recur6", e(Big,recur6,L,R,P,A,N,T), e(Big,recur6));
		testEqq("recur5 without enough params", e(Big,recur5,L,R,P,A), e(Big,recur5,L,R,P,A));
		testEqq("recur5", e(Big,recur5,L,R,P,A,N,T), e(Big,recur5,L));
		testEqq("recur4", e(Big,recur4,L,R,P,A,N,T), e(Big,recur4,L,R));
		testEqq("recur3", e(Big,recur3,L,R,P,A,N,T), e(Big,recur3,L,R,P));
		testEqq("recur2", e(Big,recur2,L,R,P,A,N,T), e(Big,recur2,L,R,P,A));
		testEqq("recur1", e(Big,recur1,L,R,P,A,N,T), e(Big,recur1,L,R,P,A,N));
	}*/
	
	public static void testIfElse(){
		lg("Starting testIfElse");
		testEqq("e(ifElse,T,I,I)", e(ifElse(),T,I,I), u);
		testEqq("e(ifElse,T,t(N),t(P))", e(ifElse(),T,t(N),t(P)), N);
		testEqq("e(ifElse,F,t(N),t(P))", e(ifElse(),F,t(N),t(P)), P);
		testEqq("e(ifElse,T,I,.) -> (I .) -> .", e(ifElse(),T,I,u), u);
		testEqq("e(ifElse,F,I,.) -> (. .)", e(ifElse(),F,I,u), e(u,u));
		//testEqq("ifElse thenConst 1", IF(tt(T),thenT(P),thenT(N)), P);
		//testEqq("ifElse thenConst 2", IF(tt(F),thenT(P),thenT(N)), N);
		
		testEqq("(tttt(u) N) -> (T (T (T u)))", e(tttt(u),N), ttt(u));
		testEqq("ifElse T thenConst L", e(IF(t(T),thenConst(L),thenConst(R)),u), L);
		testEqq("ifElse F thenConst R", e(IF(t(F),thenConst(L),thenConst(R)),u), R);
		testEqq("ifElse I thenConst L cuz param of the IF is T so I gets T", e(IF(I,thenConst(L),thenConst(R)),T), L);
		testEqq("ifElse I thenConst R cuz param of the IF is F so I gets F", e(IF(I,thenConst(L),thenConst(R)),F), R);
		testEqq("ifElse car thenConst L cuz param of the IF is (P T F) so car gets T",
			e(IF(car,thenConst(L),thenConst(R)),e(P,T,F)), L);
		testEqq("ifElse car then I, car gets T which chooses then(I), and the I called on (P T F) returns (P T F)",
			e(IF(car,then(I),thenConst(R)),e(P,T,F)), e(P,T,F));
		testEqq("ifElse cdr then I, cdr gets F which chooses thenT(P,I,I), and the thenT(P,I,I) called on e(P,T,F) returns (P (P T F) (P T F))",
			e(IF(cdr,then(I),thenT(P,I,I)),e(P,T,F)), e(P,e(P,T,F),e(P,T,F)));
	}
	
	/*
	public static void testIFInBigcall(){
		lg("Starting testIFInBigcall");
		Node x = e(
			Big,
			IF(p7, then(p8), then(p9)),
			F, F, T //ignore first 3 of 6 params
		);
		testEqq("testIFInBigcall 1", e(x,T,A,N), A);
		testEqq("testIFInBigcall 2", e(x,F,A,N), N);
	}*/
	
	public static void testLogic(){
		lg("Starting testLogic");
		testEqq("and F F", e(and(),F,F), F);
		testEqq("and F T", e(and(),F,T), F);
		testEqq("and T F", e(and(),T,F), F);
		testEqq("and T T", e(and(),T,T), T);
		testEqq("or F F", e(or(),F,F), F);
		testEqq("or F T", e(or(),F,T), T);
		testEqq("or T F", e(or(),T,F), T);
		testEqq("or T T", e(or(),T,T), T);
		testEqq("xor F F", e(xor(),F,F), F);
		testEqq("xor F T", e(xor(),F,T), T);
		testEqq("xor T F", e(xor(),T,F), T);
		testEqq("xor T T", e(xor(),T,T), F);
		//minorityBit, in this very unoptimized math model, is probably being exponentially slow cuz I implemented it using 4 xors and 3 ands
		//and multiple Big calls. Its time to get CacheFuncParamReturn working.
		//if(1<2) throw new Error("too slow past here. must get CacheFuncParamReturn working first");
		testEqq("minorityBit F F F", e(minorityBit(),F,F,F), T);
		testEqq("minorityBit F F T", e(minorityBit(),F,F,T), T);
		testEqq("minorityBit F T F", e(minorityBit(),F,T,F), T);
		testEqq("minorityBit F T T", e(minorityBit(),F,T,T), F);
		testEqq("minorityBit T F F", e(minorityBit(),T,F,F), T);
		testEqq("minorityBit T F T", e(minorityBit(),T,F,T), F);
		testEqq("minorityBit T T F", e(minorityBit(),T,T,F), F);
		testEqq("minorityBit T T T", e(minorityBit(),T,T,T), F);
		//verify this fails: testEqq("minorityBit T T T", e(minorityBit,T,T,T), T);
	}
	
	/** lin aka linkedList number, is a simpler kind of linkedlist that doesnt use pair,
	like (T (T (F (T nilAkaLeaf)))) is the number 0x1101 aka baseTen11, and nilAkaLeaf is 0.
	Its a much slower form than the cbt/completeBinaryTree of bits which will
	be hardware optimized to use strictfp float double long int math, in other implementations.
	This implementation is just the math spec for solving disagreements in the possible behaviors of faster implementations.
	*
	public static void testLinPlusOne(){
		lg("Starting testLinArithmetic");
		Node lin0 = nil;
		Node lin1 = T.e(nil);
		Node lin2 = F.e(T.e(nil));
		Node lin3 = T.e(T.e(nil));
		Node lin4 = F.e(F.e(T.e(nil)));
		Node lin5 = T.e(F.e(T.e(nil)));
		testEqq("(linPlusOne lin0)->lin1", e(linPlusOne,lin0), lin1);
		testEqq("(linPlusOne lin1)->lin2", e(linPlusOne,lin1), lin2);
		testEqq("(linPlusOne lin2)->lin3", e(linPlusOne,lin2), lin3);
		testEqq("(linPlusOne lin3)->lin4", e(linPlusOne,lin3), lin4);
		testEqq("(linPlusOne lin4)->lin5", e(linPlusOne,lin4), lin5);
	}
	
	/*public static void testLinPlus(){
		lg("Starting testLinPlus");
		testEqq("lin11", lin(11), e(T,e(T,e(F,e(T,nil)))));
		testEqq("linPlus 0 0", e(linPlus,lin(0),lin(0)), lin(0));
		testEqq("linPlus 0 1", e(linPlus,lin(0),lin(1)), lin(1));
		testEqq("linPlus 1 0", e(linPlus,lin(1),lin(0)), lin(1));
		testEqq("linPlus 2 3", e(linPlus,lin(2),lin(3)), lin(5));
		testEqq("linPlus 3 2", e(linPlus,lin(3),lin(2)), lin(5));
		testEqq("linPlus 11 17", e(linPlus,lin(11),lin(17)), lin(28));
		testEqq("linPlus 20 17", e(linPlus,lin(20),lin(17)), lin(37));
		testEqq("linPlus 16 16", e(linPlus,lin(16),lin(16)), lin(32));
		testEqq("linPlus 16 1", e(linPlus,lin(16),lin(1)), lin(17));
	}*/
	
	/* fibonacci, to verify cache <func,param,return> is working (which 2020-6-23-10a its not,
	and the system is designed to work anyways just exponentially slower, wherever it lacks perfect dedup,
	so if you dedup everything except for n parts, it will be at worst constant^n times slower,
	and often much faster than that).
	*
	public static void testLinFibonacciSoDeepThatIfCacheFuncParamReturnIsntWorkingThenItWillTakeTrillionsOfYearsElseNearInstant(){
		lg("Starting testLinFibonacciSoDeepThatIfCacheFuncParamReturnIsntWorkingThenItWillTakeTrillionsOfYearsElseNearInstant");
		throw new Error("TODO");
	}*/
	
	public static void testEquals(){
		lg("Starting testEquals - The universalFunc being a patternCalculusFunc allows it to do this which lambdaFuncs cant cuz its a subset of possible lambdaFuncs thats a universal subset but also a subset that allows it to know patternCalculus things that it couldnt know outside that subset cuz it wouldnt know which are in or not in the subset, except that in this system its always in that subset. Its important to understand that the equals func is implemented as a pure sparse turing machine and does not use any implementing system's == or .equals operators etc except other implementations can do that as an optimization as long as it always gets the exact same result as the sparse turing machine.");
		testEqq("(equals . .)", e(Equals(),u,u), T);
		testEqq("(equals . (..))", e(Equals(),u,e(u,u)), F);
		testEqq("(equals (..) .)", e(Equals(),e(u,u),u), F);
		testEqq("(equals (..) (..))", e(Equals(),e(u,u),e(u,u)), T);
		testEqq("(equals ((..).) ((..).))", e( Equals(), e(e(u,u),u), e(e(u,u),u) ), T);
		testEqq("(equals (.(..)) (.(..)))", e( Equals(), e(u,e(u,u)), e(u,e(u,u)) ), T);
		testEqq("(equals ((..)(..)) ((..)(..)))", e( Equals(), e(e(u,u),e(u,u)), e(e(u,u),e(u,u)) ), T);
		testEqq("(equals (..) ((..).))", e( Equals(), e(u,u), e(e(u,u),u) ), F);
		testEqq("(equals ((..).) (..))", e( Equals(), e(e(u,u),u), e(u,u) ), F);
		testEqq("(equals car car)", e(Equals(),car,car), T);
		testEqq("(equals car cdr)", e(Equals(),car,cdr), F);
		testEqq("(equals equals equals)", e(Equals(),Equals(),Equals()), T);
		testEqq("(equals car equals)", e(Equals(),car,Equals()), F);
	}
	
	/** (lazig x y z) returns (x y) */
	public static void testLazig(){
		lg("Starting testLazig");
		//fn cbtAN = e(lazig(), A, N, P);
		testEqq("lazigA", e(lazig(),A), e(lazig(),A));
		testEqq("lazigAN", e(lazig(),A,N), e(lazig(),A,N));
		testEqq("lazigANP", e(lazig(),A,N,P), e(A,N));
		testEqq("lazigPAN", e(lazig(),P,A,N), e(P,A));
	}
	
	public static void test_linPlusOneTwoscomplement(){
		lg("Starting test_linPlusOneTwoscomplement");
		testEqq("(linPlusOneTwoscomplement u) -> u, aka number with no digits", e(linPlusOneTwoscomplement(),u), u);
		testEqq("(F u)==I. Remember that when reading the following tests.", e(F,u), I);
		testEqq("(linPlusOneTwoscomplement (F u)) -> (T u), aka 0 -> 1", e(linPlusOneTwoscomplement(),e(F,u)), e(T,u));
		testEqq("(linPlusOneTwoscomplement (T u)) -> (F u), aka 1 -> 0 losing high digit to twosComplement", e(linPlusOneTwoscomplement(),e(F,u)), e(T,u));
		testEqq("(linPlusOneTwoscomplement (T (F u))) -> (F (T u)) //01 -> 10", e(linPlusOneTwoscomplement(), e(T,e(F,u))), e(F,e(T,u)));
		testEqq("(linPlusOneTwoscomplement (F (T u))) -> (T (T u)) //10 -> 11", e(linPlusOneTwoscomplement(), e(F,e(T,u))), e(T,e(T,u)));
		testEqq("(linPlusOneTwoscomplement (T (T u))) -> (F (F u)) //11 -> 00, wraps", e(linPlusOneTwoscomplement(), e(T,e(T,u))), e(F,e(F,u)));
		testEqq("(linPlusOneTwoscomplement (T (T (T u)))) -> (F (F (F u))) //111 -> 000, wraps", e(linPlusOneTwoscomplement(), e(T,e(T,e(T,u)))), e(F,e(F,e(F,u))));
		testEqq("(linPlusOneTwoscomplement (T (T (F (T u))))) -> (F (F (T (T u)))) //1011 -> 1100", e(linPlusOneTwoscomplement(), e(T,e(T,e(F,e(T,u))))), e(F,e(F,e(T,e(T,u)))));
	}
	
	public static void test_linPlusTwoscomplement(){
		lg("Starting test_linPlusTwoscomplement");
		testEqq("(F u)==I again. Remember that when reading the following tests.", e(F,u), I);
		fn plus = linPlusTwoscomplement();
		testEqq("(linPlusTwoscomplement u u) -> u, 2 numbers with no digits -> no digits", e(plus,u,u), u);
		testEqq("(linPlusTwoscomplement (F u) (F u)) -> (F u)", e(plus,e(F,u),e(F,u)), e(F,u));
		testEqq("(linPlusTwoscomplement (T u) (F u)) -> (T u)", e(plus,e(T,u),e(F,u)), e(T,u));
		testEqq("(linPlusTwoscomplement (F u) (T u)) -> (T u)", e(plus,e(F,u),e(T,u)), e(T,u));
		testEqq("(linPlusTwoscomplement (T u) (T u)) -> (F u), carry loses digit", e(plus,e(T,u),e(T,u)), e(F,u));
		testEqq("(linPlusTwoscomplement (T (F u)) (T (F u))) -> (F (T u)), 01+01->10", e(plus,e(T,e(F,u)),e(T,e(F,u))), e(F,e(T,u)));
		testEqq("(linPlusTwoscomplement (T (T (F (T u))))) (T (F (F (F u))))) -> (F (F (T (T u)))), 1011+0001->1100",
			e(plus,e(T,e(T,e(F,e(T,u)))),e(T,e(F,e(F,e(F,u))))), e(F,e(F,e(T,e(T,u)))) );
	}
	
	/*
	public static void testChurchEncodingOfArithmetic(){
		lg("Starting testChurchEncodingOfArithmetic aka https://en.wikipedia.org/wiki/Church_encoding");
		Node ch1 = e(chSucc,chZero);
		Node ch2 = e(chSucc,ch1);
		Node ch3 = e(chSucc,ch2);
		Node ch4 = e(chSucc,ch3);
		testEqq("ch3 .", e(ch3,T,nil), e(T,e(T,e(T,nil))));
		Node ch5a = e(chPlus,ch2,ch3);
		Node ch5b = e(chPlus,ch3,ch2);
		testEqq("ch5 a and b", e(ch5a,T,nil), e(ch5b,T,nil));
		testEqq("chMult vs chPlus", e(e(chMult,ch3,ch4),T,nil), e(e(chPlus,ch4,e(chPlus,ch4,ch4)),T,nil));
		testEqq("chExponent vs chMult", e(e(chExponent,ch4,ch3),T,nil), e(e(chMult,ch4,e(chMult,ch4,ch4)),T,nil));
		testEqq(
			"chExponent vs chMult, with plus",
			e( e(chPlus,ch2,e(chExponent,ch4,ch3)) ,T,nil),
			e( e(chPlus,e(chMult,ch4,e(chMult,ch4,ch4)),ch2) ,T,nil)
		);
		lg("testChurchEncodingOfArithmetic tests pass."
			+" The church encoding of arithmetic is a nonnormalized form cuz theres more than 1 form of each integer."
			+" Lin numbers, such as (T (T (T nil))) is 3, are a normalized form and are exponentially more efficient"
			+" as they store binary digits instead of unary. Cbt (complete binary tree of pairs of T and F)"
			+" bitstrings will be even more efficient than that as they"
			+" can be memory mapped between lambdas and large arrays such as for GPU optimizations or realtime transforms"
			+" between speakers and microphones processessing each of 44100 per second wave amplitudes individually or voxel graphics.");
	}*/
	
	public static void main(String[] args){
		//double timeStart = Time.now();
		//try{
			testBootIsT();
			
			long nanotimeStart = System.nanoTime(); //TODO utcnano
			
			testFnDotIdentityfunc();
			
			testTF();
			testPair();
			testIota();
			//thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger();
			testIsHalted();
			//testLeafAndFewOpsInternalStructures();
			testLeafAndFewOpsInternalStructures_withFewThingsCommentedOutCuzCodeWasFromDiffUniversalFunc_todoAddSimilarTests();
			testSTLR();
			testLRQuine();
			testIdentityFuncs();
			testConsCarCdr();
			testBigCallParams();
			
			//testBigCallRecur1To6();
			//TODO instead of recur1 to recur7, depending on number of params, use opcode (ops 1 - 7) to know exactly where to recur from,
			//which will in other implementations (than this spec) be cached in every node what is its op and number of curries.
			
			testLazig();
			testIfElse();
			testLogic();
			testEquals();
			
			test_linPlusOneTwoscomplement();
			
			//test_linPlusTwoscomplement();
			
			/*TODO testcases where callpairs call step, lazyCall, asCallPair, asCallQuad, stackDown, cacheKey, stack, etc.
			All existing testcases will be the same. The meta ops only add behaviors.
			Its most important to use a FPR <isDeterministic,func,param,return> which is a callquad (see OcfnUtil.cacheVal(fn) the value of fn.cacheKey)
			deterministicly from callpairs, a combo of a few of those.
			*/
			
			/*testIFInBigcall();
			testChurchEncodingOfArithmetic();
			testLinPlusOne();
			lg("Occamsfuncer tests passed.");
			*/
			
			long nanotimeEnd = System.nanoTime(); //TODO utcnano
			double duration = (nanotimeEnd-nanotimeStart)*1e-9;
			double stepsPerSec = OcfnUtil.countSteps_todoRemoveThisVar/duration;
			lg("steps="+OcfnUtil.countSteps_todoRemoveThisVar);
			lg("seconds="+duration);
			long objectsInCache = CacheFuncParamReturn.howManyCached();
			lg("stepsPerSec="+stepsPerSec);
			double objectsInCachePerSec = objectsInCache/duration;
			lg("objectsInCachePerSec="+objectsInCachePerSec+" objectsInCache="+objectsInCache);
			lg("In other implementations (not this spec), this will be optimized to make full use of GPU but CPU will often be many times slower than other programs that use CPU cuz of unusual cache needs.");
			
		/*}finally{
			double duration = Time.now()-timeStart;
			lg("CacheFuncParamReturn.howManyCached="+CacheFuncParamReturn.howManyCached());
			lg("OcfnUtil.test_countCallsOfStep="+OcfnUtil.test_countCallsOfStep);
			lg("duration="+duration);
		}*/
	}

}
