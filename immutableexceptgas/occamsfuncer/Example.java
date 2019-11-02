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

}
