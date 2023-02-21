class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = -1;
        int r = nums.length;
        
        while(l+1 < r) {
            int m = l + (r - l)/2;
            
            if (predicate(m, nums) == 0) l = m;
            else r = m;
        }
        
        return nums[l];
    }
    
    
    public int predicate(int m, int[] nums) {
        int idx = m;
        if (m>0 && nums[m - 1] == nums[m]) {
            idx = m -1;
        }
        
        
        return idx % 2;
    }
}