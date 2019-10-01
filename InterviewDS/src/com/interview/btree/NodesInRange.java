package com.interview.btree;

import java.util.Scanner;

public class NodesInRange {
	
	public static int getCountOfNode(Node root,int l, int h)
	{
	    if (root==null) return 0;
	    
	    int x = getCountOfNode(root.left,l, h);
	    int y = getCountOfNode(root.right,l, h);
	    
	    if (root.data>=l && root.data<=h) {
	    	return 1+x+y;
	    } else {
	    	return x+y;
	    }
	}

	public static Node createNewNode(int value) {
		Node temp = new Node(value);

		return temp;
	}

	static public Node newNode(Node root, int data) {
		if (root == null)
			root = createNewNode(data);
		else if (data < root.data)
			root.left = newNode(root.left, data);
		else
			root.right = newNode(root.right, data);

		return root;
	}

	static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while (testcases-- > 0) {
			Node root = null;
			int sizeOfArray = sc.nextInt();
			int arr[] = new int[sizeOfArray];
			for (int i = 0; i < sizeOfArray; i++) {
				int x = sc.nextInt();
				arr[i] = x;
			}

			for (int i = 0; i < sizeOfArray; i++) {
				root = NodesInRange.newNode(root, arr[i]);
			}
			int l, h;
			l=sc.nextInt();
			h=sc.nextInt();
			System.out.println(NodesInRange.getCountOfNode(root,l,h));

		}
	}
}
