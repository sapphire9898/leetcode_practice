public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        
        int sign = 1;
        boolean mulprev = false;
        boolean divprev = false;
        
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (divprev) {
                    // begin division stack.pop() / curr and then put it in the stack;
                    //update divprev
                    stack.push(stack.pop() / sum);
                    divprev = false;
                    
                }
                else if (mulprev) {
                    // begin mulplication stack.pop() / curr and then put it in the stack;
                    //update mulprev
                    stack.push(stack.pop() * sum);
                    mulprev = false;
                }
                
                else {
                    stack.push(sum * sign);
                }
                
            }
            else if (c == '+') {
                sign = 1;
            }
            else if (c == '-') {
                sign = -1;
            }
            else if (c == '*') {
                mulprev = true;
                sign = 1;
            }
            else if (c == '/') {
                divprev = true;
                sign = 1;
            }
        }
        int result = 0;
        
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;  
    }
}