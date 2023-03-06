class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = -1;
        int r = matrix.length;
        
        
        while(l+1 < r) {
            int m = l + (r - l)/2;
            
            if (matrix[m][0] == target) return true;
            else if (matrix[m][0] < target) l = m;
            else r = m;
        }
        
        int row = l;
        if (row < 0) return false;
        l = -1;
        r = matrix[0].length;
        
        while(l+1 < r) {
            int m = l + (r - l)/2;
            
            if (matrix[row][m] == target) return true;
            else if (matrix[row][m] < target) l = m;
            else r = m;
        }
        
        return false;
    }
}