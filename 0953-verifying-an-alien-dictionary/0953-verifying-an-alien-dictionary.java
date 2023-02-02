class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length -1;i++) {
            String w1 = words[i], w2 = words[i+1];
            
            
            for (int j = 0; j < w1.length(); j++) {
                // checking if w2 is prefix of w1 or not
                if (j == w2.length()) return false;
                
                char a = w1.charAt(j);
                char b = w2.charAt(j);
                if (map.get(a) < map.get(b)) break;
                if (map.get(a) > map.get(b)) return false;
            }
            
            
        }
        
        return true;
    }
}