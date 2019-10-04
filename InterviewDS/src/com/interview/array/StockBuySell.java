package com.interview.array;

public class StockBuySell {

	static void stockBuySell(int price[], int n) {
		int buy = 0;
		int sell = Integer.MAX_VALUE;
		int count = 0;

		for (int i = 1; i < n; i++) {
			if (price[i] <= price[i - 1]) {
				if (sell != Integer.MAX_VALUE) {
					System.out.print("(" + buy + " " + sell + ")" + " ");
					count = count + 1;
				}
				buy = i;
				sell = Integer.MAX_VALUE;
			} else if (price[i] > price[i - 1]) {
				sell = i;
			}
		}
		if (sell != Integer.MAX_VALUE) {
			System.out.print("(" + buy + " " + sell + ")");
			count = count + 1;
		}

		if (count == 0) {
			System.out.print("No Profit");
		}
	}

	public static void main(String[] args) {
		int[] price = {100, 180, 260, 310, 40, 535, 695};
		//int[] price = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        stockBuySell(price, price.length);

	}

}
