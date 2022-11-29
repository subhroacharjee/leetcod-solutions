class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie tr = new Trie();
        for(int num: nums) {
            tr.insert(num);
        }
        
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Integer.max(tr.getMax(num), max);
        }
        
        return max;
    }
}

class Node {
    Node[] node = new Node[2];
    public Node insert(int bit) {
        if (node[bit] == null) node[bit] = new Node();
        return node[bit];
    }
    
    public Node getNode(int bit) {
        return node[bit];
    }
}

class Trie{
    Node root;
    public Trie()  {
        root = new Node();
    }
    
    public void insert(int n) {
        Node node = root;
        for(int i = 31;i >= 0; i--) {
            int bit = (n >> i) & 1;
            node = node.insert(bit);
        }
    }
    
    public int getMax(int n) {
         Node node = root;
        int max = 0;
        for(int i = 31;i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (node.getNode(1 - bit) != null) {
                node = node.getNode(1 - bit);
                max =  max | (1<<i);
                
            } else {
                node = node.getNode(bit);
            }
        }
        
        return max;
    }
}