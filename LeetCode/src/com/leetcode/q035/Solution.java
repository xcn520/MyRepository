package com.leetcode.q035;

public class Solution {
	public int searchInsert(int[] A, int target) {
		if (A.length < 1)
			return 0;
		if (A.length == 1) {
			if (target <= A[0])
				return 0;
			else
				return 1;
		}
		int left = 0, right = A.length - 1;
		while (left <= right) {
			if (A[right] < target)
				return right + 1;
			if (A[left] >= target)
				return left;
			if (A[right] == target)
				return right;
			int mid = (left + right) / 2;
			if (A[mid] == target)
				return mid;
			if (A[mid] < target)
				left = mid + 1;
			if (A[mid] > target)
				right = mid - 1;
		}
		return 0;
	}
}
