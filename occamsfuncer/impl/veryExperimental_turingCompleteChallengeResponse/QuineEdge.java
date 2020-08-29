/** Ben F Rayfield offers this software opensource MIT license */
package occamsfuncer.impl.veryExperimental_turingCompleteChallengeResponse;
import occamsfuncer.fn;
import java.util.List;

/** In occamsfuncer, a quine is an infiniteLoop of nonhalted fns where x.step().step()...step()->x,
for any step in that infiniteLoop. There are many possible quines, such as (S I I (S I I)),
but we are only interested in those which
prove that a certain [func,param]-->return.
<br><br>
UPDATE: if (func param) returns something other than that, then prove its not a quine by the thoughtItWasAQuine returning leaf,
and of course if (func param) never halts, then its still not a quine cuz it leads to another smaller quine that doesnt lead back here
or leads to an ever expanding calculation that doesnt lead here.
(The 4 kinds of haltingOrNotHaltingEtc are:
halts, comesBackToItselfAkaQuine, goesIntoSmallerQuineThatDoesntComeBackHere, expandsForeverWithoutComingBackToItself.)
It does that by starting with a linkedlist (UPDATE: use bigcall instead of linkedlist) of:
<func,param,return,<callingFuncOnParamThenCheckIfItGivesReturnAndIfSoEvalToTheOuterLinkedlistElseInfloop>>.
Using a bigcall op (which allows up to 7 params and can call itself recursively),
the first 3 params are func, param, and return, but they're not called just by being there.
The fourth param is ignored and is used just to start the process,
so its halted until gets that parasm, and call it on leaf
to create the quine (which never halts, but we can step() thru the loop).
The funcbody in the bigcall gets the first 3 params (func param correctReturn),
calls (func param) which returns r, calls (equals r correctReturn) -> T or F,
and if it equals then returns (...bigCall funcBody func param return leaf) which closes the infiniteLoop
(FIXME see comment in QuineUtil about maybe needing to upgrade step func to do tailRecursion to close quine loop)
as its the call you started with by calling (...bigCall funcBody func param return) on leaf,
ELSE (equals r correctReturn) is F therefore returns leaf.
If (func param)->return then (...bigCall funcBody func param return leaf)->(...bigCall funcBody func param return leaf)
while still evaling so its a correct infinite loop we can step thru.
<br><br>
That one of many possible ways peers in p2p network could turingCompleteChallengeResponse eachother
to prove to eachother, at least statistically converging toward it being ever more likely,
that for any 3 fns a peer can claim to other peers that x called on y returns z,
which they can use in CacheFuncParamReturn which is used in step func
to avoid an exponential cost of repeating calculations recursively.
<br><br>
3 fns are needed at a time to make a useful statement about a quine,
and those are 3 fns along the same infiniteLoop of that quine, which step->step...->step
reaches in that order with any number of steps between them.
Think of it like a circle with a fn at many points along its 1d perimeter. Each steps to the next clockwise.
If we have many such x->...->y->...->z->...->x in the same quine, each of x y z etc being one of those
fns on the circle, then if they're wrong about the order, sometimes it can be detected
like if also x->...->b->...->y->...->x and b->...->z->...->y->...->b
thats a contradiction cuz we know x->...->b->...->y->...->z->...->x
and the y and z are reversed along clockwise order, so at least 1 of those statements must be wrong.
<br><br>
Anyone who has the whole forest under any 1 of those fns can compute all the others using the step func,
but the point of this is to statistically prove that someone else already computed that so
others dont have to. We instead would, not trust their claim, but turingCompleteChallengeResponse
eachother about many unexpected combos of quines and find the largest ever-growing set of
statements that dont contradict eachother.
<br><br>
Statements about quines will normally have 3 points on each of 2 quines,
as a way to publish quines that otherwise nobody would be looking for but they might
find them useful after they receive it along with the 3 points they are interested in,
and it will have a proofOfWork (1/asInteger(sha3_256(anythingToHash)))
where anythingToHash is concat(a,b,c,x,y,z,salt) where a b c are 3 fn ids on one quine
and x y z are 3 fn ids on the other quine and salt is a fn id normally some randomly chosen bits
so you have as many tries as you want to find a higher proofOfWork.
<br><br>
We will tend to believe that things are quines (not necessarily the funcParamReturnProving kind of quine)
the lower the total energyFunction of the whole system gets, where energy is (negative) sum of proofOfWorks
which can all be true together, so looking for a larger weighted clique as in NP math,
not the exact best solution which is too hard a puzzle to solve but just converging toward
better solutions which may, in theory, converge the correctness of what we believe toward 1-epsilon chance.
*/
public interface QuineEdge{
	
	/** points().get(whichQuine).get(whichSparsePointOnThatQuine).
	For correct gameTheory of turingCompleteChallengeResponse,
	theres at least 2 quines and at least 3 points each, per (this class) QuineEdge,
	and many QuineEdges of a variety of pairs of quines and variety of sparse points on each,
	such as you can use it to binarySearch the step sequence in a quine's infiniteLoop
	by continuing to ask a peer for more QuineEdges.
	*/
	public List<List<fn>> points();
	
	/** This can be anything and is used to look for higher proofOfWork for the same List<List<fn>>. */ 
	public fn salt();
	
	/** This proofOfWork only counts toward total energy of the system
	(Subtract this from it cuz things roll down high dimensional hills toward lower potentialEnergy) IF it
	doesnt contradict any of the other QuineEdges whose proofOfWork is summed into that,
	so looking for a clique of proofOfWorks to sum that fit the puzzle together.
	There is no amount of compute power you can pay to make peers permanently believe a false statement
	(a part or combo of the puzzle that doesnt fit) but you can trick some of them temporarily,
	which is why its converging toward truth in how the puzzle fits together on a large scale.
	Some parts of this system must be gamingLowLag so they'll need to use functions that
	are easier to prove to eachother or just do <func,param,return> caching locally
	and only share the halted binary forest of <func,param>
	instead of halted-or-evaling callquads <func,param,stack,cacheKey>.
	Technically you dont need proofOfWork to solve the puzzle, but its an infinite size puzzle
	of the space of all possible functions and stack states while evaling them
	so proofOfWork is a way for peers to show eachother which combos to look at
	without being able to flood the network with a bunch of things that not much compute time or thought was put into.
	Computing toward solving the puzzle will, in the gameTheory, tend to be near proportional to
	computing time spent on proofOfWork, or something similar, such as maybe 10% of the compute time
	would be on proofOfWork and 90% toward puzzle solving.
	*/
	public double proofOfWork();
	
	/** used for calculating proofOfWork. You can use multiple idMakers (kinds of id) at once
	in the system in general, but each QuineEdge is for a specific idMaker cuz thats needed for proofOfWork.
	*/
	public fn idMaker();
	
	/** FIXME move these to a class wrapping just the inner List<fn> of List<List<fn>>
	and this is null unless its known that its for a specific func param ret.
	*
	public fn func();
	
	public fn param();
	
	public fn ret();
	
	/** How certain is it that (func param)->ret *
	public double certainty();
	*/

}