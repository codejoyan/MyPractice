package com.interview.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinJumps {

	static int minJumps(int[] arr, int pos, int count) {

		if (pos == arr.length - 1)
			return count;
		if (pos > arr.length - 1 || arr[pos] == 0)
			return -1;

		int val = arr[pos];
		int[] minArr = new int[val];

		for (int i = 1; i <= val; i++) {
			minArr[i - 1] = minJumps(arr, pos + i, count + 1);
		}

		int r = getMin(minArr);
		return r;

	}

	static int getMin(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min && a[i] > 0) {
				min = a[i];
			}
		}
		return min;
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("----");
	}
	
	static int minJumpsDp(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 0;
		for (int i=1; i<arr.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		if (arr[0] == 0) return -1;
		
		for (int i=1; i<arr.length; i++) {
			for (int j=0; j<i; j++)	{
				if ((i-j) <= arr[j] && (dp[j]+1 < dp[i]) && arr[j]>0) {
				    dp[i] = dp[j]+1;	
				}
			}
			if (dp[i]==Integer.MAX_VALUE) {
				dp[i] = -1;
			}
		}
		return dp[arr.length-1];
	}

	public static void main(String[] args) {
		// int[] arr = {1, 4, 3, 2, 6, 7};
	    int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJumps(arr, 0, 0));
		// int[] arr = {-1, -1, -1, 3};
		// System.out.println(getMin(arr));
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.valueOf(reader.readLine());
			//System.out.println(n);

			for (int p = 1; p <= n; p++) {
				int elements = Integer.valueOf(reader.readLine());
				//System.out.println(elements);
				int[] a = new int[elements];
				String line = reader.readLine();
				String[] b = line.split(" ");
				int size = b.length;
				if (elements == size) {
					for (int i = 0; i < size; i++) {
						a[i] = Integer.parseInt(b[i]);
					}
				}
				//printArray(a);
				//System.out.println(minJumps(a, 0, 0));
				System.out.println(minJumpsDp(a));
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
