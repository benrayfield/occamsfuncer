package mutable.util;
/** Ben F Rayfield offers this software opensource MIT license */


import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/** mutable var that listeners can attach to. Verifies class type. */
public class Var<T>{
	
	private T value;
	
	private final Set<Consumer<Var<T>>> listeners = new HashSet();
	
	public T get(){ return value; }
	
	public final boolean callListenersOnlyIfNotObjectEquals;
	
	//TODO MAYBE A RECOGNIZER FUNC AS TYPE, INSTEAD OF CLASS? public final Class<T> varType;
	
	public Var(T firstValue){
		this(firstValue, true);
	}
	
	public Var(T firstValue, boolean callListenersOnlyIfNotObjectEquals){
		this.callListenersOnlyIfNotObjectEquals = callListenersOnlyIfNotObjectEquals;
		//this.varType = varType;
		value = firstValue;
	}
	
	public void set(T newValue){
		if(!callListenersOnlyIfNotObjectEquals || !value.equals(newValue)){
			//if(!varType.isInstance(newValue)) throw new ClassCastException(
			//	"Required type "+varType.getName()+", new value type "+newValue.getClass().getName());
			value = newValue;
			for(Consumer<Var<T>> listener : listeners){
				listener.accept(this);
			}
		}
	}
	
	public void startListening(Consumer<Var<T>> listener){
		listeners.add(listener);
		listener.accept(this); //first event happens instantly
	}
	
	public void stopListening(Consumer<Var<T>> listener){
		listeners.remove(listener);
	}
	
	/** nonbacking array */
	public Consumer<Var>[] listeners(){
		return listeners.toArray(new Consumer[0]);
	}

}
