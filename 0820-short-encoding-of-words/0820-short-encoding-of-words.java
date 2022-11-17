class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> wordsNotToBeAdded = new HashSet<>();
        Trie tr = new Trie();
        List<String> goodWords = new ArrayList<>();
        
        for (String word: words) {
            if (!wordsNotToBeAdded.contains(word)) {
                goodWords.add(word);
                wordsNotToBeAdded.add(word);
            }
        }
        
        wordsNotToBeAdded.clear();
        
        for (String word: goodWords) {
            tr.insert(word, wordsNotToBeAdded);
        }
        int lengthOfHash = 0;
        for (String word: goodWords) {
            if (!wordsNotToBeAdded.contains(word)) lengthOfHash += word.length() + 1;
        }
        
        return lengthOfHash;
    }
}

class Node {
    Node[] arr = new Node[26];
    String word = null;
    boolean end = false;
    
    public Node getNode(char ch) {
        return arr[ch - 'a'];
    }
    
    public Node setNode(char ch) {
        int index = ch - 'a';
        if (arr[index] == null) arr[index] = new Node();
        return arr[index];
    }
    
    public boolean getEnd() {
        return end;
    }
    
    public void setEnd(boolean end) {
        this.end = end;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
}

class Trie {
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word, HashSet<String> wordsNotToBeAdded) {
        Node node = root;
        boolean contains = false;
        int n = word.length() - 1;
        for (int i = n; i >= 0; i--) {
            char ch = word.charAt(i);
            Node tmp = node.getNode(ch);
            if (tmp != null && tmp.getEnd()) {
                wordsNotToBeAdded.add(tmp.getWord());
                tmp.setEnd(false);
            }
            
            if (tmp != null) contains=true;
            else contains = false;
           node = node.setNode(ch);
        }
        
        if (!contains) {
            node.setEnd(true);
            node.setWord(word);
        } else {
            wordsNotToBeAdded.add(word);
        }
        
    }
}