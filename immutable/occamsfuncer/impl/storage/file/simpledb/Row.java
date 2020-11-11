package immutable.occamsfuncer.impl.storage.file.simpledb;
import java.util.ArrayList;

import javax.management.Query;

import immutable.occamsfuncer.fn;

public class Row extends ArrayList<fn>{
	
	/*
	``a`b`cde meaning ((a(b(cd))e),
			and each leaf (a b c d e etc) would have a size prefix. The ````... make recursive pairs,
			which recursive lists and small maps can be defined with. YES, do that.
	Still need to choose what the leaf byte[] mean, such as need abbrevs for certain common things
	including L R S T F I P . etc, and might need some syntax like fpr ifpr twin + - (rows) etc.
	I want these to be small pieces, so each ` should be 1 of the 16 bits of a short that tells how
	many bytes that part of the object is, or maybe a varint.
	Theres these kinds of objects started by that short: dbPair, dbLeaf.
	Each of those has a size in bytes. It might represent a bit aligned cbtBitstring or other lambda,
	but its stored as byte aligned, or maybe short or int or long aligned. probably byte aligned.
	so the first bit tells is it dbPair or dbLeaf, and the next 15 bits tell the number of bytes
	in this object, including that short header, which ranges 2 to 32767 bytes, usually 3-300 bytes.
	Anything bigger than that, except maybe some of the smaller blobs go here (up to 1000 bytes?),
	goes in simpleblobtable. I might also want a bit for is this the start of a dbRow,
	so it could represent up to 16383 bytes. Need to know if its the start of a dbrow or not
	cuz its used as interchangible with a fn or some statement relating fns such as to say 2 are twins/equal,
	but I might need + and -, which create and remove rows idempotently, to be the top level?
	Or maybe I dont need to remove since they're statements which are always true (unless its a single state
	var that you keep updating the current state snapshot of the system, but maybe that could
	be done in the nondet system by querying for state at a certain utcnano_concat192bitsofyourVMsprivatename.
	The main use of removing rows is to uncache them, as another file could be created which
	doesnt have the - rows or the + rows before it they idempotently deleted/uncached.
	...
	What if there was data corruption. Need a way to at least statistically be able to align
	to the start of one of these things. A certain prefix starting one of these rows?
	Alignment on long[] instead of byte? Unsure. How about a small hash of each such row prefixing it,
	so could check if such a byte range following it matches that hash, so could align statistically.
	How about instead of short use int with the extra 2 bytes being hash of the whole content inside
	that its length refers to? expensive cuz squared number of calculations of this few hundred bytes.
	Could have 2 sizes instead of just 1, so you can jump ahead to the left (here) or right (jump) child.
	so 2 bytes for total size (minus 2 bits for dbLeaf vs dbPairInternal vs dbPairOutermost)
	and 2 bytes for how far into it is left child. Or could do that as 2 bytes if its int aligned,
	where its 1+1+7+7 bits, each 7 referring to 0-127 ints so objects would be up to 508 bytes.
	Or maybe I just want a 1 level list of small byte[] as rows?
	
	
	
	TODO this will be a sequence of bytes as a list of sequences of bytes, just those 1 levels? see comment in simpledb.java
	FIXME or do I want multiple levels deep but just a few at most, like a map whose key is a list and value is another map.
		Do I want mongodb which uses bson? I dont think I need that much complexity since its immutable forest data.
		Even if I wanted the maps, I'd still count that as lists and just alternating key val key val,
		so I've decided on lists.
		Do I want more than 1 level of list: list in list in list... up to few levels deep
			(which can represent map containing a list as a key and its value is another map, etc)?
	FIXME or do I want rows to be simple map as alternating key val key val
	where key or val can be very small, like a varint or short or byte prefixed thing, that could be just 1 or a few bytes
	like T F S P L R . fpr ifpr etc. Bencoding is a text form of size header that works with trees but
	I like varints or shorts better.
	FIXME Should the simpledb append file be just a sequence of small var size byte[],
		including syntax like + - ( ) `binarycalllikeinunlambda etc, and at a higher level
		interpret that as the adding and removing of rows?
		Each byte[] would be prefixed by a len, maybe a uint16 number of bytes, or a multiformats-varint?
		Maybe I'd like to think of it like ``a`b`cde meaning ((a(b(cd))e),
		and each leaf (a b c d e etc) would have a size prefix. The ````... make recursive pairs,
		which recursive lists and small maps can be defined with. YES, do that.
		Still need to choose what the leaf byte[] mean, such as need abbrevs for certain common things
		including L R S T F I P . etc, and might need some syntax like fpr ifpr twin + - (rows) etc.
	..
	Big objects go in simpleblobtable. small objects go in simpledb.
	simpledb refers to simpleblobtable, but simpleblobtable doesnt refer to simpledb.
	simpledb andOr occamsfuncer tells simpleblobtable 2 funcs:
		(1) idMaker: how to treehash a blob (padded with 1 then 0s until next powOf2 but not storing the padding,
			just including it in hash calculation).
		(2) func of id to dir, a second level of hashing you keep secret so that others dont know how you're storing it
			so they cant cause things to accumulate too much in any one dir, while ids are public and shared.
			If someone does figure out how you're storing it, you can quickly rehash the ids
			and move the files without changing the filenames or their contents.
	*/
	
	/** has been saved to the OutputStream since setExists(boolean) changed (including in constructor it setExists to true)? */
	public boolean isSaved(){
		throw new Error("TODO, or should this be done in SimpleDb?");
	}
	
	public void save(){
		throw new Error("TODO, or should this be done in SimpleDb?");
	}
	
	/** setExists(false) then save() appends a "- ...ids in this list..." to the OutputStream in the SimpleDb,
	which instantly defines that it doesnt exist even if it was added earlier in that OutputStream,
	and later a File (its OutputStream to) may be replaced with only the Rows that still exist,
	leaving the rest as a log or deleting it.
	*/
	public void setExists(boolean exists){
		throw new Error("TODO, or should this be done in SimpleDb?");
	}
	
	//TODO disable modify funcs here and in the Iterator

}
