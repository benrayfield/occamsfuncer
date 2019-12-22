/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncerV1.impl.util;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import immutableexceptgas.occamsfuncerV1.*;

/** FIXME the counting below maybe is not in the right order.
Make sure its in order of height recursively by bruteForce finding
all 677 binary forest shapes up to level4,
then sort them by height recursively (like in acyc32 sort).
That is, if they equal then sort says equal,
else if one is shorter than the other then sort says the shorter one is first,
else compare by left child recursively, else compare by right child recursively,
and will only recurse into at most 1 of let or right child.
<br><br>
. (0)
Level0 has 1 binary forest shapes.
`.. (0)
Level1 has 2 binary forest shapes.
`.. (dup)
`.`.. (0)
``... (1)
``..`.. (2)
Level2 has 5 binary forest shapes.
`.. (dup)
`.`.. (dup)
`.`.`.. (0)
`.``... (1)
`.``..`.. (2)
``... (dup)
``..`.. (dup)
``..`.`.. (3)
``..``... (4)
``..``..`.. (5)
``.`... (6)
``.`..`.. (7)
``.`..`.`.. (8)
``.`..``... (9)
``.`..``..`.. (10)
```.... (11)
```...`.. (12)
```...`.`.. (13)
```...``... (14)
```...``..`.. (15)
```..`... (16)
```..`..`.. (17)
```..`..`.`.. (18)
```..`..``... (19)
```..`..``..`.. (20)
Level3 has 26 binary forest shapes.
Level4 has 677 binary forest shapes.
Level5 has 458330 binary forest shapes.
<br><br>
The number of nodes from depth 0 to n appears to be,
nodesAtDepth(n) = n==0 ? 1 : Math.pow(nodesAtDepth(n-1),2)+1;
<br><br>
All 16 opcodes are at depth4. See comment in Op.java for details.
<br><br>
0 <0>
Level0 has 1 binary forest shapes.
1(0,0) <0>
Level1 has 2 binary forest shapes.
1(0,0) <dup>
2(0,1(0,0)) <0>
2(1(0,0),0) <1>
2(1(0,0),1(0,0)) <2>
Level2 has 5 binary forest shapes.
1(0,0) <dup>
2(0,1(0,0)) <dup>
3(0,2(0,1(0,0))) <0>
3(0,2(1(0,0),0)) <1>
3(0,2(1(0,0),1(0,0))) <2>
2(1(0,0),0) <dup>
2(1(0,0),1(0,0)) <dup>
3(1(0,0),2(0,1(0,0))) <3>
3(1(0,0),2(1(0,0),0)) <4>
3(1(0,0),2(1(0,0),1(0,0))) <5>
3(2(0,1(0,0)),0) <6>
3(2(0,1(0,0)),1(0,0)) <7>
3(2(0,1(0,0)),2(0,1(0,0))) <8>
3(2(0,1(0,0)),2(1(0,0),0)) <9>
3(2(0,1(0,0)),2(1(0,0),1(0,0))) <10>
3(2(1(0,0),0),0) <11>
3(2(1(0,0),0),1(0,0)) <12>
3(2(1(0,0),0),2(0,1(0,0))) <13>
3(2(1(0,0),0),2(1(0,0),0)) <14>
3(2(1(0,0),0),2(1(0,0),1(0,0))) <15>
3(2(1(0,0),1(0,0)),0) <16>
3(2(1(0,0),1(0,0)),1(0,0)) <17>
3(2(1(0,0),1(0,0)),2(0,1(0,0))) <18>
3(2(1(0,0),1(0,0)),2(1(0,0),0)) <19>
3(2(1(0,0),1(0,0)),2(1(0,0),1(0,0))) <20>
Level3 has 26 binary forest shapes.
*/
public class Cache{
	
	private static final Map<CallAsKey,fn> funcParamReturn = new HashMap();
	
	public static fn[] allCachedFns(){
		Set<fn> set = new HashSet();
		for(Map.Entry<CallAsKey,fn> entry : funcParamReturn.entrySet()){
			CallAsKey cak = entry.getKey();
			set.add(cak.L);
			set.add(cak.R);
			set.add(entry.getValue());
		}
		return set.toArray(new fn[0]);
	}
	
	/*FIXME should it be dedup by <func,param>, using map of <func,param,return>?
	Also, each <func,param,return> needs a bit to say if its a <itsL,itsR,parent>
	vs if its a nontrivial call.
	*/
	
	/*public static fn dedup(fn f){
		throw new Error("TODO");
	}
	
	public static fn dedup(fn itsL, fn itsR){
		throw new Error("TODO");
	}*/
	
	/** null if not putFuncParamReturn yet */
	public static fn getRetOfFuncParamElseNull(fn func, fn param){
		return funcParamReturn.get(new CallAsKey(func,param));
	}
	
	public static void putLRParent(fn parent){
		funcParamReturn.put(new CallAsKey(parent), parent);
	}
	
	public static void putFuncParamReturn(fn func, fn param, fn ret){
		funcParamReturn.put(new CallAsKey(func,param), ret);
	}
	
	//FIXME this func was from another fork of occamsfuncer that had type:content leafs
	/** clear CacheFuncParamReturn and Dedup.
	This will normally be done once per video frame such as 40 times per second,
	but TODO some parts of the cache maybe should stay longer,
	like there will later be RBM and LSTM learning batches that take 1 second
	since they have to do as many opencl calls as unrollBackprop time cycles,
	using (opencl)ForestOp.java, so will have to upgrade the cache for that.
	*/
	public void clearPartial(){
		//TODO optimize? 2 maps for the 2 possible values of retIsThisPair
		//would avoid looping over those that wont be removed
		//but would slow down cache lookups cuz would have to get from 2 maps.
		//For now I just want the system to work and will optimize later.
		
		Iterator<Map.Entry<CallAsKey,fn>> iter = funcParamReturn.entrySet().iterator();
		while(iter.hasNext()){
			if(!iter.next().getKey().retIsThisPair) iter.remove();
		}
		//FIXME what to do about smallLeafs?
		//Probably should leave them (or at least whichever are still reachable)
		//since this is partial clear and should not clear anything that could
		//still be called in cache funcs. (FIXME is that circular logic?)
	}
	
	//FIXME this func was from another fork of occamsfuncer that had type:content leafs
	public void clear(){
		throw new Error("Cant clear where retIsThisPair unless dedup(...) calls itself recursively (and would end 1 level deep if already deduped but would still be slower). The other choice is to garbcol all fn objects and create them again, but thats impractical.");
		//clear all cache maps (will be 2 of them, 1 for <func,param,return> and 1 for leafs)
	}
	
	/*
	//TODO I might want RandomAccessFile ability?
	
	Can the 677 nodes (up to depth4) be implemented
	as a Compiled each? The 16 ops and 1 leaf will need manually written code
	but the others I'm undecided what they should do,
	maybe just keep currying or maybe should return themself
	except if certain params then keep currying.
	
	
	What needs to be cached in Call?
	bit that says dont garbcol this cuz its one of the top n.
	short 0..676.
	is it a cbt, and index of last cbt1 else is all cbt0s.
	id or maybe ImmutableLinkedListNode of idAlgorithm to id.
	Compiled or null.
	How to know which Compiled it is, maybe an int for switch optimizing,
		like how cons car cdr nil work together?
	Or maybe they can just check == for certain fns
	like car can check if its param is the cons which would be
	a curry.
	
	Since everything, except cbts, is getting deduped anyways,
	maybe we dont need a special system for the first 677 nodes,
	or at least not for now.
	
	I still need to verify they are in recursive depth order.
	It looks like recursive depth order in level3 from the comment in Cache.java.
	Can verify for certain later.
	
	Code the "new Call(x,y)" func
	in a way that guarantees dedup without hashtable lookup
	but just for up depth4 (depth0..3 to depth0..3 are x and y),
	and that works similarly for cbts.
	That could be done with a short in each fn
	and lookup in Cache.pair[][].
	Or could store that in the fns themselves.
	
	
	//Should cbts share array when L or R into half size array?
	//I need big array wrapped in cbt.
	
	/*FIXME is there a simple way of generating the recursiveHeightSort?
			
	Create comparator by height recursively and use it on adjacent pairs
	from 0 to 676.
	*/
	
	public static final short secondHighestN = nodes(3).shortValue();
	
	/** Nodes 0 to 676 are all in depth0 to depth4 and (TODO) are cached in order of height recursively */
	public static final short highestN = nodes(4).shortValue();
	
	/*private static final byte[] height;
	private static final short[] L, R;
	private static final short[][] pair;
	private static final fn[] f;
	static{
		height = new byte[highestN];
		//L of node 0 is identityFunc (1 of the opcodes at depth4)
		L = new short[highestN];
		//R of node0 is 0 (so ((L leaf)(R leaf)) is leaf.
		R = new short[highestN];
		pair = new short[secondHighestN][secondHighestN];
		f = new fn[highestN];
		throw new Error("TODO");

	}*/
	
	/** param is node 0..(highestN-1) */
	public static short L(short node){
		throw new Error("TODO range check?");
		//return L[node];
	}
	
	/** param is node 0..(highestN-1) */
	public static short R(short node){
		throw new Error("TODO range check?");
		//return R[node];
	}
	
	/** returns node 0..(highestN-1) */
	public static short pair(short itsL, short itsR){
		throw new Error("TODO range check?");
		//return pair[itsL][itsR];
	}
	
	/** nodes from depth0 to to the given depth. This func is not cached. */
	public static BigInteger nodes(int depth){
		BigInteger x = BigInteger.ONE;
		for(int i=1; i<=depth; i++){
			x = x.multiply(x).add(BigInteger.ONE);
		}
		return x;
	}
	
	/** param is node 0..(highestN-1) */
	public static byte height(short node){
		throw new Error("TODO range check?");
		//return height[node];
	}
	
	/*Make the comparator, and verify after generate them that
	they are in order of height recursively.
	Generate same as in OccamsfuncerCountBinForestShapesPerDepth.
	*/

}
