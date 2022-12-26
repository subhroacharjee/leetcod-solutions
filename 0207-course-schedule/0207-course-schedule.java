class Solution {
    Stack<Integer> stack = new Stack<>();
    public boolean canFinish(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adjList =  new List[n];
        for (int i = 0; i< n; i++) adjList[i] = new ArrayList<>();
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (u == v) return false;
            adjList[u].add(v);
            
        }
        
        
        for (int i = 0; i < n; i++) {
            // System.out.println(i + " " + adjList[i]);
            if (!visited[i]) topoSort(i, adjList, visited);
        }
        
        int[] position =  new int[n];
        int idx = 0;
        
        while (!stack.isEmpty()) {
            position[stack.peek()] = idx;
            idx++;
            stack.pop();
        }
        
        for (int node: position) {
            for (int adjNode: adjList[node]) {
                if (position[node] > position[adjNode]) return false;
            }
        }
        
        return true;
    }
    
    void topoSort(int node, List<Integer>[] adjList, boolean[] visited) {
        
		visited[node] = true;
		for ( int adjNode: adjList[node]) {
			if (visited[adjNode]) continue;
			topoSort(adjNode,adjList, visited);
		}
		stack.add(node);
        // System.out.println(stack);
	}
}