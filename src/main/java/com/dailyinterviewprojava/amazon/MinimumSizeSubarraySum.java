package com.dailyinterviewprojava.amazon;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 */
public class MinimumSizeSubarraySum {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		String[] inputs = InputUtil.inputArr(input);
		int[] nums = InputUtil.integerArr(inputs);
		int s = scanner.nextInt();
		
		// Print output
		System.out.println(minSubArrayLen(s, nums));
		
		scanner.close();
	}
	
	static int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else {
			// Key = count of contiguous subarray
	        int key = 0;
	        
	        for (int i = 0; i < nums.length - 1; i++) {
	        	int count = 1;
	        	int sum = nums[i];
	        	
	        	int j = i + 1;
	        	while (j < nums.length && sum < s) {
	        		sum += nums[j];
	        		++count;
	        		++j;
	        	}
	        	
	        	// Update key
	        	if (count >= 1 && sum >= s) {
	        		if (key == 0 || key > count) {
	        			key = count;
	        		}
	        	}
	        }
	        
	        return key;
		}
    }

}
