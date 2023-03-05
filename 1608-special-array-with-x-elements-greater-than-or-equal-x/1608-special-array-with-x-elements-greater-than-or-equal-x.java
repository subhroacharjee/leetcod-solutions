class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums); 
        int l = -1, r = (int)10e5;
        
        while(l +1 < r) {
            int m = l + (r - l)/2;
            
            if (predicate(nums, m) == 0) l = m;
            else r = m;
        
        }
        
        int countG = 0;
        for (int num: nums) {
            if (num >= l) countG++;
        }
        
        
        return countG == l ? l:-1;
    }
    
    
    int predicate(int[] nums, int x) {
        
        int indexOfX = 0;
        int idx = 0;
        while(idx < nums.length && nums[idx++] < x) indexOfX++;
        
        int count = nums.length - indexOfX + 1;
        if (nums.length - indexOfX >= x) return 0;
        else return 1;
    }
}