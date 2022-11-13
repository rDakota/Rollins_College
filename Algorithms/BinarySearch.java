
public class BinarySearch {
	
	
	public static int reverseBinSearch(int[] nums, int value) {

		int low = 0;
		int high = nums.length - 1;
		
		
		while (low <= high) {
			int guess = (high + low) / 2;
			
			System.out.println(nums[guess]);
			
			if (nums[guess] < value) {
				System.out.println("Too Low");
				high = guess - 1;
			}
			
			else if (nums[guess] > value) {
				System.out.println("Too High");
				low = guess + 1;
			}
			
			else {
				System.out.println("Just high");
				return nums[guess];
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		int myNums[] = {107, 80, 62, 49, 36, 28, 25, 10};
		System.out.println(reverseBinSearch(myNums, 36));

	}

}
