package com.dailyinterviewprojava.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dailyinterviewprojava.util.InputUtil;

/**
 * 
 * @author ema
 * Given a list of words, group the words that are anagrams of each other. (An anagram are words made up of the same letters).
 * 
 * Example:
 * 
 * Input: ['abc', 'bcd', 'cba', 'cbd', 'efg']
 * Output: [['abc', 'cba'], ['bcd', 'cbd'], ['efg']]
 *
 */
public class GroupWordsThatAreAnagrams {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] strs = InputUtil.inputArr(scanner.next());
		
		// Print output
		List<List<String>> result = groupAnagramWords(strs);
		for (List<String> list : result) {
			System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
		}
		
		scanner.close();
	}
	
	static String charsToStringBuffer(char[] arr) {
		Arrays.sort(arr);
		return new StringBuilder().append(arr).toString();
	}
	
	static List<List<String>> groupAnagramWords(String[] strs) {
        if (strs.length <= 1) {
        	List<String> list = Arrays.asList(strs);
        	List<List<String>> lists = new ArrayList<>();
        	lists.add(list);
        	return lists;
        }
        
        List<String> list = new ArrayList<>();
        String key = charsToStringBuffer(strs[0].toCharArray());
        
        // Insert first value into HashMap
        Map<String, List<String>> map = new HashMap<>();
        list.add(strs[0]);
        map.put(key, list);
        
        // Check for anagram and insert into HashMap
        for (int i = 1; i < strs.length; i++) {
        	key = charsToStringBuffer(strs[i].toCharArray());
        	
        	if (map.containsKey(key)) {
        		list = map.get(key);
        		list.add(strs[i]);
        	} else {
        		list = new ArrayList<>();
    			list.add(strs[i]);
    			map.put(key, list);
        	}
        } 
        
        // Insert into result list
        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        	lists.add(entry.getValue());
        }
        
        return lists;
    }

}
