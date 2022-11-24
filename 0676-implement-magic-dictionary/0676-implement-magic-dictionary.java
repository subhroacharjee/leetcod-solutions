class MagicDictionary {
    Node root;
    public MagicDictionary() {
        root = new Node();
    }
    
    private void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            node = node.setNode(word.charAt(i));
        }
        node.setEnd();
    } 
    
    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            this.insert(word);
        }
    }
    
    private boolean _search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.getNode(word.charAt(i)) == null) return false;
            node = node.getNode(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean search(String searchWord) {
        char[] arr = searchWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char oldCh = arr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == oldCh) continue;
                arr[i] = j;
                String newWord = new String(arr);
                if (this._search(newWord)) return true;
            }
            arr[i] = oldCh;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

class Node {
    Node[] arr = new Node[26];
    
    boolean end = false;
    
    public Node getNode(char ch) {
        return arr[ch - 'a'];
    }
    
    public Node setNode(char ch) {
        if (arr[ch - 'a'] == null) arr[ch - 'a'] = new Node();
        return arr[ch - 'a'];
    }
    
    public boolean isEnd() {
        return end;
    }
    
    public void setEnd() {
        end = true;
    }
}