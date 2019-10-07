package com.dailyinterviewprojava.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.TreeNode;

/**
 * 
 * @author ema
 * You are given the preorder and inorder traversals of a binary tree in the form of arrays. 
 * Write a function that reconstructs the tree represented by these traversals.
 * 
 * Example:
 * Preorder: [a, b, d, e, c, f, g]
 * Inorder: [d, b, e, a, f, c, g]
 * 
 * The tree that should be constructed from these traversals is:
 * 
 *     a
 *    / \
 *   b   c
 *  / \ / \
 * d  e f  g
 *
 */
public class ReconstrunctBinaryTreeFromPreorderAndInorderTraversals {
	
	static int pre;
	
	static TreeNode buildTree(int[] preorder, int[] inorder) {
	    Map<Integer,Integer> map = new HashMap<>();
	    for (int i = 0; i < inorder.length; i++) {
	    	map.put(inorder[i], i);
	    }
	    
	    return tree(0, inorder.length-1, preorder, map);
	}
	
	static TreeNode tree(int start, int end, int[] preorder, Map<Integer,Integer> map){
	    if (start > end) {
	    	return null;
	    }
	    
	    TreeNode root = new TreeNode(preorder[pre]);
	    
	    int r = pre;
	    
	    pre++;
	    
	    root.left = tree(start, map.get(preorder[r]) - 1, preorder,map);
	    
	    root.right = tree(map.get(preorder[r]) + 1, end, preorder, map);
	    
	    return root;
	}
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] preorder = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		int[] inorder = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Print output
		TreeNode result = buildTree(preorder, inorder);
		
		scanner.close();
	}

}
