class Solution {
Queue<NodeHolder> q = new LinkedList<>();
public int minDepth(TreeNode root) {
if( root != null) q.add(new NodeHolder(root, 1));
return bfs();
}
public int bfs() {
if (q.isEmpty()) return 0;
NodeHolder holder = q.poll();
TreeNode root = holder.node;
if (isLeaf(root)) {
q.clear();
return holder.level;
}
if(root.right != null) q.add(new NodeHolder(root.right, holder.level + 1));
if (root.left != null) q.add(new NodeHolder(root.left, holder.level + 1));
return bfs();
}
private boolean isLeaf(TreeNode node) {
return node.left == null && node.right == null;
}
}
​
class NodeHolder {
/*
* This class keeps a node and it's level, so that during BFS we dont have to
* worry about finding the level manually.
*/
public TreeNode node;
public int level;
public NodeHolder(TreeNode node, int level){
this.node = node;
this.level = level;
}
}
```
​
​