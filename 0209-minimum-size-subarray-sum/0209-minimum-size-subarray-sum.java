class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) sums[i]=sums[i-1] + nums[i];
    
        int res = n+1;
        
        for (int i = 0; i < n; i++) {
            int l = i-1, r= n;
            while(l+1 < r) {
                int m = l + (r - l)/2;
                int cost = sums[m] - sums[i] + nums[i];
                if (cost < target) {
                    l = m;
                }
                else {
                    res = Math.min(res, m - i  + 1);
                    r = m;
                }
            }
            
            
        }
        
        
        return res == n+1 ? 0: res;
    }
    
    
}