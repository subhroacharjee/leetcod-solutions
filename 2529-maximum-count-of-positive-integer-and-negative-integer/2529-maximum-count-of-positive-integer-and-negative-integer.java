class Solution {
    public int maximumCount(int[] nums) {
        int l1 =-1, r1= nums.length;
        int l2 = -1, r2 = nums.length;
        
        while(l1 + 1 < r1) {
            int m = l1 + (r1 - l1)/2;
            if (nums[m] < 0) l1 = m;
            else r1 = m;
        }
        
        while(l2 + 1 < r2) {
            int m = l2 + (r2 - l2)/2;
            if (nums[m]<=0) l2 = m;
            else r2 = m;
        }
        
        if (l1 > r2) return nums.length;
        return Math.max(l1+1, nums.length - r2);
    }
}