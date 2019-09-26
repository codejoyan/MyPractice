package com.interview.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArrays {
	
	static int countZeroSum(int[] arr) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    Integer prefixSum = 0;
	    int value=0;
	    int count=0;
	    int n=0;
	    map.put(0, 1);
	    for (int i=0; i<arr.length; i++) {
	        prefixSum += arr[i]	;
	        if (map.containsKey(prefixSum)) {
	        	value=map.get(prefixSum)+1;
	        	map.put(prefixSum, value);
	        } else {
	        	map.put(prefixSum, 1);
	        }
	    }
	    
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	    	n = entry.getValue();
	    	count += n * (n-1)/2;	
	    }
	    return count;
	}

	public static void main(String[] args) {
		
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
				System.out.println(countZeroSum(a));
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
