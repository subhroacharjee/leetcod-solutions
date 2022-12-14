class Solution {
    public int rob(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int[] arr = new int[nums.length];
        for (int i =0; i< nums.length; i++) arr[i] = -1; //O(n)
        for(int i = 0; i < 2; i++) {
            max1 = Integer.max(dfs(i, nums, arr), max1);
        }
        
        return max1;
        
    }
    
    int dfs(int i, int[] nums, int[] mem) {
        if (i >= nums.length) return 0;
        if (mem[i]!= -1) return mem[i];
        int max = 0;
        for (int j = i+2; j < nums.length; j++) {
            max = Integer.max(max, dfs(j, nums, mem));
        }
        max += nums[i];
        mem[i] = max;
        return max;
    }
}