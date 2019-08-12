package com.dailyinterviewprojava.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author ema
 * Given a sorted array, A, with possibly duplicated elements, find the indices of the first and last occurrences of a target element, x. Return -1 if the target is not found.
 *
 * Example:
 * Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
 * Output: [6,8]
 *
 * Input: A = [100,150,150,153], target = 150
 * Output: [1,2]
 *
 * Input: A = [1,2,3,4,5,6,10], target = 9
 * Output: [-1, -1]
 *
 */
public class FirstAndLastIndices {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int target = scanner.nextInt();
		
		// Array
		input = input.replace("[", "");
		input = input.replace("]", "");
		String[] inputArr = input.split(",");
		int[] nums = new int[inputArr.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(inputArr[i]);
		}
		
		// Print output
		System.out.println(Arrays.toString(getRange(nums, target)));
		
		scanner.close();
	}
	
	static int[] getRange(int[] nums, int target) {
		int[] result = new int[2];
		
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				index.add(i);
			}
		}
		if (index.size() > 1) {
			result[0] = index.get(0);
			result[1] = index.get(index.size() - 1);
		} else if (index.size() == 1) {
			result[0] = index.get(0);
			result[1] = index.get(0);
		} else {
			result[0] = -1;
			result[1] = -1;
		}
		
		return result;
	}

}
