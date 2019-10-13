package com.dailyinterviewprojava.twitter;

import java.util.Scanner;

/**
 * 
 * @author ema
 * Given a Roman numeral, find the corresponding decimal value. Inputs will be between 1 and 3999.
 * 
 * Example:
 * Input: IX
 * Output: 9
 * 
 * Input: VII
 * Output: 7
 * 
 * Input: MCMIV
 * Output: 1904
 * Roman numerals are based on the following symbols:
 * I     1
 * IV    4
 * V     5
 * IX    9
 * X     10
 * XL    40
 * L     50
 * XC    90
 * C     100
 * CD    400
 * D     500
 * CM    900
 * M     1000
 * Numbers are strings of these symbols in descending order. In some cases, subtractive notation is used to avoid repeated characters. The rules are as follows:
 * 1) I placed before V or X is one less, so 4 = IV (one less than 5), and 9 is IX (one less than 10)
 * 2) X placed before L or C indicates ten less, so 40 is XL (10 less than 50) and 90 is XC (10 less than 100).
 * 3) C placed before D or M indicates 100 less, so 400 is CD (100 less than 500), and 900 is CM (100 less than 1000).
 *
 */
public class ConvertRomanNumeralsToDecimal {

	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		int output = romanToInt(input);
		System.out.println(output);
		
		scanner.close();
	}
	
	private static int romanToInt(String s) {
		char[] charArr = s.toCharArray();
		int result = conversion(Character.toString(charArr[0]));
		int i = 1;
		while(i < charArr.length) {
			String before = Character.toString(charArr[i - 1]);
			String current = Character.toString(charArr[i]);
			if(before.equals("I") && current.equals("V")) {
				result = result - conversion(before) + 4;
			} else if(before.equals("I") && current.equals("X")) {
				result = result - conversion(before) + 9;
			} else if(before.equals("X") && current.equals("L")) {
				result = result - conversion(before) + 40;
			} else if(before.equals("X") && current.equals("C")) {
				result = result - conversion(before) + 90;
			} else if(before.equals("C") && current.equals("D")) {
				result = result - conversion(before) + 400;
			} else if(before.equals("C") && current.equals("M")) {
				result = result - conversion(before) + 900;
			} else {
				result += conversion(current);
			}
			
			++i;
		}
		
		return result;
    }
	
	private static int conversion(String s) {
		switch(s) {
			case "V":
				return 5;
			case "X":
				return 10;
			case "L":
				return 50;
			case "C":
				return 100;
			case "D":
				return 500;
			case "M":
				return 1000;
			default:
				return 1;
		}
	}
	
}
