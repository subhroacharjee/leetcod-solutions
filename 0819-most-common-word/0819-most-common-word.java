class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            if (bannedSet.contains(word)) continue;
            String tmp = word.toLowerCase();
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        
        int freq = -1;
        String ans = "";
        for (String key: map.keySet()) {
            if (freq < map.get(key)) {
                ans = key;
                freq = map.get(key);
            }
        }
        
        return ans;
    }
}