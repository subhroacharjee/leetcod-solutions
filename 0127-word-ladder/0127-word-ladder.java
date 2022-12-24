class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, beginWord));
        int ans = 0;
        
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int distance = q.peek().length;
                String word = q.peek().word;
                q.poll();
                if(word.equals(endWord)) {
                    return distance;
                }
                
                for (int j = 0; j < word.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == word.charAt(j)) continue;
                        String newWord = word.substring(0,j) + ch + word.substring(j+1);
                        if (wordSet.contains(newWord)) {
                            q.add(new Pair(distance+1, newWord));
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            
        }
        return 0;
        
    }
    
}

class Pair {
    public int length;
    public String word;
    
    public Pair(int n, String st) {
        length = n;
        word = st;
    }
}