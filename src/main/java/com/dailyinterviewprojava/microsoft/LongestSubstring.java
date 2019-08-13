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
		
		// Print result
		System.out.println(lengthOfLongestSubstring(input));
		
		scanner.close();
	}
	
	static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		} else {
			// Count substring without repeating characters and store as 'list'
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			List<Integer> list = new ArrayList<Integer>();
			Integer count = 0;
			
			// i = start index of substring
			for (int i = 0; i < s.length(); i++) {
				String substr = s.substring(i, s.length());
				char[] chars = substr.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					if (map.containsKey(chars[j])) {
						// update list
						list.add(count);
						
						// reset map and count
						map.clear();
						count = 0;
						
						break;
					} else {
						map.put(chars[j], 1);
						++count;
					}
				}
			}
			
			if (count > 0) {
				list.add(count);
			}
			
			// Sort 'list' to get longest substring without repeating characters
			Collections.sort(list);
			
			return list.get(list.size() - 1);
		}
	}

}