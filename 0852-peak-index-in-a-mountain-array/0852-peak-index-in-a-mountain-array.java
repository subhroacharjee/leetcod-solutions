class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = -1;
        int r = arr.length;
        
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (predicate(arr, m) == 0) l = m;
            else r = m;
        }
        
        return r;
    }
    
    
    int predicate(int[] arr, int m) {
        if (arr[m] > arr[m+1]) return 1;
        else return 0;
    }
}