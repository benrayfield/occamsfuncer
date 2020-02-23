package mutable.occamsfuncerV2Prototype.ui;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import immutableexceptgas.occamsfuncerV2Spec.fn;
import mutable.occamsfuncerV2Spec.Mut;
import mutable.util.ScreenUtil;

/** has a Var<fn> (actually a Mut<fn>)
that is the ONLY state of occamsfuncer
(other than Gas.top etc), and person interacts with it
thru mouse, keyboard, screen, speakers, microphone,
webcam and gamepadAPI in browser, etc.
In general the fn in that Var is a
"stateful object emulated by stateless/immutable"
which means theVar.get().f(input).f(T) returns nextStateReactingToThatInput
and theVar.get().f(input).f(F) returns returnValueForThatInput,
or maybe I got the T and F backward (FIXME).
For example, theVar.set(theVar.get().f(linkedList("put", "VK_LEFT", 1.)).f(T))
updates theVar to know that the left button on the local keyboard
was pressed, though in an internet system everyone should use a different
prefix such as a datastruct containing their publicKey with "VK_LEFT".
theVar.get().f(linkedList("get", "mainScreen.voxelY10X10R4G4B4")).f(F)
would return a cbt of variable size containing the kind of ints
used by VoxelUi (Y10X10R4G4B4).
You might "put" "pause" as 1 during multiple updates
in case the value of the Var is designed to compute the new value of screen
after each update, and you pushed mutliple buttons or multiple dimensions
of game controller input... then "put" "pause" 0
then "get" "mainScreen.voxelY10X10R4G4B4"
or something like that.
Or maybe the fn in the Var is designed to only compute the screen
when you "get", "mainScreen.voxelY10X10R4G4B4"
instead of storing it in a map. Could happen either way.
Either way, the fn in the Var will be a call of curry that
contains a treemap and forkEdits itself (using recur)
to keep its "mutable object state" immutably/statelessly
in that treemap and optionally multiple treemaps in that treemap
such as one that has keys writable from outside and one thats
only writable by self. Of course you could forkEdit any fn
but the point is if you only call it on various params you create
then it can enforce certain rules designed into itself
so it can do advanced things in ways that the person using it
cant damange nomatter what the person does through this OccamsfuncerUI.
*/
public class OccamsfuncerUI extends JPanel{
		/*TODO contains extends VoxelUI*/
		//TODO contains not implements: implements MouseListener, MouseMotionListener, KeyListener
		/* TODO jsoundcard, browser gamepadAPI thru occamserver, etc*{*/
	
	public final Mut state;
	
	protected BufferedImage image;
	
	public final int w = 1<<10, h = 1<<10;
	
	public void put(Object key, Object value){
		state.apply(ll("put",key,value));
		/*	FIXME call repaint in a loop
		for only the t time after last keyboard/mouse movement?
		Or call it only at such movement?
		*/
		repaint();
	}
	
	public fn get(Object key){
		return state.apply(ll("get",key));
	}
	
	/** value starts as 0 if doesnt have that key */
	public void putPlus(Object key, double add){
		put(key,get(key).d()+add);
	}
	
	public OccamsfuncerUI(fn firstState){
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		setFocusable(true); //for KeyListener
		state = new Mut(firstState);
		addMouseMotionListener(new MouseMotionListener(){
			public void mouseMoved(MouseEvent e){
				put("mouseY",(double)e.getY());
				put("mouseX",(double)e.getX());
			}
			public void mouseDragged(MouseEvent e){
				mouseMoved(e);
			}
		});
		addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e){
				put("mouseButton$"+e.getButton(),0.);
			}
			public void mousePressed(MouseEvent e) {
				put("mouseButton$"+e.getButton(),1.);
			}
			public void mouseExited(MouseEvent e){
				put("mouseIn", 0.);
			}
			public void mouseEntered(MouseEvent e) {
				put("mouseIn", 1.);
			}
			public void mouseClicked(MouseEvent e){}
		});
		addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent e){
				putPlus("mouseWheel", (double)e.getClickCount());
			}
		});
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){
				put("VK$"+e.getKeyCode(), 0.);
			}
			public void keyPressed(KeyEvent e){
				put("VK$"+e.getKeyCode(), 1.);
			}
		});
		/*addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e){
				put("focusIn",0.);
			}
			public void focusGained(FocusEvent e){
				put("focusIn",1.);
			}
		});*/
	}
	
	public void paint(Graphics g){
		fn voxelsCbt = get("mainScreen.voxelsY10X10R4G4B4");
		paint(voxelsCbt, g);
	}
	
	protected void paint(fn voxelsCbt, Graphics g){
		paint(ints(voxelsCbt), g);
	}
	
	public int[] ints(fn voxelsCbt){
		throw new Error("TODO");
	}
	
	protected void paint(int[] voxels, Graphics g){
		WritableRaster wr = image.getRaster();
		DataBufferInt buffer = (DataBufferInt) wr.getDataBuffer();
		int size = h*w;
		for(int i=0; i<size; i++){
			buffer.setElem(0, 0xff000000);
		}
		int imageW = image.getWidth(), imageH = image.getHeight();
		for(int v : voxels){
			int address = v>>>12;
			int c = ((v&0xf00)<<12) | ((v&0xf0)<<8) | ((v&0xf)<<4);
			int color = 0xff000000 | c;
			buffer.setElem(address, color);
		}
		ScreenUtil.paintOGIYXHW(this, g, image, 0, 0, getHeight(), getWidth());
	}

}