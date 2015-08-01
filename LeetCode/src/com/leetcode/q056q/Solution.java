package com.leetcode.q056q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 0)
        	return new ArrayList<Interval>();
        Collections.sort(intervals, new intervalComparator());
        List<Interval> res = new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        res.add(pre);
        for(int i = 1; i < intervals.size(); i ++){
        	Interval curr = intervals.get(i);
        	if(pre.end >= curr.start){
        		pre = new Interval(pre.start, Math.max(pre.end, curr.end));
        		res.remove(res.size() - 1);
        		res.add(pre);
        	}else{
        		pre = curr;
        		res.add(pre);
        	}
        }
        return res;
	}
	class intervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}

	}
}
