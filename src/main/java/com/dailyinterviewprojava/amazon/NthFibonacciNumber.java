package com.dailyinterviewprojava.amazon;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * @author ema
 * The Fibonacci sequence is the integer sequence defined by the recurrence relation: F(n) = F(n-1) + F(n-2), where F(0) = 0 and F(1) = 1. In other words, the nth Fibonacci number is the sum of the prior two Fibonacci numbers. Below are the first few values of the sequence:
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 * 
 * Given a number n, print the n-th Fibonacci Number.
 * Examples:
 * Input: n = 3
 * Output: 2
 * 
 * Input: n = 7
 * Output: 13
 *
 */
public class NthFibonacciNumber {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(fib(scanner.nextInt()));
		scanner.close();
	}
	
	private static int fib(int n) {
		// Fibonacci, (Fn) = (Fn-1) + (Fn-2)
		BigInteger fn = new BigInteger("0");
		BigInteger fnminus1 = new BigInteger("0");
		BigInteger fnminus2 = new BigInteger("1");
		
		for(int i = 0; i < n; i++) {
			fn = fnminus1.add(fnminus2);
			fnminus2 = fnminus1;
			fnminus1 = fn;
		}
		
		return fn.intValue();
    }

}
