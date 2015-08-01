package com.leetcode.q006;

public class Solution {
	public static String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || nRows <= 1 || nRows >= s.length()) {
			return s;
		}
		String result = "";
		for (int i = 0; i < nRows; i++) {

			int post1 = (nRows - i - 1) * 2;
			int post2 = i * 2;
			int post = i;
			result += s.charAt(post);
			while (post < s.length()) {
				if (post1 != 0) {
					post += post1;
					if (post < s.length()) {
						result += s.charAt(post);
					}
				}
				if (post2 != 0) {
					post += post2;
					if (post < s.length()) {
						result += s.charAt(post);
					}
				}

			}
		}
		return result;
	}
}
