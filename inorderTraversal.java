//**************** The recursive version ******************************//
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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<Integer>();
        res.addAll(new ArrayList<Integer>(inorderTraversal(root.left)));
        res.add(root.val);
        res.addAll(new ArrayList<Integer>(inorderTraversal(root.right)));
        return res;
    }
}


//**************** The iterative version ******************************
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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        TreeNode curr = root;
        
        while (!stack.isEmpty() || curr != null) {
            
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            stack.pop();
            res.add(curr.val);
            curr = curr.right;
            
        }
        
        return res;
    }
}