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
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                    
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    //input the curr;
                    if (pre != null && pre.val > curr.val) {
                        if (first == null) {
                            first = pre;
                            second = curr;
                        }
                        else {
                            second = curr;
                        }
                    }
                    
                    pre = curr;
                    curr = curr.right;
                }
 
            }
            else {
                //input the curr,
                if (pre != null && pre.val > curr.val) {
                        if (first == null) {
                            first = pre;
                            second = curr;
                        }
                        else {
                            second = curr;
                        }
                    }
                pre = curr;
                curr = curr.right;
                
            }
        }
        
        
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        
    }
    
    
    
}