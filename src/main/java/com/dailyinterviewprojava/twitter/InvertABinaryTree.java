package com.dailyinterviewprojava.twitter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.TreeNode;

/**
 * 
 * @author ema
 * You are given the root of a binary tree. Invert the binary tree in place. 
 * That is, all left children should become right children, and all right children should become left children.
 *
 * Example:
 *
 *     a
 *    / \
 *   b   c
 *  / \  /
 * d   e f
 *
 * The inverted version of this tree is as follows:
 *
 *   a
 *  / \
 * c   b
 *  \ / \
 *  f e  d
 *
 */
public class InvertABinaryTree {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		Scanner scanner = new Scanner(System.in);
		String[] inputArr = InputUtil.inputArr(scanner.next());
		TreeNode root = null;
		for(String input : inputArr) {
			root = insertTreeNode(root, Integer.parseInt(input));
		}
		
		// Invert tree
		root = invertTree(root);
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode root, int input) {
		if(root == null) {
			root = new TreeNode(input);
		} else {
			if(input > root.val) {
				root.right = insertTreeNode(root.right, input);
			} else {
				root.left = insertTreeNode(root.left, input);
			}
		}
		
		return root;
	}
	
	static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    
	    while(!queue.isEmpty()) {
	        TreeNode current = queue.poll();
	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null) queue.add(current.left);
	        if (current.right != null) queue.add(current.right);
	    }
	    
	    return root;
    }

}
