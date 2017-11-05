import java.io.*;
import java.util.*;
public class Reader {
	public File file;
	public Scanner userInput = null;
	
	public Scanner read(){
		
		file = new File("input.txt");//We are using this to get the information from the file
		try {
			userInput = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("Wrong input file");
		}
		return userInput;//Return the information read from the file
		
		
		
	}

}
