public class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> data;
    private Stack<Integer> mindata;
    public MinStack() {
        data = new Stack<Integer>();
        mindata = new Stack<Integer>();
    }
    
    public void push(int x) {
        data.push(x);
        if (mindata.isEmpty()) mindata.push(x);
        else {
            mindata.push(Math.min(mindata.peek(), x));
        }
    }
    
    public void pop() {
        data.pop();
        mindata.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return mindata.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */