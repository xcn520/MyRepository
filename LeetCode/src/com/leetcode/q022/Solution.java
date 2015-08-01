package com.leetcode.q022;

/**
 * ??????????????????????????????????
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * */
import java.util.ArrayList;
import java.util.List;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"*/
public class Solution {
	public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        generate(result,"", 0, 0, n);
        return result;
    }

	private void generate(ArrayList<String> result,String tem, int l, int r,
			int n) {
		if(l == n){
			for(int i = 0;i < n - r; i ++){
				tem += ")";
			}
			result.add(tem);
			return;
		}
		generate(result, tem + "(", l + 1, r, n);  
        if(l > r)  
            generate(result, tem + ")", l, r + 1, n);  
		
	}
}
