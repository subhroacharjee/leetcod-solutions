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
    List<String> list = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return list;
        }
        addToPath(root, "");
        return list;
    }
    
    
    private void addToPath(TreeNode node, String s){
       
        if(node.left == null && node.right == null){
            list.add(s+node.val);
            return;
        }
        if(node.left == null){
            addToPath(node.right, ""+s+node.val+"->");
            return;
        }
       if(node.right == null){
            addToPath(node.left, ""+s+node.val+"->");
            return;
        }
         addToPath(node.left, ""+s+node.val+"->"); 
         addToPath(node.right, ""+s+node.val+"->");
    }
}