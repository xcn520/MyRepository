package com.leetcode.q027;

public class Solution {
	public int removeElement(int[] A, int elem) {
        if(A.length == 0 || (A.length == 1 && elem == A[0]))
            return 0;
        int i = 0;
        for(int j = 0; j < A.length; j ++){
            if(A[j] != elem){
                A[i ++] = A[j];
            }
        }
        return i;
    }
}
