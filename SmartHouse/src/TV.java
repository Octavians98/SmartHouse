
public class TV extends Appliance{
	
	private static int standardElectricityUse = 1;
	private static int standardGasUse = 0;
	private static int standardWaterUse = 0;
	private int isTime;
	static int timeOn = -1;
	
	public TV(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
}
	
public boolean safe(){
		return true;
	}
	
	@Override
	public String toString() {
		return "TV";
	}

public void turnOnTv(){
	currentState = true;
}

public void turnOffTv(){
	currentState = false;
}

public void timePasses(){
	if(currentState)addConsumed();
}
}
