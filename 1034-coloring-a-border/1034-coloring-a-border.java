class Solution {
    int[][] delta = {
        {0,1}, {0,-1}, {1,0},{-1,0}
    };
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] isVisited = new boolean[n][m];
        isVisited[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        int originalColor = grid[row][col];
        q.add(new Pair(row, col));
        List<Pair> borders = new ArrayList<>();
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for (int[] d: delta) {
                int x = d[0] + p.x;
                int y = d[1] + p.y;
                
                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != originalColor) {
                    borders.add(new Pair(p.x, p.y));
                    continue;
                } else if (isVisited[x][y]) {
                    continue;
                }
                
                isVisited[x][y] = true;
                q.add(new Pair(x, y));
            }
        }
        
        for (Pair p: borders) {
            grid[p.x][p.y] = color;
        }
        
        return grid;   
    }
}

class Pair {
    public int x;
    public int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}