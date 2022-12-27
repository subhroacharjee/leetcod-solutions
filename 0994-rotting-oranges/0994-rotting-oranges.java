class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) cnt++;
            }
        }
        int days = 0; 
        int[][] delta = {
            {0,-1}, {1,0}, {0, 1}, {-1, 0}
        };
        while(!q.isEmpty() && cnt > 0) {
            days++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                for (int x = 0; x < delta.length; x++) {
                    int coordRow = p.i + delta[x][0];
                    int coordCol = p.j + delta[x][1];
                    
                    if (coordRow < 0 || coordRow >= n) continue;
                    if (coordCol < 0 || coordCol >= m) continue;
                    if (grid[coordRow][coordCol] == 2 || grid[coordRow][coordCol] == 0) continue;
                    grid[coordRow][coordCol] = 2;
                    cnt--;
                    q.add(new Pair(coordRow, coordCol));
                }
            }
        }
        
        return cnt == 0 ? days : -1;
        
    }
    
}

class Pair{
    public int i,j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}