class Solution {
    int[] degree;
    List<Integer>[] adjList;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int V = n;
        Queue<Integer> q = new LinkedList<>();
        degree = new int[n];
        adjList = new List[n];
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        
        for(int i = 0; i < n; i++) {
            if (degree[i] <= 1) q.add(i);
        }
        
        while(V > 2) {
            int size = q.size();
            V -= size;
            for (int j = 0; j < size; j++) {
                int node = q.poll();
                for (int adjNode: adjList[node]) {
                    degree[adjNode] --;
                    if (degree[adjNode] == 1) q.add(adjNode);
                }
                
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            
            ans.add(q.poll());
        }
        
        return ans;
    }
    
}