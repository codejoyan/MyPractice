package com.interview.recursion;

import java.util.ArrayList;

public class FindAllSubsets {

	static ArrayList<ArrayList<String>> findSubsets(String[]arr, int index, ArrayList<ArrayList<String>> res) {
		if ( index == arr.length) return res;
		
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> s: res) {
			temp.add(new ArrayList<String>(s));
			s.add(arr[index]);
			temp.add(new ArrayList<String>(s));
		}
		//System.out.println(temp);
		return findSubsets(arr,index+1,temp);
	}
	
	public static void main(String[] args) {
		String[] arr = {"a", "b", "c", "d"};
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		temp.add(s);
		ArrayList<ArrayList<String>> result = findSubsets(arr, 0, temp);
		for (ArrayList<String> s1: result) {
			System.out.println(s1);
		}
		

	}

}