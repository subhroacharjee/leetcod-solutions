class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ptr1 = 0;
        int ptr2 = 0;
        
        int ans = -1;
        while(ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                ans = nums1[ptr1];
                ptr1++;
                ptr2++;
                
                break;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                ptr2++;
            } else {
                ptr1++;
            }
        }
        
        return ans;
    }
}