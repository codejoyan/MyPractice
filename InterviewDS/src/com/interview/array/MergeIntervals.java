package com.interview.array;

import java.util.*;

//https://leetcode.com/problems/merge-intervals/solution/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int index = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                else if (o1[0] == o2[0])
                    return 0;
                else
                    return -1;
            }
        });
        if (intervals.length<=0) return intervals;

        int[][] result = new int[intervals.length][intervals[0].length];
        result[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (result[index][1] >= intervals[i][0]) {
                //result[index][1] = intervals[i][1];
                result[index][1] = Integer.max(result[index][1], intervals[i][1]);
            } else {
                index++;
                result[index] = intervals[i];
            }
        }

        int[][] finalResult = new int[index+1][intervals[0].length];
        for (int i = 0; i < index+1; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public static void printArray(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.println("--");
            for (int j=0; j<arr[0].length;j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{1,3},{2,5},{6,7},{8,16},{15,18}};
        //int[][] intervals =  {{1,4},{0,4}};
        int[][] intervals =  {{1,4},{1,5}};
        printArray(new MergeIntervals().merge(intervals));
    }
}
