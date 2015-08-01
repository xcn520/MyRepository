package com.leetcode.q079;

public class Solution {
	public static boolean exist(char[][] board, String word) {
        if(board.length == 0 || word.length() == 0)
        	return false;
        int row = board.length, col = board[0].length;
        int start = 0;
        for(int i = 0; i < row; i ++){
			for(int j = 0; j < col; j ++){
				if(helper(board, word, i, row, j, col, start))
					return true;
			}
		}
		return false;
    }

	private static boolean helper(char[][] board, String word, int r, int row, int c,
			int col, int start) {
		if(board[r][c] == word.charAt(start)){
			char cc = board[r][c];
			board[r][c] = ' ';
			if(start + 1 == word.length())
				return true;
			if(r > 0){
				if(helper(board, word, r - 1, row, c, col, start + 1))
					return true;
			}
			if(r < row - 1){
				if(helper(board, word, r + 1, row, c, col, start + 1))
					return true;
			}
			if(c > 0){
				if(helper(board, word, r, row, c - 1, col, start + 1))
					return true;
			}
			if(c < col - 1){
				if(helper(board, word, r, row, c + 1, col, start + 1))
					return true;
			}
			board[r][c] = cc;
		}
		return false;
	}
	public static void main(String[] args) {
		char[][] a = {{'A'}};
		String word = "a";
		boolean res = exist(a, word);
		System.out.println(res);
	}
}
