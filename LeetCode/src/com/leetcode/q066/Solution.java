package com.leetcode.q066;

public class Solution {
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
        	return digits;
        int temp = 1;
        for(int i = digits.length - 1; i >= 0; i --){
        	int value = digits[i] + temp;
        	digits[i] = value % 10;
        	temp = value / 10;
        }
        if(temp == 1){
        	int[] result = new int[digits.length + 1];
        	result[0] = 1;
        	for(int i = 1; i < result.length; i ++)
        		result[i] = 0;
        	return result;
        }
        return digits;
    }
}
