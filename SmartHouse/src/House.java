import java.util.ArrayList;
import java.util.HashMap;

public class House {

	ArrayList<Appliance> appliances;
	ArrayList<Meter> meters;
	ArrayList<Person> persons;
	
	public House() { //Declaring the arraylist of meters, persons and appliances.
		
		appliances = new ArrayList<Appliance>();
		meters = new ArrayList<Meter>();
		persons = new ArrayList<Person>();
		
	}
	
	public void addMeter(Meter meter){//This method add a meter to the meter list
	
		meters.add(meter);
	}
	
	public void addAppliance(Appliance appliance){//Set the meter reference, this way every appliance will use the correct meter
		appliance.addMeters(meters);
	
		appliances.add(appliance);
	}
	
	public void addPeople(Person person){//This method add a new person to the person list
		 
		persons.add(person);
	}
	public void removeAppliance(Appliance appliance){//This method remove an appliance from the house if there are any,
																																				
		if(appliances.size() != 0){
		for(Appliance app : appliances){
			if(app.equals(appliance)){
		appliances.remove(app);
		break;}}}}
	
	public Person getPerson(){ //This method returns the size of the person list
		
		return persons.get(persons.size()-1);
	}

	
	public ArrayList<Appliance> getAppliances(){
		
		return appliances;
		
	}
	public int appNumber(){
	
		return appliances.size();
	}
	
	public Appliance searchAppliance(String name){
		
		return null;
		
		
	}
	
	public void timePasses(){ //This method carries out the consum simulation for a day(96 units of 15 min time)
		for(int t=1; t<=96; t++){
			for(Appliance appliance : appliances){
				appliance.timePasses();}
			for(Person person : persons){
				person.timePasses(t);
			}
		}
	}

	public void resourcesUsed(){    //This method prints the amount of meters consumed
		for(Meter meter : meters){
			if(meter.getType().equals("electric")){
				System.out.println("Electricity used " + meter.getConsumed());
			}else if(meter.getType().equals("water")){
				System.out.println("Water used " + meter.getConsumed());
				}else if(meter.getType().equals("gas")){
					System.out.println("Gas used " + meter.getConsumed());
				}
		}
	}
	public static void main(String[] args){ 
		Interpreter interpreter = null;
		try {
			interpreter = new Interpreter();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		interpreter.interpret();
		House house = interpreter.returnHouse();
		house.timePasses();
		house.resourcesUsed();}

}
				
				
				
				
				
						
		
