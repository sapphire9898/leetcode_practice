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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, k);
        return res.get(k - 1);
    }
    
    
    
    private void helper(TreeNode root, List<Integer> list, int k) { 
        // preorder visit. 
        if (root == null) return;
        if (list.size() == k) return;
        
        helper(root.left, list, k);
        list.add(root.val);
        helper(root.right, list, k);
        
        
        
    }
}


public class Solution {
    
    private int counter;
    private TreeNode temp;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            throw new java.lang.NullPointerException();
        };
        helper(root,k);
        return temp.val;
    }
    
    public void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left,k);
        counter++;
        if (counter == k) {
            temp = root;
            return;
        }
        if (counter < k) helper(root.right,k);
    }
}