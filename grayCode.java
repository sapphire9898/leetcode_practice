public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        else if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }
        
        List<Integer> firsthalf = grayCode(n - 1);
        
        res.addAll(firsthalf);
        
        for (int i = firsthalf.size() - 1; i >= 0; i--) {
            res.add(firsthalf.get(i) + (1 << n - 1));
        }
        
        return res;
        
    }
}