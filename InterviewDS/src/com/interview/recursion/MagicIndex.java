package com.interview.recursion;

public class MagicIndex {
	
	private static int recGetNo(int[] arr, int low, int high) {
		if (low>high) return -1;

		int x, y = -1;
		int mid = low+(high-low)/2;
		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] > mid) {
			int r = arr[mid] - mid;
			x = recGetNo(arr, low, mid-1);
			y = recGetNo(arr, mid+r, high);
		} else {
			int r = mid - arr[mid];
			x = recGetNo(arr, low, mid-r);
			y = recGetNo(arr, mid+1, high);
		}
		
		if (x != -1) {
			return x;
		} else if (y != -1) {
			return y;
		} else {
			return -1;
		}
		
	}

	public static void main(String[] args) {
		int[] arr = { -1, -1, 0, 1, 2, 2, 7, 7, 9 };
		System.out.println(recGetNo(arr, 0, 8));
	}

}
