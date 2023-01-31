class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        
        for (int num: nums) {
            for (int j = -1; j <= 1; j+=2) {
                int tmp = num + j;
                if (map.containsKey(tmp)) {
                    ds.union(map.get(num), map.get(tmp));
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Integer.max(ds.size[i], max);
        }
        
        return max;
    }
}

class DisjointSet {
    public int[] size;
    int[] parent;
    
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