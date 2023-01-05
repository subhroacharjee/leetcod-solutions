class Solution {
    private int timer= 0;
    private List<List<Integer>> serverBridge = new ArrayList<>(); // will store all critical connections
    private boolean[] visited;
    private int[] timeOfDiscovery;
    private int[] lowestTimeOfDiscovery;
    private List<Integer>[] adjList;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adjList = new List[n];
        visited = new boolean[n];
        timeOfDiscovery = new int[n];
        lowestTimeOfDiscovery = new int[n];
        
        // graph creation
        for (int i =0 ; i< n; i++) adjList[i] = new ArrayList<>();
        
        for (List<Integer> connection: connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        for (int i =0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, -1);
        }
        
        return serverBridge;
    }
    
    private void dfs(int node, int parent) {
        visited[node] = true;
        timeOfDiscovery[node] = lowestTimeOfDiscovery[node] = timer++;
        
        for (int adjNode: adjList[node]) {
            if (adjNode == parent) continue;
            if (!visited[adjNode]) {
                dfs(adjNode, node);
                
                // so adjNode will have a lowest time of discovery greater than the
                // it's parent node then it means all the nodes from the adjNode are not
                // coming back to the parent node and hence if this edge is cut out it will
                // create 2 components.
                if (timeOfDiscovery[node] 
                    < lowestTimeOfDiscovery[adjNode]) 
                serverBridge.add(Arrays.asList(node, adjNode));
            }
            
            // we are assigning the lowest time as in a single component lowest time for all the nodes
            // will be same as the it's ancestor.
            lowestTimeOfDiscovery[node] = Integer.min(lowestTimeOfDiscovery[node],
                                                      lowestTimeOfDiscovery[adjNode]);
            
        }
    }
}