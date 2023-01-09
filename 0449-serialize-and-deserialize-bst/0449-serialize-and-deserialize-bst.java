/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        String s = root.val + "";
        s +=" " + serialize(root.left);
        s+= " " + serialize(root.right);
        
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> treeNodes = new LinkedList<String>();
        treeNodes.addAll(Arrays.asList(data.split(" ")));
        return helper(treeNodes);
        
    }
    
    public TreeNode helper(Queue<String> treeNodes) {
        String currNode = treeNodes.poll();
        if (currNode.equals("#")) {
			return null;
		}
        TreeNode newNode = new TreeNode(Integer.valueOf(currNode));
        newNode.left = helper(treeNodes);
        newNode.right = helper(treeNodes);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;