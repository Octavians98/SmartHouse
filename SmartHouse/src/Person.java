import java.util.HashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class Person {

	public String name;
	public int age;
	public String gender;
	HashMap<Integer, String> taskList;
	ArrayList<Appliance> appliances;
	Class getClass = String.class;
	public Person(String name, int age, String gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		taskList = new HashMap<Integer, String>();
	}
	
	public String getName(){//Return the name of the person
		
		return name;
	}
	
	public String getGender(){//Return the gender of the person(I know it`s wrong to assume a gender but in this house only male and female are accepted(sorry about that))
		
		return gender;
	}
	
	public int getAge(){//Return the age of the person
		
		return age;
	}
	
	public void appListRef(ArrayList<Appliance> app){//Set the reference of the appliances
		
		this.appliances = app;
	
	}

	public void addNewTask(int time, String newTask){//Add a new task to the tasks hashmap
		
		taskList.put(time, newTask);
	}
	
	public void timePasses(int time){//Checks at what time the task should start and use a person to carry out the task(S)
		
		for(int startTime: taskList.keySet()){
			if(startTime == time){
				for(Appliance currentApp : appliances){
				
					Method[] methods = currentApp.getClass().getDeclaredMethods();
					for(Method metod : methods){
						
						if(metod.getName().equalsIgnoreCase(taskList.get(startTime))){
						
							try {
								metod.invoke(currentApp,null);
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
			
			
		}
		
	}
	
	
}
