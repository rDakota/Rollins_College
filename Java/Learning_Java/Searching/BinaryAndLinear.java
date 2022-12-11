/**
 * Binary and Linear search examples
 * @author rowanrichter
 * @date 10-4-2022
 */
import java.util.ArrayList;


public class BinaryAndLinear {
	
	public static int binarySearch(ArrayList<Integer> a, int value) {
		
		int left = 0;
		int right = a.size() - 1;
		
		while(left <= right) {
			int guess = (left + right) / 2;

			if(value == a.get(guess)) {
				//System.out.println(a.get(guess) + ": Just right");
				return a.get(guess);
			}
			else if(a.get(guess) > value ) {
				//System.out.println(a.get(guess) + ": Too high");
				right = guess - 1;
			}

			else if(a.get(guess) < value){
				//System.out.println(a.get(guess) + ": Too Low");
				left = guess + 1;
			}
		}
		return -1;
	}
	
	public static int linearSearch(ArrayList<Integer> a, int value) {
		int bSearches = 0;
		for(int x = 0; x < a.size(); x++){
			bSearches++;
			if(a.get(x) == value){
				System.out.println("It took " + bSearches + " searches to find the number " + a.get(x));
				return a.get(x);
			}
		}
		return -1;
	}
	
	public static int linSearch(int[] nums, int x) { // ordered array
		int index = 0;
		int searches = 0;
		while ( (index < nums.length) && (nums[index] <= x) ) {
			searches++;
			if (nums[index] == x) {
				System.out.println(searches);
				return nums[index];
			}
			index++;
		}
		System.out.println(searches);
		return -1;
	}
	
	public static int findAndReplace(char[] characters) {
		int index = 0;
		int totalChanged = 0;
		while (index < characters.length) {
			if (characters[index] == 'e') {
				characters[index] = 'E';
				totalChanged++;
			}
			index++;
		}
		return totalChanged;
	}
	
	public static int binSearch(int[] numbers, int key) {
		boolean found = false;
		int right = numbers.length - 1;
		int left = 0;
		int guess = (right + left) / 2;
		int bSearches = 0;
		while (left <= right && found == false) {
			//System.out.println(numbers[guess]);
			bSearches++;
			if (numbers[guess] > key) {
				//System.out.println("Too high");
				right = guess - 1;
			}
			else if (numbers[guess] < key) {
				//System.out.println("Too low");
				left = guess + 1;
			}
			else {
				//System.out.println("Just right");
				found = true;
			}
			guess = (right + left) / 2;
		}
		
		if (found == true) {
			System.out.print("It took " + bSearches + " searches to find the number ");
			return numbers[guess];
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(16);
		nums.add(32);
		nums.add(34);
		nums.add(39);
		nums.add(42);
		nums.add(45);
		nums.add(56);
		nums.add(58);
		nums.add(67);
		nums.add(79);
		
		//char letters[] = {'a', 'R', 'e' ,'p', 'e', 'e', 'w', 'e', 'M'};
		int myNums[] = {17, 24, 32, 40, 44, 52, 55, 60, 65, 67, 71, 72};
		//int myNums[] = {28, 33, 34, 38, 39, 42, 48, 50, 53, 58, 63, 71, 83};
		//System.out.println(findAndReplace(letters));
		//System.out.println(linSearch(myNums, 56));
		//System.out.println(linearSearch(nums, 32)); // big O of n ------- scales linearly
		System.out.println(binarySearch(nums, 42)); // big O of log base 2 of n ------ scales logarithmically
		System.out.println(binSearch(myNums, 32)); // big O of log base 2 of n ------ scales logarithmically
	}
}
