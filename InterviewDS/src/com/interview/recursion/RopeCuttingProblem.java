package com.interview.recursion;

public class RopeCuttingProblem {

	private static int MaxCut(int n, int a, int b, int c) {
		if (n == 0 ) return 0;
		if (n < 0) return -1;
		
		int r = Integer.max(MaxCut(n-a, a, b, c), Integer.max(MaxCut(n-b, a, b, c), MaxCut(n-c, a, b, c)));
		
		if (r == -1 ) return -1;
		return r+1;
	}
	
	public static void main(String[] args) {
	    System.out.println(MaxCut(23,11,9,12));	

	}

}
