class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int MAX_LENGTH = 100001;
        int[] players = new int[MAX_LENGTH];
        for(int i = 0; i < MAX_LENGTH; i++) players[i] = -1;
        
        int max = 0;
        int min = MAX_LENGTH;
        
        for(int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            
            max = Integer.max(max, Integer.max(winner, loser));
            min = Integer.min(min, Integer.min(winner, loser));
            if (players[loser] == -1) players[loser] = 1;
            else players[loser]++;
            
            if (players[winner] == -1) players[winner] = 0;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int player = min; player <max+1; player++) {
            if (players[player] == -1) continue;
            else if (players[player] == 0) ans.get(0).add(player);
            else if (players[player] == 1) ans.get(1).add(player);
        }
        
        return ans;
    }
}