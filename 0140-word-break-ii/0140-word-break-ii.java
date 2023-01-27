class Solution {
    HashMap<String, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        formString(s, "", set);
        return ans;
    }
    
    void formString(String word, String prev, HashSet<String> set) {
        if (word.length() == 0) {
            ans.add(prev);
            return;
        }
        for (int i = 1; i <=word.length(); i++) {
            String left = word.substring(0,i);
            String right = word.substring(i);
            if (set.contains(left)) {
                String newPrev = prev.length() == 0 ? left : prev + " " + left;
                formString(right, newPrev, set);
            }
        }
    }
}