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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length -1, nums);
    }
    
    public TreeNode dfs(int start, int end, int[] nums) {
        if (start > end) return null;
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(start, mid-1, nums);
        root.right = dfs(mid+1, end, nums);
        
        return root;
    }
}