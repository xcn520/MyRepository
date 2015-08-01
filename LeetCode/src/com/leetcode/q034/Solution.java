package com.leetcode.q034;

public class Solution {
	public static int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if(A.length < 1)
        	return result;
        if(A.length == 1 && A[0] == target){
        	result[0] = 0; 
        	result[1] = 0; 
        	return result;
        }
        int start = 0, end = A.length - 1;
        while(start <= end){
        	int middle = (start + end)/2;
        	if(A[middle] > target){
        		end = middle - 1;
        	}else if(A[middle] < target){
        		start = middle + 1;
        	}else{
        		result[0] = findIndex(A, start, middle, target, true);
        		result[1] = findIndex(A, middle, end, target, false);
        		break;
        	}
        }
        return result;
    }

	private static int findIndex(int[] a, int start, int end, int target, boolean b) {
		int left = start, right = end;
		if(b){
			int result = end;
			while(left <= right){
				int mid = (left + right)/2;
				if(a[mid] < target){
					left = mid + 1;
				}else{
					result = result < mid ? result : mid;
					right = mid - 1;
				}
			}
			return result;
		}else{
			int result = start;
			while(left <= right){
				int mid = (left + right)/2;
				if(a[mid] > target){
					right = mid - 1;
				}else{
					result = result > mid ? result : mid;
					left = mid + 1;
				}
			}
			return result;
		}
	}
	public static void main(String[]a){
		int[] l = {2,2};
		searchRange(l,2);
	}
}
