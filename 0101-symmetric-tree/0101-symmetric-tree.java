/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
       
        return dfs(root.left).equals(dfs2(root.right));
    }
    
    String dfs(TreeNode root) {
        if (root == null) return "_";
        return root.val + dfs(root.left) + dfs(root.right);
    }
    
    String dfs2(TreeNode root) {
        if (root == null) return "_";
        return root.val + dfs2(root.right) + dfs2(root.left);
    }
}