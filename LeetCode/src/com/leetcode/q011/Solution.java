package com.leetcode.q011;

public class Solution {
	public static int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
        	if(height[start] <= height[end]){
        		result = height[start] * (end - start) > result ? height[start] * (end - start) : result;
        		start ++;
        	}else{
        		result = height[end] * (end - start) > result ? height[end] * (end - start) : result;
        		end --;
        	}
        }
        return result;
    }
	
	public static void main(String[] args){
		int a [] = {2,1};
		System.out.println(maxArea(a));
	}
}
