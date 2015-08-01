package com.leetcode.q054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null)
			return res;
		int m = matrix.length;
		if (m == 0)
			return res;
		int n = matrix[0].length;
		if (n == 0)
			return res;
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				res.add(matrix[0][i]);
			}
			return res;
		}
		if (n == 1) {
			for (int i = 0; i < m; i++) {
				res.add(matrix[i][0]);
			}
			return res;
		}
		merge(matrix, res, 0, m, 0, n);
		return res;
	}

	private static void merge(int[][] matrix, List<Integer> res, int i, int m,
			int j, int n) {
		if (i >= m || j >= n)
			return;
		if (i == m - 1) {
			for(int k = j; k <= n - 1; k ++){
				res.add(matrix[i][k]);
			}
			return;
		}
		if (j == n - 1) {
			for(int k = i; k <= m - 1; k ++){
				res.add(matrix[k][j]);
			}
			return;
		}
		for (int ii = j; ii <= n - 1; ii++) {
			res.add(matrix[i][ii]);
		}
		for (int jj = i + 1; jj <= m - 1; jj++) {
			res.add(matrix[jj][n - 1]);
		}
		for (int mm = n - 2; mm >= j; mm--) {
			res.add(matrix[m - 1][mm]);
		}
		for (int nn = m - 2; nn >= i + 1; nn--) {
			res.add(matrix[nn][j]);
		}
		merge(matrix, res, i + 1, m - 1, j + 1, n - 1);
	}

	public static void main(String[] args) {
		int[][] n = { { 1,2,3,4}, {5,6,7,8},{9,10,11,12}};
		spiralOrder(n);
	}
}
