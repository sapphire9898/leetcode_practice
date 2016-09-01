public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                switch (c) {
                    case ']' : 
                        if (stack.isEmpty() || stack.pop() != '[') return false;
                        break;
                    case '}' :
                        if (stack.isEmpty() || stack.pop() != '{') return false;
                        break;
                    case ')' :
                        if (stack.isEmpty() || stack.pop() != '(') return false;
                        break;
                    default:
                        break;
                }
            }
            else return false;
        }
        return stack.isEmpty();
    }
}