/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncerV2Spec;

public class Gas extends RuntimeException{
	
	/** Think of this as simulating free market trading
	between memory and compute cycles, both paid in units of Gas.top.
	When memory gets low, this changes so memory costs more.
	When memory is freed, it changes back.'
	Its not trading since theres only 1 process,
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
	*/
	public static boolean forceDeterminism = false;
	
	/** instance field and instance() since it must start null cuz of some java limit (or java bug?) that wont let a throwable be static final in its own class */
	private static Gas instance;
	
	/** accessed by $ funcs and wallet and spend calls.
	Wallet and spend calls are somewhere in Op.nondetGet.
	*/
	public static double top;
	
	
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
