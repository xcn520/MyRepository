package com.test;

public class IP2Integer {
	public static final long PART1 = 0xff000000;
	public static final long PART2 = 0xff0000;
	public static final long PART3 = 0xff00;
	public static final long PART4 = 0xff;
	public static long ip2Int(String ip){
		long result = 0;
		String[] str = ip.split("\\.");
		result = result | (Long.valueOf(str[0]) << 24);
		result = result | (Long.valueOf(str[1]) << 16);
		result = result | (Long.valueOf(str[2]) << 8);
		result = result | Long.valueOf(str[3]);
		return result;
	}
	public static String num2IPStr(long num){
		long part = (num & PART1) >> 24;
		String result = String.valueOf(part);
		part = (num & PART2) >> 16;
		result = result + "." + String.valueOf(part);
		part = (num & PART3) >> 8;
		result = result + "." + String.valueOf(part);
		part = (num & PART4);
		result = result + "." + String.valueOf(part);
		return result;
	}
	public static void main(String[] args) {
		String s = "128.255.255.255";
		long res = ip2Int(s);
		System.out.println(res);
		String str = num2IPStr(res);
		System.out.println(str);
	}
}
