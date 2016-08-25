/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        sb.append("[" + root.val);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                sb.append("," + curr.left.val);
                queue.offer(curr.left);
            }
            else {
                sb.append(",null");
            }
            if (curr.right != null) {
                sb.append("," + curr.right.val);
                queue.offer(curr.right);
            }
            else {
                sb.append(",null");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 3) return null;
        String realdata = data.substring(1, data.length() - 1);
        String[] strArr = realdata.split(",");
        if (realdata.length() == 0 || realdata.equals("") || strArr == null || strArr.length == 0) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
        if (strArr.length == 1) return root;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            curr.left = strArr[i].equals("null") ?  null : new TreeNode(Integer.valueOf(strArr[i]));
            i++;
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            
            curr.right = strArr[i].equals("null") ?  null : new TreeNode(Integer.valueOf(strArr[i]));
            
            i++;
            if (curr.right != null) {
                queue.offer(curr.right);
            }            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));