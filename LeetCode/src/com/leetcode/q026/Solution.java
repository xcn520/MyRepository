package com.leetcode.q026;

public class Solution {
	public static int removeDuplicates(int[] A) {
        if(A.length <= 1)
        	return 0;
        int i = 0;
        int j = 1;
        while(j < A.length){
        	if(A[j] != A[i]){
        		i ++;
        		A[i] = A[j];
        		j ++;
        	}else{
        		j ++;
        	}
        }
        return i + 1;
    }
	
	public static void main(String[]a){
		int[] b = {1,1,2,3,3,4};
		removeDuplicates(b);
	}
}
