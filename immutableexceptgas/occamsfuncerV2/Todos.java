package immutableexceptgas.occamsfuncerV2;

import javax.xml.stream.events.Comment;

/** this class doesnt do anything. its just a place to put comments.
Get it out of the top level package of occamsfuncer asap,
but I dont want to lose these plans.
todo copy from phonedoc soon to here too.
*/
public class Todos{
	
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
