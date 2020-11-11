package mutable.occamsfuncer.uis.dragtree;
import java.security.SecureRandom;
import java.util.Random;

import immutable.occamsfuncer.fn;
import immutable.util.Text;
import mutable.util.ScreenUtil;

public class SimpleDTNode implements DTNode{
	
	protected fn data;
	
	protected boolean horiz;
	
	protected double borderFractionX, borderFractionY, split;
	
	protected DTNode parent, L, R;
	
	protected int colorBG;
	
	public SimpleDTNode(DTNode parent, fn data){
		this.parent = parent;
		this.data = data;
		this.borderFractionX = this.borderFractionY = .05;
		this.split = .5;
		this.horiz = true;
		colorBG = 0xff000000;
	}

	public fn data(){
		return data;
	}

	public void data(fn data){
		boolean changed = this.data != data; //may still be equal fn but not deduped
		this.data = data;
		if(changed){
			throw new RuntimeException("TODO replace L and R and maybe need to tell parent");
		}
	}

	public double borderFractionX(){
		return borderFractionX;
	}
	
	public double borderFractionY(){
		return borderFractionY;
	}

	public void borderFractionX(double fractionX){
		boolean changed = borderFractionX != fractionX;
		if(fractionX < 0 || fractionX > 1./3) throw new RuntimeException("fractionX="+fractionX);
		this.borderFractionX = fractionX;
		if(changed){
			//FIXME might need to cause a repaint or JComponent.invalidate or invalidateTree etc.
		}
	}
	
	public void borderFractionY(double fractionY){
		boolean changed = borderFractionY != fractionY;
		if(fractionY < 0 || fractionY > 1./3) throw new RuntimeException("fractionY="+fractionY);
		this.borderFractionY = fractionY;
		if(changed){
			//FIXME might need to cause a repaint or JComponent.invalidate or invalidateTree etc.
		}
	}

	public double split(){
		return split;
	}

	public void split(double d){
		boolean changed = split != d;
		this.split = d;
		if(changed){
			//FIXME might need to cause a repaint or JComponent.invalidate or invalidateTree etc.
		}
	}

	public boolean horiz(){
		return horiz;
	}

	public void horiz(boolean z){
		boolean changed = horiz != z;
		horiz = z;
		if(changed){
			//FIXME might need to cause a repaint or JComponent.invalidate or invalidateTree etc.
		}
	}

	public DTNode parent(){
		return parent;
	}
	
	public DTNode l(){
		return L;
	}
	
	public DTNode r(){
		return R;
	}
	
	//static Random rand = new SecureRandom(Text.strToBytes(""+(System.nanoTime()+System.currentTimeMillis()*new Object().hashCode()+17))); //FIXME set colorBG externally

	public DTNode L(){
		if(L == null){
			L = new SimpleDTNode(this, data().Func());
			//L.colorBG(0xff0f0f0f|rand.nextInt(1<<24));
		}
		return L;
	}

	public DTNode R(){
		if(R == null){
			R = new SimpleDTNode(this, data().Param());
			//L.colorBG(0xff0f0f0f|rand.nextInt(1<<24));
		}
		return R;
	}
	
	public void removeChilds(){
		L = R = null;
	}
	
	public Rect LRect(Rect parentRect){
		return horiz() ? insideBorder(parentRect).left(split()) : insideBorder(parentRect).top(split());
	}
	
	public Rect RRect(Rect parentRect){
		return horiz() ? insideBorder(parentRect).right(1-split()) : insideBorder(parentRect).bottom(1-split());
	}
	
	public int colorBG(){
		return colorBG;
	}
	
	public void colorBG(int argb){
		colorBG = argb;
	}

}
