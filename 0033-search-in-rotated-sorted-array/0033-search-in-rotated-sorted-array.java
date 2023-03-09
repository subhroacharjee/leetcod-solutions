class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        
        int l = pivot-1, r = nums.length;
        
        while(l+1< r) {
            int m = l + (r - l)/2;
            if (nums[m]<= target) l = m;
            else r = m;
        }
        
        if (l >=0 && nums[l] == target) return l;
        
        l = -1;
        r = pivot;
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (nums[m]<= target) l = m;
            else r = m;
        }
        if (l >= 0 && nums[l] == target) return l;
        return -1;
        
    }
    
    int findPivot(int[] nums) {
        int l = -1;
        int r = nums.length;
        int lastElem = nums[r - 1];
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] > lastElem) l = m;
            else r = m;
        }
        
        return r;
    }
}