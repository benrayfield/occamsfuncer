package immutable.occamsfuncer.impl.storage.file.simpledb;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import immutable.occamsfuncer.fn;

/** a database for up to around 100 million small objects in memory
and any size of data that fits on your harddrive of
up to about 1 million sparsely loaded blobs (each has its own file, as in SimpleBlobTable),
and its compatible with the standard ids and merkle forest of occamsfuncer
so can scale to any size even the whole internet, having sparse parts of it in p2p network.
Occamsfuncer's default id type supports up to 2^63-1 (TODO verify, might be 2^62-1 etc) bits per object (1 exabyte)
and up to about 2^96 objects (to avoid sha3_256 collisions which you'd need about 2^128 objects for).
This default id type is 416 bits (52 bytes): 256 bits of hash or literal data,
63 bits of bitstring size (fn.bize()) and a bit for is its size too big to fit in that and its the 63 lowest bits of that size
(actually supports unlimited size bitstrings but interpreted not supported directly in ids),
64 bits of which powOf2 aligned subrange in a bitstring (fn.zigzag()),
and 32 bits of various masks and small integers for optimizing (first bit is always 1 so other datastructs can start with 0,
(or todo maybe should allocate a multicodec or multihash prefix for it and be ~56 bytes instead of 52, after its been working longer)
idOfIdDepth, pairOfPairDepth, number of curries left, etc).
<br><br> 
Appends small lists to a file, prefixed by + or - to add or remove them.
Each list is identified by its whole contents and names things by their 52 byte id,
with some binary datastruct like maybe a varint size or 2 bytes of size since its for small things.
Its read sequentially without randomAccess ability cuz you have to know the size of a thing to know
where the next thing starts. Its meant to load all the objects into memory except the
large blobs (such as files up to 1 exabyte fits in int64 number of bits, or other ways of blob storage).
Those are loaded as needed, or in parts as used by fn.zigzag() and fn.unwrap().
<br><br>
Each row is basically a list of fn ids, or maybe lazyEvaled ids but will compute them before writing to file.
<br><br>
//PLR means parent left right
//quad means callquad aka parent func/L param/R stack cacheKey isParentsFunc
//DFPR means isDeterministic func param return
//	or maybe should have 2 row types for this for T vs F, or maybe should have a shorter literal syntax here.
//existence of "lockgc" or not prevents garbcol of blobs until its unlocked, like a db transaction, normally when replacing a row with something similar,
//	but since I decided to include the normed and any nonnormed form of the same forest shape as a row (a "twin" row),
//	thats self contained and doesnt need to modify the PLR or quad rows of either of those.
Example row: + "PLR" id(x) id(L(x)) id(R(x))
Example row: + "DFPR" id(T) id(plus3) id(5) id(8)
Example row: + "" id(T) id(plus3) id(5) id(8)
Example row: + "quad" id(x) id(L(x)) id(R(x)) id(stack(x)) id(cacheKey(x)) id(T)
//Example row: + "lockgc"
//Example row: - "lockgc"
Example row: + "twin" id(x) id(anyOfTheNonnormedFormsOfX)
The strings such as "DFPR" and "twin" do map to ids and fns, like everything else, but its a smaller syntax of writing them,
and should maybe be done for any literal that fits in an id here as compression.
Row ["quad" id(x) id(L(x)) id(R(x)) id(stack(x)) id(cacheKey(x)) id(T)] is a list of those 7 fn (a Row.java instance),
usually not all 7 are new fns, just ptrs to existing fns, especially for common strings and T vs F.
Example row: + "map" keyA valA keyB valB...
<br><br>
See Row.setExists(boolean) comment about replacing the File with one that only contains what still exists,
leaving the rest as a log of adds and removes or deleting that.
*/
public class SimpleDb implements Closeable{
	
	
	/** FIXME this needs to be definable on callquads, not just callpairs/halted. */
	public fn idMaker() {
		throw new Error("TODO");
	}
	
	
	
	/** TODO nodify SimpleBlobTable to read into any requested array/etc type such as FloatBuffer, float[], long[], byte[]. *
	private SimpleBlobTable blobs;
	*/
	
	/** the File is for many small objects, many of which will refer to whole or parts of blobs in SimpleBlobTable.
	The many small objects are always in memory when used. The blobs may be sparsely loaded from files.
	Any object may be garbcoled before written to longterm storage, or may be stored after a delay,
	even if its sent across internet at gamingLowLag it may never be stored on harddrive.
	*
	public SimpleDb(File file, SimpleBlobTable blobs){
		throw new Error("first use FileInputStream to read all contents once, then close that and open an append OutputStream of same file."
			+" TODO also a mode where it copies only the rows that still exist to the OutputStream,"
			+" so its still just 1 InputStream and 1 OutputStream but they would be for different Files instead of its normally the same file.");
	}*/
	
	/*public SimpleDb(InputStream readFileBeforeAppending){
		TODO
	}
	
	private OutputStream append = TODO;
	*/
	
	private Set<Row> rows = new HashSet<Row>();
	
	public void close(){
		throw new Error("TODO write all remaining Row to OutputStream then close the OutputStream");
	}

}