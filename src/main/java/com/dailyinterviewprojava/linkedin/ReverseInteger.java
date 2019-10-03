package com.dailyinterviewprojava.linkedin;

import java.util.Scanner;

/**
 * 
 * @author ema
 * Write a function that reverses the digits a 32-bit signed integer, x. Assume that the environment can only store integers within the 32-bit signed integer range, [-2^31, 2^31 - 1]. The function returns 0 when the reversed integer overflows.
 * 
 * Example:
 * Input: 123
 * Output: 321
 *
 */
public class ReverseInteger {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		int output = reverse(input);
		System.out.println(output);
		
		scanner.close();
	}
	
	private static int reverse(int x) {
		try {
	        String input = Integer.toString(x);
	        
	        String output = "";
	        int count = -1;
			char[] charArr = input.toCharArray();
			int size = charArr.length - 1;
			if((Character.toString(charArr[0])).equals("-")) {
				output = "-";
				count = 0;
			}
			
			while(size > count) {
				output += Character.toString(charArr[size]);
				--size;
			}
			
			return Integer.valueOf(output);
		} catch(Exception e) {
			return 0;
		}
    }

}
