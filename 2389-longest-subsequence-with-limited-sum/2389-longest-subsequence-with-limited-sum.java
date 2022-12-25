class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i+1] += nums[i];
        }
        
        
        for (int i = 0; i < queries.length; i++) {
             ans[i] = findIndex(nums, nums.length, queries[i]);
        }
        
        return ans;
    }
    
    int findIndex(int[] arr, int n, int K) {
        // Lower and upper bounds
        int start = 0;
        int end = n - 1;

        // Traverse the search space
        while (start <= end)
        {
            int mid = (start + end) / 2;
            
            // If K is found
            if (arr[mid] == K)
                return mid+1;

            else if (arr[mid] < K)
                start = mid + 1;

            else
                end = mid - 1;
        }

        // Return insert position
        return end + 1;
    }
}