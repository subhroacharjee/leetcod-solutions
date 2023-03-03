class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = getFirstPosition(nums, target);
        int l = getLastPosition(nums, target);
        
        if (f>l) return new int[]{-1, -1};
        return new int[]{f, l};
    }
    
    int getFirstPosition(int[]nums, int target) {
        int l = -1;
        int r = nums.length;
        
        while(l+1 < r) {
            int mid = l + (r - l)/2;
            
            if (nums[mid] < target) l = mid;
            else r = mid;
        }
        
        return r;
    }
    
    int getLastPosition(int[]nums, int target) {
        int l = -1;
        int r = nums.length;
        
        while(l+1 < r) {
            int mid = l + (r - l)/2;
            
            if (nums[mid] <= target) l = mid;
            else r = mid;
        }
        
        return l;
    }
}