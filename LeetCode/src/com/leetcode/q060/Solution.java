package com.leetcode.q060;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0)
        	return "";
        List<String> res = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        int value = 1;
        for(int i = 1; i <= n; i ++){
        	list.add(String.valueOf(i));
        	value *= i;
        }
        if(k > value)
        	return "";
        helper(res, n, k, list, value);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < res.size(); i ++)
        	str.append(res.get(i));
        return str.toString();
    }

	private static void helper(List<String> res, int n, int k, List<String> list, int value) {
		if(n <= 0)
			return;
		value /= n;
		int index = k / value;
		if(k % value == 0){
			index --;
			res.add(list.get(index));
			list.remove(index);
			for(int i = list.size() - 1; i >= 0; i --)
				res.add(list.get(i));
			return;
		}
		res.add(list.get(index));
		list.remove(index);
		k = k % value; 
		n = n - 1;
		helper(res, n, k, list, value);
	}
	public static void main(String[] args) {
		getPermutation(4, 16);
	}
}
