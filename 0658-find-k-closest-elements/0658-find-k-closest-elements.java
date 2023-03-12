class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0, r = n-1;
        List<Integer> list = new ArrayList<>();
        
        while(r - l >= k) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            } else {
                r--;
            }
        }
        
        for (int i=l; i <=r; i++) {
            list.add(arr[i]);
        }
        
        return list;
    }
}