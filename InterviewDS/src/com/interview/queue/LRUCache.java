package com.interview.queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LRUCache {

	Map<Integer, Integer> map;
	Map<Integer, Integer> ageMap;
	int capacity;
	int ageCounter;
	int minVal;
	int minKey;

	/* Inititalize an LRU cache with size N */
	public LRUCache(int N) {
		this.capacity = N;
		this.ageCounter = 0;
		map = new HashMap<Integer, Integer>();
		ageMap = new HashMap<Integer, Integer>();
	}

	/*
	 * Returns the value of the key x if present else returns -1
	 */
	public int get(int x) {
		if (map.containsKey(x)) {
			// ageMap.put(x, ageMap.get(x) + 1);
			ageCounter = ageCounter + 1;
			ageMap.put(x, ageCounter);
			return map.get(x);
		} else {
			return -1;
		}
	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		// if (!map.containsKey(x)) {
		minVal = Integer.MAX_VALUE;
		if (map.size() == capacity) {
			if (map.containsKey(x)) {
				for (Map.Entry<Integer, Integer> entry : ageMap.entrySet()) {
					// System.out.println(entry.getKey()+"="+entry.getValue());
					if (entry.getValue() < minVal) {
						minVal = entry.getValue();
						minKey = entry.getKey();
					}
				}
				// System.out.println("minKey:"+minKey);
				ageMap.remove(minKey);
				map.remove(minKey);
			}
		}
		ageCounter = ageCounter + 1;
		ageMap.put(x, ageCounter);
		map.put(x, y);
		// System.out.println("capacity:"+capacity+"size:"+map.size());
		// }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			Set<Integer> s = new HashSet<Integer>();
			int n = sc.nextInt();
			LRUCache g = new LRUCache(n);
			int q = sc.nextInt();

			while (q > 0) {

				String c = sc.next();
				// System.out.println(c);
				if (c.equals("GET")) {
					int x = sc.nextInt();
					System.out.print(g.get(x) + " ");
				}
				if (c.equals("SET")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					g.set(x, y);
				}

				q--;
				// System.out.println();
			}
			t--;
			System.out.println();
		}
	}

}
