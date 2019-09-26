package com.interview.sorting;

public class TernaryValuedArraySort {

	static void sort(int[] arr) {
		int lastZeroIdx=0;
		int firstZeroIdx=0;
		int zeroCount=0;
		int lastOneIdx=0;
		int firstOneIdx=0;
		int secondOneIdx=0;
		int oneCount=0;
		int lastTwoIdx=0;
		int firstTwoIdx=0;
		int secondTwoIdx=0;
		int twoCount=0;
		int tmp1;
		int tmp2;
		
        for (int i=0; i<arr.length-1; i++) {
        	if (arr[i] == 0) {
        		if (zeroCount==0) {
        			firstZeroIdx=i;
        		}
        		lastZeroIdx = i;
        		zeroCount++;
        	}
        	if (arr[i] == 1) {
        		if (oneCount==0) {
        			firstOneIdx=i;
        		}
        		if (oneCount==1) {
        			secondOneIdx=i;
        		}
        		lastOneIdx = i;
        		oneCount++;
        	}
        	if (arr[i] == 2) {
        		if (twoCount==0) {
        			firstTwoIdx=i;
        		}
        		if (twoCount==1) {
        			secondTwoIdx=i;
        		}
        		lastTwoIdx = i;
        		twoCount++;
        	}
        	
        	if (arr[i] == 0 && i>lastOneIdx) {
        	    tmp1 = arr[firstOneIdx];
        	    arr[firstOneIdx] = arr[i];
        	    arr[i] = tmp1;
        	    
        	    tmp2 = firstOneIdx;
        	    lastOneIdx = i;
        	    lastZeroIdx=tmp2;
        	    firstOneIdx=Integer.max(firstOneIdx, secondOneIdx);
        	    i = i-1;
        	}
        	
        	if (arr[i] == 1 && i>lastTwoIdx) {
        	    tmp1 = arr[firstTwoIdx];
        	    arr[firstTwoIdx] = arr[i];
        	    arr[i] = tmp1;
        	    
        	    tmp2 = firstTwoIdx;
        	    lastTwoIdx = i;
        	    lastOneIdx=tmp2;
        	    firstTwoIdx=Integer.min(firstTwoIdx, secondTwoIdx);
        	    i = i-1;      		
        	}
        	
        }
	}
	
	public static void main(String[] args) {
	    int[] arr = {0,1,2,0,1,2,0,0,2,1,2,2,1,0};
	    sort(arr);
        for (int i=0; i<arr.length; i++) {
    	    System.out.println(arr[i]);
        }

	}

}
