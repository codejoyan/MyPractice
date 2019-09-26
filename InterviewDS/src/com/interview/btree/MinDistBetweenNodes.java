package com.interview.btree;

import java.util.HashMap;
import java.util.Map;

public class MinDistBetweenNodes {
	
	public static Map<Integer, Integer> h1;
	
	public static Integer getMinDist(MyIntNode n, MyIntNode s1, MyIntNode s2) {
		h1 = new HashMap<Integer, Integer>();
		Integer a = Lca(n, s1, s2);
		return h1.get(s1.data)+h1.get(s2.data);
	}
	
	public static Integer Lca(MyIntNode n, MyIntNode s1, MyIntNode s2)  {
		if (n == null) {
			return null;
		}
		
		if ((n.data == s1.data) || (n.data == s2.data)) {
			h1.put(n.data, 1);
			return n.data;
		}
		
		Integer l = Lca(n.left, s1, s2);
		Integer r = Lca(n.right, s1, s2);
		
		if ((l != null) && (r != null)) {
			h1.put(n.data, 0);
			return n.data;
		} else if (l != null) {
			int lVal = h1.get(l);
			h1.put(l, lVal+1);
			return l;
		} else if (r != null) {
			int rVal = h1.get(r);
			h1.put(r, rVal+1);
			return r;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
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
		
		//System.out.println(getMinDist(n1, n2, n8));
		//System.out.println(getMinDist(n1, n3, n6));
		System.out.println(getMinDist(n1, n7, n9));

	}

}
