package com.test;

import java.util.Stack;


public class ReBuildTree {

	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre == null || in == null || pre.length != in.length)
            return null;
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length -1);
        return root;
	}

	private static TreeNode reConstructBinaryTree(int[] pre, int s1, int e1, int[] in,
			int s2, int e2) {
		if(s1 > e1 || s2 > e2)
			return null;
		TreeNode tree = new TreeNode(pre[s1]);
		int divider = findIndexInArray(in,pre[s1],s2,e2);  
        int offSet = divider-s2-1;  
        TreeNode left = reConstructBinaryTree(pre,s1+1,s1+1+offSet,in,s2,s2+offSet);
        TreeNode right = reConstructBinaryTree(pre,s1+offSet+2,e1,in,divider+1,e2);
        tree.left = left;
        tree.right = right;
        return tree;
	}

	private static int findIndexInArray(int[] in, int x, int begin, int end) {
		for(int i=begin;i<=end;i++){  
            if(in[i]==x)return i;  
        }  
        return -1;
	}

	public static void main(String[] args){
		int[] preOrder = {7,10,4,3,1,2,8,11};  
        int[] inOrder = {4,10,3,1,7,11,8,2};
        int[] a = {1,2,3,4,5,6,7};
        reOrderArray(a);
	}
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	stack1.push(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()){
            while(! stack1.isEmpty()){
            	stack1.push(stack2.pop());
            }
        }
    	if(!stack2.isEmpty())
    		return stack2.pop();
    	return 0;
    }
    
    
    public static int minNumberInRotateArray(int [] array) {
    	if(array == null || array.length <= 0)
        	return 0;
        int i = 0, j = array.length - 1;
        int mid = 0;
        while (array[i] >= array[j]){
            if(j - i == 1){
                mid = j;
                break;
            }
        	mid = (i + j) / 2;
        	if(array[i] == array[j] && array[i] == array[mid]){
        		return findSmallest(array, i, j);
        	}
        	else if(array[i] <= array[mid]){
        		i = mid;
        	}else if(array[mid] <= array[j]){
        		j = mid;
        	}
        }
        return array[mid];
    }

	private static int findSmallest(int[] array, int i, int j) {
		int result = Integer.MAX_VALUE;
		for(int k =i;k <=j; k++){
			result =  result > array[k]?array[k]:result;
		}
		return result;
	}

	public static void reOrderArray(int [] array) {
    	if(array == null || array.length <= 1)
            return;
        int i = 0, j = array.length -1;
        while(i < j){
            while(i < array.length && (array[i] & 1) == 1)
                i ++;
            while(j >= 0 && (array[j] & 1) == 0)
                j --;
            if(i < j){
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
    }
}
