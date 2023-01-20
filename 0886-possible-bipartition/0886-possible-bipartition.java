class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors = new int[n+1];
        List<Integer>[] adjList = new List[n+1];
        
        // create graph
        for (int i = 0; i <= n; i++) adjList[i] = new ArrayList<>();
        
        for (int[] dislike: dislikes) {
            int u = dislike[0], v = dislike[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        // color the graph
        Queue<Integer> q = new LinkedList<>();
        
        
        for (int i = 1; i <= n; i++) {
            if (colors[i]!=0) continue;
            q.add(i);
            colors[i] = 1;
            while(!q.isEmpty()) {
                int node = q.poll();
                int nextColor = colors[node] == 1? -1: 1;
                for (int adjNode: adjList[node]) {
                    if (colors[adjNode] != 0) {
                        if (colors[adjNode] != nextColor) return false;
                        else continue;
                    }
                    colors[adjNode] = nextColor;
                    q.add(adjNode);
                }
            }
        
        }
        
        // validating if grouping is possible or not
        for (int i = 1; i <= n; i++) {
            
            for (int adjNode: adjList[i]) {
                if (colors[i] == colors[adjNode]) return false;
            }
        }
        return true;
        
    }
    
}