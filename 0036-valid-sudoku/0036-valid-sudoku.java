class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> visited = new HashSet<>();
        
        int n = 9, m = 9;
        for (int i = 0; i<n; i++) {
            visited.clear();
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (visited.contains(board[i][j] - '0')) return false;
                    visited.add(board[i][j] - '0');
                }
            }
           
            visited.clear();
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(board[j][i])) {
                    if (visited.contains(board[j][i] - '0')) return false;
                    visited.add(board[j][i] - '0');
                }
            }
            
            int[] coord = getQuad(i+1);
            
            visited.clear();
            for (int j = coord[0]; j <= coord[2]; j++) {
                for (int k = coord[1]; k <= coord[3]; k++) {
                   
                    if (Character.isDigit(board[j][k])) {
                        if (visited.contains(board[j][k] - '0')) return false;
                        visited.add(board[j][k] - '0');
                    }
                }
               
            }
            
           
            
        }
        return true;
    }
    
    public int[] getQuad(int i) {
        int[] ans = new int[4];
        if (i <= 3) {
            ans[0] = 0;
            ans[2] = 2;
        } else if (i <= 6) {
            ans[0] = 3;
            ans[2] = 5;
        } else {
            ans[0] = 6;
            ans[2] = 8;
        }
        
        if (i == 1 || i == 4 || i == 7) {
            ans[1]=0;
            ans[3]=2;
        } else if (i == 2 || i == 5 || i == 8) {
            ans[1] = 3;
            ans[3] = 5;
        } else {
            ans[1] = 6;
            ans[3] = 8;
        }
        
        return ans;
    }
}