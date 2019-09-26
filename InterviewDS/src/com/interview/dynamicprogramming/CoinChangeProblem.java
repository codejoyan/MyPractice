package com.interview.dynamicprogramming;

public class CoinChangeProblem {

	private static int r1 = 0;
	private static int r2 = 0;

	private static int MaxSumCoinVal(int cnt, int[] arr, int s, int e) {
		int r = 0;

		// System.out.println("cnt:"+cnt+"::s:"+s+"::e:"+e);
		if (s > e) {
			return Integer.max(r1, r2);
		}

		int idx = cnt % 2;
		int selVal = Integer.max(arr[s], arr[e]);

		if (idx == 0) {
			r1 = r1 + selVal;
		} else {
			r2 = r2 + selVal;
		}

		if (arr[s] > arr[e]) {
			cnt = cnt + 1;
			s = s + 1;
			e = e;
			r = MaxSumCoinVal(cnt, arr, s, e);
		} else {
			cnt = cnt + 1;
			s = s;
			e = e - 1;
			r = MaxSumCoinVal(cnt, arr, s, e);
		}

		return r;

	}

	private static int CoinSum(int[] arr, int l, int r) {

		/*
		 * if (r-l==1) { return Integer.max(arr[l], arr[r]); }
		 */
		if (l > r) {
			return 0;
		}
		return Integer.max(arr[l] + Integer.min(CoinSum(arr, l + 2, r), CoinSum(arr, l + 1, r - 1)),
				arr[r] + Integer.min(CoinSum(arr, l + 1, r - 1), CoinSum(arr, l, r - 2)));

	}

	private static int DpCoinSum(int[] coins) {

		int N = coins.length;
		int[][] dp = new int[N][N];
		//dp[1][0] = Integer.max(coins[0], coins[1]);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == i) {
					dp[i][j] = coins[i];
					// System.out.println("dp["+i+"]["+j+"]"+dp[i][j]);
				} else if (i-j ==1) {
					dp[i][j] = Integer.max(coins[i], coins[j]);
				}
			}
		}

		for (int i = 2; i < N; i++) {
			for (int j = 0; j + 2 < N; j++) {
				//System.out.println("i:" + i + ",j:" + j);
				dp[i][j] = Integer.max(coins[j] + Integer.min(dp[i][j + 2], dp[i - 1][j + 1]),
						coins[i] + Integer.min(dp[i - 1][j + 1], dp[i - 2][j]));

			}
		}

/*		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j <= i) {
					System.out.println("dp[" + i + "][" + j + "]" + dp[i][j]);
				}

			}
		}*/

		return dp[N - 1][0];

	}

	public static void main(String[] args) {
		// int[] arr = new int[] {25, 5, 2, 1};
		// int[] arr = new int[] {25, 2, 5, 6};
		int[] arr = new int[] { 2, 3, 15, 7 };
		System.out.println(MaxSumCoinVal(0, arr, 0, 3));
		System.out.println(CoinSum(arr, 0, 3));
		System.out.println(DpCoinSum(arr));
	}

}