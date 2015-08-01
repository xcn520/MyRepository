package com.leetcode.q038;

public class Solution {
	public static String countAndSay(int n) {
		if(n < 1)
			return "";
        if(n == 1)
        	return "1";
        int i = 1;
        String result = "1";
        while(i < n){
        	result = read(result);
        	i ++;
        }
        return result;
        
    }

	private static String read(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i ++){
			int count = 1;
			char tem = str.charAt(i);
			while(i + 1 < str.length()){
				if(str.charAt(i + 1) == tem){
					count ++;
					i ++;
				}else{
					break;
				}
			}
			result += (String.valueOf(count) + str.charAt(i));
		}
		return result;
	}
	
	public static void main(String[]a){
		System.out.println(countAndSay(20));
	}
}
