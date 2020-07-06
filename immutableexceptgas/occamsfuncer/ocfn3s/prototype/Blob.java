/** Ben F Rayfield offers this software opensource MIT license */
package immutableexceptgas.occamsfuncer.ocfn3s.prototype;
import java.lang.reflect.Array;

import immutable.occamsfuncer.ocfn3s.spec.Compiled;
import immutable.occamsfuncer.ocfn3s.spec.fn;

public class Blob<T> implements fn{
	
	/** inclusive from index in array, exclusive to index in array */
	public final int from, to;
	
	/** ((pair funcsParam) param) aka (pair funcsParam param). func is (pair funcsParam) and TODO there will be
	an optimization where its skipped by some funcs that directly return funcsParam but dedup and hashing still works the same.
	*/
	protected fn func, funcsParam, param;
	
	/** 1d primitive array such as int[] or double[]. Shared between multiple Blobs. Dont modify its contents, but you have access to it for efficiency. */
	public final T array;
	
	public Blob(T array){
		this(array, 0, Array.getLength(array));
	}
	
	public Blob(T array, int from, int to){
		this.array = array;
		this.from = from;
		this.to = to;
	}
	
	//FIXME what about stack()? Does Blob ever have that? Should it be another class that wraps Blob and gives it the extra ptr or is that just Call?
	
	public fn func(){
		/*if(func == null){
			//can use cp instead of pair.f(funcsParam()).eval() cuz know its halted,
			//and func() and param() and stack() must always return in constant time, so they're not allowed to call eval.
			func = cp(null,pair,funcsParam());
		}
		return func;
		*/
		throw new Error("TODO");
	}
	
	public fn funcsParam(){
		if(funcsParam == null){
			if(from+1==to){
				throw new Error("TODO SmallBlob");
			}else{
				funcsParam = new Blob(array, from, (from+to)>>1);
			}
		}
		return funcsParam;
	}
	
	public fn param(){
		if(param == null){
			if(from+1==to){
				throw new Error("TODO SmallBlob");
			}else{
				param = new Blob(array, (from+to)>>1, to);
			}
		}
		return param;
	}

	public fn stack(){
		return null;
	}

	public fn step(){
		return this;
	}

	public Compiled compiled(){
		throw new Error("TODO");
	}

	public void setCompiled(Compiled c){
		throw new Error("Cant setCompiled on Blob");
	}

	public boolean isLeaf(){
		return false;
	}

	public boolean isHalted(){
		return true;
	}

	public boolean isCbt(){
		return true;
	}

	public boolean isParentsFunc(){
		return false;
	}

	public boolean isParentsParam(){
		return false;
	}

	public long j(long bitIndex){
		throw new Error("TODO");
	}

	public long bize(){
		throw new Error("TODO");
	}

	public fn cacheKey(){
		throw new Error("TODO");
	}

}
