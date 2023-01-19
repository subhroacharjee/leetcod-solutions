class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int cumilitiveSum = 0;
        int[] modArr = new int[k];
        
        for (int i = 0; i < n; i++) {
            cumilitiveSum += nums[i];
            modArr[((cumilitiveSum % k) + k) % k]++; // upto that point
        }
        
        int result = 0;
        for (int i= 0; i < k; i++) {
            if (modArr[i] > 1) {
                result+= (modArr[i] * (modArr[i]-1))/2;
            }
        }
        result+= modArr[0];
        return result;
    }
}