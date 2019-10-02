package com.interview.recursion;

public class EggDroppingProblem {
	
	int getMinCount(int n, int h) {
		if (n==1 || h==0 || h==1) {
			return h;
		}
		int minCount = Integer.MAX_VALUE;
		
		for (int i=1; i<=h; i++) {
			minCount = Integer.min(minCount, 1 + Integer.max(getMinCount(n-1, i-1), getMinCount(n, h-i)));
		}
		return minCount;
	}

	public static void main(String[] args) {
		EggDroppingProblem e = new EggDroppingProblem();
        System.out.println(e.getMinCount(2, 10));
        System.out.println(e.getMinCount(3, 5));
	}

}
 