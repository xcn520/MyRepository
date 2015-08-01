package com.leetcode.q043q;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static String multiply(String num1, String num2) {
		if (num1.length() == 0 || num2.length() == 0)
			return "0";
		if((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0'))
			return "0";
		String result = "", tail = "";
		List<String> l = new ArrayList<String>();
		for (int i = num2.length() - 1; i >= 0; i--) {
			if (i != num2.length() - 1)
				tail += "0";
			String temp = tail;
			int v = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				int k1 = Integer.valueOf(String.valueOf(num1.charAt(j)));
				int k2 = Integer.valueOf(String.valueOf(num2.charAt(i)));
				int value = k1 * k2 + v;
				v = value / 10;
				temp = String.valueOf((value % 10)) + temp;
			}
			if (v > 0) {
				temp = String.valueOf(v) + temp;
			}
//			result = sum(result, temp);
			l.add(temp);
		}
		for(int i = 0; i < l.size(); i ++){
			result = sum(result, l.get(i));
		}
		return result;
	}

	private static String sum(String result, String temp) {
		int i = result.length() - 1, j = temp.length() - 1, tem = 0;
		String res = "";
		while(i >= 0 && j >= 0){
			int value = Integer.valueOf(String.valueOf(result.charAt(i))) + Integer.valueOf(String.valueOf(temp.charAt(j))) + tem;
			tem = value / 10;
			res = String.valueOf(value % 10) + res;
			i --;
			j --;
		}
		while(i >= 0){
			int value = Integer.valueOf(String.valueOf(result.charAt(i))) + tem;
			tem = value / 10;
			res = String.valueOf(value % 10) + res;
			i --;
		}
		while(j >= 0){
			int value = Integer.valueOf(String.valueOf(temp.charAt(j))) + tem;
			tem = value / 10;
			res = String.valueOf(value % 10) + res;
			j --;
		}
		if(tem > 0){
			res = String.valueOf(tem) + res;
		}
		return res;
	}
	public static void main(String[]a){
		long start = System.currentTimeMillis();
		String result = multiply("876951260380003421157781274806313","822645457782195762777437600752946401176964373861231");
		
//		String result = multiply2("876951260380003421157781274806313","822645457782195762777437600752946401176964373861231");
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	public static String multiply2(String num1, String num2) {
		if(num1.length() == 0 || num2.length()==0)
			return "0";
		if((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0'))
			return "0";
		int[] num11 = new int[num1.length()];
		int[] num22 = new int[num2.length()];
		int[] res = new int[num1.length() + num2.length()];
		int ii = 0, jj = 0;
		String result = "";
		for(int i = num1.length() - 1; i >= 0; i --){
			num11[ii] = Integer.valueOf(String.valueOf(num1.charAt(i))); 
			ii ++;
		}
		for(int j = num2.length() - 1; j >=0; j --){
			num22[jj] = Integer.valueOf(String.valueOf(num2.charAt(j)));
			jj ++;
		}
		for(int i = 0; i < num11.length; i ++){
			for(int j = 0; j < num22.length; j ++){
				res[i + j] += num11[i] * num22[j];
			}
		}
		int temp = 0;
		for(int i = 0; i < res.length - 1; i ++){
			int value = (res[i] + temp) % 10;
			temp = (res[i] + temp) / 10;
			result = String.valueOf(value) + result;
		}
		if(temp > 0){
			result = String.valueOf(temp) + result;
		}
		return result;
	}
}
