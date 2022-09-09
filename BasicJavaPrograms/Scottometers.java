/**
 * Convert units of miles to Scottometers
 * 
 * Each Scottometer is 1 million miles
 * 
 * Javadoc style headers start with slash-star-star and end with star-slash
 * Javadoc is a program that can read specifically formatted headers and 
 * automatically generate Java documentation
 * 
 * We'll use Javadoc style headers for all of our programs and eventually 
 * For the methods and classes that we write
 * 
 * @author rowanrichter
 * CMS 121
 */

// Java imports go at the top of the program before the class declaration
import java.util.Scanner;

public class Scottometers {

	public static void main(String[] args) {
		
		// Declare a constant variable to store miles per scottometer
		// The keyword final makes a constant variable
		// By convention constants are named in ALL_CAPS with underscores
		// Cannot reassign it to another variable thus protecting the data
		final double MILES_PER_SCOTTOMETER = 1000000.0;
		
		// Our main tool for reading input from the user is the scanner class
		// Scanner can read from the standard system input and then return to us
		// to us the values that it reads
		
		// scan is not significant
		// It is user given name
		
		// New is the memory allocation keyword
		// when you make a variable of object type (like scanner)
		// The new keyword tells Java to allocate memory for that new object
		
		// The right hand side has a special name: the CONSTRUCTOR method
		// The constructor method is called to create new objects of a particular type
		// Constructor method has the same name as the class itself
		// Constructor may take arguments that initialize the new object
		
		// Here, System.in is the standard system input
		// The constructor specifies the creation of a new scanner object
		// that can read from System.in
		

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number of miles: ");
		
		// nextDouble method is used to read a double from the terminal
		double miles = input.nextDouble();
		
		// Calculate Scottometers
		// Sanity check the output
		double sm = miles / MILES_PER_SCOTTOMETER;
		
		// You can combine variables into string output
		// The plus does string concatenation in Java
		
		// Another option is to use printf for formatted output
		// %.2f is the format specifier for a float(double) with two digits after the decimal
		// System.out.printf("That's %.2f scottometers.", sm);
		
		System.out.println("That's " + sm + " scottometers.");
		
		input.close();
	}

}
