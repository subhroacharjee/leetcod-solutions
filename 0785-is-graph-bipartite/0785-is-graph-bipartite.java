class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        boolean ans = true;
        for (int i = 0; i < n && ans; i++) {
            if (colors[i] == 0 ) ans = ans && dfs(i, 1, graph, colors);
        }
        
        return ans;
    }
    
    private boolean dfs(int node, int cl, int[][] graph, int[] colors) {
        colors[node] = cl;
        int altCl = cl == 1? -1:1;
        for (int adjNode: graph[node]) {
            if (colors[adjNode] != 0 ) {
                if ( colors[adjNode] == cl) return false;
                continue;
            }
            
            boolean flag = dfs(adjNode, altCl, graph, colors);
            if (!flag) return false;
        }
        
        return true;
    }
}