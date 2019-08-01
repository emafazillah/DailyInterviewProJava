package com.dailyinterviewprojava.google;

import java.util.Scanner;

public class ReverseALinkedList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String inputs = scanner.next();
		inputs = inputs.replace("[", "");
		inputs = inputs.replace("]", "");
		
		
		ListNode node = null;
		
		scanner.close();
	}
	
	
	static ListNode reverseList(ListNode listNode) {
		
		
		
		
		// TODO
		return null;
	}

}

class ListNode {
	int val;
    ListNode next;
    
    ListNode(int x) { 
    	val = x; 
    }
}
