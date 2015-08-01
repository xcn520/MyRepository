package com.leetcode.q020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for(int i = 0; i < s.length(); i ++){
        	char curr = s.charAt(i);
        	if(map.keySet().contains(curr))
        		stack.push(curr);
        	else{
        		if(!stack.isEmpty() && map.get(stack.peek()).equals(curr)){
        			stack.pop();
        		}else{
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }
}
