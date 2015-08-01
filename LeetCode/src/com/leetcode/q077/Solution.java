package com.leetcode.q077;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<Integer>> combine(int n, int k) {
        if(k > n)
        	return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(res,list,1,n,k);
        return res;
    }

	private static void helper(List<List<Integer>> res, List<Integer> list, int start,
			int n, int k) {
		if(k == 0){
			res.add(new ArrayList(list));
			return;
		}
		if(start > n)
			return;
		for(; start <= n; start ++){
			list.add(start);
			helper(res,list,start+1,n,k-1);
			list.remove(list.size() - 1);
		}
	}
	public static void main(String[] args) {
		combine(2,2);
	}
}
