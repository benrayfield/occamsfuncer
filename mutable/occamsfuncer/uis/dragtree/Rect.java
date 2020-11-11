package mutable.occamsfuncer.uis.dragtree;

public final class Rect{
	
	public final double x, y, w, h;
	
	public Rect(double x, double y, double w, double h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public Rect left(double fraction){
		if(fraction == 1) return this;
		return new Rect(x,y,w*fraction,h);
	}
	
	public Rect right(double fraction){
		if(fraction == 1) return this;
		return new Rect(x+w*(1-fraction),y,w*fraction,h);
	}
	
	public Rect top(double fraction){
		if(fraction == 1) return this;
		return new Rect(x,y,w,h*fraction);
	}
	
	public Rect bottom(double fraction){
		if(fraction == 1) return this;
		return new Rect(x,y+h*(1-fraction),w,h*fraction);
	}
	
	/** borderThickness ranges 0 to .5 (limiting it to 0 to 1/3 so can still see whats inside),
	usually very near 0. Its fraction of smallest dimension the border is thick on all 4 sides.
	FIXME might need to redesign the border norming math cuz rects are normed to be inside width 1 height 1.
	*/
	public Rect insideBorder(double borderThicknessFractionX, double borderThicknessFractionY){
		if(borderThicknessFractionX < 0 || 1./3 < borderThicknessFractionX) throw new RuntimeException("borderThicknessFractionX="+borderThicknessFractionX);
		if(borderThicknessFractionY < 0 || 1./3 < borderThicknessFractionY) throw new RuntimeException("borderThicknessFractionY="+borderThicknessFractionY);
		/*double minWH = Math.min(w,h);
		double borderThickness = minWH*borderThicknessFraction;
		return new Rect(x+borderThickness, y+borderThickness, w-borderThickness*2, h-borderThickness*2);
		*/
		double borderThicknessX = w*borderThicknessFractionX;
		double borderThicknessY = h*borderThicknessFractionY;
		return new Rect(x+borderThicknessX, y+borderThicknessY, w-borderThicknessX*2, h-borderThicknessY*2);
		
	}
	
	public String toString(){
		return "<x"+x+" y"+y+" w"+w+" h"+h+">";
	}
	
	/** inclusive on all borders */
	public boolean containsXY(double x, double y){
		return this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h;
	}

}