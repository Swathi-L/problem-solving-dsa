// 1. Use the built-in stack
// 2. To find min element in O(1), push the min val in stack along with the value

class MinStack {

    Stack<int[]> stack;
    // int min;
    
    public MinStack() {
        // Integer[0] -> val; Integer[1] -> minimum
        stack = new Stack<>();
        // min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        int minGlobal = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];
        int min = Math.min(minGlobal, val);
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
        stack.pop();
        // if(!stack.isEmpty()) {
        //     min = stack.peek()[1];
        // } else {
        //     min = Integer.MAX_VALUE;
        // }
    }
    
    public int top() {
       return stack.peek()[0]; 
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */