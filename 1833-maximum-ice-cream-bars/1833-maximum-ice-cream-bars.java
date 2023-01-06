class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        
        // iterate through cost metrics till coins are exhausted
        int wallet = coins;
        int idx = 0;
        while(idx < costs.length) {
            if (costs[idx] > wallet) break;
            wallet-= costs[idx];
            idx++;
        }
        
        if (wallet == coins) return 0;
        return idx;
    }
}