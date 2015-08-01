package com.leetcode.q013;

public class Solution {
	public static int romanToInt(String s) {
        int result = 0;
        String[] romans = {"CM","M","CD","D","XC","C","XL","L","IX","X","IV","V","I"};
        int values[] = {900,1000,400,500,90,100,40,50,9,10,4,5,1};
        if(s == null || s.trim().length() == 0){
        	return 0;
        }
        for(int i = 0; i < romans.length; i ++){
        	while(s.contains(romans[i]))
        	{
        		result += values[i];
        		s = s.replaceFirst(romans[i], "");
        	}
        }
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(romanToInt("MMCMLXXX"));
	}
}
