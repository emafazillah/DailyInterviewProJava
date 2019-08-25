package com.dailyinterviewprojava.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given a list of numbers, where every number shows up twice except for one number, find that one number.
 * 
 * Example:
 * Input: [4,3,2,4,1,3,2]
 * Output: 1
 * 
 * Challenge: Find a way to do this using O(1) memory.
 *
 */
public class FindTheNonDuplicateNumber {
	
	public static void main(String...strings) {
		// Input into array
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		String[] inputs = InputUtil.inputArr(input);
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(singleNumber(nums));
		
		scanner.close();
	}
	
	static int singleNumber(int[] nums) {
		// Count duplicate
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				map.put(nums[i], 1);
			} else {
				if (map.containsKey(nums[i])) {
					int val = map.get(nums[i]);
					map.put(nums[i], ++val);
				} else {
					map.put(nums[i], 1);
				}
			}
		}
		
		// Get non-duplicate
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return 0;
	}

}
