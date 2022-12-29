class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] decoded = new int[n];
        decoded[0] = first;
        
        for (int i = 0; i < n - 1; i++ ) {
            decoded[i+1] = decoded[i] ^ encoded[i];
        }
        
        return decoded;
    }
}