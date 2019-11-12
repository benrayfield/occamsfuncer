package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;

import java.util.function.BinaryOperator;

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
		if(Gas.forceDeterminism){
			throw new Error("if its InfloopIf then return leaf (still deterministic cuz that op always either infloops or returns leaf),"
				+" else infloop (so its like whatever it was going to do, such as Wallet or Spend, was just infinitely inefficient but didnt change its behaviors).");
		}else{
			throw new Error("TODO");
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
