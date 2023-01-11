class Solution {
    List<Integer>[] adjList;
    boolean[] visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adjList = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        // make the tree
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        // find the min time to 
        
        return dfs(0, 0, hasApple);
    }
    
    private int dfs(int node, int myCost, List<Boolean> hasApples) {
        if (visited[node]) return 0;
        visited[node] = true;
        int time = 0;
        for (int child: adjList[node]) {
            time+= dfs(child, 2, hasApples);
        }
        if (time == 0 && !hasApples.get(node)) return 0;
        return time + myCost;
    }
}