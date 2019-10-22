package com.interview.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;



public class FindIslandCount {

	static Map<String, String> map = null;
	static Map<String, Integer> visitMap = null;
	static Map<String, String> parentSetValue = null;
	static Set<String> parentSet = null;
	static Queue<String> queue = null;

	static void setAdj(ArrayList<ArrayList<Integer>> list, int r, int c, String parentKey, int N, int M) {
		String key = r + "-" + c;
		if (!visitMap.containsKey(key)) {
			if ((r >= 0 && r < N) && (c >= 0 && c < M)) {
				if (list.get(r).get(c) == 1) {
					// System.out.println(key + "!!" + parentKey + "!!" +
					// map.get(key));
					if (map.containsKey(key) && (map.get(key) != parentKey)) {
						// System.out.println("enter");
						if (map.get(key).compareTo(parentKey) < 0) {
							parentSetValue.put(parentKey, map.get(key));
							parentSetValue.put(map.get(key), map.get(key));
						} else {
							parentSetValue.put(parentKey, parentKey);
							parentSetValue.put(map.get(key), parentKey);
						}
					} else {
						if (parentSetValue.containsKey(parentKey)) {
							parentSetValue.put(parentKey, parentSetValue.get(parentKey));
						} else {
							parentSetValue.put(parentKey, parentKey);
						}
						map.put(key, parentKey);
					}
				}
			}
		}
	}

	static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
		String parent;
		map = new HashMap<String, String>();
		visitMap = new HashMap<String, Integer>();
		parentSet = new HashSet<String>();
		parentSetValue = new HashMap<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list.get(i).get(j) == 1) {
					String current = i + "-" + j;
					visitMap.put(current, 1);
					if (map.containsKey(current)) {
						parent = map.get(current);
					} else {
						parent = current;
					}
					// System.out.println("o" + current.getR() + "-" +
					// current.getC());
					// System.out.println(current.toString()+"-"+parent.toString());
					if (parentSetValue.containsKey(parent)) {
						parentSetValue.put(parent, parentSetValue.get(parent));
					} else {
						parentSetValue.put(parent, parent);
					}
					// parentSet.add(parentSetValue.get(parent));
					setAdj(list, i - 1, j - 1, parent, N, M);
					setAdj(list, i - 1, j, parent, N, M);
					setAdj(list, i - 1, j + 1, parent, N, M);
					setAdj(list, i, j - 1, parent, N, M);
					setAdj(list, i, j + 1, parent, N, M);
					setAdj(list, i + 1, j - 1, parent, N, M);
					setAdj(list, i + 1, j, parent, N, M);
					setAdj(list, i + 1, j + 1, parent, N, M);
				}
			}
		}
		System.out.println(parentSetValue);
		for (Map.Entry<String, String> entry : parentSetValue.entrySet()) {
			parentSet.add(entry.getValue());
		}
		return parentSet.size();
	}
	
	
	static int findIslands1(ArrayList<ArrayList<Integer>> list, int N, int M) {
		queue = new LinkedList<String>();
		map = new HashMap<String, String>();
		visitMap = new HashMap<String, Integer>();
		parentSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (list.get(i).get(j) == 1) {
					String current = i + "!" + j;
					String parent = current;
					//map.put(current, parent);
					//visitMap.put(current, 1);
					queue.add(current);
					while (!queue.isEmpty()) {
						String key = queue.poll();
						//System.out.println(key);
						//System.out.println(key.indexOf("-")-1);
						int row = Integer.valueOf(key.substring(0, key.indexOf("!")));
						//System.out.println(key.substring(key.indexOf("-")+1));
						int col = Integer.valueOf(key.substring(key.indexOf("!")+1));
						//System.out.println(row+"!"+col);
						if (!visitMap.containsKey(key) && (row>=0 && row<N) && (col>=0 && col<M) && list.get(row).get(col)==1) {
							//map.put(key, parent);
							parentSet.add(parent);
							visitMap.put(key, 1);
							queue.add((row-1)+"!"+(col-1));
							queue.add((row-1)+"!"+(col));
							queue.add((row-1)+"!"+(col+1));
							queue.add((row)+"!"+(col-1));
							queue.add((row)+"!"+(col+1));
							queue.add((row+1)+"!"+(col-1));
							queue.add((row+1)+"!"+(col));
							queue.add((row+1)+"!"+(col+1));
						}
					}
				}
			}
		}
		return parentSet.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

			// creating arraylist of arraylist
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> temp = new ArrayList<>(M);
				list.add(i, temp);
			}

			// adding elements to the arraylist of arraylist
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int val = sc.nextInt();
					list.get(i).add(j, val);
				}
			}

			System.out.println(new FindIslandCount().findIslands1(list, N, M));

		}
	}

}
