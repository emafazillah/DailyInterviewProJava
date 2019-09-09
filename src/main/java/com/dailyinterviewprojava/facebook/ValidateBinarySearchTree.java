package com.dailyinterviewprojava.facebook;

import com.dailyinterviewprojava.util.TreeNode;

/**
 * 
 * @author ema
 * You are given the root of a binary search tree. Return true if it is a valid binary search tree, and false otherwise. 
 * Recall that a binary search tree has the property that all values in the left subtree are less than or equal to the root, 
 * and all values in the right subtree are greater than or equal to the root.
 * 
 */
public class ValidateBinarySearchTree {
	
	TreeNode previousNode;
	
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
		
		if (!isValidBST(root.left)) {
			return false;
		}
		
		if (previousNode == null || root.val > previousNode.val) {
			previousNode = root;
		} else {
			return false; 
		}
		
		if (!isValidBST(root.right)) {
			return false;
		}
		
		return true;
    }

}
