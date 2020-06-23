package mutable.occamsfuncer.v2.prototype.ui;
import static immutableexceptgas.occamsfuncer.v2.prototype.util.ImportStatic.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.function.Consumer;

import javax.swing.JPanel;

import immutable.util.MathUtil;
import immutableexceptgas.occamsfuncer.v2.prototype.util.Example;
import immutableexceptgas.occamsfuncer.v2.spec.fn;
import mutable.util.Rand;
import mutable.util.ScreenUtil;
import mutable.util.Var;

/** get quadtree working asap.
Now that every fn has a comment child (of 3 childs, except below height 5 comment is always leaf),
can get quadtree working quickly.
Leaf will be used like nil. Make the comments be linkedlist of pairs, like a tinymap.
Key will be things like "intARGBQuadtree" or "comment".
Example: (pair (pair "comment" "hello") (pair (pair "intARGBQuadtree" ...) leaf)).
Or should it simply be (pair "hello" pixelsData)?
Create the tinymap this way...
tinylist = (curry unary(255) T (T leaf));
(tinylist key val key val...)
Or how about writing an arbitrary type string after the tinylist...
tinymap = (tinylist "tinymap")
(tinymap key val key val...)
<br><br>
OLD...
<br><br>
TODO I want the goldenRatioQuadtree ui working
in a basic way. Just draw it without special logic for pair or nonpair etc,
for now, with F is color00 and leafFirstHalf is color01
and leafSecondHalf is color10 and T is color11.
Get dragAndDrop working with mouse similar to in iotavm controls,
and use mouse wheel to go in and out sizes.
*/
public class Quadtree extends JPanel{ //TODO rename to QuadtreeUi
	
	/*TODO??? do this as cccc() where first 2 params are either this same datastruct or leaf,
	and third param can be anything (whose comment field is used for
	text andOr intargb pixels), and thats the datastruct form,
	and fourth param always infloops,
	so it can branch in any num of dims such as 2 or 3.
	Or add another param for mapreduce with a func of 2 params to 1 param
	and thats constrained to be the 1 param generated from that field in
	the 2 childs considering that they may be leafs.
	For example, it could be a bayesnode with a random order of which dims
	explored first and by redundant permutations verify its consistency.
	*/
	
	public final Var<fn> var;
	
	protected Consumer<Var> listener;
	
	public Quadtree(Var<fn> var){
		this.var = var;
		var.startListening(listener = (Var v)->{
			Quadtree.this.repaint();
		});
	}
	
	protected void finalize(){
		var.stopListening(listener);
	}
	
	public void paint(Graphics g){
		paint(this, g, false, 0, 0, getWidth(), getHeight(), var.get());
	}
	
	/*static final Color colorA =  new Color(0xff000000);
	static final Color colorB =  new Color(0xff555555);
	static final Color colorC = new Color(0xff808080);
	static final Color colorD =  new Color(0xffaaaaaa);
	static final Color colorE =  new Color(0xffffffff);
	*/
	
	/** sizes 4pow0=1 to 4pow15=1073741824 ints, lazy created */
	private static BufferedImage[] bi = new BufferedImage[16];
	/** from pool */
	protected static BufferedImage bi(int size){
		double sq = Math.sqrt(size);
		int sqi = (int)sq;
		if(sq != sqi || !MathUtil.isPowerOf2(sqi))
			throw new Error("size is not a power of 4: "+size);
		int log4OfSize = Integer.numberOfTrailingZeros(sqi);
		if(bi[log4OfSize] == null){
			bi[log4OfSize] = new BufferedImage(sqi, sqi, BufferedImage.TYPE_INT_ARGB);
		}
		return bi[log4OfSize];
	}
	
	/** UPDATE: theres no isCommentPixelsQuadtree param cuz drawing all at once when get to the int[].
	comment is fn.comment(), one of the 3 childs of each fn: L() R() comment().
	Comment can be any datastruct. I'm undecided which it will be (TODO),
	but it can contain text and intARGB[] pic which are all for Humans to understand
	such as an icon and a name. These are not unique as any comment can duplicate them.
	If you want uniqueness, use a treemap (see MapPair, MapSingle, MapEmpty in Example class
	which are 2019-12-30 incomplete). The isCommentPixelsQuadtree param of this func
	tells if its painting the comment vs the quadtree of pairs before it gets to
	the first object that has a non-leaf comment.
	*/
	protected static synchronized void paint(
			ImageObserver obs, Graphics g, boolean vertical, int y, int x, int h, int w, fn ob){
		
		int y0, y1, x0, x1, h0, h1, w0, w1;
		if(vertical){ //recurse into my top and bottom halfs
			y0 = y;
			y1 = y+h/2;
			x0 = x;
			x1 = x;
			h0 = h/2;
			h1 = h-h/2;
			w0 = w;
			w1 = w;
		}else{ //recurse into my left and right halfs
			y0 = y;
			y1 = y;
			x0 = x;
			x1 = x+w/2;
			h0 = h;
			h1 = h;
			w0 = w/2;
			w1 = w-w/2;
		}
		
		/*if(isCommentPixelsQuadtree){
			//FIXME need to decide at top node of comment how it will be displayed,
			//as text or quadtree of intARGB[].
			//If text, display using Graphics.drawString
			//and use some kind of clipping func so it doesnt
			//display outside the x y w h rectangle and is truncated inside it. 
			//If intARGB[], recurse to draw it.
			//Comment might contain text andOr colorARGBQuadtree andOr other things
			//String text = TODO;
			//int[] colorARGBQuadtree = TODO;
			//TODO
			
			
			ob is probably either a wrapper of a binheap range of int[]
			or the inefficient way of complete binary tree of cbt0 and cbt1
			of the bits that would go in that int[].
			Could use fn.intAt(int) func if knew how deep to draw it.
			
			FIXME is it still quadtree indexed inside the int[]
			or is it rows and cols, and what if its not a perfect square divisible?
			ANSWER: Its a powOf4 size
			in normal rows-cols pixel order not quadtree order.
			
			TODO create BufferedImage for every powOf4 size but lazy.
		}else{
		*/
			//This gets the top node of the comment, but below that its parts are the "ob" var.
			fn comment = ob.comment();
			if(comment == leaf && ob.L().L()==pair){
				//recurse quadtree outside comment
				fn pairL = ob.L().R();
				fn pairR = ob.R();
				paint(obs, g, !vertical, y0, x0, h0, w0, pairL);
				paint(obs, g, !vertical, y1, x1, h1, w1, pairR);
			}else{
				//recurse comment, which may be a quadtree or other way of displaying
				fn picOrLeaf = commentPicOrLeaf(comment);
				//fn textOrLeaf = commentTextOrLeaf(comment);
				String text = commentText(comment);
				if(picOrLeaf != leaf){ //paint it
					paintPic(obs, g, picOrLeaf, y, x, h, w);
				}
				if(!text.equals("")){ //paint text over parts of picOrLeaf
					paintStr(g, text, y, x, h, w);
				}
			}
		//}
		
		/*
		if(w <= 0 || h <= 0) throw new Error("w or h <= 0");
		boolean isOneOfTheConstantsMappedToACertainWayToPaint = ob==leaf || ob==T || ob==F;
		boolean isTooSmallToPaintDeeper = w==1 || h==1;
		boolean deepEnough = isOneOfTheConstantsMappedToACertainWayToPaint || isTooSmallToPaintDeeper;
		if(deepEnough){
			Color outer;
			Color inner;
			if(ob == F){
				outer = inner = colorA;
			}else if(ob == T){
				outer = inner = colorE;
			}else if(ob == leaf){
				//FIXME this should be firstHalf colorB and secondHalf colorD
				//c = new Color(0xff000000|Rand.strongRand.nextInt(0x1000000));
				outer = colorB;
				inner = colorD;
			}else{
				outer = inner = colorC;
			}
			g.setColor(outer);
			g.fillRect(x, y, w, h);
			g.setColor(inner);
			int thick = Math.min(w,h)/7;
			g.fillRect(x+thick, y+thick, w-thick*2, h-thick*2);
		}else{
			int x0, x1, y0, y1, w0, w1, h0, h1;
			if(vertical){ //recurse L() and R() into my top and bottom halfs
				x0 = x;
				x1 = x;
				y0 = y;
				y1 = y+h/2;
				w0 = w;
				w1 = w;
				h0 = h/2;
				h1 = h-h/2;
			}else{ //recurse L() and R() into my left and right halfs
				x0 = x;
				x1 = x+w/2;
				y0 = y;
				y1 = y;
				w0 = w/2;
				w1 = w-w/2;
				h0 = h;
				h1 = h;
			}
			paint(g, !vertical, x0, y0, w0, h0, ob.L());
			paint(g, !vertical, x1, y1, w1, h1, ob.R());
		}*/
	}
	
	protected synchronized static void paintPic(ImageObserver obs, Graphics g, fn pixelsSizeAPowerOf4, int y, int x, int h, int w){
		long bitSize = pixelsSizeAPowerOf4.cbtSize();
		if(bitSize < 32) throw new Error("TODO its less than 1 int: "+pixelsSizeAPowerOf4);	
		long intSize = bitSize>>5;
		if(intSize > Integer.MAX_VALUE) throw new Error("bitSize too big: "+bitSize);
		BufferedImage b = bi((int)intSize);
		int offset = 0;
		int sqSize = (int)Math.sqrt(intSize);
		if(sqSize*sqSize != intSize) throw new Error("Not a square (should also be powOf4): "+intSize);
		for(int yi=0; yi<sqSize; yi++){
			for(int xi=0; xi<sqSize; xi++){
				int colorARGB = pixelsSizeAPowerOf4.intAt(offset);
				offset += 32;
				//b.setRGB(xi, yi, colorARGB); TODO
				b.setRGB(xi, yi, 0xffabcdef);
				//TODO in array is faster for BufferedImage?
				//setRGB seems to be very optimized in earlier code, probably will be here too.
			}
		}
		//int scanSize = w; //FIXME is this in units of ints or bytes?
		//b.setRGB(0, 0, w, h, pixelsSizeAPowerOf4, 0, scanSize);
		ScreenUtil.paintOGIYXHW(obs, g, b, y, x, h, w);
	}
	
	/** doesnt disturb the parts the text doesnt touch,
	so you should paint int[] pixels first then text over it.
	*/
	protected static void paintStr(Graphics g, String s, int y, int x, int h, int w){
		Shape prevClip = g.getClip();
		g.setClip(new Rectangle(x, y, w, h));
		//TODO wrap text. and put it inside a thin rectangle border.
		g.drawString(s, x, y+h/2);
		g.setClip(prevClip);
	}
	
	/** any fn can be any pixel. Arbitrarily using pair.f(pair).f(pair) for that.
	You could also put any powOf4 size image in the comment of a fn, for efficiency,
	but this is just 1 pixel.
	*/
	public static fn pixel(int colorARGB){
		return pair.f(pair).f(pair).COMMENT(commentPixel(colorARGB));
	}
	
	public static fn quad(fn topLeft, fn topRight, fn bottomLeft, fn bottomRight){
		return pair(pair(topLeft,bottomLeft),pair(topRight,bottomRight));
	}
	
	public static void main(String[] args){
		fn black = pixel(0xff000000);
		fn white = pixel(0xffffffff);
		fn red = pixel(0xffff0000);
		fn green = pixel(0xff00ff00);
		fn blue = pixel(0xff0000ff);
		/*fn state = quad(
			quad(red,green,blue,white),
					black,
			white,
					quad(black,white,black,white)
		);
		*/
		fn state = blue;
		lg("quadtree.state="+state);
		
		//fn equals = Example.equals();
		Var<fn> v = new Var(state);
		ScreenUtil.testDisplayWithoutExitOnClose(new Quadtree(v));
	}

}
