
public abstract class Cooker extends Appliance{
	
	public Cooker(int electricityUse, int gasUse, int waterUse, int timeOn)
	{
		super(electricityUse, gasUse, waterUse, timeOn);
		
	}


public boolean safe(){
		
		return false;
	}
	
	public abstract void cook();
	public abstract String toString();
}
