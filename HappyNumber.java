public class Solution {
    public boolean isHappy(int n) {
        // use hashtable to store whether this is a happy number ? 
        // try while loop;
        if (n < 1) return false;
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            int sum = 0, curr = n;
            
            while (curr > 0) {
                sum += (curr % 10) * (curr % 10);
                curr /= 10;
            }
            n = sum;
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
}