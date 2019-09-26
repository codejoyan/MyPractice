package com.interview.dynamicprogramming;

import java.util.Scanner;
import java.math.BigInteger;

public class CatalanNumber {

	private static BigInteger FindCatalanNumber(int n) {
		BigInteger [] dp = new BigInteger[2*n+1];
		if (n==0) return BigInteger.valueOf(0);
		dp[0] = BigInteger.valueOf(1);
		for (int i=1; i<=2*n; i++) {
			dp[(int) i] = dp[(int) (i-1)].multiply(BigInteger.valueOf(i));
		}
		return dp[2*n].divide(((dp[n].multiply(dp[n])).multiply(BigInteger.valueOf(n+1))));
	}
	
	public static void main(String[] args) {
		//System.out.println(FindCatalanNumber(10));
		Scanner sc = new Scanner(System.in);
		String size = sc.nextLine();
		for (int i=1;i<=Integer.valueOf(size);i++) {
		    int input = sc.nextInt();
		    System.out.println(FindCatalanNumber(input));    
		}
	}

}
