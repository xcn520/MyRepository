package com.leetcode.q050q;

public class Solution {
	public static double pow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(n < 0 && n != Integer.MIN_VALUE)
            return 1.0 / pow(x, -n);
        if(n < 0 && n == Integer.MIN_VALUE)
        	return 1.0 / (pow(x, -(n + 1)) * x);
        double result = 1.0;
        while(n > 0){
        	if(n % 2 == 0){
        		result *= x;
        	}
        	n /= 2;
        	x *= x;
        }
        return result;
    }
	public static void main(String[] args) {
		pow(0.0001, 2147483647);
	}
}
