package com.interview.array;

import java.util.Arrays;

public class MergeSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;

        int start = 0;
        if (len1 % 2 == 0) start = (len1 / 2) - 1;
        else start = (len1 / 2);

        int stop = len1 - 1;

        if (len1 == 0 && len2 == 0) return Double.MIN_VALUE;
        else if (len1 == 0 && len2 != 0) return median(nums2, len2);
        else if (len1 != 0 && len2 == 0) return median(nums1, len1);
        else return helper(nums1, nums2, len1, len2, start, stop);

    }

    double median(int[] num, int len) {
        if (len % 2 == 0) return ((double) (num[len / 2] + num[len / 2 - 1])) / 2;
        else return num[len / 2];
    }

    double helper(int[] nums1, int[] nums2, int len1, int len2, int start, int stop) {
        int[] x1 = new int[start + 1];
        int[] x2 = new int[len1 - start - 1];
        int[] y1 = new int[(len1 + len2 + 1) / 2 - start - 1];
        int[] y2 = new int[len2 - ((len1 + len2 + 1) / 2 - start - 1)];

        int[] r1 = new int[len1 + len2];
        int len = len1+len2;
        if (nums1[len1-1]<=nums2[0]) {
            System.arraycopy(nums1, 0, r1, 0, len1);
            System.arraycopy(nums2, 0, r1, len1, len2);
            return median(r1, len);
        } else if (nums1[0]>=nums2[len2-1]) {
            System.arraycopy(nums2, 0, r1, 0, len2);
            System.arraycopy(nums1, 0, r1, len2, len1);
            return median(r1, len);
        }

/*        if (nums1[len1 - 1] <= nums2[0] && (len1 + len2) % 2 == 0) {
            int[] r1 = new int[len1 + len2];
            System.arraycopy(nums1, 0, r1, 0, len1);
            System.arraycopy(nums2, 0, r1, len1, len2);
            return ((double)(nums1[len1 - 1]+ nums2[0]))/2;
        } else if (nums1[len1 - 1] <= nums2[0] && (len1 + len2) % 2 != 0) {
            return Integer.max(nums1[len1 - 1], nums2[0]);
        } else if (nums2[len2 - 1] >= nums1[0] && (len1 + len2) % 2 == 0) {
            return ((double)(nums2[len2 - 1]+ nums1[0]))/2;
        } else if (nums2[len2 - 1] >= nums1[len2-1] && (len1 + len2) % 2 != 0) {
            return Integer.max(nums2[len2 - 1], nums1[0]);
        }*/ else {
            System.arraycopy(nums1, 0, x1, 0, x1.length);
            System.arraycopy(nums1, x1.length, x2, 0, x2.length);
            System.arraycopy(nums2, 0, y1, 0, y1.length);
            System.arraycopy(nums2, y1.length, y2, 0, y2.length);
            printArray(x1);
            printArray(x2);
            printArray(y1);
            printArray(y2);
            Double result = 0D;

            if (start <= stop) {
                int rightVal1 = Integer.MAX_VALUE;
                if (x2.length != 0) rightVal1 = x2[0];

                int rightVal2 = Integer.MAX_VALUE;
                if (y2.length != 0) rightVal2 = y2[0];

                int leftVal1 = Integer.MIN_VALUE;
                if (x1.length != 0) leftVal1 = x1[x1.length-1];

                int leftVal2 = Integer.MIN_VALUE;
                if (y1.length != 0) leftVal2 = y1[y1.length-1];

                if (leftVal1 <= rightVal2 && leftVal2 <= rightVal1) {
                    if ((len1 + len2) % 2 == 0) {
                        result = ((double) (Integer.max(leftVal1, leftVal2) + Integer.min(rightVal1, rightVal2))) / 2;
                    } else {
                        result = (double) (Integer.max(leftVal1, leftVal2));
                    }
                } else if (leftVal1 <= rightVal2 && leftVal2 > rightVal1) {
                    result = helper(nums1, nums2, len1, len2, start + 1, stop);
                } else if (leftVal1 > rightVal2 && leftVal2 <= rightVal1) {
                    result = helper(nums1, nums2, len1, len2, start - 1, stop);
                }
            }
            return result;
        }
    }

    void printArray(int[] num) {
        for (int i : num) {
            System.out.print(i);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        //int[] num1 = {1, 3, 4, 7, 20};
        //int[] num1 = null;
        //int[] num2 = {5, 6, 9, 11, 13};
        //int[] num2 = null;

        //int[] num1 = {1, 2};
        //int[] num2 = {3, 4};

        //int[] num1 = {3};
        //int[] num2 = {-2,-1};

        int[] num1 = {1,3,4};
        int[] num2 = {2};

        //int[] num1 = {2};
        //int[] num2 = {1,3};

        //int[] num1 = {1,2};
        //int[] num2 = {1,2,3};

        System.out.println(new MergeSortedArray().findMedianSortedArrays(num1, num2));
    }
}
