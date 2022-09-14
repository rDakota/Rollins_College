/**
 * Valid Anagram Tester using ArrayLists
 */
import java.util.*;

public class Anagram {
	
    public static boolean isAnagram(String s, String t) {
        
        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();
        
        if (s != t && s.length() == t.length()) {
        	// first String
            for (int i = 0; i < s.length(); i++) {
                list1.add(s.charAt(i));
            }
            // second String
            for (int j = 0; j < t.length(); j++) {
                list2.add(t.charAt(j));
            }
            
            //System.out.println(list1.toString());
            //System.out.println(list2.toString());
            
            // sort both ArrayLists
            Collections.sort(list1);
            Collections.sort(list2);
            
            //System.out.println(list1.toString());
            //System.out.println(list2.toString());
            
            // if they are equivalent then return true and is an anagram
            if (list1.equals(list2)) {
            	return true;
            }
            
        }
        
        return false;
        
    }

	public static void main(String[] args) {
		System.out.println(isAnagram("rat", "car"));
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("dusty", "study"));
		System.out.println(isAnagram("bored", "robed"));
		System.out.println(isAnagram("peach", "cheat"));
		System.out.println();
		System.out.println(isAnagram("dust", "study"));
		System.out.println(isAnagram("elbow", "elbow"));
		System.out.println(isAnagram("cider", "cider"));
		

	}

}
