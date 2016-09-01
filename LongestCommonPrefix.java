public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        else if (strs.length == 1) {
            return strs[0];
        }
        
        StringBuilder newstring = new StringBuilder();
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return newstring.toString();
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return newstring.toString();
                }
                
            }
            newstring.append(c);
        }
        return newstring.toString();
    }
}