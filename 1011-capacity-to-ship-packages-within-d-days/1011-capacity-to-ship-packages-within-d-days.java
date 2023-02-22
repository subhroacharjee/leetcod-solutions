class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = Arrays.stream(weights).sum() + 1;
        
        while(l+1 < r) {
            int m  = l + (r - l)/ 2;
            if (predicate(m, days, weights) == 0) l = m;
            else r = m;
        }
        
        return r;
    }
    
    
    int predicate(int m, int days, int[] weights) {
        int noOfDays = getNoOfDays(m, weights);
        if (noOfDays > days) return 0;
        else return 1;
    }
    
    int getNoOfDays(int m, int[] weights) {
        int days = 0;
        int maxWt = 0;
        
        for (int wt: weights) {
            if (wt > m) return Integer.MAX_VALUE;
            
            if (maxWt + wt > m) {
                days++;
                maxWt = wt;
            } else {
                maxWt += wt;
            }
        }
        
        return ++days;
    }
}