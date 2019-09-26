package com.interview.btree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {
	
	public static boolean isLeaf(MyIntNode n) {
		boolean l = n.left==null?true:false;
		boolean r = n.right==null?true:false;
		return l&&r;
	}
	
    public static boolean rootToLeafSum(Integer s, MyIntNode n, List<Integer> list) {
	     if ( n == null) {
	    	 return false;
	     }
	     
	     s = s - n.data;
	     
	     if (!isLeaf(n)) {
		     boolean l = rootToLeafSum(s, n.left, list);
		     boolean r = rootToLeafSum(s, n.right, list);
		     
		     if (l||r) {
		    	 list.add(n.data);
		     }
		     return true;
	     }else {
	    	 if ( s == 0 ) {
	    		 list.add(n.data);
	    		 return true;
	    	 } else {
	    		 return false;
	    	 }
	     }
	}

	
	public static void main(String[] args) {
		MyIntNode n1 = new MyIntNode(10);
		MyIntNode n2 = new MyIntNode(16);
		MyIntNode n3 = new MyIntNode(5);
		MyIntNode n4 = new MyIntNode(-3);
		MyIntNode n5 = new MyIntNode(6);
		MyIntNode n6 = new MyIntNode(11);
		
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.left = n5;
		n3.right = n6;
		
		//System.out.println(isLeaf(n6));
		//System.out.println(isLeaf(n2));
		List<Integer> l = new ArrayList<Integer>();
		
		rootToLeafSum(26, n1, l);
		
		System.out.println(l);
	}
}
