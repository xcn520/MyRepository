package com.leetcode.q041;

import java.util.Arrays;


public class Solution {
	public static int firstMissingPositive(int[] A) {
        if(A.length <= 0)
        	return 1;
        if(A.length == 1 && A[0] != 1)
        	return 1;
        else if(A.length==1 && A[0] == 1)
        	return 2;
        Arrays.sort(A);
        int i = 0, target = 1;
        while(i < A.length){
        	if(A[i] <= 0){
        		i ++;
        	}else{
        		if(A[i] == target){
        			i ++;
        			while(i < A.length && A[i] == target){
        				i ++;
        			}
        			target ++;
        		}
        		else{
        			return target;
        		}
        	}
        }
        return target;
    }
	public static void main(String[]a){
		int [] A = {0,2,2,1,1};
		firstMissingPositive(A);
	}
}
