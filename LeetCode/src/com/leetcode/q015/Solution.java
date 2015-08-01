package com.leetcode.q015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length; i ++){
        	if(num[i] > 0)
        		break;
        	else{
        		if(i >= 1 && num[i] == num[i-1]){
        			continue;
        		}
        		int p = i + 1;
        		int q = num.length - 1;
        		while(p < q){
        			if(num[i] + num[p] + num[q] == 0){
        				List<Integer> l = new ArrayList<Integer>();
        				l.add(num[i]);
        				l.add(num[p]);
        				l.add(num[q]);
        				result.add(l);
        				p ++;
        				while(num[p] == num[p-1] && p < q)
        					p ++;
        			}else if(num[i] + num[p] + num[q] < 0){
        				p ++;
        				while(num[p] == num[p-1] && p < q)
        					p ++;
        			}else if(num[i] + num[p] + num[q] > 0){
        				q --;
        				while(num[q] == num[q+1] && p < q)
        					q --;
        			}
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args){
		int num[] = {1,-1,-1,0};
		long start = System.currentTimeMillis();
		List<List<Integer>> result = threeSum(num);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
