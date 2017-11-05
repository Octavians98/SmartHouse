/**This class is the abstract super class for the appliances that are we will implement later.
 * 
 */

/**
 * @author Octavian

 *
 */
import java.util.ArrayList;

public abstract class Appliance {

	private int electricityUse;
	private int gasUse;
	private int waterUse;
	public int timeOn;
	boolean currentState;
	private ArrayList<Meter> meters;
	
	public Appliance(int electricityUse, int gasUse, int waterUse, int timeOn) {
		super();
		this.electricityUse = electricityUse;
		this.gasUse = gasUse;
		this.waterUse = waterUse;
		this.timeOn = timeOn;
		
	}
	
	public void addMeters(ArrayList<Meter> meters)
	{
		this.meters = meters;
	}

	public void addConsumed()//This methods counts how many electric, gas, water meters the house consume in a day.
	{
		for(Meter meter : meters){
			if(meter.getType() == "electric") meter.incrementConsumed(electricityUse);
			if(meter.getType() == "gas") meter.incrementConsumed(gasUse);
			if(meter.getType() == "water") meter.incrementConsumed(waterUse);
		}
	}
	public abstract void timePasses();
	public abstract String toString();
	

	
}
