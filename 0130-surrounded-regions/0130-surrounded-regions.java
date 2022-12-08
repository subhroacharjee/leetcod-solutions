class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][]visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                q.add(new Pair(0,i));
            }
            
            if (board[n-1][i] == 'O') {
                q.add(new Pair(n-1, i));
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                q.add(new Pair(i, 0));
            }
            
            if (board[i][m-1] == 'O') {
                q.add(new Pair(i, m-1));
            }
        }
        
        bfs(q, board, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
        
    }
    
    int[][] dx = {
        {1,0}, {0,1}, {-1,0}, {0,-1}
    };
    private void bfs(Queue<Pair> q, char[][] board, boolean[][] visited) {
        if (q.isEmpty()) return;
        int n = board.length;
        int m = board[0].length;
        int i = q.peek().x;
        int j = q.peek().y;
        q.poll();
        visited[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k][0];
            int y = j + dx[k][1];
            if (x < 0 || x >= n || y < 0 || y >= m) continue;
            if (board[x][y] == 'X' || visited[x][y]) continue;
            q.add(new Pair(x, y));
        }
        
        bfs(q, board, visited);
    }
}

class Pair {
    public int x;
    public int y;
    
    public Pair(int i, int j) {
        x = i;
        y = j;
    }
}