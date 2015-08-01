package com.leetcode.q048;

public class Solution {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        int n = matrix.length;
        int[][] value = new int[n][n];
        for(int i = 0; i < n; i ++){
        	for(int j = 0; j < n; j ++){
        		value[j][n - 1 -i] = matrix[i][j];
        	}
        }
        matrix = value;
	}
	
	
}
