package mutable.occamsfuncerV2.ui;
import static immutableexceptgas.occamsfuncerV2.impl.util.ImportStatic.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Consumer;

import javax.swing.JPanel;

import immutableexceptgas.occamsfuncerV2.fn;
import immutableexceptgas.occamsfuncerV2.impl.util.Example;
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
public class GoldenratioQuadtreeUi extends JPanel{
	
	public final Var<fn> var;
	
	protected Consumer<Var> listener;
	
	public GoldenratioQuadtreeUi(Var<fn> var){
		this.var = var;
		var.startListening(listener = (Var v)->{
			GoldenratioQuadtreeUi.this.repaint();
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
		ScreenUtil.testDisplayWithoutExitOnClose(new GoldenratioQuadtreeUi(v));
	}

}
