package com.dailyinterviewprojava.linkedin;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.ListNode;
import com.dailyinterviewprojava.util.TreeNode;

/**
 * 
 * @author ema
 * Given a sorted list of numbers, change it into a balanced binary search tree. You can assume there will be no duplicate numbers in the list.
 * 
 */
public class CreateABalancedBinarySearchTree {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] list = InputUtil.inputArr(scanner.next());
		ListNode head = null;
		for (String s : list) {
			head = insertListNode(head, Integer.parseInt(s));
		}
		
		// Create balance BST
		TreeNode root = createBalancedBST(head);
		
		scanner.close();
	}
	
	static ListNode insertListNode(ListNode head, int val) {
		if (head == null) {
			return new ListNode(val);
		} else {
			head.next = insertListNode(head.next, val);
			return head;
		}
	}
	
	static TreeNode createBalancedBST(ListNode head) {
		if (head == null) {
			return null;
		}
		
        // Get middle node
        ListNode middleNode = getMiddleNodeVal(head);
        
        TreeNode root = new TreeNode(middleNode.val);
        
        if (head == middleNode) {
        	return root;
        }
        
		// Build BST recursively
        root.left = createBalancedBST(head);
        root.right = createBalancedBST(middleNode.next);
		
		return root;
    }
	
	static ListNode getMiddleNodeVal(ListNode head) {
		ListNode prev = null;
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (prev != null) {
			prev.next = null;
		}
		
		return slow;
	}
	
}
