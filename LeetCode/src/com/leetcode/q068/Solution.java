package com.leetcode.q068;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
        if(words.length == 1 && words[0].length() == 0 && maxWidth == 0){
            res.add("");
            return res;
        }
        if(words.length == 0 || maxWidth <= 0)
            return res;
        int n = words.length;
        int length = 0, space = 0, start = 0, end = 0;
        for(int i = 0; i < n; i++){
            length += words[i].length() + 1;
            if(length < maxWidth + 1 && i != n - 1)
            	continue;
            else if(length < maxWidth + 1 && i == n - 1){
            	end = n - 1;
            	String str = "";
            	for (int j = start; j <= end; j ++){
            		str += (words[j] + " ");
            	}
            	int l = maxWidth - str.length();
            	if(l < 0)
            	    res.add(str.trim());
            	else{
            	    for(int j = 0; j < l; j ++){
            	        str += " ";
            	    }
            	}
            	length = 0; 
            	space = 0;
            	res.add(str);
            	i = end;
            	start = end + 1;
            	end += 1;
            }
            else if(length == maxWidth + 1){
            	end = i;
            	String str = "";
            	for(int j = start; j <= end; j ++){
            		str += (words[j] + " ");
            	}
            	res.add(str.length() == maxWidth ? str : str.trim());
            	i = end;
            	start = end + 1;
            	end = end + 1;
            	length = 0;
            }else{
            	end = i - 1;
            	int l = 0,count = 0;;
            	for (int j = start; j <= end; j ++){
            		l += words[j].length();
            		count ++;
            	}
            	int mod = 0;
            	if(count != 1){
            		space = (maxWidth - l)/(count - 1);
            		mod = (maxWidth - l)%(count - 1);
            	}
            	else
            		space = maxWidth - l;
            	String str = "";
            	for(int k = start; k <= end; k ++){
            		str += words[k];
            			for(int j = 0; j < space; j ++){
                			str += " ";
                		}
            			if(mod > 0)
                			str += " ";
                		mod --;
            	}
            	length = 0; 
            	space = 0;
            	res.add(str.length() == maxWidth ? str : str.trim());
            	i = end;
            	start = end + 1;
            	end += 1;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		String[] w = {"This", "is", "an", "example", "of", "text", "justification."};
		fullJustify(w,16);
	}
}
