class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;

        Map<String, Boolean> cache = new HashMap<>();

        for (String word : words) {
            if (word.length() > S.length()) continue;

            if (isSubsequence(word, S, cache)) {
                ++res;
            }
        }
        return res;
    }

    public boolean isSubsequence(String word, String S, Map<String, Boolean> cache) {
        if (cache.get(word) != null) {
            return cache.get(word);
        }

        int index = -1;
        for (char c : word.toCharArray()) {
            index = S.indexOf(c, index + 1);

            if (index == -1) {
                cache.put(word, false);
                return false;
            }
        }
        cache.put(word, true);
        return true;
    }
}