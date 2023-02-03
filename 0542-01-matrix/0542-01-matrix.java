class Solution {
    final int[][] delta = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}  
    };
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] distance = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    
                    q.offer(new int[] {i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] pair = q.poll();
            for (int[] del: delta) {
                int row = pair[0] + del[0];
                int col = pair[1] + del[1];
                
                // check if out of bound
                if (row < 0 || row >= n) continue;
                if (col < 0 || col >= m) continue;
                
                // in case the distance there is already minimum.
                if (distance[row][col] <= distance[pair[0]][pair[1]] + 1) continue;
                
                distance[row][col] = distance[pair[0]][pair[1]] + 1;
                q.add(new int[] {row, col});
            }
        }
        
        return distance;
    }
}