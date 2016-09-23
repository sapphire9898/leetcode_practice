public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        int ans = 1;
        for (int n : nums) {
            int left = n - 1;
            int right = n + 1;
            int count = 1;
            
            while (set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }
            while (set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }
            
            ans = Math.max(ans, count);
            
        }
        return ans;
        
    }
}