public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) return res;
        List<Integer> ans = new ArrayList<Integer>();
        helper(res, ans, s, 0);
        return res;
    }
    private void helper(List<String> res, List<Integer> ans, String s, int start) {
        if (ans.size() > 4) return;
        
        if (s.length() == start && ans.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(ans.get(i));
                if (i < 3) {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
            return;
        }
        
        if (start >= s.length()) return;
        
        int i = start;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int onedigit = Integer.valueOf(s.substring(i, i + 1));
                ans.add(onedigit);
                helper(res, ans, s, start + 1);
                ans.remove(ans.size() - 1);
            }
            if (i + 1 < s.length() && s.charAt(i) > '0' && s.charAt(i) <= '9') {
                int twodigits = Integer.valueOf(s.substring(i, i + 2));
                ans.add(twodigits);
                helper(res, ans, s, start + 2);
                ans.remove(ans.size() - 1);
            }
            
            if (i + 2 < s.length() && s.charAt(i) != '0' && Integer.valueOf(s.substring(i, i + 3)) >= 100 && Integer.valueOf(s.substring(i, i + 3)) <= 255) {
                int threedigits = Integer.valueOf(s.substring(i, i + 3));
                ans.add(threedigits);
                helper(res, ans, s, start + 3);
                ans.remove(ans.size() - 1);
            }

        
    }
}