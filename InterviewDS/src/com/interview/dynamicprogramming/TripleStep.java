package com.interview.dynamicprogramming;

import java.util.Arrays;

public class TripleStep {
	
	private static Long dpCalculateStep(int n) {
		Long[] dp = new Long[n+1];
		dp[0]= new Long(1);
		for (int i=1;i<=n;i++) {
			if (i==1) {
				dp[1] = dp[0];
			} else if (i==2) {
				dp[2] = dp[1] + dp[0];
			} else {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}	
		}
		return dp[n];
	}
	
	private static int recCalculateStep(int n) {
		if ( n < 0 ) return 0;
	    if ( n == 0 ) return 1;
		return recCalculateStep(n-1) + recCalculateStep(n-2) + recCalculateStep(n-3);	
        
	}

	public static void main(String[] args) {
	    System.out.println(recCalculateStep(4));
	    System.out.println(dpCalculateStep(4));
	    int i = 1/2;
	    System.out.println(i);
	}

}