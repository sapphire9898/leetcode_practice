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
    private int maxvalue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxvalue;
    }
    
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int max = root.val;
        
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        int tempMax = Math.max(left, right) + root.val;
        maxvalue = Math.max(maxvalue, left + right + root.val);
        return tempMax;
        
    }
}