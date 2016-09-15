public class Solution {
    public String getPermutation(int n, int k) {
        if (n < 1 || k < 1) return "";
        if (n == 1 && k == 1) return "1";

        k = k - 1;
        int nn_1 = 1;
        
        int cnt = n - 1;
        for (;cnt >= 1; cnt--) {
             nn_1 *= cnt;
        }
        if (k > nn_1 * n) return "";
        
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        
       for (int m = n; m >= 1; m--) {
            int a = k / nn_1;
            
            int curr = list.get(a);
            sb.append(curr);
            
            list.remove(a);
            k = k - a * nn_1;
            if (m != 1) {
                nn_1 /= (m - 1);
            }
        }
        
        return sb.toString();
    }
}