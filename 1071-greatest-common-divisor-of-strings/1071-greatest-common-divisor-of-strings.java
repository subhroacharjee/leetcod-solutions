class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        if (!s1.equals(s2)) {
            return "";
        }
        return s2.substring(0, gcd(str1.length(), str2.length()));
        
    }
    
    int gcd(int a, int b) {
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a); 
    }
}