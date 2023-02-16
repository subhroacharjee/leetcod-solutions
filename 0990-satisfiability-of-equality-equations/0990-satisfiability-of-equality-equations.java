class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet(26);
        
        
        for (String eq : equations) {
            int first = eq.charAt(0) - 'a';
            int second = eq.charAt(3) - 'a';
            
            char operation = eq.charAt(1);
            if (operation == '=') {
                ds.union(first, second);
            } 
        }
        
        for (String eq : equations) {
            int first = eq.charAt(0) - 'a';
            int second = eq.charAt(3) - 'a';
            
            char operation = eq.charAt(1);
            if (operation == '!' && ds.find(first, second)) {
                return false;
            }
        }
        
        return true;
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
    
    public int findUPar(int u) {
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