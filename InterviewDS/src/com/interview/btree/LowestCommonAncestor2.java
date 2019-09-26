package com.interview.btree;



public class LowestCommonAncestor2 {
	

	static int lca(Node root, int n1, int n2) {
	    int x=0;
		if (root == null) return -1; 
	    if (root.data == n1) return root.data;
	    if (root.data == n2) return root.data;
	    
	    int l = lca(root.left, n1, n2);
	    int r = lca(root.right, n1, n2);
	    
	    if (l != -1 && r == -1) x = l;
	    if (l == -1 && r != -1) x = r;
	    if (l != -1 && r != -1) x = root.data;
	    if (l == -1 && r == -1) x = -1;
	    
	    return x;
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

	static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		// String input = "2 81 87 42 66 90 45";
		String input = "20 8 22 4 12 10 14";
		String[] a = input.split(" ");
		int[] b = new int[a.length];
		Node r = new Node(Integer.parseInt(a[0]));
		for (int i = 1; i < a.length; i++) {
			b[i] = Integer.parseInt(a[i]);
			insert(r, b[i]);
		}
		// inOrder(r);
        System.out.println(lca(r, 4, 10));
	}

}
