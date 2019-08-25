package com.dailyinterviewprojava.google;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
 *
 * Example 1:
 * Input: [3,3,2,1,3,2,1]
 * Output: [1,1,2,2,3,3,3]
 * 
 * Challenge: Try sorting the list using constant space.
 *
 */
public class SortingAListWith3UniqueNumbers {
	
	public static void main(String...strings) {
		// Input into array
		Scanner scanner = new Scanner(System.in);		
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(inputs[i]);
		}
		
		// Print output
		System.out.println(Arrays.toString(sortNums(nums)));
		
		scanner.close();
	}
	
	static int[] sortNums(int[] nums) {
		int sorted = 0;
		while(sorted < nums.length) {
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					sorted = 0;
					break;
				} else {
					++sorted;
				}
			}
		}
		return nums;
	}

}
