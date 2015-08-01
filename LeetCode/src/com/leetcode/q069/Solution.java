package com.leetcode.q069;

public class Solution {
	public static int mySqrt(int x) {
        int left = 0, right = x;
        if(x <= 0)
            return 0;
        int result = 0;
        while(left <= right){
            long mid = (left + right)/2;
            if(mid * mid == x)
                return (int)mid;
            if(mid * mid > x)
                right = (int)mid - 1;
            else{
                left = (int)mid + 1;
                result = result < mid ? (int)mid : result;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		mySqrt(2147395599);
	}
}
