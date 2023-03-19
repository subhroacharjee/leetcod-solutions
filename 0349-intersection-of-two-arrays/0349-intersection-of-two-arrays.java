class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums2) {
            set.add(n);
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (set.contains(nums1[i])) res.add(nums1[i]);
        }
        
        int[] ans= new int[res.size()];
        int ptr = 0;
        for(int n: res) {
            ans[ptr++] = n;
        }
        
        return ans;
    }
}