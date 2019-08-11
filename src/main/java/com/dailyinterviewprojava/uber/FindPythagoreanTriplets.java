package com.dailyinterviewprojava.uber;

import java.util.Scanner;

/**
 * 
 * @author ema
 * Given a list of numbers, find if there exists a pythagorean triplet in that list. A pythagorean triplet is 3 variables a, b, c where a^2 + b^2 = c^2
 *
 * Example:
 * Input: [3,5,12,5,13]
 * Output: True
 * Here, 5^2 + 12^2 = 13^2.
 *
 */
public class FindPythagoreanTriplets {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		input = input.replace("[", "");
		input = input.replace("]", "");
		String[] inputArr = input.split(",");
		
		// Input to array
		int[] nums = new int[inputArr.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(inputArr[i]);
		}
		
		// Print output
		System.out.print(findPythagoreanTriplets(nums));
		
		scanner.close();
	}
	
	static boolean findPythagoreanTriplets(int[] nums) {
		for (int a = 0; a < nums.length; a++) {
			for (int b = 0; b < nums.length; b++) {
				if (a != b) {
					for (int c = 0; c < nums.length; c++) {
						if (c != a && c != b) {
							if ((nums[a] * nums[a]) + (nums[b] * nums[b]) == (nums[c] * nums[c])) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}

}