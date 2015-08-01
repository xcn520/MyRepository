package com.leetcode.q074;

public class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
        	return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row - 1;
        while(left < right){
        	int mid = (left + right) / 2;
        	if(matrix[mid][0] < target){
        		left = mid;
        		if(matrix[right][0] > target)
        			right --;
        		else if(matrix[right][0] == target)
        			return true;
        		else
        			left = right;
        	}else if(matrix[mid][0] > target){
        		right = mid - 1;
        	}else{
        		return true;
        	}
        }
        if(left > right)
        	return false;
        int res = left;
        left = 0; right = col - 1;
        while(left <= right){
        	int mid = (left + right)/2;
        	if(matrix[res][mid] == target)
        		return true;
        	else if(matrix[res][mid] < target)
        		left = mid + 1;
        	else
        		right = mid - 1;
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] a = {{1}};
		searchMatrix(a, 1);
	}
}
