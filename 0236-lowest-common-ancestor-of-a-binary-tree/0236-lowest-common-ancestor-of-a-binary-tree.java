/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listForP = findPath(root, p);
        List<TreeNode> listForQ = findPath(root, q);
        
        TreeNode prev = null;
        int idx = 0;
        while( idx < listForP.size() && idx < listForQ.size() && listForP.get(idx).val == listForQ.get(idx).val) {
            prev = listForP.get(idx);
            idx++;
        }
        
        return prev;
        
    }
    
    public List<TreeNode> findPath(TreeNode root, TreeNode source) {
        if (root == null) return null;
        if (root.val == source.val) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }
        
        List<TreeNode> tmp = findPath(root.left, source);
        if (tmp!=null) {
            tmp.add(0, root);
            return tmp;
        }
        tmp = findPath(root.right, source);
         if (tmp!=null) {
            tmp.add(0, root);
            return tmp;
        }
        return null;
    }
}