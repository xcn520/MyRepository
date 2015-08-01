package com.leetcode.q030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
	public static List<Integer> findSubstring(String S, String[] L) {
        if(S == null || L == null)
        	return null;
        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String str : L){
        	if(map.containsKey(str)){
        		map.put(str, map.get(str) + 1);
        	}else{
        		map.put(str, 1);
        	}
        }
        int wordLength = L[0].length();
        int wordCount = L.length;
        for(int i = 0; i <= S.length() - wordLength * wordCount; i ++){
        	Map<String, Integer> hp = new HashMap<String, Integer>();
        	int k = 0;
        	for(int j = i, j2 = i + (wordLength)*(wordCount-1); j <= j2; j = j + wordLength, j2 = j2 - wordLength){
        		if(j == j2){
        			String str1 = S.substring(j, j + wordLength);
        			if(map.containsKey(str1)){
            			if(hp.containsKey(str1)){
            				hp.put(str1, hp.get(str1) + 1);
            			}else{
            				hp.put(str1, 1);
            			}
            			if(hp.get(str1) > map.get(str1))
        					break;
            			k += 1;
            		}else{
            			break;
            		}
        		}else{
        			String str1 = S.substring(j, j + wordLength);
            		String str2 = S.substring(j2, j2 + wordLength);
            		if(map.containsKey(str1) && map.containsKey(str2)){
            			if(hp.containsKey(str1)){
            				hp.put(str1, hp.get(str1) + 1);
            			}else{
            				hp.put(str1, 1);
            			}
            			if(hp.containsKey(str2)){
            				hp.put(str2, hp.get(str2) + 1);
            			}else{
            				hp.put(str2, 1);
            			}
            			if(hp.get(str1) > map.get(str1))
        					break;
            			if(hp.get(str2) > map.get(str2))
        					break;
            			k += 2;
            		}else{
            			break;
            		}
        		}
        	}
        	if(k == wordCount){
        		result.add(i);
        	}
        }
        return result;
    }
	public static void main(String[]a){
		String[] l = {"fooo","barr","wing","ding","wing"};
		findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",l);
	}
}
