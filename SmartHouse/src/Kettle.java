
public class Kettle extends Appliance {

	private static int standardElectricityUse = 20;
	private static int standardGasUse = 0;
	private static int standardWaterUse = 1;
	private int isTime;
	static int timeOn = 1;
	public Kettle(int electricityUse, int gasUse, int waterUse) {
		
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
		 
	}
	
public boolean safe(){
		
		return false;
	}

public void boil(){
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
public String toString(){
		
		return "Kettle";
	}
}

