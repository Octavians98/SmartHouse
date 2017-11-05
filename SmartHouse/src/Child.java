//This class creates the "child type" person, also we know that age, name and gender are always given by the user so we don`t
//need to use default values for this constructor.
public class Child extends Person {
	
	public Child(String name, int age, String gender){
		
		super(name,age,gender);
	}

}
