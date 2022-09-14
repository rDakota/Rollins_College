
public class NonRecrusivePalindromes {
	
    public static boolean isPalindrome(String s) {
    	
    	// This removes all whitespace and punctuation and leaves only letters and digits
 	   	// Must include "_" as well in separate replace method
        s = s.replace("_", "");
        s = s.toLowerCase().replaceAll("\\W", "");
        
        // loop only needs to go half way with checks
        for (int i = 0; i < s.length() / 2; i++) {
        	// continually checking the corresponding characters to see if they match
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        // will return true if does not trip anything from for loop
        return true;
    }


	public static void main(String[] args) {
		System.out.println(isPalindrome("Nurses run"));
		System.out.println(isPalindrome("cocoococ"));
		System.out.println(isPalindrome(" "));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		

	}

}
