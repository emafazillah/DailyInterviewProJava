package com.dailyinterviewprojava.google;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * There are n people lined up, and each have a height represented as an integer. A murder has happened right in front of them, 
 * and only people who are taller than everyone in front of them are able to see what has happened. How many witnesses are there?
 * 
 * Example:
 * Input: [3, 6, 3, 4, 1]
 * Output: 3
 * Explanation: Only [6, 4, 1] were able to see in front of them.
 * #
 * #
 * # #
 * ####
 * ####
 * #####
 * 36341                                 x (murder scene)
 * 
 */
public class WitnessOfTheTallPeople {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);

		// Output
		System.out.print(countWitnesses(nums));

		scanner.close();
	}

	public static int countWitnesses(int[] nums) {
		int counter = 1;
		int n = nums.length;
		int maxHeight = nums[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] > maxHeight) {
				counter++;

				maxHeight = nums[i];
			}
		}

		return counter;
	}
}
