package com.test;

public class Probability {

	public static float getProbability(int n, int s){
		if(n <= 0 || s < n || s > 6 * n)
			return 0f;
		else{
			int [] times = new int[6 * n + 1];
			for(int i = 1; i <= 6; i ++)
				times[i] = 1;
			for(int i = 2; i <= n; i ++){
				for(int k = 6 * i; k >= n; k --){
					int number = 0, count = 1;
					for(int k2 = k - 1; k2 >= 0 && count <= 6; k2 --, count ++){
						number += times[k2];
					}
					times[k] = number;
				}
				for(int j = 0; j < i; j ++){
					times[j] = 0;
				}
			}
			return getProb(times, n, s);
		} 
			
	}

	private static float getProb(int[]num, int n, int s) {
		int sum = 0;
		int s_time = num[s];
		for(int i = n; i <= 6 * n; i ++){
			sum += num[i];
		}
		return (s_time * 1.0f) / (sum * 1.0f);
	}
	
	public static void main(String[]args){
		System.out.println(getProbability(3, 3));
	}
}
