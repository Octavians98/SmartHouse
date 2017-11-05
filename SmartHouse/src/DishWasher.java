
public class DishWasher extends Appliance{

	private static int standardElectricityUse = 2;
	private static int standardGasUse = 0;
	private static int standardWaterUse = 1;
	static int timeOn = 6;
	private int isTime;
	
	public DishWasher(int electricityUse, int gasUse, int waterUse) {
		
		super(electricityUse>=0? electricityUse : standardElectricityUse,
				gasUse>=0? gasUse : standardGasUse, 
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
		 }
	
public boolean safe(){
		
		return true;
	}

public void washDishes(){
	currentState = true;
	isTime = 0;
}
public void timePasses(){//This is an appliance that carries out a task, so for every 15 min(one unit of timeOn),
						//this method it is gonna increment the standard consumed value for every type of resources
						//used by this appliance(this block of comment is the same for every appliance that carries out a task//
	if(currentState){
		addConsumed();
		isTime++;
		if(isTime==timeOn) currentState = false;
	}
}

	public String toString(){
		
		return "DishWasher";
	}

	
}
