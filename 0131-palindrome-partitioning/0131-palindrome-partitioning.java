class Solution {
    List<List<String>> ans = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    public List<List<String>> partition(String s) {
        part(0,s,new ArrayList<>());
        return ans;
    }
    
    private void part(int index, String s, List<String> old) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(old));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String nPart = s.substring(index, i+1);
            if (!isPalindrome(nPart)) continue;
            old.add(nPart);
            part(i+1, s, old);
            old.remove(old.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        if (set.contains(s)) return true;
        
        int idxSt = 0, idxEd = s.length() -1;
        while(idxSt < idxEd && s.charAt(idxSt) == s.charAt(idxEd)) {
            idxSt ++;
            idxEd --;
        }
        if (idxSt >= idxEd) set.contains(s);
        return idxSt >= idxEd;
    }
}