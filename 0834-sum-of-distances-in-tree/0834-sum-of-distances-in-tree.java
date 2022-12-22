class Solution {
    int[] res, count;
    List<Set<Integer>> graph;
    int N;
    Queue<Integer[]> q = new LinkedList<>();
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.N = n;
        res = new int[N];
        count = new int[N];
        graph = new ArrayList<>();

        // Initialize the value of count array. (Cuz it contains itself)
        Arrays.fill(count, 1);
        // Build the tree graph
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }
    
     private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                res[child] = res[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }
}