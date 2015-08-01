package com.leetcode.q005;

public class Solution {
	public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
        	return s;
        String result = s.substring(0, 1);
        for(int i = 0; i < s.length(); i++){
        	String tem = palindrome(s, i, i);
        	if(tem.length() > result.length()){
        		result = tem;
        	}
        	tem = palindrome(s, i, i+1);
        	if(tem.length() > result.length()){
        		result = tem;
        	}
        }
        return result;
    }
	
	private String palindrome(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
			start --;
			end ++;
		}
		return s.substring(start + 1, end);
	}

}
