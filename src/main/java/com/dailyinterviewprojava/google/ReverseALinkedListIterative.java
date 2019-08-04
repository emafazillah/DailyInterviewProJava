package com.dailyinterviewprojava.google;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author ema
 * Reverse a Linked List
 * 
 * Given a singly-linked list, reverse the list. This can be done iteratively or recursively. Can you get both solutions?
 * 
 * Example:
 * Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL
 * Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL
 *
 */
public class ReverseALinkedListIterative {
	
	public static void main(String...strings) {
		// Input to linked list
		Scanner scanner = new Scanner(System.in);
		String inputs = scanner.next();
		inputs = inputs.replace("[", "");
		inputs = inputs.replace("]", "");
		String[] inputArray = inputs.split(",");
		ListNode node = null;
		
//		for(String input : inputArray) {
//			if(!"null".equals(input)) {
//				node = insertListNode(node, Integer.parseInt(input));
//			}
//		}
		
		int count = inputArray.length - 1;
		while(count > -1) {			
			if(!"null".equals(inputArray[count])) {
				ListNode temp = node;
				node = new ListNode(Integer.parseInt(inputArray[count]));
				node.next = temp;
			}
			--count;
		}
		
		// Reverse linked list
		node = reverseList(node);
		
		scanner.close();
	}
	
	static ListNode insertListNode(ListNode listNode, int value) {
		if(listNode == null) {
			listNode = new ListNode(value);
		} else {
			ListNode temp = listNode;
			listNode = new ListNode(value);
			listNode.next = temp;
		}
		
		return listNode;
	}
	
	static ListNode reverseList(ListNode listNode) {
		Stack<ListNode> stack = new Stack<ListNode>();
		
		while(listNode != null) {
			ListNode temp = listNode;
			stack.push(listNode);
			listNode = temp.next;
		}
		
		while(!stack.isEmpty()) {
			if(listNode == null) {
				listNode = new ListNode(stack.peek().val);
			} else {
				ListNode temp = listNode;
				listNode = new ListNode(stack.peek().val);
				listNode.next = temp;
			}
			stack.pop();
		}
		
		return listNode;
	}

}

class ListNode {
	int val;
    ListNode next;
    
    ListNode(int x) { 
    	val = x; 
    }
}
