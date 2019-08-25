package com.dailyinterviewprojava.facebook;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given a list, find the k-th largest element in the list.
 * Input: list = [3, 5, 2, 4, 6, 8], k = 3
 * Output: 5
 *
 */
public class KthLargestElementInAList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int k = scanner.nextInt();
		
		// Print output
		System.out.println(findKthLargest(nums, k));
		
		scanner.close();
	}
	
	static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
    }

}
