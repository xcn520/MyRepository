package com.leetcode.q082;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode nHead = head;
        ListNode p = head;
        ListNode pre = new ListNode(0);
        Map<Integer, Integer> set = new HashMap<Integer, Integer>();
        while(p != null){
            if(set.containsKey(p.val)){
                set.put(p.val,2);
                p = p.next;
                pre.next = p;
            }else{
                set.put(p.val,1);
                pre = p;
                p = p.next;
            }
        }
        while(nHead != null && set.containsKey(nHead.val) && set.get(nHead.val) == 2){
            nHead = nHead.next;
        }
        if(nHead == null || nHead.next == null)
            return nHead;
        p = nHead.next;
        pre = nHead;
        while(p != null){
            if(set.get(p.val) == 2){
                pre.next = p.next;
                p = p.next;
            }else{
                pre = p;
                p = p.next;
            }
        }
        return nHead;
    }
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(2);
		deleteDuplicates(l);		
	}
}
