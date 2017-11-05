
public class GasCoocker extends Cooker {

	private static int standardElectricityUse = 0;
	private static int standardGasUse = 4;
	private static int standardWaterUse = 0;
	static int timeOn = 4;
	private int isTime;
	public GasCoocker(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
}

public String toString(){
		
		return "GasCooker";
	}

public void cook(){
	currentState = true;
	isTime = 0;
}
public boolean safe(){
	
	return false;
}
public void timePasses(){
	if(currentState){
		addConsumed();
		isTime++;
		if(isTime==timeOn)currentState = false;
	}
}

	
}
