package com.leetcode.q110;

public class Solution {
	    public boolean isBalanced(TreeNode root) {
	        setHeight(root);
	        return balanced(root);
	    }
	    public int setHeight(TreeNode root){
	        if(root == null)
	            return 0;
	        root.val = Math.max(setHeight(root.left),setHeight(root.right)) + 1;
	        return root.val;
	    }
	    public boolean balanced(TreeNode root){
	        if(root == null){
	            return true; 
	        }
	        int l = 0, r = 0;
	        if(root.left != null)l = root.left.val;
	        if(root.right != null)r = root.right.val;
	        if(Math.abs(l-r) <=1 && balanced(root.left) && balanced(root.right))return true;
	        return false;
	    }
}
