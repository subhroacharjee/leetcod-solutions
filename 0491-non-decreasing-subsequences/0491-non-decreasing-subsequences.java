class Solution {
    HashSet<List<Integer>> ans = new HashSet<>();
    int N;
    int[] nums;
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        N = nums.length;
        find(0, -1000, new ArrayList<>());
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(ans);
        return result;
    }
    
    void find(int index, int last, List<Integer> current) {
        if (index == N) {
            if (current.size() >=2 ) ans.add(new ArrayList<>(current));
            return;
        }
        
        if (nums[index] >= last) {
                current.add(nums[index]);
                find(index+1, nums[index], current);
                current.remove(current.indexOf(nums[index]));
        }
        
        find(index+1, last, current);
        
    }
    
    
}