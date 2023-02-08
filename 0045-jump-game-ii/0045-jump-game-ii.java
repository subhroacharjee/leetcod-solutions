class Solution {
    int[] mem;
    final int inf = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        int n = nums.length;
        mem = new int[n];
        Arrays.fill(mem, -1);
        return getMinSteps(nums, 0, n);
    }
    
    private int getMinSteps(int[] arr, int idx, final int n) {
        if (idx == n-1) return 0;
        if (mem[idx] != -1) return mem[idx];
        
        int minJumps = inf;
        
        for (int j = 1; j <= arr[idx]; j++) {
            int newIdx = idx + j;
            if (newIdx > n-1) break;
            if (arr[newIdx] == 0 && newIdx != n-1) continue;
            int jump = getMinSteps(arr, newIdx, n);
            if (jump != inf)
            minJumps = Math.min(jump + 1, minJumps);
        }
        
        return mem[idx] = minJumps;
    }
}