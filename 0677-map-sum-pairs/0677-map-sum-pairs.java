class Node {
    Node[] arr = new Node[26];
    int sum = 0;
    
    public Node setNode(char ch) {
        if (arr[ch - 'a'] == null) arr[ch - 'a'] = new Node();
        return arr[ch - 'a'];
    }
    
    public Node getNode(char ch) {
        return arr[ch - 'a'];
    }
    
    public void setSum(int i) {
        sum = i;
    }
    
    public int getSum() {
        return sum;
    }
}


class MapSum {
    Node root;
    HashMap<String, Integer> isDone;
    public MapSum() {
        root = new Node();
        isDone = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        Node node = root;
        for(int i = 0; i < key.length(); i++) {
            node = node.setNode(key.charAt(i));
            if (!isDone.containsKey(key))  node.setSum(node.getSum() + val);
            else {
                int x = node.getSum() - isDone.get(key);
                node.setSum(x+val);
            }
        }
        
        isDone.put(key, val);
    }
    
    public int sum(String prefix) {
         Node node = root;
        for(int i = 0; i < prefix.length(); i++) {
            node = node.setNode(prefix.charAt(i));
            if (node == null) return 0;
        }
        return node.getSum();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */