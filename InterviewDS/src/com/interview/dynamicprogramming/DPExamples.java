package com.interview.dynamicprogramming;

public class DPExamples {

	private static int LongIncSub(int[] arr) {
		int[] lis = new int[arr.length];
		int z = 1;
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Integer.max(lis[j] + 1, lis[i]);
				}
				// if (i==4) System.out.println(j+"-"+lis[i]);
			}
			System.out.println("lis[" + i + "]-" + lis[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			z = Integer.max(z, lis[i]);
		}
		return z;
	}

	private static int SumWine(int[] bottles, int left, int right, int year) {
		if (left > right) return 0;
		
        return Integer.max(year*bottles[left] + SumWine(bottles, left+1, right, year+1),
        		year*bottles[right] + SumWine(bottles, left, right-1, year+1));
	}

	public static void main(String[] args) {
		// int[] arr = {5,7,4,8,9};
		int[] arr = { 8, 9, 4, 5, 7 };
		// int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		// int[] arr = {3, 4, -1, 0, 6, 2, 3};
		//System.out.println(LongIncSub(arr));
		// System.out.println(lis(arr, arr.length));
		
		int[] bottles = { 2, 3, 5, 1, 4 };
		System.out.println(SumWine(bottles, 0, 4, 1));
	}
}
