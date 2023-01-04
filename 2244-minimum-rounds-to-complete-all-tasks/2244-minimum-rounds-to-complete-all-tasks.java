class Solution {
    HashMap<Integer, Integer> mem = new HashMap<>();
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int task: tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        int count = 0;
        for (int key: freq.keySet()) {
            int x = dfs(freq.get(key));
            if (x == -1) return -1;
            count+= x;
        }
        return count;
    }
    
    private int dfs(int n) {
        if (n == 1) return -1;
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (mem.containsKey(n)) return mem.get(n);
        
        int ans = 0;
        int x = dfs(n - 3);
        int y = dfs(n - 2);
        if (x == -1 && y == -1) ans = -1;
        else if (x == -1 && y != -1) ans = y + 1;
        else if (x != -1 && y == -1) ans = x + 1;
        else ans = Integer.min(y, x) + 1;
        mem.put(n, ans);
        
        return ans;
        
    }
}