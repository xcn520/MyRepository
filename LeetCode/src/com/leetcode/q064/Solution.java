package com.leetcode.q064;

public class Solution {
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
        if(m <= 0)
        	return 0;
        int n = grid[0].length;
        if(n <= 0)
        	return 0;
        if(m == 1 && n == 1){
        	return grid[0][0];
        }
        int[][] min = new int[m][n];
        min[0][0] = grid[0][0];
        for(int i = 1; i < m; i ++){
        	min[i][0] = min[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i ++){
        	min[0][i] = min[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i ++){
        	for(int j = 1; j < n; j ++){
        		min[i][j] = min[i - 1][j] < min[i][j - 1] ? min[i - 1][j] + grid[i][j] : min[i][j - 1] + grid[i][j];
        	}
        }
        return min[m - 1][n - 1];
    }
	public static void main(String[] args) {
		int [][] a = {{1,2},{1,1}};
		minPathSum(a);
	}
}
