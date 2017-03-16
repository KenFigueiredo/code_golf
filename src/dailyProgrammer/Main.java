package dailyProgrammer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sysIn = new Scanner(System.in);
		System.out.print("Please enter what day's daily program (MonthDDYYYY) you would like to run: ");
		String className = sysIn.nextLine();
		String fullName = "dailyProgrammer." + className;
		className += ".txt";
		sysIn.close();
		
		try {
			Class<?> cls = Class.forName(fullName);
			Class<String> cArg = String.class;
			cls.getDeclaredConstructor(cArg).newInstance(className);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Class not found");
		} catch(InstantiationException e){
			System.out.println("ERROR: Could not instantiate class");
		} catch (IllegalAccessException e) {
			System.out.println("ERROR: Illegal Access");
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: Illegal Argument");
		} catch (InvocationTargetException e) {
			System.out.println("ERROR: Invocation Target");
		} catch (NoSuchMethodException e) {
			System.out.println("ERROR: No Such Method");
		} catch (SecurityException e) {
			System.out.println("ERROR: Security Exception");
		} 
		
	}
}
