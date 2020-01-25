/** https://github.com/benrayfield/occamsfuncer
V2 has no comment param in any of the 16 ops and instead
has 3 childs instead of how V1 has 2 childs,
and the third child is read and written by 2 ops
which replaced the ifElse and lazig ops which
are instead derived in Example.java
and can be (in Boot.optimize(), TODO) optimized to
the same speed as if they were ops.
<br><br>
OLD...
<br><br>
Different universal lambda functions get different occamsfuncer
version numbers, such as occamsfuncerV1,
and this (incomplete, TODO get same testcases working) is occamsfuncerV2.
Theres nothing wrong with V1. It computed (equals equals equals)==T
where equals is Example.equals() and is a certain lambda func.
Theres nothing wrong with the math of it, but V2 redefines
15 of the 16 ops to have a place to put a Human readable comment,
like V1 already has that in the getp op (which still has diff behaviors
cuz it takes what curry generates as its param and curry has
an extra param of comment)
aka (getp comment cbtAsUnary thingMadeByCurry).
Its trivial to put comment in most of the ops
such as identityFunc aka "I" will still work
if you use (I anyComment) as identityFunc instead of I directy.
There will be Compiled.java optimizations of each of the 16 ops
in the case where comment is leaf (write leaf as .).
But I'm uncertain how it will work with these ops:
-- curry, cuz its first param needs to be cbtAsUnary
	to instantly choose the number of params aka fn.cur().
-- cbt0 and cbt1, cuz they are optimization of bitstrings (either just a complete binary tree or the way of using them that the last cbt1 is not part of the bitstring and is padded with cbt0s until the next powOf2, and way of using them means whatever is derived from the universal lambda that takes cbt as param andor returns cbt.
--- how Op.ifElse will work with (T comment) vs (F comment) as its param.
	or does it use T and F directly?
...
Maybe the simpler ops such as T F cbt0 cbt1 etc should not have comment?
No, V2 will have EVERY op (16 of them) have a comment as first param
(default comment is leaf, most optimized).
*/
package immutableexceptgas.occamsfuncerV2Spec;