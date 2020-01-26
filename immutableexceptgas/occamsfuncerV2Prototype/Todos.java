package immutableexceptgas.occamsfuncerV2Prototype;

/** this class doesnt do anything. its just a place to put comments.
Get it out of the top level package of occamsfuncer asap,
but I dont want to lose these plans.
todo copy from phonedoc soon to here too.
*/
public class Todos{
	
	
	
	
	/** This comment moved from Cache.java
	 
	TODO make ids this way asap.
	
	About ids...
	perfectDedupOfCbtUpToHeight is 13 cuz its needed to dedup ids and
	small string literals used as var names.
	Cbt0 and cbt1 are height 4. Height 13 is cbts size 512.
	Ids are normally 36 bytes, including 4 bytes of header and up to 256 bytes of literal.
	They can contain a multihash (such as used in ipfs)
	or a rawCbt from 1 to 256 bits (only powOf2 sizes)
	or a cbtBitstring from 0 (1 with padding) to 256 (257 with padding) bits.
	The choice of multihash vs cbtRaw vs cbtBitstring,
	and the multihash header, go in the extra 4 bytes.
	Its meant to fit in 9 ints so there will be padding in the 4 bytes sometimes.
	Since rawCbt has to be a powOf2, despite that Id like to use
	doubleSha224 instead of doubleSha256,
	still have to add header past any powOf2 size,
	and since ipfs (at least it did years ago) by default uses sha256,
	I'm trying the default kind of ids being 1 byte of my kind of header,
	to say the type of thing, then up to 3 bytes of multihash header, etc.
	<br><br>
	Also unaryCbt will be deduped if dedupAllUnaryCbt, nomatter their height.
	There will be a special kind of id for them which doesnt store their content,
	only stores their height, maybe in an int24 or int32 or maybe an int256?
	<br><br>
	FIXME this perfect dedup does not include childs of a cbt except
	that ids are always perfect dedup and its possible to cache all ids
	BUT it seems too expensive to cache all the childs of a wrapped array,
	those being the left and right halfs of it recursively. 
	*
	public static final byte perfectDedupUpToHeight = 13;
	TODO
	
	/** FIXME should this be true?
	These can be deduped by height in int range using Call.isUnaryCbt and Call.height,
	both in Cache.java and ids.
	*
	public static final boolean dedupAllUnaryCbtUpToInt32Height = false;
	*/
	
	
	
	
	
	/*Moved this from Example.mapPair[
	TODO now that I have double math working with ocfnplugs
	(todo do it as user level code to avoid op.nondet things
	that wont be standard across occamsfuncerVMs),
	build mapPair and mapSingle and mapEmpty
	and avlList and maybe a few other datastructs,
	and do it in a way that when the long math is replaced
	by the user level code that its at Example.nameXYZ funcs
	so its automatically replaced. Create the curry constraint and curry funcBody.
	]
	*/
	
	/*
	Moved this from Cache[
	Some things need to be perfect deduped nomatter how they're built.
	This includes small strings used as map keys,
	but wait, map always uses id so that doesnt need perfect dedup.
	
	The forests of S need weak dedup, strong enough that if the same S call
	of (S x y z) is built again some other way,
	including the (x z) (y z) or (whatXZReturns whatYZReturns) each must be deduped
	nomatter how those combos come together from multiple sources multiple times
	redundantly... That needs to be deduped only to the extent that some cbts
	can be just compared by == while others need perfect dedup
	such as getting a substring starting at index 44+1 vs at 43+2
	
	Should there be a func that dedups?
	Dedup or not gives the exact same lambda behaviors
	and is only an optimization (often exponentially faster).
	
	SOLUTION: every densely stored cbt will have a long binheapIndex,
	maybe the first 2^58 indexs are sparsely stored as int[]s,
	and the next 2^58 indexs are sparsely stored as float[]s,
	and the next 2^59 indexs are sparsely stored as double[]s,
	and index is of a bit.
	Also I might want some of that range for Call instances
	which would have 3 long fields and about 21 bytes of other fields
	so might fit in blocks of 48 bytes, not including their ids,
	though thats something I'll leave for future design
	as this is not affecting ids and is only
	an optimization to dedup childs of big cbts
	without having to store them in hashtable.
	]*/
	
	/* Moved this from Call[
	Call is int[9forid 6forfields 3*9 for childs = 168 bytes]
	self contained int[42] which can be shared across network
	and if any of the childs are literal cbt or cbtbitstring
	up to 256 bits then they're self contained in their id.
	Contains all the fields for this object but does
	not contain the fields for childs which can only
	be found in their content to hash.
	Can have a half million of these in memory for only 84mB.
	Can store them in a db of only 1 table and only 1 column.
	Can store binary data for about 1/3 efficiency,
	though could also store it in bigger chunks
	for approaching 100%-epsilon efficiency
	and still generate the same ids as needed,
	an optimization to add later.
	Can lookup these by int[9] id in hashtable.
	
	TODO put a version in the fields somewhere
	that is a few of the bytes from the hash of Example.equals()
	or maybe the hash of the hash algorithm itself
	though might be a circular paradox if needing to
	put that in the fields of Call.java
	but other than that any algorithm can be called on itself.
	
	Do I want a bit for has returned vs is being evaled?
	(if being evaled, comment is always leaf)
	
	Do I want a structure of same or lesser size
	that means <func,param,return>?
	That can be derived as the normal call datastruct
	but takes 3 calls starting with a certain fn
	the one that will go in Example.funcParamReturn()
	(or what was its name in Example?).
	
	Do I want a prefix such as ocfn200124_: (which adds 3 ints)
	to name the specific day its hash algorithm changed as YYMMDD?
	
	Do I want a long refcount in the fields,
	so can replace that int[] with another int[] that has the same
	key but only 1 of them will exist at a time per VM?
	Makes network sync harder but in network they will all just say
	the refcount is 0.
	maybe in network we use the recursiveExpireTime field?
	]*/
	
	/*Moved this from ArrayCbt[]
	FIXME point into /occamsfuncer/src/immutableexceptgas/occamsfuncerV2Prototype/denseCbtMemMap/Mem.java
	instead of storing the array here.
	Use only a long ptr here to refer into Mem,
	and byte height is also known by its long addr in Mem
	but could cache those things here.
	Also cbtBitstrings that arent a powOF2 could be inefficient
	in that model, requiring log num of Call objects
	such as if an id is 36 bytes
	then you need (32Bytes (((4Bytes empty4Bytes) empty8Bytes) empty16Bytes))
	where those empty* are shared branches.
	so it would actually be more efficient in some ways
	just to store 64Bytes, and thats what I want to avoid.
	I could technically store 10 ints in Mem and just define
	the rest up to the next powOf2 as padded with 0s.
	Yes, do that.
	Or maybe ids should be 35 bytes so only have to store 9 ints.
	]*/
	
	/** moved from Nondet.java
	TODO check for type is "mutableWrapperLambda",
	and where do Spend and Wallet (and maybe SpendIf) calls go?
		
	TODO, if theres enough compile resources left (max 2^16 java classes
	per classloader, for example, but multiple classloaders can interact
	through an interface they both share) to generate the lambdas in
	a Compiled for calling the func looked up here by reflection.
	*/
	
	/*
	TODOS for mutable.occamsfuncerV2.Network
	
	TODO hook into occamserver using http instead of https
	since all security is done inside the fn objects,
	though you could use https if you want (TODO) such as run
	occamsfuncer inside Tomcat or ApacheHttpCore instead of occamserver,
	which would give you privacy across peer hops but
	since any fns that cross the network are considered public
	there shouldnt be a need for privacy in that
	and if you want privacy you encrypt cbt bits
	and have privacy of that array
	or build a homomorphic crypto system on top of
	the universal lambda function (at user level,
	not modifying occamsfuncer VM).
	People will probably want https just to make their browsers etc
	stop complaining that they dont understand what kind of security it is.
	Part of the security is that the security can evolve
	in turingComplete ways,
	such as fn.id(fn idGenerator) can use any fn as an idGenerator
	or multiple idGenerators at once.
	...
	Hook that into serve(byte[]) func,
	where the http headers (if any) are ignored and only use the content.
	
	TODO if am subscribed to 10000 of 4 bytes per cycle each
	at 32 hz each (so 128 bytes per second each),
	how should those be efficiently organized without allocating
	fn objects for each of them? Cuz fn objects are too expensive
	to allocate for every few bytes.
	This is needed for mmgMouseai and mmgOfBendyLoopsClimbingEachother
	and maybe networked music tools	(maybe should be openOSC compatible?)
	and other experimental games.
	*/
	
	/*See "MUTABLEWRAPPERLAMBDASPEC" farther below.
	TODO mutableWrapperLambda as a way to webcall eachother.
	Digsig (such as by ed25519) will be verified using curry constraint
	that infloops if the sig isnt verified,
	but there will be another way to use it by nondet.
	The correct way to do it is for each possible param of a pubkey
	to only ever at most 1 value,
	but I cant prevent them from signing multiple values
	for the same key and I cant sync it perfectly to prevent that,
	so I have to define an unambiguous way to solve such conflicts
	which will either be some way of comparing them and take the smaller
	or that if 2 values are ever found for the same param then
	value becomes leaf.
	I choose the leaf design, that if 2 values are ever found
	for the same param that the value becomes leaf,
	BUT I still have to decide if its ALL values for all params
	of that pubkey or if its per pubkey.param.
	I choose for it to be for that pubkey, to basically blacklist
	it the first time it doesnt obey the spec.
	You can of course create unlimited number of other pubkeys
	as its blacklisting per pubkey not considering network address,
	and fns can be designed to take pubkeys as param
	so they arent hardcoded to any specific pubkey,
	or you can point at a specific pubkey.
	Param of op.nondet will be something like
	linkedlist or pair of "mutableWrapperLambda" pubkey,
	where pubkey is any recogFunc of 3 things: signature, param, return,
	or maybe recogFunc of (tinylist signature param return)
	or maybe a different order of those params or something.
	digsigPubKey should be some structure of curry
	that uses curry constraint to infloop unless signature is verified
	and the thing its signing is id of (pair param return),
	but that means the curry must also include param of idGenerator,
	and must have another param since curry constraint is verified
	at second last param.
	(curry unary(TODO) constraint funcBody
		idGenerator param return signature ignoreThis) infloops.
	(curry unary(TODO) constraint funcBody
		idGenerator param return signature) exists only if digsigPubkey signed param return.
	(curry unary(TODO) constraint funcBody) is a digsigPubkey, stored in funcBody,
		or maybe funcBody should be considered the digsigPubkey.
	As I'm going to use multihash as part of ids (prefixed by 1 byte)
	and multihash already has a prefix for ed25519 pubkey,
	is there a way to use that instead of needing all these other objects?
	Probably not cuz it makes the size of an id nonstandard, exceeds the 35 bytes.
	Signature is one of the params and in some cases would be cbtBitstring that ed25519 uses,
	and funcBody would be (ed25519Verify cbtBitstringOfEd25519PubKey)
	where ed25519Verify is some derived func.
	So there is a place to put in the binary ed25519 pubkey and binary signature,
	so it could be optimized by a Compiled IF Op.nondet had another param
	instead of making you use (pair "mutableWrapperLambda" pubkey) as the param.
	How many params should Op.nondet have? Currently it has 2, and I'm thinking of
	expanding it to 3, but should it be more? How many would ever be needed?
	(nondet type instance param)?
	(nondet "mutableWrapperLambda" pubkey) is a func that can be used for web calls?
	If (nondet "mutableWrapperLambda" pubkey x) ever returns 2 different things
	then all params of it return leaf forever after that is known.
	If you want to return different values for the same param
	then a workaround is to use (pair time param) instead of param directly
	or (pair randomNum param).
	Simplify digsigPubkey to any func that takes 2 params and on the first
	does not infloop when that first param is (tinylist signature param return),
	so digsigPubkey could recognize anything even if its not a tinylist
	and thats part of the trinaryForestBloomFilter
	but (nondet "mutableWrapperLambda")
	only counts (tinylist signature param return).
	BUT FIXME where to put idGenerator?
	Instead, digsigPubkey recognizes 2 params and infloops on the third...
	(aDigsigpubkey idGenerator (tinylist signature param return))
		is second last param where curry constraint is verified and infloops if not satisfied.
	(aDigsigpubkey idGenerator (tinylist signature param return) ignoreThis) infloops.
	Make web calls on (nondet "mutableWrapperLambda" (aDigsigpubkey idGenerator)).
	...
	MUTABLEWRAPPERLAMBDASPEC:
	If this exists: (aDigsigpubkey idGenerator (tinylist signature "hello" "world"))
	and theres no 2 values for same param,
	then: (nondet "mutableWrapperLambda" (aDigsigpubkey idGenerator) "hello") returns "world".
	else (nondet "mutableWrapperLambda" (aDigsigpubkey idGenerator) anything) returns leaf.
	Or how it will be normally written...
	(nondet "mutableWrapperLambda" (aDigsigpubkey idGenerator))#bob
	(bob (pair 23423542435 "hello")) returns "world".
	...
	Or maybe should add an extra param for timeOrRandomNum so (bob 23423542435) is a func
	so you could ((bob 23423542435) "hello") returns "world".
	If you dont want to use the time param you could use time 0 for everything,
	but maybe it shouldnt require that extra param.
	That might have come from anywhere. It doesnt have to identify itself,
	and a response doesnt have to be given. The param might contain
	instructions where to respond such as one of alice's pubkeys.
	Thats why the first call is to "bob" instead of mentioning "alice" first
	which is normal in crypto talk that alice first sends a message to bob.
	Its merkle data integrity but if you want crypto you'll have to derive it yourself
	such as to send a cbtBitstring that happens to contain encrypted bits
	that are public to everyone in the network.
	...
	Like http, these can be cached, but unlike http,
	they are normally cached forever unless its discovered that a pubkey gave to values
	for same param which is not allowed by the spec so from then on every param
	of that pubkey returns leaf.
	...
	There will be a nondet func to return the lowest sorted pair of conflicting
	things signed by a pubkey, else it will wait until that is found,
	so by nondet spend call it can check if a digsigPubkey is still obeying the rules
	as far as is known locally.
	...
	UPDATE: instead of returning leaf when pubkey breaks the spec,
	define that pubkey as all calls take forever so its closer to standard lambda math
	in that its acting like its infinitely inefficient,
	but that doesnt fix that multiple computers might have got different return values
	for the same pubkey and param before that.
	*/
	
	
	
	
	
	
	
	/*Decide on the details of how to partial dedup without using id of every cbt
	but instead using == comparing of big cbts, and treemaps will still use
	a param idGenerator for sorting keys. Its enough dedup for the forests of s
	to not expand exponentially and for that to go through multiple curry calls
	recursively still deduping. The id of any cbt up to 256 bits,
	including cbtRaw or cbtBitstring up to 256 (with an extra bit if is cbtBitstring)
	contains those bits literally, but still might need to create a part of
	Cache.java to dedup those cbts so for example if you're computing
	fibonacci recursively then it will have linear cost instead of exponential,
	and that can work even for ids or bigints up to 256 bits.
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Redesigning occamsfuncer to have comment field at start of every op,
	and most importantly to be able to put a datastruct there containing string and pic (cbt intARGB pixels)
	and for quadtree (branching factor 2 but twice as deep) to be above those in the standard ui datastruct
	which ends at var depth of wherever nonquadtree ob starts (a well defined datastruct marks that
	an ob is below, even if its a quadtree that otherwise would have been quadtree childs).
	AndOr I might want mathevo-like triangle adjacency matrix with 2 adjacent as its pairs in forest
	and to the right of the diagonal is text form.
	AndOr I might want trinary branching factor 3 instead of 2, except the third branch (comment)
	is always leaf when height<5 so none of the ops are modified by it and especially
	important is there is only 1 leaf, or maybe just leaf has to have leaf as its third child,
	but I'm very hesitant to do that cuz it would complicate recursion such as in Example.equals()
	would have to recurse into 3 branches which would take 2 ANDs and 3 calls of recur.
	I dont like the quadtree behaviors of not being able to comment at param index
	and only at the start of each op andOr in any igfp.
	Or I could keep the binary shape and somehow define that (comment (func param)) is the normal recursion,
	such as (comment ((comment (s k)) k)) instead of ((s k) k).
	Or I could take the trinary, everywhere except leaf (whose third child is always leaf),
	and often define funcs on 3 things such as it wouldnt complicate Example.equals()
	as much if I defined AND of 3 things so cound use 1 AND3 and 3 recurs,
	and of course that would end fast on the comment branch if comment is leaf
	which is an optimized case
	I think this is what I want, trinary everywhere except leaf,
	BUT I'm still undecided on if I want only the ops with comment==leaf to work
	since you can check them with ==, or if I want them to allow comments and still work,
	and what if the lower structures they're made of have comments?
	
	Do I want it to be trinaryforest instead of binaryforest?
	I could have 2 extra ops somewhere that getComment and forkPutComment,
	and that way the ops curries dont need to be modified
	BUT it would be a much bigger redesign and would make
	it waste more memory EXCEPT default comment is leaf(withnocomment)
	so could store that in just 1 extra bit per object
	if in a variable size stream, and bigger than that if it has a comment.
	BUT does it make leaf inconsistent?
	Calling leaf on itself in various combos must be able to
	generate every possible function with every possible comment,
	especially to generate leaf with a comment as its trinary third child,
	where its other 2 childs are I and itself.
	(R leafwithcommentx) is leafwithcommentx, not leaf,
	so does that break the lambda math?
	What if I only allow comments on objects that are at least height5?
	
	/*FIXME how many curries does leaf take? Is it a kind of vararg
	caused by being able to derive the 16 ops at height4?
	Maybe I should be careful in choosing order of those 16 ops
	as they are derived by combos of leaf calling leaf or
	such as (leaf (leaf leaf)). cur() needs to be consistent.
	
	How can I make sure fn.cur() is not reduced
	when adding another param, if cur is already CURRIES_INFINITE?
	Should I just let it decrement?
			
	Should it infloop if try to exceed int height, int curHeight, int cur?
			
	Should I use float for number of curries since float can represent Infinity?
	
	Should I use long height, long curHeight, long cur, instead of ints?
	No, its still finite, even though it would prevent reaching
	the limit by those who try except maybe after a very very long time.
	
	/*TODO uiObject=(curry ... (using constraint) funcBodyActsLikeOb)
	...		
	(uiObject humanReadableCommentCbt obExists ob <uiObject> <uiObject> cbtIntargbQuadtreeOrNull x)
	returns (ob x). Its normally used as a datastruct without the x until called on an x by dragAndDrop
	or automatically AIs communicating with AIs andOr Humans etc.
	...
	obExists (T or F) has to be there cuz need the flexibility to use
	every possible ob in this system as it will be like a memory or desktop on screen
	to put anything in, and I dont want the ui to have no way to know
	if leaf is meant as its ob vs if leaf means theres no ob.
	...
	or should it have 4 uiObject childs? No, still need it to be shaped as binary forest
	for alignment to lambdas.
	...
	Instead of just obExists and having childs vs cbtIntargbQuadtreeOrNull,
	should there be a cbt representing its type (4 types so far)?
	I'm trying to keep it general enough it wont need more types ever,
	as those would be a different datastruct not displayed in same JPanel if needed.
	...
	and JPanel to display and draganddrop them (already have one with 4 colors but it
	is for fns in general, not for this datastruct).
	VERY VERY IMPORTANT, this datastruct can act like lambda funcs
	that take this datastruct or normal func as param
	and return this datastruct or normal func,
	like you can grab a comment or picture and
	call it on a picture to get another picture,
	and normal fns can take these picture/datastruct/comment as param
	and call them on other things, even if those fns were not
	designed to work with this datastruct (which they actually werent
	as I thought of this datastruct after designing the universal lambda func).
	Build this as a subclass of GoldenratioQuadtreeUi.
	*/

}
