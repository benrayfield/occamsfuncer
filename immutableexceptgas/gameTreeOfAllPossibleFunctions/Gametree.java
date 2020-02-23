package immutableexceptgas.gameTreeOfAllPossibleFunctions;

public interface Gametree<T>{
	
	/** branching factor of every node */
	public int size();
	
	public Gametree<T> get(int i);
	
	public T state();

}