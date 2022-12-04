class Solution{
    
   char[][] matrix;
    String word;
    int n, m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        matrix = board;
        this.word = word;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (matrix[i][j]!='#' && func(i, j, 0)) return true; 
            }
        }
        
        return false;
    }
    
    
    
    boolean func(int i, int j, int wordIndex) {
        if(wordIndex == word.length()) return true;
        if ( i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] != word.charAt(wordIndex)) return false;
        

        matrix[i][j] = '#';
        boolean ans1 = func(i+1, j, wordIndex +1) 
                        || func(i-1, j, wordIndex+1) 
                        || func(i, j+1, wordIndex+1) 
                        || func(i, j-1, wordIndex+1);
        matrix[i][j] = word.charAt(wordIndex);
        
        return ans1;
        
    }
    
}

