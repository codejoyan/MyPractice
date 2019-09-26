package com.interview.matrix;

public class SpiralTraversal {

	static void spiralTraversal(int[][] mat) {
		int R = mat.length;
		int C = mat[0].length;

		int r = R;
		int c = C;
		while (r >= 1 && c >= 1) {
			// Print 1st row
			for (int j = 0; j < c; j++) {
				System.out.println(mat[0][j]);
			}
			mat = resizeMatrix(mat, true, 0, false, 0);
			if (mat != null) {
				r = mat.length;
				c = mat[0].length;
			} else {
				r=0;
				c=0;
			}
			if (r >= 1 && c >= 1) {
				// Print last column
				for (int i = 0; i < r; i++) {
					System.out.println(mat[i][c - 1]);
				}
				mat = resizeMatrix(mat, false, 0, true, 1);
				if (mat != null) {
					r = mat.length;
					c = mat[0].length;
				} else {
					r=0;
					c=0;
				}
			}

			if (r >= 1 && c >= 1) {
				// Print last row
				for (int j = c - 1; j >= 0; j--) {
					System.out.println(mat[r - 1][j]);
				}
				mat = resizeMatrix(mat, true, 1, false, 0);
				if (mat != null) {
					r = mat.length;
					c = mat[0].length;
				} else {
					r=0;
					c=0;
				}
			}

			if (r >= 1 && c >= 1) {
				// Print first column
				for (int i = r - 1; i >= 0; i--) {
					System.out.println(mat[i][0]);
				}
				mat = resizeMatrix(mat, false, 0, true, 0);
				if (mat != null) {
					r = mat.length;
					c = mat[0].length;
				} else {
					r=0;
					c=0;
				}
			}
		}
	}

	static int[][] resizeMatrix(int[][] mat, boolean rows, int rIndex, boolean columns, int cIndex) {
		int R = mat.length;
		int C = mat[0].length;
		int[][] temp = null;
		if (rows) {
			if (R - 1 >= 1 && C >= 1) {
				temp = new int[R - 1][C];
			} else {
				return null;
			}

			if (rIndex == 0) {
				for (int i = 0; i < R - 1; i++) {
					temp[i] = mat[i + 1];
				}
			} else {
				for (int i = 0; i < R - 1; i++) {
					temp[i] = mat[i];
				}
			}
		}

		if (columns) {
			if (R >= 1 && C - 1 >= 1) {
				temp = new int[R][C - 1];
			} else {
				return null;
			}
			if (cIndex == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 1; j < C; j++) {
						temp[i][j - 1] = mat[i][j];
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C - 1; j++) {
						temp[i][j] = mat[i][j];
					}
				}
			}
		}
		return temp;
	}

	static void printMatrix(int[][] mat) {
		int R = mat.length;
		int C = mat[0].length;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(mat[i][j]);
				System.out.print("-");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 9, 2 }, { 10, 8, 6, 4 }, { 5, 12, 7, 13 }, { 11, 21, 17, 19 } };
		//int[][] mat = { { 97, 45, 21 }, { 2, 91, 67 }, { 12, 51, 37 } };
		int R = mat.length;
		int C = mat[0].length;
		printMatrix(mat);
		System.out.println("--");
		/*
		 * int[][] dest = resizeMatrix(mat, true, 0, false, 0);
		 * printMatrix(dest); System.out.println("--"); dest = resizeMatrix(mat,
		 * true, 1, false, 0); printMatrix(dest); System.out.println("--"); dest
		 * = resizeMatrix(mat, false, 0, true, 0); printMatrix(dest);
		 * System.out.println("--"); dest = resizeMatrix(mat, false, 0, true,
		 * 1); printMatrix(dest); System.out.println("--");
		 */
		spiralTraversal(mat);

	}

}
