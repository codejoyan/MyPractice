package com.interview.dynamicprogramming;

public class LongestCommonSubsequence {
	
	static int lcs(int p, int q, String s1, String s2){
		int[][] dp = new int[p+1][q+1];
		for (int i=0; i<=p; i++) {
			dp[i][0] = 0;
		}
		
		for (int j=0; j<=q; j++) {
			dp[0][j] = 0;
		}
		
		for (int i=1; i<=p; i++) {
			for (int j=1; j<=q; j++) {
			    if (s1.charAt(i-1) == s2.charAt(j-1)) {
			    	dp[i][j] = 1 + dp[i-1][j-1];
			    } else {
			    	dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
			    }
			}
		}
		return dp[p][q];
	}

	public static void main(String[] args) {
	    String s1 = "ABCDGH";
	    String s2 = "AEDFHR";
		System.out.println(lcs(s1.length(), s2.length(), s1, s2));

	}

}
