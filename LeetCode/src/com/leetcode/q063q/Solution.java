package com.leetcode.q063q;

public class Solution {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
        if(m <= 0)
        	return 0;
        int n = obstacleGrid[0].length;
        if(n <= 0)
        	return 0;
        if(m == 1 && n == 1 && obstacleGrid[0][0] == 0)
        	return 1;
        if(m == 1 && n == 1 && obstacleGrid[0][0] == 1)
        	return 0;
        if(obstacleGrid[0][0] == 1)
            return 0;
        boolean flag = false;
        for(int i = 1; i < m; i ++){
        	if(obstacleGrid[i][0] == 0 && !flag){
        		obstacleGrid[i][0] = 1;
        	}else{
        		flag = true;
        		obstacleGrid[i][0] = -1;
        	}
        }
        flag = false;
        for(int i = 1; i < n; i ++){
        	if(obstacleGrid[0][i] == 0 && !flag){
        		obstacleGrid[0][i] = 1;
        	}else{
        		flag = true;
        		obstacleGrid[0][i] = -1;
        	}
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		int value = 0;
        		if(obstacleGrid[i - 1][j] != -1 && obstacleGrid[i][j] == 0)
        			value += obstacleGrid[i - 1][j];
        		if(obstacleGrid[i][j - 1] != -1 && obstacleGrid[i][j] == 0)
        			value += obstacleGrid[i][j - 1];
        		obstacleGrid[i][j] = value;
        	}
        }
        if(obstacleGrid[m - 1][n - 1] == -1)
            return 0;
        return obstacleGrid[m - 1][n - 1];
    }
	public static void main(String[] args) {
		int [][] a = {{1,0}};
		uniquePathsWithObstacles(a);
	}
}
