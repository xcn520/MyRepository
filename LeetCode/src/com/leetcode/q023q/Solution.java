package com.leetcode.q023q;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	public  ListNode mergeKLists(List<ListNode> lists) {
        /*ListNode result = new ListNode(0);
        ListNode p = result;
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode min = new ListNode(Integer.MAX_VALUE);
        int flag = Integer.MAX_VALUE;
        if(lists == null)
        	return null;
        for(int i = 0; i < lists.size(); i ++){
        	if(lists.get(i) == null)
        		continue;
        	if(min.val > lists.get(i).val){
        		flag = i;
        		min.val = lists.get(i).val;
        	}
        }
        if(min.val != Integer.MAX_VALUE){
        	p.next = new ListNode(min.val);
            p = p.next;
            for(int i = 0; i < lists.size(); i ++){
            	if(i == flag && lists.get(i).next != null){
            		list.add(lists.get(i).next);
            	}else if(i != flag && lists.get(i) != null){
            		list.add(lists.get(i));
            	}
            }
            if(lists.size() > 0){
            	p.next = mergeKLists(list);
            }
        }
        return result.next;*/
		/*if(lists == null || lists.size() == 0)
			return null;
		if(lists.size() == 1)
			return lists.get(0);
		ListNode result = new ListNode(0);
		result.next = lists.get(0);
		for(int i = 1; i < lists.size(); i ++){
			result.next = mergeTwoLists(lists.get(i), result);
		}
		return result.next;*/
		if(lists == null || lists.size() == 0)
			return null;
		if(lists.size() == 1)
			return lists.get(0);
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		for(int i = 0; i < lists.size(); i ++){
			if(lists.get(i) != null){
				queue.add(lists.get(i));
			}
		}
		ListNode result = new ListNode(0);
		ListNode p = result;
		while(queue.size() > 0){
			ListNode curr = queue.poll();
			p.next = curr;
			p = p.next;
			if(curr.next != null)
				queue.add(curr.next);
		}
		return result.next;
    }
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode q = head;
        if(l1 == null){
        	head = l2;
        	return head;
        }
        if(l2 == null){
        	head = l1;
        	return head;
        }
        if(l1.val < l2.val){
    		q.val = l1.val;
    		l1 = l1.next;
    	}else{
    		q.val = l2.val;
    		l2 = l2.next;
    	}
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		q.next = l1;
        		q = q.next;
        		l1 = l1.next;
        	}else{
        		q.next = l2;
        		q = q.next;
        		l2 = l2.next;
        	}
        }
        if(l1 == null && l2 != null)
        	q.next = l2;
        if(l1 != null && l2 == null)
        	q.next = l1;
        return head;
    } 
	
	public static void main(String[]a){
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(null);
	}
}
