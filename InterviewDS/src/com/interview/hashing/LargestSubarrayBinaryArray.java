package com.interview.hashing;

import java.util.HashSet;
import java.util.Set;

public class LargestSubarrayBinaryArray {
	
	static int largestSub(int[] arr) {
		int max=0;
		for (int i=0; i<arr.length;i++) {
			int count0 = 0;
			int count1 = 0;
			for (int j=i; j<arr.length;j++) {
				if (arr[j]==0) count0++;
				if (arr[j]==1) count1++;
				
				if (count0==count1 && (2*count0) > max) {
					max = (2*count0);
				}
			}
		}
		return max;
	}
	
	static int largestSubHash(int[] arr) {
		int prefixSum=0;
		int max=0;
		Set<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        int val;
		for (int i=0; i<arr.length;i++) {
			if (arr[i]==0) {
				val = -1;
			} else {
				val = arr[i];
			}
		    prefixSum += val;
		    if (hs.contains(prefixSum)) {
		    	if (max<(i-prefixSum+1)) {
		    		max=i-prefixSum+1;
		    	}
		    }
		    hs.add(prefixSum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,1,0,1,1,0};
		//int[] arr = {1,1,1};
		//int[] arr = {1,1,1,1,0,0,1,1,1,1,0,0};
		System.out.println(largestSub(arr));
		System.out.println(largestSubHash(arr));
	}

}
