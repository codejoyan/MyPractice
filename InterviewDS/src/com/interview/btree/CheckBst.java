package com.interview.btree;

import java.util.HashMap;
import java.util.Scanner;

public class CheckBst {
	
	int isBST(Node root) {
		return checkBST(root, null, -1, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	int checkBST(Node root, Node parent, int leftChild, int leftMin, int rightMax) {
		
		if (root==null) return 1;
		//System.out.println(root.data);
		if (leftChild==1) {
			leftMin = Integer.min(leftMin, parent.data);
		    if (root.left != null) {
		    	if ((root.left.data > root.data) || (root.left.data > leftMin)) return 0;
		    }
		    if (root.right != null) {
		    	if ((root.right.data < root.data) || (root.right.data > leftMin)) return 0;
		    }
            if (root.data > parent.data) return 0;
		} else if (leftChild==0) {
			rightMax = Integer.max(rightMax, parent.data);
		    if (root.left != null) {
		    	if ((root.left.data > root.data) || (root.left.data < rightMax)) return 0;
		    }
		    if (root.right != null) {
		    	if ((root.right.data < root.data)|| (root.right.data < rightMax)) return 0;
		    }
            if (root.data < parent.data) return 0;		
		}
		
		int x = checkBST(root.left, root, 1, leftMin, rightMax);
		int y = checkBST(root.right, root, 0, leftMin, rightMax);
		//System.out.println("x:"+x+"::y:"+y);
		if (x==0 || y==0) {
			return 0;
		} else {
			return 1;
		}
		
	}

	public static void main(String[] args) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
			
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
            CheckBst g = new CheckBst();
            System.out.println(g.isBST(root));
			//ob.printInorder(root);
            t--;
			
        }		

	}

}
