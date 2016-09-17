public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        
        if (heights == null || heights.length == 0) return res;
        
        // if the value is greater or equal than the stack[top], we push it, and increment i with 1;
        // if the value is smaller than stack[top], we calculate the area. 
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int p = stack.pop();
                int h = heights[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
        }
        
        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = heights[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            res = Math.max(res, h * w);
        }
        
        return res;
        
        
        
    }
}