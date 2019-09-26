package com.interview.btree;

public class LowestCommonAncestor {
	
	public static Integer Lca(MyIntNode n, MyIntNode s1, MyIntNode s2)  {
		if (n == null) {
			return null;
		}
		
		if ((n.data == s1.data) || (n.data == s2.data)) {
			return n.data;
		}
		
		Integer l = Lca(n.left, s1, s2);
		Integer r = Lca(n.right, s1, s2);
		
		if ((l != null) && (r != null)) {
			return n.data;
		} else if (l != null) {
			return l;
		} else {
			return r;
		}
	}
	
	public static void main (String[] args) {
		MyIntNode n1 = new MyIntNode(3);
		MyIntNode n2 = new MyIntNode(6);
		MyIntNode n3 = new MyIntNode(2);
		MyIntNode n4 = new MyIntNode(11);
		MyIntNode n5 = new MyIntNode(9);
		MyIntNode n6 = new MyIntNode(5);
		MyIntNode n7 = new MyIntNode(8);
		MyIntNode n8 = new MyIntNode(13);
		MyIntNode n9 = new MyIntNode(7);
		
		n1.left = n2;
		n1.right = n7;
		n2.left = n3;
		n2.right = n4;
		n4.left = n5;
		n4.right = n6;
		n7.right = n8;
		n8.left = n9;
		
		System.out.println(Lca(n1, n2, n8));
		System.out.println(Lca(n1, n3, n6));
		System.out.println(Lca(n1, n7, n9));
		
	}

}