package com.leetcode.q075;

public class Solution {
	public static void sortColors(int[] nums) {
        if(nums.length == 0)
        	return;
        int len = nums.length;
        int left = 0, right = len - 1;
        for(; left < len; left ++){
        	if(nums[left] != 0)
        		break;
        }
        for(; right > 0;right --){
        	if(nums[right] != 2)
        		break;
        }
        for(int min = left; min <= right;){
        	if(nums[min] == 2){
        		nums[min] = nums[right];
        		nums[right] = 2;
        		right --;
        	}else if(nums[min] == 0){
        		nums[min] = nums[left];
        		nums[left] = 0;
        		left ++;
        		min ++;
        	}else{
        		min ++;
        	}
        }
    }
	public static void main(String[] args) {
		
		int[] a = {2,0};
		sortColors(a);
	}
}
