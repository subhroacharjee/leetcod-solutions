class Solution {
    int getIndexFromChar(char ch) {
        switch(ch) {
            case 'U': return 0;
            case 'R': return 1;
            case 'D': return 2;
            case 'L': return 3;
        }
        return -1;
    }
    
    public boolean judgeCircle(String moves) {
        int[][] delta = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        int[] currIndex = {0,0};
        char[] movesArr = moves.toCharArray();
        for (char move: movesArr) {
            int idx = getIndexFromChar(move);
            currIndex[0] += delta[idx][0];
            currIndex[1] += delta[idx][1];
        }
        
        return currIndex[0] == 0 && currIndex[1] == 0;
    }
}