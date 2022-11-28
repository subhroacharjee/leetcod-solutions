class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        TreeSet<String>[] dict = new TreeSet[n+1];
        HashMap<String, Integer> mem = new HashMap<> ();
        
        for (String word: words) {
            if (!mem.containsKey(word)) mem.put(word, 0);
            
            int index  = mem.get(word);
            
            if(dict[index] != null) dict[index].remove(word);;
            if (dict[index+1] == null) dict[index+1] = new TreeSet<>();
            
           
            dict[index+1].add(word);
            
            mem.put(word, mem.get(word)+1);
        }
        List<String> ans = new ArrayList<>();
        int idx = 0;
        for (int i = n; i >=0 && idx < k; i--) {
            if(dict[i]== null) continue;
            Iterator<String> it = dict[i].iterator();
            while(idx < k && it.hasNext()) {
                ans.add(it.next());
                idx++;
            }
            
        }
        
        return ans;
        
    }
}