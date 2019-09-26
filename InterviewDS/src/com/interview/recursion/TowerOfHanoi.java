package com.interview.recursion;

public class TowerOfHanoi {
	static long moves=0;
	static void towerOfHanoi(int n, int s, int t, int a) {
		moves++;
		if (n == 1) {
			System.out.println("move disk 1 from rod "+s+" to rod "+t);
			return;
		}
		towerOfHanoi(n-1, s, a, t);
		System.out.println("move disk "+n+" from rod "+s+" to rod "+t);
		towerOfHanoi(n-1, a, t, s);
	}
	
	public static void main(String[] args) {
		towerOfHanoi(3, 1, 3, 2);
		System.out.println(moves);

	}

}
