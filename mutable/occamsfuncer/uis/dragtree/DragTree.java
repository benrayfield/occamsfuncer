package mutable.occamsfuncer.uis.dragtree;
import static mutable.util.Lg.*;
import static immutable.occamsfuncer.simpleSlowPrototype.OcfnUtil.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.security.SecureRandom;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.function.Function;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import immutable.occamsfuncer.fn;
import immutable.occamsfuncer.simpleSlowPrototype.OcfnUtil;
import mutable.util.Rand;
import mutable.util.ScreenUtil;
import mutable.util.Time;

public class DragTree extends JPanel{
	
	/*Or maybe it should be a 2d grid of pair(char,fn) and various ui stuff transforms it to a different 2d contents of pair(char,fn)s
	such as to resize the border rectangle of a certain fn inside which some fns reachable from it are.
	TODO DTNode will have these fields:
		double split
		boolean hasBorder //name/text is only displayed (along top and left borders) if hasBorder, else need to act on parent to see it
		boolean horiz
		fn data
		DTNode L
		DTNode R
	Ocns //maps between fn and String, for display in 2d grid of pair(char,fn)
	final double charHeight, charWidth;
	Create a toolbar or 2d grid of ~100 of these, in half the screen, using tree made of pairs with borders hidden so you only
	see the grid rectangles, which you can drag anything to and it will be instantly halted cuz its just a tree with that in it,
	and the big area on the other half of the screen is the main fn you're editing, using that workspace/toolbar/etc for
	temp dragAndDrop.
	...
	Represent this as immutable forest of DTNode? implement dtnode in fn? cant do that yet cuz fns arent optimized yet.
		If I got just SmallBlob (wraps a byte for height and long for up to cbt64) optimized, DTNode could be made of fns,
		and use a specific bigcall* as semantic for dtnode, or use typeval. So DragTree would have 1 fn as its state. 
		
	TODO DTNode will have these fields:
		int borderColorARGB
		boolean hasBorder //(a b c d e) is ((a b c d) e) so the outer (abcd e) has 2 things so just display its border.
		//double borderThickness //in units of fraction, ceil so min 1 pixel thick
		//Rect insideBorder //in units of fraction
		double split //in insideBorder
		boolean horiz //in insideBorder
		fn data
		
	TODO try this... where border exists at node n, if there is a #localname of n, display the first char of its name at its top left corner
		and its second char in 2 places which are 1 char right and 1 char down of that and so on along the top and left borders,
		but not past its display rect, like its border is 1 char wide. If it has no #localName then just display @ in its top left corner
		or maybe display "@"+identityHashCode. Top left corner where border exists is a different color.
	Maybe the first char of display name tells which kind of syntax it is, such as ( or { or [ or ` or IF or thenConst etc, then a space.
	     Naturally ] or } or ) etc would go at the bottom right corner BUT i only want to display the top and left of borders? Try both.
	Maybe I want the { at top left and } at bottom right displayed and to be able to mouse drag either of them
		to recursively resize parents toward whatever it thinks user wants?
	Or maybe it should be a 2d grid of pair(char,fn) and various ui stuff transforms it to a different 2d contents of pair(char,fn)s
		such as to resize the border rectangle of a certain fn inside which some fns reachable from it are.
		
	TODO try this... always have space for all borders displayed, 4 pixels thick (black bright darker black of some colorvec)
		but display whole border as black if !hasBorder, and display the hidden nodes as just a border but nothing inside them
		and can look deeper inside by holding mouse on the border, or something like that.
		{} () [] ` IF thenT thenConst etc are different colorvecs of border.
		Grab border and drag it.
	
	TODO DTNode have 2 child rects whose x y w h are in units of fraction and are scaled relative to a parent rect,
	which obsoletes indent and horiz and split fields.
	And I might want Rect to be xStart yStart xEnd yEnd.
	And I might want DTnode to auto display a border of borderThicknessFraction if the 2 childs arent overlapping it,
	And I might want DTNode to display 2 borders, 1 is the smallest border that fits around the 2 childs together
	and the other is its outer border?
	Maybe the left side of some borders is an indent? How about separate size of the 4 sides of each border?
	Should UILists ((){}[]`) display one side brighter than the other so you know the direction (down vs right)?
	Should the bintree parts of a UIList have some parts of their border as 0 width or 0 height but the 2 other sides nonzero,
		else they need to be inside something else which displays its border. 
	
	TODO I want 4 colors of rectangle border, a few pixels thick, for () {} [] and `,
	and I want a way to grab any call pair (a b) within a () or {} or [] or `,
	and I want a way to say you want more or less detail in a certain node to change its display size.
	```x would be 3 rectangles around x.
	The same way could have rectangle border colors for IF, thenT, thenConst, etc,
	which are things I wrote in java files to more intuitively build fns.
	
	TODO I might want there to be simpler DTNodes that have no ident and can be simply 1 side of a rectBorder
	which is very thin and the other side is most of the area, and each DTNode would be either horizontal or vertical split
	with only a double fraction dividing the area between those, instead of having DTNode.indent be a third thing.
	
	TODO I might need various controls inside DTNodes so more than 2-3 things?
	*/
	
	protected DTNode root;
	
	/** #names have no effect on global id but do affect display. They are names of constant fns. There are no variables cuz everything is constant.
	You can still forkEdit treemap to share names but multiple treemaps can disagree on the names, and every forkEdited treemap state has a global id.
	All globalIds are lazyEvaled for efficiency since most objects never need one.
	A globalId maker is any fn which when given any fn returns a cbt512 or other consistent size of bitstring or cbt.
	A bitstring is a cbt excluding the last 1 bit and 0s after it as padding.
	<br><br>
	TODO 
	*/
	protected WeakHashMap<fn,String> localNames = new WeakHashMap<fn,String>();
	
	/** does not dedup, so multiple of the same forest shape of call pairs could have different names temporarily until deduped */
	public boolean hasName(fn x){
		return localNames.containsKey(x);
	}
	
	/** else null. does not dedup, so multiple of the same forest shape of call pairs could have different names temporarily until deduped */
	public String name(fn x){
		return localNames.get(x);
	}
	
	/** does not dedup, so multiple of the same forest shape of call pairs could have different names temporarily until deduped */
	public void name(fn x, String newName){
		localNames.put(x, newName);
	}
	
	public DragTree(fn x){
		this(new SimpleDTNode(null,x));
	}
	
	/** this is an editor andOr viewer of fn wrapped in a DTNode */
	public DragTree(DTNode root){
		//setFocusable(true); //to allow keylistener
		/*addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e){
				throw new RuntimeException("TODO");
			}
			public void keyReleased(KeyEvent e){
				throw new RuntimeException("TODO");
			}
			public void keyPressed(KeyEvent e){
				throw new RuntimeException("TODO");
			}
		});*/
		/*addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e){
				repaint();
			}
			public void mouseDragged(MouseEvent e){
				mouseMoved(e);
			}
		});*/
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){
				//System.out.println("click "+Time.now());
				//double start = Time.now();
				DTNode n = nodeAt(e.getX(), e.getY());
				//System.out.println("clicked n="+n);
				if(n != null){
					onclick(n, e.getButton());
				}
				//double duration = Time.now()-start;
				//System.out.println("click time "+duration);
			}
			public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		});
		addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent e){
				DTNode n = nodeAt(e.getX(), e.getY());
				if(n != null){
					//Some computers or mouses have very different scales of mouse wheel amount
					//or they always do amount of -1 or 1 but different amounts of it.
					//FIXME needs norming over time. TODO copy code from listweb, but that code sometimes makes it go too fast or slow
					//and gets stuck doing that, so needs more adjustment to the stat algorithm.
					double amount = e.getPreciseWheelRotation()*.1;
					onMouseWheel(n, amount);
				}
			}
		});
		//TODO drag events. copy some code from listweb
		setDTNode(root);
	}
	
	/** when drag a DTNode onto another DTNode, returns the next top DTNode that would result, without actually modifying the top.
	Each DTNode has a fn. It forkEdits the binary forest of call pairs, to get a lazyEval, then tries to eval it,
	and if it returns fast enough (such as less than 1 second, normally less than .02 second, sometimes .000001 second)
	then it worked and creates/finds a fn.
	
	TODO drag currying like in iotavm.
	*
	public DTNode drag(DTNode from, DTNode to){
		
	}*/
	
	public void setDTNode(DTNode root){
		this.root = root;
		repaint();
	}
	
	/** else null */
	public DTNode nodeAt(double x, double y){
		return nodeAt(x, y, topRect(), root);
	}
	
	/** else null */
	protected DTNode nodeAt(double x, double y, Rect rect, DTNode node){
		if(rect.containsXY(x, y)){
			if(node.hasChilds()){
				DTNode recurseL = nodeAt(x,y,node.LRect(rect),node.L());
				if(recurseL != null) return recurseL;
				DTNode recurseR = nodeAt(x,y,node.RRect(rect),node.R());
				if(recurseR != null) return recurseR;
			}
			return node; //if has no childs or if has childs but neither intersects (x,y)
		}else{
			return null;
		}
	}
	
	public Rect topRect(){
		return new Rect(0., 0., getWidth(), getHeight());
	}
	
	public void paint(Graphics g){
		//double start = Time.now();
		//System.out.println("paint starting");
		g.setColor(Color.black);
		//g.setColor(new Color(ScreenUtil.randColor()));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Rect topRect = topRect();
		Function<DTNode,String> toString = (DTNode node)->{
			fn d = node.data();
			String name = name(d);
			return name==null ? d.toString() : "#"+name;
			//return name==null ? "?"+System.identityHashCode(d) : "#"+name;
		};

		paint(g, root, topRect, toString);
		
		
		//paintLinesBetweenCenterOfParentToCenterOfEachChild(g, root, topRect, Color.green, Color.blue);
		//double end = Time.now();
		//double duration = end-start;
		//System.out.println("Paint time "+duration);
	}
	
	static Random rand;
	static{
		rand = new SecureRandom(); //TODO mutable.util.Rand.strongRand
		rand.setSeed(System.nanoTime()+System.currentTimeMillis()*new Object().hashCode()+17);
	}
	
	/** x y w and h are in units of pixels, but in DTNode they are relative fractions */
	public void paint(Graphics g, DTNode node, Rect rect, Function<DTNode,String> toString){
		//in case its too deep, dont waste on things smaller than a pixel,
		//but still want that pixel drawn if theres only 1 thing smaller than a pixel to draw in it, so using .3 instead of 1
		
		//if(rect.w < .3 || rect.h < .3) return;
		DTNode lNode = node.l();
		DTNode rNode = node.r();
		if((lNode != null) != (rNode != null)) throw new RuntimeException("Both childs must be null or both nonnull");
		boolean displayChilds = lNode != null;
		boolean displaySelf = true;
		//boolean displaySelfText = !displayChilds;
		boolean displaySelfText = displaySelf;
		//boolean displaySelf = !displayChilds; //!displayChilds?
		
		if(displaySelf) {
			
			//g.fillRect((int)rect.x, (int)rect.y, Math.max((int)rect.w,1), Math.max((int)rect.h,1));
			//System.out.println("fillrect "+rect+" color="+g.getColor()+" "+Integer.toHexString(color));
			
			//String s = ""+System.identityHashCode(node.data());
			//String s = node.data().toString();
			String s = toString.apply(node);
			
			//Rect insideBorder = node.insideBorder(rect);
			//g.setClip((int)insideBorder.x, (int)insideBorder.y, (int)insideBorder.w, (int)insideBorder.h);
			g.setClip((int)rect.x, (int)rect.y, (int)rect.w, (int)rect.h);
			
			//g.setClip((int)rect.x, (int)rect.y, (int)rect.w, (int)rect.h);
			//g.setColor(Color.gray);
			
			int color = node.colorBG();
			/*
			//int color = 0xff000000 | rand.nextInt(1<<24); //FIXME why is node.colorBG() always 0xff000000 which it starts as?
			g.setColor(new Color(color));
			
			//TODO 4 triangles of 4 different brightnesses, but to optimize dont draw the middle rectangle just draw the borders,
			//considering theres 2 doubles for y and x border thickness per DTNode.
			//This will make it much faster to draw also, or maybe the slowness is caused by having to toString funcs.
			
			//triangle using all 3 corners except bottom right
			g.fillPolygon(
				new int[]{ //x
					(int)rect.x, //top left
					(int)(rect.x+rect.w), //top right
					(int)rect.x //bottom left
				},
				new int[]{ //y
					(int)rect.y, //top left
					(int)rect.y, //top right
					(int)(rect.y+rect.h) //bottom left
				},
				3
			);
			//g.setColor(new Color(color^0xffffff));
			int shadowColor = ScreenUtil.aveColor(color,0xff000000);
			//int shadowColor = ScreenUtil.aveColor(color,ScreenUtil.aveColor(color,0xff000000));
			g.setColor(new Color(shadowColor));
			g.fillPolygon(
				new int[]{ //x
					(int)rect.x, //bottom left
					(int)(rect.x+rect.w), //bottom right
					(int)(rect.x+rect.w), //top right
				},
				new int[]{ //y
					(int)(rect.y+rect.h), //bottom left
					(int)(rect.y+rect.h), //bottom right
					(int)rect.y, //top left
				},
				3
			);
			*/
			
			Rect inner = node.insideBorder(rect);
			
			g.setColor(new Color(ScreenUtil.weightedSumColor(0xff000000, .7f, color)));
			g.fillPolygon(topBorder(rect,inner));
			
			g.setColor(new Color(ScreenUtil.weightedSumColor(0xff000000, .6f, color)));
			g.fillPolygon(leftBorder(rect,inner));
			
			g.setColor(new Color(ScreenUtil.weightedSumColor(0xff000000, .5f, color)));
			g.fillPolygon(rightBorder(rect,inner));
			
			g.setColor(new Color(ScreenUtil.weightedSumColor(0xff000000, .3f, color)));
			g.fillPolygon(bottomBorder(rect,inner));
			
			if(displaySelfText) {
				g.setColor(Color.white);
				//int textColor = 0xff000000 | rand.nextInt(1<<24); //FIXME why is node.colorBG() always 0xff000000 which it starts as?
				//textColor = ScreenUtil.aveColor(textColor, 0xffffffff);
				//g.setColor(new Color(textColor));
				//g.drawString(s, (int)rect.x, (int)(rect.y+rect.h/2));
				g.drawString(s, (int)rect.x+2, (int)((rect.y+g.getFont().getSize2D())));
			}
			
			//border
			//g.drawRect((int)(rect.x+1), (int)(rect.y+1), Math.max((int)(rect.w-3),1), Math.max((int)(rect.h-3),1));
		}
		
		
		
		if(displayChilds){
			paint(g, lNode, node.LRect(rect), toString);
			paint(g, rNode, node.RRect(rect), toString);
		}
	}
	
	public void onMouseWheel(DTNode n, double amount){
		lg("wheel "+amount);
		double targetSplit = amount>0 ? 1 : 0;
		double a = Math.abs(amount);
		double decay = a/(1+a);
		n.split(n.split()*(1-decay)+decay*targetSplit);
		lg("split "+n.split());
		repaint();
	}
	
	public void onclick(DTNode n, int button){
		System.out.println("mouse button "+button);
		
		if(button == 1){ //left click causes 2 childs to exist if they dont already. if they are new, they have no childs of their own.
			if(!n.hasChilds()){
				n.L(); //create/find
				n.R(); //create/find
				n.L().colorBG(ScreenUtil.randColor(Rand.strongRand));
				n.R().colorBG(ScreenUtil.randColor(Rand.strongRand));
				n.split(Rand.strongRand.nextDouble());
				n.horiz(Rand.strongRand.nextBoolean());
				//n.colorBG(ScreenUtil.randColor(Rand.strongRand));
			}
		}else if(button == 2){ //middle click, flip vertical/horizontal layout of 2 childs, if there are childs
			n.horiz(!n.horiz());
		}else if(button == 3){ //right click removes childs
			if(n.parent() != null) n.parent().removeChilds();
		}
		/*if((n.l() != null) != (n.r() != null)) throw new RuntimeException("Both childs must be null or both nonnull");
		boolean hasChilds = n.l() != null;
		if(hasChilds){
			n.removeChilds();
		}else{
			n.expandToDepthNAndRandomizeViews(4, new SecureRandom()); //TODO use Rand.strongRand
		}*/
		repaint();
	}
	
	public void paintLinesBetweenCenterOfParentToCenterOfEachChild(Graphics g, DTNode node, Rect rect, Color lineColorA, Color lineColorB){
		DTNode lNode = node.l();
		DTNode rNode = node.r();
		if((lNode != null) != (rNode != null)) throw new RuntimeException("Both childs must be null or both nonnull");
		if(lNode != null){ //has childs
			g.setColor(lineColorA);
			//g.setXORMode(lineColorB);
			Rect lRect = node.LRect(rect);
			Rect rRect = node.RRect(rect);
			g.drawLine(
				(int)(rect.x+rect.w/2), //parent x
				(int)(rect.y+rect.h/2), //parent y
				(int)(lRect.x+lRect.w/2), //child x
				(int)(lRect.y+lRect.h/2) //child y
			);
			g.drawLine(
				(int)(rect.x+rect.w/2), //parent x
				(int)(rect.y+rect.h/2), //parent y
				(int)(rRect.x+rRect.w/2), //child x
				(int)(rRect.y+rRect.h/2) //child y
			);
			paintLinesBetweenCenterOfParentToCenterOfEachChild(g, lNode, lRect, lineColorA, lineColorB);
			//paintLinesBetweenCenterOfParentToCenterOfEachChild(g, rNode, rRect, lineColorA, lineColorB);
		}
	}
	
	public static void main(String... args){
		fn x = OcfnUtil.Equals(); //FIXME shouldnt depend on any specific implementation of occamsfuncer such as where that OcfnUtil class is
		System.out.println("(todo it will appear exponentially smaller when use #names for shared branches) equals = "+x);
		DTNode node = new SimpleDTNode(null, P.e(x).e(op(12)));
		node.colorBG(0xffcccccc);
		/*node.L().L().L().L();
		node.L().L().L().R();
		node.L().L().horiz(false);
		node.L().L().expandToDepthNAndRandomizeViews(7, new SecureRandom()); //TODO mutable.util.Rand.strongRand
		node.L().L().R();
		node.L().R();
		node.R().L();
		node.R().R();
		*/
		DragTree dtr = new DragTree(node);
		dtr.name(x,"equals");
		for(int i=0; i<32; i++){
			dtr.name(OcfnUtil.op(i), "op"+i);
		}
		ScreenUtil.testDisplayWithExitOnClose(dtr);
	}
	
	/** parallelogram between the tops of the 2 rects */
	public static Polygon topBorder(Rect outer, Rect inner){
		return new Polygon(
			new int[]{(int)(outer.x+outer.w), (int)outer.x, (int)inner.x, (int)(inner.x+inner.w)},
			new int[]{(int)outer.y, (int)outer.y, (int)inner.y, (int)inner.y},
			4
		);
	}
	
	public static Polygon bottomBorder(Rect outer, Rect inner){
		return new Polygon(
			new int[]{(int)(outer.x+outer.w), (int)outer.x, (int)inner.x, (int)(inner.x+inner.w)},
			new int[]{(int)(outer.y+outer.h), (int)(outer.y+outer.h), (int)(inner.y+inner.h), (int)(inner.y+inner.h)},
			4
		);
	}
	
	public static Polygon leftBorder(Rect outer, Rect inner){
		return new Polygon(
			new int[]{(int)outer.x, (int)outer.x, (int)inner.x, (int)inner.x},
			new int[]{(int)outer.y, (int)(outer.y+outer.h), (int)(inner.y+inner.h), (int)inner.y},
			4
		);
	}
	
	public static Polygon rightBorder(Rect outer, Rect inner){
		return new Polygon(
			new int[]{(int)(outer.x+outer.w), (int)(outer.x+outer.w), (int)(inner.x+inner.w), (int)(inner.x+inner.w)},
			new int[]{(int)outer.y, (int)(outer.y+outer.h), (int)(inner.y+inner.h), (int)inner.y},
			4
		);
	}

}
