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
    Stack<Integer> ancestors = new Stack<>();
    public int maxAncestorDiff(TreeNode root) {
        ancestors.push(root.val);
        int max = -1;
        max = dfs(root.right, max);
        max = dfs(root.left, max);
        return max; 
    }
    
    
    public int dfs(TreeNode node, int currentMax) {
        if (node == null) return currentMax;
        
        Iterator ancestorIt = ancestors.iterator();
        while (ancestorIt.hasNext()) {
            int val = (int)ancestorIt.next();
            int tmp = Math.abs(val - node.val);
            currentMax = Math.max(tmp, currentMax);
        }
        ancestors.add(node.val);
        currentMax = Math.max(dfs(node.right, currentMax), currentMax);
        currentMax = Math.max(dfs(node.left, currentMax), currentMax);
        ancestors.pop();
        return currentMax;
    }
}

