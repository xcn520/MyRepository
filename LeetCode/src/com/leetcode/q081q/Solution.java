package com.leetcode.q081q;

public class Solution {
	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
        while(left <= right){
        	int middle = (left + right)/2;
        	if(target == nums[middle])
        		return true;
        	if(nums[left] < nums[middle]){
        		if(target >= nums[left] && target < nums[middle])
        			right = middle - 1;
        		else left = middle + 1;
        	}else if(nums[left] > nums[middle]){
        		if(target >= nums[left] || target < nums[middle])
        			right = middle - 1;
        		else left = middle + 1;
        	}else{
        		left ++;
        	}
        }
        return false;
	}
}
