package com.leetcode.q002;

public class Solution {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode result = new ListNode(0);
		ListNode p3 = result;
		int value = 0;
		while (p1 != null || p2 != null || value > 0){
			if(p1 != null){
				value += p1.val;
				p1 = p1.next;
			}
			if(p2 != null){
				value += p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(value % 10);
			p3 = p3.next;
			value = value / 10;
		}
		return result.next;
	}
	public static void main(String[] args){
		
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode (3);
		ListNode l = addTwoNumbers(l1 , l2);
		System.out.println(l.val + l.next.val + l.next.next.val);
	}
}
