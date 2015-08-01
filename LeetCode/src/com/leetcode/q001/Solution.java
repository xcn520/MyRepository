package com.leetcode.q001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int[] result = new int[2];
	    for(int i = 0; i < numbers.length; i ++ ){
	            if(map.get(target - numbers[i]) != null){
	                result[1] = i + 1;
	                result[0] = (int) map.get(target - numbers[i]);
	            }else{
	                map.put(numbers[i], i+1);
	            }
	     }
	     return result;
    }
}
