class Solution {
    public boolean isPerfectSquare(int num) {
        double l = 0, r = (double)num;
        double m = 0;
        int steps = 150;
        while(steps-- > 0) {
            m = l + (r - l)/2;
            if (m*m <= num) l = m;
            else r = m;
        }
        
        double x = Math.ceil(m);
        
       
        return x == m;
    }
}