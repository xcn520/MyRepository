package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BTreeDepth {

	public static int getDepth(TreeNode node){
		if(node == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		int depth = 0;
		while(queue.size() > 0){
			int size = queue.size();
			depth ++;
			while(size > 0){
				TreeNode tNode = queue.poll();
				if(tNode.left != null)
					queue.offer(tNode.left);
				if(tNode.right != null)
					queue.offer(tNode.right);
				size --;
			}
		}
		return depth;
	}
	public static int getDepth2(TreeNode node){
		if(node == null)
			return 0;
		Queue<Map<Integer, TreeNode>> queue = new LinkedList<Map<Integer, TreeNode>>();
		Map m0 = new HashMap();
		int depth = 1;
		m0.put(depth, node);
		queue.offer(m0);
		int result = 0;
		while(queue.size() > 0){
			Map m1 = queue.poll();
			if(m1 != null && m1.get(depth) != null){
				TreeNode n1 = (TreeNode) m1.get(depth);
				depth ++;
				if(n1.left != null){
					result = result > depth ? result : depth;
					Map m2 = new HashMap();
					m2.put(depth, n1.left);
					queue.offer(m2);
				}
				if(n1.right != null){
					result = result > depth ? result : depth;
					Map m2 = new HashMap();
					m2.put(depth, n1.right);
					queue.offer(m2);
				}
			}else if(m1 != null && m1.get(depth + 1) != null){
				TreeNode n1 = (TreeNode) m1.get(depth + 1);
				depth += 2;
				if(n1.left != null){
					result = result > depth ? result : depth;
					Map m2 = new HashMap();
					m2.put(depth, n1.left);
					queue.offer(m2);
				}
				if(n1.right != null){
					result = result > depth ? result : depth;
					Map m2 = new HashMap();
					m2.put(depth, n1.right);
					queue.offer(m2);
				}
			}
			depth --;
		}
		return result;
	}
	public static int getDepth3(TreeNode node){
		if(node == null)
			return 0;
		Stack stack = new Stack<TreeNode>();
		Stack depth = new Stack<Integer>();
		stack.push(node);
		depth.push(1);
		int result = 1;
		while(!stack.isEmpty()){
			TreeNode tree = (TreeNode) stack.pop();
			int d = (int) depth.pop();
			if(tree.left != null){
				stack.push(tree.left);
				depth.push(d + 1);
			}
			if(tree.right != null){
				stack.push(tree.right);
				depth.push(d + 1);
			}
			result = result > d ? result : d;
		}
		return result;
	}
	public static void main(String[] args){
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		t0.left = t1;
		t0.right = t2;
//		t1.left = t3;
//		t3.right = t4;
//		t2.right = t5;
//		t5.left = t6;
//		t6.left=t7;
//		t7.left = t8;
		int res = getDepth3(t0);
		System.out.println(res);
	}
}
