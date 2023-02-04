class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] f1 = new int[26];
        
        for (char ch: s.toCharArray()) {
            f1[ch - 'a']++;
        }
        
        for (char ch: t.toCharArray()) {
            f1[ch - 'a']--;
        }
        
        
        for (int i : f1) {
            if (i != 0) return false;
        }
        
        return true;
    }
}