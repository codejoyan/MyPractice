package com.interview.sorting;

public class QuickSort {
	
	static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr,low,high);
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}
	
	static int partition(int[] arr, int low, int high) {
		int temp;
		int pivot = arr[high];
		int i = low-1;
		
		for (int j=0; j<high; j++) {
			if (arr[j] <= pivot) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[high];
		arr[high] = arr[i+1];
		arr[i+1] = temp;
		return i+1;
	}

	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 3, 5};
		sort(arr, 0, 4);
		
        for (int i=0; i<arr.length; i++) {
    	    System.out.println(arr[i]);
        }

	}

}
