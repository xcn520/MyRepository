package com.leetcode.q051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if(n <= 0)
            return result;
        int[] value = new int[n];
        DFS_helper(n, result, 0, value);
        return result;
    }
    private static void DFS_helper(int n, List<String[]> res, int row, int[] value){
        if(n == row){
            String[] strs = new String[n];
            for(int i = 0; i < n; i ++){
                String str = "";
                for(int j = 0; j < n; j ++){
                    if(value[i] == j){
                        str += "Q";
                    }else{
                        str += ".";
                    }
                }
                strs[i] = str;
            }
            res.add(strs);
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
    	solveNQueens(2);
	}
}
