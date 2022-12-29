class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int v : nums){
            xor ^= v;
        }
        int r = xor &(~(xor-1));
        int[] res = new int[2];

        for(int v : nums){
            if((v & r) != 0) res[0] ^= v;
        }
        res[1] = res[0]^xor;

        return res;
    }
}