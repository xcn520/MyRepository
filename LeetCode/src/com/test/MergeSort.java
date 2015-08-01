package com.test;

public class MergeSort {

	public static void mergeSort(int[] nums){
		if(nums == null || nums.length <= 1){
			return ;
		}
		int start = 0, end = nums.length - 1;
		mergeSort(nums, start, end);
		
	}

	private static void mergeSort(int[] nums, int start, int end) {
		if(start < end){
			int mid = (start + end)/2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid + 1, end);
			merge(nums, start, mid, end);
		}
	}

	private static void merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while(i <= mid && j <= end){
			if(nums[i] <= nums[j])
				temp[k ++] = nums[i ++];
			else
				temp[k ++] = nums[j ++];
		}
		while(i <= mid){
			temp[k ++] = nums[i ++];
		}
		while(j <= end)
		{
			temp[k ++] = nums[j ++];
		}
		for(int k2 = 0; k2 < temp.length; k2++){
			nums[k2 + start] = temp[k2];
		}
	}
	
	public static void main(String[] args){
		int[] num = {1,3,2,8,6,5,9,4};
		mergeSort(num);
	}
}
