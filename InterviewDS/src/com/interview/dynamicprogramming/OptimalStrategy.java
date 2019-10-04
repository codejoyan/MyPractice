package com.interview.dynamicprogramming;

public class OptimalStrategy {

	static long countMaximum(int arr[], int n) {
		return getMaximum(arr, 0, arr.length - 1);

	}

	static long getMaximum(int arr[], int l, int r) {
		long[][] dp = new long[r + 1][r + 1];

		for (int i = r; i >= 0; i--) {
			for (int j = 0; j <= r; j++) {
				if (i == j) {
					dp[i][j] = arr[i];
					//System.out.println("dp[" + i + "][" + j + "]=" + arr[i]);
				} else if (j - i == 1) {
					dp[i][j] = Integer.max(arr[j], arr[i]);
					//System.out.println("dp[" + i + "][" + j + "]=" + Integer.max(arr[j], arr[i]));
				}
			}
		}

		//System.out.println("l:" + l + "r:" + r);
		for (int i = r-2; i >= 0; i--) {
			for (int j = 2; j <= r; j++) {
				if (j > i) {
					dp[i][j] = Long.max(arr[i] + Long.min(dp[i + 1][j - 1], dp[i + 2][j]),
							arr[j] + Long.min(dp[i + 1][j - 1], dp[i][j - 2]));
				}
			}
		}
		return dp[l][r];
	}

	public static void main(String[] args) {
		//int[] arr = { 5, 3, 7, 10 };
		int[] arr = { 8, 15, 3, 7 };
		System.out.println(countMaximum(arr, arr.length));
	}

}
