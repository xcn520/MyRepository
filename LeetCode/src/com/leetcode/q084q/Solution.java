package com.leetcode.q084q;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        int i = 0, res = 0;
        while(i < h.length){
        	if(stack.isEmpty() || h[stack.peek()] <= h[i]){
        		stack.add(i ++);
        	}else{
        		int start = h[stack.pop()];
        		int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        		res = res >= start * width ? res : start * width;
        	}
        }
        return res;
    }
}
