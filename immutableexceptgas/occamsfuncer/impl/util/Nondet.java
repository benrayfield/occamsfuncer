package immutableexceptgas.occamsfuncer.impl.util;
import static immutableexceptgas.occamsfuncer.impl.util.ImportStatic.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.BinaryOperator;

import immutableexceptgas.occamsfuncer.fn;

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

	
	public static fn nondet(fn a, fn b){
		$();
		if(Gas.forceDeterminism){
			throw new Error("if its InfloopIf then return leaf (still deterministic cuz that op always either infloops or returns leaf),"
				+" else infloop (so its like whatever it was going to do, such as Wallet or Spend, was just infinitely inefficient but didnt change its behaviors).");
		}else{
			if(a.isBitstring()){
				String s = str(a);
				if(s.startsWith("ocfnplug:")){
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
					
					/*get java.lang.reflect.Method and verify it takes exactly 1 fn param and returns fn.
					Dont verify it obeys $(...) and other Gas limits
					but do say thats required in the occamsfuncer spec
					as any func whose name starts with "ocfnplug"
					is considered part of the VM.
					TODO
					*/
				}
			}
			
			//dont contradict what future things might do,
			//just pretend its infinitely inefficient.
			return infLoop();
			
			/*TODO create ocfnplug func to help me test op.recur.
			This func will be called ocfnplugEqq and simply does java == of 2 params and returns T or F
			so I dont have to get Example.equals() working yet.
			Test ocfnplugEqq first.
			(nondet <ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq> S S) should return T.
			While I plan to use other javaclasses than Call.java for cbtBitstrings LATER,
			for now I will do it the slow way by building the cbt for a wrapped string (in utf8)
			in ImportStatic.f(Object) aka wrap that object,
			so wrap "ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq" in utf8
			which will have a cbt1 appended then cbt0s until the next higher powOf2 size,
			and use that as the way to automatically call immutableexceptgas.occamsfuncer.Example.ocfnplugEqq(fn,fn)
			or maybe it should take a madebycurry datastruct as 1 fn aka
			(lazyEval (curry ... a) b) where a and b are the 2 params to check if they ==.
			...
			UPDATE: can only have 1 param of ocfnplugEqq so it will be madebycurry.
			cc is Example.cc().
			(cc (nondet <ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq>) S S)
			should return T cuz S==S.
			(cc (nondet <ocfnplug:immutableexceptgas.occamsfuncer.Example.ocfnplugEqq>))#eqq
			(eqq S S)
			*/
		}
		
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
