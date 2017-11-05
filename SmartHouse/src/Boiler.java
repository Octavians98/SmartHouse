/*This block of comment is the same for every appliance so I will write it one time only, here.
 * the constructor checks if the values for gas use, electricity use and water use are 0, it this case
 * the defaults value for every appliance will be used instead.
 *
 */
public class Boiler extends Appliance {

	private static int standardElectricityUse = 0;
	private static int standardGasUse = 1;
	private static int standardWaterUse = 0;
	private static int timeOn = -1;
	public Boiler(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : standardElectricityUse,//By using this we are making sure that if no value is given
				gasUse>=0? gasUse : standardGasUse, 					//the appliance will use the default values.
				waterUse>=0? waterUse : standardWaterUse,
						timeOn);
	}
	@Override//This method returns the name of the appliance.
	public String toString() {
		return "Boiler";
	}
	public void turnOnBoiler(){//Because this is a turn on/off type of appliance we are changing the current state to on if someone is turning the boiler on.
		currentState = true;	//This comment is the same for every on/off type appliance
	}
	public void turnOffBoiler(){//And to off is the person wants to turn off the boiler.
		currentState = false;	////This comment is the same for every on/off type appliance
		
	}
 public void timePasses(){//The timePasses function increments consumed meters over time
		if(currentState)addConsumed();
}
	public boolean safe(){//Some task are considered "dangerous" for kids, so this methods return if the task is safe or not.
		
		return false;
	}
	
	
	
}
