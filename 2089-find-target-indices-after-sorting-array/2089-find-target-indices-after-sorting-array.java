class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        
        int l =-1, r = nums.length;
        
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] < target) l = m;
            else r = m;
        }
        List<Integer> res =  new ArrayList<>();
        
        while(r < nums.length && nums[r] == target) res.add(r++);
        
        return res;
    }
}