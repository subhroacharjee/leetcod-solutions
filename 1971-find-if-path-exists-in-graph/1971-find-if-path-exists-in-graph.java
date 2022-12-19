class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        boolean []visited = new boolean[n];
        HashSet<Integer>[] adjList = new HashSet[n];
        for (int i = 0; i < n; i++) adjList[i] = new HashSet<>();
        
        for (int i =0; i< edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][0]);
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
            adjList[edges[i][1]].add(edges[i][1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i< size; i++) {
                int s = q.poll();
                visited[s] = true;
                
                for (int adjNode: adjList[s]) {
                    if (adjNode == destination) {
                        q.clear();
                        return true;
                    }
                    if (visited[adjNode]) continue;
                    q.add(adjNode);
                }
            }
        }
        
        return false;
    }
    
    
}