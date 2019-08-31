package com.dailyinterviewprojava.twitter;

import java.util.Stack;

/**
 * 
 * @author ema
 * Implement a class for a stack that supports all the regular functions (push, pop) and 
 * an additional function of max() which returns the maximum element in the stack (return None if the stack is empty). 
 * Each method should run in constant time.
 *
 */
public class MaximumInAStack {
	public static void main(String...strings) {
		MaxStack maxStack = new MaxStack();
		maxStack.push(1);
		maxStack.push(2);
		maxStack.push(3);
		maxStack.push(2);
		System.out.println("get max: " + maxStack.getMax());
		maxStack.pop();
		maxStack.pop();
		System.out.println("get max: " + maxStack.getMax());
	}
}

class MaxStack {
	
	Stack<Integer> stack = new Stack<>();
	
	Stack<Integer> maximumInAStack = new Stack<>();

    /** initialize your data structure here. */
    public MaxStack() {
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	
    	// Update maximumInAStack
    	if(maximumInAStack.isEmpty()) {
			maximumInAStack.push(x);
		} else {
			int count = stack.size() - 1;
	    	while(count > -1) {
	    		if(maximumInAStack.peek() < stack.get(count)) {
	        		maximumInAStack.pop();
	        		maximumInAStack.push(stack.get(count));
	        	}
	    		
	    		--count;
	    	}
		}
    }
    
    public void pop() {
    	if(stack.isEmpty()) {
    		throw new RuntimeException("Stack is empty.");
    	}
    	
    	stack.pop();
    	maximumInAStack.pop();
        
        // Update maximumInAStack
        if(!stack.isEmpty()) {
        	int count = stack.size() - 1;
        	while(count > -1) {
        		if(!maximumInAStack.isEmpty()) {
        			if(maximumInAStack.peek() < stack.get(count)) {
    	        		maximumInAStack.pop();
    	        		maximumInAStack.push(stack.get(count));
    	        	}
        		} else {
        			maximumInAStack.push(stack.get(count));
        		}
        		
        		--count;
        	}
        }
    }
    
    public int top() {
    	if(stack.isEmpty()) {
    		throw new RuntimeException("Stack is empty.");
    	}
    	
        return stack.peek();
    }
    
    public int getMax() {
    	return maximumInAStack.peek();
    }
    
}
