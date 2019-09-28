package com.interview.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FindKthElement {
	
	int searchElement(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int k=0;
		for (int i=0; i<arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
		}	
	    }
		
		for (int i=0; i<=100000; i++) {
			if (map.containsKey(i)) {
				k=k+1;
			}
			
			if (k==n) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		try {
			
/*			int[] p1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};*/			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.valueOf(reader.readLine());

			for (int p = 1; p <= n; p++) {
				int[] a1;
				int size = Integer.valueOf(reader.readLine());
				a1 = new int[size];
				String arrayLine = reader.readLine();
				String[] a = arrayLine.split(" ");
				String element = reader.readLine();
				if (size == a.length) {
					for (int i = 0; i < size; i++) {
						a1[i] = Integer.parseInt(a[i]);
					}
				}
				FindKthElement f = new FindKthElement();
				System.out.println(f.searchElement(a1, Integer.valueOf(element)));
			}
			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

