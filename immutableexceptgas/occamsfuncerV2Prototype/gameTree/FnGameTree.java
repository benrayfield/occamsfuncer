package immutableexceptgas.occamsfuncerV2Prototype.gameTree;
import java.util.List;
import immutableexceptgas.gameTreeOfAllPossibleFunctions.Gametree;
import immutableexceptgas.occamsfuncerV2Spec.fn;

public class FnGameTree implements Gametree<fn>{
	
	public final fn state;
	
	public final List<fn> actions;
	
	public FnGameTree(fn state, List<fn> actions){
		this.state = state;
		this.actions = actions;
	}

	public int size(){
		return actions.size();
	}

	public Gametree<fn> get(int i){
		return new FnGameTree(actions.get(i).f(state), actions);
	}

	public fn state(){
		return state;
	}

}
