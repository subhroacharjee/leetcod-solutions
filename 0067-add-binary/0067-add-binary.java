class Solution {
    public String addBinary(String a, String b) {
        
        while(a.length() != b.length()) {
            if (a.length() > b.length()) {
            b = '0'+b;
            }
            if (b.length() > a.length()) {
                a = '0'+a;
            }
        }
        
        int sum = 0;
        int carry = 0;
        String ans = "";
        int lastIdxOfA = a.length() - 1;
        int lastIdxOfB = b.length() - 1;
        while(lastIdxOfA >= 0) {
            int bitA = a.charAt(lastIdxOfA--) - '0';
            int bitB = b.charAt(lastIdxOfB--) - '0';
            
            sum = (bitA ^ bitB) ^ carry;
            carry = (bitA & bitB) | ((bitA | bitB) & carry);
            ans= sum + ans;
        }
        
        if (carry == 1) ans = carry + ans;
        return ans;
        
    }
}