package com.leetcode.q044q;

import java.util.regex.Pattern;

public class Solution {
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;
		int toP = -1, toS = -1, i = 0, j = 0;
		while (i < s.length()) {
			if (j < p.length()
					&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
				continue;
			} else if (j < p.length() && p.charAt(j) == '*') {
				toP = j;
				toS = i;
				j++;
				continue;
			}
			if (toS != -1) {
				i = toS + 1;
				toS++;
				j = toP + 1;
				continue;
			}
			return false;
		}
		while (j < p.length()) {
			if (p.charAt(j) == '*') {
				j++;
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] a) {
		boolean r = isMatch("aa", "*");
		System.out.println(r);
	}
}
