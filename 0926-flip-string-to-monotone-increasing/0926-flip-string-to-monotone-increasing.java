class Solution {
    public int minFlipsMonoIncr(String s) {
        int flipCount = 0, countOnes = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') countOnes++;
            else if (countOnes > 0) flipCount++;
            
            flipCount = Integer.min(countOnes, flipCount);
        }
        
        return flipCount;
    }
    
}