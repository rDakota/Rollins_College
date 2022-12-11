/**
 * Starter code for the recursion practice problems
 *
 * @author CMS 121
 */

public class Recursion {

	/** 
   * Return the length of the Collatz sequence with the given start value
   */
	public static int collatz(int n) {
		// 1 is the Base case:
	    if (n == 1) {
	        return 1;
	    }
	    
	    // Recursive case: return 1 + collatz(m)
	    // where m is the number that comes after 
	    // n using the rules of the sequence
	    
	    // Initialize m as int
	    int m;
	    
	    if (n % 2 == 0) {
	    	m = n / 2;
	    } else {
	    	m = 3 * n + 1;
	    }
	    
		return 1 + collatz(m);
	}
	
	/** 
   * Calculate the nth Fibonacci number, where n can be positive or negative
   */
	public static int fib(int n) {
		
		// Base case
		if (n == 0) {
			return 0;
		}
					
		if (n == 1) {
			return 1;
		}		
				
		// Recursive case
		// definition for negative values
		if (n < 0) {
			return fib(n + 2) - fib(n + 1);
		} 
		// definition for positive values	
		return fib(n - 2) + fib(n - 1);

	}
	
	
	/**
   * Calculate McCarthy's 91 function
   */
	public static int mccarthy(int n) {
		
		// Base case
		if (n > 100) {
			return n - 10;
		}
					
		// Recursive case
		// Do not need the if because these two inequalities are mutually exclusive
		return mccarthy(mccarthy(n + 11));
	}
	
	
	//*** DO NOT EDIT THE CODE BELOW THIS POINT. ***//
	//*** DO NOT EDIT THE CODE BELOW THIS POINT. ***//
	//*** DO NOT EDIT THE CODE BELOW THIS POINT. ***//
	//*** ARE YOU EDITING THE CODE BELOW THIS POINT? STOP IT. ***//
	
	//*** Automated testing ***//
	
	public static boolean validate(int result, int expected) {
	    System.out.println("\tExpected " + expected + "\tGot " + result);
	    if (result == expected) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	
	public static void main(String[] args) {
		
	    int numCorrect = 0;
	    int numTests = 14;
	    
	    // Collatz sequence tests
	    int result = collatz(1);
	    System.out.println("collatz(1)");	
	    if (validate(result, 1)) numCorrect++;
	    
	    result = collatz(8);
	    System.out.println("collatz(8)");
	    if (validate(result, 4)) numCorrect++;
	    
	    result = collatz(6);
	    System.out.println("collatz(6)");
	    if (validate(result, 9)) numCorrect++;
	    
	    result = collatz(11);
	    System.out.println("collatz(11)");
	    if (validate(result, 15)) numCorrect++;
	    
	    System.out.println();
	    
	    // Fibonacci numbers
	    result = fib(0);
	    System.out.println("fib(0)");
	    if (validate(result, 0)) numCorrect++;
	    
	    result = fib(-1);
	    System.out.println("fib(-1)");
	    if (validate(result, 1)) numCorrect++;
	    
	    result = fib(-2);
	    System.out.println("fib(-2)");
	    if (validate(result, -1)) numCorrect++;
	    
	    result = fib(-3);
	    System.out.println("fib(-3)");
	    if (validate(result, 2)) numCorrect++;
	    
	    result = fib(-4);
	    System.out.println("fib(-4)");
	    if (validate(result, -3)) numCorrect++;
	    
	    result = fib(8);
	    System.out.println("fib(8)");
	    if (validate(result, 21)) numCorrect++;
	    
	    System.out.println();
	    
	    // McCarthy's 91 function
	    result = mccarthy(1);
	    System.out.println("mccarthy(1)");
	    if (validate(result, 91)) numCorrect++;
	    
	    result = mccarthy(10);
	    System.out.println("mccarthy(10)");
	    if (validate(result, 91)) numCorrect++;
	    
	    result = mccarthy(91);
	    System.out.println("mccarthy(91)");
	    if (validate(result, 91)) numCorrect++;
	    
	    result = mccarthy(111);
	    System.out.println("mccarthy(111)");
	    if (validate(result, 101)) numCorrect++;
	    
	    // Fraction of successful tests
	    double fraction = (double) numCorrect / (double) numTests;
	    System.out.println();
	    System.out.println("Passed " + numCorrect + " out of " + numTests + " tests.");
	    System.out.println("Fraction passed = " + fraction);

	}

}