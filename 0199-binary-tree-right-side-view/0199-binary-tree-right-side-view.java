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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode node = null;
            int n = q.size();
            for (int i = 0; i< n; i++) {
                if (q.peek().left != null) q.add(q.peek().left);
                
                if (q.peek().right != null) q.add(q.peek().right);
                node = q.poll();
            }
            ans.add(node.val);
        }
        
        return ans;
    }
}