class Solution {
    public int findMin(int[] nums) {
        int l = -1;
        int r = nums.length;
        int last = nums[r - 1];
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] > last) l = m;
            else r = m;
        }
        
        return nums[r];
    }
}