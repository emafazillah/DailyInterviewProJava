package com.dailyinterviewprojava.twitter;

import java.util.Scanner;
import java.util.Stack;

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
		
		// Input into 'stack'
		char[] chars = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(char c : chars) {
			stack.add(c);
		}
		
		scanner.close();
	}

}
