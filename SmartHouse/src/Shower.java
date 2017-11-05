
public abstract class Shower extends Appliance {


	public Shower(int electricityUse, int gasUse, int waterUse, int timeOn)
	{
		super(electricityUse, gasUse, waterUse, timeOn);
	}
public abstract void shower();

public boolean safe(){
		return true;
	}
public abstract String toString();



}
