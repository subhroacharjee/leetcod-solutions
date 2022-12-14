class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int CHARACTER_LENGTH = 26;
        int[] map1 = new int[CHARACTER_LENGTH];
        int[] map2 = new int[CHARACTER_LENGTH];
         HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        
        for (int i = 0; i< word1.length(); i++) {
            set1.add(word1.charAt(i));
            map1[word1.charAt(i)- 'a']++;
        }
        for (int i = 0; i< word2.length(); i++){
            set2.add(word2.charAt(i));
            map2[word2.charAt(i)- 'a']++;
        }
        
       if(!set1.equals(set2)) return false;
        for(int i =0; i< CHARACTER_LENGTH; i++) {
            for (int j = i+1; j< CHARACTER_LENGTH; j++){
                if (map1[i] > map1[j]) {
                    map1[i] = map1[i] + map1[j];
                    map1[j] = map1[i] - map1[j];
                    map1[i] = map1[i] - map1[j];
                }
            }
            
            for (int j = i+1; j< CHARACTER_LENGTH; j++){
                if (map2[i] > map2[j]) {
                    map2[i] = map2[i] + map2[j];
                    map2[j] = map2[i] - map2[j];
                    map2[i] = map2[i] - map2[j];
                }
            }
        }
        
        for (int i = 0; i < CHARACTER_LENGTH; i++) {
            if(map1[i] != map2[i]) return false;
        }
        
        return true;
    }
}