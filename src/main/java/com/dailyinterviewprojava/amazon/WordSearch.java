package com.dailyinterviewprojava.amazon;

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
 * You are given a 2D array of characters, and a target string. Return whether or not the word target word exists in the matrix. 
 * Unlike a standard word search, the word must be either going left-to-right, or top-to-bottom in the matrix.
 *
 * Example:
 *
 * [['F', 'A', 'C', 'I'],
 * ['O', 'B', 'Q', 'P'],
 * ['A', 'N', 'O', 'B'],
 * ['M', 'A', 'S', 'S']]
 *
 * Given this matrix, and the target word FOAM, you should return true, as it can be found going up-to-down in the first column.
 *
 */
public class WordSearch {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		List<String> inputs = new ArrayList<>();
		while (scanner.hasNext()) {
			String input = scanner.next();
			if ("exit".equals(input)) {
				break;
			}
			inputs.add(input);
		}
		
		// Input into 2D-array
		Map<Integer, List<String>> map = new HashMap<>(); 
		for (int i = 0; i < inputs.size(); i++) {
			String[] inputArr = InputUtil.inputArr(inputs.get(i));
			map.put(i, Arrays.asList(inputArr));
		}
		
		char[][] board = new char[map.size()][map.get(0).size()];
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++) {
				board[i][j] = map.get(i).get(j).charAt(0);
			}
		}
		
		// Print output
		System.out.println(exist(board, word));
		
		scanner.close();
	}

	static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
        	return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // DFS for backtracking
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                	return true;
                }
            }
        }
        
        return false;
    }
	
	static boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (word.length() == index){
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[i][j];
        
        // marking it as visited using space char so that it won't be visited again
        board[i][j] = ' ';

        boolean found = dfs(board, word, index + 1, i - 1, j) ||  
        		dfs(board, word, index + 1, i + 1, j) ||  
        		dfs(board, word, index + 1, i, j - 1) || 
        		dfs(board, word, index + 1, i, j + 1);

        // we need to put the board back to the previous state
        board[i][j] = temp;
        
        return found;
    }
	
}
