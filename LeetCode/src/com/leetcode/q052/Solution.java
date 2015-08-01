package com.leetcode.q052;

public class Solution {
    public static int totalNQueens(int n) {
        String result = "";
        if(n <= 0)
            return 0;
        int[] value = new int[n];
        DFS_helper(n, result, 0, value);
        return Integer.valueOf(result);
    }
    private static void DFS_helper(int n, String res, int row, int[] value){
        if(n == row){
        	int v = Integer.valueOf(res) + 1;
            res = String.valueOf(v);
        }else{
            for(int i = 0; i < n; i ++){
                value[row] = i;
                if(isValid(value, row)){
                    DFS_helper(n, res, row + 1, value);
                }
            }
        }
    }
    private static boolean isValid(int[] value, int row){
        for(int i = 0; i < row; i++){
            if(value[i] == value[row] || Math.abs(value[i] - value[row]) == row - i)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
    	totalNQueens(1);
	}
}
