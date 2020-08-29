/** Ben F Rayfield offers this software opensource MIT license */
package occamsfuncer.impl.ui;
import javax.swing.JPanel;

/** all inputs and outputs are controlled by a fn currentState which, given inputs, returns its next state and outputs.
Occamsfuncer is a sandbox, so this doesnt give it access to your private files or ability to network to computers
that have not opted into this protocol except to ask them if they do and check robots.txt etc.
You dont need a UI for occamsfuncer, can run only as a server (TODO), or only on local commandline, or any combo.
TODO choose some datastruct of treemap (in the fn) for the various things it reads and writes.
*/
public class OcfnPanel extends JPanel{
	
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