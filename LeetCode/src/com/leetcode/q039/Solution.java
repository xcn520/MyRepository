package com.leetcode.q039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<Integer>>result = new ArrayList<List<Integer>>();
	List<Integer> item = new ArrayList<Integer>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length ==0)
        	return result;
        Arrays.sort(candidates);
        combination(candidates, target, 0, 0);
        return result;
    }
	private void combination(int[] candidates, int target, int sum, int level) {
		if(sum == target){
			result.add(new ArrayList<Integer>(item));
			return;
		}
		if(sum > target)
			return;
		for(int i = level; i < candidates.length; i ++){
			if(i > 0 && candidates[i] == candidates[i - 1]){
				continue;
			}
			sum += candidates[i];
			item.add(candidates[i]);
			combination(candidates, target, sum, i);
			item.remove(item.size() - 1);
			sum -= candidates[i];
		}
	}
}
