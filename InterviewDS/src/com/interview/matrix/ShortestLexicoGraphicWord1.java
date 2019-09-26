package com.interview.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ShortestLexicoGraphicWord1 {

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
	
	static int computeWeight(String[] result) {
		int weight = 0;
		for (int i=0;i<result.length;i++) {
			weight = weight + lookUpWeights(result[i]);
		}
		return weight;
	}
	
	static String buildResult(String[] result) {
		String finalStr = "";
		for (int i=0;i<result.length;i++) {
			finalStr = finalStr + result[i];
		}
		return finalStr;
	}

	public static void findNeighbor(int x, int y, String[] result, int[][] b, int idx) {

		if (x < xMax && y < yMax && b[x][y] == 1) {
			result[idx] = a[x][y];
			b[x][y] = 1;

			if (idx == s-1) {
				int weight = computeWeight(result);
				String resultStr = buildResult(result);
				if (s1.isEmpty()) {
					s1.push(weight);
					s2.push(resultStr);
				} else if (weight < s1.peek()) {
					s1.push(weight);
					s2.push(resultStr);
				}
				return;
			}
		}
		findNeighbor(x, y + 1, result, b, idx + 1);
/*		findNeighbor(x, y - 1, result, b, idx + 1);
		findNeighbor(x + 1, y, result, b, idx + 1);
		findNeighbor(x + 1, y + 1, result, b, idx + 1);
		findNeighbor(x + 1, y - 1, result, b, idx + 1);
		findNeighbor(x - 1, y, result, b, idx + 1);
		findNeighbor(x - 1, y + 1, result, b, idx + 1);
		findNeighbor(x - 1, y - 1, result, b, idx + 1);*/

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
				int[][] b = new int[xMax][yMax];
				String[] result = new String[s];
				findNeighbor(i, j, result, b, 0);
			}
		}
		System.out.println(s1.peek());
		System.out.println(s2.peek());

	}

}
