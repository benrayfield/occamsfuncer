/** Ben F Rayfield offers this software opensource MIT license */
package mutable.doubleAssemblyVM;

public class DoubleAssemblyVM{
	private DoubleAssemblyVM(){}
	
	/*TODO very important
	I want a variant of this called DoubleAndFnAssemblyVM
	whose state also includes a Mut (stateful view of stateless fn)
	and 1 or more of the whichFuncs is to copy into it (as param)
	a double array of any chosen cbtBitstring size
	and to copy out of it a cbtBitstring (if its not NaN etc but
	will figure out how to optimize for that later)
	but this fnCall op must act ONLY within specified ranges
	so regardless of if the cbt (or noncbt) it returns
	is bigger (ignore if noncbt) than the allowed output range,
	it will only copy within that allowed output range.
	Like the 5 actions which can generate any fn,
	those actions being [tapeLeft tapeRight get put call],
	a cbt could be viewed as choosing between those actions
	or different set of possible actions to navigate
	the current Mut to grab 2 fns to call on eachother
	and replace the "turingmachine state" with that,
	the turingmachineState being both the tape and 1 register
	and being a 5-way tree of possible actions,
	or other possible model of computing represntable
	as a Mut.
	...
	The purpose of this is to let DoubleAssemblyVM
	call more efficient models such as copying a range of double[]
	into a fn which calls OpenCL or int[]_and_double[] acyclicFlow
	or which does anything that fns can do better than this DoubleAssemblyVM.
	...
	I'm also considering the 32 registers each having a fn part
	or the first 64k indexs each having a fn part
	like in the (double,double)->double ops within those first 64k addresses,
	but probably its best to keep it to 1 fn state and let the fn itself
	handle the addressing and state transitions of the fn side
	based on sending in cbts containing double[] copied from ranges.
	
	todo port sparsedoppler to this,
	and if its too slow then change from long[] to double[]
	and still just use it cast to int for addresses.
	
	include sigmoid, sine, cosine, hypot, etc ambiguous double and float ops
	BUT mark them as ambiguous.
	allow those in the implementation of sparsedoppler.
	also the difference between the Float.*raw* Double.*raw* bits
	vs normed bits.
	*/
	
	
	/** at most 6 bits, maybe less. second highest bit of byte is !isIntIntToIntOp,
	and highest bit tells to jump or not aka copy z to instructionPtr at end.
	*/
	public static final byte
		noOp = 0,
		const0 = 1, //write it in z
		const1 = 2, //write it in z
		getMemMask = 3, //write it in z
		intPlus = 4,
		intMult = 5,
		doublePlus = 6,
		doubleMult = 7,
		and = 8,
		or = 9,
		xor = 10,
		not = 11,
		nand = 12,
		nor = 13,
		shift = 14,
		rotateBits = 15,
		copy = 16,
		copy16BitsFromOpcode = 61,
		copyRange = 62,
		halt = 63;
	
	//TODO should there be input and output
	//by IntSupplier and IntConsumer? Or do that directly in mem[]?
	//If not directly in mem[] then need opcode (in range 32..63) for it.
			
	
	
	/** register.length==32. mem.length is a powOf2.
	register[0] is instructionPtr.
	The other 31 registers all do the same thing as eachother.
	Each opcode is 32 bits.
	There will be opcodes for copying ranges in the int[] mem.
	whichFunc is the low byte in each opcode.
	If a certain bit in whichFunc is 1 vs 0,
	that tells if its an (int,int)->int op between 3
	registers other than instructionPtr
	and instructionPtr is always one of 4 registers used at a time.
	There is a bit in whichFunc that tells if at the end of the op
	the ->int should also be copied over instructionPtr.
	If isIntIntToIntOp then 3 registers other than instructionPtr
	are named, and for each there are 3 extra bits.
	int memMask = mem.length-1;
	One of those bits tells if its register[n] or mem[register[n]&memMask]
	The other 2 bits tell if should increment, decrement, or leave as it is,
	the either register[n] or mem[register[n]&memMask].
	Any of the 31 non-instructionPtr registers can be used
	like ptr to top of a stack or for streaming or other general uses.
	Stacks are not in well defined ranges so be careful.
	There will be an op to copy the high 16 bits of an op
	(where !isIntIntToIntOp) to a register named by a byte,
	after sliding up the value of that register by 16,
	so it takes 2 opcodes to put a literal int value in
	any register other than instructionPtr,
	or more efficiently you can use a copy op from a register
	other than instructionPtr, but its important for an instruction
	to be able to contain literal data.
	<br><br>
	returns number of steps unused;
	*
	public static int run(int[] register, int[] mem, int stepsRemaining){
		int memMask = mem.length-1;
		if(register.length != 32 || (mem.length&memMask)!=0)
			throw new Error("wrong sizes");
		while(stepsRemaining-- > 0){
			//FIXME count 1 step per 16 ints copied in range copy
			int instruction = mem[register[0]&memMask];
			boolean jump = (instruction&128)!=0; //copy ->int (at third register named) to register[0] if true, at end of op
			boolean isIntIntToIntOp = (instruction&64)!=0;
			byte addToXOrAddToWhatXPointsAt = TODO;
			byte addToYOrAddToWhatYPointsAt = TODO;
			byte addToZOrAddToWhatZPointsAt = TODO;
			boolean xIsWhatRegisterPointsAt = TODO;
			boolean yIsWhatRegisterPointsAt = TODO;
			boolean zIsWhatRegisterPointsAt = TODO;
			int xIsWhichRegister = 0;
			int yIsWhichRegister = 0;
			int zIsWhichRegister = 0;
			int x = 0, y = 0, z = 0;
			byte whichFunc = (byte)(instruction&63);
			if(isIntIntToIntOp){
				xIsWhichRegister = (instruction>>>8)&31;
				xIsWhatRegisterPointsAt = ((instruction>>>(8+5))&1)!=0;
				addToXOrAddToWhatXPointsAt = (byte)((instruction>>>(8+6))&3);
				x = register[xIsWhichRegister];
				if(xIsWhatRegisterPointsAt) x = mem[x&memMask];
				
				Do same for y and z
				
				switch(whichFunc){
					case plus:
						z = x+y;
					break;
					case mult:
						z = x*y;
					break;
					default:
				}
			}else{
				switch(whichFunc){
					case copy16BitsFromOpcode:
						TODO copy from high 16 bits of mem[instruction&memMask]
						to low 16 bits of z, after sliding z up by 16 bits.
					break;
					case copyRange:
						TODO use System.arraycopy and subtract range size
						divided by 16 (round up) minus 1, from stepsRemaining,
						and make sure to bound it within &memMask.
					break;
					case halt:
						return stepsRemaining;
					break;
					default:
				}
			}
			add addToXOrAddToWhatXPointsAt to registers or mem[register].
			if(isIntIntToIntOp){
				if(zIsWhatRegisterPointsAt){
					mem[zIsWhichRegister&memMask] = z;
				}else{
					TODO
				}
			}
			register[0] = (register[0]+1)&memMask;
			if(jump) register[0] = z&memMask;
		}
	}*/
	public static double run(double[] register, double[] mem, double stepsRemaining){
		//double can only hold all the integer values densely between plus/minus 2^53
		//so would not be able to reliably subtract 1 to get a different number if more.
		stepsRemaining = Math.min(stepsRemaining, Math.pow(2, 53));

		
		/*
		TODO double and long and float and int ieee754 ops
		such as multiply and plus and negate and cast,
		but none of the ambiguous ops such as exp or sine
		as those need to be derived from unambiguous ops plus multiply etc.
		use the "raw" efficient int-float long-double transforms?
		or at least have option for that.
		
		each modelsofcomputing.registers32ints opcode touches at most 4 registers,
		1 of which is always instructionPtr. Make sure none of those 3 overlap eachother
		and none of those 3 equal instructionPtr.
		Maybe instructionPtr should be a separate int[1] and have int[32] other registers?
		...
		put float and double ops in, where double ops such as double*double use the 4 ints
		at mem[register[n..(n-3)] or 2 registers each 2 ints at them.
		...
		Put int12.int12.int8 acyclicFlow ops in (so i dont have to lose speed for those),
		and maybe also int8.int8.int8.int8 ops for low 256 ints of mem.
		but those are normally double ops. could still use it that way. low 512 or 8192 ints.
		UPDATE: int16.int16.int16.int8? Or 2 of int12.int12.int8 per long? 
		..
		put in an opcode to make a sandboxedSystemCall
		such as to call a forest of forestops defined entirely in the int[] mem
		such as a range of mem[] that has int ptrs to the forestops to do in a sequence in opencl,
		or maybe to interact with the user or other IO,
		but try to keep it stateless so avoid IO and let io be handled by occamsfuncer.mutableWrapperLambda
		which occurs between calls of large blocks of this kind of int[] computing.
		Allow double[] optimization of some parts of the int[] especially for music ops.
		...
		Start using occamsfuncer for everything I do, if I can.
		...
		Use occamsfuncer fn objects to organize the medium efficiency calls of int[]
		which organize GPU computing, but still the int[] will be slow for graphics
		but still alot faster than occamsfuncer fn objects,
		such as int[] computing might be able to do an indexOf search by bruteforce
		of 10 mB/sec, compared to in manually optimized code could search 300 mB/sec.
		...
		Still, its enough for people to build simple mmg games together.
		Occamsfuncer will expand beyond music tools cuz of this.
		Remember, the int[] mem and int[32] registers are viewable as cbt.
		...
		(((probably not, but possibly... Also, ???? hardware, such as FPGA, could later be designed specificly for this kind of int[] computing
		and could do it as fast as normal computers, or maybe even faster as its VERY threadable.
		It would have no problem with using 64k cpus together, if the memory hardware could support it,
		though might want to redesign it for 64 bits at a time instead of 32 in that case for larger
		memory space and opcodes that can refer to other cpus and gpus etc.
		But far sooner (if that ever happens) I expect this model of computing
		to be a useful optimization of occamsfuncerV2's universalLambdaFunction,
		accessed through cbts of various powOf2 sizes paired with a cbt of size 32registers*32bitsPerInt.
		)))
		...
		https://www.reddit.com/r/FPGA/comments/evc335/what_memory_topologies_are_available_for_fpgas/
		...
		https://www.reddit.com/r/compsci/comments/evcgcd/what_would_make_a_good_spec_for_defining_specs_in/
		*/
		
		final int memMask = mem.length-1;
		final int mask2 = 0xffff&memMask;
		if(register.length != 32 || (mem.length&memMask)!=0)
			throw new Error("wrong sizes");
		final int regsAtOnceOtherThanInstructionPtr = 3;
		final byte[] addToRegOrAddToWhatRegPointsAt = new byte[regsAtOnceOtherThanInstructionPtr];
		final boolean[] isWhatRegPointsAt = new boolean[regsAtOnceOtherThanInstructionPtr];
		final int[] whichRegister = new int[regsAtOnceOtherThanInstructionPtr];
		final double[] val = new double[regsAtOnceOtherThanInstructionPtr];
		while(stepsRemaining-- > 0){
			
			/*I want to use a uint53 as an instruction
			in cases when instruction is bigger than
			a certain value such as maybe > 2^48+1 or 2^32.
			This will be a much faster op thats more like acyclicFlow.
			Its int16.int16.int16.int5
			where the int5 is the low 5 bits of whichFunc
			which means it can only do the isIntIntToIntOp kinds,
			and the 3 addresses it does that between are in the int16s.
			It never affects any register other than instructionPtr
			which as usual increments forward.
			This gives you 64k doubles to do (double,double)->double
			ops from any 2 to any 1.
			So instruction should be long instead of int,
			but as soon as find it fits in int,
			do the normal process below instead of this acyclicFlow-like
			faster process on the uint53 in the long.
			I imagine a 2 ghz computer doing
			100k occamsfuncer ops per second,
			5million of the slower ops below per second,
			and 50million of these ops per second,
			though those are just guesses as the system
			hasnt scaled up yet,
			and when using GPU it gets the same speed as the GPU
			and can do about 1500 opencl kernel calls per second
			but they get inefficient if you do more than
			100 calls from java to opencl back to java per second
			so multiple kernel calls in CLQueue before returning to java.
			Some of those things have nothing to do with this doubleAssemblyVM
			but I'm saying it to put it into context when you should
			use this vs the other things occamsfuncer can be compiled to.
			*/
			
			final long instructionBig = (long)mem[((int)register[0])&memMask];
			if(instructionBig > Integer.MAX_VALUE){ //or should it be >=2^32?
				final byte whichFunc = (byte)(instructionBig&32);
				//FIXME use sign bit as int54 so int6.int16.int16.int16,
				//but make sure those high int16s are never 0 so this IF we are in
				//its condition happens. Is there a better way?
				final int addrA = ((int)(instructionBig>>>5))&mask2;
				final int addrB = ((int)(instructionBig>>>21))&mask2;
				final int addrC = ((int)(instructionBig>>>37))&mask2;
				//TODO mem[addrC] = op(whichFunc,mem[addrA],[addrB]);
				if(1<2) throw new Error("TODO");
				register[0] = ((int)register[0]+1)&memMask;
				continue;
				
				//This will be fast enough as proven in
				//AcyclicFlowMusicOpcodes\src\immutable\acyclicflow\dense\TestSpeedOfDoubleOpcodes.java

			}
			/*Might not be fast enough. Do I want int12.int12.int5 in some range
			without modifying instructionPtr and just charge the stepsRemaining
			all at once for a range?
			
			Or maybe should actually copy it into an int[]
			and use that int[] parallel to the double[],
			where each such int[] is at most size 4096 since thats the max size
			that int12 can refer to.
			
			since whichFunc is 6 bits, could do int13.int13.int6 for int[8192].
			*/
			
			//FIXME count 1 step per 16 ints copied in range copy
			final int instruction = (int)instructionBig;
			final boolean jump = (instruction&128)!=0; //copy ->int (at third register named) to register[0] if true, at end of op
			
			
			
			
			
			
			
			
			
			
			
			//FIXME should isIntIntToIntOp be &32!=0 and those ops be just half of the 64 ops?
					
					
					
					
					
					
					
					
					
					
					
					
			final boolean isIntIntToIntOp = (instruction&64)!=0;
			/*byte addToXOrAddToWhatXPointsAt = TODO;
			byte addToYOrAddToWhatYPointsAt = TODO;
			byte addToZOrAddToWhatZPointsAt = TODO;
			boolean xIsWhatRegisterPointsAt = TODO;
			boolean yIsWhatRegisterPointsAt = TODO;
			boolean zIsWhatRegisterPointsAt = TODO;
			int xIsWhichRegister = 0;
			int yIsWhichRegister = 0;
			int zIsWhichRegister = 0;
			double x = 0, y = 0, z = 0;
			*/
			final byte whichFunc = (byte)(instruction&63);
			if(isIntIntToIntOp){
				for(int r=0; r<regsAtOnceOtherThanInstructionPtr; r++){
					final int rOffset = (r+1)<<3;
					whichRegister[r] = (instruction>>>rOffset)&31;
					isWhatRegPointsAt[r] = ((instruction>>>(rOffset+5))&1)!=0;
					//add an int2, normally is -1 or 0 or 1, like pop noop push or for streaming etc.
					addToRegOrAddToWhatRegPointsAt[r] = (byte)((instruction>>>(rOffset+6))&3);
					val[r] = register[whichRegister[r]];
					if(isWhatRegPointsAt[r]) val[r] = mem[((int)val[r])&memMask];
				}
				/*xIsWhichRegister = (instruction>>>8)&31;
				xIsWhatRegisterPointsAt = ((instruction>>>(8+5))&1)!=0;
				addToXOrAddToWhatXPointsAt = (byte)((instruction>>>(8+6))&3);
				x = register[xIsWhichRegister];
				if(xIsWhatRegisterPointsAt) x = mem[x&memMask];
				*
				Do same for y and z
				*/
				
				switch(whichFunc){
					case noOp:
						//doesnt modify here but still can add in int2 per register
						//andOr jump, depending on other bits in the instruction.
						//One of those possible instruction values does nothing at all.
					break;
					case intPlus:
						val[2] = (int)val[0]+(int)val[1];
					break;
					case intMult:
						val[2] = (int)val[0]*(int)val[1];
					break;
					case doublePlus:
						val[2] = val[0]+val[1];
					break;
					case doubleMult:
						val[2] = val[0]*val[1];
					break;
					case and:
						val[2] = (int)val[0]&(int)val[1];
					break;
					case or:
						val[2] = (int)val[0]|(int)val[1];
					break;
					case xor:
						val[2] = (int)val[0]^(int)val[1];
					break;
					case not:
						val[2] = ~(int)val[0];
					break;
					case nand:
						val[2] = ~((int)val[0]&(int)val[1]);
					break;
					case nor:
						val[2] = ~((int)val[0]|(int)val[1]);
					break;
					default:
				}
			}else{
				switch(whichFunc){
				
					case copy16BitsFromOpcode:
						/*FIXME copy16BitsFromOpcode will be just for the int value,
						but want another opcode for copying the double immediately following
						instructionPtr and jump instructionPtr over it,
						to quote a double value in 1 cycle.
						
						UPDATE: copy high 32 bits of long instead of high 16 bits of int,
						and rename copy16BitsFromOpcode to copy32BitsFromOpcode
						I want both ops the 16 and 32 kind,
						cuz that way have the option to use only 32 bit ops.
						
						TODO copy from high 16 bits of mem[instruction&memMask]
						to low 16 bits of z, after sliding z up by 16 bits.
						*/
						if(1<2) throw new Error("TODO");
					break;
					case copyRange:
						/*TODO use System.arraycopy and subtract range size
						divided by 16 (round up) minus 1, from stepsRemaining,
						and make sure to bound it within &memMask.
						*/
						if(1<2) throw new Error("TODO");
					break;
					case halt:
						return stepsRemaining;
					//break;
					default:
				}
			}
			//add addToXOrAddToWhatXPointsAt to registers or mem[register].
			if(1<2) throw new Error("TODO");
			if(isIntIntToIntOp){
				/*if(zIsWhatRegisterPointsAt){
					mem[zIsWhichRegister&memMask] = z;
				}else{
					throw new Error("TODO");
				}*/
				throw new Error("TODO");
			}
			register[0] = ((int)register[0]+1)&memMask;
			if(jump) register[0] = ((int)val[2])&memMask;
		}
		return stepsRemaining;
	}

}	