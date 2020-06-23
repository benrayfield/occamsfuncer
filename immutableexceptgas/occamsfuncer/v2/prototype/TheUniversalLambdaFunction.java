package immutableexceptgas.occamsfuncer.v2.prototype;
import immutableexceptgas.occamsfuncer.v2.prototype.fns.Leaf;
import immutableexceptgas.occamsfuncer.v2.spec.fn;

public class TheUniversalLambdaFunction{
	private TheUniversalLambdaFunction(){}
	
	/** the whole occamsfuncer software can be used from this,
	including the wrapping of large 1d primitive arrays or strings
	such as universalLambdaFunction.f("hello").f(new float[]{...}),
	but you will probably find the 16 fn constants in ImportStatic
	useful as they are the fn form of the 16 ops
	that can be derived each as a few calls of this
	and you will get the same fn by == regardless of
	if you use those constants or if you derive them
	even if you derive them many different ways
	cuz this system has a perfect godel-like-numbering
	that works trivially by each unique binary forest shape
	that leads to 1 leaf is a unique function behavior
	if you could looking into its left and right childs
	and checking is a fn the leaf (Op.isLeaf),
	all of which a fn can measure about another fn
	using only combos of universalLambdaFunction aka leaf.
	To understand these behaviors, look in Op.java and Boot.java.
	*/
	public static final fn instance = Leaf.instance;

}
