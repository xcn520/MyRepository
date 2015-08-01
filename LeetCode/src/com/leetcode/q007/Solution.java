package com.leetcode.q007;

public class Solution {
	public static int reverse(int x) {
		/*
		 * String str = String.valueOf(x); String result = ""; if(str.charAt(0)
		 * == '-'){ result += "-"; for(int i = str.length() - 1; i > 0; i --){
		 * result += str.charAt(i); } }else{ for(int i = str.length() - 1; i >=
		 * 0; i --){ result += str.charAt(i); } } try{ return
		 * Integer.valueOf(result); }catch (Exception e) { return 0; }
		 */
		long result = 0;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		while (x != 0) {
			if (!((result * 10 + x % 10) > max || (result * 10 + x % 10) < min)){
				result = result * 10 + x % 10;
				x /= 10;
			} else {
				return 0;
			}
		}
		return (int)result;
	}

	public static void main(String[] args) {
		int result = reverse(1234567899);
		System.out.println(result);
	}
}
