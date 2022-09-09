/**
 * Use Binet's Formula to calculate the nth term in the Fibonacci sequence
 *
 * Binet's formula is split into pieces in order to calculate more simply
 * 
 * @author rowanrichter
 * CMS 121
 */

import java.util.Scanner;

public class Binet {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a value for n: ");
		
		// Using nextInt method to read a integer for n from the terminal
		int n = input.nextInt();
		
		// temp1 represents the division of a square root outside of the parentheses
		double temp1 = 1 / Math.sqrt(5);
		
		// temp2 represents the golden ratio phi
		double temp2 = (1 + Math.sqrt(5)) / 2;
		
		// temp3 represents the other inner parentheses section
		// that is similar but not exact to the golden ratio
		double temp3 = (1 - Math.sqrt(5)) / 2;
		
		// All three pieces are combined to calculate the nth fibonacci number 
		// using the user provided n
		double NthFibonacciNum = temp1 * (Math.pow(temp2, n) - Math.pow(temp3, n));
		
		// A raw, unrounded, apporximation of the nth fibonacci number is printed below 
		System.out.println("The " + n + "th Fibonacci number is " + NthFibonacciNum + ".");
		
		// Below is an alternative method that provides an approximation of the nth 
		// Fibonacci number rounded to two decimal places
		// System.out.printf("The " + n + "th Fibonacci number is approximately %.2f.", NthFibonacciNum);
		
		input.close();
		
		
		
	}

}
