package com.leetcode.q058;

public class Solution {
	public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        s = s.trim();
        if(!s.contains(" "))
        	return s.length();
        int index = s.lastIndexOf(" ");
        String ss = s.substring(index + 1, s.length());
        return ss.length();
    }
	public static void main(String[]a){
		lengthOfLastWord("a b ");
	}
}
