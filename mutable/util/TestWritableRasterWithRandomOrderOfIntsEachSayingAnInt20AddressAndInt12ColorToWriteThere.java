package mutable.util;
import java.awt.*;
import java.awt.image.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;

public class TestWritableRasterWithRandomOrderOfIntsEachSayingAnInt20AddressAndInt12ColorToWriteThere extends JPanel{
	
	int count = 0;
	
	//long sparseData[];
	int[] sparseData;
	
	private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
	private static long weakrandFastSeed = 24098345083452345L;
	private static int nextWeakrandFastInt(){
		weakrandFastSeed = (weakrandFastSeed * multiplier + addend) & mask;
		return (int)(weakrandFastSeed >>> 16);
	}
	
	/** index is y*width + x */
	protected void changeData(){
		count++;
		/* faster but you have to use int instead of floats for color...
		for(int p=0; p<data.length; p++){
			data[p] = 0xff000000 | (count+p)*333;
		}*/
		//slower probably because of the calls to color func...
		int offset = 0;
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				/*float red = 0;
				float green = ((count+x)%37)/37f;
				float blue = ((count+y)%17)/17f;
				data[offset+x] = color(red, green, blue);
				*/
				//data[offset+x] = 0xff000000 | ((count*134531+x)%23425437)&0xffffff;
				//int color = 0xff000000 | ((count+x)*0x10101)&0xffffff;
				//int colorAsInt12 = ((count+(x>>2))*0x111)&0xfff;
				//int colorAsInt12 = ((count+x)*0x111)&0xfff;
				//int colorAsInt12 = nextWeakrandFastInt()&0xfff;
				int colorAsInt12 = nextWeakrandFastInt()&0xfff;	
				//int colorAsInt12 = Rand.strongRand.nextInt(1<<12);
				//colorAsInt12 = 0x55f;
				//colorAsInt12 &= ~(0b100010001); //remove 1 bit of precision from each of red green blue
				//colorAsInt12 &= ~(0b11101110111); //remove 3 bits of precision from each of red green blue
				//int colorAsInt12 = ((count+x)*0x137)&0xfff;
				//int color = 0xff000000 | ((count*134531+x)%23425437)&0xffffff;
				//int color = 0xff000000 | ((count*134531+x)%23425437)&0xffffff;
				int address = offset+x;
				//data[address] = color;
				//sparseData[address] = (((long)address)<<32)|(color&0xffffffffL);
				sparseData[address] = ((address<<12)|colorAsInt12);
			}
			offset += width; //avoid multiply which is slower than plus
		}
		//shuffle(sparseData, new Random());
		//swapSomeRanges(sparseData);
		//if(count==1) Arrays.sort(sparseData);
		//if(count%35==0) Arrays.sort(sparseData);
		//if(count%35==0) shuffle(sparseData, new Random());
		//if(count%5==0) shuffle(sparseData, new Random());
		//shuffle(sparseData, new Random());
		if(count==1) shuffle(sparseData, new Random());
	}
	
	/** longs are high 32 bits address and low 32 bits value to write there in denseInts.
	Leaves other indexs in denseInts as they are.
	*/
	public static void copySparseLongsToDenseInts(long[] sparseLongs, int[] denseInts){
		for(long g : sparseLongs){
			denseInts[(int)(g>>>32)] = (int)g;
		}
	}
	
	void shuffle(long[] a, Random rand){
		for(int i=1; i<a.length; i++){
			int j = rand.nextInt(i);
			long temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	void shuffle(int[] a, Random rand){
		for(int i=1; i<a.length; i++){
			int j = rand.nextInt(i);
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	void swapNonoverlappingRanges(long[] a, int startA, int startB, int len){
		for(int i=0; i<len; i++){
			long temp = a[startA+i];
			a[startA+i] = a[startB+i];
			a[startB+i] = temp;
		}
	}
	
	void swapNonoverlappingRanges(int[] a, int startA, int startB, int len){
		for(int i=0; i<len; i++){
			int temp = a[startA+i];
			a[startA+i] = a[startB+i];
			a[startB+i] = temp;
		}
	}
	
	/** hopefully this will still be locally sorted enough to be efficient graphics.
	NO, it was 4 times slower, went down to 12 fps.
	So instead I'm going to try int[] where the first int tells which pixel (first int is offset)
	and the other ints are pixels to write after that.
	*/
	void swapSomeRanges(long[] a){
		for(int y=0; y<height; y++){
			int startA = y*width;
			int len = width/2;
			int startB = y*width+len;
			swapNonoverlappingRanges(a, startA, startB, len);
		}
	}
	void swapSomeRanges(int[] a){
		for(int y=0; y<height; y++){
			int startA = y*width;
			int len = width/2;
			int startB = y*width+len;
			swapNonoverlappingRanges(a, startA, startB, len);
		}
	}
	
	public static int color(float red, float green, float blue){
		return 0xff000000 |
			(Math.max(0, Math.min((int)(red*0x100), 0xff)) << 16) |
			(Math.max(0, Math.min((int)(green*0x100), 0xff)) << 8) |
			Math.max(0, Math.min((int)(blue*0x100), 0xff));
	}
	
	protected BufferedImage image;
	
	public final int width, height;
	
	/** index is y*width + x */
	protected int data[];
	
	public TestWritableRasterWithRandomOrderOfIntsEachSayingAnInt20AddressAndInt12ColorToWriteThere(int width, int height){
		this.width = width;
		this.height = height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		System.out.println("colorModel="+image.getColorModel());
		System.out.println("raster.bands="+image.getRaster().getNumBands());
		data = new int[width*height*5]; //fixme not *5
		//sparseData = new long[width*height];
		sparseData = new int[width*height];
		Dimension d = new Dimension(width, height);
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
		nextState();
	}
	
	long frames = 0;
	
	float fps = 1;
	
	long lastNanotime = System.nanoTime();
	
	public void paint(Graphics g){
		//g.drawImage(image, 0, 0, this);
		ScreenUtil.paintOGIYXHW(this, g, image, 0, 0, getHeight(), getWidth());
		g.setColor(Color.black);
		frames++;
		long nowNanotime = System.nanoTime();
		double dt = Math.max(0, Math.min((nowNanotime-lastNanotime)*1e-9,.1));
		lastNanotime = nowNanotime;
		double decay = dt*3;
		double instantFps = 1/dt;
		fps = (float)(fps*(1-decay) + decay*instantFps);
		g.drawString("Frames: "+frames+" fps="+fps, 50, 50);
	}
	
	public boolean nextState(){
		WritableRaster wr = image.getRaster();
		DataBufferInt buffer = (DataBufferInt) wr.getDataBuffer();
		changeData();
		//Arrays.sort(sparseData);
		//copySparseLongsToDenseInts(sparseData, data);
		int imageW = image.getWidth(), imageH = image.getHeight();
		int offset = 0;
		//int i = 0;
		/*for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				//int index = offset+x;
				buffer.setElem(index, data[index]);
				//buffer.setElem(i, data[i]);
				//i++;
			}
			offset += width;
		}*/
		/*for(long g : sparseData){
			buffer.setElem((int)(g>>>32), (int)g);
		}*/
		for(int g : sparseData){
			int address = g>>>12;
			int c = ((g&0xf00)<<12) | ((g&0xf0)<<8) | ((g&0xf)<<4);
			int color = 0xff000000 | c;
			//int color = 0xff000000 | c | (c<<4); 
			//int color = 0xff000000 | c | (c>>4);
			buffer.setElem(address, color);
			//buffer.setElem(address, c);
		}
		//wr.setPixels(0, 0, image.getWidth(), image.getHeight(), data);
		//image.setRGB(0, 0, imageW, imageH, data, 0, imageW);
		repaint();
		return true;
	}
	
	public static void main(String args[]){
		//int width = 800, height = 600;
		//int width = 1300, height = 1000;
		int width = 1024, height = 1024;
		//int width = 512, height = 512;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//int width = screenSize.width-70;
		//int height = screenSize.height-100;
		final TestWritableRasterWithRandomOrderOfIntsEachSayingAnInt20AddressAndInt12ColorToWriteThere t = new TestWritableRasterWithRandomOrderOfIntsEachSayingAnInt20AddressAndInt12ColorToWriteThere(width, height);
		//t.setDoubleBuffered(true);
		JFrame window = new JFrame();
		window.add(t);
		window.pack();
		//window.setLocation((screenSize.width-width)/2, (screenSize.height-height)/2);
		window.setLocation((screenSize.width-width)/2, 50);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		new Thread(){
			public void run(){
				while(true){
					t.nextState();
					try{
						Thread.sleep(1L);
						//Thread.sleep(20L);
					}catch(InterruptedException e){}
				}
			}
		}.start();
	} 

}