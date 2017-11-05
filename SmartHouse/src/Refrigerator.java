public class Refrigerator extends Appliance {
	
	private static int standardElectricityUse = 1;
	private static int standardGasUse = 0;
	private static int standardWaterUse = 0;
	static int timeOn = -1;
	
	public Refrigerator(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);}
public boolean safe(){
		return true;
	}
	@Override
	public String toString() {
		return "Refrigerator";
	}
public void timePasses(){
	addConsumed();
}
	


}
