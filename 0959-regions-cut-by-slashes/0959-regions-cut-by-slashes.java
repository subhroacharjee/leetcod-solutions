class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet((n + 1) * (n + 1));
        
        // connect outer most sides
        
        for (int i = 0 ; i <= n; i++) {
            ds.union(0, i);
            ds.union(0, (i*(n+1)) + 0);
            ds.union(0, (n * (n+1)) + i);
            ds.union(0, (i *(n+1)) + n);
        }
        int count = 1;
        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '/') {
                    int x = (i+1) * (n+1) + j;
                    int y = (i*(n+1)) + j+1;
                    if (ds.find(x, y)) count++;
                    ds.union(x, y);
                } else if (s.charAt(j) == '\\') {
                     int x = (i) * (n+1) + j;
                    int y = ((i+1)*(n+1)) + j+1;
                    if (ds.find(x, y)) count++;
                    ds.union(x, y);
                }
            }
        }
        
        return count;
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