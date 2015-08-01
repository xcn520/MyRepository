package com.leetcode.q061;

public class Solution {
	public static ListNode rotateRight(ListNode head, int k) {
		if(k <= 0 || head == null || head.next == null)
            return head;
        ListNode p = head;
        int size = 0;
        while(p != null){
        	size ++;
        	p = p.next;
        }
        k = k % size;
        if(k == 0)
        	return head;
        p = head;
        ListNode q = head;
        for(int i = 0; i < k; i ++){
            q = q.next;
        }
        while(q.next != null){
            q = q.next;
            p = p.next;
        }
        ListNode nHead = p.next;
        p.next = null;
        q.next = head;
        return nHead;
    }
	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		rotateRight(n,2);
	}
}
