class Solution {
    private int res = 0;
    int[][] dir = {
        {0,1}, {1,0}, {0,-1}, {-1,0}  
    };
    public int uniquePathsIII(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int count = 0;
        int[] start = null, end = null;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1) start = new int[]{i, j};
                else if(grid[i][j] == 0) count++;
            }
        }
        boolean[][] visited = new boolean[height][width];
        visited[start[0]][start[1]] = true;
        dfs(grid, start[0], start[1], visited, count + 1);
        return this.res;
    }
    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int count){
        if(grid[row][col] == 2 && count == 0)
            this.res++;
        else{
            int tempRow = 0, tempCol = 0;
            for(int d = 0; d < 4; d++){
                tempRow = row + dir[d][0];
                tempCol = col + dir[d][1];
                if(tempRow >= 0 && tempRow < grid.length && tempCol >= 0 && tempCol < grid[0].length && !visited[tempRow][tempCol] && grid[tempRow][tempCol] != -1){
                    visited[tempRow][tempCol] = true;
                    dfs(grid, tempRow, tempCol, visited, count - 1);
                    visited[tempRow][tempCol] = false;
                }
            }
        }
    }
}
