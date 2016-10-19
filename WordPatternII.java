public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if ((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)) return true;
        if ((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0)) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        return helper(pattern, 0, str, 0, map1, map2);
    }
    
    private boolean helper(String pattern, int pleft, String str, int sleft, Map<Character, String> map1, Map<String, Character> map2) {
        if (pleft >= pattern.length() && sleft >= str.length()) return true;
        if (pleft >= pattern.length() || sleft >= str.length()) return false;
        
        char c = pattern.charAt(pleft);
        if (!map1.containsKey(c)) {
            // helper any thing is okay. 
            for (int i = sleft + 1; i <= str.length(); i++) {
                String curr = str.substring(sleft, i);
                if (map2.containsKey(curr)) {
                    continue;
                }
                map2.put(curr, c);
                map1.put(c, curr);
                boolean result = helper(pattern, pleft + 1, str, i, map1, map2);
                map1.remove(c);
                map2.remove(curr);
                if (result) return true;
            }
        }
        else {
            // has already stored as c - curr, curr - c;
            String curr = map1.get(c);
            if (!map2.containsKey(curr) || map2.get(curr) != c) return false;
            
            if (sleft + curr.length() - 1 > str.length() - 1 || !str.substring(sleft, sleft + curr.length()).equals(curr)) {
                return false;
            }
            boolean result = helper(pattern, pleft + 1, str, sleft + curr.length(), map1, map2);
            if (result) return true;
        }
        return false;
    }
    
}