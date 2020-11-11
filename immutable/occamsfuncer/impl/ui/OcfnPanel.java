/** Ben F Rayfield offers this software opensource MIT license */
package immutable.occamsfuncer.impl.ui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.dnd.DropTarget;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import static mutable.util.Lg.*;
import javax.swing.JPanel;

import immutable.occamsfuncer.fn;
import mutable.util.ScreenUtil;
import mutable.util.Var;

/** all inputs and outputs are controlled by a fn currentState which, given inputs, returns its next state and outputs.
Occamsfuncer is a sandbox, so this doesnt give it access to your private files or ability to network to computers
that have not opted into this protocol except to ask them if they do and check robots.txt etc.
You dont need a UI for occamsfuncer, can run only as a server (TODO), or only on local commandline, or any combo.
TODO choose some datastruct of treemap (in the fn) for the various things it reads and writes.
*/
public class OcfnPanel extends JPanel{
	
	/*TODO create a Compiled.java optimization for some simple graphics mode, like painting colored circles of varying x y and radius,
	with a string inside them, just to get started. The only graphics mode is for fn to choose all the pixels,
	so create a fn which does that exact calculation, then manually optimize the Compiled.java instance and in the VM hook those together,
	which is an optimization, an ugly overly specific one, but I've got to have some way to do the graphics while I'm still building
	the basics of the system, and later compiling will be turingComplete so I wont have to manually do it in overly specific ways.
	*/
	
	/** TODO what datastruct should this be? treemap? */
	public final Var<fn> stateVar;
	
	protected Consumer<Var<fn>> listener;
	
	protected BufferedImage bufImg = null;
	
	/** treemap of string to double */
	protected fn controls;
	
	protected fn inputToState(){
		fn input = theEmptyMap;
		input = mapPut.e(input).e("controls").e(controls);
		//input = mapPut.e("time").e(Time.utcnano());
		return input;
	}
	
	public void nextState(){
		fn state = stateVar.get();
		fn input = inputToState();
		//state.e(input) is intentionally called twice here, which would normally slow most programs to half speed,
		//only for the purpose of demonstrating function call caching. It almost always costs only a few extra microseconds.
		fn output = state.e(input).e(T);
		fn nextState = state.e(input).e(F);
		stateVar.set(nextState);
		
		/*FIXME what to do with output? the painter function is in there somewhere.
		paint(Graphics) needs to be updated if state isnt a map anymore (but probably contains that same map).
		*/
		
		
		/*FIXME This seems messy. Maybe I should use the semantic of state.e(input).e(F)->nextState and state.e(input).e(T)->output,
		such as state.e(input)->pair.e(output).e(nextState), though I might want to use the opposite order nextState output.
		I could, using one of the 7 (of 16 or maybe soon 32 including metaOps whose first of 15 params is (leaf leaf))
		opcodes that define a lambda of 1-7 params, easily wrap the treemap in that.
		That semantic is generally useful for any object that takes an input, optionally updates its state, and gives an output.
		
		fn state = stateVar.get();
		//fn nextState = TODO get something out of the state map and call it on some combo of inputToTheState() and state,
		//	or forkEdit the state to have "input" key map to inputToState()
		//	then call state.e("think").e(state);
		//	or something like that.
		
		fn think = state.e("think");
		fn forkEditedStateToHaveInput = mapPut.e(state).e("input").e(inputToState());
		fn nextState = think.e(forkEditedStateToHaveInput);
		stateVar.set(nextState); //triggers listeners, including repaint,
			//TODO triggers jsoundcard, sandboxed interactions with network (make sure to obey robots.txt), etc
		//Like Urbit, this is meant to be a server and desktop program and mobile and a variety of other things,
		//all made of many combos of a single function.
		*/
		 
	}
	
	/** funcs needed to forkEdit the controls map and a few other basics. Since these might be implemented various ways
	for various kinds of map, they're params of constructor.
	If a map was object oriented, these would be the overriding or inherited functions.
	You could define a function that takes "put", "remove", etc as param
	and returns the specific kind of put or remove used with that map, or which curries more params and forkEdits the map,
	so it can do object-oriented, but doing it the simpler way at least for now.
	*/
	public final fn theEmptyMap, mapPut, mapRemove, T, F;
	
	/*FIXME get rid of the need for "fn tools" by using the input map similarly to fn output = state.e(input).e(T); fn nextState = state.e(input).e(F);
		so you would just call "put" or "get" followed by some params? It might be a few times less efficient?
		Is that how I really want to interact with maps?
	*/
				
	/** tools is used as a namespace/map containing at least "mapPut", "mapRemove", "theEmptyMap", "T", and "F", mapping them to functions
	to do some basic things to interact with the current fn state (which is an immutable/stateless efficiently-forkEditable snapshot).
	*/
	public OcfnPanel(Var<fn> stateVar, fn tools){
		this.stateVar = stateVar;
		this.theEmptyMap = tools.e("theEmptyMap");
		this.mapPut = tools.e("mapPut");
		this.mapRemove = tools.e("mapRemove");
		this.controls = tools.e("theEmptyMap");
		this.T = tools.e("T");
		this.F = tools.e("F");
		addMouseMotionListener(new MouseMotionListener(){
			public void mouseMoved(MouseEvent e){
				controlsPut("mouseY", e.getY());
				controlsPut("mouseX", e.getX());
			}
			public void mouseDragged(MouseEvent e){
				mouseMoved(e);
			}
		});
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}
		    public void mousePressed(MouseEvent e){
				controlsPut("mouseBtn"+e.getButton(), 1);
		    }
		    public void mouseReleased(MouseEvent e){
		    	controlsPut("mouseBtn"+e.getButton(), 0);
		    }
		    public void mouseEntered(MouseEvent e){
		    	controlsPut("mouseIn", 1);
		    }
		    public void mouseExited(MouseEvent e){
		    	controlsPut("mouseIn", 0);
		    }
		});
		addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent e){
				//TODO statistical norming gradually over time, like I've done in listweb and other places for mouse wheel?
				//but listweb sometimes gets stuck with a very very fast wheel scroll until restart program. Would need some adjustment.
				controlsPut("mouseWheel", controlsGet("mouseWheel")+e.getPreciseWheelRotation());
			}
		});
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){
				controlsPut("VK"+e.getKeyCode(), 0);
			}
			public void keyPressed(KeyEvent e){
				controlsPut("VK"+e.getKeyCode(), 1);
			}
		});
		addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e){
				controlsPut("focus", 0);
			}
			public void focusGained(FocusEvent e) {
				controlsPut("focus", 1);
			}
		});
		addComponentListener(new ComponentListener(){
			public void componentShown(ComponentEvent e){}
			public void componentResized(ComponentEvent e){
				controlsPut("pixHeight", getHeight());
				controlsPut("pixWidth", getWidth());
			}
			public void componentMoved(ComponentEvent e){}
			public void componentHidden(ComponentEvent e){}
		});
		//How did I do dragAndDrop in listweb? Basically java allows I think its a String contentType and bytes,
		//and it may also be able to drop java.awt.Components specificly. Mostly I'm interested in the bytes and contentType.
		//TODO setDropTarget(new DropTarget(){
		//	...
		//});
		//TODO
		//TODO controlsPut("time", utcnano)? Or should that go in a different map maybe along with things like browser GPS api?
		//TODO hook in mouse, keyboard, and thru browser api multitouchscreen, pointerlock, htmlCanvas, gamepadAPI, webAudioAPI, jsoundcard, etc.
		
		stateVar.startListening((Var<fn> v)->{
			//fn newState = v.get();
			repaint();
			//TODO is there more?
		});
	}
	
	/*
	FIXME should controls be a fn treemap and also have mapPut fn out here to forkEdit it so inputForState() would just be that fn or some fn containing it?
	/** TODO only mouseWheel needs a double. the rest could be float or maybe int16? *
	protected Map<String,Double> controls = new HashMap();
	*/
	
	/** translates current contents of controls *
	protected fn inputForState(){
	}*/
	
	/** only nonzero positions are stored */
	protected void controlsPut(String dimension, double position){
		//if(position == 0) controls.remove(dimension);
		//else controls.put(dimension,position);
		if(position == 0) controls = mapRemove.e(controls).e(dimension);
		else controls = mapPut.e(controls).e(dimension).e(position);
	}
	
	protected double controlsGet(String dimension){
		//return controls.getOrDefault(dimension, 0.);
		return controls.e(dimension).doubleAt(0);
	}
	
	/** TODO verify. if !anyFnUsedAsBitstring.isCbt() then when its asked for bits they will all be 0, which must work cuz
	we dont want to have to prove things about the code that generates the next state as a fn.
	*/
	public static void copyFnToBufferedImage(fn anyFnUsedAsBitstring, int height, int width, BufferedImage b){
		int len = height*width;
		Object unwrapped = anyFnUsedAsBitstring.unwrap();
		if(unwrapped instanceof int[]){
			//TODO? bufImg.getRaster().createInterleavedRaster(dataType, w, h, bands, location).
			//TODO? bufImg.getRaster().setSamples(0, 0, width, height, , iArray);
			int[] fnPixelsArray = (int[]) unwrapped;
			b.setRGB(0, 0, width, height, fnPixelsArray, 0, width); //TODO verify width (instead of height or width*4 or height*4) is the correct scansize
		}else{
			int i = 0;
			for(int y=0; y<height; y++){
				for(int x=0; i<width; x++){
					//at least in other code (TODO verify) these kinds of loops into BufferedImage seem to get very optimized in JVM, like its just doing System.arraycopy,
					//but it might be slower cuz harder to optimize thru function call than just local vars
					int colorARGB = anyFnUsedAsBitstring.IntAt(i++);
					b.setRGB(x, y, colorARGB);
				}
			}
		}
	}
	
	public void paint(Graphics g){
		
		fn state = stateVar.get();
		//If state is a treemap, then calling it on a key gets value.
		//mapPut etc are separate funcs taking the treemap as param and forkEditing to return another treemap.
		fn painter = state.e("painter");
		//You might find a variety of things in that state map, such as a "mindmap" key,
		//various (immutable forkEditable parts of) playings of online games live now,
		//huge datasets for AI experiments, experimental AI algorithms,
		//personal files, business files, things for the formally-verified operation of machines, etc...
		//None of that would put any of the other parts at risk cuz all objects are immutable/stateless,
		//and anything that needs to be encrypted should create such crypto functions themself and use bitstrings,
		//not as plugins but as combos of the universal function (which is a universal lambda function
		//and a pattern calculus function, of 15 params) as this is a functional programming system and a custom JIT compiler.
		//The unpredictable variety of what might be in a (efficiently forkEditable immutable) state
		//is why the state provides its own painter function.
		int height = getWidth(), width = getWidth();
		
		/*
		FIXME do I want a grid of pixels or do I want voxelY11X12RGB9 or voxelY10X10RGB12 or voxelY16X16ARGB32?
			Internally most graphics related fns will use one of those kinds of 2d voxels, but the outermost fn might better be just a grid of pixels,
			but it would avoid the last copy of a few megabytes int[] to another such int[] to display them as voxels here.
		*/
		
		//get pixels in rectangle 0..height-1 0..width-1 describing state.
		/*TODO or should it be yStart yEndExcl xStart xEndExcl, and does y go up or down on screen in this model?
		In java positive y is down and positive x is right.
		*/
		
		fn pixelsARGB = painter.e(0).e(0).e(height).e(width).e(state);
		if(bufImg == null || bufImg.getHeight() != height || bufImg.getWidth() != width){ //TODO optimize use BufferedImage's or Graphics's tile size instead?
			bufImg = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		}
		copyFnToBufferedImage(pixelsARGB, height, width, bufImg);
		ScreenUtil.paintOGIYXHW(this, g, bufImg, 0, 0, height, width);
	}
	
	protected void finalize(){
		stateVar.stopListening(listener);
	}
	
	//TODO JSoundCard for speakers and microphones
	
	//TODO bigO(1) recursive splitpane-like dividing of window with y11x10rgb9 voxels (each voxel is an int, or for smooth color use longs, option for int or long)
	
	//TODO occamserver, upgraded to support http keepalive and maybe https, even though it doesnt need https cuz will use digital signatures (such as ed25519 and ed448)
	
	//TODO MouseMotionListener
	
	//TODO MouseListener
	
	//TODO KeyListener, dont forget to setFocusable(true) 
	
	//TODO simple graphics mode with colored rectangles or circles, maybe lines from and to a place, and text. This will happen before the voxel and splitpane-like graphics.
	
	//TODO connect to browser on localhost for gamepad api (such as wireless xbox double joystick double analog trigger controller),
	//multitouchscreen API (phone screen used as game controller), webcam, etc.

}