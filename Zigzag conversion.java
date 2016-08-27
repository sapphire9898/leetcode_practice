public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        
        int u = 2 * (numRows - 1);
        
        // the first row. 
        for (int i = 0; i * u < s.length(); i++) {
            sb.append(s.charAt(i * u));
        }
        
        // the middle rows. 
        for (int j = 1; j < u / 2; j++) {
            for (int i = 0; i * u + j < s.length(); i++) {
                    sb.append(s.charAt(i * u + j));
                    if (i * u + u - j < s.length()) {
                        sb.append(s.charAt(i * u + u - j));
                    }
             }
        }
        // the last row. 
        for (int i = 0; i * u + u / 2 < s.length(); i++) {
            sb.append(s.charAt(i * u + u / 2));
        }
        return sb.toString();
    }
}

// the beautiful solution with the same idea
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder sb = new StringBuilder();
        
        int u = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += u) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && (j + u - 2 * i) < s.length()) {
                    sb.append(s.charAt(j + u - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}

