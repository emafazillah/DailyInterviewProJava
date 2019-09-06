package com.dailyinterviewprojava.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.ListNode;

/**
 * 
 * @author ema
 * Given a linked list of integers, remove all consecutive nodes that sum up to 0.
 *
 * Example:
 * Input: 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
 * Output: 10
 *
 * The consecutive nodes 5 -> -3 -> -3 -> 1 sums up to 0 so that sequence should be removed. 
 * 4 -> -4 also sums up to 0 too so that sequence should also be removed.
 *
 */
public class RemoveConsecutiveNodesZeroSum {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		ListNode listNode = null;
		for (int i = 0; i < inputs.length; i++) {
			listNode = insertListNode(listNode, Integer.parseInt(inputs[i]));
		}
		
		// Remove zero sum sublists
		listNode = removeZeroSumSublists(listNode);
		
		// Print output
		while (listNode != null) {
			System.out.print(listNode.val + ",");
			listNode = listNode.next;
		}
		System.out.println();
		
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
	
	static ListNode removeZeroSumSublists(ListNode head) {
		// ListNode to array
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> mapRemove = new HashMap<>();
		int count = 0;
		while (head != null) {
			map.put(count, head.val);
			head = head.next;
			++count;
		}
		System.out.print("map===" + map.toString());
		System.out.println();
		
		// Remove zero sum sublist
		for (int i = 0; i < map.size(); i++) {
			boolean isBreak = false;
			int sum = 0;
			
			// Check left
			mapRemove = new HashMap<>();
			for (int left = 0; left <= i; left++) {
				mapRemove.put(left, map.get(left));
				sum += map.get(left);
				if (sum == 0) {
					System.out.print("sumLeft is zero===" + mapRemove.toString());
					System.out.println();
					isBreak = true;
					break;
				}
			}
			
			if (isBreak) break;
			
			// Check right
			sum = 0;
			mapRemove = new HashMap<>();
			for (int right = i; right >= 0; right--) {
				mapRemove.put(right, map.get(right));
				sum += map.get(right);
				if (sum == 0) {
					System.out.print("sumRight is zero===" + mapRemove.toString());
					System.out.println();
					isBreak = true;
					break;
				}
			}
			
			if (isBreak) break;
		}
		
		// Update head
		for (Map.Entry<Integer, Integer> entryRemove : mapRemove.entrySet()) {
			map.remove(entryRemove.getKey());
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			head = insertListNode(head, entry.getValue());
		}
		
		return head;
    }
	
}
