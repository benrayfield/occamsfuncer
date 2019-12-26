package immutableexceptgas.occamsfuncerV2.impl.util;
import static immutableexceptgas.occamsfuncerV2.impl.util.Example.cc;
import static immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic.*;

import java.lang.reflect.InvocationTargetException;

import immutableexceptgas.occamsfuncerV2.fn;

/** This is NOT part of the occamsfuncer spec since all these
could be derived using the simpler ops (at most height4)
without writing any java code,
but the parts containing hardcoded BinaryOperator<fn>
as optimizations are plugins. Those could inTheory be
compiled automatically but that would need a smarter compiler.
<br><br>
Examples of things you could derive at user level
from the leaf aka the universal function,
without any java code, but since I'm still building the system
I'm going to call those combos using java.
*/
public class Example{
	private Example(){}
	
	/** TODO port the older version of https://github.com/benrayfield/smartblob
	to occamsfuncer, as a proof of concept of opencl and javassist optimization
	of that amount of complexity. It must be the triangle kind of smartblob
	instead of the circles kind, cuz circles are not a good proof of concept.
	*/
	private static fn bouncingSpringy2dPolygonsLikeInSmartblobGame;
	public static fn bouncingSpringy2dPolygonsLikeInSmartblobGame(){
		if(bouncingSpringy2dPolygonsLikeInSmartblobGame == null){
			throw new Error("TODO");
		}
		return bouncingSpringy2dPolygonsLikeInSmartblobGame;
	}
	
	
	
	/** TODO use "Op.nondetGet cbtAsStringPlug (ocfnplug)"
	by prefixing all of these with ocfn,
	like ocfnplugEquals, ocfnplugCdr, etc?
	Or I could use these funcs to create the fns
	then store the fns and not need these javafuncs again.
	Or I could make 1 func that uses java reflection to get these
	and it starts with ocfnplug,
	like ocfnplugReflectExample(String funcName)
	Example: ocfnplugReflectExample("cdr") returns Example.cdr().
	*/
	public static fn ocfnplugReflectExample(String funcName){
		$();
		try{
			return (fn) Example.class.getMethod(funcName).invoke(null);
		}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e){
			return infLoop();
		}
	}
	
	private static fn iota;
	/** This has the same param/return mapping as
	iota aka Lf.f(Lx.Ly.Lz.((xz)(yz)))(Lq.Li.q)
	and differs only in reflection ability
	(which the universal lambda function can do, so its not exactly iota)
	as you can use Op.L and Op.R to look at the call pairs inside
	any halted state while still being a function within the system.
	*/
	public static fn iota(){
		if(iota == null){
			iota = pair.f(S).f(T);
		}
		return iota;
	}
	
	private static fn callParamOnItself;
	public static fn callParamOnItself(){
		if(callParamOnItself == null){
			callParamOnItself = S.f(I).f(I);
		}
		return callParamOnItself;
	}
	
	private static fn fnThatInfiniteLoopsForEveryPossibleParam;
	public static fn fnThatInfiniteLoopsForEveryPossibleParam(){
		if(fnThatInfiniteLoopsForEveryPossibleParam == null){
			fnThatInfiniteLoopsForEveryPossibleParam =
				lazig().f(callParamOnItself()).f(callParamOnItself());
		}
		return fnThatInfiniteLoopsForEveryPossibleParam;
	}
	
	//TODO put BinaryOperator<fn> in some of these.
	
	/*Use Op.pair instead
	private static fn cons;
	public static fn cons(){
		if(cons == null){
			return pair; //https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
		}
		return cons;
	}*/
	
	private static fn c;
	/** curry 2 without constraint. funcBody then its params are next. */
	public static fn c(){
		if(c == null){
			c = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(4),
				T //no constraint
			);
		}
		return c;
	}
	
	private static fn cc;
	/** curry 2 without constraint. funcBody then its params are next. */
	public static fn cc(){
		if(cc == null){
			cc = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(5),
				T //no constraint
			);
		}
		return cc;
	}
	
	private static fn ccc;
	/** curry 3 without constraint. funcBody then its params are next. */
	public static fn ccc(){
		if(ccc == null){
			ccc = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(6),
				T //no constraint
			);
		}
		return ccc;
	}
	
	private static fn cccc;
	/** curry 4 without constraint. funcBody then its params are next. */
	public static fn cccc(){
		if(cccc == null){
			cccc = f(
				curry,
				//cuz (curry cbtAsUnary constraint funcBody params...)
				unary(7),
				T //no constraint
			);
		}
		return cccc;
	}
	
	private static fn[] currysWithoutConstraints = new fn[256];
	/** curry 4 without constraint. funcBody then its params are next. */
	public static fn c(int funcParams){
		boolean isSmall = funcParams<256;
		fn cached = isSmall ? currysWithoutConstraints[funcParams] : null;
		if(cached != null) return cached;
		fn ret = f(
			curry,
			//cuz (curry cbtAsUnary constraint funcBody params...)
			unary(3+funcParams),
			T //no constraint
		);
		if(isSmall) currysWithoutConstraints[funcParams] = ret;
		return ret;
	}
	
	private static fn and;
	/** AND of 2 params which are each T or F. Returns T or F.
	TODO check compatibility with https://en.wikipedia.org/wiki/Church_encoding
	TODO optimize: use ifelse for shortcircuiting.
	*/
	public static fn and(){
		if(and == null){
			and = f(
				cc(),
				S(
					p(4),
					p(5), //if p4 is T
					t(F) //if p4 is F
				)
			);
		}
		return and;
	}
	
	private static fn or;
	/** OR of 2 params which are each T or F. Returns T or F.
	TODO optimize: use ifelse for shortcircuiting.
	*/
	public static fn or(){
		if(and == null){
		and = f(
				cc(),
				S(
					p(4),
					t(F), //if p4 is T
					p(5) //if p4 is F
				)
			);
		}
		return and;
	}
	
	private static fn unaryInc;
	/** Example: unaryInc().f(unary(3))==unary(4). */
	public static fn unaryInc(){
		if(unaryInc == null){
			//FIXME should this verify it is a unary (cbt of all cbt1)?
			unaryInc = callParamOnItself;
		}
		return unaryInc;
	}
	
	/*
	private static fn unaryDec;
	public static fn unaryDec(){
		if(unaryDec == null){
			//FIXME should this verify it is a unary (cbt of all cbt1)?
			//FIXME what if its already unary(0) aka cbt1? Return cbt1? Inflop?
			unaryDec = L;
		}
		return unaryDec;
	}*/
	
	/** FIXME cant do this easily without equals func to detect unary0 */
	private static fn unaryAdd;
	/** Example: unaryAdd().f(unary(3)).f(unary(4))==unary(7). */
	public static fn unaryAdd(){
		if(unaryAdd == null){
			unaryAdd = f(
				cc(),
				IF(
					ST(equals(),p(5),t(unary(0))), //if second param is unary(0)
					then(p(4)), //then return first param (second param moved into it)
					then(
						recur,
						ST(unaryInc(),p(4)), //1 higher cbt than p4
						ST(L, p(5)) //1 lower cbt than p5. R would work too.
					)
				)
			);
		}
		return unaryAdd;
	}
	
	//private static boolean experimentalEqualsCode = true;
	private static fn equals;
	public static fn equals(){
		if(equals == null){
			fn getP4 = p(4);
			fn getP5 = p(5);
			fn p5IsLeaf = S(t(isLeaf),getP5);
			equals = f(
				cc(),
				IF(
					S(t(isLeaf),getP4),
					then(p5IsLeaf),
					then(IF(
						p5IsLeaf,
						tt(F),
						then(
							t(and()),
							S(recur, S(t(L),getP4), S(t(L),getP5) ),
							S(recur, S(t(R),getP4), S(t(R),getP5) )
						)
					))
				)
			);
		}
		return equals;
	}
	
	private static fn funcParamReturn;
	/** Existence of (funcParamReturn func param return) (by curry constraint),
	See comment in Compiled.timeId for a kind of database I'm considering creating,
	and using this it only need store binaryForest (Ls and Rs and keepUntilAtLeast)
	since that can represent <func,param,return> (less efficiently but simpler).
	It would have 2 tables: <self,L,R,keepUntilAtLeast>. self is the primary key.
	and <self,bigCbt> //need log of these for a cbtBitstring unless you want to pad 0s.
	and <self,bigCbtBitstring>
	x.keepUntilAtLeast >= x.L().keepUntilAtLeast
	x.keepUntilAtLeast >= x.R().keepUntilAtLeast
	keepUntilAtLeast can be increased but not decreased,
	considering those constraints.
	This guarantees all fns reachable remain.
	<br><br>
	(funcParamReturn func param ret x) evals to (ret x).
	There is no return statement in lambdas. Return is just a name here.
	for any 3 fns func param return,
	proves that (func param) evals to return,
	except if it calls Op.nondet which is by definition potentially nondeterministic.
	It does that by (equals (func param) return),
	and if that never halts (caught by $(...) system limiting compute resources)
	then the funcParamReturn call wouldnt finish so you would never
	have a pointer to a (funcParamReturn func param return) that isnt true.
	*/
	public static fn funcParamReturn(){
		if(funcParamReturn == null){
			throw new Error("TODO see comment below");
			/*funcParamReturn = TODO infloop unless (func param) evals to return,
			and it must be done in curry's constraint instead of
			in curry's funcBody, cuz (funcParamReturn func param return)
			must eval to itself,
			therefore it must also take 1 more param
			(TODO choose arbitrary behavior, such as always return leaf,
			or act like the return so give param to the return.)).
			*/
		}
		return funcParamReturn;
	}
	
	
	
	private static fn IF;
	/** (IF condition ifTrue ifFalse)
	<br><br>
	This is a replacement for code like this...
	S(
		t(ifElse),
		S(...)#aCondition,
		f(lazig(), S(...)#anIfTrue),
		f(lazig(), S(...)#anIfFalse)
	)
	<br><br>
	Code like this instead (but this might be buggy and need to change, TODO)...
	S(
		t(IF()),
		S(...)#aCondition,
		S(...)#anIfTrue,
		S(...)#anIfFalse
	)
	<br><br>
	To do that, IF() needs to take those same anIfTrue and anIfFalse
	params and have the same behaviors as if lazig() were there.
	(lazig x y z) returns (x y).
	(lazig anIfTrue)'s next param is y which is the param that S(...)#anIfTrue
	passes down recursively, and z is the leaf param given by ifElse
	thats ignored just to cause the eval of (x y) aka (anIfTrue y).
	We have to build this using Op.ifElse
	(or could derive its behaviors with s and k but less efficiently)
	since this will not be a java func since I'm trying to
	avoid needing Op.nondet (which is how java funcs are called).
	The f(...) instead of S(...), in f(lazig(), S(...)#anIfTrue),
	prevents the outer S(t(ifElse)...) from passing its params
	down into S(...)#anIfTrue, and instead lazig remembers that param
	as the y in (lazig x y z).
	I will try building this using an ifElse and 2 lazigs.
	Wait, I cant, cuz  if S(...) is in a S(...) then by definition
	it passes the params down into the inner S(...).
	This IF() function is therefore logically impossible as defined,
	but I can adjust the syntax so lazig is shorter to write.
	I could give it a 1 letter name like t(x) means T.f(x) aka (T x),
	and I could also define a letter that can be used instead of S,
	meaning that S is wrapped in a lazig call,
	maybe ifS(a b c) means f(lazig(), S(a b c)) or then(...)
	S(
		t(IF()),
		S(...)#aCondition,
		then(...)#anIfTrue,
		then(...)#anIfFalse
	)
	*
	public static fn IF(){
		if(IF == null){
			IF = f(
				ccc(),
				S(
					t(ifElse),
					p(4),
					S(t(S), t(t(lazig())), p(5)), //FIXME causes stackoverflow in Example.equals()
					S(t(S), t(t(lazig())), p(6)) //FIXME
				)
			);
		}
		return IF;
	}*/
	
	/** returns T or F depending if the 2 params equal by binForest shape.
	TODO optimize by Compiled that first checks their depth
	then compares them by whichever id type(s) is believed to be a secureHash,
	but want to avoid that if can trivially detect a difference
	such as isNil which is implemented using this is only looking
	for a specific thing.
	<br><br>
	The equals is a func that checks every path and uses Op.isLeaf
	so has exponential cost, but will be optimized to average constant time
	and that constant is at worst the time to compute an id
	(of which multiple id types are allowed simultaneously
	but 1 should be chosen to be trusted for determiniing equality
	at least in the early prototype).
	*
	public static fn equals(){
		if(equals == null){
			/*TODO write the exponential cost implementation first,
			then write the Compiled optimization of it,
			keeping in mind that id funcs must themself be written as fn
			and normally would themselves be optimized by Compiled.
			Define it recursively. If both are isLeaf then it equals,
			else if 1 is isLeaf and the other not, then not equals,
			else the AND of equals of both lefts and both rights.
			Op.curry is designed to have a pointer to the func being called
			so it can be recursive.
			Do 3 if/elses (2 of which are used each time) and handle all 4 cases.
			*
			
			//p4 is first param cuz p0..p3 are standard parts of curry.
			fn getP4 = p(4);
			fn getP5 = p(5);
			fn p5IsLeaf = S(t(isLeaf),getP5);
			/*equals =
				f(
					cc,
					S( //funcBody
						S(t(isLeaf),getP4), //returns T or F for first param
						p5IsLeaf, //optimization of the commentedout S(...) below
						//S(
						//	//FIXME verify if this is the right way to if/else inside if/else
						//	p5IsLeaf,
						//	t(T), //both leafs, equals return true
						//	t(F) //1 is leaf and the other not, equals return false
						//),
						S(
							p5IsLeaf,
							t(F), //1 is leaf and the other not, equals return false
							S(
								//Return AND of
								//(recurse into 2 lefts) (recurse into 2 rights)
								t(and()),
								S( recur, S(t(L),getP4), S(t(L),getP5) ),
								S( recur, S(t(R),getP4), S(t(R),getP5) )
							)
						)
					)
				);
			*/
			
			
			/*
			//implement equals using Op.ifElse
			//FIXME use Op.ifElse
			//.Example.How to split p5IsLeaf, related to S(...)?
			equals =
				f(
					cc(),
					S( //funcBody
						t(ifElse),
						
						//condition
						S(t(isLeaf),getP4),
						
						//(S((T I)(T p5IsLeaf)) p) is (p5IsLeaf p)
						//but something to figure out...
						//does S((T I) p5IsLeaf) work? It doesnt lazyeval
						//but its just the condition so ok not to lazyeval that.
						
						//funcIfTrue
						t(I),
						//t(p5IsLeaf),
						
						//paramIfTrue
						p5IsLeaf,
						
						//p5IsLeaf.L(),
						//p5IsLeaf.R(),
						//S(
						//	//FIXME verify if this is the right way to if/else inside if/else
						//	p5IsLeaf,
						//	t(T), //both leafs, equals return true
						//	t(F) //1 is leaf and the other not, equals return false
						//),
						
						//funcIfFalse
						S(
							t(ifElse),
							p5IsLeaf,
							
							//See S((T I) p5IsLeaf) comment above
							t(I),
							t(F),
							//t(F).L(), //1 is leaf and the other not, equals return false
							//t(F).R(),
							
							//FIXME use ifElse in here?
							//but how? cuz there are 32 things: and, recur..., recur...
							//A/lso ifElse of 5 params is making things bigger to write
							//and is making me get L and R of things I want to use literally.
							//Also the depth of multiple S(...) is confusing.
							//I need to get this Example.equals() func working
							//as proofOfConcept that the universal function (leaf)
							//is flexible, practical, and turingComplete,
							//though this isnt enough for proof of turingCompleteness
							//I would soon after building this func build rule110, proving it,
							//then proceed to other Example funcs implementing various games etc.
							//...
							//or if I cant get this to work intuitively and correct math
							//then I'll have to use the lazy interface (which has lazyL lazyR and eval funcs
							//and implements fn and runs (lazyL lazyR) to get the thing it actually wraps
							//and remembers ptr to that fn it wraps
							//before returning from any javafunc in fn such as fn.L() or fn.cur()
							//but only for calls that do not instantly return (such as cur()>1).
							//Op.ifElse appears to not align well with the following way
							//Im trying to use S(... S(...) S(...) ...) to AND 2 RECURs.
							//Does the t(S(...)) t(I) fix it? Probably. TODO verify.
							
							
							
							//FIXME the recurs here might be getting
							//the wrong param cuz the S is inside t(...)
							//t(S(
							//	//Return AND of
							//	//(recurse into 2 lefts) (recurse into 2 rights)
							//	t(and()),
							//	S( recur, S(t(L),getP4), S(t(L),getP5) ),
							//	S( recur, S(t(R),getP4), S(t(R),getP5) )
							//)),
							//t(I)
							
							
							//FIXME the recurs here might be getting
							//the wrong param cuz the S is inside t(...)
							//TODO use lazyEval here a few places?
							S(
								//Return AND of
								//(recurse into 2 lefts) (recurse into 2 rights)
								t(and()),
								S( t(lazyEval), S(recur,S(t(L),getP4)), S(t(L),getP5) ),
								S( t(lazyEval), S(recur,S(t(R),getP4)), S(t(R),getP5) )
							),
							t(I)
						),
						//paramIfFalse
						t(I)
					)
				);
				*/
			
				/*equals = f(
				cc(),
				S(
					t(ifElse),
					//condition
					S(t(isLeaf),getP4),
					//funcIfTrue
					t(I),
					//paramIfTrue. p4 is leaf.
					p5IsLeaf, //already know p4IsLeaf here
					//funcIfFalse. p4 is not leaf.
					S(
						t(ifElse),
						p5IsLeaf,
						//inner ifTrue
						t(I),
						t(F), //p4 isLeaf. p5 !isLeaf.
						
						//inner ifFalse. p4 !isLeaf. p5 !isLeaf.
						
						//I need to avoid giving recur its last param
						//until the outer ifelse does (funcIfFalse paramIfFalse).
						//That paramIfFalse will be ignored.
						//It can be done with lazyEval s k etc somehow.
						//(lazyEval x y z) returns (x y z)
						//(s x y z) return ((x z)(y z)).
						//I still need the param to flow down the s forest
						//so recur and getP4 and getP5 will work,
						//and in (s x y z) that param is z.
						//I might need to derive a new func, which I'll call lazys.
						
						
						//lazys of AND (recurse into 2 lefts) (recurse into 2 rights)
						//
						//Putting lazys in S(...) wont work. lazys needs to be in f(...)
						//but somehow to reproduce the behaviors of S(...).
						//
						//If this definition of lazys is true, will it work?
						//(lazys w x y z) returns ((w z)(y z))?
						//Probably so. TODO test this in TestBasics.*equals*
						//(after finishing Example.lazys() to do that.
						S(
							t(lazys()),
							t(S(
								t(and()),
								S(recur, S(t(L),getP4), S(t(L),getP5) )
							)),
							t(S(recur, S(t(R),getP4), S(t(R),getP5) ))
						),
						t(I)
						
						//S(
						//	//AND (recurse into 2 lefts) (recurse into 2 rights)
						//	t(and()),
						//	S( t(lazyEval), S(recur,S(t(L),getP4)), S(t(L),getP5) ),
						//	S( t(lazyEval), S(recur,S(t(R),getP4)), S(t(R),getP5) )
						//),
						//t(I)
					),
					//paramIfFalse
					t(I)
				)
				*
			
				equals = f(
					cc(),
					S(
						t(ifElse),
						//condition
						S(t(isLeaf),getP4),
						//funcIfTrue
						S(t(lazig()), p5IsLeaf),
						//t(I),
						//paramIfTrue (is always leaf if redesign ifElse). p4 is leaf.
						//p5IsLeaf, //already know p4IsLeaf here
						//funcIfFalse. p4 is not leaf.
						S(
							t(ifElse),
							p5IsLeaf,
							//inner ifTrue
							t(t(F)), //first T is for S(...). Second T is for ifElse gives leaf param.
							//t(I),
							//t(F), //p4 isLeaf. p5 !isLeaf.
							
							//inner ifFalse. p4 !isLeaf. p5 !isLeaf.
							
							/*I need to avoid giving recur its last param
							until the outer ifelse does (funcIfFalse paramIfFalse).
							That paramIfFalse will be ignored.
							It can be done with lazyEval s k etc somehow.
							(lazyEval x y z) returns (x y z)
							(s x y z) return ((x z)(y z)).
							I still need the param to flow down the s forest
							so recur and getP4 and getP5 will work,
							and in (s x y z) that param is z.
							I might need to derive a new func, which I'll call lazys.
							*/
							
							//lazys of AND (recurse into 2 lefts) (recurse into 2 rights)
							//
							//Putting lazys in S(...) wont work. lazys needs to be in f(...)
							//but somehow to reproduce the behaviors of S(...).
							//
							//If this definition of lazys is true, will it work?
							//(lazys w x y z) returns ((w z)(y z))?
							//Probably so. TODO test this in TestBasics.*equals*
							//(after finishing Example.lazys() to do that.
							
							/*S(
								t(lazys()),
								t(S(
									t(and()),
									S(recur, S(t(L),getP4), S(t(L),getP5) )
								)),
								t(S(recur, S(t(R),getP4), S(t(R),getP5) ))
							),
							t(I)
							*
							f(
								lazig(),
								S(
									t(and()),
									S(recur, S(t(L),getP4), S(t(L),getP5) ),
									S(recur, S(t(R),getP4), S(t(R),getP5) )
								)
							)
							
							
							//S(
							//	//AND (recurse into 2 lefts) (recurse into 2 rights)
							//	t(and()),
							//	S( t(lazyEval), S(recur,S(t(L),getP4)), S(t(L),getP5) ),
							//	S( t(lazyEval), S(recur,S(t(R),getP4)), S(t(R),getP5) )
							//),
							//t(I)
						)
						//paramIfFalse (is always leaf if redesign ifElse)
						//t(I)
					)
				
				
			);
			
			//TODO optimize by equals.setCompiled(new Compiled(...)) 
		}
		return equals;
	}*/
	
	/** OLD DESIGN OF EXAMPLE.EQUALS... used lazig instead.
	The first usecase of it is in Example.equals().
	(lazys w x y z) returns ((w z)(y z)).
	<br><br>
	Wrote this while figuring out what lazys does (still not sure but getting closer)...
	S((lazys S(...) S(...)) t(I))
	returns something with the 2 inner S(...) called on eachother,
	and those inner S(...) get the param that came into the outer S(...)
	cuz of the t(I).
	Wait, I might be missing another param since the outer S(...)
	gives the param that the inner S(...)es need.
	amd the t(I)'s purpose is to delay calling the inner S(...)es on eachother
	until the ifElse calls (funcIfTrue paramIfTrue) or (funcIfFalse paramIfFalse).
	That t(I) can remember the param that the S(...)es need even after
	lazys ignores it. That design appears to be...
	(lazys w x y z) returns ((w z)(y z))
	and could be described as a lazy-s since (s w x z) is ((w z)(x z))
	so the lazy part is the y param.
	Is that what I want? (lazys w x y z) returns ((w z)(y z))?
	Maybe, but I need to make sure that fits with the lazys working inside f(...)
	instead of S(...). 
	<br><br>
	OLD...
	TODO?
	(lazys x y z) returns (x y)
	TODO? (S(lazys w x) y z) returns (S(w x) y), and (S(lazys w x) y) is halted.
	FIXME is that possible?
	*/
	private static fn lazys;
	public static fn lazys(){
		if(lazys == null){
			//(lazys w x y z) returns ((w z)(y z)).
			lazys = f(
				cccc(),
				S(
					S(p(4),p(7)),
					S(p(5),p(7))
				)
			);
		}
		return lazys;
	}
	
	private static fn lazig;
	/** (lazig x y z)->(x y) */
	public static fn lazig(){
		if(lazig == null){
			lazig = f( ccc(), S(p(4),p(5)) ); //ignore p(6)
		}
		return lazig;
	}
	
	private static fn ifElse;
	/** UPDATE: If condition is not T or F then evals to (pair ifTrue ifElse condition),
	or something similar to that TODO verify.
	OLD... (ifElse condition ifTrue ifFalse)
	evals to (ifTrue leaf) if condition==T,
	evals to (ifFalse leaf) if condition==F,
	else infloops.
	Normally used with lazig and S. See Example.equals() andOr ImportStatic.IF(fn,fn,fn).
	*/
	public static fn ifElse(){
		if(ifElse == null){
			fn getCondition = p(4);
			fn getIfTrue = p(5);
			fn getIfFalse = p(6);
			ifElse = f(
				ccc(),
				S(
					ST(pair, getIfTrue, getIfFalse, getCondition),
					t(leaf)
				)
			);
		}
		return ifElse;
	}
	
	private static fn lazyEval;
	/** (lazyEval x y z) returns (x y z) */
	public static fn lazyEval(){
		if(lazyEval == null){
			lazyEval = f( ccc(), S(p(4),p(5),p(6)) );
		}
		return lazyEval;
	}
	
	
	private static fn unaryAddUsingNondetEqq;
	/** cuz cant make the normal unaryAdd yet cuz havent got equals() working
	and am making unaryAdd to test Op.ifElse with Op.recur.
	This func recursively decreases second param while increasing first param
	until second param is unary(0).
	*/
	public static fn unaryAddUsingNondetEqq(){
		if(unaryAddUsingNondetEqq == null){
			fn getP4 = p(4);
			fn getP5 = p(5);
			fn unaryDec = L;
			unaryAddUsingNondetEqq = f(
				cc(),
				S(
					t(Example.ifElse()),
					//condition. If second param is unary0
					S(t(eqq().f(unary(0))),getP5),
					//ifTrue
					f(Example.lazig(), getP4),
					//ifFalse
					f(
						Example.lazig(),
						S(
							recur,
							S(t(unaryInc()),getP4),
							S(t(unaryDec),getP5)
						)
					)
				)	
			);
			
			/*this is using the old 5 param kind of ifElse (redesigned to 3 params)
			unaryAddUsingNondetEqq = f(
				cc(),
				S(
					t(ifElse),
					//condition. If second param is unary0
					S(t(eqq().f(unary(0))),getP5),
					//funcIfTrue
					t(I),
					//paramIfTrue
					getP4, //return this
					//funcIfFalse
					S(
						recur,
						S(t(unaryInc()),getP4)
					),
					//paramIfFalse
					S(t(unaryDec),getP5)
				)	
			);
			*/
		}
		return unaryAddUsingNondetEqq;
	}
	
	private static fn doubleMult;
	/** given 2 params that are cbtBitstring of 64 bits each, returns another of those
	thats the strictfp ieee754 multiply of those doubles
	such as what happens in java when you multiply 2 doubles in strictfp.
	*/
	public static fn doubleMult(){
		if(doubleMult == null){
			throw new Error("TODO");
		}
		return doubleMult;
	}
	
	/** curry 2 cbt bitstrings each of size 64, return 1 of those */
	private static fn doubleAdd;
	public static fn doubleAdd(){
		if(doubleAdd == null){
			throw new Error("TODO");
		}
		return doubleAdd;
	}
	
	/** curry 2 cbt bitstrings each of size 32, return 1 of those */
	private static fn floatAdd;
	public static fn floatAdd(){
		if(floatAdd == null){
			throw new Error("TODO");
		}
		return floatAdd;
	}
	
	private static fn mandelbrot;
	/** given some representation (TODO choose one) of x y coordinates in cbtBitstring,
	returns a cbtBitstring of the double representing the brightness/color
	as mandelbrot is normally displayed continuously
	even though technically mandelbrot returns a bit.
	*/
	public static fn mandelbrot(){
		if(mandelbrot == null){
			throw new Error("TODO");
		}
		return mandelbrot;
	}
	
	private static fn car;
	/** Lx.xF where F is La.Lb.b
	https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	*/
	public static fn car(){
		if(car == null){
			//(pair x y) is Lxyz.zyx
			//(car (pair x y)) is x
			//(car (pair x y)) is La.aT
			car = S.f(I).f(t(T));
		}
		return car;
	}
	
	private static fn cdr;
	/** Lx.xT where T is La.Lb.a
	https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	*/
	public static fn cdr(){
		if(cdr == null){
			//see comment in car()
			car = S.f(I).f(t(F));
		}
		return cdr;
	}
	
	private static fn nil;
	/** https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	says this should be (pair T T), but I'm undecided about that.
	Am trying it.
	FIXME See how it works in TestBasics,
	and make sure to test strange combos of it.
	*/
	public static fn nil(){
		if(nil == null){
			nil = pair.f(T).f(T);
		}
		return nil;
	}
	
	private static fn isNil;
	/** TODO https://en.wikipedia.org/wiki/Church_encoding#Church_pairs
	says isNil should be FIRST aka CAR, but in this system
	there seems to be a better form of it which is
	(equals nil) so (equals nil x) would be T or F depending
	if the forest shape of nil and x are equal.
	*/
	public static fn isNil(){
		if(isNil == null){
			isNil = equals().f(nil());
		}
		return isNil;
	}
	
	
	
	
	
	
	
	
	/** more general than rule110 as it can do all 256 elementaryCellularAutomata
	Takes a size 8 cbt bitstring as param (or TODO should it be a cbt of 8 cbtLeafs?)
	*/
	private static fn elementaryCellularAutomataRecur;
	public static fn elementaryCellularAutomataRecur(){
		if(elementaryCellularAutomataRecur == null){
			throw new Error("TODO");
		}
		return elementaryCellularAutomataRecur;
	}
	
	/** recursive, not cbt optimized, except for the 2d indexs being cbt.
	Takes a func of 2 cbts for the baseCases,
	and is a func of 3 params that takes the basecase func and 2 cbts,
	or something like that (TODO choose an interface),
	and returns a bit (todo cbt or T/F?) for that 2d coordinate.
	*/
	private static fn rule110Recur;
	public static fn rule110Recur(){
		if(rule110Recur == null){
			throw new Error("TODO derive from elementaryCellularAutomataRecur");
		}
		return rule110Recur;
	}
	
	/** true if is a cbt (complete binary tree) of cbt0 and cbt1
	AND it has at least 1 cbt1 (just past end of the bitstring).
	TODO setCompiled optimization to call fn.isBitstring.
	*
	public static fn isBitstring;
	public static fn isBitstring(){
		
		if(isBitstring == null){
			isBitstring = f(
				c(),
				IF(
					ST(), TODO base case is it [cbt0 or cbt1] or is it not a cbt, and does cbt allow noncompletebinarytree shapes such as (0(11))?
					TODO,
					S(recur, )
				)
			);
			
			//FIXME that was copied from equals, rewrite it.
			//isBitstring = f(
			//	cc(),
			//	IF(
			//		S(t(isLeaf),getP4),
			//		then(p5IsLeaf),
			//		then(IF(
			//			p5IsLeaf,
			//			tt(F),
			//			then(
			//				t(and()),
			//				S(recur, S(t(L),getP4), S(t(L),getP5) ),
			//				S(recur, S(t(R),getP4), S(t(R),getP5) )
			//			)
			//		))
			//	)
			//);
			
			throw new Error("TODO");
		}
		return isBitstring;
	}*/
	
	
	/** given a cbt bitstring, which is any cbt that has a cbt1,
	else infloop if has no cbt1,
	push a cbt0 just before the last cbt1.
	*/
	public static fn cbtbsPush0;
	public static fn cbtbsPush0(){
		if(cbtbsPush0 == null){
			//cbtbsPush0 = TODO;
			throw new Error("TODO");
		}
		return cbtbsPush0;
	}
	
	/** given a cbt bitstring, which is any cbt that has a cbt1,
	else infloop if has no cbt1,
	push a cbt1 just before the last cbt1.
	*/
	public static fn cbtbsPush1;
	public static fn cbtbsPush1(){
		if(cbtbsPush1 == null){
			throw new Error("TODO");
			//cbtbsPush1 = TODO;
		}
		return cbtbsPush1;
	}
	
	public static fn cbtbsPeek;
	/** given a cbt bitstring, which is any cbt that has a cbt1,
	else infloop if has no cbt1,
	return the cbt0 or cbt1 just before the last cbt1.
	*/
	public static fn cbtbsPeek(){
		if(cbtbsPeek == null){
			throw new Error("TODO");
			//cbtbsPeek = TODO;
		}
		return cbtbsPeek;
	}
	
	public static fn cbtbsPop;
	/** given a cbt bitstring, which is any cbt that has a cbt1,
	else infloop if has no cbt1,
	returns such a bitstring 1 smaller, or returns same bitstring if already empty.
	To get the bit (cbt0 or cbt1) popped, use cbtbsPeek() on the nonpopped state. 
	*/
	public static fn cbtbsPop(){
		if(cbtbsPop == null){
			throw new Error("TODO");
			//cbtbsPop = TODO;
		}
		return cbtbsPop;
	}
	
	/** depending on param can generate any possible turingMachine and step through its states,
	representing it as Op.pair of the efficient-fork-append ends of 2 cbt bitstrings
	so can push/pop bits between them or even insert/delete to change the size
	of the turing tape.
	*/
	private static fn turingMachine;
	public static fn turingMachine(){
		if(turingMachine == null){
			throw new Error("TODO");
		}
		return turingMachine;
	}
	
	private static fn mapPut;
	public static fn mapPut(){
		if(mapPut == null){
			throw new Error("TODO");
		}
		return mapPut;
	}
	
	private static fn mapPair;
	public static fn mapPair(){
		if(mapPair == null){
			fn unary7 = unary(7);
			//func that infloops if parent's fields dont fit with both child's fields together
			fn mapPairConstraint = null;//FIXME TODO
			//func that does GET
			fn mapPairFuncBody = null;//FIXME todo
			//both of those use Op.getParam, where param0 is curry and param3 is mapPairFuncBody
			//and param4 is idFunc and param5 is number of key/val pairs in the map (cbtAsSize),
			//and so on until last param is getKey. Constraint cant see getKey (the key to get)
			//cuz constraint runs at cur()-1 so gets a different (lazyEval currysL currysR)
			//where currysR is maxChild instead of getKey.
			//So MapPair is just a name (that doesnt affect ids) of the earlier params
			//and MapPair is a specific call of Op.curry.
			//(MapPair idFunc cbtAsSize minKey maxKey minChild maxChild getKey)
			fn MapPair = f(curry,unary7,mapPairConstraint,mapPairFuncBody);
			//func that forkEdits a map (MapPair, MapSingle, or MapEmpty)
			//(mapPut map key val) returns forkEdited map
			throw new Error("TODO");
		}
		return mapPair;
	}
	
	/** see Opcode.acyclicFlow and .acyclicFlowN in other fork of occamsfuncer.
	This is where to hook in the int[] acyclicFlow music tool optimization.
	*/
	private static fn acyclicFlow;
	public static fn acyclicFlow(){
		if(acyclicFlow == null){
			throw new Error("TODO");
		}
		return acyclicFlow;
	}
	
	/** see Opcode.acyclicFlow and .acyclicFlowN in other fork of occamsfuncer.
	This is where to hook in the int[] acyclicFlow music tool optimization.
	*/
	private static fn acyclicFlowN;
	public static fn acyclicFlowN(){
		if(acyclicFlowN == null){
			throw new Error("TODO");
		}
		return acyclicFlowN;
	}
	
	/** a digsig (digital signature) algorithm for signing and verifying
	cbt bitstring, which has small signatures, publicKeys, privateKeys,
	and deterministicly generates key pairs without need for salt.
	*/
	private static fn ed25519sha512;
	public static fn ed25519sha512(){
		if(ed25519sha512 == null){
			throw new Error("TODO");
		}
		return ed25519sha512;
	}
	
	/** FIXME do this in Op.nondetGet instead.
	wraps mutable parts of the world in immutable lambda
	by having them digsign (digitally sign, such as by ed25519sha512)
	pairs of <param,return>, and param may include time andOr other ids,
	BUT this is technically not safe enough to be considered a lambda
	and must instead be part of Op.nondetGet
	cuz someone could sign multiple <param,return> for the same param
	and then that whole func (a mutableWrapperLambda) would be invalid
	unless it was defined as possibly nondeterministic from the start.
	*
	private static fn mutableWrapperLambda;
	public static fn ed25519sha512(){
		if(ed25519sha512 == null){
			TODO
		}
		return ed25519sha512;
	}*/
	
	/** Example uses: opencl optimized LSTM or RBM neuralnets, matrix multiply,
	hashing many things at once, many ed25519 digsigs at once, etc.
	<br><br>
	This is where ForestOp.java and OpenclUtil.java and Javassist hook in,
	though its not the only place Javassist could optimize things,
	it is probably the only place Opencl ndrange kernels need to hook in
	(opencl image/convolutional would hook in maybe somewhere else).
	This is not specific to opencl or javassist as it could be
	implemented efficiently by any parallel number crunching system.
	<br><br>
	Its a forest of ForestOp where each ForestOp has n ForestOp childs
	the lowest of which is a func to GET a literal array from param passed
	in at each of the top ForestOps (s and curry style).
	Each ForestOp returns 1 array thats an integer multiple size
	of number of opencl get_global_id(0)
	such as blocks of 5 float32s or blocks of 1 int32
	or blocks of 8 int32s representing a bigint each.
	It cant return multiple arrays from each ForestOp
	since you would use multiple ForestOp for that,
	which is a design sacrifice to keep it simple
	but technically could be implemented as those share some code
	within a single opencl kernel that returns multiple arrays.
	Occamsfuncer does not know the difference between primitive types
	at the cbt level but can know the difference at the function level
	which processes cbts as for example ieee754 strictfp float32 math
	or in Op.nondetGet you could use non-strictfp math or any
	nondeterministic op you want at your own risk of inconsistent behaviors
	but not at risk of anything escaping sandbox or infiniteLooping
	as its still protected by Gas.top etc (inTheory).
	This will do multiple forExample opencl kernels in a single call,
	which can be ordered async with dependnet (by multiple CLQueue) order.
	The recommended opencl implementation is LWJGL
	cuz of its low lag and compatibility with lots of desktop/laptop OSes,
	as will be used in the prototype, but thats NOT part of
	the occamsfuncer spec
	as the spec is ONLY the definition of the universal lambda function
	and everything other than that is just optimizations of it.
	Mobile phone implementations will probably implement this numCrunch fn
	using a different number crunching API specialized in their
	kind of hardware, similar to opencl.
	CUDA might be implemented in some systems
	as long as it follows the occamsfuncer spec
	and is therefore emulating occamsfuncer and just optimizing it
	and does not put anyone at the mercy and dependence on
	proprietary software since all its behaviors are known
	and formal-verifiable and challenge-response-able
	and replacable and redundantly implementable in
	multiple systems at once that can be hotSwapped
	andOr used together even as parts of the same function call
	across the internet at gaming-low-lag.
	Hadoop, number crunching clouds, quantum optimized clouds, etc,
	lots of possible ways to implement optimizations of this,
	though quantum optimizations might better have their own
	fn designed for their kind of statistics
	and maybe hook it in through op.nondetGet?
	*/
	private static fn numCrunch;
	public static fn numCrunch(){
		if(numCrunch == null){
			throw new Error("TODO");
		}
		return numCrunch;
	}
	
	/** the puzzle game where you slide pieces with powOf2 numbers on them */
	private static fn game2048;
	public static fn game2048(){
		if(game2048 == null){
			throw new Error("TODO");
		}
		return game2048;
	}
	
	private static fn gameRubiksCube3x3x3;
	public static fn gameRubiksCube3x3x3(){
		if(gameRubiksCube3x3x3 == null){
			throw new Error("TODO");
		}
		return gameRubiksCube3x3x3;
	}
	
	private static fn gameGoNxM;
	public static fn gameGoNxM(){
		if(gameGoNxM == null){
			throw new Error("TODO");
		}
		return gameGoNxM;
	}
	
	private static fn gameTetrisNxM;
	/** Each square in the 2d grid will have 2 bits: connectsToRight, connectsToDown.
	That way, all possible 2d shapes that fit in a grid,
	such as the normal tetris pieces, can be represented as each horizontally
	and vertically adjacent pairs of squares being connected or not,
	and will also want cbt for intARGB or just intRGB color
	(might store those 2 bits in the A 8 bits?). Undecided on the datastructs.
	*/
	public static fn gameTetrisNxM(){
		if(gameTetrisNxM == null){
			throw new Error("TODO");
		}
		return gameTetrisNxM;
	}
	
	private static fn gameChessNxM;
	public static fn gameChessNxM(){
		if(gameChessNxM == null){
			throw new Error("TODO");
		}
		return gameChessNxM;
	}
	
	private static fn gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM;
	public static fn gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM(){
		if(gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM == null){
			throw new Error("TODO");
		}
		return gameVariantOfChessWherePiecesHaveMovesOfSameColorPieceTheyrePointingAtButLoseTheirOwnMovesWhenSoNxM;
	}
	
	/** https://sourceforge.net/projects/visualintfactor/
	with 2d digit carrying.
	*/
	private static fn visualIntFactorGamelikeBoard;
	public static fn visualIntFactorGamelikeBoard(){
		if(visualIntFactorGamelikeBoard == null){
			throw new Error("TODO");
		}
		return visualIntFactorGamelikeBoard;
	}
	
	/** Similar to visualIntFactorGamelikeBoard except with added constraints
	to lock parts so can swap to integers but not swap their individual bits
	while locked but can while summing to left andOr summing toward right.
	Each row (or is it col) except 2 on the sides is 1 of the integers
	to be summed, either toward the left or right.
	*/
	private static fn visualIntFactorGamelikeBoardWithSubsetSumConstraints;
	public static fn visualIntFactorGamelikeBoardWithSubsetSumConstraints(){
		if(visualIntFactorGamelikeBoardWithSubsetSumConstraints == null){
			throw new Error("TODO");
		}
		return visualIntFactorGamelikeBoardWithSubsetSumConstraints;
	}
	
	/** a simple game for testing reinforcementLearning AIs */
	private static fn gameBlocksWorld;
	public static fn gameBlocksWorld(){
		if(gameBlocksWorld == null){
			throw new Error("TODO");
		}
		return gameBlocksWorld;
	}
	
	private static fn gameSimilarToPacman;
	public static fn gameSimilarToPacman(){
		if(gameSimilarToPacman == null){
			throw new Error("TODO");
		}
		return gameSimilarToPacman;
	}
	
	private static fn gameSimilarToMarioRoyaleManyPlayers;
	public static fn gameSimilarToMarioRoyaleManyPlayers(){
		if(gameSimilarToMarioRoyaleManyPlayers == null){
			throw new Error("TODO");
		}
		return gameSimilarToMarioRoyaleManyPlayers;
	}
	
	/** like the iotavm/iotadesktop ui on github
	except a regular grid instead of (float,float) positions.
	*/
	private static fn uiForDragAndDropFuncOntoFuncToGetFunc;
	public static fn uiForDragAndDropFuncOntoFuncToGetFunc(){
		if(uiForDragAndDropFuncOntoFuncToGetFunc == null){
			throw new Error("TODO");
		}
		return uiForDragAndDropFuncOntoFuncToGetFunc;
	}
	
	/** see Vob.java (Visual OBject) in another fork of occamsfuncer */
	private static fn vobGraphicsExample1;
	public static fn vobGraphicsExample1(){
		if(vobGraphicsExample1 == null){
			throw new Error("TODO");
		}
		return vobGraphicsExample1;
	}
	
	/** see benrayfields smoothtapenet project on github */
	private static fn smoothTapeNet;
	public static fn smoothTapeNet(){
		if(smoothTapeNet == null){
			throw new Error("TODO");
		}
		return smoothTapeNet;
	}
	
	/** see benrayfields hyperCubeWave project on github */
	private static fn hyperCubeWave;
	public static fn hyperCubeWave(){
		if(hyperCubeWave == null){
			throw new Error("TODO");
		}
		return hyperCubeWave;
	}
	
	/** audivolv interactive musical instrument evolver, with hyperSphereNet option. */
	private static fn audivolv;
	public static fn audivolv(){
		if(audivolv == null){
			throw new Error("TODO");
		}
		return audivolv;
	}
	
	/** average (heads-tails)^2 is number of coins,
	counting all exponential number of ways they can land exactly once.
	*/
	private static fn deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips;
	public static fn deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips(){
		if(deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips == null){
			throw new Error("TODO");
		}
		return deriveCentralLimitTheoremByAllPossibilitiesOfCoinFlips;
	}
	
	/** Since I havent got curry working perfectly yet (2019-11-26) I'm passing a pair
	to this func to test ocfnplug. (pair a b) aka ((pair a) b).
	2019-12 curry is working. (equals equals equals) returns T,
	where equals is Example.equals() which is a lambda func.
	*/
	public static fn ocfnplugEqqOfPair(fn aPair){
		fn a = aPair.L().R();
		fn b = aPair.R();
		return a==b ? T : F;
	}
	
	public static fn ocfnplugEqq(fn madeByCurry){
		$();
		fn a = getParam(4,madeByCurry);
		fn b = getParam(5,madeByCurry);
		return a==b ? T : F;
	}
	
	public static fn eqq;
	public static fn eqq(){
		if(eqq == null){
			eqq = cc().f(nondet.f("ocfnplug:"+Example.class.getName()+".ocfnplugEqq"));
		}
		return eqq;
	}
	
	/*TODO some of those fun experimental jar files in my q18 dir
	such as the "clouds that get brighter" graphics effect,
	or the earlier things that led to physicsmata, or physicsmata itself,
	smoothlife (not my project but could still implement variant of it),
	bayesiancortex experiment (didnt work out but still interesting),
	fluidGravity3Way, etc.
	
	TODO ops for the loop optimizations that avoid directly
	calculating maps but abstractly represent looping vars etc
	as puts of maps, and if/else that works with those,
	and progn-like ops (the p(...) syntax), etc.
	
	TODO, Example.java isnt the right place for ocfnplug,
	since Op.nondetGet is the right place,
	but I do want all static java funcs whose name (after package.a.b.classname)
	start with "ocfnplug" to be callable from Op.nondetGet cbtOfStringPlug,
	and be careful not to let any of those slip by Human attention
	as they must be trusted code trusted to not allow escape from sandbox,
	so dont want any to slip by in PULL REQUEST in opensource
	without much Human attention to them. Need an automatic generator
	of list of such funcs.
	*/

}





