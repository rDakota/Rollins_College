/**
 *  Merging 2 Arrays
 * @author rowanrichter
 *
 */

import java.util.Arrays;


public class MergeArrays {
	
	 public static int[] merge(int[] a, int n, int[] b, int m) {
	        int i = n - 1; // elements in a
		    int j = m - 1; // elements in b
		    int k = m + n - 1; // elements in a and b combined
	 
		    while (k >= 0) { // while have not gone through both together
			    if (j < 0 || (i >= 0 && a[i] > b[j])) {
				    a[k] = a[i];
	                k--;
	                i--;
			    } else {
				    a[k] = b[j];
	                k--;
	                j--;
			    }
		    }
		    return a; // merge sorted in place of a
	    }

	public static void main(String[] args) {
		
		/*
		 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
		 * Output: [1,2,2,3,5,6]
		 */
		
		//int nums1[] = {1,2,3,0,0,0};
		
		//int m = 3;
		
		//int nums2[] = {2,5,6};
		
		//int n = 3;
		
		/*
		 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
		 * Output: [1]
		 */
		
		int nums1[] = {1};
		
		int m = 1;
		
		int nums2[] = {};
		
		int n = 0;
		
		/*
		 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
		 * Output: [1]
		 */
		
		//int nums1[] = {0};
		
		//int m = 0;
		
		//int nums2[] = {1};
		
		//int n = 1;
		
		
		int merged[] = merge(nums1, m, nums2, n);
		
		System.out.println(Arrays.toString(merged));
		

	}

}
