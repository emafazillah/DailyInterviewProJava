package com.dailyinterviewprojava.google;

import java.util.Scanner;
import java.util.Stack;

public class ReverseALinkedList {
	
	public static void main(String...strings) {
		// Input to linked list
		Scanner scanner = new Scanner(System.in);
		String inputs = scanner.next();
		inputs = inputs.replace("[", "");
		inputs = inputs.replace("]", "");
		String[] inputArray = inputs.split(",");
		ListNode node = null;
		for(String input : inputArray) {
			if(!"null".equals(input)) {
				node = insertListNode(node, Integer.parseInt(input));
			}
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
		if(listNode == null) {
			return null;
		}
		
		Stack<ListNode> stack = new Stack<ListNode>();
		while(listNode != null) {
			ListNode temp = listNode;
			
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
