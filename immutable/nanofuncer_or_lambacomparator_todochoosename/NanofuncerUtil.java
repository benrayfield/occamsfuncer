package immutable.nanofuncer_or_lambacomparator_todochoosename;

public class NanofuncerUtil {
	
	//TODO use the 6 param universalFunc at https://github.com/benrayfield/lambdacomparator
	//instead of this possibly slight variation of it. or are they equal?
	//and rename this to lambdacomparator? or rename lambdacomparator to nanofuncer?
	
	
	/* but its far harder to optimize than occamsfuncer.
	
	the universal lambda function which is also a pattern calculus function, which I believe has smallest kolmogorov complexity is...

	It always takes 6 parameters, which are made of combos of itself (in a binary forest of call pairs)...
	
	Depending on the first 3 parameters, whether each of them isLeaf or NOT_isLeaf (where leaf means the universal function itself), it does these 8 things with the next 3 of 6 params...
	
	(0) La.Lb.Lc.Ld.Le.Lf.(leftChild f) //as in patternCalculus, where (leftChild x (rightChild x)) equals x for all possible x.
	
	(1) La.Lb.Lc.Ld.Le.Lf.(rightChild f) //as in patternCalculus, where (leftChild x (rightChild x)) equals x for all possible x.
	
	(2) La.Lb.Lc.Ld.Le.Lf.e //K as in SKI calculus, aka True in Church Encoding of lambdas
	
	(3) La.Lb.Lc.Ld.Le.Lf.f //False (if 2 curries left) or IdentityFunc (if 1 curry left)
	
	(4) La.Lb.Lc.Ld.Le.Lf.(isLeaf f) //as in patternCalculus, returns True or False depending if f is the universal function or not.
	
	(5) La.Lb.Lc.Ld.Le.Lf.df(ef) //S as in SKI calculus
	
	(6) La.Lb.Lc.Ld.Le.Lf.fde //pair as in Church Encoding of lambdas
	
	(7) La.Lb.Lc.Ld.Le.Lf.d(pair e f) //how to build lambdas of any number of parameters. This is funcBody d called on 2 params e and f. Can accumulate linkedlist in e by recursively calling itself.
	
	This is a simpler, and far less efficient form, of the 15 parameter universal function that is occamsfuncer,
	BUT its far harder to optimize than occamsfuncer.
	*/

}
