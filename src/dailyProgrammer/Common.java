package dailyProgrammer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class Common {
		
	public BufferedReader loadFile(String file){
		try{
			BufferedReader t = new BufferedReader(new FileReader(file));
			return t;
		}catch(FileNotFoundException e){
			System.out.println("ERROR: File Not Found");
		}		
		return null;
	}
}
