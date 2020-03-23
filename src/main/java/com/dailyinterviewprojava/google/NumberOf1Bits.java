package com.dailyinterviewprojava.google;

import java.util.Scanner;

/**
 * 
 * @author ema
 * Given an integer, find the number of 1 bits it has.
 * 
 */
public class NumberOf1Bits {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseUnsignedInt(scanner.next(), 2);
		
		System.out.println(hammingWeight(n));
		
		scanner.close();
	}
	
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) { 
    	int weight = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) 
				weight++;
		}
		return weight;
    }

}
