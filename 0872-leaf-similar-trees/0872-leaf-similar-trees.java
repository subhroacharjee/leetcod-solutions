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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1).equals(dfs(root2));
    }
    
    public String dfs(TreeNode root) {
        if ( root == null) return "";
        if (root.right == null && root.left == null) return root.val + "_";
        
        return dfs(root.left) + dfs(root.right);
    }
}