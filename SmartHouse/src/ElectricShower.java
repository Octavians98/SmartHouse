
public class ElectricShower extends Shower{

	private static int standardElectricityUse = 12;
	private static int standardGasUse = 0;
	private static int standardWaterUse = 4;
	private int isTime;
	static int timeOn = 1;
	public ElectricShower(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
}
	
public String toString(){
	return "ElectricShower";
}

public void shower(){
	currentState = true;
	isTime = 0;
}
public boolean safe(){
	
	return true;
}
	
public void timePasses(){
	if(currentState){
		addConsumed();
		isTime++;
		if(isTime==timeOn)currentState = false;
	}
}
}
