package com.leetcode.q016;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int key = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			if(key == 0)
				break;
			if (i >= 1 && num[i] == num[i - 1]) {
				continue;
			}
			int p = i + 1;
			int q = num.length - 1;
			while (p < q) {
				if (num[i] + num[p] + num[q] == target) {
					key = 0;
					result = target;
					break;
				} else if (num[i] + num[p] + num[q] < target) {
					if(key > target - (num[i] + num[p] + num[q])){
						key = target - (num[i] + num[p] + num[q]);
						result = num[i] + num[p] + num[q];
					}
					p++;
					while (num[p] == num[p - 1] && p < q)
						p++;
				} else if (num[i] + num[p] + num[q] > target) {
					if(key > (num[i] + num[p] + num[q]) - target){
						key = (num[i] + num[p] + num[q]) - target;
						result = num[i] + num[p] + num[q];
					}
					q--;
					while (num[q] == num[q + 1] && p < q)
						q--;
				}
			}
		}
		return result;
	}
}
