package com.leetcode.q078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0){
        	res.add(new ArrayList<Integer>());
        	return res;
        }
        Arrays.sort(nums);
        helper(res, list, nums, 0, nums.length);
        return res;
    }

	private static void helper(List<List<Integer>> res, List<Integer> list,
			int[] nums, int i, int length) {
		res.add(new ArrayList<Integer>(list));
		for(;i < length; i ++){
			list.add(nums[i]);
			helper(res, list, nums, i + 1, length);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,3};
		subsets(a);
	}
}
