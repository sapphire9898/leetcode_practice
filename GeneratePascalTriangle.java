public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);
        if (numRows == 1) return res;
        
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                curr.add(list.get(j) + list.get(j + 1));
            }
            curr.add(1);
            res.add(curr);
            list = curr;
        }
        return res;
    }
}