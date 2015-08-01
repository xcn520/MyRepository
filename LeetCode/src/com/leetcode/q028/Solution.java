package com.leetcode.q028;

public class Solution {
	public static int strStr(String haystack, String needle) {
        if(needle.length() == haystack.length() && needle.length() == 0)
            return 0;
        if(needle.length() == 0)
            return 0;
        if(needle.length() > haystack.length())
            return -1;
        int index = 0;
        boolean flag = false;
        while(index + needle.length() <= haystack.length()){
        	int i = index;
        	int j;
            for(j = 0; j < needle.length() && i < haystack.length();){
                if(haystack.charAt(i) == needle.charAt(j)){
                	i ++;
                	j ++;
                	continue;
                }else{
                	break;
                }
            }
            if(j == needle.length()){
            	flag = true;
            	break;
            }
            index ++;
        }
        if(flag)
        	return index;
        return -1;
    }
	
	public static void main(String[]a){
		strStr("a", "a");
	}
}
