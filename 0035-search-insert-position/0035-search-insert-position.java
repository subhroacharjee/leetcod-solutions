class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = -1; int r = nums.length;
        while(l +1 < r) {
            int m = l + (r-l)/2;
            if (predicate(nums[m], target) == 0) l = m;
            else r = m;
        }
        
        return r;
    }
    
    int predicate(int m, int target) {
        if (m < target) return 0;
        return 1;
    }
}