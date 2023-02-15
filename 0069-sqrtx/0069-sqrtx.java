class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        final int t = x;
        int l = 0;
        int r = x;
        int steps = 150;
        int m = 0;
        
        while(steps-- > 0) {
            m = l + (r - l)/2;
            
            
	        long mSq = (long)m * (long)m;
	        
	        if (mSq <= t) {
	            l = m;
	        } else {
	            r = m;
	        }
	        
        }
        
        return l;
    }
    
  
}