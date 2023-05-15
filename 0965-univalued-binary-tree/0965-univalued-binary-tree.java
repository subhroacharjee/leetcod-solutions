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
    int no = -1;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (this.no == -1) this.no = root.val;
        if (this.no == root.val) return true && isUnivalTree(root.right) && isUnivalTree(root.left);
        else return false;
    }
}