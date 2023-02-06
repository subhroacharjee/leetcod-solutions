class Solution {
    int ans = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] adjList = createGraph(n);
        
        
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) continue;
            adjList[parent[i]].add(i);
        }
        
        maxPath(0, adjList, s);
        return ans;
    }
    
    public List<Integer>[] createGraph(int n) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        return adjList;
    }
    
    
    private int maxPath(int node, List<Integer>[] adjList, String s) {
        
        int[] pts = new int[2];
        for (int adjNode: adjList[node]) {
            int res = maxPath(adjNode, adjList, s);
            if (s.charAt(node) == s.charAt(adjNode)) continue;
            if (pts[0] < res) {
                pts[1] = pts[0];
                pts[0] = res;
                
            } else if (res > pts[1]) {
                pts[1] = res;
            }
        }
        ans = Math.max(ans, 1 + pts[0] + pts[1]);
        return 1 + pts[0];
    }
}