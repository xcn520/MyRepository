package com.leetcode.q049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < strs.length; i ++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String anagram = new String(str);
            if(map.containsKey(anagram)){
                if(map.get(anagram) != -1){
                    result.add(strs[map.get(anagram)]);
                    map.put(anagram, -1);
                }
                result.add(strs[i]);
            }else{
                map.put(anagram, i);
            }
        }
        return result;
	}
}
