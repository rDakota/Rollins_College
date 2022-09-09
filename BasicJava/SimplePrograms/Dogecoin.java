/**
 * Conversion calculator of  US dollars to dogecoins
 * 
 * Each dogecoin is the equivalent of $0.16 USD
 * 
 * @author rowanrichter
 * CMS 121
 */

import java.util.Scanner;

public class Dogecoin {

	public static void main(String[] args) {
		
		// Dogecoins are set as a constant variable 
		// and initialized at $0.16
		final double USD_PER_DOGE = 0.16;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an amount in dollars: ");
		
		// Take in input as amount in dollars as a double type
		// nextDouble method reads a double from the terminal
		double dollars = input.nextDouble();
		
		// Calculate dogecoins as double
		double dogecoins = dollars / USD_PER_DOGE;
		
		// Formatted printing of USD in dogecoins to two digits 
		// after the decimal as denoted by %.2f
		System.out.printf("That's %.2f dogecoins.", dogecoins);
		
		// Close the scanner
		input.close();
		
		

	}

}
