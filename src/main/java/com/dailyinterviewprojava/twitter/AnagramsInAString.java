package com.dailyinterviewprojava.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author ema
 * Given 2 strings s and t, find and return all indexes in string s where t is an anagram.
 * 
 */
public class AnagramsInAString {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String p = scanner.next();
		
		List<Integer> result = findAnagrams(s, p);
		Integer[] output = result.toArray(new Integer[result.size()]);
		
		// Output
		System.out.println(Arrays.toString(output));
		
		scanner.close();
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		
		// Get sum of p
		char[] charsP = p.toCharArray();
		int pSum = 0;
		for(char charP : charsP) {
			pSum += Character.getNumericValue(charP);
		}
		Arrays.sort(charsP);
		
		for(int i = 0; i <= (s.length() - p.length()); i++) {
			// Get sum of substring S and compare with sum of p
			String subStringS = s.substring(i, i + p.length());
			char[] charsS = subStringS.toCharArray();
			int sSum = 0;
			for(char charS : charsS) {
				sSum += Character.getNumericValue(charS);
			}
			Arrays.sort(charsS);
			
			// Check for anagram
			String stringCharsS = Arrays.toString(charsS);
			String stringCharsP = Arrays.toString(charsP);
			if((pSum == sSum) && (stringCharsP.equals(stringCharsS))) {
				result.add(i);
			}
		}
		
		return result;
    }	
	
}
