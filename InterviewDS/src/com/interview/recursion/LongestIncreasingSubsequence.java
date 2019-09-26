package com.interview.recursion;

public class LongestIncreasingSubsequence {
	
	static int lis(int[] arr, int[] lis, int n) {
      
		if (n==1) {
			return 1;
		}
		
		if (n==arr.length) {
			return getMax(lis);
		}
		
		for (int j=0; j<n; j++) {
           if (arr[j] < arr[n] && (lis[n] < lis[j] + 1))  {
        	   lis[n] = lis[j] + 1;
           }
      }
      return lis(arr, lis, n+1);
	}
	
	static int getMax (int[] arr) {
	    int max=0;
	    for (int i=0; i<arr.length;i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
	    return max;
	}
		
	static void printArray(int[] arr) {
		for (int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("----");
	}
	
	public static void main(String[] main) {
		//int[] arr = {1,5,8,3,6,7};
		int[] arr = {3,4,8,2,9,6};
		int[] lis = new int[arr.length];
		for (int i=0; i<arr.length;i++) {
			lis[i] = 1;
		}
	    System.out.println(lis(arr, lis, 1));	
	}

}
