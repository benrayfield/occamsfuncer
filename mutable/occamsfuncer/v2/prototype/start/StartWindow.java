package mutable.occamsfuncer.v2.prototype.start;
import java.io.OutputStream;

import immutableexceptgas.occamsfuncer.v2.prototype.test.TestBasics;
import immutableexceptgas.occamsfuncer.v2.prototype.util.Example;
import immutableexceptgas.occamsfuncer.v2.spec.Gas;
import immutableexceptgas.occamsfuncer.v2.spec.fn;
import mutable.occamsfuncer.v2.prototype.ui.OccamsfuncerUI;

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
