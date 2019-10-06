package com.interview.btree;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
	
	static Map<Integer, Integer> map;
	
	static void insert(Node root, int key) {
		if (key < root.data) {
			if (root.left != null) {
				insert(root.left, key);
			} else {
				root.left = new Node(key);
			}
		} else if (key > root.data) {
			if (root.right != null) {
				insert(root.right, key);
			} else {
				root.right = new Node(key);
			}
		}

	}
	
	static void inOrderMap(Node root) {
		if (root==null) return;
		
		if (!map.containsKey(root.data)) {
			map.put(root.data, 1);
		}
		inOrderMap(root.left);
		inOrderMap(root.right);
	}
	
	static boolean findPair(Node root, int sum) {
		map = new HashMap<Integer, Integer>();
		if (root == null) return false;
		
		inOrderMap(root);
/*        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }*/
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	if (map.containsKey(sum-entry.getKey()) && entry.getKey() != (sum-entry.getKey()) ) {
        		System.out.println(entry.getKey()+"-"+entry.getValue());
        		return true;
        	}
        }
        return false;	
	}

	public static void main(String[] args) {
        int[] arr = {8, 5, 1, 3, 9};
		//int[] arr = {0, 1, 2, 7, 8, 3};
		//int[] arr = {94, 13, 39, 55, 38, 66, 99, 63, 37};
		//int[] arr = {9, 56, 14, 24, 66};
        int sum = 4;
        //int sum = 6;
		//int sum = 50;
		//int sum = 28;
        Node root = new Node(arr[0]);
        for (int i=1; i<arr.length; i++) {
        	insert(root, arr[i]);
        }
        
        System.out.println(findPair(root, sum));
	}

}
