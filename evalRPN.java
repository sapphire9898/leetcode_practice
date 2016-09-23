public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int a = stack.pop();
                
                int b = stack.pop();
                
                stack.push(compute(a, b, tokens[i]));
            }
            else { 
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
        
    }
    private int compute(int a, int b, String s) {
        switch(s) {
            case "+" : return a + b;
            case "-" : return b - a;
            case "*" : return a * b;
            case "/" : return b / a;
            default : break;
        }
        return -1;
    }
    
}