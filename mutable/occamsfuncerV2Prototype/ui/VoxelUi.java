package mutable.occamsfuncerV2Prototype.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.JPanel;

import mutable.util.Rand;
import mutable.util.ScreenUtil;
import mutable.util.Time;

/** Each voxel has 10 bits of y, 10 x, 4 red, 4 green, 4 blue,
so an int chooses position in 1024x1024 and color.
Its slightly cartoony of not being as smooth of color
as you get with 8 bits of each of red green and blue,
but it gets 60 fps on an old computer,
and most importantly the pixels can be written in
any order so occamsfuncer can concat the pixels of many objects
so many of those objects can generate the voxel ints
in parallel such as in GPU.
The universal lambda function will support
graphics ops such as screen blit.
<br><br>
OLD...
Each voxel is an integer value in a double.
A voxel has 16 brightnesses of each of red green blue
and can be size 1 to 1024 in each of y and x
and can 
<br><br>
The bits will be:
uint12 colorRGB
uint10 y
uint10 x
uint10 ySizeMinus1
uint10 xSizeMinus1
It can only do 1024x1024 and 16 shades of red green and blue if so,
but other standards could be designed later maybe that use long
instead of double for more bits,
but for now I'm doing alot of stuff with doubles only
and need a way to get started with graphics.
Also the 1024x1024 size has the advantage that
it only has to paint that size of BufferedImage
so its faster, and I'm only using about that resolution anyways
if the mindmap software is in a small column on the left
and to the right of that is the occamsfuncer graphics area,
and it can paint stretched for whatever resolution you're
actually using.
???
<br><br>
Double can represent all integers from -2^53 to 2^53
(both inclusive) so has 54 usable bits
if we count the negatives,
or has about 62 or 63 usable bits if
store the other bits in the exponent
by doubling it or not, then 4x it,
then 8x it, and so on, for those extra bits,
without affecting the low bits.
*/
public class VoxelUi extends JPanel{
	
	/*TODO copy code from TestWritableRasterWithRandomOrderOfIntsEachSayingAnInt20AddressAndInt12ColorToWriteThere
	cuz its faster. uint10Y uint10X uint12Color Raster of the BufferedImage.
	
	
	/*
	TODO implement RBM.java and RbmEditor.java
	(some of my RBM boltzmann neuralnet experiments),
	the RBM as a function that acts like object oriented
	by taking a param then taking a second param of T or F
	to choose to get its next state vs retun value
	(normal way to do that is return pair of nextState and returnVal),
	and GRAPHICS... The rectangles of RBM EdLay weights, which are floats
	displayed by brightness normed to a certain bellcurve,
	will generate those ints in that rectangle
	by using a screen x and y offset to generate the 20 bit position
	per pixel and use the float arrays (in opencl optimized lambdas)
	and norms of multiple float arrays,
	to generate the 12 bit color, and return an array of such ints
	for each rectangle to draw on screen,
	those ints already containing the info of where the rectangle is.
	Then do an experiment of only including the ints that are
	not within 50 pixels of the center of that rectangle,
	so generate another array of ints that lacks those ints,
	filtered 1 at a time to forkApppend them to the next array or not,
	then display that along with some other objects behind it,
	and the objects behind it should be visible through that circle
	since its not a rectangle but a group of points that happened
	to be all the points in a rectangle or all except those in the circle.
	There are no bounding shapes like in java awt Shape.
	Theres just individual voxels.
	
	
	TODO make some simple game to demo this graphics ability.
	*/
	
	public final int h = 1024, w = 1024;
	
	public final BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	
	public void paint(int... voxels){
		//Arrays.sort(voxels);
		for(int voxel : voxels){
			//updateBuffer(voxel);
			int y = (voxel>>>12)&0x3ff;
			int x = (voxel>>>22)&0x3ff;
			int c = ((voxel&0xf00)<<8) | ((voxel&0xf0)<<4) | (voxel&0xf);
			//c<<4 turns colors 0x00..0x30..0xf0 to colors 0x00..0x33..0xff
			int colorARGB = 0xff000000 | c | (c<<4);
			bi.setRGB(x, y, colorARGB);
			//bi.setRGB(x, y, 0xff000000|(voxel&0xfff)); //testing speed, not the right calculation
		}
		repaint();
	}
	
	public void paint(double... voxels){
		for(double voxel : voxels){
			updateBuffer((long)voxel);
		}
		repaint();
	}
	
	public void paint(long... voxels){
		for(long voxel : voxels){
			updateBuffer(voxel);
		}
		repaint();
	}
	
	public void updateBuffer(double voxel){
		updateBuffer((long)voxel);
	}
	
	public void updateBuffer(int voxel){
		//int yHighXLow = (v>>>12)&0xfffff;
		int y = (voxel>>>12)&0x3ff;
		int x = (voxel>>>22)&0x3ff;
		int c = ((voxel&0xf00)<<8) | ((voxel&0xf0)<<4) | (voxel&0xf);
		//c<<4 turns colors 0x00..0x30..0xf0 to colors 0x00..0x33..0xff
		int colorARGB = 0xff000000 | c | (c<<4);
		bi.setRGB(x, y, colorARGB);
	}
	
	public void updateBuffer(long voxel){
		int v = (int)voxel;
		//int yHighXLow = (v>>>12)&0xfffff;
		int y = (v>>>12)&0x3ff;
		int x = (v>>>22)&0x3ff;
		int c = ((v&0xf00)<<8) | ((v&0xf0)<<4) | (v&0xf);
		//c<<4 turns colors 0x00..0x30..0xf0 to colors 0x00..0x33..0xff
		int colorARGB = 0xff000000 | c | (c<<4);
		if(voxel <= Integer.MAX_VALUE){ //one pixel
			bi.setRGB(x, y, colorARGB);
		}else{
			int ySize = (((int)(voxel>>>42))&0x3ff)+1;
			int xSize = (((int)(voxel>>>32))&0x3ff)+1;
			ySize = Math.min(ySize, h-y);
			xSize = Math.min(xSize, w-x);
			for(int i=0; i<ySize; i++){
				for(int j=0; j<xSize; j++){
					bi.setRGB(x+j, y+i, colorARGB);
				}
			}
		}
		//caller must do this, for efficiency: repaint();
	}
	
	public void paint(Graphics g){
		ScreenUtil.paintOGIYXHW(this, g, bi, 0, 0, getHeight(), getWidth());
	}
	
	private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
	private static long weakrandFastSeed = Rand.strongRand.nextLong()&0xffffffffffffL;
	private static int nextWeakrandFastInt(){
		weakrandFastSeed = (weakrandFastSeed * multiplier + addend) & mask;
		return (int)(weakrandFastSeed >>> 16);
	}
	
	public static void main(String[] args){
		VoxelUi v = new VoxelUi();
		ScreenUtil.testDisplayWithExitOnClose(v);
		//double[] voxels = new double[30000];
		//double[] voxels = new double[1<<20];
		//long[] voxels = new long[1<<20];
		int[] voxels = new int[1<<20];
		//int[] voxels = new int[1<<16];
		while(true){
			for(int i=0; i<voxels.length; i++){
				//long vox = Rand.weakRand.nextInt();
				//int vox = Rand.weakRand.nextInt();
				int vox = nextWeakrandFastInt();
				//long vox = Rand.strongRand.nextInt();
				/*int ySize = Rand.weakRand.nextInt(5);
				int xSize = ySize;
				vox |= ((long)xSize)<<32;
				vox |= ((long)ySize)<<42;
				*/
				voxels[i] = vox;
			}
			v.paint(voxels);
			Time.sleepNoThrow(.01);
		}
	}

}