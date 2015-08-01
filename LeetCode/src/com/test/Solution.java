package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
//		ListNode node = new ListNode(1);
//		node.next = new ListNode(3); 
//		node.next.next = new ListNode(24);
//		node.next.next.next = new ListNode(58);
//		ListNode node2 = new ListNode(2);
//		node2.next = new ListNode(4);
//		Merge(node, node2);
		int[] a = {5,4,3,2,1};
		System.out.println(VerifySquenceOfBST(a));
		Scanner scan = new Scanner(System.in);
		int result = scan.nextInt();
		System.out.println(result);
	}
	
	public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 1)
        	return true;
        int start = 0, end = sequence.length - 1;
        return isPost(sequence, start, end);
    }
	
	private static boolean isPost(int[] sequence, int start, int end) {
		if(start >= end)
			return true;
		int compare = sequence[end];
		int mid1 = start, mid2 = end - 1;
		while(mid1 < end && sequence[mid1] < compare ){
			mid1 ++;
		}
		while(mid2 >= start && sequence[mid2] > compare){
			mid2 --;
		}
		if(mid1 - mid2 == 1){
			return isPost(sequence, start, mid2) && isPost(sequence, mid1, end - 1);
		}
		return false;
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = (TreeNode)queue.poll();
            list.add(node.val);
            if(node != null && node.left != null)
                queue.offer(node.left);
            if(node != null && node.right != null)
                queue.offer(node.right);
        }
        return list;
    }
	
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
	        if(pushA == null || popA == null || pushA.length != popA.length)
	            return false;
	        int length = popA.length;
	        int sPush = 0, sPop = 0;
	        Stack stack = new Stack();
	        while(sPop < length){
	            while(stack.isEmpty() || ((int)stack.peek()) != popA[sPop]){
	                if(sPush < length){
	                    stack.push(pushA[sPush ++]);
	                }
	                else
	                    break;
	            }
	            if(((int)stack.peek()) != popA[sPop])
	                break;
	            stack.pop();
	            sPop ++;
	        }
	        if(stack.isEmpty() && sPop == length)
	            return true;
	        return false;
	    }
	
	private Stack stack = new Stack();
    private Stack minStack = new Stack();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            minStack.push((int)minStack.peek() < node ? minStack.peek() : node);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty() && ! minStack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty() && ! minStack.isEmpty()){
            return (int) minStack.peek();
        }
        return (int) minStack.peek();
    }
    
    public int min() {
        return (int) minStack.peek();
    }
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }
        while(list1 != null){
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        while(list2 != null){
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        return result.next;
    }
	public static ListNode ReverseList(ListNode head) {
		if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode last = curr.next;
        pre.next = null;
        while (curr != null){
        	curr.next = pre;
        	pre = curr;
            curr = last;
            if(last == null)
                break;
            last = last.next;
        }
        return pre;
    }
	public double Power(double base, int exponent) {
        if(base == 0.0 || exponent == 0)
            return 0.0;
        double result;
        if(exponent < 0){
			long expon = (long) exponent;
            result = PowerWithUnsined(base, -expon);
			result = 1.0 / result;
        }else{
            result = PowerWithUnsined(base, (long)exponent);
        }
        return result;
    }
    private double PowerWithUnsined(double base, long exponent){
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = PowerWithUnsined(base, exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1)
            result *= base;
        return result;
    }
	public static String reserveInt(int s){
		String result = "";
		List<Integer> list = new ArrayList<Integer>(); 
		reverse(list, s);
		for(int i = 0; i < list.size(); i ++){
			result += String.valueOf(Math.abs(list.get(i)));
		}
		if(s < 0){
			result += "-";
		}
		return result;
	}

	private static void reverse(List<Integer> list, int s) {
		int r = s % 10;
		list.add(new Integer(r));
		if(s / 10 == 0)
			return ;
		else{
			reverse(list, s / 10);
		}
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
        if(listNode == null)
            return result;
        ListNode node = listNode;
        while(node != null){
            result.add(0,node.val);
            node = node.next;
        }
        for(int i = 0; i < result.size(); i ++)
            System.out.println(result.get(i));
        return result;
    }
	private static  class ListNode {
		        int val;
		       ListNode next = null;
		
		        ListNode(int val) {
		           this.val = val;
		        }
		    }
}
