public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() <= 10) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            int curr = code(s.substring(i, i + 10));
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
                if (map.get(curr) == 2) {
                    res.add(s.substring(i, i + 10));
                }
            }
            else {
                map.put(curr, 1);
            }
        }
        return res;
    }
    
    private int code(String s) {
        // s is string with len 10;
        // A 00, C 01, G 11, T 10;
        // for example, ACGT --> 00011110 , for len 10, each could be represented by 20-bit. an integer is enough. 
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 3);
        map.put('T', 2);
        int sum = 0;
        
        for (int i = 9; i >= 0; i--) {
            char c = s.charAt(i);
            sum |= map.get(c) << (i * 2);
        }
        return sum;
    }
}