package immutableexceptgas.occamsfuncerV2Prototype.util;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncerV2Spec.Gas;
import immutableexceptgas.occamsfuncerV2Spec.fn;
import mutable.util.Rand;

/** Implementation of Op.nondet goes here
and you can load plugins (TODO design that system, and maybe should be 3 params
instead of 2 where first is plugin name, second is plugin data
(such as a type:content) that refers to a function
to be called with third param.
<br><br>
OLD...
<br><br>
Anything thats possibly nondeterministic
goes in Op.nondetInfloopIf or Op.nondetGet.
The main usecases are Spend and Wallet ops which
are both nondeterministic cuz they read Gas.top (Wallet),
and another op (TODO name it) that infloops only if
Gas.top is less than its param, so as long as
theres enough gas its considered deterministic
since you can run it again until it might later
have enough gas and get the same
deterministic calculation eventually.
<br><br>
Other uses are to hook in plugins (NOT THE BEST WAY) such as
in funcs whose name (after package.x.y.z.classname) starts
with "ocfnplug" which is a way to opt in to the occamsfuncer system
as a security layer against it calling functions not designed
to work with it's counting of Gas.top etc.
<br><br>
Its strongly recommended to instead define the behaviors
of plugins as combos of the deterministic ops
and write a BinaryOperator<fn> to optimize those combos
of the universal function (the leaf),
including calling the $(...) funcs to
count and limit compute resources,
BUT thats often hard to do so both ways are available.
Hopefully the world will standardize on some variant
of the deterministic ops, some fork of occamsfuncer,
which can efficiently compute all possible things
and not have to trust plugins since they are derived.
*/
public class Nondet{

	
	public static fn nondet(fn type, fn instance, fn param){
		
		if(Gas.forceDeterminism){
			return infLoop();
		}else{
			if(type == nondet && instance == nondet){ //get powOf2 num of random bits
				//FIXME change this to take a long param for size of random bitstring to return?
				//or how about int? Should they be rawcbt, cbtBitstring of int, or Example.contentType("... that primitive...")???
				
				if(!param.isCbt()) return infLoop();
				long bits = param.cbtSize();
				if(bits < 8 || bits > (1<<30)) throw new Error("TODO?");
				byte[] b = new byte[(int)(bits>>3)];
				Rand.strongRand.nextBytes(b);
				return wrapPowOf2Size(b);
				//throw new Error("TODO return strongRandom cbt bits same size as param, if param is a cbt. This is the only source of randomness as it required redesigning Cache to not create CallAsKey if its L is (nondet nondet nondet). Use "+Rand.class+".strongRand");
			}
			String typeS = str(type);
			if(typeS.equals("ocfnplug")){
				String funcName = str(instance);
				int i = funcName.lastIndexOf('.');
				if(i == -1) throw new Error("no dot in "+funcName);
				String lastPartOfFuncName = funcName.substring(i+1);
				String className = funcName.substring(0,i);
				try{
					Class c = Class.forName(className);
					Method m = c.getMethod(lastPartOfFuncName,fn.class);
					if(m.getReturnType() != fn.class) throw new Error("java Method doesnt return "+fn.class+" type");
					if(!Modifier.isStatic(m.getModifiers())) throw new Error("java Method isnt static: "+funcName);
					//Dont curry like this cuz if you want it in a curry you put that outside the nondet call.
					//fn madeByCurry = lazyEval.f( curry.f(unary(5)).f(T).f(nondet).f(a) ).f( b );
					//return (fn) m.invoke(null,madeByCurry);
					return (fn) m.invoke(null,param);
				}catch(ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
					throw new Error("type="+type+" instance="+instance+" param="+param,e);
				}
			}else if(typeS.equals("limitComputeResources")){
				//In some options of running the system,
				//nondet.f("limitComputeResources") may be allowed
				//while nondet.f("ocfnplug") is not,
				//or any other set of possible limits on
				//what nondet calls are allowed,
				//but everything other than nondet is standard.
				//nondet means potentially NONDETerministic.
				
				//This code has not been tested as of 2020-1-25.
				//TODO optimize: move this code into 2 Compileds,
				//one at ccc().f(nondet.f("limitComputeResources").f("spend"))
				//and one at nondet.f("limitComputeResources").f("wallet")
				//so dont have to compare strings except the first time.
				$();
				
				/** See TestBasics.testLimitComputeResources
				and CallAsKey not being allowed to cache
				a call whose L is (nondet nondet nondet)
				cuz thats the randomness generator.
				
				FIXME wallet and spend calls must take salt
				to prevent reusing the same nondeterministic call
				where its not supposed to be reused.
				It must be reused sometimes
				such as if a forest of S calls uses it,
				but other times a forest of S calls
				means to use a different cache.
				Therefore somehow, user-level-code has to
				choose the salt, OR maybe the salt should be
				Time.timeId() and only allow calling the same thing
				once per video frame?
				Could put the salt in fn.COMMENT of wallet or spend call,
				but that doesnt really help in choosing the salt.
				This is a paradox that needs more thought
				and how the possible solutions of this might be
				related to salting by time in mutableWrapperLambda.
				I could make a nondet call to give a random salt,
				but that just pushes the problem back of
				you still need to either never cache that call
				or give it a salt before it can give you a different
				salt than the last time it gave you one.
				I can generate secure random numbers deterministicly,
				but thats not the problem.
				Maybe I should just let them reuse the cache if they're
				not careful to generate a different pseudorandom salt.
				...
				Or maybe I should use total amount of gas (Gas.top+storeGas)
				as the salt?
				Gas.top+storeGas decreases with every calculation
				and is only refilled at often as cache is cleared
				(other than it doesnt clear the parts that
				contain custom Compiled objects and everything reachable from them).
				I could also generate a random salt to prefix to (Gas.top+storeGas).
				...
				XXSOLUTION: salt is
				cbt thats concat of (randomNumberThatChangesOncePerCacheClear,doubleToRawCbt(Gas.top+sumOfAll(storeGas))))
				(and if solving the caching across multiple computers also
				prefix that with a random number thats unique to each computer
				or just replace Time.timeId() with a random number but give it
				more digits and cbt has to be a powOf2Size,
				and add an extra param in all nondet calls or in CallAsKey.java
				..
				No its not solved yet, but getting closer.
				..
				Problem is even using totalGas as salt,
				(plus (wallet leaf) 3)
				must be able to give a different result than
				(plus (wallet leaf) 3) called a different time,
				so the (wallet leaf) doesnt get called again.
				It just looks up (plus (wallet leaf)) and adds it to 3.
				(plus (wallet leaf)) would be cached.
				But I still need to use the same result of (plus (wallet leaf) 3)
				if its in (* (plus (wallet leaf) 3) (plus (wallet leaf) 3))
				meaning to square it. Or maybe it would be ok to differ there
				and I should just make the user level code put the salt in
				instead of leaf and generate salt deterministicly,
				but that would require passing in an extra func
				to EVERYTHING, compared to everything as it is now
				only takes 1 param it would have to take 2 so thats
				a huge slowdown.
				...
				Maybe there should be a func that Cache.java
				NEVER caches, and it only takes 1 param and ignores it,
				and it returns a random number,
				and the wallet and spend calls would somehow
				call it and not cache that or anything that has pointer to that
				but cache what it returns,
				So it needs a change to Cache.java.
				And to get the pointer to the thing
				(which nothing can be cached which can reach that thing)
				I'd need a func that always returns that thing
				BUT which doesnt have a pointer to that thing.
				For example if the thing that cant be cached is (x y)
				then (lazig x y) doesnt contain (x y) but (lazig x y anything)
				returns (x y).
				Yes, do something like that. Details to work out.
				...
				SOLUTION??? Cache.java will not create CallAsKey where
				its L is (nondet nondet nondet).
				(nondet nondet nondet aCbt) returns aCbt of same size
				and strongRandom bits.
				Use those strongRandom bits as salt in calls of
				wallet and spend,
				such as (lazig (nondet nondet nondet) aCbtSize128)
				gives the random bits when called on leaf.
				OR...
				maybe need to prevent caching the (nondet nondet nondet)
				also, not just things that have it as their L,
				so if it has (nondet nondet) or (nondet nondet nondet) as its L?
				...
				Best solution I have as of 2020-1-26-6a:
				Wallet and Spend must each take a salt param,
				and if the same salt is used multiple times
				before clearing the cache (which most of gets cleared
				once per video frame, except whats on harddrive etc)
				then it gives same answer as before,
				so be careful about that.
				Where that salt comes from is the question,
				such as could have a number that starts as a constant
				and branches to 2 (or more) different next possible numbers
				and that would be part of user level code,
				so recursively limiting compute resources
				is more expensive than I thought but not impractically expensive,
				and its less reliable to guarantee its nondeterministic
				than I thought vs you might use the same salt multiple times
				and get the same cached answer.
				Maybe it should go in comment branch or an extra curry param
				in many funcs, but only where wallet or spend might
				be used below?
				...
				It is decided, at least until I find a better solution
				but probably never will find a better solution, decided that:
				(curry cbtUnary constraint funcbody optionalSaltElseLeaf_forNondet params...)
				and cccc().f(nondet.f("limitComputeResources").f("spend"))
				.f(saltElseLeaf_forNondet).f(maxSpend).f(doIfEnoughWallet).f(elseDo)
				and nondet.f("limitComputeResources").f("wallet").f(saltElseLeaf_forNondet)
				but since saltElseLeaf_forNondet doesnt require any changes to
				the curry op, only to params of nondet (wallet and spend etc),
				this will only be recommended in the comment of curry op,
				and it maybe will in some ways of using the system
				automatically pass the salt param from each curry to child curry(s)
				each with a different transform, optionally.
				*/
				
				String instanceS = str(instance);
				if(instanceS.equals("wallet")){
					return w(Gas.top);
				}else if(instanceS.equals("spend")){
					fn madeByCurry = param;
					double storeGas = 0;
					fn elseDo = getp(7,madeByCurry);
					try{
						//param is only a madeByCurry if the nondet call
						//is wrapped in a curry so it can have more params,
						//such as ccc().f(nondet.f("limitComputeResources").f("spend"))
						//	.f(salt).f(maxSpend).f(doIfEnoughWallet).f(elseDo)
						
						//ignore salt at getp(4,madeByCurry) here,
						//but Cache.java wont ignore it.
						double maxSpend = getp(5,madeByCurry).R().doubleAt(0);
						double haveGas = Gas.top;
						maxSpend = Math.min(Math.max(0,maxSpend), haveGas); //TODO a little less than that?
						storeGas = haveGas-maxSpend;
						Gas.top = maxSpend;
						fn doIfEnoughWallet = getp(6,madeByCurry);
						fn ret = doIfEnoughWallet.f(leaf); //doIfEnoughWallet is often a lazig
						Gas.top += storeGas;
						lg("spend.try finished Gas.top += "+storeGas+", total "+Gas.top);
						return ret;
					}catch(Gas g){
						Gas.top += storeGas;
						lg("spend.else starting, Gas.top += "+storeGas+", total "+Gas.top);
						//catch Gas.instance, for efficienjcy without filling
						//in stacktrace reuses same Gas throwable every time.
						return elseDo.f(leaf); //elseDo is often a lazig
					}
				}
			}
			//If more possible behaviors are added later in Op.nondet,
			//this is considered compatible but infinitely inefficient.
			return infLoop();
		}
		
		/*throw new Error("FIXME move 'ocfnplug' to type, and the string after it to 'instance'");
		/*$();
		if(Gas.forceDeterminism){
			return infLoop();
			//throw new Error("if its InfloopIf then return leaf (still deterministic cuz that op always either infloops or returns leaf),"
			//	+" else infloop (so its like whatever it was going to do, such as Wallet or Spend, was just infinitely inefficient but didnt change its behaviors).");
		}else{
			
			if(a.isBitstring()){
				String s = str(a);
				if(s.equals("spend:")){
					throw new Error("TODO");
				}else if(s.equals("spendIf:")){ //in a way, is deterministic if it has enough, since it doesnt ask how much, only infloops if it doesnt have enough, and you can run from an earlier state until this doesnt infloop.
					throw new Error("TODO");
				}else if(s.equals("wallet:")){
					throw new Error("TODO");
				}else if(s.startsWith("ocfnplug:")){
					//TODO optimize by Map<fn,Method> caching these
					//(will that interfere with java garbcol or occamsfuncer garbcol?)
					//package.a.b.class.ocfnplugFuncName(fn) returns fn
					String funcName = s.substring("ocfnplug:".length());
					int i = funcName.lastIndexOf('.');
					if(i == -1) throw new Error("no dot in "+funcName);
					String lastPartOfFuncName = funcName.substring(i+1);
					String className = funcName.substring(0,i);
					try{
						Class c = Class.forName(className);
						Method m = c.getMethod(lastPartOfFuncName,fn.class);
						if(m.getReturnType() != fn.class) throw new Error("java Method doesnt return "+fn.class+" type");
						if(!Modifier.isStatic(m.getModifiers())) throw new Error("java Method isnt static: "+s);
						//Dont curry like this cuz if you want it in a curry you put that outside the nondet call.
						//fn madeByCurry = lazyEval.f( curry.f(unary(5)).f(T).f(nondet).f(a) ).f( b );
						//return (fn) m.invoke(null,madeByCurry);
						return (fn) m.invoke(null,b);
					}catch(ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
						throw new Error(s,e);
					}
					
					//get java.lang.reflect.Method and verify it takes exactly 1 fn param and returns fn.
					//Dont verify it obeys $(...) and other Gas limits
					//but do say thats required in the occamsfuncer spec
					//as any func whose name starts with "ocfnplug"
					//is considered part of the VM.
					//TODO
				}
			}
			
			//dont contradict what future things might do,
			//just pretend its infinitely inefficient.
			return infLoop();
			
			
			
			
			//TODO create ocfnplug func to help me test op.recur.
			//This func will be called ocfnplugEqq and simply does java == of 2 params and returns T or F
			//so I dont have to get Example.equals() working yet.
			//Test ocfnplugEqq first.
			//(nondet <ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq> S S) should return T.
			//While I plan to use other javaclasses than Call.java for cbtBitstrings LATER,
			//for now I will do it the slow way by building the cbt for a wrapped string (in utf8)
			//in ImportStatic.f(Object) aka wrap that object,
			//so wrap "ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq" in utf8
			//which will have a cbt1 appended then cbt0s until the next higher powOf2 size,
			//and use that as the way to automatically call immutableexceptgas.occamsfuncer.Example.ocfnplugEqq(fn,fn)
			//or maybe it should take a madebycurry datastruct as 1 fn aka
			//(lazyEval (curry ... a) b) where a and b are the 2 params to check if they ==.
			//...
			//UPDATE: can only have 1 param of ocfnplugEqq so it will be madebycurry.
			//cc is Example.cc().
			//(cc (nondet <ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq>) S S)
			//should return T cuz S==S.
			//(cc (nondet <ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq>))#eqq
			//(eqq S S)
			
		}*/
		
		//FIXME implement Wallet Spend InfloopIf
		//ocfnplug:package...class.func,
		//all as type:content is first param.
		
		
		/*Or maybe I dont need a plugin system since the following
		would be enough: the few wallet related ops (Wallet Spend InfloopIf)
		and static funcs whose name starts with ocfnplug.
		
		Yes, do that, and make it all be type:content
		such as "image/jpeg:...bytesOfJpgFile..."
		and such as "ocfnplug:package.a.b.name.func"
		for funcs that take 1 fn as param and return a fn.
		YES DO THAT,
		and call the example ocfnplug java func from older fokr of occamsfuncer,
		and later hook in neuralnet stuff,
		and later than that implement neuralnets using the deterministic ops.
		*/
	}
	
	/** This is the implementation of Op.nondetInfloopIf
	and is where constraints go. Throws by infLoop() or returns leaf.
	<br><br>
	
	*
	public static BinaryOperator<fn> nondetInfloopIf = (fn L, fn R)->{
		$();
		//TODO implement that
		//"and another op (TODO name it) that infloops only if\r\n" + 
		//"Gas.top is less than its param, so as long as\r\n" + 
		//"theres enough gas its considered deterministic"
		return leaf;
	};
	
	/** This is the implementation of Op.nondetGet. *
	public static BinaryOperator<fn> nondetGet = (fn L, fn R)->{
		$();
		//TODO implement Spend and Wallet here
		return infLoop();
	};*/

}
