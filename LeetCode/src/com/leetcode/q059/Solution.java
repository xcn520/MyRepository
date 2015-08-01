package com.leetcode.q059;

public class Solution {
	public static int[][] generateMatrix(int n) {
		
        if(n <= 0)
        	return new int[][] {};
        int [][] res = new int[n][n];
        helper(res, n, 1, 0, n);
        return res;
    }

	private static void helper(int[][] res, int n, int startNum, int i, int k) {
		if(n <= 0)
			return;
		for(int ii = i; ii < k; ii ++){
			res[i][ii] = startNum ++;
		}
		for(int ii = i + 1; ii < k; ii ++){
			res[ii][k - 1] = startNum ++;
		}
		for(int ii = k - 2; ii >= i; ii --){
			res[k-1][ii] = startNum ++;
		}
		for(int ii = k - 2; ii > i; ii --){
			res[ii][i] = startNum ++;
		}
		helper(res, n - 2, startNum, i + 1, k - 1);
	}
	public static void main(String[] args) {
		generateMatrix(0);
	}
}
