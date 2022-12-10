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
    long M = 1000000007;
    public int maxProduct(TreeNode root) {
        LongTree prefixTree = new LongTree();
        sumOfSubTree(root, prefixTree);
        long maxSum = prefixTree.val;
        return (int)(getMaxProduct(prefixTree, maxSum, -1) % M);
    }
    
    void sumOfSubTree(TreeNode root, LongTree node) {
        if (root == null) {
            return;
        }
        
        if (root.right != null) {
            node.right = new LongTree();
            sumOfSubTree(root.right, node.right);
            node.val = node.right.val;
        }
        if (root.left !=null) {
            node.left = new LongTree();
            sumOfSubTree(root.left, node.left);
            node.val += node.left.val;
        }
        
        node.val += root.val; 
    }
    
    long getMaxProduct(LongTree root, long maxSum, long max) {

        if (root.right == null && root.left == null) return Math.max(root.val, max);
        long prod = 1;
        if (root.right != null) {
            
            prod = (maxSum - root.right.val) * root.right.val;
            max = getMaxProduct(root.right, maxSum, Math.max(prod, max));
            
        }
        
        if (root.left != null) {
            prod = (maxSum - root.left.val) * root.left.val;
            max = getMaxProduct(root.left, maxSum, Math.max(prod, max));
        }
        
        return max;
        
    }
}

class LongTree {
    public long val;
    public LongTree left;
    public LongTree right;
    public LongTree() {
         val = 0;
     }
}