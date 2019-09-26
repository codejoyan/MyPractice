package com.interview.btree;

public class FindFloorBst {
	private int ceil = Integer.MIN_VALUE;
	int traverse(Node root, int key) {
		if (root == null) return Integer.MAX_VALUE;
		
		if (root.data <= key) {
			setCeil(root.data, key);
			traverse(root.right, key);
		} else {
			traverse(root.left, key);
		}
		
		if (getCeil() == Integer.MIN_VALUE) {
		    return Integer.MAX_VALUE;    
		} else {
		    return getCeil();
		}
	}
	
	 void setCeil(int x, int y) {
		if (x <= y) {
		    ceil = Integer.max(ceil, x);
		}
	}
	
	 int getCeil() {
		return ceil;
	}
	
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
	
	public static void main(String[] args) {
		//String input = "20 8 22 4 12 10 14";
		String input = "82 49 94 6 13 14 51 69";
		String[] a = input.split(" ");
		int[] b = new int[a.length];
		Node r = new Node(Integer.parseInt(a[0]));
		for (int i = 1; i < a.length; i++) {
			b[i] = Integer.parseInt(a[i]);
			insert(r, b[i]);
		}
		FindFloorBst f = new FindFloorBst();
		System.out.println(f.traverse(r, 51));

	}

}
