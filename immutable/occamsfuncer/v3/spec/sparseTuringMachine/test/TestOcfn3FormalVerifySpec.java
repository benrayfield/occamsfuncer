/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.v3.spec.sparseTuringMachine.test;
import static immutable.occamsfuncer.v3.spec.sparseTuringMachine.OcfnUtil.*;
import static immutable.util.TestUtil.*;
import java.util.Arrays;
import immutable.occamsfuncer.v3.spec.fn;
import immutable.occamsfuncer.v3.spec.sparseTuringMachine.*;

public class TestOcfn3FormalVerifySpec{
	
	public static void testIota(){
		lg("Starting testIota");
		Node x = iota;
		lg("iota = "+x);
		testEqq("(iota iota N) cuz iota iota is an identityFunc", x.e(x).e(N), N);
		testEqq("get T from iota", x.e(x.e(x.e(x))), T);
		testEqq("get S from iota", x.e(x.e(x.e(x.e(x)))), S);
		lg("Tests pass: testIota");
	}
	
	public static void thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger(){
		lg("Starting thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger");
		Node x = f(P,f(I,N),f(I,N));
		OcfnUtil.forABreakpoint = true;
		Node pnn = eval(x); //returns (P N N)
		OcfnUtil.forABreakpoint = false;
		testEqq("pnn", pnn, bootF(P,N,N));
	}
	
	public static void testIsHalted(){
		lg("Starting testIsHalted");
		for(int params=0; params<9; params++){
			Node[] p = new Node[params+1];
			Arrays.fill(p, u);
			test("isHalted . "+params+"params", f(p).isHalted);
		}
		test("isHalted (..(..))", f(u,u,f(u,u)).isHalted);
		test("isHalted should be false . 10params", !f(u,u,u,u,u,u,u,u,u,u,u).isHalted);
		test("isHalted should be false (remember, universalFunc always curries 10 params, so any more are lazy after that 10 returns which is also lazy) . 11params", !f(u,u,u,u,u,u,u,u,u,u,u,u).isHalted);
	}
	
	public static void testLeafAndFewOpsInternalStructures(){
		lg("Starting testLeaf");
		testEqq("(L Leaf)", L(u), I);
		testEqq("(R leaf)", R(u), u);
		testEqq("L(F)==op0", L(F), op0);
		testEqq("L(L(I))==op0", L(L(I)), op0);
		testEqq("L(T)==op1", L(T), op1);
		testEqq("L(L(L))==op2", L(L(L)), op2);
		testEqq("L(L(R))==op3", L(L(R)), op3);
		testEqq("(L Leaf) 2", e(L,u), I);
		testEqq("(R leaf) 2", e(R,u), u);
	}
	
	public static void testSTLR(){
		lg("Starting testSTLR");
		Node st = f(S,T);
		test("st.L()==S", L(st)==S);
		test("st.R()==T", R(st)==T);
		test("st.L()==S 2", e(L,st)==S);
		test("st.R()==T 2", e(R,st)==T);
	}
	
	public static void testLRQuine(Node x){
		testEqq("testLRQuine_"+x, e(L,x,f(R,x)), x);
	}
	
	public static void testLRQuine(){
		lg("Starting testLRQuine");
		Node uuNonhalted = f(u,u);
		testEqq("step (..) becomes halted on (..)", setCacheKey(step(uuNonhalted),null), bootF(u,u));
		testLRQuine(u);
		testLRQuine(e(u,u));
		testLRQuine(L);
		testLRQuine(R);
		//TODO more calls of testLRQuine
	}
	
	public static void testIdentityFuncs(){
		lg("Starting testIdentityFuncs");
		Node stt = e(S,T,T);
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
		Node cons = OcfnUtil.cons;
		Node car = OcfnUtil.car;
		Node cdr = OcfnUtil.cdr;
		Node nil = OcfnUtil.nil;
		Node isNil = OcfnUtil.isNil;
		Node list_N_A_L = cons.e(N).e(cons.e(A).e(cons.e(L).e(nil)));
		testEqq("testConsCarCdr_1", car.e(list_N_A_L), N);
		testEqq("testConsCarCdr_2", car.e(cdr.e(list_N_A_L)), A);
		testEqq("testConsCarCdr_3", car.e(cdr.e(cdr.e(list_N_A_L))), L);
		testEqq("testConsCarCdr_4", cdr.e(cdr.e(cdr.e(list_N_A_L))), nil);
		testEqq("isNil_nil", isNil.e(nil), T);
		testEqq("isNil_[list_N_A_L]", isNil.e(list_N_A_L), F);
	}
	
	public static void testBigCallParams(){
		lg("Starting testBigCallParams");
		testEqq("p10", e(Big,p10,L,R,P,A,N,T), T);
		testEqq("p9", e(Big,p9,L,R,P,A,N,T), N);
		testEqq("p8", e(Big,p8,L,R,P,A,N,T), A);
		testEqq("p7", e(Big,p7,L,R,P,A,N,T), P);
		testEqq("p6", e(Big,p6,L,R,P,A,N,T), R);
		testEqq("p5", e(Big,p5,L,R,P,A,N,T), L);
		testEqq("p4", e(Big,p4,L,R,P,A,N,T), p4);
		testEqq("p3", e(Big,p3,L,R,P,A,N,T), u);
		testEqq("p2", e(Big,p2,L,R,P,A,N,T), u);
		testEqq("p1", e(Big,p1,L,R,P,A,N,T), u);
	}
	
	public static void testBigCallRecur1To6(){
		lg("Starting testBigCallRecur1To6");
		testEqq("recur6 without enough params", e(Big,recur6,L,R,P,A,N), e(Big,recur6,L,R,P,A,N));
		testEqq("recur6", e(Big,recur6,L,R,P,A,N,T), e(Big,recur6));
		testEqq("recur5 without enough params", e(Big,recur5,L,R,P,A), e(Big,recur5,L,R,P,A));
		testEqq("recur5", e(Big,recur5,L,R,P,A,N,T), e(Big,recur5,L));
		testEqq("recur4", e(Big,recur4,L,R,P,A,N,T), e(Big,recur4,L,R));
		testEqq("recur3", e(Big,recur3,L,R,P,A,N,T), e(Big,recur3,L,R,P));
		testEqq("recur2", e(Big,recur2,L,R,P,A,N,T), e(Big,recur2,L,R,P,A));
		testEqq("recur1", e(Big,recur1,L,R,P,A,N,T), e(Big,recur1,L,R,P,A,N));
	}
	
	public static void testIfElse(){
		lg("Starting testIfElse");
		Node ifElse = OcfnUtil.ifElse;
		testEqq("e(ifElse,T,I,I)", e(ifElse,T,I,I), u);
		testEqq("e(ifElse,T,t(N),t(P))", e(ifElse,T,t(N),t(P)), N);
		testEqq("e(ifElse,F,t(N),t(P))", e(ifElse,F,t(N),t(P)), P);
		testEqq("e(ifElse,T,I,.) -> (I .) -> .", e(ifElse,T,I,u), u);
		testEqq("e(ifElse,F,I,.) -> (. .)", e(ifElse,F,I,u), e(u,u));
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
	
	public static void testIFInBigcall(){
		lg("Starting testIFInBigcall");
		Node x = e(
			Big,
			IF(p8, then(p9), then(p10)),
			F, F, T //ignore first 3 of 6 params
		);
		testEqq("testIFInBigcall 1", e(x,T,A,N), A);
		testEqq("testIFInBigcall 2", e(x,F,A,N), N);
	}
	
	public static void testLogic(){
		lg("Starting testLogic");
		testEqq("and F F", e(and,F,F), F);
		testEqq("and F T", e(and,F,T), F);
		testEqq("and T F", e(and,T,F), F);
		testEqq("and T T", e(and,T,T), T);
		testEqq("or F F", e(or,F,F), F);
		testEqq("or F T", e(or,F,T), T);
		testEqq("or T F", e(or,T,F), T);
		testEqq("or T T", e(or,T,T), T);
		testEqq("xor F F", e(xor,F,F), F);
		testEqq("xor F T", e(xor,F,T), T);
		testEqq("xor T F", e(xor,T,F), T);
		testEqq("xor T T", e(xor,T,T), F);
		//minorityBit, in this very unoptimized math model, is probably being exponentially slow cuz I implemented it using 4 xors and 3 ands
		//and multiple Big calls. Its time to get CacheFuncParamReturn working.
		//if(1<2) throw new Error("too slow past here. must get CacheFuncParamReturn working first");
		testEqq("minorityBit F F F", e(minorityBit,F,F,F), T);
		testEqq("minorityBit F F T", e(minorityBit,F,F,T), T);
		testEqq("minorityBit F T F", e(minorityBit,F,T,F), T);
		testEqq("minorityBit F T T", e(minorityBit,F,T,T), F);
		testEqq("minorityBit T F F", e(minorityBit,T,F,F), T);
		testEqq("minorityBit T F T", e(minorityBit,T,F,T), F);
		testEqq("minorityBit T T F", e(minorityBit,T,T,F), F);
		testEqq("minorityBit T T T", e(minorityBit,T,T,T), F);
		//verify this fails: testEqq("minorityBit T T T", e(minorityBit,T,T,T), T);
	}
	
	/** lin aka linkedList number, is a simpler kind of linkedlist that doesnt use pair,
	like (T (T (F (T nilAkaLeaf)))) is the number 0x1101 aka baseTen11, and nilAkaLeaf is 0.
	Its a much slower form than the cbt/completeBinaryTree of bits which will
	be hardware optimized to use strictfp float double long int math, in other implementations.
	This implementation is just the math spec for solving disagreements in the possible behaviors of faster implementations.
	*/
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
	*/
	public static void testLinFibonacciSoDeepThatIfCacheFuncParamReturnIsntWorkingThenItWillTakeTrillionsOfYearsElseNearInstant(){
		lg("Starting testLinFibonacciSoDeepThatIfCacheFuncParamReturnIsntWorkingThenItWillTakeTrillionsOfYearsElseNearInstant");
		throw new Error("TODO");
	}
	
	public static void testEquals(){
		lg("Starting testEquals - The universalFunc being a patternCalculusFunc allows it to do this which lambdaFuncs cant cuz its a subset of possible lambdaFuncs thats a universal subset but also a subset that allows it to know patternCalculus things that it couldnt know outside that subset cuz it wouldnt know which are in or not in the subset, except that in this system its always in that subset. Its important to understand that the equals func is implemented as a pure sparse turing machine and does not use any implementing system's == or .equals operators etc except other implementations can do that as an optimization as long as it always gets the exact same result as the sparse turing machine.");
		testEqq("(equals . .)", e(equals,u,u), T);
		testEqq("(equals . (..))", e(equals,u,e(u,u)), F);
		testEqq("(equals (..) .)", e(equals,e(u,u),u), F);
		testEqq("(equals (..) (..))", e(equals,e(u,u),e(u,u)), T);
		testEqq("(equals ((..).) ((..).))", e( equals, e(e(u,u),u), e(e(u,u),u) ), T);
		testEqq("(equals (.(..)) (.(..)))", e( equals, e(u,e(u,u)), e(u,e(u,u)) ), T);
		testEqq("(equals ((..)(..)) ((..)(..)))", e( equals, e(e(u,u),e(u,u)), e(e(u,u),e(u,u)) ), T);
		testEqq("(equals (..) ((..).))", e( equals, e(u,u), e(e(u,u),u) ), F);
		testEqq("(equals ((..).) (..))", e( equals, e(e(u,u),u), e(u,u) ), F);
		testEqq("(equals car car)", e(equals,car,car), T);
		testEqq("(equals car cdr)", e(equals,car,cdr), F);
		testEqq("(equals equals equals)", e(equals,equals,equals), T);
		testEqq("(equals car equals)", e(equals,car,equals), F);
	}
	
	/** (lazig x y z) returns (x y) */
	public static void testLazig(){
		lg("Starting testLazig");
		Node cbtAN = e(lazig, A, N, P);
		testEqq("lazigA", e(lazig,A), e(lazig,A));
		testEqq("lazigAN", e(lazig,A,N), e(lazig,A,N));
		testEqq("lazigANP", e(lazig,A,N,P), e(A,N));
		testEqq("lazigPAN", e(lazig,P,A,N), e(P,A));
	}
	
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
	}
	
	public static void main(String[] args){
		testIota();
		thisHelpsInManuallyTestingCacheFuncParamReturnUsingDebugger();
		testIsHalted();
		testLeafAndFewOpsInternalStructures();
		testSTLR();
		testLRQuine();
		testIdentityFuncs();
		testConsCarCdr();
		testBigCallParams();
		testBigCallRecur1To6();
		testIfElse();
		testIFInBigcall();
		testLogic();
		testLazig();
		testChurchEncodingOfArithmetic();
		testLinPlusOne();
		testEquals();
		//as of 2020-6-27-7a it passes to here
		
		
		//testLinPlus();
		testLinFibonacciSoDeepThatIfCacheFuncParamReturnIsntWorkingThenItWillTakeTrillionsOfYearsElseNearInstant();
		
		//TODO get CacheFuncParamReturn working (using Node.cacheKey) else nearly everything will cost exponential.
		//TODO test car cdr cons nil
		//TODO create equals func and verify (equals equals equals)==T and (equals car car)==T and (equals car cdr)==F.
		lg("Ocfn3 tests passed - TODO more tests.");
	}

}
