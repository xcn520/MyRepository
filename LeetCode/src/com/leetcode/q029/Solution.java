package com.leetcode.q029;

public class Solution {
	public static int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == 0)
        	return 0;
        if(divisor == 1)
        	return dividend;
        long divisor1 = (long) divisor;
        long dividend1 = (long) dividend;
        int flag = 0;
        if(dividend1 < 0){
        	dividend1 = -dividend1;
        	flag ++;
        }
        if(divisor1 < 0){
        	divisor1 = - divisor1;
        	flag ++;
        }
        long[] num = new long[32];
        long[] sum = new long[32];
        num[0] = 1;
        sum[0] = divisor1;
        int i = 1;
        long result = 0;
        for(i = 1; sum[i - 1] < dividend1 & i < 32; i ++){
        	sum[i] = sum[i - 1] + sum[i - 1];
        	num[i] = num[i - 1] + num[i - 1];
        }
        -- i;
        while(dividend1 >= divisor1 && i >= 0){
        	while(dividend1 >= sum[i] && sum[i] > 0){
        		dividend1 -= sum[i];
        		result += num[i];
        	}
        	i --;
        }
        if(flag ==0 || flag == 2){
        	if(result > Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	return (int)result;
        }
        if((-result) < Integer.MIN_VALUE){
        	return Integer.MAX_VALUE;
        }
        return (int)-result;
    }
	
	public static void main(String[]a){
		System.out.println(divide(-2147483648, -1));
	}
}
