package com.dailyinterviewprojava.util;

public class InputUtil {
	
	public static String[] inputArr(String input) {
		input = input.replace("[", "");
		input = input.replace("]", "");
		return input.split(",");
	}
	
	public static int[] integerArr(String[] inputArr) {
		int[] nums = new int[inputArr.length];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(inputArr[i]);
		}
		return nums;
	}

}
