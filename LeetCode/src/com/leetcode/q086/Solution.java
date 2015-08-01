package com.leetcode.q086;

public class Solution {
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head, tail = null, pre = null, nHead = new ListNode(0);
		int count = 0;
		while (p != null) {
			tail = p;
			p = p.next;
			count++;
		}
		p = head;
		nHead.next = head;
		pre = nHead;
		int i = 0;
		while (i < count && p != tail) {
			if (p.val < x) {
				pre = p;
				p = p.next;
			} else {
				pre.next = p.next;
				tail.next = p;
				tail = tail.next;
				tail.next = null;
				p = pre.next;
			}
			i++;
		}
		return nHead.next;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		// l.next.next=new ListNode(3);
		// l.next.next.next = new ListNode(2);
		// l.next.next.next.next = new ListNode(5);
		// l.next.next.next.next.next = new ListNode(2);
		partition(l, 2);
	}
}
