alert("TODO implement at least the ocfn spec in js before the gpu optimized practical one");
alert("TODO occamsfuncer.js occamsfuncer_TODOPortItToJsAfterItWorksInJava_andServeItFromOccamserver(todoUpgradeToHttpKeepaliveAndHttps) Use webasm, GPU.js, htmlCanvas, pointerlock, webcam, WebAudioAPI.ScriptNode, gamepadAPI, ajax, CORS (if possible), websocket (if possible), WebStorage (obsoleted cookies), etc. be compatible with nodejs? The main thing I want is browser js and java versions.");

/** TODO the universal function itself, which creates a new function with every call and can take string or Uint8Array etc params to wrap. */  
//var occamsfuncer = function(param){
var λ = function(param){
	//store pointer to the shared map of cached <func,param,return> in each function?
	//TODO
};

//var u = occamsfuncer;
//var uu = u(u);

//T is bootF(u,u,bootF(u,u),u,u,u, u,u,u,u,u,u,u,u) aka op(8) then 8 u's, so 2 params until eval. (TODO verify that in TestSpec.java)
//var T = u(u)(u)(uu)(u)(u)(u)(u)(u)(u)(u)(u)(u)(u)(u);
var T = λ(λ)(λ)(λλ)(λ)(λ)(λ)(λ)(λ)(λ)(λ)(λ)(λ)(λ)(λ);

var S = TODO;

var pair = TODO;

var iota = pair(S)(T);

alert('iota(iota)("hello") should identityfunc of that string = '+iota(iota)("hello"));

alert('Move all these named vars into a treemap and give that treemap as a single var in a separate js file. The occamsfuncer.js should have only the universal function and optimizations of it, no other named objects.");