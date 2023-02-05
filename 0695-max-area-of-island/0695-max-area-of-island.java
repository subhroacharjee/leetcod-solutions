class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length; 
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Integer.max(maxArea, getArea(grid, i, j, 0));
                }
            }
        }
        
        return maxArea;
    }
    
    int[][] delta = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    private int getArea(int[][] grid, int i, int j, int area) {
        grid[i][j] = -1;
        for (int[] d: delta) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || x >= grid.length) continue;
            if (y < 0 || y >= grid[0].length) continue;
            if (grid[x][y] != 1) continue;
            area+= getArea(grid, x, y, 0);
        }
        area+=1;
        return area;
    }
}