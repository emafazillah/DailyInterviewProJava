package com.dailyInterviewProJava.uber;

import java.util.Scanner;
import java.util.Stack;

/**
 * Hello world!
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
