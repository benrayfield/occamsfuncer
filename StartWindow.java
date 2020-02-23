import java.io.OutputStream;

import immutableexceptgas.occamsfuncerV2Prototype.test.TestBasics;
import immutableexceptgas.occamsfuncerV2Prototype.util.Example;
import immutableexceptgas.occamsfuncerV2Spec.Gas;
import immutableexceptgas.occamsfuncerV2Spec.fn;
import mutable.occamsfuncerV2Prototype.ui.OccamsfuncerUI;

public class StartWindow{
	public static void main(String[] args) {
		Gas.top = 1L<<53;
		Gas.forceDeterminism = false;
		//FIXME load and save uiState between runs of JVM
		//and allow multiple states to exist which may share branches.
		fn uiState = loadOrCreateUiState();
		OccamsfuncerUI ui = new OccamsfuncerUI(uiState);
	}
	
	/** for now it only creates new */
	public static fn loadOrCreateUiState(){
		return Example.default_OccamsfuncerUI_state();
	}
	
	public static void saveUiState(OutputStream out){
		throw new Error("TODO");
	}
}
