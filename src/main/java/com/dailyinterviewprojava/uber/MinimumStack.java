package com.dailyinterviewprojava.uber;

import java.util.Stack;

/**
 * 
 * @author ema
 * Design a simple stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Note: be sure that pop() and top() handle being called on an empty stack.
 * 
 */
public class MinimumStack {
	public static void main(String...strings) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println("get min: " + minStack.getMin());
		minStack.pop();
		System.out.println("get top: " + minStack.top());
		System.out.println("get min: " + minStack.getMin());
	}
}

class MinStack {
	
	Stack<Integer> stack = new Stack<>();
	
	Stack<Integer> minimumStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	
    	// Update minimumStack
    	if(minimumStack.isEmpty()) {
			minimumStack.push(x);
		} else {
			int count = stack.size() - 1;
	    	while(count > -1) {
	    		if(minimumStack.peek() > stack.get(count)) {
	        		minimumStack.pop();
	        		minimumStack.push(stack.get(count));
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
    	minimumStack.pop();
        
        // Update minimumStack
        if(!stack.isEmpty()) {
        	int count = stack.size() - 1;
        	while(count > -1) {
        		if(!minimumStack.isEmpty()) {
        			if(minimumStack.peek() > stack.get(count)) {
    	        		minimumStack.pop();
    	        		minimumStack.push(stack.get(count));
    	        	}
        		} else {
        			minimumStack.push(stack.get(count));
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
    
    public int getMin() {
    	return minimumStack.peek();
    }
    
}
