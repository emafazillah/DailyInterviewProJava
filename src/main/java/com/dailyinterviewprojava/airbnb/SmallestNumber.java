package com.dailyinterviewprojava.airbnb;
import java.util.Arrays;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given a sorted list of positive numbers, find the smallest positive number that cannot be a sum of any subset in the list.
 * 
 * Example:
 * Input: [1, 2, 3, 8, 9, 10]
 * Output: 7
 * Numbers 1 to 6 can all be summed by a subset of the list of numbers, but 7 cannot.
 * 
 */
public class SmallestNumber {
    int findSmallestNumber(int arr[], int n)  
        { 
            int res = 1; // Initialize result 
            for (int i = 0; i < n && arr[i] <= res; i++) 
                res = res + arr[i]; 

            return res; 
        } 

        public static void main(String[] args)  
        { 
            // Input
            Scanner scanner = new Scanner(System.in);
            String[] inputs = InputUtil.inputArr(scanner.next());
            int[] nums = InputUtil.integerArr(inputs);

            // Lenth of the array
            int n1 = nums.length; 

            // Printing Output
            SmallestNumber small = new SmallestNumber(); 
            System.out.println(small.findSmallestNumber(nums, n1));

            scanner.close();

        } 

}
