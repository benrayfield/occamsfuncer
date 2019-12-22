/** https://github.com/benrayfield/occamsfuncer
Different universal lambda functions get different occamsfuncer
version numbers, such as occamsfuncerV1,
and this (incomplete, TODO get same testcases working) is occamsfuncerV2.
Theres nothing wrong with V1. It computed (equals equals equals)==T
where equals is Example.equals() and is a certain lambda func.
Theres nothing wrong with the math of it, but V2 redefines
each of the 16 ops to have a place to put a Human readable comment,
like V1 already has that in the getp op
aka (getp comment cbtAsUnary thingMadeByCurry).
Its trivial to put comment in most of the ops
such as identityFunc aka I will still work
if you use (I anyComment) as identityFunc instead of I directy.
There will be Compiled.java optimizations of each of the 16 ops
in the case where comment is leaf (write leaf as .).
But I'm uncertain how it will work with these ops:
-- curry, cuz its first param needs to be cbtAsUnary
	to instantly choose the number of params aka fn.cur().
-- cbt0 and cbt1, cuz they are optimization of bitstrings (either just a complete binary tree or the way of using them that the last cbt1 is not part of the bitstring and is padded with cbt0s until the next powOf2, and way of using them means whatever is derived from the universal lambda that takes cbt as param andor returns cbt.
*/
package immutableexceptgas.occamsfuncerV2;