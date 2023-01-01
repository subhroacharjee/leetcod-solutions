class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        
        for (int i = 0; i < pattern.length();i++ ) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch).equals(words[i])) continue;
                else return false;
            } else {
                for (char key: map.keySet()) {
                    if (map.get(key).equals(words[i])) return false;
                }
                map.put(ch, words[i]);
            }
            
        }
        
        return true;
    }
}