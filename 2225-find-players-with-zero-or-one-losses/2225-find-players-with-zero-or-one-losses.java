class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < matches.length; i ++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            
            if (!map.containsKey(loser)) {
                map.put(loser,1);
            } else {
                map.put(loser, map.get(loser)+1);
            }
            
            if (!map.containsKey(winner)) {
                map.put(winner, 0);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int player : map.keySet()) {
            if (map.get(player) == 0) ans.get(0).add(player);
            else if (map.get(player) == 1) ans.get(1).add(player);
        }
        
        return ans;
    }
}