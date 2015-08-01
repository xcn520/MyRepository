package com.leetcode.q076q;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static String minWindow(String s, String t) {
        if(t.length() > s.length() || t.length() == 0 || s.length() == 0)
        	return "";
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i ++){
        	if(dict.containsKey(t.charAt(i))){
        		dict.put(t.charAt(i), dict.get(t.charAt(i)) + 1);
        	}else{
        		dict.put(t.charAt(i), 1);
        	}
        }
        int count = 0, start = 0, end = 0, min = s.length() + 1;
        String res = "";
        while(end < s.length()){
        	char c = s.charAt(end);
        	if(dict.containsKey(c)){
        		if(found.containsKey(c)){
        			if(found.get(c) < dict.get(c))
        				count ++;
        			found.put(c, found.get(c) + 1);
        		}else{
        			found.put(c, 1);
        			count ++;
        		}
        	}
        	if(count == t.length()){
        		char cc = s.charAt(start);
        		while(!dict.containsKey(cc) || found.get(cc) > dict.get(cc)){
        			if(dict.containsKey(cc)){
        				found.put(cc, found.get(cc) - 1);
        			}
        			start ++;
    				cc = s.charAt(start);
        		}
        		if(min > end - start + 1){
        			min = end - start + 1;
        			res = s.substring(start, end + 1);
        		}
        	}
        	end ++;
        }
        return res;
    }
	public static void main(String[] args) {
		minWindow("b","b");
	}
}
