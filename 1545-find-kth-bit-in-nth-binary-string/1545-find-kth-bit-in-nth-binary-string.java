class Solution {
    public char findKthBit(int n, int k) {
        
        if (k == 1 || n == 1) return '0';
        final int powOf2 = (int)Math.pow(2, n-1);
        
        if (k < powOf2) return findKthBit(n-1, k);
        if (k == powOf2) return '1';
        else {
            k = 2 * powOf2 - k;
            char ch = findKthBit(n - 1, k);
            
            return ch == '0' ? '1' : '0';
        }
    }
}