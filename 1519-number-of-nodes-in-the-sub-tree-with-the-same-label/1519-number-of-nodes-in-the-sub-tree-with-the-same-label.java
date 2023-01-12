class Solution {
    HashMap<Character, HashSet<Integer>> map = new HashMap<>();
    int[] ans;
    boolean visited[];
    List<Integer>[] adjList;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        visited = new boolean[n];
        adjList = new List[n];
        
        
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        
        
        for (int[] edge : edges) {
            
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        
        dfs(0,-1, labels);
        
        return ans;
    }
    
    private int[] dfs(int node, int parent, final String labels) {
    int[] count = new int[26]; // Count of letters down from this u

    for (final int v : adjList[node]) {
      if (v == parent)
        continue;
      int[] childCount = dfs(v, node, labels);
      for (int i = 0; i < 26; ++i)
        count[i] += childCount[i];
    }

    ans[node] = ++count[labels.charAt(node) - 'a']; // The u itself
    return count;
  }
}