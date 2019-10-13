package com.dailyinterviewprojava.amazon;

import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * The h-index is a metric that attempts to measure the productivity and citation impact of the publication of a scholar. 
 * The definition of the h-index is if a scholar has at least h of their papers cited h times.
 * 
 * Given a list of publications of the number of citations a scholar has, find their h-index.
 * 
 * Example:
 * Input: [3, 5, 0, 1, 3]
 * Output: 3
 * Explanation:
 * There are 3 publications with 3 or more citations, hence the h-index is 3.
 *
 */
public class HIndex {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] citations = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Output
		System.out.println(hIndex(citations));
		
		scanner.close();
	}
	
	static int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		
		Arrays.sort(citations);
		
		int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
        	if (citations[i] > count) {
        		++count;
        	}
        }
        
        return count;
    }

}
