class Solution {
    public boolean halvesAreAlike(String s) {
        int h1 = 0;
        int h2 = 0;
        
        int ptr1 = 0;
        int ptr2 = s.length() - 1;
        String x = s.toLowerCase();
        while(ptr1 < ptr2) {
            if (isVowel(x.charAt(ptr1))){
                h1++;
            }
            
            if (isVowel(x.charAt(ptr2))){
                h2++;
            }
            ptr1++;
            ptr2--;
        }
        
        return h1 == h2;
    }
    
    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}