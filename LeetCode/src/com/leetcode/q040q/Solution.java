package com.leetcode.q040q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	static List<List<Integer>>result = new ArrayList<List<Integer>>();
	static List<Integer> item = new ArrayList<Integer>();
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num == null || num.length == 0)
        	return result;
        Arrays.sort(num);
        combination(num, target, 0, 0);
        return result;
    }
	private static void combination(int[] candidates, int target, int sum, int level) {
		if(sum == target){
			result.add(new ArrayList<Integer>(item));
			return;
		}
		if(sum > target)
			return;
		for(int i = level; i < candidates.length; i ++){
			sum += candidates[i];
			item.add(candidates[i]);
			combination(candidates, target, sum, i+1);
			item.remove(item.size() - 1);
			sum -= candidates[i];
			while(i<(candidates.length - 1) && candidates[i] == candidates[i + 1]){
				i ++;
			}
		}
	}
	public static void main(String[]q){
		int[] l = {1,1,2};
		combinationSum2(l, 2);
	}
}
