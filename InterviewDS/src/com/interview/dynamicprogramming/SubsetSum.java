package com.interview.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	static void findSubsetSum2(int[] arr, int sum) {
		int runningSum = 0;
		if (runningSum == sum - runningSum) {
			System.out.println("YES");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			runningSum = arr[i];
			for (int j = 0; j < arr.length && i != j; j++) {
				runningSum = runningSum + arr[j];
				if (runningSum == sum - runningSum) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");

	}

	static void findSubsetSum(int[] arr, int sum) {
		// int sum = 0;
		List<Integer> input = new ArrayList<Integer>();
		input.add(0);
		/*
		 * for (int i = 0; i < arr.length; i++) { sum = sum + arr[i]; }
		 */
		boolean isEqual = isEqual(0, arr, input, sum);
		if (isEqual) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		boolean isEqual2 = isEqual2(0, 0, arr, sum);
		if (isEqual2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	

	static boolean isEqual(int idx, int[] arr, List<Integer> input, int sum) {
		if (idx == arr.length - 1) {
			return false;
		}
		List<Integer> output = new ArrayList<Integer>();
		for (Integer i : input) {
			if ((i == (sum - i)) || ((arr[idx] + i) == sum - (arr[idx] + i))) {
				return true;
			} else {
				output.add(i);
				output.add(arr[idx] + i);
			}
		}
		boolean equal = isEqual(idx + 1, arr, output, sum);
		return equal;

	}
	
	static boolean isEqual2(int idx, int input, int[] arr, int sum) {
		if (idx == arr.length||sum<0) {
			return false;
		}
		if(sum==0) return true;
		if ((input == (sum - input)) || ((arr[idx] + input) == sum - (arr[idx] + input))) {
			return true;
		}
		 return isEqual2(idx+1, input, arr, sum) || isEqual2(idx+1, arr[idx]+input, arr, sum);

	}

	public static void main(String[] args) {
		/*
		 * int[] arr = { 1, 5, 11, 5 }; int[] arr = {1, 3, 5};
		 * findSubsetSum(arr);
		 */
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.valueOf(reader.readLine());

			for (int i = 1; i <= t; i++) {
				int size = Integer.valueOf(reader.readLine());
				int[] input = new int[size];
				String arrayLine = reader.readLine();
				String[] a = arrayLine.split(" ");
				int sum = 0;
				for (int j = 0; j < size; j++) {
					input[j] = Integer.parseInt(a[j]);
					sum = sum + input[j];
				}
				findSubsetSum(input, sum);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}