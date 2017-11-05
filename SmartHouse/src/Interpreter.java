import java.lang.reflect.Constructor;
import java.util.Scanner;


public class Interpreter { 

	public String[] input;
	House house = new House();
	Reader reader = new Reader();
	Scanner userInput = reader.read();



	public void interpret(){
		while(userInput.hasNextLine()){

			input = userInput.nextLine().split(":|\\,");//we call the split method for every line in order to split the input by ":" and ","

			switch(input[0].toLowerCase()){ //toLowerCase will make the program non key sensitive
			case"house":
				this.house = new House(); //new house is created
				break;
			case "electricmeter": case "gasmeter": case "watermeter":
				try {
					int consumed = 0, generated =0;
					boolean canGenerate = false; 
					int i;
					boolean can = false;
					for (i=1; i<input.length; i++){ 
						if (input[i].equals("true") || input[i].equals("false")){ 
							can = true;
							break;
						}
					}

					if (can){ 
						for (int p=1; p<=i-1; p++){ 
							if (p==1){
								consumed = Integer.parseInt(input[p]); 
							}
							if (p==2){
								generated = Integer.parseInt(input[p]);
							}
						}
						if (input[i].equals("true")){
							canGenerate = true; 
						}
					}
					else{
						for (int p=1; p<input.length; p++){ 
							if (p==1){
								consumed = Integer.parseInt(input[p]);
							}
							if (p==2){
								generated = Integer.parseInt(input[p]);
							}
						}
					}
					//Adding the specific meters to the house
					if(input[0].toLowerCase().equals("electricmeter")){
						ElectricMeter electricmeter = new ElectricMeter(consumed, generated, canGenerate);
						house.addMeter(electricmeter);
					}
					if(input[0].toLowerCase().equals("gasmeter")){
						GasMeter gasmeter = new GasMeter(consumed, generated, canGenerate);
						house.addMeter(gasmeter);
					}
					if(input[0].toLowerCase().equals("watermeter")){
						WaterMeter watermeter = new WaterMeter(consumed, generated, canGenerate);
						house.addMeter(watermeter);
					}}
				catch (Exception e){
					System.err.println("We don`t use that meter in this house");
				}break;
				//Adding appliances tot the house, if there are more than 25 appliances in the house already, we will get an error message
			case "tv": case "electriccooker": case "dishwasher": case "refrigerator": case "washingmachine":
			case "kettle": case "nightlight": case "powershower": case "electricshower": case "boiler": case "gascooker":
				
					if(house.appNumber() >= 25){
						System.err.println("The house is full of appliances already");
						break;
					}

					int electricityUse = -1;
					int waterUse = -1;
					int gasUse = -1;
					for(int c = 1; c<input.length; c++){
						switch(c){
						case 1 : 
							electricityUse = Integer.parseInt(input[1]);
							break;
						case 2 :
							gasUse = Integer.parseInt(input[2]);
							break;
						case 3 :
							waterUse = Integer.parseInt(input[3]);
							break;
						default:
							System.err.println("Incorect value");
							break;
						}
					}
					
					try{
					Class<?> newClass = Class.forName(input[0]);
					Constructor<?> newConstructor = newClass.getConstructor(int.class, int.class, int.class);
					Appliance app = (Appliance)newConstructor.newInstance(electricityUse, gasUse, waterUse);
					house.addAppliance(app);
				}catch(Exception e){
					System.err.println(e.getMessage());
				}break;
			/*
			 * Creating a new person with the values read from the file(we know that for this class we will always have given values)
			 */
			case"person":
				String name;
				int age=-1;
				String gender;
				name = input[1];
				try{
					age = Integer.parseInt(input[2]);
				}catch(Exception e){
					System.err.println("age problem");
				}	gender = input[3];
					
					if(age >= 18){
						GrownUp grownUp = new GrownUp(name, age, gender);
						house.addPeople(grownUp);
					}else{
						Child child = new Child(name, age, gender);
						house.addPeople(child);}
					house.getPerson().appListRef(house.getAppliances());
				break;
				//Adding the task to the house
			case "dowashing": case "boil": case "turnontv": case "turnofftv": case "washdishes": case "turnonboiler": case "turnoffboiler": 
			case "turnonnightlamp": case "turnoffnightlamp": case "cook": case "shower":

				try{
					Person person = house.getPerson();
					int time = Integer.parseInt(input[1]);
					person.addNewTask(time, input[0]);
				}
				catch (Exception e){
					System.err.println(e.getMessage());
				}
				break;	
			}
		}
	}
	public Interpreter() {
	}
	public House returnHouse(){ //Returning the house that was created by the Interpreter
		return this.house;
	}	
}




