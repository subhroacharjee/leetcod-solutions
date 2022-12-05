/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()) {
            Node leftNode = q.poll();
            int n = q.size();
            if (leftNode.left != null) q.add(leftNode.left);
            if (leftNode.right != null) q.add(leftNode.right);
            for (int i = 0; i< n; i++) {
                leftNode.next = q.peek();
                leftNode = q.poll();
                if (leftNode.left != null) q.add(leftNode.left);
                if (leftNode.right != null) q.add(leftNode.right);
            }
        }
        
        return root;
    }
}