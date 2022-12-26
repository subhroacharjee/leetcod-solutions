/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
   public Node cloneGraph(Node node) {
       if (node == null) return null;
        HashMap<Integer, Node> visitedNodes = new HashMap<Integer, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Node newRoot = new Node(node.val);
		visitedNodes.put(node.val, newRoot);
		while(!queue.isEmpty()) {
			Node currNode = queue.poll();
			Node copyNode = visitedNodes.get(currNode.val);
			for (int i = 0; i < currNode.neighbors.size(); i++) {
				int key = currNode.neighbors.get(i).val;
				if (visitedNodes.containsKey(key)) {
					copyNode.neighbors.add(visitedNodes.get(key));
				} else {
					Node newChild = new Node(key);
					copyNode.neighbors.add(newChild);
					visitedNodes.put(key, newChild);
					queue.add(currNode.neighbors.get(i));
				}
			}
		}
		return newRoot;
    }
    
}