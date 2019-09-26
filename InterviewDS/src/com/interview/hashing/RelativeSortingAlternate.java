package com.interview.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortingAlternate {

	private Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

	void relativeSort(int[] a1, int[] a2) {
		for (int i=0; i<a1.length; i++) {
			if (map.containsKey(a1[i])) {
				map.put(a1[i], map.get(a1[i])+1);
			} else {
				map.put(a1[i], 1);
			}
		}
		
		for (int i=0; i<a2.length; i++) {
		    if (map.containsKey(a2[i])) {
		    	for (int j=1;j<=map.get(a2[i]);j++) {
		    		System.out.print(a2[i]+" ");
		    	}
		    	map.remove(a2[i]);
		    }
		}
		
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			for (int j=1;j<=map.get(entry.getKey());j++) {
			    System.out.print(entry.getKey() + " ");
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {
		try {

			/*
			 * int[] p1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}; int[] p2 = {2, 1,
			 * 8, 3}; printArray(relativeSort(p1, p2)); for (Map.Entry<Integer,
			 * Integer> entry: map.entrySet()) {
			 * System.out.println(entry.getKey()+"-"+entry.getValue()); }
			 */

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.valueOf(reader.readLine());
			// System.out.println(n);

			for (int p = 1; p <= n; p++) {
				int[] a1;
				int[] a2;
				String sizes = reader.readLine();
				// System.out.println(elements);
				String[] a = sizes.split(" ");
				int size1 = Integer.valueOf(a[0]);
				int size2 = Integer.valueOf(a[1]);
				String line1 = reader.readLine();
				String[] b1 = line1.split(" ");
				int size_1 = b1.length;
				a1 = new int[size_1];
				String line2 = reader.readLine();
				String[] b2 = line2.split(" ");
				int size_2 = b2.length;
				a2 = new int[size_2];
				if (size1 == size_1 && size2 == size_2) {
					for (int i = 0; i < size_1; i++) {
						a1[i] = Integer.parseInt(b1[i]);
					}

					for (int i = 0; i < size_2; i++) {
						a2[i] = Integer.parseInt(b2[i]);
					}
				}
				// printArray(a1);
				// printArray(a2);
				RelativeSortingAlternate g = new RelativeSortingAlternate();
				g.relativeSort(a1, a2);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
