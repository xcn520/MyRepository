package com.leetcode.q019;

public class Solution {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode p = head;
		ListNode q = head;
		for (int i = 0; i < n; i++) {
			q = q.next;
		}
		if (q == null) {
			head = head.next;
			p = null;
			return head;
		}
		while (q.next != null) {
			p = p.next;
			q = q.next;
		}
		ListNode tmp = p.next;
		p.next = tmp.next;
		tmp = null;
		return head;
	}

	public static void main(String[] a) {
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		removeNthFromEnd(h, 1);
	}
}
