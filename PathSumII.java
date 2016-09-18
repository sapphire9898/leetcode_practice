/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        helper(res, new ArrayList<Integer>(list), root.left, sum);
        helper(res, new ArrayList<Integer>(list), root.right, sum);
        
       

    }
}