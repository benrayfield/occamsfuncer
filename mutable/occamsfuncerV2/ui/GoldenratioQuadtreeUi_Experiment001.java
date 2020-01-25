package mutable.occamsfuncerV2.ui;
import static immutableexceptgas.occamsfuncerV2Prototype.util.ImportStatic.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Consumer;

import javax.swing.JPanel;

import immutableexceptgas.occamsfuncerV2Prototype.util.Example;
import immutableexceptgas.occamsfuncerV2Spec.fn;
import mutable.util.Rand;
import mutable.util.ScreenUtil;
import mutable.util.Var;

/** TODO I want the goldenRatioQuadtree ui working
in a basic way. Just draw it without special logic for pair or nonpair etc,
for now, with F is color00 and leafFirstHalf is color01
and leafSecondHalf is color10 and T is color11.
Get dragAndDrop working with mouse similar to in iotavm controls,
and use mouse wheel to go in and out sizes.
*/
public class GoldenratioQuadtreeUi_Experiment001 extends JPanel{
	
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
	
	public GoldenratioQuadtreeUi_Experiment001(Var<fn> var){
		this.var = var;
		var.startListening(listener = (Var v)->{
			GoldenratioQuadtreeUi_Experiment001.this.repaint();
		});
	}
	
	protected void finalize(){
		var.stopListening(listener);
	}
	
	public void paint(Graphics g){
		paint(g, false, 0, 0, getWidth(), getHeight(), var.get());
	}
	
	static final Color colorA =  new Color(0xff000000);
	static final Color colorB =  new Color(0xff555555);
	static final Color colorC = new Color(0xff808080);
	static final Color colorD =  new Color(0xffaaaaaa);
	static final Color colorE =  new Color(0xffffffff);
	
	public static void paint(Graphics g, boolean vertical, int x, int y, int w, int h, fn ob){
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
		}
	}
	
	public static void main(String[] args){
		fn state = Example.equals();
		Var<fn> v = new Var(state);
		ScreenUtil.testDisplayWithoutExitOnClose(new GoldenratioQuadtreeUi_Experiment001(v));
	}

}
