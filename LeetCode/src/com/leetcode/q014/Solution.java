package com.leetcode.q014;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		String pre = strs[0];
        for(int i = 0; i < strs.length; i ++){
        	if(pre.length() > strs[i].length()){
        		pre = strs[i];
        	}
        }
        for(int i = 0; i < strs.length; i ++){
        	for(int j =  pre.length(); j > -1; j --){
        		pre = pre.substring(0, j);
        		if(strs[i].startsWith(pre))
        			break;
        		if(pre.length() == 0)
        			break;
        	}
        	if(pre.length() == 0)
        		break;
        }
        return pre;
    }
}
