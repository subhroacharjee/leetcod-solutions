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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        
        q.add(root);
        while(!q.isEmpty()) {
            int tempSum = 0;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                tempSum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            
            sum = tempSum;
        }
        
        return sum;
    }
}