package com.leetcode.q009;

public class Solution {
	public static boolean isPalindrome(int x) {
        if(x < 0)
        	return false;
        int compare = reverse(x);
        if(x == compare)
        	return true;
        return false;
    }
	private static int reverse(int x) {
		int compare = 0;
		while(x != 0){
        	compare = compare * 10 + x % 10;
        	x /= 10;
        }
		return compare;
	}
	public static void main(String[] args){
		System.out.println(isPalindrome(101011));
	}
}
