package com.interview.array;

public class RearrangeAlternate {
	
	public static void rearrange(int arr[], int n){
		int i;
		int j;
		int temp;
		if (n%2 == 0) {
	    	i = n/2;
	    	j = n/2-1;
	    	temp = arr[i];
	    	arr[i] = arr[j];
	    	arr[j] = temp;
	    	i=i-2;
	    	j=j+2;
	    } else {
	    	i = n/2-1;
	    	j = n/2+1;	    	
	    }
	    
	    while (i>=0 && j<=n) {
	    	temp = arr[j];
	    	for (int k=j; k>i; k--) {
	    		arr[k] = arr[k-1];
	    	}
		    arr[i] = temp;
		    i = i-1;
		    j = j+1;
	    }
	}
	
	public static void main (String[] args) {
	//int[] arr = {3,5,6,17,74,99,101};
	int[] arr = {3,5,6,17,74,99};
	//int[] arr = {12,23,28,43,44,59,60,68,70,85,88,92,124,125,136,168,171,173,179,199,212,230,277,282,306,314,316,325,328,336,337,363,365,368,369,371,374,387,394,414,422,427,430,435,457,493,506,527,531,538,541,546,568,583,650,691,730,737,751,764,778,783,785,789,794,803,809,815,847,858,863,874,887,896,916,920,926,927,930,957,981,997};
	//System.out.println(arr[41]);
	rearrange(arr, arr.length);
	for (int i=0; i<arr.length; i++) {
		System.out.println(arr[i]);
	}
	}

}
