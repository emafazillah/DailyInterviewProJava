package com.dailyinterviewprojava.microsoft;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.ListNode;

/**
 * 
 * @author ema
 * You are given two linked-lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbersAsALinkedList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		
		String[] inputs1 = InputUtil.inputArr(scanner.next());
		ListNode listNode1 = null;
		for (String input1 : inputs1) {
			listNode1 = insertListNode(listNode1, Integer.parseInt(input1));
		}
		
		String[] inputs2 = InputUtil.inputArr(scanner.next());
		ListNode listNode2 = null;
		for (String input2 : inputs2) {
			listNode2 = insertListNode(listNode2, Integer.parseInt(input2));
		}
		
		// Add two linked list
		ListNode result = addTwoNumbers(listNode1, listNode2);
		
		// Print output by reverse result Linked List
		ListNode reverseResult = new ListNode(result.val);
		while (result.next != null) {
			ListNode temp = reverseResult;
			reverseResult = new ListNode(result.next.val);
			reverseResult.next = temp;
			result = result.next;
		}
		
		while (reverseResult != null) {
			System.out.print(reverseResult.val);
			reverseResult = reverseResult.next;
		}
		
		scanner.close();
	}
	
	static ListNode insertListNode(ListNode listNode, int val) {
		if (listNode == null) {
			listNode = new ListNode(val);
		} else {
			listNode.next = insertListNode(listNode.next, val);
		}
		
		return listNode;
	}
	
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		int sum = 0;
		while (l1 != null || l2 != null) {
			int x = 0;
			if (l1 != null) {
				x = l1.val;
			}
			
			int y = 0;
			if (l2 != null) {
				y = l2.val;
			}
			
			sum += x + y;
			
			if (sum >= 10) {
				result = insertListNode(result, sum - 10);
				sum = 1;
			} else {
				result = insertListNode(result, sum);
				sum = 0;
			}
			
			if (l1 != null) {
				l1 = l1.next;
			}
			
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		
		if (sum > 0) {
			result = insertListNode(result, sum);
		}
		
		return result;
    }

}
