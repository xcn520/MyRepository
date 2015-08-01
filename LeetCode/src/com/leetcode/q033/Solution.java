package com.leetcode.q033;

public class Solution {
	public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while(left <= right){
        	int middle = (left + right)/2;
        	if(target == A[middle])
        		return middle;
        	if(A[left] < A[middle]){
        		if(target >= A[left] && target < A[middle])
        			right = middle - 1;
        		else left = middle + 1;
        	}else if(A[left] > A[middle]){
        		if(target >= A[left] || target < A[middle])
        			right = middle - 1;
        		else left = middle + 1;
        	}else{
        		left ++;
        	}
        }
        return -1;
    }
}
