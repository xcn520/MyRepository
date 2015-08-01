package com.leetcode.q071;

import java.util.Stack;

public class Solution {
	public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
        	return path;
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String str : strs){
        	if(str.equals("") || str.equals(".")){}
        	else if(str.equals("..")){
        		if(!stack.isEmpty()){
        			stack.pop();
        		}
        	}else{
        		stack.add(str);
        	}
        }
        Stack<String> stack2 = new Stack<String>();
        while(!stack.isEmpty()){
        	stack2.add(stack.pop());
        }
        String res = "";
        while(!stack2.isEmpty()){
        	res += ("/"+stack2.pop());
        }
        if(res.equals(""))
            return "/";
        return res;
    }
}
