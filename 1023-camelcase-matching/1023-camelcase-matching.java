class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        Trie tr = new Trie();
        tr.insert(pattern);
        List<Boolean> ans = new ArrayList<>();
        
        for (String q: queries) {
            ans.add(tr.check(q));
        }
        
        return ans;
    }
}

class Node{
    Node[] small = new Node[26];
    Node[] caps = new Node[26];
    boolean end = false;
    public Node addNode(char ch) {
        if (Character.isUpperCase(ch)) {
            if (caps[ch - 'A'] == null) caps[ch - 'A'] = new Node();
            return caps[ch - 'A'];
        }
        if (small[ch - 'a'] == null) small[ch - 'a'] = new Node();
        return small[ch - 'a'];
    }
    
    public Node getNode(char ch) {
        if (Character.isUpperCase(ch)) {
            return caps[ch - 'A'];
        }
        return small[ch - 'a'];
    }
    
    public boolean isEnd() {
        return end;
    }
    
    public void setEnd() {
        end = true;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String pattern) {
        Node node = root;
        for (int i = 0; i < pattern.length(); i++) {
            node = node.addNode(pattern.charAt(i));
        }
        
        node.setEnd();
    }
    
    public boolean check(String word) {
        Node node = root;
        
        for (int i = 0; i < word.length(); i++) {
            Node instance = node.getNode(word.charAt(i));
            if (Character.isUpperCase(word.charAt(i))) {
                if (instance == null) return false;
                node = instance;
            } else {
                if (instance != null) node = instance;
            }
        }
        
        return node.isEnd();
    }
}