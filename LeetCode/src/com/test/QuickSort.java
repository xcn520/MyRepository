package com.test;

public class QuickSort {
	public static void quickSort(int[] nums){
		if(nums == null)
			return ;
		int start = 0, end = nums.length - 1;
		sort(nums, start, end);
	}

	private static void sort(int[] nums, int start, int end) {
		if(start < end && nums != null){
			int mid = getMid(nums, start, end);
			sort(nums, start, mid - 1);
			sort(nums, mid + 1, end);
		}
	}

	private static int getMid(int[] nums, int start, int end) {
		int compare = nums[start];
		int i = start, j = end;
		while(i < j){
			while(nums[i] <= compare && i < end){
				i ++;
			}
			while(nums[j] > compare && j >= start){
				j --;
			}
			if(i < j){
				nums[i] = nums[i] ^ nums[j];
				nums[j] = nums[i] ^ nums[j];
				nums[i] = nums[i] ^ nums[j];
			}
		}
		if(j > start){
			nums[start] = nums[start] ^ nums[j];
			nums[j] = nums[start] ^ nums[j];
			nums[start] = nums[start] ^ nums[j];
		}
		return j;
	}
	public static void main(String[] args){
		int[] num = {1,3,2,8,6,5,9,4};
		quickSort(num);
	}

}
