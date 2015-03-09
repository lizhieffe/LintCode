package Finished;

import java.util.Stack;

public class ImplementingQueueByStack {

	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementingQueueByStack() {
        // in stack
        stack1 = new Stack<Integer>();
        
        // out stack
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (stack2.size() == 0)
            migrate();
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (stack2.size() == 0)
            migrate();
        return stack2.peek();
    }
    
    private void migrate() {
        while (stack1.size() > 0)
            stack2.push(stack1.pop());
    }
}
