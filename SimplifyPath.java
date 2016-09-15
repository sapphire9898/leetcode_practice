public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        
        //".." means going to last level
        // "." means THIS dir path.
        
        HashSet<String> skip = new HashSet<String>(Arrays.asList("", ".", ".."));
        
        for (String str : path.split("/")) {
            if (str.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(str)) stack.push(str);
        }
        
        StringBuilder sb = new StringBuilder();
       
        while (!stack.isEmpty()) {
            String str = stack.pop();
            sb.insert(0, "/" + str);
        }
        
        
        if (sb == null || sb.length() == 0) return "/";
        return sb.toString();
       
        
    }
}