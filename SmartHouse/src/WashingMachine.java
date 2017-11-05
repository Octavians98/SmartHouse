
public class WashingMachine extends Appliance {
	
	private static int standardElectricityUse = 1;
	private static int standardGasUse = 0;
	private static int standardWaterUse = 0;
	private int isTime;
	static int timeOn = 8;
	public WashingMachine(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
	}
	
public boolean safe(){
		
		return true;
	}
	
public void doWashing(){
	currentState = true;
	isTime = 0;
}
public void timePasses(){
	if(currentState){
		addConsumed();
		isTime++;
	if(isTime==timeOn)currentState = false;
	}
}

	@Override
	public String toString() {
		return "WashingMachine";
	}

}
