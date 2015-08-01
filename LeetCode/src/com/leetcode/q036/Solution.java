package com.leetcode.q036;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i ++){
        	Set<Character> set = new HashSet<Character>();
        	for(int j = 0; j < 9; j ++){
        		if(board[i][j] == '.')
        			continue;
        		else{
        			if(set.contains(board[i][j]))
        				return false;
        			else
        				set.add(board[i][j]);
        		}
        	}
        }
        for(int i = 0; i < 9; i ++){
        	Set<Character> set = new HashSet<Character>();
        	for(int j = 0; j < 9; j ++){
        		if(board[j][i] == '.')
        			continue;
        		else{
        			if(set.contains(board[j][i]))
        				return false;
        			else
        				set.add(board[j][i]);
        		}
        	}
        }
        for(int start = 0; start < 9; start ++){
        	Set<Character> set = new HashSet<Character>();
        	int i = start / 3, j = start % 3;
        	for(int k = 0; k < 9; k ++){
        		int ii = i * 3 + k / 3, jj = j * 3 + k % 3;
        		if(board[ii][jj] == '.')
        			continue;
        		else{
        			if(set.contains(board[ii][jj]))
        				return false;
        			else
        				set.add(board[ii][jj]);
        		}
        	}
        }
        return true;
    }
}
