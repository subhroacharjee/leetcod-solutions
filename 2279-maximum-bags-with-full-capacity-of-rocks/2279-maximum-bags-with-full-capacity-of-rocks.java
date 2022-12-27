class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] remaining = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            remaining[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remaining);
        int idx = 0;
        while (idx < n && additionalRocks >= remaining[idx]) {
            additionalRocks = additionalRocks - remaining[idx];
            remaining[idx] = 0;
            idx++;
            ans++;
        }
        
        return ans;
    }
}