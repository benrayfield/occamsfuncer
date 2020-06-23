package immutableexceptgas.occamsfuncer.v1.impl.util;

import immutableexceptgas.occamsfuncer.v1.fn;

/** linkedlist of key/value pairs that compares by ==,
so if for example you want to use this to compare by idFuncs
so a fn can cache values for multiple idFuncs
(such as one by sha2-256 and another by sha3-256
either way with some pre and post processing for cbt optimizations etc),
then dedup those idFuncs before using them as a key here.
*/
public final class TinyMap{
	
	//FIXME this might interfere with garbcol (at java level andOr occamsfuncer level)
	
	public final fn key, val;
	
	public final TinyMap next;
	
	public TinyMap(fn key, fn val){
		this(key,val,null);
	}
	
	public TinyMap(fn key, fn val, TinyMap next){
		this.key = key;
		this.val = val;
		this.next = next;
	}
	
	public fn get(fn key){
		if(this.key == key) return val;
		if(next == null) return null;
		return next.get(key);
	}
	
	public TinyMap put(fn key, fn val){
		if(get(key) != val) return put_usuallyForksEvenIfNoChange(key,val);
		return this;
	}
	
	/** Use rem(fn key) to remove. Dont use null val. */
	public TinyMap put_usuallyForksEvenIfNoChange(fn key, fn val){
		//TODO optimize by not creating new TinyMap unless that mapping doesnt exist
		if(this.key == key){
			if(this.val == val) return this;
			return new TinyMap(key, val, next);
		}
		if(next == null) return new TinyMap(this.key,this.val,new TinyMap(key,val));
		return new TinyMap(this.key,this.val,next.put(key,val));
	}
	
	public TinyMap rem(fn key){
		if(get(key) == null) return this;
		return rem_usuallyForksEvenIfNoChange(key);
	}
	
	public TinyMap rem_usuallyForksEvenIfNoChange(fn key){
		//TODO optimize by not creating new TinyMap unless that mapping doesnt exist
		if(this.key == key){
			if(next == null) return null;
			return next;
		}
		if(next == null) return this;
		return new TinyMap(this.key,this.val,next.rem(key));
	}

}