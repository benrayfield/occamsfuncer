//Like data/occamsfuncer/js/occamsfuncer.js except this is a very slow simple implementation used to solve any disagreements on the correct behavior.
//It must exactly match the [universal lambda function, and pattern calculus function] behaviors of the spec built in java.

//λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz is a made up example, the correct size, of base58 of any 256 bits,
//in this case it will always be the 256 bits of an occamsfuncer MonkeyId256 (See MonkeyId256.java).
//Different id algorithms are named with memorable words instead of numbers, cuz they're not a sequence,
//they're various kinds of ids of the same functions (defined entirely by forest shape) you can use together.

//the universal function
var occamsfuncerSpec = function(param){
	//TODO
};

var NewFn = function(binaryId, func, param, stack, cacheKey){
	this.I = binaryId; //Uint32Array(8) with first 3 ints filled in as as int32 header then zigzag64. last 5 ints are 0 until filled in. TODO put bit somewhere to say if has been filled in or not, since they could actually all be 0s.
	this.L = func;
	this.R = param;
	this.S = stack;
	this.C = cacheKey;
	//generate something like λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz from this.I/binaryId after filling in the last 5 ints of it if not already filled in.
	this.toString = function(){
		TODO λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz base58 of 256 bit MonkeyId. save it in this.idStr if not already saved. return from that cache next time.
		that will cause lazy hashing. also save Uint32Array(8)
	};
};

//func L['λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz']
//never null
var L = {};

//param R['λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz']
//never null
var R = {};

//cacheKey C['λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz'] = some other λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz node;
//often null
var C = {};

//stack S['λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz']
//often null
var S = {};

//blob S['λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz'] it points into (see zigzag64)
//often null
var B = {};

//int32 header H['λ8NPQ4XYZxabcdfJKLhjkmopSzTW9BCEGHqtuJ0246vyz']
//never null
var H = {};

//TODO zigzag64, maybe in 2 int32 parts?


//All calculations are done by 2 fn -> 1 fn,
//other than [optimizations such as using large arrays, gpu, acyclicFlow, etc] which do the same logic but faster in some cases.
//Example: ((metaOp_lazyCall x) y)
//Example: ((metaOp_step x) y)
//Example: (L x)
//Example: (metaOp_cacheKey x)
//Example: (metaOp_asMeta x)
const step = function(x, y){
	TODO
};


maybe better for each to be a new function(...)
