public class ReverseNum {
	
    public static int reverse(int x) {
         int reverseNum = 0;
         while (x != 0) {
        	 int remainder = x % 10;
        	 x = x / 10;
        	 
        	 // if reverse number is outside of range 2^32 
        	 // OR 
        	 // it is equal to at the moment but about to be unequal because remainder is < -8
             if (reverseNum < Integer.MIN_VALUE/10 || (reverseNum == Integer.MIN_VALUE / 10 && remainder < -8)) return 0; 
             
        	 // if reverse number is outside of range -2^32 
        	 // OR 
        	 // it is equal to at the moment but about to be unequal because remainder is >  7
             if (reverseNum > Integer.MAX_VALUE/10 || (reverseNum == Integer.MAX_VALUE / 10 && remainder > 7)) return 0; 
             
             reverseNum = (reverseNum * 10) + remainder;
         }
         return reverseNum;
    }

    
    public static void main(String[] args) {
    	System.out.println(reverse(1463847412));
    	System.out.println(reverse(0));
    	System.out.println(reverse(1534236469));
    	System.out.println(reverse(-123));
    }
}