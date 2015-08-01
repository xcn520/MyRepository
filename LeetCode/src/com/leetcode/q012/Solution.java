package com.leetcode.q012;

public class Solution {
	public static String intToRoman(int num) {
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder result = new StringBuilder();
        if(num < 0 || num > 3999)
        	return null;
        for(int i = 0; i < values.length; i++){
        	while(num >= values[i]){
        		num -= values[i];
        		result.append(romans[i]);
        	}
        }
        return result.toString();
    }
	
	public static void main(String[] args){
		String result = intToRoman(2980);
		System.out.println(result);
	}
}
