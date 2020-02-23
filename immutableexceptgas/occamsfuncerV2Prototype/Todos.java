package immutableexceptgas.occamsfuncerV2Prototype;

import immutableexceptgas.occamsfuncerV2Prototype.util.CallAsKey;
import immutableexceptgas.occamsfuncerV2Spec.fn;
import mutable.occamsfuncerV2Prototype.ui.OccamsfuncerUI;

/** this class doesnt do anything. its just a place to put comments.
Get it out of the top level package of occamsfuncer asap,
but I dont want to lose these plans.
todo copy from phonedoc soon to here too.
*/
public class Todos{
	
	/*moved from OccamsfuncerUI
	TODO get something very basic working such as
	each keyboard button maps to a different color
	and make the whole screen that color when its pushed.
	*/
	
	/*Moved from Cache.java...
	FIXME cache will no longer be cleared by caller
	and will instead use continuous garbcol.
	It will clear whichever CallAsKey is oldest counting from
	the last time it was used,
	and CallAsKey will use up to 3 WeakReferences OR
	3 longs and every object has a long localId,
	whichever of those 2 ways is faster,
	as cache must not not prevent garbcol,
	but still anything reachable from a fn whose Compiled
	is customized (not a ptr to the 16 Compileds of the ops and those below)
	wont be garbcoled.
	*/
	
	
	
	/*moved from immutable.gpuVM
	
	QUOTE from gpuVM in mindmap[
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
	Also, hardware, such as FPGA, could later be designed specificly for this kind of int[] computing
	and could do it as fast as normal computers, or maybe even faster as its VERY threadable.
	It would have no problem with using 64k cpus together, if the memory hardware could support it,
	though might want to redesign it for 64 bits at a time instead of 32 in that case for larger
	memory space and opcodes that can refer to other cpus and gpus etc.
	But far sooner (if that ever happens) I expect this model of computing
	to be a useful optimization of occamsfuncerV2's universalLambdaFunction,
	accessed through cbts of various powOf2 sizes paired with a cbt of size 32registers*32bitsPerInt.
	...
	https://www.reddit.com/r/FPGA/comments/evc335/what_memory_topologies_are_available_for_fpgas/
	...
	https://www.reddit.com/r/compsci/comments/evcgcd/what_would_make_a_good_spec_for_defining_specs_in/


	ocfn vob graphics? Textures on triangles? What if the textures are all from 1 big cbt?
	ocfn aftrans of unit triangle as polygons? could aftrans into color space too so 3d->6d Or could just give 3*3d points and 3 ints for the color. or 3*6d points? Or textures? 
		https://webglsamples.org/lots-o-objects/lots-o-objects-draw-elements.html
	Maybe I should allow java:codestring in the nondet sections but filter the code to only allow code that calls $(cost) certain places like at the start of a loop, and before allocating memory? Or could allow only wrapper objects of arrays etc and make it use only those and convert them to fn after done mutating them, and not allowed to give ptr to such mutable objects to any other function until freeze them into fn? Also hook in acyclicFlowInt[]MusicToolsOptimization and opencl forestop this way, with similar safety guarantees.
	Or do I want the progn style loops that abstractly act as treemaps (or tinymaps?)?
	Could I for example simulate many small objects that way?
	Try writing the code to simulate many bouncing balls or smartblobs that way...
	Do I want to use op.curry (such as Example.c() or .cc() or .ccc() etc)
	and op.recur for that (with tailRecursion optimization?)?
	ns will be (getter of) a treemap of varname to value
	f(
		c
		S(
			recur
			ST(someTransform (getp <unary4>)#ns)
		)
	)
	//and forgot to putin an ending condition. Use IF(...) for that.
	The curry and recur arent helping here. What I really need is the someTransform.
	(while condition funcBody firstState)
	continues if (condition state) is T, else that must be F.
	then replaces state with (funcBody state), and returns the final state.
	Or how about the model of statefulObjects where it returns (pair nextState returnValue)
	so (statefulObject anything T) and (statefulObject anything F) return nextState or returnValue,
	and the return value could be should it continue.
	But it doesnt need to take a param each time, so thats the wrong model.
	"while" would be a derived func.
	(
		while
		?outerLoopContinue //S(I t(;outerLoopContinue)) //treemap has ;outerLoopContinue -> T or F
		progn(
			//hypot=(...) is a func that takes a treemap param and forkEdits the ;hypot key to that value
			hypot=ST(doublerawcbtAdd ST(dSquare ?x)	ST(dSquare ?y))
			
		)
		(tinyMapToTreemap (tinyMap ...))
	)
	Try implementing sha256 efficiently in occamsfuncer. What syntax would I use?
	https://github.com/benrayfield/jsutils/blob/master/src/sha256.js
	...
	Build procedural assembly that ONLY has ints,
	and has at most 256 registers and maybe 1 of them is instructionPointer,
	maybe 1 or more of them is stackPointer, and maybe each int is
	byteFromA byteFromB byteTo byteWhichFunc,
	and it will use either the Float.*int*bits* funcs OR emulate ieee754 float math
	using ints without those funcs since I might be able to do it faster
	by using a long or multiple longs if I maybe standardize it on
	something slightly different than ieee754 and just dont call it ieee754,
	such as dont have NaNs or infinities or something like that.
	Map between int[1<<log2OfSize] and cbt before and after each run of n cycles.
	First 256 or maybe first 128 ints are the registers.
	Registers should probably only be for reading and writing at top of stack
	and instead do all calculations on the stack.
	Or maybe stack should be for copying to the registers but
	do all the (int,int)->int ops in the registers?
	I want at least 2 registers one of which is memPtr and one is memVal,
	and its always true that mem[memPtr]==memVal and can use that to read and write memory.
	I might want a register that is decremented every cycle and is like ocfn Gas.top
	to limit number of cycles.
	I might want instructionPtr to be writable directly instead of jumpIfLessOrEqual (jle) etc,
	which I know is harder to optimize but its simpler opcode.
	I might want all memory reads to be an opcode that uses whats on top of stack as ptr
	and reads whats at that ptr and replaces top of stack with that value,
	and I might want all writes to use the top 2 values on stack and write one
	to mem[the other]. Or I might want a register that is the read and write address
	and auto increments whenever its read or written,
	or I might want mulitple of those.
	I might want opcodes to always be 1 byte each so can store 4 of them in each int,
	and dont allow opcode 0, so when >>>8 it if its 0 then thats the end of the opcodes
	in that int. So would have to load from memory less often.
	Need an opcode that pushes next int (after that opcode) onto stack,
	or maybe next n ints.
	No to the 256 or 128 registers.
	There will be 16 registers. 1 of them is instructionPointer,
	and the others are 15 of the same thing.
	They all point into memory. Various opcodes choose up to 3 or maybe 4 of them
	and do a certain thing which affects only the memory they're pointing at and those 4.
	Or maybe there should be 8 registers.
	Ops will normally increment, decrement, or not change the value of each of the few registers
	that op is for, such as to increment register3, decrement register5, and leave register9 as it is,
	after adding the 2 ints at the mems pointed at by 2 of those registers and writing the result into
	the mem pointed at by the third register, or ops to copy the value at a certain register
	over the pointer value (pointer becomes that value) of a certain register.
	These registers can be used for streaming or stacks,
	and stack is not a well defined range but its top is wherever such registers point,
	and its not always used as a stack.
	At most 16 bits of literal can be included in an opcode, to copy to any of those
	places just mentioned. So it takes 2 opcodes to push a literal int onto a stack.
	Every opcode is 32 bits. No exceptions.
	8 registers, so 3 bits to name each,
	and a bit to say is it the register itself or is it the value it points at,
	so 4 bits to name a var.
	int2 to say what to add to that register, allowed values being -1 0 1.
	Need maybe 8 bits to say which thing to do, such as plus, multiply, shift, and, or, etc.
	Always use instructionPtr and 3 other registers,
	and have a separate opcode to copy the value from a register to instructionPtr,
	so those 4 registers selected cant overlap eachother.
	Between the 3 of them that arent instructionPtr,
	it does an (int,int)->int op and optionally does ptr++ or ptr-- or leave ptr as it is
	for each of those registers or the values they point at.
	An example of (int,int)->int is plus, negate, mutliply, and, or, shift, etc.
	Actually, just put in a bit in every opcode for is the third register supposed to copy
	its value to instructionPtr after doing its thing or not.
	Branching will be done forexample by creating 0b11111111... vs 0b0000000... then AND those
	with the 2 possible things to branch to one vs the other then jump to the result of that AND of ORs,
	or can do normal pointer arithmetic.
	Every jump will be anded by a mask that limits jumping to the int[].length which must be a powOf2.
]
*/
	
	
	
	
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
