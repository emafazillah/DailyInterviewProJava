package com.dailyinterviewprojava.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * You are given an array of intervals - that is, an array of tuples (start, end). The array may not be sorted, and could contain overlapping intervals. 
 * Return another array where the overlapping intervals are merged.
 * 
 * For example:
 * [(1, 3), (5, 8), (4, 10), (20, 25)]
 * 
 * This input should return [(1, 3), (4, 10), (20, 25)] since (5, 8) and (4, 10) can be merged into (4, 10).
 * 
 */
public class MergeOverlappingIntervals {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		input = input.substring(1, input.length());
		input = input.substring(0, input.length() - 1);
		List<String[]> list = new ArrayList<>();
		int i = 0;
		while (i < input.length()) {
			int start = i;
			while (!"]".equals(Character.toString(input.charAt(i)))) {
				++i;
			}
			++i;
			int end = i;
			String inner = input.substring(start, end);
			inner = inner.replace("[", "");
			inner = inner.replace("]", "");
			String[] arr = inner.split(",");
			list.add(arr);
			++i;
		}
		
		// Input into intervals
		int[][] intervals = new int[list.size()][2];
		for (int j = 0; j < intervals.length; j++) {
			String[] arr = list.get(j);
			intervals[j] = InputUtil.integerArr(arr);
		}
		
		// Print output
		int[][] result = merge(intervals);
		for (int idx = 0; idx < result.length; idx++) {
			int[] arr = result[idx];
			System.out.println(Arrays.toString(arr));
		}
		
		scanner.close(); 
	}
	
	static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		
		// Sort intervals
		List<Interval> intervalsList = new ArrayList<>();
		for (int[] arr : intervals) {
			intervalsList.add(new Interval(arr[0], arr[1]));
		}
		
		Collections.sort(intervalsList, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		int readIdx = 1;
        int writeIdx = 0;
        while (readIdx < intervalsList.size()) {
            Interval current = intervalsList.get(writeIdx);
            Interval next = intervalsList.get(readIdx);
            if (current.end >= next.start) {
                if (next.end > current.end) { 
                    current.end = next.end;
                }
            } else {
                writeIdx++;
                current = intervalsList.get(writeIdx);
                current.start = next.start;
                current.end = next.end;
            }
            
            readIdx++;
        }
        
        // Merge intervals
        int[][] mergedIntervals = new int[writeIdx + 1][2];
        for(int i = 0; i <= writeIdx; i++){
            mergedIntervals[i][0] = intervalsList.get(i).start;
            mergedIntervals[i][1] = intervalsList.get(i).end;
        }
        
        return mergedIntervals;
    }

}

class Interval {
	int start;
	int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
