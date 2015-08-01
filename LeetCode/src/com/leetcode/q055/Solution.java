package com.leetcode.q055;

import java.util.List;

public class Solution {
	public boolean canJump(List<Integer> nums) {
        int ret = 0;// 当前跳数
		int last = 0;// 上一跳可达最远距离
		int curr = 0;// 当前一跳可达最远距
		for (int i = 0; i < nums.size(); ++i) {
			// 无法向前继跳直接返回
			if (i > curr) {
				return false;
			}
			// 需要进行下次跳跃，则更新last和当执行的跳数ret
			if (i > last) {
				last = curr;
				++ret;
			}
			// 记录当前可达的最远点
			curr = curr > (i + nums.get(i)) ? curr : (i + nums.get(i));
		}

		return true;
    }
}
