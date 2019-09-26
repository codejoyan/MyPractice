package com.interview.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ShortestLexicoGraphicWord {

	public static String a[][];
	public static int s = 0;
	public static int xMax = 0;
	public static int yMax = 0;
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<String> s2 = new Stack<String>();
	static Map<String, Integer> m = new HashMap<String, Integer>();

	static void loadMap() {
		m.put("a", 1);
		m.put("b", 2);
		m.put("c", 3);
		m.put("d", 4);
		m.put("e", 5);
		m.put("f", 6);
		m.put("g", 7);
		m.put("h", 8);
		m.put("i", 9);
		m.put("j", 10);
		m.put("k", 11);
		m.put("l", 12);
		m.put("m", 13);
		m.put("n", 14);
		m.put("o", 15);
		m.put("p", 16);
		m.put("q", 17);
		m.put("r", 18);
		m.put("s", 19);
		m.put("t", 20);
		m.put("u", 21);
		m.put("v", 22);
		m.put("w", 23);
		m.put("x", 24);
		m.put("y", 25);
		m.put("z", 26);
	}

	public static void createMatrix(int x, int y, String[] xStr) {
		a = new String[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				a[i][j] = xStr[i].split(";")[j];
			}
		}
	}

	public static void printMatrix() {
		// int x = a[0].length;
		// int y = a.length;

		for (int i = 0; i < xMax; i++) {
			System.out.println("row" + i);
			for (int j = 0; j < yMax; j++) {
				System.out.println(a[i][j]);
			}
		}
	}

	public static int lookUpWeights(String s) {
		return m.get(s);
	}

	public static int findNeighbor(String elem, int x, int y, String result, int weight, HashMap<String, Integer> m, int seq) {
		int j = 0;
        int flag = 0;
		if (result != null) {
			if (Integer.valueOf(result.length()) > s) {
				//System.out.println(result.length());
				return -1;
			} else if (Integer.valueOf(result.length()) == s) {
				// System.out.println("abc");
				System.out.println(result + ";" + weight);
				if (s1.isEmpty()) {
					s1.push(weight);
					s2.push(result);
				} else if (weight < s1.peek()) {
					s1.push(weight);
					s2.push(result);
				}
				return 1;
			}
		}

		if (((x >= 0) && (x < xMax)) && ((y >= 0) && (y < yMax))) {
			
			if (m.get(seq+":"+x+":"+y) != null) {
				flag = 1;
			} else {
				flag = 0;
			}
			
			if (result == null) {
				result = elem;
			} else {
				result = result + elem;
			}
			weight = weight + lookUpWeights(elem);
			m.put(seq+":"+x+":"+y, 1);
			// 1
			if (((x - 1 >= 0) && (x - 1 < xMax)) && ((y >= 0) && (y < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x - 1][y], x - 1, y, result, weight, m, seq);
			}
			// 2
			if (((x - 1 >= 0) && (x - 1 < xMax)) && ((y + 1 >= 0) && (y + 1 < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x - 1][y + 1], x - 1, y + 1, result, weight, m, seq);
			}
			// 3
			if (((x - 1 >= 0) && (x - 1 < xMax)) && ((y - 1 >= 0) && (y - 1 < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x - 1][y - 1], x - 1, y - 1, result, weight, m, seq);
			}
			// 4
			if (((x >= 0) && (x < xMax)) && ((y + 1 >= 0) && (y + 1 < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x][y + 1], x, y + 1, result, weight, m, seq);
			}
			// 5
			if (((x >= 0) && (x < xMax)) && ((y - 1 >= 0) && (y - 1 < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x][y - 1], x, y - 1, result, weight, m, seq);
			}
			// 6
			if (((x + 1 >= 0) && (x + 1 < xMax)) && ((y >= 0) && (y < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x + 1][y], x + 1, y, result, weight, m, seq);
			}
			// 7
			if (((x + 1 >= 0) && (x + 1 < xMax)) && ((y + 1 >= 0) && (y + 1 < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x + 1][y + 1], x + 1, y + 1, result, weight, m, seq);
			}
			// 8
			if (((x + 1 >= 0) && (x + 1 < xMax)) && ((y - 1 >= 0) && (y - 1 < yMax))&& (flag == 0)) {
				j = findNeighbor(a[x + 1][y - 1], x + 1, y - 1, result, weight, m, seq);
			}
		}
		return j;

	}

	public static void main(String[] args) {
		s = 5;
		int count = 0;
		loadMap();
		String[] input = new String[4];
		input[0] = "h;j;i;h";
		input[1] = "g;b;c;s";
		input[2] = "x;e;f;a";
		input[3] = "w;c;j;k";

		createMatrix(4, 4, input);
		xMax = a[0].length;
		yMax = a.length;
		// printMatrix();

		for (int i = 0; i < xMax; i++) {
			for (int j = 0; j < yMax; j++) {
				count++;
				findNeighbor(a[i][j], i, j, null, 0, new HashMap<String, Integer>(), count);
			}
		}
		System.out.println(s1.peek());
		System.out.println(s2.peek());

	}

}
