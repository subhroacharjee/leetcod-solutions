class Solution {
    int[] mem = new int[46];
    public int climbStairs(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        if (mem[n] != 0) return mem[n];
        
        mem[n] = climbStairs(n-1) + climbStairs(n-2);
        return mem[n];
    }
}