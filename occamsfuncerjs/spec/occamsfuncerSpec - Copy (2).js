//Like data/occamsfuncer/js/occamsfuncer.js except this is a very slow simple implementation used to solve any disagreements on the correct behavior.
//It must exactly match the [universal lambda function, and pattern calculus function] behaviors of the spec built in java.

//the universal function
var occamsfuncerSpec = function(param){
	//TODO
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
