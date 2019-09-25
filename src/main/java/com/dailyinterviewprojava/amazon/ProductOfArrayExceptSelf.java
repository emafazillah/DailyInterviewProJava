package com.dailyinterviewprojava.amazon;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * You are given an array of integers. Return an array of the same size where the element at each index is 
 * the product of all the elements in the original array except for the element at that index.
 * 
 * For example, an input of [1, 2, 3, 4, 5] should return [120, 60, 40, 30, 24].
 * 
 * You cannot use division in this problem.
 *
 */
public class ProductOfArrayExceptSelf {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(Arrays.toString(productExceptSelf(nums)));
		
		scanner.close();
	}
	
	static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
        	return nums;
        }
        
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
        	left[i] = nums[i - 1] * left[i - 1];
        }
        
        int[] right = new int[nums.length];
        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
        	right[i] = nums[i + 1] * right[i + 1];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
        	result[i] = left[i] * right[i];
        }
        
        return result;
    }

}
