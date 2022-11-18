class Solution {
    public boolean isUgly(int no) {
        if (no == 0) return false;
       int i = 1;
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);
  
        return (no == 1) ;
    }
    
    int maxDivide(int a, int b)
    {
        while (a % b == 0)
            a = a / b;
        return a;
    }
  
}