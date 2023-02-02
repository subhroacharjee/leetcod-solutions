class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        int top = 0;
	    int bottom = n-1;
	    int left = 0;
	    int right = m-1;
	    
	    int count  = n*m;
	    
	    while (count > 0) {
	        for (int j = left; j <= right; j++) {
	            ans.add(mat[top][j]);
	            count--;
	        }
	        top++;
	        if (count <= 0) break;
	        for (int j = top; j <= bottom; j++) {
	            ans.add(mat[j][right]);
	            count--;
	        }
	        right--;
	        if (count <= 0) break;
	        for (int j = right; j >= left; j-- ) {
	            ans.add(mat[bottom][j]);
	            count--;
	        }
	        bottom--;
	        if (count <= 0) break;
	        for (int j = bottom; j >= top; j--) {
	            ans.add(mat[j][left]);
	            count--;
	        }
	        left++;
	    }
        
        return ans;
    }
}