package com.test;

import java.util.ArrayList;
import java.util.List;

public class SegmentSort {

	public void segmentSort(double[] nums){
		if(nums == null)
			return;
		int length = nums.length;
		List[] segs = new List[10];
		for(int i = 0; i < length; i ++){
			int number = (int) (10*nums[i]);
			if(segs[number] == null){
				List<Double> l = new ArrayList<Double>();
				l.add(nums[i]);
			}else{
				segs[number].add(nums[i]);
			}
		}
		int k = 0;
		for(int i = 0; i < 10; i ++){
			List<Double> ll = insertSort(segs[i]);
			if(ll != null){
				for(Double d : ll){
					nums[k ++] = d;
				}
			}
		}
		
	}

	private List<Double> insertSort(List<Double> list) {
		// TODO Auto-generated method stub
		return null;
	}
}
