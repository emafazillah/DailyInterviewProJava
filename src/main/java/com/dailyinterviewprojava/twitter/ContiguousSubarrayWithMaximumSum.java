package com.dailyinterviewprojava.twitter;

import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * You are given an array of integers. Find the maximum sum of all possible contiguous subarrays of the array.
 * 
 * Example:
 * 
 * [34, -50, 42, 14, -5, 86]
 * 
 * Given this input array, the output should be 137. The contiguous subarray with the largest sum is [42, 14, -5, 86].
 * 
 * Your solution should run in linear time.
 *
 */
public class ContiguousSubarrayWithMaximumSum {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(maxSubArraySum(nums));
		
		scanner.close(); 
	}
	
	static int maxSubArraySum(int[] nums) {
		int maxCount = nums[0];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
			
			if (count <= 0) {
				maxCount = Math.max(count, maxCount);
				count = 0;
				continue;
			}
			
			if (count > maxCount) {
				maxCount = count; 
			}
		}
        return maxCount;
    }

}
