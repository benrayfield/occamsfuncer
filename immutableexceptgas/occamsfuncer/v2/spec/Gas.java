/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.v2.spec;

public class Gas extends RuntimeException{
	private Gas(){}
	
	/** Think of this as simulating free market trading
	between memory and compute cycles.
	Compute cycles are paid in units of Gas.top.
	TODO Allocation of memory is paid in units of Gas.top*Gas.memToComRatio.
	(but not necessarily freeing since instead you might just get
	more Gas.top available 30 times per second depending
	how much memory is available)
	TODO adjust Gas.memToComRatio by how much memory is available,
	either by counting it per object in occamsfuncerVM
	(but overriding Object.finalize is expensive)
	or by Runtime.getRuntime().freeMemory()
	(probably faster on average but laggier?).
	...
	When memory gets low, this changes so memory costs more.
	When memory is freed, it changes back.'
	Its not trading since theres only 1 process
	...
	(could easily run in parallel if there were 1 of this etc per thread,
	but since its bottlnecked by IO I'm going with 1 CPU thread
	other than openCL parts use many GPU threads),
	...
	and whats being controlled by the gas and mem and com limits
	are how much compute resources deeper calls can use
	before returning to parent call and so on.
	FIXME this hasnt been hooked in as of 2019-10-11,
	but Gas.top (HaltingDictator.topWallet in other forks of occamsfuncer)
	has been in those other forks of occamsfuncer.
	*/
	public static float memToComRatio;
	
	/** If true, since last Cache.clear(), has not failed an Op.spend
	which would have diverted it to a catch cuz didnt have
	enough compute resources for the deterministic way,
	and has not done an Op.gas which nondeterministicly reads
	how much compute resources are left,
	but it can do Op.gasAtLeast since that takes the
	nondeterministic path if theres at least that much gas left,
	unless theres not then the nondeterministic path. 
	This becomes true after every call of Cache.clear().
	Deterministic calculations can be shared across Internet
	without sync problems,
	and the rest we will have to figure out as the system evolves
	but will probably end up being something only doable locally
	that leads to an object at the determinisstic level
	thats synced by ed25519 publicKeys to digsig arbitrary inputs
	paired with a double time and keep the newest object per publicKey.
	*/
	public static boolean deterministicSoFar = true;
	
	/** TODO Spend or some permission call changes this similar to Spend call.
	Only affects Op.nondet and anything that may lead to it being called.
	<br><br>
	(todo rewrite comment...)
	If false...
	allow Op.nondet to do nondeterministic things instead
	of always infiniteLooping (deterministic),
	which is a certain few calls of universalLambdaFunction.
	Its useful for limiting compute cycles and memory
	and calling plugins, if any.
	*/
	public static boolean forceDeterminism = false;
	
	/** At the start of any call, it c
	public static boolean sudo = true;
	
	
	/** Amount of compute resources available to this call and
	deeply things it calls. When that returns, whatever amount of
	resources the parent is saving are added back into this,
	as thats how the Spend call works.
	<br><br>
	accessed by $ funcs and wallet and spend calls.
	Wallet and spend calls are somewhere in Op.nondetGet.
	*/
	public static double top;
	
	/** instance field and instance() since it must start null cuz of some java limit (or java bug?) that wont let a throwable be static final in its own class */
	private static Gas instance;
	
	
	static{
		memToComRatio = 1;
		top = 1L<<53;
		/*Gas g = null;
		try{
			throw new Gas();
		}catch(Throwable t){
			g = (Gas)t;
		}*/
		//Gas g = new Gas();
		//instance = g;
	}
	
	public static Gas instance(){
		if(instance == null) instance = new Gas();
		return instance;
	}


}
