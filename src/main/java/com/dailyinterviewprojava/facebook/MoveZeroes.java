package com.dailyinterviewprojava.facebook;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
public class MoveZeroes {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Output
		moveZeroes(nums);
		
		scanner.close();
	}
	
	public static void moveZeroes(int[] nums) {
		int length = nums.length;
		int i = 0;
		int index = 0;
		int trailingZeroIndex = length - 1; // Initiate trailing zero index
		boolean isAllZeroes = false;
		
		while(i < length) {
			// Check if not equals '0' then update index 'i'
			if(nums[i] == 0) {
				if(i >= trailingZeroIndex) {
					++i;
				} else {
					// Update current trailing zero index
					while((nums[trailingZeroIndex - index] == 0) && (trailingZeroIndex - index > 0)) {
						if(trailingZeroIndex - index > 0) {
							++index;
						} else {
							// The whole array are zeroes
							isAllZeroes = true;
							break;
						}
					}
					if(isAllZeroes) {
						break;
					}
					trailingZeroIndex -= index;
					
					// Loop until '0' reaching trailing zero index
					int j = i;
					while(j < trailingZeroIndex) {
						int temp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = temp;
						++j;
					}
				}
			} else {
				++i;
			}
		}
		
		// Print output
		System.out.println(Arrays.toString(nums));
    }

}
