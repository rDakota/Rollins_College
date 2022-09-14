/**
 * Recursive method that verifies if a string is a palindrome
 */

public class Palindromes {
 
  public static boolean isPalindrome(String s) {
	  
	   // This removes all whitespace and punctuation and leaves only letters and digits
	   // Must include "_" as well in separate replace method
	   s = s.toLowerCase().replaceAll("\\W", "");
	   s = s.replace("_", "");
	   
	 
      // Base case: length 0 or 1 is trivially a palindrome
      if (s.length() <= 1) {
          return true;
      }

      // Other stopping case: if outer letters don't match, return false
      if (s.charAt(0) != s.charAt(s.length() - 1)) {
    	  return false;
      }
      
      // Recursive case: check if the inner substring is a palindrome
      //
      // substring(1, n) returns the substring starting at index 1 and going up to index n - 1 
      
      String inner = s.substring(1, s.length() - 1);
      return isPalindrome(inner);
  }
  
	public static void main(String[] args) {
		System.out.println(isPalindrome("Nurses run"));
		System.out.println(isPalindrome("cocoococ"));
		System.out.println(isPalindrome(" "));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		

	}

}
