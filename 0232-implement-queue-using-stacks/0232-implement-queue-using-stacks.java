class MyQueue {
    Stack<Integer> stackTop;
    Stack<Integer> stackBottom;
    public MyQueue() {
        stackTop = new Stack<Integer>();
        stackBottom = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (stackTop.isEmpty()) {
            stackTop.push(x);
        } else {
            stackBottom.push(x);
        }
    }
    
    public int pop() {
        int ans = stackTop.pop();
        if (stackTop.isEmpty()) {
            while(!stackBottom.isEmpty()) {
                stackTop.push(stackBottom.pop());
            }
        }
        return ans;
    }
    
    public int peek() {
        return stackTop.peek();
    }
    
    public boolean empty() {
        return stackTop.isEmpty() && stackBottom.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */