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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       Pair p = lca(root);
        return p.node;
    }
    
    public Pair lca(TreeNode root) {
        if (root == null) return new Pair(null, 0);
        Pair lt = lca(root.right);
        Pair rt = lca(root.left);
        
        if (rt.distance == lt.distance) return new Pair(root, rt.distance + 1);
        else if (rt.distance > lt.distance) {
            rt.distance ++;
            return rt;
        }
        else {
            lt.distance ++;
            return lt;
        }
        
    }
}

class Pair {
    public TreeNode node;
    public int distance;
    public Pair(TreeNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}