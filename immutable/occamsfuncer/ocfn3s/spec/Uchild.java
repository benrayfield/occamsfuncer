/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.ocfn3s.spec;

/** child pointer type used in various kinds of Ufun */
public enum Uchild{
	
	/** For every x, (func x (param x)) equals x. (func leaf) equals IdentityFunc. (param leaf) equals leaf. */
	func,
	
	/** For every x, (func x (param x)) equals x. (func leaf) equals IdentityFunc. (param leaf) equals leaf. */
	param,
	
	/** 1 lower in stack, state of the stack, efficiently forkEditable for BigO(1) per step */
	stack,
	
	/** first (func param) this part of stack called, before it was replaced by what those returned in the middle of calculations,
	such as (S x y z) becomes ((x z)(y z)) aka (x z (y z)) but its cacheKey is still lazy (S x y) called on z aka (S x y z) with isHalted==false.
	cacheKey holds a normed form that doesnt have any cacheKey of its own and doesnt have stack and doesnt have compareCardinality etc,
	as if it was a call at the bottom of a stack, so if that call happens again (even if inside a stack, it asks about the normed form),
	return from cache instead of doing an exponential number of calculations.
	When it returns, add to cache the mapping: norm(cacheKey) -> return. Return values are already normed
	(FIXME verify, it might be leaving stack on those and its just not breaking anything cuz its not checking their stack)
	cuz for something to return means it doesnt have anything lower on stack to do,
	except if its returning to something in the stack. Thats why I wrote that FIXME to check if its doing that.
	*/
	cacheKey,
	
	/** Cardinality is a unary number in some kinds of universalFunc. If cardinality(func) < cardinality(param)
	then eval to (S I I (S I I)) aka infloop. If cardinality(func) <= cardinality(param) at the last param of a (nondet leaf anything),
	which is either a question or statement about its last param (called on leaf) halting or not,
	THEN eval to (S I I (S I I)) aka infloop cuz questions or statements about halting must be about a lower cardinality than self.
	Everything else allows equal-or-lower cardinality than self.
	leaf aka . is unary number 0. (T anyUnaryNumber) is 1 higher, such as (T (T (T .))) is unary 3.
	<br><br>
	Cardinality is left out of some kinds of universalFunc cuz comparing 2 unary numbers adds complexity
	that cant be done in a single call of step so counts down a pair of unary numbers in this compareCardinality child.
	<br><br>
	compareCardinality is either null or (Pair unaryNumberA unaryNumberB) and is always halted.
	*/
	compareCardinality;

}
