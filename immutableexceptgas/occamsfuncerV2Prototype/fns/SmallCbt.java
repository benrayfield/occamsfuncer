package immutableexceptgas.occamsfuncerV2Prototype.fns;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import immutableexceptgas.occamsfuncerV2Spec.Compiled;
import immutableexceptgas.occamsfuncerV2Spec.fn;

/** If height is 0, then data is either cbt0 or cbt1.
If height is 1, then its 2 bits. Height goes up to 6 for 64 bits.
cbtHeight is 4 more than fn height since cbt0 and cbt1 are
both at height 4.
*/
public class SmallCbt extends AbstractFn{
	
	public final byte height;
	
	public final long data;
	
	/** This is the most general constructor.
	You would need it for an int1, int2, or int4 since theres no primitives for that,
	or if called by ArrayCbt this would be more convenient.
	*/
	public SmallCbt(byte height, long data){
		this.height = height;
		this.data = data;
	}
	
	public SmallCbt(long data){
		this((byte)10, data); //height is cbt1.height()+log2(sizeof(long))
	}
	
	/** doubleToLongBits, not doubleToRawLongBits cuz must deterministic,
	unless this was used from inside Op.nondet it would be allowed
	but even then you would more likely use a DoubleCbt or FloatCbt
	since they only translate to bits if their descendants are observed.
	*/
	public SmallCbt(double data){
		this((byte)10, Double.doubleToLongBits(data));
	}
	
	/** floatToIntBits, not floatToRawIntBits as explained in SmallCbt(double) comment. */
	public SmallCbt(int data){
		this((byte)9, ((long)Float.floatToIntBits(data))<<32);
	}
	
	public SmallCbt(short data){
		this((byte)8, ((long)data)<<48);
	}
	
	public SmallCbt(char data){
		this((byte)8, ((long)data)<<48);
	}
	
	public SmallCbt(byte data){
		this((byte)7, ((long)data)<<56);
	}

	public fn f(fn param){
		throw new Error("TODO");
	}

	public fn fIgnoreConstraint(fn param){
		return f(param);
	}

	public fn L(){
		//height wont be 4 cuz cbt0 and cbt1 are Call instances.
		//FIXME should cbt0 and cbt1 be SmallCbt instances?
		if(height == 5){ //(00) or (01) or (10) or (11)
			return data<0 ? cbt1 : cbt0;
		}else{
			//return new SmallCbt(height-1, TODO shift etc);
			throw new Error("TODO");
		}
	}

	public fn R(){
		//height wont be 4 cuz cbt0 and cbt1 are Call instances.
		//FIXME should cbt0 and cbt1 be SmallCbt instances?
		if(height == 5){ //(00) or (01) or (10) or (11)
			return (data<<1)<0 ? cbt1 : cbt0;
		}else{
			//return new SmallCbt(height-1, TODO shift etc);
			throw new Error("TODO");
		}
	}

	public int cur(){
		throw new Error("TODO");
	}

	public fn curBig(){
		throw new Error("TODO");
	}

	public fn bh(int path){
		throw new Error("TODO binheap indexing is efficiently doable using height and (long)data");
	}

	public fn bhBig(fn path) {
		throw new Error("TODO");
	}

	public fn id(fn algorithm){
		throw new Error("TODO id of cbts up to 256 bits, or maybe 255 bits, would normally be literal in id, depending on which idFunc");
	}

	public Compiled compiled(){
		throw new Error("TODO");
	}

	public void setCompiled(Compiled c){
		throw new Error("TODO");
	}

	public boolean isCbt(){
		return true;
	}

	public boolean isBigCbt(){
		return false;
	}

	public long longAt(long cbtBitIndex){
		//FIXME can cbtBitIndex ever be negative?
		return data<<cbtBitIndex;
	}

	public long longAtBig(fn cbtBitIndex){
		throw new Error("TODO");
	}

	public int height(){
		return height;
	}

	public fn heightBig(){
		throw new Error("TODO");
	}

	public fn bitstringSizeBig(){
		throw new Error("TODO");
	}

	public fn op(){
		return data<0 ? cbt1 : cbt0; //optimization of bitAt(0)?cbt1:cbt0
	}

	public boolean isUnaryCbt(){
		int howManyBits = 1<<(height-4);
		long unaryCbt = (-1L)<<(64-howManyBits); //11111...0000
		return data==unaryCbt;
	}
	
	//for height 5 (cbtSize1) use cbt0 or cbt1.
	//Remember cbt is often interpreted as bitstring by ignoring the last cbt1,
	//but doesnt have to as it depends how fns use it, and all possible fns
	//are derivable to have any [mapping of param to return]
	//of finite kolmogorovComplexity/amountOfInformation,
	//but you cant derive a fn which can hide its internal binary forest shape
	//from Op.L and Op.R and Op.isLeaf, which makes it only a subset
	//of all possible lambda functions since, for example,
	//(lazyEval (S I I) (S I I)) is nonhalting for every possible param
	//but a fn which gets it as a param can build an emulator of it
	//and run it 1 step at a time without committing to run it until it ends,
	//which is a design constraint you cant have if you allow
	//all possible lambdas since one must call its param to detect
	//the behaviors of that param, so I consider this subset
	//of all possible lambdas (derivable from leaf aka a universal lambda)
	//to be a better model of computing. ((L x)(R x)) equals x for all x.

}


