class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n+1];
        int[] outgoing = new int[n+1];
        
        for (int[] trst : trust) {
            incoming[trst[1]]++;
            outgoing[trst[0]]++;
        }
        
        for (int i = 1; i < n+1; i++) {
            if (incoming[i] == n-1 && outgoing[i] == 0) return i;
        }
        return -1;
    }
}