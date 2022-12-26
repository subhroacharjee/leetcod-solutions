class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') continue;
                else if (!visited[i][j]) {
                    dfs(i, j, grid, visited);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    int[][] delta = {
        {0, -1}, {0, 1}, {1, 0},{-1,0}
    };
    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        for (int k = 0; k < delta.length; k++) {
            int coordY = delta[k][0] + i;
            int coordX = delta[k][1] + j;
            if (coordY < 0 || coordY >= grid.length) continue;
            if (coordX < 0 || coordX >= grid[0].length) continue;
            if (grid[coordY][coordX] == '0') continue;
            if (visited[coordY][coordX]) continue;
            dfs(coordY, coordX, grid, visited);
        }
    }
}