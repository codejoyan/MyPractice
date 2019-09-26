package com.interview.sorting;

public class MergeSortApplications {

	
	private static int count=0;
	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int[] helper = new int[arr.length];
		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
		}

		int helperLeft = low;
		int helperRight = mid+1;
		int current = low;

		while (helperLeft <= mid && helperRight <= high) {

			if (helper[helperLeft] <= helper[helperRight]) {
				arr[current] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = mid - helperLeft;
		for (int i=0; i<=remaining; i++) {
			arr[current+i] = helper[helperLeft+i];
		}
		

	}
	
	public static int invCount(int[] arr, int low, int high) {
		int inv_count = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			inv_count = invCount(arr, low, mid);
			inv_count = inv_count + invCount(arr, mid + 1, high);
			inv_count = inv_count + invMerge(arr, low, mid, high);
		}
        return inv_count;
	}

	public static int invMerge(int[] arr, int low, int mid, int high) {
		int[] helper = new int[arr.length];
		//String pr="";
		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
			//pr=helper[i]+","+pr;
		}

		int inv_count=0;
		int helperLeft = low;
		int helperRight = mid+1;
		int current = low;
		//System.out.println("low:"+low+"::mid:"+mid+"::high"+high);
		//System.out.println(pr);

		while (helperLeft <= mid && helperRight <= high) {

			//System.out.println("left:"+helper[helperLeft]+"::right:"+helper[helperRight]);
			if (helper[helperLeft] <= helper[helperRight]) {
				arr[current] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
				inv_count = inv_count + (mid-helperLeft+1);
				//System.out.println("count:"+count);
			}
			current++;
		}
		
		int remaining = mid - helperLeft;
		for (int i=0; i<=remaining; i++) {
			arr[current+i] = helper[helperLeft+i];
		}
		return inv_count;

	}

	public static void main(String[] args) {
        //int[] arr = {2, 5, 15, 7, 10};
        int[] arr = {2, 4, 1, 3, 5};
		//int[] arr = {9, 6, 1, 3, 10, 2};
        //mergeSort(arr, 0, arr.length-1);
        
        //for (int i=0; i<arr.length; i++) {
        	//System.out.println(arr[i]);
        //}
        //invCount(arr, 0, arr.length-1);
        System.out.println(invCount(arr, 0, arr.length-1));
        
	}

}
