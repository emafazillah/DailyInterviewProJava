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

	static String palindromicString(String s, int midPoint, int i, int endLeft, int endRight, boolean isOdd) {
		String left = "";
		String right = "";
		
		if (midPoint - i >= 0 && endRight <= s.length()) {
			left = s.substring(midPoint - i, endLeft);
			right = s.substring(midPoint + 1, endRight);
		}
		
		boolean isPalindromic = true;
		
		for (int j = 0; j < left.length(); j++) {
			if (left.charAt(j) != right.charAt(left.length() - 1 - j)) {
				isPalindromic = false;
				break;
			}
		}
		
		if (isPalindromic) {
			if (isOdd) {
				return left + s.charAt(midPoint) + right;
			} else {
				return left + right;
			}
		}
		
		return "";
	}

	static String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		} else {
			String longestPalindromicString = "";
			
			for (int midPoint = 0; midPoint < s.length(); midPoint++) {
				for (int i = 0; i <= midPoint; i++) {
					if (palindromicString(s, midPoint, i, midPoint, midPoint + 1 + i, true) .length() > longestPalindromicString.length()) {
						longestPalindromicString = palindromicString(s, midPoint, i, midPoint, midPoint + 1 + i, true);
					}
					
					if (palindromicString(s, midPoint, i, midPoint + 1, midPoint + 2 + i, false).length() > longestPalindromicString.length()) {
						longestPalindromicString = palindromicString(s, midPoint, i, midPoint + 1, midPoint + 2 + i, false);
					}
				}
			}
			
			return longestPalindromicString;			
		}
	}	
}
