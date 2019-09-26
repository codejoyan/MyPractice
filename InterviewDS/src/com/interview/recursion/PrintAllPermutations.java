package com.interview.recursion;

import java.util.ArrayList;

public class PrintAllPermutations {

	static ArrayList<ArrayList<String>> perm (ArrayList<String> input) {
		ArrayList<ArrayList<String>> retListPerm = new ArrayList<ArrayList<String>>();
		String first = input.get(0);
		Integer inputLen = input.size();
		ArrayList<String> rem = new ArrayList<String>();
		for (int i=1; i<inputLen; i++) {
			rem.add(i-1, input.get(i)); 	
		}
		
		//Base Case goes here
		if (inputLen == 2) {
			String second = input.get(1);
			ArrayList<String> p1 = new ArrayList<String>();
			p1.add(first);
			p1.add(second);
			ArrayList<String> p2 = new ArrayList<String>();
			p2.add(second);
			p2.add(first);
			retListPerm.add(p1);
			retListPerm.add(p2);
			return retListPerm;
		}
		
		ArrayList<ArrayList<String>> listPerm = perm (rem);
		for (ArrayList<String> elemPerm: listPerm) {
		    for (int i=0; i<inputLen; i++) {
		    	ArrayList<String> curr = new ArrayList<String>();
		    	
		    	for (int j=0; j<inputLen-1; j++) {
		    		if (j==i) {
		    			curr.add(i, first);		
		    		}
		    		if (j>=i) {
		    		    curr.add(j+1, elemPerm.get(j));	
		    		} else {
		    			curr.add(j, elemPerm.get(j));
		    		}
		    	}
		    	
		    	if (i==(inputLen-1)) {
		    		curr.add(i, first);
		    	}
		    	//System.out.println(curr);
		    	retListPerm.add(curr);
		    }
		}
		return retListPerm;	
	}
	
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		input.add(0, "a");
		input.add(1, "b");
		input.add(2, "c");
		input.add(3, "d");
		input.add(4, "e");
		ArrayList<ArrayList<String>> retListPerm = perm(input);
		
		for (ArrayList<String> elemPerm: retListPerm) {
			System.out.println(elemPerm);
		}

	}

}
