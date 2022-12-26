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
    public boolean isBalanced(TreeNode root) {
        int lHeight = 0;
        int rHeight = 0;
        
        if (root == null) return true;
        lHeight = height(root.left);
        rHeight = height(root.right);
        return Math.abs(lHeight - rHeight) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }
    
    int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Integer.max(height(root.left), height(root.right));
    }
}