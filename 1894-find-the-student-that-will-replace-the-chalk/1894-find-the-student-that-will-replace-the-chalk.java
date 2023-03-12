class Solution {
    public int chalkReplacer(int[] chalks, int k) {
        int sum = 0;
        for (int i = 0; i < chalks.length; ++i) {
            sum += chalks[i];
            k -= chalks[i];
            if (k < 0) {
                return i;
            }
        }
        k %= sum; 
        for (int i = 0; i < chalks.length; ++i) {
            k -= chalks[i];
            if (k < 0) {
                return i;
            }
        }
        return 0;
        
    }
}