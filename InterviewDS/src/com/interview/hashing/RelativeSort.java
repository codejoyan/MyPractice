package com.interview.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RelativeSort {
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	static void initLoad(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			map.put(arr[i], i);
		}
	}
	
	static int getRelOrder(int n, int len) {
		if (!map.containsKey(n)){
			map.put(n, n+len);
		}
		return map.get(n);
	}
	
	
	static int[] relativeSort(int[] a1, int[] a2) {
		int[] a, b;
		if (a1.length < a2.length) {
			a = a2;
			b = a1;
			initLoad(a1);
		} else {
			a = a1;
			b = a2;
			initLoad(a2);			
		}
		
        mergeSort(a, 0, a.length-1, b.length);
		return a;
		
	}
	
	static void mergeSort(int[] arr, int low, int high, int len) {
		int mid = low + (high-low)/2;
		if (low < high) {
			mergeSort(arr, low, mid, len);
			mergeSort(arr, mid+1, high, len);
			merge(arr, low, mid, high, len);
		}
	}
	
	static void merge(int[] arr, int low, int mid, int high, int len) {
		int[] helper = new int[arr.length];
		
		for(int i=low; i<=high; i++) {
			helper[i] = arr[i];
		}
		
		int helperLeft = low;
		int helperRight = mid+1;
		int current = low;
		
		while (helperLeft<=mid && helperRight<=high) {
			if (getRelOrder(helper[helperLeft], len) <= getRelOrder(helper[helperRight], len)) {
				arr[current] = helper[helperLeft];
				helperLeft++;
				current++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
				current++;				
			}
		}
		
		int rem = mid-helperLeft;
		for (int i=0; i<=rem; i++) {
			arr[current+i] = helper[helperLeft+i];
		}
	}
	
	static void printArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		try {
			
/*			int[] p1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
			int[] p2 = {2, 1, 8, 3};
			printArray(relativeSort(p1, p2));
			for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
				System.out.println(entry.getKey()+"-"+entry.getValue());
			}*/
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.valueOf(reader.readLine());
			//System.out.println(n);

			for (int p = 1; p <= n; p++) {
				int[] a1;
				int[] a2;
				String sizes = reader.readLine();
				//System.out.println(elements);
				String[] a = sizes.split(" ");
				int size1 = Integer.valueOf(a[0]);
				int size2 = Integer.valueOf(a[1]);
				String line1 = reader.readLine();
				String[] b1 = line1.split(" ");
				int size_1 = b1.length;
				a1=new int[size_1];
				String line2 = reader.readLine();
				String[] b2 = line2.split(" ");
				int size_2 = b2.length;
				a2=new int[size_2];
				if (size1 == size_1 && size2 == size_2) {
					for (int i = 0; i < size_1; i++) {
						a1[i] = Integer.parseInt(b1[i]);
					}
					
					for (int i = 0; i < size_2; i++) {
						a2[i] = Integer.parseInt(b2[i]);
					}
				}
				//printArray(a1);
				//printArray(a2);
				printArray(relativeSort(a1, a2));
			}
			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
