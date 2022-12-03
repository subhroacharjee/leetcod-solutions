class Solution {
    public String frequencySort(String s) {
        Queue<Pair> pq = new PriorityQueue<>(100, new PairComparator());
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        
       for (char key : map.keySet()) {
           pq.add(new Pair(key, map.get(key)));
       }
        String ans = "";
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            for(int i = 0; i < p.frequency; i++) {
                ans+=p.ch;
            }
        }
        
        return ans;
        
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
                return o2.frequency - o1.frequency;
    }
}

class Pair {
    public int frequency = 0;
    public char ch;
    
    public Pair(char ch, int freq) {
        this.ch = ch;
        frequency = freq;
    }
}