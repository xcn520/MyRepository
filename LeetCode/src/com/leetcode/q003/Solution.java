package com.leetcode.q003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static int subLength(String s){
		int result = 0;
		int pre = 0;
		if(s == null || s.equals(""))
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i ++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), i);
			}else{
				if(map.get(s.charAt(i)) >= pre){
					result = result > (i - pre)?result : (i - pre);
					pre = map.get(s.charAt(i)) + 1;
					map.put(s.charAt(i),i);
				}else{
					map.put(s.charAt(i),i);
				}
			}
		}
		result = result > (s.length() - pre)?result : (s.length() - pre);
		return result;
	}
	
	public static void main(String [] args){
		int result = subLength("aaaabcdeabcdef");
		System.out.println(result);
	}
}
