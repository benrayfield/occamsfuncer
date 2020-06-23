package mutable.occamsfuncer.v2.prototype;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import java.util.Map;
import java.util.Set;

import immutableexceptgas.occamsfuncer.v2.prototype.util.Example;
import immutableexceptgas.occamsfuncer.v2.spec.*;
import mutable.occamsfuncer.v2.spec.Mut;

/** Static funcs to access network in safe ways
(that malicious code in occamsfuncer sandbox
cant use in unsafe ways even if given access, TODO verify),
which are organized by tit-for-tat,
such as...
<br><br>
<br><br>
mutableWrapperLambda:
[[[
sending and receiving of fn objects (trinary forest)
such as the SmallForest.java datastruct
or datastructs compatible with mulithash/multicodec,
both of which will include literal bitstrings up to 256 bits
in an id as is.
(I'm undecided on datastructs so far,
but am decided on the the lambda func that occamsfuncerV2 is)
]]]
<br><br>
<br><br>
mypeerstreamapi (not specific to ed25519
or even specific to publickeys as it could just as easily
do any recognizerFunction of param return sig for any 3 things,
and see Todo.java comment "MUTABLEWRAPPERLAMBDASPEC" for details)...
[[[
subscribing to a large set of ed25519 publicKeys for streaming
(at a speed thats a powOf2 (positive or negative) number of bytes per second)
at an efficiency that can gaming-low-lag send individual bytes
with only a few times that overhead on average.
This is a workaround for most windows internet connections (and maybe also
 linux depending on isp etc) limiting number of network connections, while
  I still need gaming-low-lag many to many publish subscribe streaming of
   small data each some of them bigger data.

It uses ed25519 (pubkey) every few seconds or few times per second but per video
 frame (such as 20-50 times per second) it syncs, in a mostly hill climbable way),
  by proofofwork on pairs of any chosen timewindows of pairs of streams
   (which half the bytes in are hash and half are chosen data) with int96
    nonce per such pair of bitstring, and takes the maxClique of which of 
    those <bytes,bytes,nonce> can simultaneously be true, going for the max
     compute resources spent on whichever clique is found to be consistent.
A pubkey must often sign parts of its own state and may choose to sign parts
 of other streams states, where a stream state is the recent end, up to
  current utc time, of those bytes.


mypeerstreamapi explained in mmgOfBendyLoopsClimbingEachother 2020-1-8 QUOTE
NETWORK: Each game, which anyone may start inside a shared chatroom etc,
 will be organized by a single server which ed25519 signs pair<time,hash>
  (similar to ipns but at gamingLowLag) and all other computers share it
   with eachother as fast as they can but only on paths that tend to get
    it there before other peers get it there, and on return paths each 
    player ed25519 signs their game controls which gets back to that server.
     More generally this is publishSubscribe of [ed25519PublicKey
      maxDataSizeEach maxCyclesPerSecond] or something like that. Or
       maybe somehow new players could join during a game, which is
        better for mmg. Syncing at a single server per game (such as
         1000 games happening at once and anyone may run such a server
          at any time) avoids blockchainlike slowness, even though I'd 
          prefer it be pure decentralijzed if I knew a way to sync and
           gametheory that fast.
...
Or I might use ed25519 not on every update but on sparse updates such
 as once per half second or once per 3 seconds varying, and use some
  other method to agree on the streaming bits between which can be 
  challengeResponsed that short time later and boot those out of the
   network who dont go by the network protocol.
...
The network protocol would be a streamAppending 
nphardBlockchainRandomGenFork0(state)Fork1(state)Addtoscore(state)
 (fork 0 or fork 1 by appending a chosen bit at each even bit index 
 and each odd bit index is derived from that so far appended bitstring
  such as a moving window of it or sparsely only the primes or
   something like that). Each pubkey would define a speed of that, 
   2^n bits per second for some integer n, so a "server" would publish
    more bits per second than a "client", but its technically everyone
     to everyone. These could be synced by proofOfWork on pairs of
      bitstrings which are each some range in 2 of such streams.
       The streams are always contentAddressable cuz of the
        strongPseudorandom bits on odd index and contain any chosen
         data at even bit indexs. Nonce will be 96 bits, so a piece
          of data is an int96 and 2 intNs of 2 things that both exist 
          somewhere in 2 streams. 2 streams may have a shared past
           but not a shared future. Need some
...
But I still might need a way to attach those streams to ed25519 so
 it can be verified which player each stream is from even though its
  not verified at gamingLowLag its verified by challengeResponse 
  gametheory converges to.
...
Maybe the hash of each pubkey should be used in the hash algorithm
 that generates the bits at odd bit indexs, so no 2 publickeys can
  ever have the same stream for more than a few seconds and it would 
  be detected as an error. And each pubkey has to sign part of its
   stream (the bits at even and odd indexs recently, which are aligned
    to utc time on sparse powOf2 intervals) at least every few seconds, 
    the more often the better, but between that others can just claim
     parts of it by proofOfWork on pairs of parts of streams without
      saying which streams they're from, as a kind of compression.
...
Each odd indexed bit will be computed the same way as every other 
odd indexed bit, as a hash of a window relative to that bit index 
and its inputs also include (hash of) the ed25519 pubkey. So you dont
 have to think about bit indexs other than is it even or odd, and 
 you could view that as a base4Number.
...
Or how about 7 bits of data and 1 bit of hash, for more efficiency?
 No, half and half is a good ratio cuz it syncs faster. But maybe it
  should alternate dataByte hashByte dataByte hashByte....
...
hashByte could be computed as 
last_orshoulditbefirst_ByteOf(doubleSha256(
	concat2Of(concat(certain set of byte offsets,pubkey))))
	 similar to part of hashrotatecrypt except this way its still
	  a hash not encrypting anything just hashing so you know where
	   the data came from.
...
Each of these pubkeys would be pair(ed25519pubkey,powOf2NumberOfBitsPerSecond).
...
You therefore dont need a long blockchain of earlier parts of the stream
 of any pubkey to verify that some part came a certain time after another
  part except that you wouldnt know its time offset in utc, so maybe that
   time offset should also be part of the input to the hash... 
   last_orshoulditbefirst_ByteOf(doubleSha256(
   		concat2Of(concat(certain set of byte offsets,
   			pubkey,utcTimeAsUint32secondsUint32fractionseconds)))).
...
There needs to be a way to start a stream without it having to be
 computed by hash, such as all 0s, and maybe 1 of the bits in the
  hash byte tells if it is that or not.
UNQUOTE.
]]]
*/
public final class Network{
	private Network(){}
	
	
	
	/** FIXME maybe the state should go in StartWindow
	which creates OccamsfuncerUI with that state?
	Or should server and window be different objects?
	TODO load from harddrive the serverState from previous run.
	*/
	public static final Mut serverState = new Mut(Example.defaultServerState());
			
	/** TODO some part of serverState, such as one of its op.curry params,
	should be network options, but make sure it still obeys robots.txt
	and cant create a DoSAttack or hack to create a botnet etc
	(which will be prevented by it always lacking execute permission
	and instead a fn is called on a fn to create/find a fn,
	and networking is only the observation and sharing of such constants).
	*/
	public static final int maxPacketBytes = 1<<24;

	/** Before I get serve(Set<byte[]>) working,
	I'll design a server fn to just take 1 request at a time
	as this system is still very experimental.
	Eventually it will be able to use unlimited threads.
	*/
	public static byte[] serve(byte[] in){
		if(in.length > maxPacketBytes) throw new Error(
			"in.length="+in.length+" maxPacketBytes="+maxPacketBytes);
		return bytes(serverState.apply(in));
	}
	
	/** TODO after serve(byte[]) is working, redesign it for parallel.
	multiple small objects incoming, and for each a response,
	and serverState is updated.
	That The Set<byte[]> is translated to be a param of serverState,
	and the output of serverState (as Mut defines output)
	is translated to Map<byte[],byte[]> whose keys are in that Set.
	*/
	public static Map<byte[],byte[]> serve(Set<byte[]> in){
		throw new Error("TODO redesign serve(byte[]) to call this, since serverState will have to be different for it to take a set-liek datastruct as param");
	}
	
	/** publish in Mutable Wrapper Lambda (MWL) way,
	where the existence of a certain object, enforced by its curry constraint,
	(TODO) something like
	(curry aUnary aConstraint aFuncBody aParam aReturn signature)),
	proves that aFuncBody, or maybe (curry aUnary aConstraint aFuncBody),
	has signed something meaning (nondet "mutableWrapperLambda" pubkey aParam)
	returns aReturn, and that if it ever signs multiple returns for the same param
	then forever after all returns
	for any param of (nondet "mutableWrapperLambda" pubkey) infloop
	(and are caught at innermost spend call)
	such as by calling Example.fnThatInfiniteLoopsForEveryPossibleParam().f(leaf)
	which does or (S I I (S I I)),
	as a way of blacklisting that pubkey for not being a mutableWrapperLambda,
	but anyone is free to create as many pubkeys as they want,
	but nobody has to subscribe to any pubkey,
	and theres no specific required kind of networking
	as many kinds of networking could be used together
	all implementing the same occamsfuncer spec at a higher level.
	The way its defined, aFuncBody doesnt have to be a publicKey
	but is in general a recognizerFunction of that datastruct of
	of that number of params, so it could be any kind of digitalSignature
	based publicKey or a proofOfWork recognizer beyond some certain difficulty
	or it could accept every possible thing but that would likely be
	quickly blacklisted for signing multiple returns for the same param.
	*/
	public static void publishMWL(fn sig){
		throw new Error("TODO");
	}
	
	/** TODO see mypeerstreamapi in comment of this class
	but FIXME generalize it so its not specific to ed25519
	or any specific proofOfWork algorithm. Generalize those as fns.
	Maybe just including a fn streamType param here
	is enough generalizing of that?
	Statement (previously named sig)
	means somethign different than in publishMWL func
	as it could be the <bytes,bytes,nonce> kind or an ed25519 of
	some claim about your own stream or about other streams,
	and I'm undecided on alot of that so I'll leave that in the
	comment of this class for now.
	Splitting publishStream* into 2 funcs, one for sig and one for powTriple <bytes,bytes,nonce> 
	*/
	public static void publishStreamSig(fn sig){
		publishMWL(sig);
	}
	
	/** powTriple is a cbtBitstring. TODO what datastruct?
	Use multiformats varint size headers? Or keep that in streamType?
	Are they var size bytestrings?
	*/
	public static void publishStreamPOWTriple(fn streamType, fn powTriple){
		throw new Error("TODO");
	}
	
	/** Since cbtBitstring is efficiently forkAppendable,
	the fn returned will only have log number of new objects (or less if wrapping array(s))
	<br><br>
	TODO should it align on nanoseconds instead and just use (long)Time.nowNano()?
	Yes, so powOf2 is nonnegative. powOf2==0 means 1 nanosecond precision.
	powOf2==30 is exactly an interval of (2^30)/(10^9)=1.073741824 seconds.
	It must align on a powOf2 number of nanoseconds interval
	so different speeds of stream can align in binary.
	<br><br>
	OLD...
	utc3232 represents time ranges from 1970 to about the year 2106,
	always with precision of 2^-32 seconds.
	if utc3232start is the same as an earlier call of this
	or is aligned on a powOf2.
	utc3232 is in units of 2^-32 seconds and starts at
	year 1970 plus 2^31 seconds. so Long.MIN_VALUE is 1970 and its signed longs.
	powOf2 number of seconds per cycle.
	TODO byte or bit aligned.
	TODO what about the hash bits/bytes (odd index)
	which alternate between the data bits/bytes (even)?
	pubkey contains that powOf2 but its param here just to make sure you
	get the size you're expecting. 
	*
	public fn streamRange(fn pubkey, byte powOf2, long utcNanoStart, long utcNanoEnd)
	//public fn streamRange(fn pubkey, int powOf2, long utc3232start, long utc3232EndExcl)
	*/
	public byte log2OfNanosecondsIntervalOfStreamOfPubkey(fn pubkey){
		throw new Error("TODO");
	}
	/** utcNano times are start<<log2OfNanosecondsIntervalOfStreamOfPubkey(pubkey) (inclusive)
	to endExcl<<log2OfNanosecondsIntervalOfStreamOfPubkey(pubkey) (exclusive).
	See comment of streamRange andOr log2OfNanosecondsIntervalOfStreamOfPubkey
	for the efficiently forkAppendable cbtBitstring datastruct returned
	and how to cut off a powOf2 size block of the past efficiently
	while reusing most of its recent content (shared fn branches).
	<br><br>
	This func automatically subscribes, automatically unsubscribes if you dont
	call it for long enough on the same pubkey, and waits at most maxWaitNanoseconds
	before giving up. Returns null if gives up.
	If you've already subscribe(fn,double) to that pubkey,
	then if the max wait doesnt extend into the future then it should return instantly.
	*/
	public fn streamRange(long maxWaitNanoseconds, fn pubkey, long start, long endExcl){
		throw new Error("TODO");
	}
	
	/** To start with, subscribeToWhat can be some representation of
	a URL or a digital signature based public key such as ed25519 (TODO).
	<br><br>
	I'm trying to keep this general, of just a fn subscribeToWhat
	and double priority, so whatever the subscribe parts of
	the network become, they can be represented somehow as a fn
	and the priority tells how much bandwidth, reordering to make
	some lower lag than others, etc,
	keeping in mind that its organized by titForTat.
	This is open-ended as subscribeToWhat could be anything,
	as different implementations of occamsfuncer might
	accept different representations of the network
	but I'll try to standardize that once I'm able to experiment
	with networking occamsfuncer and mmgMouseai etc
	and see what problems come up.
	*/
	public static void subscribe(fn subscribeToWhat, double priority){
		throw new Error("TODO");
	}
	
	/** how many subscribed to? */
	public static int subscribes(){
		throw new Error("TODO");
	}
	
	public static void unsubscribeAll(){
		throw new Error("TODO");
	}
	
	/*
	public static Map<fn,fn> fnToMap(fn x){
		throw new Error("TODO");
	}
	
	public static Set<byte[]> fnToSet(Set<>){
		throw new Error("TODO");
	}*/
		
	
	/* This is done in Mut serverState...
	//public static Map<fn,fn> serve(Set<fn> requests){
	/** a request may be some form of set of multiple requests
	or a single request, as I've not decided on the datastructs yet,
	and the response will be to those.
	Var<fn> serverState is updated each time this is called.
	This only takes the input and gives the output.
	*
	public static fn serve(fn request){
		fn state = serverState.get().f(param)
		fn aPair = state.f(requests);
		fn nextState = aPair.f(T);
		fn  = aPair.f(F);
		serverState.set()
	}*/
	

}
