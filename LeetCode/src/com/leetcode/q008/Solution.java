package com.leetcode.q008;

public class Solution {
	public static int atoi(String str) {
		if(str == null || str.trim().equals("")){
        	return 0;
        }
        str = str.trim();
        String flag = "+";
        boolean flag2 = false;
        long result = 0;
        int begin = 0;
        if(str.charAt(begin) == '+'){
        	begin ++;
        }else if(str.charAt(begin) == '-'){
        	begin ++;
        	flag = "-";
        }
        if(!(str.charAt(begin) >= '0' && str.charAt(begin) <= '9')){
        	return 0;
        }
        while (begin < str.length() && str.charAt(begin) >= '0' && str.charAt(begin) <= '9' ){
            if(str.charAt(begin) > '0')
                flag2 = true;
            if(flag2){
                result = result * 10 + (str.charAt(begin) - '0');
            }
            if(result > Integer.MAX_VALUE)
            	break;
        	begin ++;
        }
        if(flag == "+" && result <= Integer.MAX_VALUE)
        	return (int)result;
        if(flag == "+" && result > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if(flag == "-" && -result >= Integer.MIN_VALUE)
        	return (int)-result;
        if(flag == "-" && -result < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return 0;
    }
	
	public static void main(String[] args){
		int result = atoi("2147483648");
		System.out.println(result);
	}
}
