class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] extraEdge = new int[] {-1,-1};
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n+1);
        
        for (int[] edge: edges) {
            if (ds.find(edge[0], edge[1])) {
                extraEdge[0] = edge[0];
                extraEdge[1] = edge[1];
            } else {
                ds.union(edge[0], edge[1]);
            }
        }
        
        return extraEdge;
    }
}

class DisjointSet {
    int[] sizes;
    int[] parents;
    
    public DisjointSet(int n) {
        sizes = new int[n];
        Arrays.fill(sizes, 1);
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    public boolean find(int u, int v) {
        return findUPar(u) == findUPar(v);
    }
    
    private int findUPar(int u) {
        if (parents[u] == u) return u;
        return parents[u] = findUPar(parents[u]);
    }
    
    public void union(int u, int v) {
        int p1 = findUPar(u);
        int p2 = findUPar(v);
        
        if (p1 == p2) return;
        
        if (sizes[p1] > sizes[p2]) {
            sizes[p1] += sizes[p2];
            parents[p2] = p1;
        } else {
            sizes[p2] += sizes[p1];
            parents[p1] = p2;
        }
    }
}