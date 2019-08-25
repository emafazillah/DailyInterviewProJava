package com.dailyinterviewprojava.google;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.ListNode;

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
public class ReverseALinkedList {
	
	public static void main(String...strings) {
		// Input to linked list
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		String[] inputs = InputUtil.inputArr(input);		
		ListNode listNode = null;
		for (int i = 0; i < inputs.length; i++) {
			listNode = insertListNode(listNode, Integer.parseInt(inputs[i]));
		}
		
		// Reverse linked list
		listNode = reverseList(listNode);
		
		// Print output
		int[] output = new int[inputs.length];
		int i = 0;
		while (listNode != null) {
			output[i] = listNode.val;
			listNode = listNode.next;
			++i;
		}
		System.out.println(Arrays.toString(output));
		
		scanner.close();
	}
	
	static ListNode insertListNode(ListNode listNode, int value) {
		if(listNode == null) {
			listNode = new ListNode(value);
		} else {
			listNode.next = insertListNode(listNode.next, value);
		}
		
		return listNode;
	}
	
	static ListNode reverseList(ListNode listNode) {
		if (listNode == null) {
			return null;
		}
		
		ListNode reverseListNode = new ListNode(listNode.val);
		while (listNode.next != null) {
			ListNode temp = reverseListNode;
			reverseListNode = new ListNode(listNode.next.val);
			reverseListNode.next = temp;
			listNode = listNode.next;
		}
		
		return reverseListNode;
	}

}
