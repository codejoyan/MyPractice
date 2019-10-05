package com.interview.searching;

import java.util.HashMap;
import java.util.Map;

public class LeastPosMissingNum {
	
	int missingNumber(int arr[], int n) {
		int smallestNum=-1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			if (!map.containsKey(arr[i])) {
			    map.put(arr[i], 1);	
			} else {
				map.put(arr[i], map.get(arr[i])+1);	
			}
			
		}
		
		for (int i=1; i<1000000; i++) {
			if (!map.containsKey(i)) {
				smallestNum = i;
				break;
			}
		}
		return smallestNum;
	}

	public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5};
		int[] arr = {0, -10, 1, 3, -20};
        LeastPosMissingNum l = new LeastPosMissingNum();
        System.out.println(l.missingNumber(arr, arr.length));
        
	}

}
