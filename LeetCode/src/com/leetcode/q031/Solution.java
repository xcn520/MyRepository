package com.leetcode.q031;

import java.util.Arrays;

public class Solution {
	public void nextPermutation(int[] num) {
        if(num.length < 2)
        	return;
        for(int i = num.length - 2; i >= 0; i --){
        	if(num[i] < num[i + 1]){
        		int j = num.length - 1;
        		while(num[i] >= num[j]){
        			j --;
        		}
        		int tem = num[i];
        		num[i] = num[j];
        		num[j] = tem;
        		Arrays.sort(num, i + 1, num.length);
        		return ;
        	}
        }
        Arrays.sort(num);
        return;
    }
}
