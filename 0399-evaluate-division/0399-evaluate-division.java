class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Graph g = new Graph(equations, values);
        int n = queries.size();
        double[] ans = new double[n];
        int idx = 0;
        for (List<String> q: queries) {
            ans[idx++] = g.getDivision(q);
        }
        return ans;
    }
}

class Graph {
    HashMap<String, Integer> nodes = new HashMap<>();
    List<Pair>[] adjList;
    public int size = 0;
    DisjointSet ds;
    boolean[] visited;
    Queue<Pair> q = new LinkedList<>();
    
    public Graph(List<List<String>> edges, double[] weights) {
        for (List<String> edge: edges) {
            if (!nodes.containsKey(edge.get(0))) {
                nodes.put(edge.get(0), size);
                size++;
            }
            
            if (!nodes.containsKey(edge.get(1))) {
                nodes.put(edge.get(1), size);
                size++;
            }
        }
        
        
        adjList = new List[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new ArrayList<>();
        }
        ds = new DisjointSet(size);
        visited = new boolean[size];
        createGraph(edges, weights);
    }
    
    private void createGraph(List<List<String>> edges, double[] weights) {
        int idx = 0;
        for (List<String> edge: edges) {
            int u = nodes.get(edge.get(0));
            int v = nodes.get(edge.get(1));
            
            adjList[u].add(new Pair(v, weights[idx]));
            adjList[v].add(new Pair(u, 1/weights[idx]));
            ds.union(u,v);
            ds.union(v,u);
            idx++;
        }
    }
    
    
    public int getNodeValues(String node) {
        return nodes.getOrDefault(node, -1);
    }
    
    public double getDivision(List<String> edge) {
        int u = getNodeValues(edge.get(0));
        int v = getNodeValues(edge.get(1));
        
        
        if (u == -1 || v == -1) {
            return -1.0f;
        }
        if (!ds.find(u,v)) return -1.0f;
     
        Arrays.fill(visited, false);
        q.clear();
        
        q.add(new Pair(u, 1.0));
        visited[u] = true;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x == v) return p.y;
            for(Pair adjNode : adjList[p.x]) {
                if (visited[adjNode.x]) continue;
                visited[adjNode.x] = true;
                q.add(new Pair(adjNode.x, p.y * adjNode.y));
            }
        }
        
        return -1.0;
    }
    
}

class Pair {
    public int x;
    public double y;
    public Pair(int x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return x + "->" + y;
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
    
    public int findUPar(int n) {
        if (parents[n] == n) return n;
        return parents[n] = findUPar(parents[n]);
    }
    
    public boolean find(int u, int v) {
        return findUPar(u) == findUPar(v);
    }
    
    public void union(int u, int v) {
        if (find(u,v)) return;
        int uPar = findUPar(u);
        int vPar = findUPar(v);
        
        if (sizes[uPar] > sizes[vPar]) {
            sizes[uPar] += sizes[vPar];
            parents[vPar] = uPar;
        } else {
            sizes[vPar] += sizes[uPar];
            parents[uPar] = vPar;
        }
    }
}