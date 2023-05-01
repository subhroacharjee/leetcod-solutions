class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1 || k == 1) return 0;
        int size = (int)Math.pow(2, n -2);
        if (k > size) {
            int ans = kthGrammar(n-1, k-size);
            ans = ans ^ 1;
            return ans;
        } else {
            return kthGrammar(n-1, k);
        }
    }
}