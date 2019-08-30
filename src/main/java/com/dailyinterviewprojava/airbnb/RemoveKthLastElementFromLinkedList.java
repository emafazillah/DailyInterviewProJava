package com.dailyinterviewprojava.airbnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.ListNode;

/**
 * 
 * @author ema
 * You are given a singly linked list and an integer k. Return the linked list, removing the k-th last element from the list.
 *
 * Try to do it in a single pass and using constant space.
 *
 */
public class RemoveKthLastElementFromLinkedList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int n = scanner.nextInt();
		ListNode listNode = null;
		for (String input : inputs) {
			listNode = insertListNode(listNode, Integer.parseInt(input));
		}
		
		// Remove kth from end
		listNode = removeKthFromEnd(listNode, n);
		while (listNode != null) {
			System.out.print(listNode.val + " >> ");
			listNode = listNode.next;
		}
		System.out.print("null");
		
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
	
	static ListNode removeKthFromEnd(ListNode head, int n) {
		// Save List Node as Collection
        List<Integer> list = new ArrayList<Integer>();
        while(head != null) {
        	list.add(head.val);
        	head = head.next;
        }
		
		// Remove kth from end
        list.remove(list.size() - n);
        
        // Save updated Collection as List Node
        for (int i = 0; i < list.size(); i++) {
        	head = insertListNode(head, list.get(i));
        }
        
		return head;
    }

}
