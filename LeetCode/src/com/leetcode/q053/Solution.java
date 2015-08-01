package com.leetcode.q053;

public class Solution {
	public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
        	sum = sum < 0 ? nums[i] : nums[i] + sum;
        	if(sum > result)
        		result = sum;
        }
        return result;
    }
	public static void main(String[] args) {
		int[] num = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(num));
	}
}
