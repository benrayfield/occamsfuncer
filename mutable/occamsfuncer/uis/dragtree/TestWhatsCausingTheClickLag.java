package mutable.occamsfuncer.uis.dragtree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mutable.util.ScreenUtil;

/** 2020-11-11 I noticed DragTree.java accumulates lag after clicking to add child rects of a rect,
if you click ~20 times fast it stops counting clicks for the next second or so,
but paint and mouse events etc only take about a millisecond as I timed,
and I paused it in debugger while it was waiting and it said java is sleeping waiting on next event,
so it might be related to swing getTreeLock etc.
TODO In this class, start with just changing background color randomly after every click and
make sure it doesnt have the lag, then gradually add more parts from DragTree until
find whats causing the lag, or maybe it wont happen here.
Strange, its doing it even with just that. Maybe its adoptopenjdk15 on win10?
<br><br>
jdk8 and openjdk11 and adoptopenjdk15 all have that problem on this win10 computer
but it seems to work when I get mousePressed or mouseReleased event, just not mouseClicked. 
*/
public class TestWhatsCausingTheClickLag extends JPanel{
	
	int color = 0xffffffff;
	
	public TestWhatsCausingTheClickLag(){
		/*addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e){
				repaint();
			}
			public void mouseDragged(MouseEvent e){
				mouseMoved(e);
			}
		});*/
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
				
			}
			public void mousePressed(MouseEvent e){
				
			}
			public void mouseReleased(MouseEvent e){
				repaint();
			}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		});
	}
	
	public void paint(Graphics g){
		color ^= 0x00ffffff;
		g.setColor(new Color(color));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public static void main(String... args){
		ScreenUtil.testDisplayWithExitOnClose(new TestWhatsCausingTheClickLag());
	}

}
