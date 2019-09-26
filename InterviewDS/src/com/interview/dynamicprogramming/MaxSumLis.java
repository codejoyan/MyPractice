package com.interview.dynamicprogramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxSumLis {

	private static int MaxSum(int[] arr) {
	    int[] lis = new int[arr.length];
	    int s = 0;
	    
	    for (int i=0; i<arr.length; i++) {
	    	lis[i] = arr[i];
	    	for (int j=0; j<i; j++) {
	    		if (arr[j] < arr[i]) {
	    			lis[i] = lis[i] + arr[j];
	    		} else {
	    			lis[i] = arr[j];
	    		}
	    	}
	    }
	    
        for (int i=0; i<arr.length; i++) {
        	s = Integer.max(s, lis[i]);
        }
        
        return s;
	}
	
	public static void main(String[] args) {
		//int[] arr = {8,9,4,5,7};
		//int[] arr = {1,5,8,2,3,4};
		int[] arr = {1,5,8,3,6,7};
		System.out.println(MaxSum(arr));

	}

}
