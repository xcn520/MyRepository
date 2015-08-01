package com.leetcode.q073;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
	public void setZeroes(int[][] matrix) {
        if(matrix.length == 0)
        	return ;
        if(matrix[0].length == 0)
        	return ;
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rSet = new HashSet<Integer>();
        Set<Integer> cSet = new HashSet<Integer>();
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j ++){
        		if(matrix[i][j] == 0){
        			rSet.add(i);
        			cSet.add(j);
        		}
        	}
        }
        Iterator rowIter = rSet.iterator();
        Iterator colIter = cSet.iterator();
        while(rowIter.hasNext()){
        	int i = (int) rowIter.next();
        	for(int j = 0; j < col; j ++){
        		matrix[i][j] = 0;
        	}
        }
        while(colIter.hasNext()){
        	int j = (int) colIter.next();
        	for(int i = 0; i < row; i ++){
        		matrix[i][j] = 0;
        	}
        }
    }
}
