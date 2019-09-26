package com.interview.btree;

public class FindCeilBst {
	
	private int ceil = Integer.MAX_VALUE;
	int traverse(Node root, int key) {
		if (root == null) return -1;
		
		if (root.data >= key) {
			setCeil(root.data, key);
			traverse(root.left, key);
		} else {
			traverse(root.right, key);
		}
		
		if (getCeil() == Integer.MAX_VALUE) {
		    return -1;    
		} else {
		    return getCeil();
		}
	}
	
	 void setCeil(int x, int y) {
		if (x >= y) {
		    ceil = Integer.min(ceil, x);
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
		String input = "82 49 94 6 13 13 51 69";
		String[] a = input.split(" ");
		int[] b = new int[a.length];
		Node r = new Node(Integer.parseInt(a[0]));
		for (int i = 1; i < a.length; i++) {
			b[i] = Integer.parseInt(a[i]);
			insert(r, b[i]);
		}
		FindCeilBst f = new FindCeilBst();
		System.out.println(f.traverse(r, 27));

	}

}
