/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;

/** Immutable. Old comments...
Decaying ave and dev.
Changes faster when less data has been added,
up to 1.0 dataAveraged which increases from 0 by decay.
*/
public class DecayBell{
	
	public final double ave, dev, howMuchData;
	
	/** contains no data so ave becomes whatever you first put in it then changes slower and slower the more data you add
	up to the first 1.0 amount of data and from then on it changes the same amount.
	*/
	public DecayBell(){
		this(0,0,0);
	}
	
	public DecayBell(double ave, double dev){
		this.ave = ave;
		this.dev = dev;
		this.howMuchData = 1;
	}
	
	public DecayBell(double ave, double dev, double howMuchData){
		this.ave = ave;
		this.dev = dev;
		this.howMuchData = howMuchData;
	}
	
	public double devOf(double value){
		return (value-ave)/dev;
	}
	
	/** If decayFraction is 0, does nothing. If decayFraction is .1, value replaces
	10% of existing data. Normally decayFraction should be very close to 0 to change it a little.
	If decayFraction is 1, the standard deviation would become 0
	because all the data points would equal, so you probably don't want to do that.
	After calling this, the average and standard deviation will change.
	*/
	public DecayBell add(double value, double decayFraction){
		if(decayFraction < 0 || 1 < decayFraction) throw new RuntimeException("decayFraction="+decayFraction);
		double newAve, newDev, newHowMuchData;
		if(howMuchData == 1){
			//This is caclulated as an infinite number of data points,
			//but instead of using a whole number for the quantity of data points,
			//the total number of data points is 1 and each is epsilon width.
			newAve = ave*(1-decayFraction) + decayFraction*value;
			double newDiff = value-ave;
			double sumOfSquares = dev*dev*(1-decayFraction) + decayFraction*newDiff*newDiff;
			//Don't divide sumOfSquares by quantity of data points because its 1.0
			newDev = Math.sqrt(sumOfSquares);
			newHowMuchData = 1;
		}else if(howMuchData == 0){
			newAve = value;
			newDev = 0;
			newHowMuchData = decayFraction;
		}else{
			newHowMuchData = howMuchData+decayFraction;
			newAve = (ave*howMuchData + decayFraction*value)/newHowMuchData;
			double newDiff = value-ave;
			double sumOfSquares = (dev*dev*howMuchData + decayFraction*newDiff*newDiff)/newHowMuchData;
			newDev = Math.sqrt(sumOfSquares);
			newHowMuchData = Math.min(1,newHowMuchData);
		}
		return new DecayBell(newAve, newDev, newHowMuchData);
	}

	public String toString(){
		if(howMuchData < 1) return "[ave="+ave+" dev="+dev+" dataAveraged="+howMuchData+"]";
		return "[ave="+ave+" dev="+dev+"]";
	}
	
}
