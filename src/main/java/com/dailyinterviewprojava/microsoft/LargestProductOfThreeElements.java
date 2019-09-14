package com.dailyinterviewprojava.microsoft;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * You are given an array of integers. Return the largest product that can be made by multiplying any 3 integers in the array.
 * 
 * Example:
 * 
 * [-4, -4, 2, 8] should return 128 as the largest product can be made by multiplying -4 * -4 * 8 = 128.
 *
 */
public class LargestProductOfThreeElements {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(maximumProductOfThree(nums));
		
		scanner.close();
	}
	
	static int maximumProductOfThree(int[] nums) {
        if (nums.length <= 3) {
        	int maxProd = 0;
        	
        	for (int i = 0; i < nums.length; i++) {
        		if (i == 0) {
        			maxProd = nums[i];
        		} else {
        			maxProd *= nums[i];
        		}
        	}
        	
        	return maxProd;
        } else {
        	Arrays.sort(nums);
        	return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }
	
}
