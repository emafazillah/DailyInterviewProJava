package com.dailyinterviewprojava.uber;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given a number of integers, combine them so it would create the largest number.
 * 
 * Example:
 * Input:  [17,7,2,45,72]
 * Output:  77245217
 * 
 */
public class MakeTheLargestNumber {
	
	public static void main (String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] nums = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Print output
		System.out.println(largestNumber(nums));
		
		scanner.close();
	}
	
	static String largestNumber(int[] nums) {
		String[] strings = Arrays.toString(nums).split("[\\[\\]]")[1].split(", ");
        
        int i = 0;
        while (i < strings.length - 1) {
        	char[] charsCurr = strings[i].toCharArray();
        	char[] charsNext = strings[i + 1].toCharArray();
        	if (charsCurr[0] == charsNext[0]) {
        		BigInteger no1 = new BigInteger(strings[i] + strings[i + 1]);
        		BigInteger no2 = new BigInteger(strings[i + 1] + strings[i]);
        		// no2 > no1 (-1: less, 0: equal, 1: greater)
        		if (no2.compareTo(no1) == 1) {
        			String temp = strings[i];
        			strings[i] = strings[i + 1];
        			strings[i + 1] = temp;
        			i = 0;
        		} else {
        			++i;
        		}
        	} else if (charsCurr[0] < charsNext[0]) {
        		String temp = strings[i];
    			strings[i] = strings[i + 1];
    			strings[i + 1] = temp;
    			i = 0;
        	} else {
        		++i;
        	}
        }
        
        String result = Arrays.toString(strings).replaceAll("[^0-9]", "");
        BigInteger bi = new BigInteger(result);
        if (bi.compareTo(new BigInteger("0")) == 1) {
        	return result;
        } else {
        	return "0";
        }
    }

}
