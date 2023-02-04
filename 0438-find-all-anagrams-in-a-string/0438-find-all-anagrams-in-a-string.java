class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        
        for (char ch: p.toCharArray()) {
            f1[ch - 'a'] ++;
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            f2[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                f2[s.charAt(i - p.length()) - 'a']--;
            }
            
            if (Arrays.equals(f1, f2)) {
                ans.add(i-p.length() + 1);
            }
        }
        
        return ans;
    }
}