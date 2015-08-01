package com.leetcode.q085qq;

import java.util.Stack;

public class Solution {
	public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
        	return 0;
        int col = matrix[0].length;
        if(col == 0)
        	return 0;
        int [][] m = new int[row][col + 1];
        for(int i = 0; i < row; i ++){
        	for(int j = 0; j < col; j ++){
        		if(matrix[i][j] == '1'){
        			if(i > 0){
        				m[i][j] = m[i - 1][j] + 1;
        			}else{
        				m[i][j] = 1;
        			}
        		}
        	}
        }
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < row; i ++){
        	int k = 0;
        	stack.clear();
        	while(k < m[i].length){//stack中一定要存放坐标
        		if(stack.isEmpty() || m[i][stack.peek()] <= m[i][k]){
        			stack.add(k++);
        		}else{
        			int hight = m[i][stack.pop()];
        			int width = stack.isEmpty() ? k : k - stack.peek() - 1;
        			res = res < hight * width ? hight * width : res;
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
//		char[][] c = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//		maximalRectangle(c);
		char c = 1 + '0';
		System.out.println(c);
	}
}
