package com.leetcode.q072q;

public class Solution {
	public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i ++){
        	dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j ++){
        	dp[0][j] = j;
        }
        for(int i = 1; i <= len1; i ++){
        	char c1 = word1.charAt(i - 1);
        	for(int j = 1; j <= len2; j ++){
        		char c2 = word2.charAt(j - 1);
        		if(c1 == c2)
        			dp[i][j] = dp[i - 1][j - 1];
        		else{
        			int insert = dp[i - 1][j] + 1;
        			int delete = dp[i][j - 1] + 1;
        			int replace = dp[i - 1][j - 1] + 1;
        			dp[i][j] = Math.min(Math.min(insert, delete), replace);
        		}
        	}
        }
        return dp[len1][len2];
    }
}
