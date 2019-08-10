package com.dailyinterviewprojava.uber;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author ema
 * Validate Balanced Parentheses
 *
 * Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings. 
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
 * An input string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 * - Note that an empty string is also considered valid.
 *
 * Example:
 * Input: "((()))"
 * Output: True
 *
 * Input: "[()]{}"
 * Output: True
 *
 * Input: "({[)]"
 * Output: False
 *
 */
public class ValidateBalancedParentheses 
{
    public static void main( String[] args )
    {
    	// Input to character array
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] characters = input.toCharArray();
        
        System.out.println(isValid(characters));
        
        scanner.close();
    }
    
    static boolean isValid(char[] characters) {
    	// Check if character length is even
    	if(characters.length % 2 != 0) {
    		return false;
    	}
    	
    	// Validate balanced parentheses
        Stack<Character> charStack = new Stack<Character>();
        for(char character : characters) {
        	switch(character) {
	        	case '{':
	        		charStack.push('}');
	        		break;
	        	case '[':
	        		charStack.push(']');
	        		break;
	        	case '(':
	        		charStack.push(')');
	        		break;
        		default:
        			if(charStack.empty() || character != charStack.peek()) {
        				return false;
        			}
        		charStack.pop();
        	}
        }
        
        return charStack.isEmpty();
    }
}
