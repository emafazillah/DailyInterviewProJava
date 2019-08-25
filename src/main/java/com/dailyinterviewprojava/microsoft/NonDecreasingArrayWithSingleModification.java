package com.dailyinterviewprojava.microsoft;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * You are given an array of integers in an arbitrary order. Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example:
 *
 * [13,4,7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.
 *
 * [13,4,1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.
 * 
 * Can you find a solution in O(n) time?
 *
 */
public class NonDecreasingArrayWithSingleModification {
	
	public static void main(String...strings) {
		// Input to array
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] lst = InputUtil.integerArr(inputs);
		for (int i = 0; i < inputs.length; i++) {
			lst[i] = Integer.parseInt(inputs[i]);
		}
		
		// Print output
		System.out.println(check(lst));
		
		scanner.close();
	}
	
	static boolean check(int[] nums) {
		if(nums.length <= 1) {
			return true;
		} else {
			int countModified = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i == 0) {
					if(nums[i] > nums[i + 1]) {
						if(countModified > 0) {
							return false;
						} else {
							nums[i] = nums[i + 1];
							++countModified;
						}
					}
				} else if(i == nums.length - 1) {
					if(nums[i - 1] > nums[i]) {
						if(countModified > 0) {
							return false;
						} else {
							nums[i - 1] = nums[i];
							++countModified;
						}
					}
				} else {
					if(nums[i] > nums[i + 1]) {
						if(countModified > 0) {
							return false;
						} else {
							if(nums[i - 1] > nums[i + 1]) {
								nums[i + 1] = nums[i];
							} else {
								nums[i] = nums[i - 1];
							}
							++countModified;
						}
					}
				}
            }
            
            return true;
		}
	}

}
