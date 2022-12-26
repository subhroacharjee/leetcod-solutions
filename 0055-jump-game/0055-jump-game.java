class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, maxReach = 0;
        
        while(i < nums.length && i <= maxReach) {
            maxReach = Integer.max(i + nums[i], maxReach);
            i++;
        }
        
        return i == nums.length;
    }
    
    
}