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
    public boolean isValidBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        dfs(root, sorted);
        for(int i = 0; i < sorted.size() - 1; i++) {
            int a = sorted.get(i);
            int b = sorted.get(i+1);
            if (a >= b) return false;
        }
        return true;
    }
    
    void dfs(TreeNode root, List<Integer> sorted) {
        if (root == null) return ;
        dfs(root.left, sorted);
        sorted.add(root.val);
        dfs(root.right, sorted);
        
    }
}