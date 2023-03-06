class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int c = 0, r = n -1;;
        int cnt = 0;
        
        while(r >=0 && c < m) {
            if (grid[r][c] < 0) {
                cnt += m - c;
                r--;
            } else {
                c++;
            }
        }
        
        return cnt;
    }
}