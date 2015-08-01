package com.leetcode.q037;

public class Solution {
	public void solveSudoku(char[][] board) {
		soleSudokuNext(board);
    }

	private boolean soleSudokuNext(char[][] board) {
		for(int i=0;i<9;i++)  
            for(int j=0;j<9;j++)  
                if(board[i][j] == '.'){  
                    for(int k=1;k<=9;k++){  
                        board[i][j] = (char)('0'+k);  
                        if(isValid(board,i,j) && soleSudokuNext(board))   
                            return true;
                        board[i][j] = '.';
                    }
                    return false;   
                }  
        return true;  
	}

	private boolean isValid(char[][] board, int row, int col) {
		for(int j=0;j<9;j++)  
            if(j != col && board[row][j] == board[row][col])  
                return false;  
      
        for(int i=0;i<9;i++)  
            if(i != row && board[i][col] == board[row][col])  
                return false;  
          
        int gridRow = row/3*3, gridCol = col/3*3;  
        for(int i=0;i<3;i++)  
            for(int j=0;j<3;j++)      
                if((gridRow + i != row || gridCol + j != col) && board[gridRow + i][gridCol + j] == board[row][col])  
                    return false;  
        return true;
	}
}
