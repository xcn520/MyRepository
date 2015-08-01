package com.leetcode.q017;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
        	return new ArrayList<String>();
        String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
        for(int i = digits.length() - 1; i >= 0; i --){
        	int key = digits.charAt(i) - '0';
        	result = toResult(key, keyboard, result);
        }
        return result;
    }

	private static List<String> toResult(int key, String[] keyboard,
			List<String> result) {
		List<String> newResult = new ArrayList<String>();
		String keys = keyboard[key];
		if(result == null || result.size() == 0){
			for(int i = 0; i < keys.length(); i ++){
				newResult.add(String.valueOf(keys.charAt(i)));
			}
		}else{
			for(int i = 0; i < keys.length(); i ++){
				for(int j = 0; j < result.size(); j ++){
					newResult.add(String.valueOf(keys.charAt(i)) + result.get(j));
				}
			}
		}
		return newResult;
	}
	
	public static void main(String[]a){
		letterCombinations("22");
	}
}
