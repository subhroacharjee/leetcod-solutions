class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        
        for(int i = 0; i < prices.length; i++) {
            max = Integer.max(max, prices[i] - min);
            min = Integer.min(prices[i], min);
        }
        
        return max;
    }
}