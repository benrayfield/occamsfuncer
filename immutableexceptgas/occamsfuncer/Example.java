package immutableexceptgas.occamsfuncer;
import static immutableexceptgas.occamsfuncer.ImportStatic.*;

/** This is NOT part of the occamsfuncer spec since all these
could be derived using the simpler ops (at most height4)
without writing any java code.
<br><br>
Examples of things you could derive at user level
from the leaf aka the universal function,
without any java code, but since I'm still building the system
I'm going to call those combos using java.
*/
public class Example{
	private Example(){}
	
	TODO put BinaryOperator<fn> in some of these.
	
	private static fn cons;
	public static fn cons(){
		if(cons == null){
			TODO
		}
		return cons;
	}
	
	private static fn car;
	public static fn car(){
		if(car == null){
			TODO
		}
		return car;
	}
	
	private static fn cdr;
	public static fn cdr(){
		if(cdr == null){
			TODO
		}
		return cdr;
	}
	
	private static fn nil;
	public static fn nil(){
		if(nil == null){
			TODO
		}
		return nil;
	}
	
	private static fn isNil;
	public static fn isNil(){
		if(isNil == null){
			TODO
		}
		return isNil;
	}
	
	/** more general than rule110 as it can do all 256 elementaryCellularAutomata
	Takes a size 8 cbt bitstring as param (or TODO should it be a cbt of 8 cbtLeafs?)
	*/
	private static fn elementaryCellularAutomataRecur;
	public static fn elementaryCellularAutomataRecur(){
		if(elementaryCellularAutomataRecur == null){
			TODO
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
			TODO derive from elementaryCellularAutomataRecur
		}
		return rule110Recur;
	}
	
	/** depending on param can generate any possible turingMachine and step through its states,
	representing it in cbt(s) bitstring(s) maybe 2 of them or maybe 1 with an index.
	*/
	private static fn turingMachine;
	public static fn turingMachine(){
		if(turingMachine == null){
			TODO
		}
		return turingMachine;
	}
	
	private static fn mapPut;
	public static fn mapPut(){
		if(mapPut == null){
			TODO
		}
		return mapPut;
	}
	
	private static fn mapPair;
	public static fn mapPair(){
		if(mapPair == null){
			fn unary7 = cbtAsUnary(7);
			//func that infloops if parent's fields dont fit with both child's fields together
			fn mapPairConstraint = TODO;
			//func that does GET
			fn mapPairFuncBody = TODO;
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
		}
		return mapPair;
	}
	
	/** curry 2 cbt bitstrings each of size 64, return 1 of those */
	private static fn doubleMult;
	public static fn doubleMult(){
		if(doubleMult == null){
			TODO
		}
		return doubleMult;
	}
	
	/** curry 2 cbt bitstrings each of size 64, return 1 of those */
	private static fn doubleAdd;
	public static fn doubleAdd(){
		if(doubleAdd == null){
			TODO
		}
		return doubleAdd;
	}
	
	/** curry 2 cbt bitstrings each of size 32, return 1 of those */
	private static fn floatAdd;
	public static fn floatAdd(){
		if(floatAdd == null){
			TODO
		}
		return floatAdd;
	}
	
	/** see Opcode.acyclicFlow and .acyclicFlowN in other fork of occamsfuncer.
	This is where to hook in the int[] acyclicFlow music tool optimization.
	*/
	private static fn acyclicFlow;
	public static fn acyclicFlow(){
		if(acyclicFlow == null){
			TODO
		}
		return acyclicFlow;
	}
	
	/** see Opcode.acyclicFlow and .acyclicFlowN in other fork of occamsfuncer.
	This is where to hook in the int[] acyclicFlow music tool optimization.
	*/
	private static fn acyclicFlowN;
	public static fn acyclicFlowN(){
		if(acyclicFlowN == null){
			TODO
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
			TODO
		}
		return ed25519sha512;
	}
	
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
			TODO
		}
		return numCrunch;
	}
	
	TODO ops for the loop optimizations that avoid directly
	calculating maps but abstractly represent looping vars etc
	as puts of maps, and if/else that works with those,
	and progn-like ops (the p(...) syntax), etc.

}
