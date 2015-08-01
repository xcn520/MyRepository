package com.leetcode.q080;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
        	return nums.length;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int res = 1;
        int j = 0;
        map.put(nums[j], 1);
        for(int i = 1; i < nums.length; i ++){
        	if(nums[i] == nums[j]){
        		if(map.get(nums[i]) != 2){
        			map.put(nums[i], 2);
        			j ++;
        			nums[j] = nums[i];
        			res ++;
        		}
        	}else{
        		map.put(nums[i],1);
        		j ++;
    			nums[j] = nums[i];
    			res ++;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		int[] num = {1,1,1,2};
		removeDuplicates(num);
	}
}
