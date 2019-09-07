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
			listNode = listNode.next;
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
	
	static ListNode removeZeroSumSublists(ListNode head) {
		Map<Integer, ListNode> map = new HashMap<>();
        boolean isZeroSum = true; 
        
        while (isZeroSum) {
        	isZeroSum = false;
        	int sum = 0;
        	ListNode temp = head;
        	
        	while (temp != null) {
        		sum += temp.val;
        		
        		if (sum == 0) {
        			head = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		} else if (map.containsKey(sum)) {
        			map.get(sum).next = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		}
        		
        		map.put(sum, temp);
        		temp = temp.next;
        	}
        }
        
        return head;
    }
	
}
