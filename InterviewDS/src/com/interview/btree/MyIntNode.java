package com.interview.btree;

public class MyIntNode {
	MyIntNode left;
	MyIntNode right;
	Integer data;

	MyIntNode(Integer data) {
		this.data = data;
		this.left = this.right = null;
	}
}
