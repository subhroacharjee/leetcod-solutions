class Solution {
    boolean[] visited;
    Queue<Integer> q = new LinkedList<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] in = new int[n];
        visited = new boolean[n];
        
        // transpose the graph
        List<Integer>[] adjList = createGraph(n);
        
        for (int i = 0; i < n; i++) {
            for(int ed : graph[i]) {
                adjList[ed].add(i);
                in[i]++;
            }
        }
        
        // find all terminal node
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int i : adjList[node]) {
                in[i] --;
                if (in[i] == 0) q.add(i);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) ans.add(i);
        }
        
        return ans;
        
    }
    
    public List<Integer>[] createGraph(int n) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        return adjList;
    }
    
}