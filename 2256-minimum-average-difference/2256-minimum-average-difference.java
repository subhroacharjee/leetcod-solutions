class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for(int num : nums) sum += num;
        
        long prevSum  = 0;
        long[] ans = new long[n];
        for (int i = 0; i < nums.length; i++) {
            long currentSumUptoI = prevSum + nums[i];
            long currentSumFromI = sum - nums[i];
            sum = sum - nums[i];
            prevSum = prevSum + nums[i];
            
            long x = currentSumUptoI/(i+1);
            long y = 0;
            if((n - i - 1) != 0)  y = (currentSumFromI)/(n - i - 1);
            
            
            ans[i] = Math.abs(x-y);
        }
        
        int minIndex = 0;
        
        for(int i = 0; i < n; i++) {
            if (ans[minIndex] > ans[i]) {
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}