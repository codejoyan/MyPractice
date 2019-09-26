package com.interview.btree;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class DeleteNodeBst {

     static Node deleteNode(Node root, int key) {
		 Node parent=null;
    	 Node curr = root;
		while (curr != null && curr.data != key) {
			parent = curr;
			if (key < curr.data) {
				curr = curr.left;
			} else if (key > curr.data) {
				curr = curr.right;
			}
		}
		if (curr == null) {
			return root;
		}

		// Case 1: Node has no children
		if (curr.left == null && curr.right == null) {
            if (parent.left == curr) {
            	parent.left = null;
            } else if (parent.right == curr) {
            	parent.right = null;
            }
		} else if (curr.left == null || curr.right == null) {// Case 2: Node has
																// one children
			Node child = (curr.left != null) ? curr.left : curr.right;
			if (parent.left == curr) {
				parent.left = child;	
			} else {
				parent.right = child;
			}
			
		} else {// Case 3: Node has two children
			Node successor = getMinLeftTree(curr.right);
			int val = successor.data;
			deleteNode(root, successor.data);
			curr.data=val;
		}
		
		return root;

	}

    static Node getMinLeftTree(Node node) {
    	while (node.left != null) {
    		node = node.left;
    	}
    	return node;
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
		Node result = deleteNode(r, 20);
		inOrder(result);
	}

}
