package com.interview.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SortByFrequency {

	 Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	 void populate(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
	}
	
	 boolean equalsCheck(int n1, int n2) {
		if (map.get(n1) > map.get(n2)) {
			return true;
		} else if (map.get(n1) == map.get(n2) && n1 < n2) {
			return true;
		} else {
			return false;
		}
	}

	static void sortByFreq(int arr[], int n) {
		SortByFrequency s = new SortByFrequency();
		s.populate(arr, n);
		s.mergeSort(arr, 0, arr.length - 1);
		s.printArray(arr);

	}

	 void mergeSort(int[] arr, int low, int high) {
		int mid = low + (high - low) / 2;
		if (low < high) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	 void merge(int[] arr, int low, int mid, int high) {
		int[] helper = new int[arr.length];

		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
		}

		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;

		while (helperLeft <= mid && helperRight <= high) {
			if (equalsCheck(helper[helperLeft], helper[helperRight])) {
				arr[current] = helper[helperLeft];
				helperLeft++;
				current++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
				current++;
			}
		}

		int rem = mid - helperLeft;
		for (int i = 0; i <= rem; i++) {
			arr[current + i] = helper[helperLeft + i];
		}
	}

	 void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//int[] a = {5, 5, 4, 6, 4};
		int[] a = {7, 7, 4, 6, 4, 7, 8, 9};
		sortByFreq(a, a.length);

	}

}
