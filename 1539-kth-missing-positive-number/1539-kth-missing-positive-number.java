class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = -1; int r = arr.length;
        while(l+1<r) {
            int m = l + (r - l)/2;
            int noOfMissingIntegers = arr[m] - 1 - m; // arr[m] - (m +1) -> 0 - m is m but from 1 - m+1
            
            if (noOfMissingIntegers < k) l = m;
            else r = m;
        }
        
        return l+k+1;
    }
}