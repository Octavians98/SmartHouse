
public class PowerShower extends Shower{

	private static int standardElectricityUse = 0;
	private static int standardGasUse = 10;
	private static int standardWaterUse = 5;
	private int isTime;
	static int timeOn = 1;
	public PowerShower(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
}
	@Override
	public String toString() {
		return "PowerShower";
	}
public boolean safe(){
		
		return true;
	}
	public void shower(){
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

}
