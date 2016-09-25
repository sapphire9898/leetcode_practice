public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        
        String[] v2 = version2.split("[.]");
        
        //there are 12 characters with special meanings: the backslash \, the caret ^, the dollar sign $, the period or dot ., the vertical bar or pipe symbol |, the question mark ?, the asterisk or star *, the plus sign +, the opening parenthesis (, the closing parenthesis ), and the opening square bracket [, the opening curly brace {, These special characters are often called "metacharacters".
        
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            int a = Integer.valueOf(v1[i++]);
            int b = Integer.valueOf(v2[j++]);
            if (a < b) return -1;
            else if (a > b) return 1;
        }
        
        while (i < v1.length) {
            if (Integer.valueOf(v1[i++]) > 0) return 1;
        }
        while (j < v2.length) {
            if (Integer.valueOf(v2[j++]) > 0) return -1;
        }
        return 0;
    }
}