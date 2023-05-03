class Solution {
    
    int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int perimeter = 0;
        boolean isVisited[][] = new boolean[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    isVisited[i][j] = true;
                    break;
                }
            }
        }
        
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for (int[]d : delta) {
                int x = p.a + d[0];
                int y = p.b + d[1];
                if (x < 0 || x >= n || y <0 || y >= m) {
                    perimeter++; continue;
                } else if (grid[x][y] == 0) {
                    perimeter++; continue;
                } else if (isVisited[x][y]) continue;
                
                q.add(new Pair(x,y));
                isVisited[x][y] = true;
            }
        }
        
        return perimeter;
    }
}

class Pair {
    public int a;
    public int b;
    
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}