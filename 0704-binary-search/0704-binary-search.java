class Solution {
    public int search(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        
        while(l+1<r) {
            int m = l + (r - l)/2;
            if (nums[m]<= target) l = m;
            else r = m;
        }
        
        if (l < 0 || nums[l] != target) return -1;
        return l;
    } 
}