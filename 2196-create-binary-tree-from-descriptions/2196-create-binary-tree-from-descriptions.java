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
    public TreeNode createBinaryTree(int[][] desc) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < desc.length; i++) {
            int parent = desc[i][0];
            int child = desc[i][1];
            boolean isLeft = desc[i][2] == 1;
            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }
            
            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }
            
            if (isLeft) map.get(parent).left = map.get(child);
            else map.get(parent).right = map.get(child);
            
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            inDegree.put(parent, inDegree.getOrDefault(parent, 0));
        }

        for (int key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) return map.get(key);
        }
        
        return null;
    }
}