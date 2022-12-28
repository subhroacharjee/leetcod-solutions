class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie tr = new Trie();
        tr.addAndGetLongestPrefix(strs[0]);
        String prefix = strs[0];
        for (String str: strs) {
            String currentPrefix = tr.addAndGetLongestPrefix(str);
            prefix = currentPrefix.length() > prefix.length() ? prefix : currentPrefix ;
        }
        
        return prefix;
    }
}

class TrieNode {
    TrieNode[] ch = new TrieNode[26];
    
    public TrieNode addNode(char ch) {
        if (this.ch[ch - 'a'] == null) this.ch[ch - 'a'] = new TrieNode(); 
        return this.ch[ch - 'a'];
    }
    
    public TrieNode getNode(char ch) {
        return this.ch[ch - 'a'];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public String addAndGetLongestPrefix(String word) {
        String prefix = "";
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.getNode(word.charAt(i)) != null ) {
                prefix+=word.charAt(i);
            }
            
            node=node.addNode(word.charAt(i));
        }
       
        return prefix;
    }
}