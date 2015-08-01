package com.leetcode.q046q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        perm(num, result, list);
        return result;
    }
    private void perm(int[] num, List<List<Integer>> result, List<Integer> list) {
    	if(num.length == 0){
    		result.add(new ArrayList<Integer> (list));
    		return;
    	}
    	for(int i = 0; i < num.length; i ++){
    		list.add(num[i]);
    		int[] tem = new int[num.length - 1];
    		for(int j = 0; j < i; j ++){
    			tem[j] = num[j];
    		}
    		for(int j = i; j < tem.length; j ++){
    			tem[j] = num[j + 1];
    		}
    		perm(tem, result, list);
    		list.remove(list.size() - 1);
    	}
	}
}
