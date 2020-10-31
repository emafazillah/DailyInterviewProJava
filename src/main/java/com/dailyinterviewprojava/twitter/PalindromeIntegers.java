package com.dailyinterviewprojava.twitter;

import java.util.Scanner;

/**
 * 
 * @author ema
 * Given an integer, check if that integer is a palindrome. For this problem do not convert the integer to a string to check if it is a palindrome.
 * 
 */
public class PalindromeIntegers {
    public static boolean isPalindrome(int x) {
        int temp = x;
		int reverse = 0;
		
		while(temp > 0) {
			int remainder = temp % 10;
			reverse = reverse * 10 + remainder;
			temp = temp / 10;
		}
		
		if (x == reverse) {
			return true;
		} else {
			return false;
		}
    }
    
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		boolean output = isPalindrome(input);
		System.out.println(output);
		
		scanner.close();
	}
}
