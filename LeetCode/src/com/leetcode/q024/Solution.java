package com.leetcode.q024;

public class Solution {
	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode newHead = head.next;
        ListNode p = head;
        ListNode q = head.next;
        ListNode pre = p;
        while(p != null && q != null){
        	pre.next = q;
        	p.next = q.next;
        	q.next = p;
        	pre = p;
        	p = p.next;
        	if(p != null)
        		q = p.next;
        }
        return newHead;
    }
	public static void main(String[] a){
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next= new ListNode(4);
		swapPairs(l);
	}
}
