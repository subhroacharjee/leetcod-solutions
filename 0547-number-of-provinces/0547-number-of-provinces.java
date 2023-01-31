class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) ds.union(i, j);
            }
        }
        
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) provinces++;         
        }
        
        return provinces;
    }
}

class DisjointSet {
    public int[] size;
    public int[] parent;
    
    public DisjointSet(int n) {
        size = new int[n];
        Arrays.fill(size, 1);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int findUParent(int u) {
        if (parent[u] == u) return u;
        return parent[u] = findUParent(parent[u]);
    }
    
    public void union(int a, int b) {
        int u = findUParent(a);
        int v = findUParent(b);
        
        if (u == v) return;
        
        if (size[u] > size[v]) {
            size[u] += size[v];
            parent[v] = u;
        } else {
            size[v]+= size[u];
            parent[u]= v;
        }
    }
}