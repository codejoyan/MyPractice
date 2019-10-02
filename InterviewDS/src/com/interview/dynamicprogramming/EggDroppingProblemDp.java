package com.interview.dynamicprogramming;

public class EggDroppingProblemDp {

	int getMinCount(int n, int h) {
		int minCount=Integer.MAX_VALUE;
		int[][] dp = new int[n + 1][h + 1];
		
		dp[0][0] = 0;
		for (int j = 1; j <= h; j++) {
			dp[1][j] = j;
		}
		
		for (int i = 1; i <= n; i++) {
		    dp[i][0] = 0;
		    dp[i][1] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= h; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				minCount = Integer.MAX_VALUE;
				for (int k=1; k<=j; k++) {
					minCount = Integer.min(minCount, 1+Integer.max(dp[i-1][k-1], dp[i][j-k]));
				}
				dp[i][j] = minCount;
			}
		}
		return dp[n][h];
	}

	public static void main(String[] args) {
		EggDroppingProblemDp e = new EggDroppingProblemDp();
		System.out.println(e.getMinCount(3, 5));

	}

}
