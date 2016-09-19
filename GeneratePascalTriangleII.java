public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex == 0) {
            res.add(1);
            return res;
        }
        res.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 0; j < res.size() - 1; j++) {
                curr.add(res.get(j) + res.get(j + 1));
            }
            curr.add(1);
            res = curr;
        }
        return res;
    }
}