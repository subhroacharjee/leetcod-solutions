class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] sub = new int[n];
        int lastIdx = 0;
        
        sub[lastIdx] = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (sub[lastIdx] < nums[i]) {
                sub[++lastIdx] = nums[i];
            } else {
                sub[findPos(nums[i], lastIdx, sub)] = nums[i];
            }
            // System.out.println(Arrays.toString(sub));
        }
        
        return lastIdx+1;
    }
    
    
    int findPos(int x, int n, int[] sub) {
        int l = -1, r = n;
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (sub[m] < x) l = m;
            else r = m;
        }
        return r;
    }
}