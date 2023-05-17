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
    
    Queue<Pair> q = new LinkedList<>();
    public TreeNode recoverFromPreorder(String traversal) {
        generateQueueFromString(traversal);
        TreeNode fakeRoot = new TreeNode(-1);
        f(fakeRoot, -1);
        
        return fakeRoot.left;
    }
    
    private void generateQueueFromString(String traversal) {
        boolean isNum = false;
        int val =0;
        int depth = 0;
        for (int i = 0; i < traversal.length(); i++) {
            if (Character.isDigit(traversal.charAt(i))) {
                if (!isNum) isNum = true;
                val = val * 10 + (traversal.charAt(i) - '0');
            } else {
                if (isNum) {
                    q.add(new Pair(val, depth));
                    val = 0;
                    depth =0;
                    isNum = false;
                }
                depth++;
            }
        }
        
        q.add(new Pair(val, depth));
    }
    
    private boolean f(TreeNode node, int currDepth) {
        // base condition
        // System.out.println(q);
        if (q.isEmpty()) return true;
        while (!q.isEmpty() && q.peek().depth > currDepth) {
            int val = q.peek().val;
            TreeNode next = new TreeNode(val);
            
            if (node.left == null) node.left = next;
            else if (node.right == null) node.right = next;
            else break;
            q.poll();
            if (f(next, currDepth + 1)) return true;
            
        }
        
        return false;
    }
}

class Pair {
    public int val, depth;
    
    
    public Pair(int _val, int _depth) {
        val = _val;
        depth = _depth;
    }
    
    
    @Override
    public String toString() {
        return "("+ val + " " + depth + ")";
    }
}