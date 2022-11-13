import java.util.ArrayList;

public class FizzBuzz {
	
    public static ArrayList<String> fizzBuzz(int n) {

        // ArrayList as answer
        ArrayList<String> ans = new ArrayList<String>();

        // add "1", "2", ....... term associated with "n + 1"
        for (int num = 1; num < (n + 1); num++) {
            
            String pattern = Integer.toString(num);

            if (num % 3 == 0) 
                // Divides by both 3 and 5, add FizzBuzz
                pattern = "Fizz";
            if (num % 5 == 0) 
                // Divides by 3, add Fizz
                pattern = "Buzz";
            if (num % 3 == 0 && num % 5 == 0 ) 
                // Divides by 5, add Buzz
                pattern = "FizzBuzz";
            // Not divisible by 3 or 5, add the number
            ans.add(pattern);
        }

        return ans;
    }

	public static void main(String[] args) {
		
		System.out.println(fizzBuzz(15));
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
