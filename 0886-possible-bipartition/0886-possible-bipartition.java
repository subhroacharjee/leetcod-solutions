class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] adjList = new List[n+1];
        int[] groups = new int[n+1];
        
        for (int i = 1; i <  n+1; i++) adjList[i] = new ArrayList<>();
        
        for (int i = 0; i < dislikes.length; i++) {
            adjList[dislikes[i][0]].add(dislikes[i][1]);
            adjList[dislikes[i][1]].add(dislikes[i][0]);
        }
        
    
        for( int i = 1; i < n+1; i++) {
            if (groups[i] == 0) {
                if (!dfs(i, adjList, groups, 1)) return false;
            }
        }
        
        return true;
        
    }
    
    boolean dfs(int node, List<Integer>[] adjList, int[] groups, int group) {
        groups[node] = group;
        int antiGroup = group == 1? 2: 1;
        
        for (int adjNode : adjList[node]) {
            if (groups[adjNode] != 0) {
                if (groups[adjNode] == group) return false;
                else continue;
            }
            if (!dfs(adjNode, adjList, groups, antiGroup)) return false;
        }
        
        return true;
    }
}
class Pair {
    public int node;
    public int color;
    
    public Pair(int a, int b) {
        node = a;
        color = b;
    }
}