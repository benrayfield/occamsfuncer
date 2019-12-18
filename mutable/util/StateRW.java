package mutable.util;
import immutableexceptgas.occamsfuncer.fn;

/** STATE Reading and Writing as occamsfuncer objects (fn),
an alternative to java.io.Serializable.
Similar to Var<fn> but without the events.
<br><br>
WARNING: dont let occamsfuncer instantiate just any class name
or call just any java code etc, unless you trust the data
in the fn (occamsfuncer object), since this use of it
crosses outside sandbox by allowing it to execute java code.
It has turingCompleteness (and TODO opencl and other optimizations)
inside the global sandbox, so dont restore state from
any object you dont trust.
<br><br>
Serializable also knows the class name.
Maybe the fn should be (pair classInfo otherState)
where classInfo might be a string (cbt bitstring of utf8)
or might have the java field types or something like that,
but probably the class name  
<br><br>
I'm unsure if can get access to the private fields etc,
and am uncertain if this should be designed to work on
webs of objects with cycles (would need to allocate ids for them
since finding normed form in graphIsomorphism is npcomplete).
In the worst case you implement the funcs to read and write state
where state is in java memory etc and can be copied to/from fn.
<br><br>
This has the advantage of being forest based
so the serialized form of multiple objects can
share subobjects even if they are serialized
in different systems across the world, different *.ocfn files, etc.
*.ocfn is the file extension of a file type I havent yet
defined as of 2019-12 but I have defined the behaviors
of the binary forest in all except a few edge cases
involving forests of height1 to height3 as ops are at height4.
*/
public interface StateRW{
	
	public fn getState();
	
	public void setState(fn state);

}
