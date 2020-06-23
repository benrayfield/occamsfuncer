package immutableexceptgas.occamsfuncer.v1;

/** this class doesnt do anything. its just a place to put comments.
Get it out of the top level package of occamsfuncer asap,
but I dont want to lose these plans.
todo copy from phonedoc soon to here too.
*/
public class Todos {
	
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
