package immutable.occamsfuncer.simpleSlowPrototype.lang;

/** see the ( ) { } [ ] ` syntax of Lang.java. A fn->Syntax mapping is a cache of how to
display those sparsely, like (pair a)->someSyntax in (pair a [b c]), and [b c]->someOtherSyntax,
and pair->aSyntax. Syntax of parent is derived from 2 child syntaxes (of func/L and param/R childs,
TODO verify that still works for leaf whose 2 childs are identityFunc and leaf).
<br><br>
(a b c) equals ((a b) c). (a) equals a. () equals identityFunc?
TODO should this syntax be limited to at least 2 in the list (a b)?
<br><br>
{x y z} equals {{x y} z} equals (S (S x y) z). {x} equals x. {} equals TODO_I_DONT_KNOW.
TODO should this syntax be limited to at least 2 in the list {a b}?
{w x y z} equals {{{w x} y} z} equals (S (S (S w x) y) z).
<br><br>
[a b c] equals (pair a [b c]). [c] equals (pair c leaf/u). [] equals leaf/u.
This syntax is at least 0 in the list [].
<br><br>
Therefore everything can be written as [ ] { } ( ) only, starting from [] equals leaf/u,
like ([][]) is calling leaf on leaf.
<br><br>
```x equals (T (T (T x))). Its often used as {`x y z} aka OcfnUtil.ST(x,y,z).
TODO or use a different char than `? How about .? {.x y z} or {$x y z}.
Cant be . cuz want that syntax for things like x.y.z like most languages use it.
I dont want to use ' or " for that cuz many text editors understand stringliterals,
and I might use ' for a comment syntax like (a b c)#name'the comment',
but do I mean the comment param (of the 15 param universalFunc) or an external fn->String comment
like might be stored in listweb/mindmap?
And should name and comment be merged where name is the prefix of the comment and theres some delimiter
like (a b c)#name:the%20comment ... no that doesnt handle whitespace well.
<br><br>
Syntax is ignored where a node is displayed as a name since we dont want to display it multiple places
except where user requests it, since that would result in exponential code size for linear size in memory.
<br><br>
Nodes are lazyDeduped so its possible for 2 equal nodes to have different #localNames,
and some Comparator<String> (such as choose the shortest and break ties by normal string compare) would choose which to keep.
<br><br>
[a b [x y z]#rr c rr rr] is an example of a fn being multiple places aka shared forest branch, a shared pointer or (until dedup) duplicate.
Its [a b [x y z] c [x y z] [x y z]] and the #rr has no effect on id or equals.
*/
public enum Syntax{
	
	/*Consider using an int of mask instead of enum Syntax, to say which set of things it could be,
	and (int,int)->int func for deriving parent syntax from 2 child syntaxs.
	Number of curries left before eval ranges 0 to 15 so fits in 4 bits. If its 15, then its leaf. If its 0 then its lazy.
	Could also put 16 bits in for are the L and L.L and L.L.L... each leaf or not which is a cache of the opcode
	being in the first 5 of 15 params, and shift those down each curry.
	
	FIXME what about nodes that have a nonempty comment param?
			
	FIXME what about extra long lists? They can be broken into smaller parts by using ( ) in some places
		like [a b c] equals (pair a [b c]).
			
	FIXME 2 childs being curryList can result in syntax of t, f, s, or pair,
	cuz they are all derived from universalFunc, so might need syntax for many of the fns below height 13
	but (depending on how comment param etc is handled) only a certain prefix like see the 16 opcodes on github occamsfuncer.
	*/
	
	/** Any fn that has not halted yet, but is still stateless/immutable as a forkEditable snapshot of that. !isHalted.
	Whatever it halts on will have a different Syntax.
	*/
	lazy,
	
	/** T/true */
	t,

	/** F/false */
	f,
	
	/** the S lambda */
	s,
	
	/** the P/pair lambda */
	pair,
	
	/** prefix of T, like ```x equals (T (T (T x))). Its often used as {`x y z} aka OcfnUtil.ST(x,y,z). */
	tOfOneParam,
	
	/** (a b c) equals ((a b) c). Lambda calls. */
	curryList,
	
	/** Example: (S L) */
	sOfOneParamThatsNotASCurryList,
	
	/** Example: (S (S x y)) which when called on z is {x y z} aka (S (S x y) z).
	Example: (S x). FIXME x might be the first thing in {x y z...} so not have to be a sOfOneParamThatsASCurryList.
	*/
	sOfOneParamThatsASCurryList,

	/** {x y z} equals {{x y} z} equals (S (S x y) z) */
	sCurryList,
	
	//FIXME conflicts between linkedlist and cbt and maybe currylist?
	pairOfOneParam,

	/** [a b c] equals (pair a [b c]). [c] equals (pair c leaf/u). [] equals leaf/u. */
	linkedList,
	
	//FIXME conflicts between linkedlist and cbt and maybe currylist?
	pairOfOneParamThatsCbt,
	
	cbt;
	
	//public static final Syntax ofLeaf = TODO;
	
	/*public static Syntax ofChilds(Syntax L, Syntax R){
		switch(L){
		case lazy:
			return lazy;
		case pairOfOneParam:
			switch(R){
			case lazy: return lazy;
			case curryList: return 
			case sCurryList:
			case linkedList:
			}
		case curryList:
			switch(R){
			case lazy: return lazy;
			case curryList: return 
			case sCurryList:
			case linkedList:
			}
		case sCurryList:
			switch(R){
			case lazy: return lazy;
			case curryList: return 
			case sCurryList:
			case linkedList:
			}
		case linkedList:
			switch(R){
			case lazy: return lazy;
			case curryList: return 
			case sCurryList:
			case linkedList:
			}
		}
	}*/

}
