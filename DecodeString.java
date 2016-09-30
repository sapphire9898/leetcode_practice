public class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<Integer>();
        Stack<String> strs = new Stack<String>();
        

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int start = i;
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                nums.push(Integer.valueOf(s.substring(start, i + 1)));
            }
            else if (s.charAt(i) == '[') {
                strs.push("[");
            }
            else if (s.charAt(i) == ']') {
                // read out all the strings till '[', and read out the number , compose and then push it into the strs.
                String curr = "";
                while (!strs.isEmpty() && !strs.peek().equals("[")) {
                    curr = strs.pop() + curr;
                }
                
                if (strs.isEmpty()) return "";
                strs.pop();
                if (nums.isEmpty()) return "";
                int cnt = nums.pop();
                
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < cnt; k++) {
                    sb.append(curr);
                }
                strs.push(sb.toString());
                
            }
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                strs.push(s.substring(i, i + 1));
            }
        }
        
        String res = "";
        
        while (!strs.isEmpty()) {
            res = strs.pop() + res;
        } 
        return res;
    }
}