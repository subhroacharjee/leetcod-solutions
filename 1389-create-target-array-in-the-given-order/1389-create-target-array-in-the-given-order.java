class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for ( int i = 0; i < n; i++) {
            if (ans[index[i]] != -1) {
                for (int j = n-2; j >= index[i]; j--) {
                    ans[j+1] = ans[j];
                }
            }
                
            ans[index[i]] = nums[i];
        }
        
        return ans;
    }
}