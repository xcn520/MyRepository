package com.leetcode.q004;

public class Solution {
	public static double findMedianSortedArrays(int A[], int B[]) {
        int k = A.length + B.length;
        double result = 0;
        if(k % 2 != 0){
        	result = findKth(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1);
        }else{
        	result = (findKth(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1) + findKth(A, 0, A.length-1, B, 0, B.length-1, k/2))/2;
        }
        return result;
    }

	private static double findKth(int[] a, int startA, int endA, int[] b, int startB,
			int endB, int k) {
		if(endA - startA + 1 == 0)
			return b[startB + k - 1];
		if(endB - startB + 1 == 0)
			return a[startA + k - 1];
		if(k == 1)
			return a[startA] > b[startB] ? b[startB] : a[startA];
		int midA = 0;
		int midB = 0;
		if(k / 2 > (endA - startA + 1)){
			midA = endA - startA + 1;
			midB = k - midA;
		}else if(k/2>endB-startB+1){
			midB = endB-startB+1;
			midA = k - midB;
		}else{
			midA = midB = k/2;
		}
		if(a[startA + midA - 1] < b[startB + midB - 1])
			return findKth(a, startA + midA, endA, b, startB, endB, k - midA);
		else
			return findKth(a, startA, endA, b, startB + midB, endB, k - midB);
	}
	
	public static void main(String[]a){
		int[] a1={2,3,4};
		int[] b={1};
		findMedianSortedArrays(a1,b);
	}
}
