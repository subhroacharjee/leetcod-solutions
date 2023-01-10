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
    public boolean isSubtree(TreeNode s, TreeNode t) {
 		if(s != null && t != null){
 			return same(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
 		}else if(s == null && t == null) return true;
 		return false;
 	}
 	private boolean same(TreeNode s, TreeNode t){
 		if(s == null && t == null) return true;
 		else if((s == null && t != null) || (s != null && t == null)) return false;
 		else{
 			if(s.val != t.val) return false;
 			return same(s.left, t.left) && same(s.right, t.right);
 		}
 	}
}