class Solution {
    HashSet<String> cache = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans =  new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        
        for (String word: words) {
            if (canForm(word, set)) {
                ans.add(word);
            }
        }
        
        return ans;
    }
    
    boolean canForm(String word, HashSet<String> set) {
        if (cache.contains(word)) {
            return true;
        }
        
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0,i);
            String right = word.substring(i);
            if (set.contains(left)) {
                if (set.contains(right) || canForm(right, set)) {
                    cache.add(word);
                    return true;
                }
            }
        }
        return false;
    }
}