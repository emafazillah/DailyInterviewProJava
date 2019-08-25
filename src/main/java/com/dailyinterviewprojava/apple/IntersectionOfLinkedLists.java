package com.dailyinterviewprojava.apple;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;
import com.dailyinterviewprojava.util.ListNode;

/**
 * 
 * @author ema
 * You are given two singly linked lists. The lists intersect at some node. Find, and return the node. Note: the lists are non-cyclical.
 *
 * Example:
 *
 * A = 1 -> 2 -> 3 -> 4
 * B = 6 -> 3 -> 4
 *
 */
public class IntersectionOfLinkedLists {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		ListNode headA = stringToListNode(scanner.next());		
		ListNode headB = stringToListNode(scanner.next());
		
		// Print output
		ListNode interSectinNode = getIntersectionNode(headA, headB);
		if (interSectinNode == null) {
			System.out.println("null");
		} else {
			while (interSectinNode != null) {
				System.out.print(interSectinNode.val + "->");
				interSectinNode = interSectinNode.next;
			}
			System.out.print("null");
		}
		
		scanner.close();
	}
	
	static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        StringBuilder headAStrBldr = listNodeToStringBuilder(headA);
        StringBuilder headBStrBldr = listNodeToStringBuilder(headB);
		
		ListNode intersection = null;
		for (int i = 0; i < headAStrBldr.toString().length(); i++) {
			for (int j = 1; j < headAStrBldr.toString().length(); j++) {
				// Left substring
				String leftSubstring = headAStrBldr.toString().substring(i, headAStrBldr.toString().length() - j);
				if (headBStrBldr.toString().contains(leftSubstring)) {
					// Insert into ListNode, intersection
					char[] chars = leftSubstring.toCharArray();
					for(char c : chars) {
						intersection = insertListNode(intersection, Integer.parseInt(Character.toString(c)));
					}
					return intersection;
				}
				
				// Right substring
				String rightSubstring = headAStrBldr.toString().substring(j - i, headAStrBldr.toString().length());
				if (headBStrBldr.toString().contains(rightSubstring)) {
					// Insert into ListNode, intersection
					char[] chars = rightSubstring.toCharArray();
					for(char c : chars) {
						intersection = insertListNode(intersection, Integer.parseInt(Character.toString(c)));
					}
					return intersection;
				}					
			}
		}
		
		return intersection;
    }
	
	static StringBuilder listNodeToStringBuilder(ListNode head) {
		StringBuilder sb = new StringBuilder();
        while (head != null) {
        	sb.append(head.val);
        	head = head.next;
        }
        return sb;
	}
	
	static ListNode stringToListNode(String input) {
		String[] list = InputUtil.inputArr(input);
		// Input into ListNode
		ListNode head = null;
		for (String s : list) {
			head = insertListNode(head, Integer.parseInt(s));
		}
		return head;
	}
	
	static ListNode insertListNode(ListNode listNode, int val) {
		if (listNode == null) {
			listNode = new ListNode(val);
		} else {
			listNode.next = insertListNode(listNode.next, val);
		}
		return listNode; 
	}

}
