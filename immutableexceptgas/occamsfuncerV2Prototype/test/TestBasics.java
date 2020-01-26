/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncerV2Prototype.test;
import static immutableexceptgas.occamsfuncerV2Prototype.util.Example.*;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2Prototype.fns.Call;
import immutableexceptgas.occamsfuncerV2Prototype.util.Boot;
import immutableexceptgas.occamsfuncerV2Prototype.util.Example;
import immutableexceptgas.occamsfuncerV2Prototype.util.TempOcfnplugs;
import immutableexceptgas.occamsfuncerV2Spec.Compiled;
import immutableexceptgas.occamsfuncerV2Spec.Gas;
import immutableexceptgas.occamsfuncerV2Spec.fn;
import mutable.util.Rand;
import mutable.util.Time;

public strictfp class TestBasics{
	
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
		lg("testEqq pass: "+name);
	}
	
	public static void testNotEqq(String name, Object a, Object b){
		if(a == b){
			throw new Error("Test failed (cuz they equal but shouldnt): "+name+" a["+a+"] b["+b+"]");
		}
		lg("testNotEqq pass: "+name);
	}
	
	public static void testEqq(String name, long a, long b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("testEqq pass: "+name);
	}
	
	public static void testEqq(String name, double a, double b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("testEqq pass: "+name);
	}
	
	public static void testDotEq(String name, Object a, Object b){
		if(!a.equals(b)){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("testDotEq pass: "+name);
	}
	
	/** WARNING: modifies Gas.top without conserving Gas */
	public static void testInfiniteLoopEndsCuzRunsOutOfGas(){
		lg("Starting testInfiniteLoopEndsCuzRunsOutOfGas");
		Gas.top = 1500;
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
			test("unary"+i, unary(i).isUnaryCbt());
		}
		test(!leaf.isUnaryCbt());
		test(!leaf.f(leaf).isUnaryCbt());
		test(!cbt0.isUnaryCbt());
		test(!cbt1.f(cbt0).isUnaryCbt());
		test(!cbt0.f(cbt1).isUnaryCbt());
		test(!cbt1.f(cbt1.f(cbt1)).isUnaryCbt());
		test(!S.isUnaryCbt());
		test(!T.isUnaryCbt());
	}
	
	public static void testLeaf(){
		lg("Starting testLeaf");
		testEqq("(L Leaf)", L.f(leaf), I);
		testEqq("(R leaf)", R.f(leaf), leaf);
	}
	
	/** comments are very important in this system
	since its otherwise very assembly-language-like.
	An object is either leaf or a list of 3 leafs
	called its L, its R, and its comment.
	All other object properties are derived from that trinary forest shape.
	Objects at heights 0 to 4 always have leaf as their comment,
	cuz thats where the universalLambdaFunction is defined.
	The COMMENT op, which sets comment (by forkEdit),
	must return the same object silently without setting comment,
	except if height is at least 5 without the comment
	and then it can have a comment other than leaf.
	*/
	public static void testComment(){
		lg("Starting testComment");
		fn leafLeaf = leaf.f(leaf);
		testEqq("testComment_1", leaf.COMMENT(leafLeaf), leaf);
		testEqq("testComment_2", getp.COMMENT(leafLeaf), getp);
		testEqq("testComment_3", pair.f(pair), pair.f(pair));
		testNotEqq("testComment_4", pair.f(pair).COMMENT(leafLeaf), pair.f(pair));
		testEqq("testComment_5", pair.f(pair).COMMENT(leafLeaf).COMMENT(leaf), pair.f(pair));
		testEqq("testComment_6", comment.f(COMMENT.f(pair.f(pair)).f(leafLeaf)), leafLeaf);
		testEqq("testComment_commentAnIdentityFuncAndItStillComputesIdentity", COMMENT.f(S.f(T).f(T)).f(leafLeaf).f(recur), recur);
	}

	
	/** test [((L x)(R x)) equals x for all x] for x's L and R childs,
	other than where x has a non-leaf comment,
	in which case you also have to (COMMENT ((L x)(R x)) (comment x)) equals x
	for all x, which is the more general truth.
	Comment is always leaf where height()<5 cuz thats where opcodes go,
	and setting comment silently keeps it as leaf if you try to forkEdit that.
	*/
	public static void testLRQuine(fn x, boolean testWithCommentVsCommentMustBeLeaf){
		if(testWithCommentVsCommentMustBeLeaf){
			testEqq(
				"testLRQuineWithComment_"+x,
				f(COMMENT,x.L().f(x.R()),comment.f(x)),
				x
			);
		}else{
			testEqq("testLRQuine_"+x, x.L().f(x.R()), x);
		}
	}
	
	public static void testLRQuine(boolean testWithCommentVsCommentMustBeLeaf){
		lg("Starting testLRQuine");
		fn leafLeaf = leaf.f(leaf);
		testLRQuine(leaf,testWithCommentVsCommentMustBeLeaf);
		testLRQuine(leaf.f(leaf),testWithCommentVsCommentMustBeLeaf);
		testLRQuine(L,testWithCommentVsCommentMustBeLeaf);
		testLRQuine(R,testWithCommentVsCommentMustBeLeaf);
		testLRQuine(curry,testWithCommentVsCommentMustBeLeaf);
		testLRQuine(getp,testWithCommentVsCommentMustBeLeaf);
		testLRQuine(curry.f(leaf),testWithCommentVsCommentMustBeLeaf);
		//TODO testLRQuine(curry.f(leaf).COMMENT("testing comment"));
		//but might be infiniteLoop to convert stringliteral this early in boot.
		testLRQuine(curry.f(leaf).COMMENT(leafLeaf), testWithCommentVsCommentMustBeLeaf);
		testLRQuine(leaf.f(leaf.f(getp)),testWithCommentVsCommentMustBeLeaf);
		//TODO testLRQuine(leaf.f(leaf.f(getp)).COMMENT("testing comment"));
	}
	
	/** Op.curry is the only vararg op. Its int fn.cur is 0,
	and its next param is a unary, such as unary(3)
	is cbt1.f(cbt1).f(cbt1.f(cbt1)).f(cbt1.f(cbt1).f(cbt1.f(cbt1)))
	aka a completeBinaryTree of exponentially many cbt1s (linear cost).
	The fn.cur of (curry <unaryN>) is N-1. It acts like that unary
	is the fn.cur of Op.curry (which is actually 0 but later in the
	currylist it acts like that).
	*/
	public static void testCurIntInVararg(){
		lg("Starting testIdentityFuncs");
		testDotEq("curry.cur", curry.cur(), 0);
		for(int i=1; i<5; i++){
			testDotEq("curry.u"+i+".cur", curry.f(unary(i)).cur(), i-1);
		}
		testDotEq("curry.u7.T.T.cur", curry.f(unary(7)).f(T).f(T).cur(), 4);
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
		//fn madeByCurryForConstraint = f(lazyEval,x,cbt0);
		fn madeByCurryForConstraint = f(pair,x,cbt0);
		lg("madeByCurryForConstraint: "+madeByCurryForConstraint);;
		fn y = f(curry,unary(6),T,funcBody,cbt0);
		lg("y: "+y);
		fn madeByCurryForFuncBody = f(pair,y,cbt1);
		//fn madeByCurryForFuncBody = f(lazyEval,y,cbt1);
		lg("madeByCurryForFuncBody: "+madeByCurryForFuncBody);;
		
		testEqq("constraintGetsSecondLastParam", getp(4,madeByCurryForConstraint), cbt0);
		testEqq("funcBodyGetsLastParam", getp(5,madeByCurryForFuncBody), cbt1);
		testEqq("funcBodyGetsSecondLastParam", getp(4,madeByCurryForFuncBody), cbt0);
		
		//OLD getp had comment param: fn getpLeaf = getp.f(leaf); //first param is comment. leaf means no comment.
		testEqq("constraint_getpunary4_is_cbt0", getp.f(unary(4)).f(madeByCurryForConstraint), cbt0);
		testEqq("constraint_getpunary5_is_leaf_cuzParamIndexDoesntExist", getp.f(unary(5)).f(madeByCurryForConstraint), leaf);
		testEqq("constraint_getpunary6_is_leaf_cuzParamIndexDoesntExist", getp.f(unary(6)).f(madeByCurryForConstraint), leaf);
		testEqq("funcBody_getpunary4_is_cbt0", getp.f(unary(4)).f(madeByCurryForFuncBody), cbt0);
		testEqq("funcBody_getpunary5_is_cbt1", getp.f(unary(5)).f(madeByCurryForFuncBody), cbt1);
	}
	
	public static void testAnd(){
		lg("Starting testAnd");
		lg("and="+and());
		testEqq("and_F_F", and().f(F).f(F), F);
		testEqq("and_F_T", and().f(F).f(T), F);
		testEqq("and_T_F", and().f(T).f(F), F);
		testEqq("and_T_T", and().f(T).f(T), T);
	}
	
	public static void testString(){
		lg("Starting testString");
		String s = "abc";
		lg("s: "+s);
		fn fnAbc = w(s);
		lg("fnAbc: "+fnAbc);
		String s__2 = str(fnAbc);
		lg("s__2: "+s__2);
		test(s.equals(s__2));
	}
	
	/** any static function whose name starts with "ocfnplug",
	of fn to fn outside of user level code,
	is considered part of occamsfuncer VM. The naming is for security
	since you cant name something that way by accident.
	*/
	public static void testOcfnplug(){
		fn leafLeaf = leaf.f(leaf);
		fn leafLeaf__2 = CP(leaf,leaf);
		
		fn plugEqqOfPair = nondet.f("ocfnplug").f(Example.class.getName()+".ocfnplugEqqOfPair");
		testEqq("plugEqqAPair", plugEqqOfPair.f(pair.f(leafLeaf).f(leafLeaf__2)), F);
		testEqq("plugEqqBPair", plugEqqOfPair.f(pair.f(leafLeaf__2).f(leafLeaf__2)), T);
		
		//fn plugEqq = nondet.f("ocfnplug:"+Example.class.getName()+".ocfnplugEqq");
		//fn plugEqq = cc().f(nondet.f("ocfnplug:"+Example.class.getName()+".ocfnplugEqq"));
		testEqq("plugEqqACurry", eqq().f(leafLeaf).f(leafLeaf__2), F);
		testEqq("plugEqqBCurry", eqq().f(leafLeaf__2).f(leafLeaf__2), T);
	}
	
	
	/** (lazys w x y z) returns ((w z)(y z)) *
	public static void testLazys(){
		lg("Starting testLazys");
		fn lazys = Example.lazys();
		fn cbt01 = f(lazys, R, L, fnThatInfiniteLoopsForEveryPossibleParam(), cbt1.f(cbt0));
		testEqq("lazys_reverses_10_to_01", cbt01, cbt0.f(cbt1));
	}*/
	
	/** (lazig x y z) returns (x y) */
	public static void testLazig(){
		lg("Starting testLazig");
		fn cbt01 = f(Example.lazig(), cbt0, cbt1, curry);
		testEqq("lazigA", f(Example.lazig(), cbt0, cbt1, curry), cbt0.f(cbt1));
	}
	
	/** param differs so can test new things that havent been cached yet */
	public static void testLazyEval(fn param){
		lg("Starting testLazyEval");
		fn lazyEval = Example.lazyEval();
		lg("lazyEval.f(pair).compiled()="+lazyEval.f(pair).compiled());
		lazyEval.f(pair).updateCompiledCache();
		lg("lazyEval.f(pair).compiled()="+lazyEval.f(pair).compiled());
		lazyEval.f(pair).f(curry).updateCompiledCache();
		lg("lazyEval.f(pair).compiled()="+lazyEval.f(pair).compiled());
		testEqq("(lazyEval pair curry param)", lazyEval.f(pair).f(curry).f(param), pair.f(curry).f(param));
	}
	
	public static void testIfElse(){
		lg("Starting testIfElse");
		fn ifElse = Example.ifElse();
		testEqq("f(ifElse,T,t(getp),t(curry))", f(ifElse,T,t(getp),t(curry)), getp);
		testEqq("f(ifElse,F,t(getp),t(curry))", f(ifElse,F,t(getp),t(curry)), curry);
		testEqq("f(ifElse,T,I,I)", f(ifElse,T,I,I), leaf);
	}
	
	public static void testUnaryAddWhichUsesCurryAndRecur(){
		lg("Starting testUnaryAddWhichUsesCurryAndRecur");
		testEqq("unaryInc_u3", 	unaryInc().f(unary(3)), unary(4));
		
		//if(1<2) throw new Error("infloops below. Might need redesign occamsfuncer to implement core ops as pairAndSymbol based turing machine to make this understandable.");
		testEqq("unaryAddUsingNondetEqq_u0_u0", unaryAddUsingNondetEqq().f(unary(0)).f(unary(0)), unary(0));
		testEqq("unaryAddUsingNondetEqq_u1_u1", unaryAddUsingNondetEqq().f(unary(1)).f(unary(1)), unary(2));
		testEqq("unaryAddUsingNondetEqq_u2_u1", unaryAddUsingNondetEqq().f(unary(2)).f(unary(1)), unary(3));
		testEqq("unaryAddUsingNondetEqq_u2_u3", unaryAddUsingNondetEqq().f(unary(2)).f(unary(3)), unary(5));
		
		testEqq("unaryInc_u3", unaryInc().f(unary(3)), unary(4));
		
		testEqq("unaryAdd_u0_u0", unaryAdd().f(unary(0)).f(unary(0)), unary(0));
		testEqq("unaryAdd_u1_u1", unaryAdd().f(unary(1)).f(unary(1)), unary(2));
		testEqq("unaryAdd_u2_u1", unaryAdd().f(unary(2)).f(unary(1)), unary(3));
		testEqq("unaryAdd_u2_u3", unaryAdd().f(unary(2)).f(unary(3)), unary(5));
		
		/*testEqq("unaryAdd_u3_u4", unaryAdd().f(unary(3)).f(unary(4)), unary(7));
		testEqq("unaryAdd_u0_u0", unaryAdd().f(unary(0)).f(unary(0)), unary(0));
		testEqq("unaryAdd_u5_u5", unaryAdd().f(unary(5)).f(unary(5)), unary(10));
		testEqq("unaryAdd_u5_u35", unaryAdd().f(unary(5)).f(unary(25)), unary(30));
		*/
	}
	
	/** Test the fn returned by Example.equals()
	without the Compiled optimization that compares by height, ==, andOr id,
	and without Cache dedup of <func,param,return> on the 2 funcs to be
	compared for equality but with <func,param,return> caching in the
	equals func cuz otherwise it would have exponential cost,
	but maybe that would be ok for a very small pair of things
	to compare for equality.
	*/
	public static void testEqualsWithoutDedup(boolean justLAndRNotComment){
		lg("Starting testEqualsWithoutOptimizationsOrDedup justLAndRNotComment="+justLAndRNotComment);
		fn leafLeaf = new Call(leaf,leaf);
		fn zero = new Call(leaf,leafLeaf);
		//fn one = new Call(leafLeaf,leaf);
		fn zeroZero = new Call(zero,zero);
		fn copyOfFirstOp = new Call(zeroZero,zeroZero);
		fn firstOp = Boot.op(0);
		fn secondOp = Boot.op(1);
		fn equals = justLAndRNotComment ? Example.equalsIgnoringComments() : Example.equals();
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
		//If they dont have the exact same comment
		//then equals will correctly say they're different,
		//depending on boolean justLAndRNotComment.
		fn cpoi = CP(CP(S,I),I).COMMENT("callParamOnItself");
		fn copyOf_lazig_cpoi_cpoi = CP(CP(Example.lazig(),cpoi),cpoi).COMMENT("fnThatInfiniteLoopsForEveryPossibleParam");
		//fn copyOf_lazyEval_sii_sii = CP(CP(lazyEval,sii),sii);
		test(
			"somethingLambdaFuncsCantDoCuzItWouldInfiniteLoop",
			T == equals
				.f(fnThatInfiniteLoopsForEveryPossibleParam())
				.f(copyOf_lazig_cpoi_cpoi)
				//.f(copyOf_lazyEval_sii_sii)
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
	
	public static void testIota(){
		lg("Starting testIota");
		fn x = Example.iota();
		lg("iota = "+x);
		testEqq("(iota iota getp) cuz iota iota is an identityFunc", x.f(x).f(getp), getp);
		testEqq("get T from iota", x.f(x.f(x.f(x))), T);
		testEqq("get S from iota", x.f(x.f(x.f(x.f(x)))), S);
		lg("Tests pass: testIota");
	}
	
	/** 3 childs of each node are L R Comment but can only have non-leaf comment above height 4 */
	public static void testTrinaryForest(){
		lg("Starting testTrinaryForest");
		testEqq("comment.f(leaf)", comment.f(leaf), leaf);
		testEqq("comment.f(leaf.f(leaf))", comment.f(leaf.f(leaf)), leaf);
		testEqq("comment.f(COMMENT.f(leaf.f(leaf)).f(cbt1))", comment.f(COMMENT.f(leaf.f(leaf)).f(cbt1)), leaf);
		testEqq("comment.f(COMMENT.f(getp.f(curry)).f(cbt1))", comment.f(COMMENT.f(getp.f(curry)).f(cbt1)), cbt1);
		testEqq("L.f(COMMENT.f(getp.f(curry)).f(cbt1))", L.f(COMMENT.f(getp.f(curry)).f(cbt1)), getp);
		testEqq("R.f(COMMENT.f(getp.f(curry)).f(cbt1))", R.f(COMMENT.f(getp.f(curry)).f(cbt1)), curry);
	}
	
	public static void testConsCarCdr(){
		lg("Starting testConsCarCdr");
		fn cons = pair;
		fn car = Example.car();
		fn cdr = Example.cdr();
		fn nil = Example.nil();
		fn isNil = Example.isNil();
		fn list_getp_recur_L = cons.f(getp).f(cons.f(recur).f(cons.f(L).f(nil)));
		testEqq("testConsCarCdr_1", car.f(list_getp_recur_L), getp);
		testEqq("testConsCarCdr_2", car.f(cdr.f(list_getp_recur_L)), recur);
		testEqq("testConsCarCdr_3", car.f(cdr.f(cdr.f(list_getp_recur_L))), L);
		testEqq("testConsCarCdr_4", cdr.f(cdr.f(cdr.f(list_getp_recur_L))), nil);
		testEqq("isNil_nil", isNil.f(nil), T);
		testEqq("isNil_leaf", isNil.f(leaf), F);
		testEqq("isNil_[list_getp_recur_L]", isNil.f(list_getp_recur_L), F);
	}
	
	/** See comment in Nondet.nondet(fn,fn.fn) about the design sacrifices
	being considered about the interaction between nondet and caching
	and the design so far (2020-1-26), which makes it harder to use,
	is that some nondet ops (wallet and spend, maybe others) take a salt param,
	and that salt has to be computed deterministicly as it flows through the code
	depending on which path the salt goes.
	I very much want a way to do it without manually flowing salt through
	the code that sometime later may call nondet and instead
	generating it randomly from (nondet nondet nondet size) at the time,
	but I dont know how to (and maybe its logically impossible)
	cache the right calls of nondet (that (nondet nondet nondet size) generates salt for)
	as other code still needs to use the result derived from whatever the nondet returned,
	but other calls of nondet are meant to be called differently.
	Since all ops except nondet are pure deterministic (unless they call nondet
	and you cant know if they will or not every time cuz of haltingProblem,
	but you can run in pure deterministic mode (Gas.forceDeterminism)
	so nondet always costs infinite time).... Since all ops except nondet
	are pure deterministic, and thats built into the kind of caching
	that it needs to not take exponential time to do a small thing,
	the interactions between determinism, nondeterminism, and caching
	are very hard to design.
	*/
	public static void testLimitComputeResources(){
		lg("Starting testLimitComputeResources");
		fn spend = cccc().f(nondet.f("limitComputeResources").f("spend"));
		//(spend salt maxSpend try catch) returns either (try leaf) or (catch leaf).
		fn wallet = nondet.f("limitComputeResources").f("wallet");
		//(wallet salt) returns Gas.top
		
		fn nondetNondetNondet = nondet.f(nondet).f(nondet);
		fn unary7 = unary(7); //just to make sure its the same object. caching is being tested.
		fn saltA = nondetNondetNondet.f(unary7);
		fn saltB = nondetNondetNondet.f(unary7);
		if(saltA.equals(saltB)){
			throw new Error("2 randoms equal, even when done directly by nondetNondetNondet: "+saltA);
		}
		lg("(nondet nondet nondet <unary7>) correctly gave 2 different cbts when called twice.");

		//.R() unwraps from contentType, and .doubleAt(0) gets those bits.
		double walletFirst = wallet.f(saltA).R().doubleAt(0);
		double walletSecond = wallet.f(saltB).R().doubleAt(0);
		double walletThird = wallet.f(saltA).R().doubleAt(0);
		lg("walletFirst="+walletFirst);
		lg("walletSecond="+walletSecond);
		lg("walletThird="+walletThird);
		if(walletFirst == walletSecond) throw new Error("Wallet is same despite it costs a little to read wallet.");
		if(walletFirst != walletThird) throw new Error("Same salt must return cached value from wallet call.");

		fn x = spend.f(nondetNondetNondet.f(unary7)).f(1000.)
			.f(fnThatInfiniteLoopsForEveryPossibleParam())
			.f(t("theElse"));
		if(!x.equals(w("theElse"))){
			throw new Error("Spend didnt return cbt1. It returned: "+x);
		}
		lg("Spend returned: "+x);
				
		
		/*fn loop = cc().f(
			IF(
				
			),
			saltA
		);*/
		
		
		/*
		fn nextSalt = Example.nextRandCbt128_callMeOnLeaf();
		fn saltC = nextSalt.f(leaf);
		fn saltD = nextSalt.f(leaf);
		if(saltC.equals(saltD)) throw new Error("2 randoms equal (but earlier test passed that generates randoms by (nondet nondet nondet <unary7>) but theres maybe no way around needing to manually compute salt many places deterministicly): "+saltC);
		/fn loop = cc().f(
			IF(),
			saltA
		);
		
		double gasStart = Gas.top;
		
		double gasEnd = Gas.top;
		*
		lg("nextRandCbt128_callMeOnLeaf gave 2 different salts, but that doesnt solve the cache problem of not trying to call it multiple times");
		*/
		lg("WARNING: testLimitComputeResources needs alot more tests cuz the design of mixing determinism (15 ops other than op.nondet), nondeterminism (op.nondet), and caching... that design is not completely decided and likely buggy as of 2020-1-26. Also, stackOverflow happens without throwing Gas, so maybe Spend should also check for that and throw Gas instead, or maybe I should simulate a stack on the heap using some kind of pairlike datastruct, run occamsfuncer like a forest based turing machine instead of any part of it using the java stack?");
	}
	
	public static void testOcfnplugDoubleMathRaw_stuffThatWillBeReplacedByUserLevelCodeLater(){
		lg("Starting testOcfnplugDoubleMathRaw_stuffThatWillBeReplacedByUserLevelCodeLater");
		fn dMulRaw = cc().f(nondet.f("ocfnplug").f(TempOcfnplugs.class.getName()+".ocfnplugDoubleMultiplyRaw"));
		fn dAddRaw = cc().f(nondet.f("ocfnplug").f(TempOcfnplugs.class.getName()+".ocfnplugDoubleAddRaw"));
		//FIXME should .f(double) wrap it using contentType(...).f(bitstring)
		//vs should it just be that 64 bit bitstring (raw)?
		//For now I'll make it unambiguous using doubleToBitstring(double).
		fn raw2 = doubleToBitstring(2.);
		fn raw3 = doubleToBitstring(3.);
		fn raw2p34 = doubleToBitstring(2.34);
		fn raw3p45 = doubleToBitstring(3.45);
		testEqq("raw3 as long bits of double", raw3.longAt(0), Double.doubleToLongBits(3.));
		testEqq("raw3 as double is 3", raw3.doubleAt(0), 3.);
		testEqq("dMulRaw 2 3", dMulRaw.f(raw2).f(raw3).doubleAt(0), 6.);
		testEqq("dMulRaw 2.34 3.45", dMulRaw.f(raw2p34).f(raw3p45).doubleAt(0), 2.34*3.45);
		testEqq("dAddRaw 2 3", dAddRaw.f(raw2).f(raw3).doubleAt(0), 5.);
		testEqq("dAddRaw 2.34 3.45", dAddRaw.f(raw2p34).f(raw3p45).doubleAt(0), 2.34+3.45);
	}
	
	public static void testOcfnplugDoubleMathByContentType_stuffThatWillBeReplacedByUserLevelCodeLater(){
		lg("Starting testOcfnplugDoubleMathByContentType_stuffThatWillBeReplacedByUserLevelCodeLater");
		fn dMul = cc().f(nondet.f("ocfnplug").f(TempOcfnplugs.class.getName()+".ocfnplugDoubleMultiply"));
		testEqq("dMul 2 3", dMul.f(2.).f(3.), Example.doublePrefix().f(6.));
	}
	
	public static void testDoubleMultOptimized(){
		throw new Error("TODO test Example.doubleMult()");
	}
	
	public static void testDoubleMultUnoptimized(){
		throw new Error("TODO test Example.doubleMult()");
	}
	
	public static void testDoubleAddUnoptimized(){
		throw new Error("TODO test Example.doubleAdd()");
	}
	
	public static void testDoubleAddOptimized(){
		throw new Error("TODO test Example.doubleAdd()");
	}
	
	/** TODO after Example.equals() works (in TestBasics),
	derive ieee754 float64 math and compute unoptimized mandelbrot (very low resolution)
	using it.
	This will be computed using Compiled optimization of the double ops
	which will get the exact same fn results (as proven by ids) as the unoptimized form.
	*/
	public static void testMandelbrot(){
		fn mandelbrot = Example.mandelbrot();
		throw new Error("TODO");
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
		lg("Starting at utcSecondsBaseTen:"+Time.now());
		/** change this param between the 2 loops so not all things are cached */
		fn param = cbt0.f(cbt1);
		for(int i=0; i<2; i++){
			if(i==1) param = cbt1.f(cbt0);
			boolean optimized = i!=0;
			lg("OPTIMIZED="+optimized);
			
			testInfiniteLoopEndsCuzRunsOutOfGas();
			Gas.top = 1e6;
			testLeaf();
			testComment();
			testLRQuine(true);
			//testLRQuine(false); //FIXME should be true, but comment isnt working in all combos  yet, causes stackoverflow etc
			testCurIntInVararg();
			testSTLR();
			testIdentityFuncs();
			testSCurryList();
			testIsUnaryCbt();
			testGetp();
			testAnd();
			testEqualsWithoutDedup(true);
			testString();
			testOcfnplug();
			testIfElse();
			testUnaryAddWhichUsesCurryAndRecur();
			//obsolete: testLazys();
			testLazig();
			testLazyEval(param);
			testEqualsWithoutDedup(false);
			testIota();
			testTrinaryForest();
			testConsCarCdr();
			
			//lgErr("ending tests early so can build things before later tests fail");
			//if(1<2) return; //FIXME
			
			/*I could provide an id func so secure it would never be cracked
			but it would be slow. from that maybe could bootstrap things
			so could include using those ids
			a more efficient but slightly less secure (sha256, etc)
			ids by giving the id of that id generator in the uncrackable ids? 
			/*no I dont want things like this in nondet. use ocfnplug for that
			or derive it from leaf. that includes deriving sha256 or whatever
			calculations it is, including the pre and post processing.
			private static fn defaultIdGenerator;
			public static fn defaultIdGenerator(){
				if(defaultIdGenerator == null) defaultIdGenerator =
					nondet.f("getBenFRayfieldsRecommendedIdGeneratorAtUtcTime1576000000").f(leaf);
				return defaultIdGenerator;
			}*/
			
			
			
			testOcfnplugDoubleMathRaw_stuffThatWillBeReplacedByUserLevelCodeLater();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*FIXME todo choose design:
			does cbt allow noncompletebinarytree shapes such as (0(11))
			Write testcases for that, then get back to Example.isBitstring.
			*/
			
			if(!optimized) Boot.optimize();
			
			//FIXME make sure see "lazyEval.compiled" in program output,
			//then commentOut that lg in Boot.optimize() of Example.lazyEval().
		}
		
		
		lg("The loop of tests to do before optimizing and again after optimizing, all passed.");
		
		
		Gas.top = 1e6;
		testLimitComputeResources();
		
		if(1<2){
			lg("The next tests never passed as of 2020-1-26 so ending early.");
			return;
		}
		
		testOcfnplugDoubleMathByContentType_stuffThatWillBeReplacedByUserLevelCodeLater();
		
		
		testDoubleAddUnoptimized();
		testDoubleMultUnoptimized();
		testDoubleAddOptimized();
		testDoubleMultOptimized();
		testMandelbrot();
		testSLinkedList();
		lg("All tests passed (TODO write harder tests)");
	}

}


