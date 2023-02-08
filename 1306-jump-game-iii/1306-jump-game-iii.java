class Solution {
    boolean[] visited;
    
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        visited = new boolean[n];
        int cntZero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) cntZero++;
        }
        
        if (cntZero == 0) return false;
        
        return isReachable(arr, start, n);
    }
    
    private boolean isReachable(int[] arr, int idx, final int n) {
        if (arr[idx] == 0) return true;
        if (visited[idx]) return false;
        
        visited[idx] = true;
        boolean v  = false;
        int left = idx - arr[idx];
        if (left >= 0) {
            v = isReachable(arr, left, n);
        }
        if (v) return true;
        int right = idx + arr[idx];
        if (right < n) v = isReachable(arr, right, n);
        if (v) return true;
        
        visited[idx] = false;
        return false;
    }
}