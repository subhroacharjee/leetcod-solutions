class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int rem = -1;
        int totalRem = 0;
        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            
            if (rem < 0) {
                start = i;
                rem = cur;
            } else {
                rem+=cur;
            }
            
            totalRem+=cur;
        }
        
        if (totalRem < 0) return -1;
        return start;
    }
}