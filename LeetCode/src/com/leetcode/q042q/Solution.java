package com.leetcode.q042q;

public class Solution {
	static int lowIndex = -1, highIndex = 0, low =0, high=0;
	public static int trap(int[] A) {
		if(A.length < 3)
			return 0;
        int result = 0,maxIndex = 0;
        for(int i = 1; i < A.length; i ++){
        	if(A[i] > A[maxIndex])
        		maxIndex = i;
        }
        int maxLeft = 0;
        for(int i = 1; i < maxIndex; i ++){
        	if(A[i] > A[maxLeft]){
        		maxLeft = i;
        	}else{
        		result += (A[maxLeft] - A[i]);
        	}
        }
        int maxRight = A.length - 1;
        for(int i = A.length - 2; i > maxIndex; i --){
        	if(A[maxRight] < A[i]){
        		maxRight = i;
        	}else{
        		result += (A[maxRight] - A[i]);
        	}
        } 
        return result;
    }
	public static void main(String[]q){
		int[] a = {4,2,3};
		int result = trap(a);
		System.out.println(result);
	}
}
