package mutable.util;
/** Ben F Rayfield offers this software opensource MIT license */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.JFrame;

public class ScreenUtil{
	private ScreenUtil(){}
	
	public static void moveToScreenCenter(Window w){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation((screen.width-w.getWidth())/2, (screen.height-w.getHeight())/2);
	}
	
	public static void moveToHorizontalScreenCenter(Window w){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation((screen.width-w.getWidth())/2, w.getLocation().y);
	}
	
	public static void sizeToFractionOfScreen(Window w, double fraction){
		sizeToFractionOfScreen(w,fraction,fraction);
	}
	
	public static void sizeToFractionOfScreen(Window w, double fractionY, double fractionX){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		w.setSize((int)(screen.width*fractionX), (int)(screen.height*fractionY));
	}
	
	public static int color(float bright){
		return color(bright, bright, bright);
	}
	
	public static int weightedSumColor(int colorARGB, float fraction, int otherColorARGB){
		return (weightedSumByte(colorARGB>>>24, fraction, otherColorARGB>>>24)<<24)
			| (weightedSumByte(colorARGB>>>16, fraction, otherColorARGB>>>16)<<16)
			| (weightedSumByte(colorARGB>>>8, fraction, otherColorARGB>>>8)<<8)
			| weightedSumByte(colorARGB, fraction, otherColorARGB);
	}
	
	public static int weightedSumByte(int byteA, float fraction, int byteB){
		return ((int)((byteA&0xff)*(1-fraction)+fraction*(byteB&0xff)))&0xff;
	}
	
	public static int aveColor(int colorA, int colorB){
		return (aveByte(colorA>>>24,colorB>>>24)<<24)
			| (aveByte(colorA>>>16,colorB>>>16)<<16)
			| (aveByte(colorA>>>8,colorB>>>8)<<8)
			| aveByte(colorA,colorB);
	}
	
	/** uses only low 8 bits */
	public static int aveByte(int a, int b){
		return ((a&0xff)+(b&0xff))>>1;
	}
	
	static int holdInRange(int min, int data, int max){
		return Math.max(min, Math.min(data, max));
	}
	
	/** Unlike new Color(r,g,b).getRGB(), 1-epsilon rounds to brightest.
	Truncates red, green, and blue into range 0 to 1 if needed.
	*/
	public static int color(float red, float green, float blue){
		return 0xff000000 |
			(holdInRange(0, (int)(red*0x100), 0xff) << 16) |
			(holdInRange(0, (int)(green*0x100), 0xff) << 8) |
			holdInRange(0, (int)(blue*0x100), 0xff);
	}
	
	public static int color(float alpha, float red, float green, float blue){
		return (holdInRange(0, (int)(alpha*0x100), 0xff) << 24) |
			(holdInRange(0, (int)(red*0x100), 0xff) << 16) |
			(holdInRange(0, (int)(green*0x100), 0xff) << 8) |
			holdInRange(0, (int)(blue*0x100), 0xff);
	}
	
	public static Window getWindow(Component c){
		while(!(c instanceof Window)) c = c.getParent();
		return (Window)c;
	}
	
	public static void testDisplayWithExitOnClose(Component c){
		//TODO merge duplicate code between testDisplay* funcs
		JFrame window = new JFrame("Test displaying (exitOnClose) "+c);
		window.add(c);
		sizeToFractionOfScreen(window,.5);
		moveToScreenCenter(window);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public static void testDisplayWithoutExitOnClose(Component c){
		//TODO merge duplicate code between testDisplay* funcs
		JFrame window = new JFrame("Test displaying "+c);
		window.add(c);
		sizeToFractionOfScreen(window,.5);
		moveToScreenCenter(window);
		window.setVisible(true);
	}
	
	public static void paintOGIYXHW(ImageObserver obs, Graphics g, BufferedImage i, int y, int x, int h, int w){
		double yMagnify = (double)h/i.getHeight();
		double xMagnify = (double)w/i.getWidth();
		if(g instanceof Graphics2D && (xMagnify != 1 || yMagnify != 1)){ //stretch to panel size
			Graphics2D G = (Graphics2D)g;
			AffineTransform aftrans = new AffineTransform(xMagnify, 0, 0, yMagnify, 0, 0);
			G.drawImage(i, aftrans, obs);
		}else{ //so you can see something but it may be wrong size
			g.drawImage(i, 0, 0, obs);
		}
	}
	
	public static int randColor(Random rand){
		return 0xff000000 | rand.nextInt(1<<24);
	}
	
	public static int randColor(){
		return randColor(Rand.strongRand);
	}

}
