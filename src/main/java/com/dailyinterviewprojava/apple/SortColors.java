package com.dailyinterviewprojava.apple;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library’s sort function for this problem.
 * 
 * Can you do this in a single pass?
 * 
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 */
public class SortColors {
	
private static boolean isSorted;
	
	static void sortColors(int[] nums) {
		if (nums.length <= 1) {
			System.out.println(Arrays.toString(nums));
		}
		
		isSorted = false;
		
		while(!isSorted) {
			nums = sortList(nums);
		}
		
		System.out.println(Arrays.toString(nums));
    }
	
	static int[] sortList(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) {
				int temp = list[i + 1];
				list[i + 1] = list[i];
				list[i] = temp;
				return list;
			}
		}
		
		isSorted = true;
		
		return list;
	}	
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Output
		sortColors(nums);
		
		scanner.close();
	}

}
