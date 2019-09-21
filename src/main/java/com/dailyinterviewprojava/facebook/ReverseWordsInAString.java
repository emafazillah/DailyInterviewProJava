package com.dailyinterviewprojava.facebook;

/**
 * 
 * @author ema
 * Given a string, you need to reverse the order of characters in each word within a sentence 
 * while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * Input: "The cat in the hat"
 * Output: "ehT tac ni eht tah"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 */
public class ReverseWordsInAString {
	
	public static void main(String...strings) {
		System.out.println(reverseString("The cat in the hat"));
	}
	
	static String reverseString(String s) {
		StringBuilder result = new StringBuilder();
		
		String[] arr = s.split(" ");
		for (String arrItem : arr) {
			int idx = arrItem.length() - 1;
			while (idx > -1) {
				result.append(arrItem.charAt(idx));
				--idx;
			}
			
			result.append(" ");
		}
		
		return result.toString();
    }

}
