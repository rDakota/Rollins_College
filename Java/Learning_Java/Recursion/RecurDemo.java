/**
 * Recursion Practice
 * @author rowanrichter
 * @date 10/27
 */

import java.util.ArrayList;

public class RecurDemo {
	/**
	 * 
	 * @param x
	 */
	public static void printing(int x) {
		// Stop condition
		if(x == 1) { // without this case it will print infinitely 
			System.out.println("I am printing " + x);
			return;
		}
		else {
			System.out.println("I am printing " + x);
			printing(x - 1); 
			// Recursive function call
			return;
		}
	}
	
	/**
	 * 
	 * @param x number being multiplied
	 * @param y multiplication factor
	 * @return
	 */
	public static int getProd(int x, int y) {
		// Base case
		if (y == 1) {
			return x;
		}
		// Recursive case
		else {
			//System.out.println("x = " + x + ", y = " + y);
			return x + getProd(x, y - 1);
		}
	}
	/**
	 * 
	 * @param x number being multiplied
	 * @param y multiplication factor
	 * @return void bc prints table
	 */
	public static void multTable(int x, int y) {
		// Base case
		if (y == 1) {
			System.out.println(x + " x " + y + " = " + x);
			return;
		}
		// Recursive case
		else {
			multTable(x, y - 1);
			System.out.println(x + " x " + y + " = " + x * y);
			return;
		}
	}
	
	/**
	 * 
	 * @param x
	 */
	public static void printDown(int x) {
		if (x == 1) {
			System.out.println(x);
		}
		else {
			System.out.println(x);
			printDown(x - 1);
		}
	}
	
	/**
	 * 
	 * @param x
	 */
	public static void printDownOther(int x) {
		if (x < 1) {
			return;
		}
		else {
			System.out.println(x);
			printDownOther(x - 1);
		}
	}
	
	/**
	 * 
	 * @param x number to start at
	 * @return
	 */
	public static int arithSum(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		else {
			return x + arithSum(x - 1);
		}
	}
	
	/**
	 * Method 1 to print out multiples of 5
	 * @param mult -- smallest multiple you want printed
	 * @param largestMult -- largest multiple you want to print to
	 */
	public static void printMult(int mult, int largestMult) {
		if (mult == largestMult) {
			System.out.println(mult * 5);
		}
		else {
			System.out.println(5 * mult);
			printMult(mult + 1, largestMult);
		}
	}
	/**
	 * Method 2 to print out multiples of 5
	 * @param last -- last number you want to output
	 * @param limit -- start number
	 */
	public static void printMult2(int last, int limit) {
		if (last + 5 > limit) {
			System.out.println();
		}
		else {
			System.out.println(last + 5);
			printMult2(last + 5, limit);
		}
	}
	
	/**
	 *  prints by 5 upto certain factor of 5
	 * @param y the certain mult factor
	 */
	public static void upto(int y) {
		if (y == 1) {
			System.out.println(5 * y);
			return;
		}
		else {
			upto(y - 1);
			System.out.println(5 * y);
			return;
		}
	}
	
	/**
	 * prints even numbers from n to 1
	 * @param num -- start number
	 */
	public static void evenFrom(int n) {
		if (n < 2) {
			System.out.println();
		} 
		else {
			if (n % 2 == 0) {
				System.out.println(n);
				evenFrom(n - 2);
			} 
			else {
				evenFrom(n - 1);
			}
		}
		
	}
	
	/**
	 * frequency of string
	 * @param a array 
	 * @param currentIndex indexing purposes
	 * @param target String
	 * @return count of string
	 */
	public static int stringFreq(String[] a, int currentIndex, String target) {
		// base cases
		if (a.length == 0) {
			return 0;
		}
		else if (currentIndex == 0) {
			if (a[currentIndex].equals(target))
				return 1;
			else
				return 0;
		}
		// recursive case
		if (a[currentIndex].equals(target))
			return 1 + stringFreq(a, currentIndex - 1, target);
		else
			return stringFreq(a, currentIndex - 1, target);
	}
	
	
	/**
	 * frequency of string
	 * @param a arraylist
	 * @param target String
	 * @return count of string
	 */
	public static int findStringFreq(ArrayList<String> a, String target) {
		// base cases
		if (a.size() == 0)
			return 0;

		
		// recursive case
		if (a.get(0).equals(target)) {
			a.remove(0);
			return 1 + findStringFreq(a, target);
		}
		else {
			a.remove(0);
			return findStringFreq(a, target);
		}
		
	}
	
	/**
	 * frequency of a letter
	 * @param s String
	 * @param currentIndex indexing purposes
	 * @param l character
	 * @return count of letter
	 */
	public static int letterFreq(String s, int currentIndex, char l) {
		// base cases
		if (s.length() == 0) {
			return 0;
		}
		else if (currentIndex == 0) {
			if (s.charAt(currentIndex) == l)
				return 1;
			else
				return 0;
		}
		
		// recursive case
		if (s.charAt(currentIndex) == l)
			return 1 + letterFreq(s, currentIndex - 1, l);
		else
			return letterFreq(s, currentIndex - 1, l);
		
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		// base case
		if (n <= 1) {
			return 1;
		}
		// recursive case
		else {
			return n * factorial(n - 1);
		}
	}
	
	public static int countEvens(ArrayList<Integer> a) {
		// base
		if (a.size() <= 0) {
			return 0;
		}
		
		// recursive case
		else {
			if (a.get(0) % 2 == 0) {
				a.remove(0);
				return 1 + countEvens(a);
			} else {
				a.remove(0);
				return countEvens(a);
			}
		}
	}
	
	  public static boolean isPalindrome(String s) {

	      // Base case: length 0 or 1 is trivially a palindrome
	      if (s.length() <= 1) {
	          return true;
	      }

	      if(s.charAt(0) == s.charAt(s.length()-1)) {
	          return isPalindrome(s.substring(1, s.length()-1));
	      }
	      return false;
	  }
	
	/*
	 * used openai lol
	 */
	public static String reverseString(String s) {
		  // base case: if the length of the string is 0 or 1, the string is already reversed
		  if (s.length() <= 1) {
		    return s;
		  }
		  // recursive step: reverse the substring starting at the second character
		  // and append the first character to the end of the reversed substring
		  return reverseString(s.substring(1)) + s.charAt(0);
		}
	
	
	
	public static void main(String[] args) {
		
		//ArrayList<Integer> a = new ArrayList<Integer>();
		//a.add(1); a.add(2); a.add(3); a.add(4); a.add(5); a.add(6);
		//a.add(7); a.add(8); a.add(9); a.add(10); a.add(11); a.add(12);
		
		//System.out.println(countEvens(a));
		
		//System.out.println(reverseString("racecar"));
		
		//System.out.println(reverseString("papap"));


		//printing(5);
		
		//System.out.println(getProd(2, 10));
		
		//multTable(4, 12);
		
		//upto(7);
		
		//printDown(17);
		
		//printDownOther(17);
		
		//System.out.println(arithSum(4));
		
		//System.out.println(factorial(3));
		
		//printMult2(0, 25);
		
		//printMult(1, 5);
		
		//evenFrom(21);
		
		//System.out.println(isPalindrome("racecar"));
		//System.out.println(isPalindrome("poop"));
		//System.out.println(isPalindrome("abra"));
		
		String words[] = {"happy", "sad", "dumb", "dumb", "sad", "dumb", "sleepy", "sad"};
		
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("happy");
		wordList.add("sad");
		wordList.add("dumb");
		wordList.add("dumb");
		wordList.add("sad");
		wordList.add("sad");
		wordList.add("dumb");
		wordList.add("sad");
		
		
		int wordCount = stringFreq(words, words.length - 1, "happy");
		
		System.out.println(wordCount);
		
		int wordListCount = findStringFreq(wordList, "dumb");
		
		System.out.println(wordListCount);
		
		String word = "banana";
		
		int wordLength = letterFreq(word, word.length() - 1, 'b');
		
		System.out.println(wordLength);
	}

}
