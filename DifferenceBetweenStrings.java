public class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        
        for (char c : s.toCharArray()) {
            if (!map1.containsKey(c)) {
                map1.put(c, 1);
            }
            else {
                map1.put(c, map1.get(c) + 1);
            }
        }
        
        
        for (char c : t.toCharArray()) {
            if (!map2.containsKey(c)) {
                map2.put(c, 1);
            }
            else  map2.put(c, map2.get(c) + 1);
        }
        
        for (Character c : map2.keySet()) {
            if (!map1.containsKey(c)) return c;
            else if (map1.get(c) != map2.get(c)) return c;
        }
        return 'c';
        
    }
}