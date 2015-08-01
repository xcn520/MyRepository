package com.leetcode.q018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int j = 0; j < num.length; j++) {
			if(j >= 1 && num[j] == num[j - 1])
				continue;
			for (int i = j + 1; i < num.length; i++) {
				if (i > j + 1 && num[i] == num[i - 1]) {
					continue;
				}
				int p = i + 1;
				int q = num.length - 1;
				while (p < q) {
					if (num[j] + num[i] + num[p] + num[q] == target) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(num[j]);
						l.add(num[i]);
						l.add(num[p]);
						l.add(num[q]);
						result.add(l);
						p++;
						while (num[p] == num[p - 1] && p < q)
							p++;
					} else if (num[j] + num[i] + num[p] + num[q] < target) {
						p++;
						while (num[p] == num[p - 1] && p < q)
							p++;
					} else if (num[j] + num[i] + num[p] + num[q] > target) {
						q--;
						while (num[q] == num[q + 1] && p < q)
							q--;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int num[] = {1,-2,-5,-4,-3,3,3,5};
		long start = System.currentTimeMillis();
		List<List<Integer>> result = fourSum(num, -11);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
