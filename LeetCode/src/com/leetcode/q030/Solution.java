package com.leetcode.q030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
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
        	for(int j = i; j < i + wordLength * wordCount; j = j + wordLength){
        		String str = S.substring(j, j + wordLength);
        		if(map.containsKey(str)){
        			if(hp.containsKey(str)){
        				hp.put(str, hp.get(str) + 1);
        				if(hp.get(str) > map.get(str))
        					break;
        			}else{
        				hp.put(str, 1);
        			}
        			k ++;
        		}else{
        			break;
        		}
        	}
        	if(k == wordCount){
        		result.add(i);
        	}
        }
        return result;
    }
	public static void main(String[]a){
		String[] l = {"a"};
		findSubstring("a",l);
	}
}
