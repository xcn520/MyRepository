package com.leetcode.q021;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
