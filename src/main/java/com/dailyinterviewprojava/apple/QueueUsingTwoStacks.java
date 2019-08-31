package com.dailyinterviewprojava.apple;

import java.util.Stack;

/**
 * 
 * @author ema
 * Implement a queue class using two stacks. A queue is a data structure that supports the FIFO protocol 
 * (First in = first out). Your class should support the enqueue and dequeue methods like a standard queue.
 *
 */
public class QueueUsingTwoStacks {
	
	public static void main(String...strings) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println("peek: " + obj.peek());
	}
	
}

/**
 * Queue<Integer> queue = new LinkedList<>();
 * queue.poll(); // or queue.remove();
 * queue.peek();
 * queue.isEmpty();
 */

class MyQueue {
	
	Stack<Integer> stack = new Stack<Integer>();
	
	/** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(this.stack.isEmpty()) {
    		this.stack.push(x);
    	} else {
    		Stack<Integer> tempStack = new Stack<Integer>();
    		
    		tempStack.push(x);
            int size = this.stack.size();
            int count = 0;
            while(count < size) {
            	tempStack.push(this.stack.pop());
            	++count;
            }
    		
            // Update stack
            while(size > -1) {
            	this.stack.push(tempStack.pop());
            	--size;
            }
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.stack.isEmpty()) {
        	throw new RuntimeException("Stack is empty");
        }
        
        int value = this.stack.get(0);
        
        Stack<Integer> tempStack = new Stack<Integer>();
        int size = this.stack.size() - 1;
        while(size > 0) {
        	tempStack.push(this.stack.pop());
        	--size;
        }
        
        // Update stack
        this.stack = new Stack<Integer>();
        size = tempStack.size();
        while(size > 0) {
        	this.stack.push(tempStack.pop());
        	--size;
        }
        
        return value;
    }
    
    /** Get the front element. */
    public int peek() {
    	if(this.stack.isEmpty()) {
        	throw new RuntimeException("Stack is empty");
        }
    	
    	return this.stack.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.isEmpty();
    }
    
}

