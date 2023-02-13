class Solution {
    public int countOdds(int low, int high) {
        int ans = 0;
        if (low % 2 != 0) {
            ans++;
            low ++;
        }
        if (high % 2 != 0) {
            ans ++;
            high --;
        }
        
        ans += (high - low) / 2;
        
        return ans;
    }
}