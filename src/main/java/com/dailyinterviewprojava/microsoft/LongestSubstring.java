package com.dailyinterviewprojava.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author ema
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Can you find a solution in linear time?
 *
 */
public class LongestSubstring {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		char[] arr = input.toCharArray();
		
		// Count substring without repeating characters and store as 'list'
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while(i < arr.length) {
			if(map.containsKey(arr[i])) {				
				// update list
				Integer count = 0;
				for(Map.Entry<Character, Integer> entry : map.entrySet()) {
					count += entry.getValue();
				}
				list.add(count);
				
				// reset map
				map.clear();
			} else {
				// update map
				map.put(arr[i], 1);
				
				++i;
			}
		}
		
		// Sort 'list' to get longest substring without repeating characters
		Collections.sort(list);
		
		// Print result
		System.out.println(list.get(list.size() - 1));
		
		scanner.close();
	}

}