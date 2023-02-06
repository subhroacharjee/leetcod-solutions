class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int idx  = 0;
        for (int i = 0, j = n; i < n; i++, j++) {
            ans[idx++] = nums[i];
            ans[idx++] = nums[j];
        }
        
        return ans;
    }
}