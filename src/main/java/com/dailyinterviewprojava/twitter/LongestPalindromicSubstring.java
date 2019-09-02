package com.dailyinterviewprojava.twitter;

import java.util.Scanner;

/**
 * 
 * @author ema
 * A palindrome is a sequence of characters that reads the same backwards and forwards. Given a string, s, find the longest palindromic substring in s.
 *
 * Example:
 * Input: "banana"
 * Output: "anana"
 *
 * Input: "million"
 * Output: "illi"
 *
 */
public class LongestPalindromicSubstring {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		// Print output
		System.out.println(longestPalindrome(input));
		
		scanner.close();
	}

	static String longestPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return s;
		} else {
			int start = 0;
			int end = 0;
			boolean[][] isPalindrome = new boolean[s.length()][s.length()];
			for (int j = 1; j < s.length(); j++) {
				for (int i = 0; i < j; i++) {
					if (s.charAt(i) == s.charAt(j) && (isPalindrome[i + 1][j - 1] || j - i <= 2)) {
						isPalindrome[i][j] = true;
						
						if (j - i > end - start) {
							start = i;
							end = j;
						}
					}
				}
			}
			
			return s.substring(start, end + 1);
		}
	}	
}
