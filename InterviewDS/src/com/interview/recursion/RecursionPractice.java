package com.interview.recursion;

public class RecursionPractice {
	
	//Solution for Joshua's problem
	static int jos(int n, int k) {
		
		if (n==1) return n;
		return (jos(n-1, k)+k-1)%n+1;
	}
	
	//Solution for printing all substrings given a string (in any order)
	static void psubstr(int i, int n, String s, String[] str) {
		
		if (i==n) {
			System.out.println(s);
			return;
		}
		
		psubstr(i+1, n, s, str);
		s = s + str[i];
		psubstr(i+1, n, s, str);
		
	}

	public static void main(String[] args) {
        //System.out.println(jos(7,3));
		String s = "abcd";
		String[] str = new String[4];
		for (int i=0; i<s.length(); i++) {
			str[i] = String.valueOf(s.charAt(i));
		}
        psubstr(0, s.length(), "", str);
	}

}
