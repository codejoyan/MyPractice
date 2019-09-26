package com.interview.dynamicprogramming;

public class RopeCuttingProblem {

	private static int MaxCut(int n, int a, int b, int c) {
		int x = -1, y = -1, z = -1;
		int[] dp = new int[n + 1];
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i] = -1;

			if (i - a >= 0) {
				x = dp[i - a];
			}

			if (i - b >= 0) {
				y = dp[i - b];
			}

			if (i - c >= 0) {
				z = dp[i - c];
			}

			if (x == -1 && y == -1 && z == -1) {
				dp[i] = -1;
			} else {
				dp[i] = 1 + Integer.max(x, Integer.max(y, z));
			}

		}

		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(MaxCut(23, 11, 9, 12));

	}

}
