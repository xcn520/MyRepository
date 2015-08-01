package com.leetcode.q025q;

public class Solution {
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null || head.next == null)
        	return head;
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode pre = nHead;
        ListNode p = head;
        int count = 0;
        while(p != null){
        	count ++;
        	p = p.next;
        }
        while(count >= k){
        	ListNode curr = pre.next;
        	ListNode begin = curr;
        	ListNode post = curr.next;
        	for(int i = 1; i < k; i ++){
        		ListNode tem = post.next;
        		post.next = curr;
        		curr = post;
        		post = tem;
        	}
        	pre.next = curr;
        	pre = begin;
        	pre.next = post;
        	count -= k;
        }
        return nHead.next;
    }
	public static void main(String[] a){
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
//		l.next.next = new ListNode(3);
//		l.next.next.next= new ListNode(4);
		reverseKGroup(l, 2);
	}
}
