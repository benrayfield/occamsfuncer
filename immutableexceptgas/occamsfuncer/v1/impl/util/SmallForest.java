/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.v1.impl.util;

/** This is a data format for sending things through network
or storing on harddrive etc,
and does not include a definition of which hash algorithm,
as that should be specified less frequently and in combo
with multiple of these.
<br><br>
Each int's low 2 bits choose between 4 things:
cbt bits as id, cbt bits as literal, left of call pair, right of call pair.
The next 30 bits choose the size in bits of that id or cbt literal,
where the last int in it has 0-31 unused bits,
or choose the int index where the thing they point at starts.
*/
public class SmallForest{
	
	public final int[] data;
	
	public SmallForest(int[] data){
		this.data = data;
	}
	
	public int root(){
		throw new Error("TODO");
	}
	
	public int L(int ptr){ 
		/*TODO
		TODO error checking for if its a cbt, which does have L and R
		but cant be represented in this SmallForest.
		Even if the cbt is a literal, which tells us exactly the binForest shape
		down to theLeaf, these ints arent able to represent anything
		below a cbt literal or cbt id. For that, import (and verify at same time)
		it into a system which can represent those things.
		*/
		throw new Error("TODO");
	}
	
	public int R(int ptr){
		throw new Error("TODO");
	}
	
	/** If the data at ptr (*ptr) is a ptr,
	then its a single int pointing at another int,
	else its cbt, then its either the bitstring of an id or a literal. */
	public boolean isPtr(int ptr){
		throw new Error("TODO");
	}
	
	/** not including the int header or the 0-31 bits unused of the last int.
	If ptr is a cbt (either as id or literal) then its bit size is data[int]>>>2,
	but TODO error checking?
	*/
	public int cbtBitSize(int ptr){
		throw new Error("TODO");
	}
	

}
