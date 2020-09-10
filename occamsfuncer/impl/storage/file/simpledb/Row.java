package occamsfuncer.impl.storage.file.simpledb;
import java.util.ArrayList;
import occamsfuncer.fn;

public class Row extends ArrayList<fn>{
	
	/** has been saved to the OutputStream since setExists(boolean) changed (including in constructor it setExists to true)? */
	public boolean isSaved(){
		throw new Error("TODO, or should this be done in SimpleDb?");
	}
	
	public void save(){
		throw new Error("TODO, or should this be done in SimpleDb?");
	}
	
	/** setExists(false) then save() appends a "- ...ids in this list..." to the OutputStream in the SimpleDb,
	which instantly defines that it doesnt exist even if it was added earlier in that OutputStream,
	and later a File (its OutputStream to) may be replaced with only the Rows that still exist,
	leaving the rest as a log or deleting it.
	*/
	public void setExists(boolean exists){
		throw new Error("TODO, or should this be done in SimpleDb?");
	}
	
	//TODO disable modify funcs here and in the Iterator

}
