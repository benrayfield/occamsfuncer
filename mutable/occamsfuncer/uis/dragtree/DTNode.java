package mutable.occamsfuncer.uis.dragtree;
import java.util.Random;

import immutable.occamsfuncer.fn;

/** dragtree ui is sparse binary tree of these. Multiple of these can be views of the same fn.
Fns are binary forest instead of binary tree, but its a tree view of that forest.
Example: view the OcfnUtil.equals() fn.
<br><br>
There will be a way to name fns, in a 1 to 1 mapping between fn and String using WeakHashMap<fn,String>
and Map<String,WeakReference<fn>> or something like that,
and there will be a place to hook in external storage systems for this metadata such as listweb.
<br><br>
TODO create intuitive views of the ( ) { } [ ] ` syntax in Lang.java,
such as when a Node sees its viewing ((S x) y) then view it as {x y},
and if it sees its viewing ((S ((S x) y)) z) then view it as {x y z}.
The binary tree of Nodes will still be ((S ((S x) y)) z) but some of those parts
(such as the 2 S) will be displayed as 0 size rectangles so you only see the x y and z.
Similar for [x y z] means (pair x (pair y (pair z leaf))). Only x y and z will display there too.
<br><br>
There will be some kind of outline or background color or something like that,
which tells what kind of view you have ( ) or { } or [ ] or `.
<br><br>
There will be a way to grab any part of it at the ( ) level and drag to replace any node anywhere else
or to insert somewhere in a ( ) or in a { } or in a [ ].
<br><br>
There will be a way to find the multiple Nodes which have the same fn as the selected fn
so you can go to where it already has more display space on screen or can expand or collapse some
but not other views of the same fn, or an arrow pointing to its duplicates, etc.
*/
public interface DTNode{
	
	/** the fn this is a view of */
	public fn data();
	
	//TODO insert or delete fn from part of a ( ) or { } or [ ].
	
	public void data(fn x);
	
	/** OLD... fraction of the horizontal space thick on each side of rect thats border, fraction of the smallest of width or height.
	range 0 to .5. Usually very near 0.
	FIXME might need to redesign the border norming math cuz rects are normed to be inside width 1 height 1.
	*/
	public double borderFractionX();
	public double borderFractionY();
	
	public void borderFractionX(double d);
	public void borderFractionY(double d);
	
	/** of whatever space remains after padding, the fraction of it L() is displayed, and 1-fraction for R() display */
	public double split();
	
	public void split(double d);
	
	/** horizontal vs vertical */
	public boolean horiz();
	
	public void horiz(boolean z);
	
	public DTNode parent();
	
	public Rect LRect(Rect parentRect);
	
	public Rect RRect(Rect parentRect);
	
	public default Rect insideBorder(Rect parentRect){
		return parentRect.insideBorder(borderFractionX(), borderFractionY());
	}
	
	/** same as L() except returns null if not found */
	public DTNode l();
	
	/** same as R() except returns null if not found */
	public DTNode r();
	
	/** view of fn().func()/L. Creates if that view not found.. */
	public DTNode L();
	
	/** view of fn().param()/R. Creates if that view not found. */
	public DTNode R();
	
	/** warning: can create exponential number of nodes even if the fn has linear number of nodes that share branches */ 
	public default void expandToDepthN(int n){
		//FIXME offBy1? or 2?
		if(n <= 0) return;
		L().expandToDepthN(n-1);
		R().expandToDepthN(n-1);
	}
	
	public default void expandToDepthNAndRandomizeViews(int n, Random rand){
		//FIXME offBy1? or 2?
		if(n <= 0) return;
		//colorBG(0xff000000|rand.nextInt(1<<24));
		System.out.println("expandToDepthNAndRandomizeViews this="+this+" colorBG="+Integer.toHexString(colorBG()));
		split(rand.nextDouble());
		horiz(rand.nextBoolean());
		if(n > 0){
			L().expandToDepthNAndRandomizeViews(n-1, rand);
			R().expandToDepthNAndRandomizeViews(n-1, rand);
		}
	}
	
	public void removeChilds();
	
	public default boolean hasChilds(){
		//should have both childs or neither
		return l()!=null;
	}
	
	/** intARGB color of background */
	public int colorBG();
	
	public void colorBG(int argb);

}