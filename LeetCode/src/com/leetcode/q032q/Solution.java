package com.leetcode.q032q;

import java.util.Stack;

public class Solution {
	public static int longestValidParentheses(String s) {
        int result = 0;
        if(s.length() == 0)
        	return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int[] idx = new int[s.length()];
        for(int i = 0;i < s.length(); i ++){
        	if(s.charAt(i)=='('){
        		stack.push(i);
        	}else{
        		if(!stack.isEmpty()){
        			idx[stack.pop()] = i;
        			idx[i] = -1;
        		}else{
        			idx[i] = -1;
        		}
        	}
        }
        while(!stack.isEmpty()){
        	idx[stack.pop()] = -1;
        }
        int curr = 0, i = 0;
        while(i < idx.length){
        	if(idx[i] == -1){
        		result = result > curr ? result : curr;
        		curr = 0;
        		i ++;
        	}else{
        		curr += idx[i] - i + 1;
        		i = idx[i] + 1;
        		if(i >= idx.length)
        			result = result > curr ? result : curr;
        	}
        }
        return result;
    }
	public static void main(String[]q){
		longestValidParentheses("()");
	}
}
